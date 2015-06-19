import java.sql.*;
import java.util.ArrayList;

/**
 * @author Damien MARTIN
 */

public class ReponsesBD{
    private ConnexionMySQL c;
    private Statement s;
    
    // constructeur
    public ReponsesBD(ConnexionMySQL c) throws SQLException{
	// on crée un nouveau clientBD
	try{
	    this.c=c;
	    Connection conn = c.getConnexion();
	    this.s = conn.createStatement();
	    System.out.println("reponsesBD créé");
	}
	catch(SQLException e){
	    System.out.println("reponsesBD non créé");
	}
    }

    //méthodes
    /**
     * @param numQuestionnaire un entier représentant le numéro du questionnaire
     * @param numQuestion numéro de la question à choix libre du questionnaire
     */
    public void nbReponsesLibreParCat(int numQuestionnaire, int numQuestion){
	try{
	    ResultSet rs = s.executeQuery("SELECT texteQ, intituleCat, valeur, COUNT(valeur) FROM QUESTION NATURAL JOIN REPONDRE NATURAL JOIN CARACTERISTIQUE NATURAL JOIN CATEGORIE WHERE numQ="+numQuestion+" AND idQ="+numQuestionnaire+" GROUP BY valeur, intituleCat ORDER BY intituleCat, valeur");
	    rs.next();
	    System.out.println("Analyse des réponses à la question :\n");
	    System.out.println(rs.getString("texteQ"));
	    String cat="";
	    Integer cpt=0;
	    while (rs.next()){
		if(cat.equals("")){
		    cat=rs.getString("intituleCat");
		}
		else{
		    if(rs.getString("intituleCat").equals(cat)){
			System.out.println("          "+rs.getString("valeur")+ " " +rs.getInt("COUNT(valeur)"));
			cpt+=rs.getInt("COUNT(valeur)");
		    }
		    else{
			System.out.println("Total : "+cpt+"\n");
			System.out.println("Réponses pour la catégorie "+rs.getString("intituleCat"));
			cat=rs.getString("intituleCat");
			System.out.println("          "+rs.getString("valeur")+ " " +rs.getInt("COUNT(valeur)"));
			cpt=rs.getInt("COUNT(valeur)");
		    }
		}
	    }
	    System.out.println("Total réponses : "+cpt);
	}
	catch(SQLException e){
	    System.out.println("Voici mon erreur"+e);
	}
    }

    /**
     * @param numQuestionnaire un entier correspondant au numéro de questionnaire
     * @param numQuestion un entier égal au numéro de la question de type notation
     */
    public void moyenneReponseParTrancheAgeEtHF(int numQuestionnaire, int numQuestion){
	// SELECT texteQ, idTr, valDebut, valFin, sexe, AVG(valeur)
	// FROM QUESTION NATURAL JOIN REPONDRE NATURAL JOIN CARACTERISTIQUE NATURAL JOIN TRANCHE
	// WHERE numQ=numQuestion
	// AND idQ=numQuestionnaire
	// GROUP BY sexe, idTr
	// ORDER BY idTr, sexe
	try{
	    ResultSet rs = s.executeQuery("SELECT texteQ, idTr, valDebut, valFin, sexe, AVG(valeur) FROM QUESTION NATURAL JOIN REPONDRE NATURAL JOIN CARACTERISTIQUE NATURAL JOIN TRANCHE WHERE numQ="+numQuestion+" AND idQ="+numQuestionnaire+" GROUP BY sexe, idTr ORDER BY idTr, sexe");
	    rs.next();
	    System.out.println("Analyse des réponses à la question");
	    System.out.println(rs.getString("texteQ"));
	    String tranche="";
	    double total=0;
	    // while(rs.next()){
	    // 	if (tranche.equals(""))
	    // 	    tranche=rs.getString("idTr");
	    // 	else{
	    // 	    if(rs.getString("idTr").equals(tranche)){
	    // 		System.out.println("     moyenne pour "+rs.getString("sexe")+"     "+rs.getDouble("AVG(valeur)"));
	    // 		total+=rs.getDouble("AVG(valeur)");
	    // 	    }
	    // 	    else{
	    // 		System.out.println("moyenne pour la tranche "+rs.getString("valDebut")+" - "+rs.getString("valFin")+" ans : "+total/2);
	    // 		System.out.println("Résultat pour la tranche "+rs.getString("valDebut")+" - "+rs.getString("valFin")+" :");
	    // 		total=rs.getDouble("AVG(valeur)");
	    // 	    }
	    // 	}
	    // 	tranche=rs.getString("idTr");
	    // }
	    while(rs.next()){
		tranche=rs.getString("idTr");
		System.out.println("Résultat pour la tranche "+rs.getString("valDebut")+" - "+rs.getString("valFin")+" ans : ");
		if(rs.getString("idTr").equals(tranche)){
		    System.out.println("    moyenne pour "+rs.getString("sexe")+"    "+rs.getDouble("AVG(valeur)"));
		    total+=rs.getDouble("AVG(valeur)");
		}
		else{
		    tranche=rs.getString("idTr");
		}
		//System.out.println("moyenne pour la tranche "+rs.getString("valDebut")+" - "+rs.getString("valFin")+" ans : "+total/2);
	    }
	}
	catch(SQLException e){
	    System.out.println("erreur requète : "+e);
	}
    }
}
