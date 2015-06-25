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
//getter
	public ArrayList<Sonde> getListeSonde(int idU) {
		ArrayList<Sonde> res = new ArrayList<Sonde>();
		try {
			ResultSet rs = s.executeQuery("SELECT * FROM SONDE NATURAL JOIN INTERROGER NATURAL JOIN UTILISATEUR WHERE idR=2 AND idU="+idU);
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
	
	public ArrayList<Integer> getListeQuestionnairePourUnSonde(int numSond, int idU){
		ArrayList<Sonde> listeSonde = this.getListeSonde(idU);
		for (Sonde sond : listeSonde) {
			if (sond.getNumSond() == numSond){
				return sond.getListeQuestionnaire();
			}
		}
		return new ArrayList<Integer>();
	}

}
