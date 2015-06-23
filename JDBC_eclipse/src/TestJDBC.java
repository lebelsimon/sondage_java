
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Damien MARTIN
 */

public class TestJDBC {

	ClientBD client;
	ReponsesBD reponse;
	UtilisateurBD util;
	SondeBD sond;
	QuestionnaireBD questionnaire;
	QuestionBD question;
	ReponseBD rep;

	Scanner sc = null;

	public TestJDBC() {
		sc = new Scanner(System.in);
	}

	String saisieString(String prompt) {
		System.out.print(prompt + ' ');
		String res = sc.nextLine();
		return res;
	}

	String saisieStringTel(String prompt, int longueur) {
		String res = "";
		boolean ok = false;
		while (!ok) {
			System.out.print(prompt + ' ');
			res = sc.nextLine();
			if (res.length() != 10)
				System.out.println("Le numéro doit contenir 10 chiffres");
			else
				try {
					Integer i = new Integer(res);
					ok = true;
				} catch (Exception e) {
					System.out
							.println("Le numéro ne doit contenir que des chiffres");
				}
		}
		return res;
	}

	int saisieInt(String prompt, int valMin, int valMax) {
		System.out.print(prompt + ' ');
		boolean ok = false;
		int resInt = 0;
		while (!ok) {
			String res = sc.nextLine();
			try {
				resInt = Integer.parseInt(res);
				if (resInt >= valMin && resInt <= valMax)
					ok = true;
				else
					System.out.println("L'entier doit être compris entre "
							+ valMin + " et " + valMax);
			} catch (Exception e) {
				System.out.println(res + " n'est pas un nombre entier");
				System.out.print(prompt + ' ');
			}
		}
		return resInt;
	}

