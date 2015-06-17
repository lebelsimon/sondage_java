import java.sql.*;
import java.util.ArrayList;

/**
 * @author Damien MARTIN
 */

public class QuestionnaireBD{
	private ConnexionMySQL c;
	private Statement s;

	// constructeur
	public QuestionnaireBD(ConnexionMySQL c) throws SQLException {
		// on crée un nouveau clientBD
		try {
			this.c = c;
			Connection conn = c.getConnexion();
			this.s = conn.createStatement();
			System.out.println("questionnaireBD créé");
		} 
		catch (SQLException e) {
			System.out.println("questionnaireBD non créé");
		}
	}
	
	public ArrayList<Questionnaire> getListeQuestionnaire(){
		ArrayList<Questionnaire> listeQuestionnaire = new ArrayList<Questionnaire>();
		try{
			ResultSet rs = s.executeQuery("SELECT * FROM QUESTIONNAIRE NATURAL JOIN QUESTION");
			int questionnaireCourant=-1;
			while(rs.next()){
				ArrayList<Question> listeQuestion = new ArrayList<Question>();
				if(questionnaireCourant==rs.getInt("idQ")){
					listeQuestion.add(new Question(rs.getString("texteQ")));
				}
				else{
					Questionnaire q = new Questionnaire(rs.getString("Titre"), rs.getInt("numC"), rs.getInt("idU"), rs.getInt("idPan"), rs.getString("etat").charAt(0));
					q.setIdQ(rs.getInt("idQ"));
					q.setListeQuestions(listeQuestion);
					listeQuestionnaire.add(q);
				}
			}
		}
		catch(SQLException e){System.out.println(e);}
		return listeQuestionnaire;
	}

	public void ajouterQuestionnaire(Questionnaire q){
		try{
			s.executeUpdate("INSERT INTO QUESTIONNAIRE VALUES ("+this.getMaxIdQ()+", '"+q.getTitreQuestionnaire()+"', 'C', "+ q.getNumC()+", "+q.getIdU()+", "+q.getIdPan()+")");
		}
		catch(SQLException e){ System.out.println(e); }
	}
	
	private int getMaxIdQ(){
		try{
			ResultSet rs = s.executeQuery("SELECT MAX(idQ) FROM QUESTIONNAIRE");
			rs.next();
			return rs.getInt("MAX(idQ)")+1;
		}
		catch(SQLException e){System.out.println(e);}
	return 1;
	}
	
	public void supprimerQuestionnaire(int idQ){ // problème
		try{
			s.executeUpdate("DELETE FROM QUESTIONNAIRE WHERE idQ="+idQ);
		}
		catch(SQLException e){ System.out.println(e);}
	}
	
	public void modifierQuestionnaire(Questionnaire q){ // problème
		try{
			s.executeUpdate("UPDATE QUESTIONNAIRE SET Titre='"+q.getTitreQuestionnaire()+"' etat='"+q.getEtat()+"', numC="+q.getNumC()+", idU="+q.getIdU()+", idPan="+q.getIdPan()+" WHERE idQ="+q.getIdQ());
		}
		catch(SQLException e){System.out.println(e);}
	}
}