import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
	private Statement s;

	// constructeur
	public QuestionBD(ConnexionMySQL c) throws SQLException {
		// on crée un nouveau clientBD
		try {
			this.c = c;
			Connection conn = c.getConnexion();
			this.s = conn.createStatement();
			System.out.println("questionBD créé");
		} catch (SQLException e) {
			System.out.println("questionBD non créé");
		}
	}
	
	public ArrayList<Question> getListeQuestion(int idQ){
		ArrayList<Question> listeQuestion = new ArrayList<Question>();
		try{
			ResultSet rs = s.executeQuery("SELECT * FROM QUESTION NATURAL JOIN VALPOSSIBLE")
		}
		return listeQuestion;
	}
}