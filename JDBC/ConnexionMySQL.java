import java.sql.*;

/**
 * @author Damien MARTIN
 */

public class ConnexionMySQL{
    // attributs
    public Connection mysql;
    boolean ouverte;

    // constructeur
    public ConnexionMySQL(String nom_serveur, String nom_base, String login, String repertoire_principal){
	try{
	    Class.forName("com.mysql.jdbc.Driver");
	}
	catch (Exception ex){
	    System.out.println("classe non trouvé");
	}
	try{
	    mysql = DriverManager.getConnection(nom_serveur+nom_base, login, "dmartin");
	    ouverte=true;
	}
	catch (SQLException ex){
	    System.out.println("Msg:"+ex.getMessage()+ex.getErrorCode());
	}
    }

    public void reconnexion(String nom_serveur, String nom_base, String login, String repertoire_principal){
	try{
	    mysql = DriverManager.getConnection(nom_serveur, login, "dmartin");
	}
	catch (SQLException ex){
	    System.out.println("Msg:"+ex.getMessage()+ex.getErrorCode());
	}
    }
    
    public boolean estConnecte(){
	return ouverte;
    }
	
    public void deconnexion(){
	try{
	    mysql.close();
	    ouverte=false;
	    System.out.println("déconnexion réussie");
	}
	catch(SQLException e){
	    System.out.println("pb de déconnexion");
	}
    }

    public void reconnexion(String loginMySQL, String mdp){
	try{
	    mysql = DriverManager.getConnection("jdbc:mysql://servinfo-db:3306/"+loginMySQL,loginMySQL, "dmartin");
	}
	catch(SQLException e){
	    System.out.println("Connection Failed");
	    e.printStackTrace();
	    return;
	}
	ouverte = true;
	System.out.println("connexion réussie");
    }

    public Connection getConnexion(){
	return mysql;
    }
}
