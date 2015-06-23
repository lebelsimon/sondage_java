import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

		// Panel Module Sondage
@SuppressWarnings("serial")
public class ModuleSondage extends Module{
	//~ JFrame fenetre;
	Sonde sonde;
	Questionnaire questionnaire;
	mod espaceSonde;
	QuestionnaireVue questionnaireVue;
	
	// en cas d'erreur il y auras u pop-up indiquant qu'aucun questionnaire n'est disponible
	
	public ModuleSondage(JFrame f){
		super();	
		this.setLayout( new FlowLayout());
		Sonde sonde;
		fenetre = f;
		Questionnaire questionnaire;
		
		
		
		// A PARTIR D ICI SA SERT QUE POUR LES TEST
		
		
		
		
			// creation d'utilisateur lambda
					//Utilisateur(int idU, String nomU, String prenomU, String login, String motDePasse, String role)
				Utilisateur u1 = new Utilisateur(01, "1Er", "Sondeur", "toto", "toto", "Sondeur");
				Utilisateur u2 = new Utilisateur(02, "1eme", "Sondeur", "tata", "toto", "Sondeur");
				
			// creation client
				//Client(int numero, String raisonSociale, String adresse1, String adresse2, int codePostal, String ville, String telephone, String email)
				Client c1 = new Client(01, "CadreSup", "20 rue flobert","2 rue toto", 45000, "Orleans", "06203040", "c@gmail.com");
				Client c2 = new Client(01, "Cadre", "2 rue flobert","20 rue toto", 45000, "Orleans", "0620000", "c@gmail.com");
				
			// Creation des Question
				//Question(String texteQuestion, char idT, int maxVal, int numQ)
				Question qChoixU = new Question("combien font 2+2?", 'u',0, 1);
				qChoixU.addProposition(new Proposition("4"));
				qChoixU.addProposition(new Proposition("22"));
				qChoixU.addProposition(new Proposition("poisson"));
				qChoixU.addProposition(new Proposition("je sais pas"));
				qChoixU.addProposition(new Proposition("1"));
				qChoixU.addProposition(new Proposition("0"));
				qChoixU.addProposition(new Proposition("EE"));
				qChoixU.addProposition(new Proposition("E"));
				qChoixU.addProposition(new Proposition("t"));
				qChoixU.addProposition(new Proposition("e"));
				qChoixU.addProposition(new Proposition("2e"));
				qChoixU.addProposition(new Proposition("2e"));
				qChoixU.addProposition(new Proposition("2e"));
				qChoixU.addProposition(new Proposition("2e"));
				qChoixU.addProposition(new Proposition("2e"));
				qChoixU.addProposition(new Proposition("2e"));
				qChoixU.addProposition(new Proposition("2e"));
				qChoixU.addProposition(new Proposition("2e"));
				qChoixU.addProposition(new Proposition("2e"));
				
				Question qChoixM=  new Question("quels sont vos couleurs preferer", 'm',3, 2);
				qChoixM.addProposition(new Proposition("Jaune"));
				qChoixM.addProposition(new Proposition("Orange"));
				qChoixM.addProposition(new Proposition("Rouge"));
				qChoixM.addProposition(new Proposition("Violet"));
				qChoixM.addProposition(new Proposition("Bleu"));
				qChoixM.addProposition(new Proposition("Vert"));
				
				Question qChoixNote = new Question("quel age doneriez-vous a Mme Kalla?",'n',100,3);
				
				Question qChoixLibre = new Question("quel est votre animal favori?",'l',0,4);
				
				Question qChoixClassement = new Question("Ordonnee les nombre selon vos preference (3choix) ?",'c',3,5);
				qChoixClassement.addProposition(new Proposition("Ingenieur"));
				qChoixClassement.addProposition(new Proposition("Master"));
				qChoixClassement.addProposition(new Proposition("Recherche"));
				qChoixClassement.addProposition(new Proposition("Liscence"));
				qChoixClassement.addProposition(new Proposition("n'importe"));
				qChoixClassement.addProposition(new Proposition("je sais pas"));
				
				
			// creation des questionnaire
				//Questionnaire(String titreQuestionnaire, int numC, int idU, int idPan, char etat)
				Questionnaire Quest01 = new Questionnaire("1er Questionnaire", 01, 01, 03, 's');
				Questionnaire Quest02 = new Questionnaire("2eme Questionnaire", 01, 01, 03, 's');
				Questionnaire Quest03 = new Questionnaire("3eme Questionnaire", 01, 01, 03, 's');
				
				Questionnaire Quest04 = new Questionnaire("1er Questionnaire", 01, 02, 03, 's');
				Questionnaire Quest05 = new Questionnaire("2eme Questionnaire", 01, 02, 03, 's');
				
			// creation des personnes a questionner
				//Sonde(int numSond, String nomSond, String prenomSond, int dateNaissSond, String telephone, String idCategorie)
				Sonde s1 = new Sonde(01, "Python", "Cobra", 12032012, "0234035036", "Cadre");
				Sonde s2= new Sonde(02, "Tutu", "re", 12032012, "0234035036", "Cadre");		
				
				ArrayList<Sonde> listeS = new ArrayList<Sonde>();
				listeS.add(s1);
				listeS.add(s2);
				
				ArrayList<Questionnaire> listeQ = new ArrayList<Questionnaire>();
				listeQ.add(Quest01);
				listeQ.add(Quest02);
				listeQ.add(Quest03);
				listeQ.add(Quest04);
				listeQ.add(Quest05);
				
				
				Quest01.addQuestion(qChoixU);
				Quest02.addQuestion(qChoixU);
				Quest03.addQuestion(qChoixU);
				Quest04.addQuestion(qChoixU);
				Quest05.addQuestion(qChoixU);
				
				Quest01.addQuestion(qChoixM);
				Quest02.addQuestion(qChoixM);
				Quest03.addQuestion(qChoixM);
				Quest04.addQuestion(qChoixM);
				Quest05.addQuestion(qChoixM);

				Quest01.addQuestion(qChoixNote);
				Quest02.addQuestion(qChoixNote);
				Quest03.addQuestion(qChoixNote);
				Quest04.addQuestion(qChoixNote);
				Quest05.addQuestion(qChoixNote);
				
				Quest01.addQuestion(qChoixLibre);
				Quest02.addQuestion(qChoixLibre);
				Quest03.addQuestion(qChoixLibre);
				Quest04.addQuestion(qChoixLibre);
				Quest05.addQuestion(qChoixLibre);
				
				Quest01.addQuestion(qChoixClassement);
				Quest02.addQuestion(qChoixClassement);
				Quest03.addQuestion(qChoixClassement);
				Quest04.addQuestion(qChoixClassement);
				Quest05.addQuestion(qChoixClassement);
				
				
		// FIN DE CREA VRIABLE TEST
		//~ for(int i=0; i<5; i++){
				//~ System.out.println(Quest01.getListeQuestions().get(i));
		//~ }
		// On creer un client au assart dans la liste 
		this.sonde = s1;
		this.questionnaire = listeQ.get(0)
				;
		// creation de la vue consernant les information du Sonde
		this.espaceSonde= new mod(this, this.sonde);
		
		// creation de la vue du questionnaire
		this.questionnaireVue = new QuestionnaireVue(this);
		

		
		this.add(espaceSonde);
		this.add(questionnaireVue);

	}
	
	public void modif(){
		this.removeAll();
		this.espaceSonde= new mod(this, this.sonde);
		this.questionnaireVue = new QuestionnaireVue(this);
		this.add(espaceSonde);
		this.add(questionnaireVue);
		this.revalidate();
		this.repaint();
		
		//~ m.modif();
		System.out.println("test");
	}
	
	
	
	
}
