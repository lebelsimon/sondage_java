import java.sql.*;

/**
 * 
 */

/**
 * @author dmartin
 *
 */
public class UtilisateurBD {
	private ConnexionMySQL c;
    private Statement s;
    
 // constructeur
    public UtilisateurBD(ConnexionMySQL c) throws SQLException{
	// on crée un nouveau UtilisateurBD
		try{
		    this.c=c;
		    Connection conn = c.getConnexion();
		    this.s = conn.createStatement();
		    System.out.println("UtilisateurBD créé");
		}
		catch(SQLException e){
		    System.out.println("UtilisateurBD non créé");
		}
    }
    
    public Utilisateur connexionUtilisateur(String login, String mdp){
		Utilisateur u=null;
    	try{
    		ResultSet rs = s.executeQuery("SELECT * FROM UTILISATEUR NATURAL JOIN ROLEUTIL");
    		String message="";
    		while(rs.next()){
    			if(rs.getString("login").equals(login) && rs.getString("motDePasse").equals(mdp)){
    				message="connexion réussie";
    				u=new Utilisateur(rs.getInt("idU"),rs.getString("nomU"),rs.getString("prenomU"),rs.getString("login"), rs.getString("motDePasse"), rs.getString("nomR"));
    				break;
    			}
    			else{
    				message="identifiant invalide";
    			}
    		}
    		System.out.println(message);
    	}
    	catch(SQLException e){
    		System.out.println("Erreur requète : "+e);
    	}
    	return u;
    }
}