	Client saisieClient() {
		String raisonSociale = saisieString("raison sociale :");
		String adresse1 = saisieString("adresse 1 :");
		String adresse2 = saisieString("adresse 2 :");
		int codePostal = saisieInt("Code Postal :", 1000, 99999);
		String ville = saisieString("ville :");
		String telephone = saisieStringTel("Telephone :", 10);
		String email = saisieString("email :");
		return new Client(raisonSociale, adresse1, adresse2, codePostal, ville,
				telephone, email);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestJDBC tjdbc = new TestJDBC();
		// ici creation d'un connexion à MySQL
		try {
			ConnexionMySQL co = new ConnexionMySQL(
					"jdbc:mysql://servinfo-db:3306/", "dbdmartin", "dbdmartin",
					"/home/dmartin");
			tjdbc.client = new ClientBD(co);
			tjdbc.reponse = new ReponsesBD(co);
			tjdbc.util = new UtilisateurBD(co);
			tjdbc.sond = new SondeBD(co);
			tjdbc.questionnaire = new QuestionnaireBD(co);
			tjdbc.question = new QuestionBD(co);
			tjdbc.rep = new ReponseBD(co);
			System.out.println("connexion établie");
		} catch (Exception e) {
			System.out.println("connexion non établie");
		}
		boolean fini = false;
		while (!fini) {
			System.out.println("\n1. Afficher le plus grand numéro de client");
			System.out.println("2. Créer un client");
			System.out.println("3. Supprimer un client");
			System.out.println("4. Mettre à jour un client");
			System.out.println("5. Afficher un client");
			System.out.println("6. Afficher les questionnaires par client");
			System.out.println("7. Question nbReponsesLibreParCat");
			System.out.println("8. Question moyenneReponseParTrancheAgeEtHF");
			System.out.println("9. Se connecter");
			System.out.println("10. Liste Sonde");
			System.out.println("11. Supprimer sondé");
			System.out.println("12. Afficher la liste des questionnaire avec la liste des questions");
			System.out.println("13. Afficher la liste des questions");
			System.out.println("14. Modifier une question");
			System.out.println("15. Insérer un nouveau questionnaire");
			System.out.println("16. Modifier un questionnaire");
			System.out.println("17. Supprimer un questionnaire");
			System.out.println("18. Créer un questionnaire à partir d'un numéro et d'un questionnaire de la BD");
			System.out.println("19. Afficher la liste des questionnaire pour le sondé n°10");
			System.out.println("20. Afficher les réponses du questionnaire 1 par age");
			System.out.println("21. Afficher les réponses du questionnaire 1 par catégorie socio-professionnelle");
			System.out.println("22. Sortir");
			int rep = tjdbc.saisieInt("Entrez votre choix", 1, 25);
			int numCli;
			Client c;
			switch (rep) {
			case 1:
				// ici l'appel à la méthode qui va bien + affichage du résultat
				try {
					System.out.println("\nPlus grand numéro déjà attribué : "
							+ tjdbc.client.maxNumClient() + "\n");
				} catch (SQLException e) {
					System.out.println("\nPas de numéro ");
				}
				break;
			case 2:
				try {
					c = tjdbc.saisieClient();
					// ici l'appel à la méthode qui va bien
					tjdbc.client.insererClient(c);
				} catch (SQLException e) {
					System.out
							.println("le client n'a pas été créé correctement");
				}
				break;
			case 3:
				try {
					numCli = tjdbc.saisieInt(
							"\nEntrez le numéro du client à supprimer", 1,
							999999);
					// ici l'appel à la méthode qui va bien
					tjdbc.client.effacerClient(numCli);
				} catch (SQLException e) {
					System.out.println("le client n'a pas été supprimé");
				}
				break;
			case 4:
				try {
					numCli = tjdbc.saisieInt(
							"\nEntrez le numéro du client à mettre à jour", 1,
							999999);
					System.out
							.println("Entrer les nouvelles informations du client");
					c = tjdbc.saisieClient();
					c.setNumero(numCli);
					// ici l'appel à la méthode qui va bien
					tjdbc.client.majClient(c);
				} catch (SQLException e) {
					System.out.println("le client n'a pas pu être mis à jour");
				}
				break;
			case 5:
				try {
					numCli = tjdbc.saisieInt("\nEntrez le numéro du client à afficher", 1,999999);
					// ici l'appel à la méthode qui va bien
					tjdbc.client.affiche(numCli);
				} catch (SQLException e) {
					System.out.println("le client n'a pas été affiché");
				}
				break;
			case 6:
				tjdbc.client.listeQuestionnaire();
				break;
			case 7:
				tjdbc.reponse.nbReponsesLibreParCat(1, 5);
				break;
			case 8:
				tjdbc.reponse.moyenneReponseParTrancheAgeEtHF(1, 1);
				break;
			case 9:
				String login = tjdbc.saisieString("Login : ");
				String mdp = tjdbc.saisieString("Mot de passe : ");
				System.out.println(tjdbc.util.connexionUtilisateur(login, mdp));
				break;
			case 10:
				ArrayList<Sonde> res = tjdbc.sond.getListeSonde(2);
				for (Sonde s : res)
					System.out.println(s);
				break;
			case 11:
				tjdbc.sond.supprimerSonde(1);
				break;
			case 12:
				//System.out.println(tjdbc.questionnaire.getListeQuestionnaire(1, "C"));
				System.out.println(tjdbc.questionnaire.getListeQuestionnaireConcepteur(1, "C"));
				break;
			case 13:
				System.out.println(tjdbc.question.getListeQuestion(1));
				break;
			case 14:
				tjdbc.question.modifieQuestion(1, new Question("question test", 'n', 10, 1));
				break;
			case 15:
				tjdbc.questionnaire.ajouterQuestionnaire(new Questionnaire("ajout questionnaire test", 15688, 7, 2, 'S'));
				break;
			case 16:
				Questionnaire qu = new Questionnaire("Questionnaire test modifié", 15688, 4, 1, 'S');
				qu.setIdQ(9);
				tjdbc.questionnaire.modifierQuestionnaire(qu);
				break;
			case 17:
				System.out.println("entrez le numéro de questionnaire à supprimer");
				String num = tjdbc.sc.nextLine();
				tjdbc.questionnaire.supprimerQuestionnaire(Integer.parseInt(num));
				break;
			case 18:
				System.out.println(tjdbc.questionnaire.creerQuestionnaire(1, 2, "Sondeur"));
				break;
			case 19:
				System.out.println(tjdbc.questionnaire.getListeQuestionnaireSonde(16, 2, "Sondeur"));
				break;
			case 20:
				System.out.println("------------ question note-------------");
				String[][] tab = tjdbc.rep.getReponsesParAge(1, 1, 'n');
				for(int i=0; i<tab.length; i++){
					for(int j=0; j<tab[i].length; j++){
						System.out.print(tab[i][j]+", ");
					}
					System.out.println();
				}
				System.out.println("------------ question choix unique-------------");
				tab = tjdbc.rep.getReponsesParAge(1, 3, 'u');
				for(int i=0; i<tab.length; i++){
					for(int j=0; j<tab[i].length; j++){
						System.out.print(tab[i][j]+", ");
					}
					System.out.println();
				}
				System.out.println("------------ question choix libre-------------");
				tab = tjdbc.rep.getReponsesParAge(1, 5, 'l');
				for(int i=0; i<tab.length; i++){
					for(int j=0; j<tab[i].length; j++){
						System.out.print(tab[i][j]+", ");
					}
					System.out.println();
				}
				System.out.println("------------ question classement-------------");
				tab = tjdbc.rep.getReponsesParAge(1, 4, 'c');
				for(int i=0; i<tab.length; i++){
					for(int j=0; j<tab[i].length; j++){
						System.out.print(tab[i][j]+", ");
					}
					System.out.println();
				}
				break;
			case 21:
				System.out.println("------------ question note-------------");
				String[][] tab2 = tjdbc.rep.getReponsesParCategorie(1, 1, 'n');
				for(int i=0; i<tab2.length; i++){
					for(int j=0; j<tab2[i].length; j++){
						System.out.print(tab2[i][j]+", ");
					}
					System.out.println();
				}
				System.out.println("------------ question choix unique-------------");
				tab2 = tjdbc.rep.getReponsesParCategorie(1, 3, 'u');
				for(int i=0; i<tab2.length; i++){
					for(int j=0; j<tab2[i].length; j++){
						System.out.print(tab2[i][j]+", ");
					}
					System.out.println();
				}
				System.out.println("------------ question choix libre-------------");
				tab2 = tjdbc.rep.getReponsesParCategorie(1, 5, 'l');
				for(int i=0; i<tab2.length; i++){
					for(int j=0; j<tab2[i].length; j++){
						System.out.print(tab2[i][j]+", ");
					}
					System.out.println();
				}
				System.out.println("------------ question classement-------------");
				tab2 = tjdbc.rep.getReponsesParCategorie(1, 4, 'c');
				for(int i=0; i<tab2.length; i++){
					for(int j=0; j<tab2[i].length; j++){
						System.out.print(tab2[i][j]+", ");
					}
					System.out.println();
				}
				break;
			case 22:
				System.out.println(tjdbc.client.getListeClient());
				break;
			case 23:
				fini = true;
				break;
			}
		}
		System.out.println("Merci! Au revoir");
		// ici l'appel à la méthode qui va bien
	}

}
