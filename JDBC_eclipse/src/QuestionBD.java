import java.sql.*;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author dmartin
 * 
 */
public class QuestionBD {
	private ConnexionMySQL c;
	private Statement s, s2;

	// constructeur
	public QuestionBD(ConnexionMySQL c) throws SQLException {
		// on crée un nouveau clientBD
		try {
			this.c = c;
			Connection conn = c.getConnexion();
			this.s = conn.createStatement();
			this.s2 = conn.createStatement();
			System.out.println("questionBD créé");
		} catch (SQLException e) {
			System.out.println("questionBD non créé");
		}
	}

	public ArrayList<Question> getListeQuestion(int idQ) {
		ArrayList<Question> listeQuestion = new ArrayList<Question>();
		try {
			ResultSet rs = s.executeQuery("SELECT * FROM QUESTION WHERE idQ="+ idQ); // on récupère tout les questions
			ResultSet rs2 = s2.executeQuery("SELECT * FROM QUESTION NATURAL JOIN VALPOSSIBLE WHERE idQ="+ idQ); // on récupère les valerus possibles pour
									// les questions où l'on retrouve des
									// valeurs possibles
			while (rs.next()) {
				Question q = new Question(rs.getString("texteQ"), rs.getString("idT").charAt(0), rs.getInt("MaxVal"),rs.getInt("numQ"));
				rs2 = s2.executeQuery("SELECT * FROM QUESTION NATURAL JOIN VALPOSSIBLE WHERE idQ="+ idQ);
				while (rs2.next()) {
					if (rs2.getInt("numQ") == rs.getInt("numQ")) {
						q.addProposition(new Proposition(rs2.getString("Valeur")));
					}
				}
				listeQuestion.add(q);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return listeQuestion;
	}
	
	public void addQuestion(int idQ, Question q){
		try{
			s.executeUpdate("INSERT INTO QUESTION VALUES ("+idQ+", "+q.getNumQ()+", '"+q.getTexteQuestion()+"', "+q.getMaxVal()+", '"+q.idT+"'");
			if(q.getPropositions().size()!=0){
				for(int i=0; i<q.getPropositions().size(); i++){
					s.executeUpdate("INSERT INTO VALPOSSIBLE VALUES ("+idQ+", "+q.getNumQ()+", "+(1+i)+", "+q.getPropositions().get(i).getTexte());					
				}
			}
		}
		catch(SQLException e){ System.out.println(e); }
	}
	
	public void modifieQuestion(int idQ, Question q){
		try{
			s.executeUpdate("UPDATE QUESTION SET numQ="+q.getNumQ()+", texteQ="+q.getTexteQuestion()+", idT="+q.getIdT());
		}
		catch(SQLException e){ System.out.println(e); }
	}
}
