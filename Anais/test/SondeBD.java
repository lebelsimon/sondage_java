import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author dmartin
 * 
 */
public class SondeBD {
	private ConnexionMySQL c;
	private Statement s;

	// constructeur
	public SondeBD(ConnexionMySQL c) throws SQLException {
		// on crée un nouveau UtilisateurBD
		try {
			this.c = c;
			Connection conn = c.getConnexion();
			this.s = conn.createStatement();
			System.out.println("SondeBD créé");
		} catch (SQLException e) {
			System.out.println("SondeBD non créé");
		}
	}

	public ArrayList<Sonde> getListeSonde() {
		ArrayList<Sonde> res = new ArrayList<Sonde>();
		try {
			ResultSet rs = s
					.executeQuery("SELECT * FROM SONDE NATURAL JOIN INTERROGER NATURAL JOIN UTILISATEUR WHERE idR=2");
			while (rs.next()) {
				Sonde s = new Sonde(rs.getInt("numSond"),
						rs.getString("nomSond"), rs.getString("prenomSond"),
						rs.getInt("dateNaisSond"),
						rs.getString("telephoneSond"), rs.getString("idC"));
				s.addQuestionnaire(rs.getInt("idQ"));
				res.add(s);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return res;
	}

	public void supprimerSonde(int numSonde) {
		try {
			s.executeUpdate("DELETE FROM INTERROGER WHERE numSond=" + numSonde);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
