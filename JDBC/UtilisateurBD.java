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
    
    public boolean ConnexionUtilisateur(String login, String mdp){
    	try{
    		ResultSet rs = s.executeQuery("SELECT * FROM UTILISATEUR");
    		String message="";
    		while(rs.next()){
    			if(rs.getString("login").equals(login) && rs.getString("motDePasse").equals(mdp)){
    				System.out.println("connexion réussie");
    				return true;
    			}
    			else if(rs.getString("login").equals(login) && !(rs.getString("motDePasse").equals(mdp))){
    				System.out.println("mauvais mot de passe, veuillez réessayer");
    				return false;
    			}
    			else{
    				message="mauvais login";
    			}
    		}
    		System.out.println(message);
    	}
    	catch(SQLException e){
    		System.out.println("Erreur requète : "+e);
    	}
    	return false;
    }
}
