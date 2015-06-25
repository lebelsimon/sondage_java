import java.sql.*;
import java.util.HashMap;

import javax.swing.DefaultListModel;

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
	private QuestionBD quest;

	// constructeur
	public ReponseBD(ConnexionMySQL c) throws SQLException {
		try {
			this.c = c;
			Connection conn = c.getConnexion();
			this.s = conn.createStatement();
			this.s2 = conn.createStatement();
			this.quest = new QuestionBD(c);
			System.out.println("réponseBD créé");
		} 
		catch (SQLException e) {
			System.out.println("reponseBD non créé");
		}
	}
	
	/**
	 * Permet de récupérer les données groupé par age d'une question dans un questionnaire donné
	 */
	public String[][] getReponsesParAge(int idQ, int numQ, char type){
		String[][] tabReponses=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		int nbTranche=0;
		try{
			rs = s.executeQuery("SELECT valDebut, valFin, valeur, COUNT(idTr), maxVal, idTr FROM CARACTERISTIQUE NATURAL JOIN REPONDRE NATURAL JOIN TRANCHE NATURAL JOIN QUESTION WHERE idQ="+idQ+" AND numQ="+numQ+" GROUP BY idTr, valeur");
			rs2 = s2.executeQuery("SELECT COUNT(*) FROM TRANCHE");
			rs2.next();
			nbTranche=rs2.getInt("COUNT(*)");
			rs2.close();
		}
		catch(SQLException e){System.out.println(e);}
		switch(type){
		case 'n':
			// SELECT idTr, valdebut, valfin, valeur, idT, COUNT(idTr), maxVal 
			// FROM CARACTERISTIQUE NATURAL JOIN REPONDRE NATURAL JOIN TRANCHE NATURAL JOIN QUESTION 
			// WHERE IDQ=idQ AND NUMQ=numQ GROUP BY idTr, valeur;

			try{
				// on récupère les données
				rs.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[rs.getInt("maxVal")+1+1][nbTranche+1]; // on doit mettre +1 à maxVal car il y a 11 valeurs entre 0 et 10 compris
				tabReponses[rs.getInt("valeur")][rs.getInt("idTr")-1]=rs.getString("COUNT(idTr)");
				while(rs.next()){
					tabReponses[rs.getInt("valeur")][rs.getInt("idTr")-1]=rs.getString("COUNT(idTr)");
				}
				break;
			}
			catch(SQLException e){System.out.println(e);}
			break;
		case 'c':
			try{
				rs2 = s2.executeQuery("SELECT COUNT(*) FROM VALPOSSIBLE WHERE numQ="+numQ);
				rs.next();
				rs2.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[rs2.getInt("COUNT(*)")*3+ 1][nbTranche + 1];
				// on insère la première valeur
				String[] tabValStr = rs.getString("valeur").split("; "); // on split le string que l'on a dans la base de donnees
				int valeur=0;
				for(int i=0; i<tabValStr.length; i++){
					try{
						valeur=Integer.parseInt(tabReponses[Integer.parseInt(tabValStr[i])-1 + rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1])+1;
					}
					catch(NumberFormatException e){}
					tabReponses[Integer.parseInt(tabValStr[i])-1 + rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1] = Integer.toString(valeur); //faire rs2.getInt("COUNT(*)")*i permet de rentrer les couleurs qui sont rentrées dans l'ordre
				}
				// on insère les autres valeurs
				while(rs.next()){
					tabValStr = rs.getString("valeur").split("; ");
					for(int i=0; i<tabValStr.length; i++){
						try{
							valeur=Integer.parseInt(tabReponses[Integer.parseInt(tabValStr[i])-1 + rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1])+1;
						}
						catch(NumberFormatException e){}
						tabReponses[Integer.parseInt(tabValStr[i])-1 + rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1] = Integer.toString(valeur);
					}
				}
			}
			catch(SQLException e){System.out.println(e);}
			break;
		case 'm':
			try{
				rs2 = s2.executeQuery("SELECT COUNT(*) FROM VALPOSSIBLE WHERE numQ="+numQ);
				rs.next();
				rs2.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[rs2.getInt("COUNT(*)")+ 1][nbTranche + 1];
				// on insère la première valeur
				String[] tabValStr = rs.getString("valeur").split("; "); // on split le string que l'on a dans la base de donnees
				int valeur=0;
				for(int i=0; i<tabValStr.length; i++){
					try{
						valeur=Integer.parseInt(tabReponses[Integer.parseInt(tabValStr[i])-1][rs.getInt("idTr")-1])+1;
					}
					catch(NumberFormatException e){}
					tabReponses[Integer.parseInt(tabValStr[i])-1][rs.getInt("idTr")-1] = Integer.toString(valeur); //faire rs2.getInt("COUNT(*)")*i permet de rentrer les couleurs qui sont rentrées dans l'ordre
				}
				// on insère les autres valeurs
				while(rs.next()){
					tabValStr = rs.getString("valeur").split("; ");
					for(int i=0; i<tabValStr.length; i++){
						try{
							valeur=Integer.parseInt(tabReponses[Integer.parseInt(tabValStr[i])-1][rs.getInt("idTr")-1])+1;
						}
						catch(NumberFormatException e){}
						tabReponses[Integer.parseInt(tabValStr[i])-1][rs.getInt("idTr")-1] = Integer.toString(valeur);
					}
				}
			}
			catch(SQLException e){System.out.println(e);}
			break;
		case 'u':
			try{
				rs2 = s2.executeQuery("SELECT COUNT(*) FROM VALPOSSIBLE WHERE numQ="+numQ);
				rs.next();
				rs2.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[rs2.getInt("COUNT(*)")+ 1][nbTranche + 1];
				tabReponses[rs.getInt("valeur")-1][rs.getInt("idTr") - 1] = rs.getString("COUNT(idTr)");
				while (rs.next()) {
					tabReponses[rs.getInt("valeur")-1][rs.getInt("idTr") - 1] = rs.getString("COUNT(idTr)");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			break;
		case 'l':
			DefaultListModel<Proposition> listeProp = quest.getReponseLibre(idQ, numQ);
			HashMap<String, Integer> listeRep = new HashMap<String, Integer>();
			for (int i=0; i<listeProp.getSize(); i++){
				listeRep.put(listeProp.elementAt(i).getTexte(), i+1);
			}
			try{
				rs.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[listeRep.size()+ 1][nbTranche + 1];
				tabReponses[listeRep.get(rs.getString("valeur"))-1][rs.getInt("idTr") - 1] = rs.getString("COUNT(idTr)");
				while (rs.next()) {
					tabReponses[listeRep.get(rs.getString("valeur"))-1][rs.getInt("idTr") - 1] = rs.getString("COUNT(idTr)");
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			break;
		}
		// on calcule le total des lignes
		int totalLigne=0;
		for (int i=0; i<tabReponses.length-1; i++){
			for (int j=0; j<tabReponses[i].length-1; j++){
				try{
					totalLigne+=new Integer(tabReponses[i][j]);
				}
				catch(NumberFormatException e){}
			}
			tabReponses[i][tabReponses[i].length-1]=Integer.toString(totalLigne);
			totalLigne=0;
		}
		// on calcule le total des colonnes
		int totalColonne=0;
		int nbLignes=tabReponses.length;
		int nbColonnes=tabReponses[0].length;
		for(int i=0; i<nbColonnes; i++){
			for(int j=0; j<nbLignes; j++){
				try{
					totalColonne+=new Integer(tabReponses[j][i]);
				}
				catch(NumberFormatException e){}
			}
			tabReponses[tabReponses.length-1][i]=Integer.toString(totalColonne);
			totalColonne=0;
		}
		
		return tabReponses;
	}
	
	
	/**
	 * Permet de récupérer les données groupé par age d'une question dans un questionnaire donné
	 */
	public String[][] getReponsesParCategorie(int idQ, int numQ, char type){
		String[][] tabReponses=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		int nbTranche=0;
		try{
//			SELECT idCat, intituleCat, idT,valeur, COUNT(idCat), maxVal 
//			FROM CARACTERISTIQUE NATURAL JOIN REPONDRE NATURAL JOIN CATEGORIE NATURAL JOIN QUESTION 
//			WHERE IDQ=idQ AND NUMQ=numQ 
//			GROUP BY idCat, valeur;

			rs = s.executeQuery("SELECT valDebut, valFin, valeur, COUNT(idTr), maxVal, idTr FROM CARACTERISTIQUE NATURAL JOIN REPONDRE NATURAL JOIN TRANCHE NATURAL JOIN QUESTION WHERE idQ="+idQ+" AND numQ="+numQ+" GROUP BY idTr, valeur");
			rs2 = s2.executeQuery("SELECT COUNT(*) FROM TRANCHE");
			rs2.next();
			nbTranche=rs2.getInt("COUNT(*)");
			rs2.close();
		}
		catch(SQLException e){System.out.println(e);}
		switch(type){
		case 'n':
			try{
				// on récupère les données
				rs.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[rs.getInt("maxVal")+1+1][nbTranche+1]; // on doit mettre +1 à maxVal car il y a 11 valeurs entre 0 et 10 compris
				tabReponses[rs.getInt("valeur")][rs.getInt("idTr")-1]=rs.getString("COUNT(idTr)");
				while(rs.next()){
					tabReponses[rs.getInt("valeur")][rs.getInt("idTr")-1]=rs.getString("COUNT(idTr)");
				}
				break;
			}
			catch(SQLException e){System.out.println(e);}
			break;
		case 'c':
			try{
				rs2 = s2.executeQuery("SELECT COUNT(*) FROM VALPOSSIBLE WHERE numQ="+numQ);
				rs.next();
				rs2.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[rs2.getInt("COUNT(*)")*3+ 1][nbTranche + 1];
				// on insère la première valeur
				String[] tabValStr = rs.getString("valeur").split("; "); // on split le string que l'on a dans la base de donnees
				int valeur=0;
				for(int i=0; i<tabValStr.length; i++){
					try{
						valeur=Integer.parseInt(tabReponses[Integer.parseInt(tabValStr[i])-1 + rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1])+1;
					}
					catch(NumberFormatException e){}
					tabReponses[Integer.parseInt(tabValStr[i])-1 + rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1] = Integer.toString(valeur); //faire rs2.getInt("COUNT(*)")*i permet de rentrer les couleurs qui sont rentrées dans l'ordre
				}
				// on insère les autres valeurs
				while(rs.next()){
					tabValStr = rs.getString("valeur").split("; ");
					for(int i=0; i<tabValStr.length; i++){
						try{
							valeur=Integer.parseInt(tabReponses[Integer.parseInt(tabValStr[i])-1 + rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1])+1;
						}
						catch(NumberFormatException e){}
						tabReponses[Integer.parseInt(tabValStr[i])-1 + rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1] = Integer.toString(valeur);
					}
				}
			}
			catch(SQLException e){System.out.println(e);}
			break;
		case 'm':
			try{
				rs2 = s2.executeQuery("SELECT COUNT(*) FROM VALPOSSIBLE WHERE numQ="+numQ);
				rs.next();
				rs2.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[rs2.getInt("COUNT(*)")+ 1][nbTranche + 1];
				// on insère la première valeur
				String[] tabValStr = rs.getString("valeur").split("; "); // on split le string que l'on a dans la base de donnees
				int valeur=0;
				for(int i=0; i<tabValStr.length; i++){
					try{
						valeur=Integer.parseInt(tabReponses[Integer.parseInt(tabValStr[i])-1][rs.getInt("idTr")-1])+1;
					}
					catch(NumberFormatException e){}
					tabReponses[Integer.parseInt(tabValStr[i])-1][rs.getInt("idTr")-1] = Integer.toString(valeur); //faire rs2.getInt("COUNT(*)")*i permet de rentrer les couleurs qui sont rentrées dans l'ordre
				}
				// on insère les autres valeurs
				while(rs.next()){
					tabValStr = rs.getString("valeur").split("; ");
					for(int i=0; i<tabValStr.length; i++){
						try{
							valeur=Integer.parseInt(tabReponses[Integer.parseInt(tabValStr[i])-1][rs.getInt("idTr")-1])+1;
						}
						catch(NumberFormatException e){}
						tabReponses[Integer.parseInt(tabValStr[i])-1][rs.getInt("idTr")-1] = Integer.toString(valeur);
					}
				}
			}
			catch(SQLException e){System.out.println(e);}
			break;
		case 'u':
			try{
				rs2 = s2.executeQuery("SELECT COUNT(*) FROM VALPOSSIBLE WHERE numQ="+numQ);
				rs.next();
				rs2.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[rs2.getInt("COUNT(*)")+ 1][nbTranche + 1];
				tabReponses[rs.getInt("valeur")-1][rs.getInt("idTr") - 1] = rs.getString("COUNT(idTr)");
				while (rs.next()) {
					tabReponses[rs.getInt("valeur")-1][rs.getInt("idTr") - 1] = rs.getString("COUNT(idTr)");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			break;
		case 'l':
			DefaultListModel<Proposition> listeProp = quest.getReponseLibre(idQ, numQ);
			HashMap<String, Integer> listeRep = new HashMap<String, Integer>();
			for (int i=0; i<listeProp.getSize(); i++){
				listeRep.put(listeProp.elementAt(i).getTexte(), i+1);
			}
			try{
				rs.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new String[listeRep.size()+ 1][nbTranche + 1];
				tabReponses[listeRep.get(rs.getString("valeur"))-1][rs.getInt("idTr") - 1] = rs.getString("COUNT(idTr)");
				while (rs.next()) {
					tabReponses[listeRep.get(rs.getString("valeur"))-1][rs.getInt("idTr") - 1] = rs.getString("COUNT(idTr)");
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			break;
		}
		// on calcule le total des lignes
		int totalLigne=0;
		for (int i=0; i<tabReponses.length-1; i++){
			for (int j=0; j<tabReponses[i].length-1; j++){
				try{
					totalLigne+=Integer.parseInt(tabReponses[i][j]);
				}
				catch(NumberFormatException e){}
			}
			tabReponses[i][tabReponses[i].length-1]=Integer.toString(totalLigne);
			totalLigne=0;
		}
		// on calcule le total des colonnes
		int totalColonne=0;
		int nbLignes=tabReponses.length;
		int nbColonnes=tabReponses[0].length;
		for(int i=0; i<nbColonnes; i++){
			for(int j=0; j<nbLignes; j++){
				try{
					totalColonne+=Integer.parseInt(tabReponses[j][i]);
				}
				catch(NumberFormatException e){}
			}
			tabReponses[tabReponses.length-1][i]=Integer.toString(totalColonne);
			totalColonne=0;
		}
		
		return tabReponses;
	}
}