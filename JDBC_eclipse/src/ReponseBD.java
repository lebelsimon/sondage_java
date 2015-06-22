import java.sql.*;

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
	
	/**
	 * Permet de récupérer les données groupé par age d'une question dans un questionnaire donné
	 */
	public int[][] getReponsesParAge(int idQ, int numQ, char type){
		int[][] tabReponses=null;
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
				tabReponses = new int[rs.getInt("maxVal")+1+1][nbTranche+1]; // on doit mettre +1 à maxVal car il y a 11 valeurs entre 0 et 10 compris
				tabReponses[rs.getInt("valeur")][rs.getInt("idTr")-1]=rs.getInt("COUNT(idTr)");
				while(rs.next()){
					tabReponses[rs.getInt("valeur")][rs.getInt("idTr")-1]=rs.getInt("COUNT(idTr)");
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
				tabReponses = new int[rs2.getInt("COUNT(*)")*3+ 1][nbTranche + 1];
				// on insère la première valeur
				String[] tabValStr = rs.getString("valeur").split("; ");
				int[] tabValInt = new int[tabValStr.length];
				for(int i=0; i<tabValInt.length; i++)
					tabReponses[Integer.parseInt(tabValStr[i])-1+rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1] +=1; //faire rs2.getInt("COUNT(*)")*i permet de rentrer les couleurs qui sont rentrées dans l'ordre
				// on insère les autres valeurs
				while(rs.next()){
					tabValStr = rs.getString("valeur").split("; ");
					tabValInt = new int[tabValStr.length];
					for(int i=0; i<tabValInt.length; i++)
						tabReponses[Integer.parseInt(tabValStr[i])-1+rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1] +=1; 
				}
			}
			catch(SQLException e){System.out.println(e);}
			break;
		case 'm':
			break;
		case 'u': case 'l': // les réponses libres et les réponses uniques se comportent de la même manière car le nombre de réponses et dans la table VALPOSSIBLE
			try{
				rs2 = s2.executeQuery("SELECT COUNT(*) FROM VALPOSSIBLE WHERE numQ="+numQ);
				rs.next();
				rs2.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new int[rs2.getInt("COUNT(*)")+ 1][nbTranche + 1];
				tabReponses[rs.getInt("valeur")-1][rs.getInt("idTr") - 1] = rs.getInt("COUNT(idTr)");
				while (rs.next()) {
					tabReponses[rs.getInt("valeur")-1][rs.getInt("idTr") - 1] = rs.getInt("COUNT(idTr)");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			break;
		}
		// on calcule le total des lignes
		int totalLigne=0;
		for (int i=0; i<tabReponses.length-1; i++){
			for (int j=0; j<tabReponses[i].length-1; j++){
				totalLigne+=tabReponses[i][j];
			}
			tabReponses[i][tabReponses[i].length-1]=totalLigne;
			totalLigne=0;
		}
		// on calcule le total des colonnes
		int totalColonne=0;
		int nbLignes=tabReponses.length;
		int nbColonnes=tabReponses[0].length;
		for(int i=0; i<nbColonnes; i++){
			for(int j=0; j<nbLignes; j++){
				totalColonne+=tabReponses[j][i];
			}
			tabReponses[tabReponses.length-1][i]=totalColonne;
			totalColonne=0;
		}
		
		return tabReponses;
	}
	
	
	/**
	 * Permet de récupérer les données groupé par age d'une question dans un questionnaire donné
	 */
	public int[][] getReponsesParCategorie(int idQ, int numQ, char type){
		int[][] tabReponses=null;
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
				tabReponses = new int[rs.getInt("maxVal")+1+1][nbTranche+1]; // on doit mettre +1 à maxVal car il y a 11 valeurs entre 0 et 10 compris
				tabReponses[rs.getInt("valeur")][rs.getInt("idTr")-1]=rs.getInt("COUNT(idTr)");
				while(rs.next()){
					tabReponses[rs.getInt("valeur")][rs.getInt("idTr")-1]=rs.getInt("COUNT(idTr)");
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
				tabReponses = new int[rs2.getInt("COUNT(*)")*3+ 1][nbTranche + 1];
				// on insère la première valeur
				String[] tabValStr = rs.getString("valeur").split("; ");
				int[] tabValInt = new int[tabValStr.length];
				for(int i=0; i<tabValInt.length; i++)
					tabReponses[Integer.parseInt(tabValStr[i])-1+rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1] +=1; //faire rs2.getInt("COUNT(*)")*i permet de rentrer les couleurs qui sont rentrées dans l'ordre
				// on insère les autres valeurs
				while(rs.next()){
					tabValStr = rs.getString("valeur").split("; ");
					tabValInt = new int[tabValStr.length];
					for(int i=0; i<tabValInt.length; i++)
						tabReponses[Integer.parseInt(tabValStr[i])-1+rs2.getInt("COUNT(*)")*i][rs.getInt("idTr")-1] +=1; 
				}
			}
			catch(SQLException e){System.out.println(e);}
			break;
		case 'm':
			break;
		case 'u': case 'l': // les réponses libres et les réponses uniques se comportent de la même manière car le nombre de réponses et dans la table VALPOSSIBLE
			try{
				rs2 = s2.executeQuery("SELECT COUNT(*) FROM VALPOSSIBLE WHERE numQ="+numQ);
				rs.next();
				rs2.next();
				// on crée le tableau avec un +1 pour l'affichage du total
				tabReponses = new int[rs2.getInt("COUNT(*)")+ 1][nbTranche + 1];
				tabReponses[rs.getInt("valeur")-1][rs.getInt("idTr") - 1] = rs.getInt("COUNT(idTr)");
				while (rs.next()) {
					tabReponses[rs.getInt("valeur")-1][rs.getInt("idTr") - 1] = rs.getInt("COUNT(idTr)");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			break;
		}
		// on calcule le total des lignes
		int totalLigne=0;
		for (int i=0; i<tabReponses.length-1; i++){
			for (int j=0; j<tabReponses[i].length-1; j++){
				totalLigne+=tabReponses[i][j];
			}
			tabReponses[i][tabReponses[i].length-1]=totalLigne;
			totalLigne=0;
		}
		// on calcule le total des colonnes
		int totalColonne=0;
		int nbLignes=tabReponses.length;
		int nbColonnes=tabReponses[0].length;
		for(int i=0; i<nbColonnes; i++){
			for(int j=0; j<nbLignes; j++){
				totalColonne+=tabReponses[j][i];
			}
			tabReponses[tabReponses.length-1][i]=totalColonne;
			totalColonne=0;
		}
		
		return tabReponses;
	}
}