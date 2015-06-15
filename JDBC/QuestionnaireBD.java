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
					Questionnaire q = new Questionnaire(rs.getString("Titre"));
					q.setListeQuestions(listeQuestion);
					listeQuestionnaire.add(q);
				}
			}
		}
		catch(SQLException e){System.out.println(e);}
		return listeQuestionnaire;
	}

}