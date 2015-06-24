import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * @author Damien MARTIN
 */

public class ClientBD{
    private ConnexionMySQL c;
    private Statement s;
    
    // constructeur
    public ClientBD(ConnexionMySQL c) throws SQLException{
	// on crée un nouveau clientBD
	try{
	    this.c=c;
	    Connection conn = c.getConnexion();
	    this.s = conn.createStatement();
	    System.out.println("clientBD créé");
	}
	catch(SQLException e){
	    System.out.println("clientBD non créé");
	}
    }

    //méthodes
    public int maxNumClient() throws SQLException{
	// on crée un ResultSet pour récupérer les résultats de la requête
	ResultSet rs = s.executeQuery("SELECT MAX(NumC) FROM CLIENT");
	rs.next();
	return rs.getInt("MAX(NumC)");
    }

    public void insererClient(Client c) throws SQLException{
	s.executeUpdate("INSERT INTO CLIENT VALUES ("+
			(this.maxNumClient()+1)+",'"+
			c.getRaisonSociale()+"','"+
			c.getAdresse1()+"','"+
			c.getAdresse2()+"',"+
			c.getCodePostal()+",'"+
			c.getVille()+"','"+
			c.getTelephone()+"','"+
			c.getEmail()+"')");
    }

    public void effacerClient(int num) throws SQLException{
	s.executeUpdate("DELETE FROM CLIENT WHERE numC="+num);
    }

    public void majClient(Client c) throws SQLException{
	s.executeUpdate("UPDATE CLIENT SET numC="+c.getNumero()+
			", raisonSoc='"+c.getRaisonSociale()+
			"', adresse1='"+c.getAdresse1()+
			"',adresse2='"+c.getAdresse2()+
			"',CodePostal="+c.getCodePostal()+
			",Ville='"+c.getVille()+
			"',Telephone='"+c.getTelephone()+
			"',email='"+c.getEmail()+"')");
    }

    public Client rechercherClientParNum(int num) throws SQLException{
	ResultSet rs = s.executeQuery("SELECT * FROM CLIENT");
	Client res = null;
	try{
	    while(rs.next()){
		if(rs.getInt("numC")==num)
		    res=new Client(num, 
				   rs.getString("raisonSoc"), 
				   rs.getString("adresse1"), 
				   rs.getString("adresse2"), 
				   rs.getInt("CodePostal"), 
				   rs.getString("Ville"), 
				   rs.getString("Telephone"), 
				   rs.getString("email"));
	    }
	}
	catch(SQLException e){
	    System.out.println("client non trouvé");
	}
	return res;
    }
    
    public void affiche(int num) throws SQLException{
    	Client c = this.rechercherClientParNum(num);
    	c.affiche();
    }

    public void listeQuestionnaire(){
	int clientCourant=0;
	boolean premier=true;
	try{
	    ResultSet rs = s.executeQuery("SELECT  numC, raisonSoc, adresse1, adresse2, CodePostal, Ville, titre FROM CLIENT NATURAL JOIN QUESTIONNAIRE ORDER BY numC, Titre");
	    int cpt=1;
	    while(rs.next()){
		if(clientCourant!=rs.getInt("numC")){
		    clientCourant=rs.getInt("numC");
		    // on regarde si on doit afficher le total en premier
		    if(!premier){System.out.println("Total : "+cpt);}
		    premier=false;
		    cpt=1;
		    // on commence l'affichage
		    System.out.println("------------------------------------------------");
		    System.out.println("num : "+rs.getInt("numC")+"\n"+rs.getString("raisonSoc")+"\n"+rs.getString("adresse1"));
		    // on test s'il y a une deuxième adresse
		    if(rs.getString("adresse2")!=null)
			System.out.println(rs.getString("adresse2"));
		    System.out.println(rs.getInt("CodePostal")+"\n");
		    // on test si le client a un questionnaire
		    if(rs.getString("Titre")!=null){
			System.out.println("liste des questionnaires : ");
			System.out.println("    "+rs.getString("Titre"));
		    }
		    else{
			System.out.println("Pas de questionnaire attribué");
		    }
		
		}
		else {
		    System.out.println("    "+rs.getString("Titre"));
		    cpt++;
		}
	    }
	    System.out.println("Total : "+cpt);
	}
	catch(SQLException e){
	    System.out.println("erreur affichage liste "+e);
	}
    }
    
    public HashMap<Integer, String> getListeClient(){
    	HashMap<Integer, String> listeClient = new HashMap<Integer, String>();
    	try{
    		ResultSet rs = s.executeQuery("SELECT * FROM CLIENT");
    		while(rs.next()){
    			listeClient.put(rs.getInt("numC"), rs.getString("raisonSoc"));
    		}
    	}
    	catch(SQLException e){System.out.println(e);}
    	return listeClient;
    }
    
    public HashMap<Integer, String> getListePanel(){
    	HashMap<Integer, String> listePanel = new HashMap<Integer, String>();
    	try{
    		ResultSet rs = s.executeQuery("SELECT * FROM PANEL");
    		while(rs.next()){
    			listePanel.put(rs.getInt("idPan"), rs.getString("nomPan"));
    		}
    	}
    	catch(SQLException e){System.out.println(e);}
    	return listePanel;
    }
    
}
