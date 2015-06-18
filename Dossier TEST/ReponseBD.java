import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author dmartin
 *
 */
public class ReponseBD{
	private ConnexionMySQL c;
	private Statement s, s2;

	// constructeur
	public ReponseBD(ConnexionMySQL c) throws SQLException {
		// on crée un nouveau clientBD
		try {
			this.c = c;
			Connection conn = c.getConnexion();
			this.s = conn.createStatement();
			this.s2 = conn.createStatement();
			System.out.println("réponseBD créé");
		} 
		catch (SQLException e) {
			System.out.println("reponseBD non créé");
		}
	}
}