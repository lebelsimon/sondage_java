import java.sql.*;
import java.util.ArrayList;

/**
 * @author Damien MARTIN
 */

public class QuestionnaireBD{
	private ConnexionMySQL c;
	private Statement s, s2;
	private QuestionBD qBD;

	// constructeur
	public QuestionnaireBD(ConnexionMySQL c) throws SQLException {
		// on crée un nouveau clientBD
		try {
			this.c = c;
			Connection conn = c.getConnexion();
			this.s = conn.createStatement();
			this.s2 = conn.createStatement();
			this.qBD=new QuestionBD(c);
			System.out.println("questionnaireBD créé");
		} 
		catch (SQLException e) {
			System.out.println("questionnaireBD non créé");
		}
	}
	
	public ArrayList<Questionnaire> getListeQuestionnaire(int idU, String role){
		ArrayList<Questionnaire> listeQuestionnaire = new ArrayList<Questionnaire>();
		ArrayList<Question> listeQuestion = new ArrayList<Question>();
		try{
			ResultSet rs = s.executeQuery("SELECT * FROM QUESTIONNAIRE NATURAL JOIN QUESTION WHERE idU="+idU+" AND Etat='"+role.charAt(0)+"'");
			int idQcourant=-1;
			while(rs.next()){
				// si c'est le même questionnaire
				if(rs.getInt("idQ")==idQcourant){
					// on crée une nouvelle question et on lui ajoute la liste des propositions
					Question question = new Question(rs.getString("texteQ"), rs.getString("idT").charAt(0), rs.getInt("maxVal"), rs.getInt("numQ"));
					question.setPropositions(qBD.getListePropositionPourUneQuestion(rs.getInt("idQ"), rs.getInt("numQ")));
					listeQuestion.add(question);
				}
				// sinon c'est un nouveau questionnaire
				else{
					// on crée une nouvelle liste de question
					listeQuestion = new ArrayList<Question>();
					// on crée un nouveau questionnaire
					Questionnaire q = new Questionnaire(rs.getString("Titre"), rs.getInt("numC"), rs.getInt("idU"), rs.getInt("idPan"), rs.getString("etat").charAt(0));
					q.setIdQ(rs.getInt("idQ"));
					idQcourant=rs.getInt("idQ");
					// on crée une nouvelle question
					Question question = new Question(rs.getString("texteQ"), rs.getString("idT").charAt(0), rs.getInt("maxVal"), rs.getInt("numQ"));
					// on ajoute les propositions de la question
					question.setPropositions(qBD.getListePropositionPourUneQuestion(rs.getInt("idQ"), rs.getInt("numQ")));
					// on ajoute la question à la liste
					listeQuestion.add(question);
					q.setListeQuestions(listeQuestion);
					listeQuestionnaire.add(q);
					
				}
			}
			// on récpère les questionnaires qui ne sont pas associés à des questions.
			ResultSet rs2 = s2.executeQuery("SELECT * FROM QUESTIONNAIRE WHERE Titre NOT IN(SELECT Titre FROM QUESTIONNAIRE NATURAL JOIN QUESTION) AND idU="+idU+" AND Etat='"+role.charAt(0)+"'");
			while(rs2.next()){
				Questionnaire q = new Questionnaire(rs2.getString("Titre"), rs2.getInt("numC"),  rs2.getInt("idU"),  rs2.getInt("idPan"),  rs2.getString("etat").charAt(0));
				q.setListeQuestions(new ArrayList<Question>());
				listeQuestionnaire.add(q);
			}
		}
		catch(SQLException e) { System.out.println(e); }
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
	
	public void supprimerQuestionnaire(int idQ){
		try{
			s.executeUpdate("DELETE FROM QUESTIONNAIRE WHERE idQ="+idQ);
		}
		catch(SQLException e){ System.out.println(e);}
	}
	
	public void modifierQuestionnaire(Questionnaire q){
		try{
			s.executeUpdate("UPDATE QUESTIONNAIRE SET Titre='"+q.getTitreQuestionnaire()+"', etat='"+q.getEtat()+"', numC="+q.getNumC()+", idU="+q.getIdU()+", idPan="+q.getIdPan()+" WHERE idQ="+q.getIdQ());
		}
		catch(SQLException e){System.out.println(e);}
	}
	
	public Questionnaire creerQuestionnaire(int idQ){
		Questionnaire res=null;
		ArrayList<Question> listeQuestion=new ArrayList<Question>();
		try{
			String titreQuestionnaire="";
			ResultSet rs = s.executeQuery("SELECT * FROM QUESTIONNAIRE WHERE idQ="+idQ);
			while(rs.next()){
				titreQuestionnaire=rs.getString("Titre");
				res=new Questionnaire(titreQuestionnaire, rs.getInt("numC"),  rs.getInt("idU"),  rs.getInt("idPan"), rs.getString("etat").charAt(0));
			}
			ResultSet rs2 = s2.executeQuery("SELECT * FROM QUESTIONNAIRE NATURAL JOIN QUESTION WHERE idQ="+idQ);
			if(rs2.absolute(1)){
				while(rs2.next()){
					listeQuestion.add(new Question(rs2.getString("texteQ"), rs2.getString("idT").charAt(0), rs2.getInt("maxVal"), rs2.getInt("numQ")));
				}
			}
			res.setListeQuestions(listeQuestion);
		}
		catch(SQLException e){ System.out.println(e); }
		return res;
	}
	
	public ArrayList<Questionnaire> getListeQuestionnaireSonde(int numSond, int idU, String role){
		ArrayList<Questionnaire> listeQuestionnaire = new ArrayList<Questionnaire>();
		try{
			ResultSet rs = s.executeQuery("SELECT * FROM QUESTIONNAIRE q, INTERROGER i WHERE q.idQ=i.idQ AND numSond="+numSond+" AND idU="+idU+" AND Etat="+role.charAt(0));
			while(rs.next()){
				listeQuestionnaire.add(this.creerQuestionnaire(rs.getInt("idQ")));
			}
		}
		catch(SQLException e){System.out.println(e);}
		return listeQuestionnaire;
	}
}