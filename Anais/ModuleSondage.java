import javax.swing.*;

import java.util.Random;
import java.awt.*;
import java.util.ArrayList;


/// ICI A SUPR: creerTest  + remise en place acce conection
		// Panel Module Sondage
@SuppressWarnings("serial")
public class ModuleSondage extends Module{

	Sonde sonde=null;
	Questionnaire questionnaire;
	mod espaceSonde;
	QuestionnaireVue questionnaireVue;
	SondeBD info;
	ConnexionMySQL maCo;
	Utilisateur utilisateur;
	JFrame fenetre;
	// en cas d'erreur il y auras u pop-up indiquant qu'aucun questionnaire n'est disponible
	
	public ModuleSondage(ConnexionMySQL connexion, Utilisateur util, JFrame f){ //
		
		super();	
		System.out.println("DEB CREATION D UNE MODULE SONDAGE");
		this.setLayout( new FlowLayout());
		this.setOpaque(false);
		Sonde sonde;
		Questionnaire questionnaire;
		maCo = connexion;
		utilisateur = util;
		fenetre = f;

		Random random = new Random();
		
		// On creer un client au assart dans la liste 
		
		
		try{
			info = new SondeBD(maCo);
			QuestionnaireBD QBD = new QuestionnaireBD(maCo);
			System.out.println("FIN QBD");
			this.sonde = this.selectSond();	
			System.out.println("crea Sonde");
			// calcul du Questionnaire 
			int pif = random.nextInt( QBD.getListeQuestionnaireSonde(this.sonde.getNumSond(), util.getIdU(), "Sondeur").size());
			System.out.println(QBD.getListeQuestionnaireSonde(this.sonde.getNumSond(), util.getIdU(), "Sondeur"));
			this.questionnaire = QBD.getListeQuestionnaireSonde(this.sonde.getNumSond(), util.getIdU(), "Sondeur").get(pif);
			System.out.println("FIN INIT");
			
		}catch( Exception e){
			System.out.println("pas de connexion"+ e);
		}
		
		//~ this.creerTest();
		
		
		// creation de la vue consernant les information du Sonde
		this.espaceSonde= new mod(this);
		
		// creation de la vue du questionnaire
		this.questionnaireVue = new QuestionnaireVue(this);
		
		this.add(espaceSonde);
		this.add(questionnaireVue);
		System.out.println("\nFIN CREA MODULE SONDAGE");

	}
	
	 public Sonde selectSond() throws Exception{

		ArrayList <Sonde> list=info.getListeSonde(utilisateur.getIdU());
		Random random = new Random();
		int ind=random.nextInt(list.size());	
		sonde = new Sonde(list.get(ind));
		//info.supprimerSonde(sonde.getNumSond());

		return sonde;
	}
	
	
	public void modif(){
		this.removeAll();
		try{
			this.sonde = this.selectSond();
		}
		catch( Exception e){
			System.out.println("pas de connexion"+ e);
		}
		this.espaceSonde= new mod(this);
		System.out.println(espaceSonde);
		this.questionnaireVue = new QuestionnaireVue(this);
		this.add(espaceSonde);
		this.add(questionnaireVue);
		this.revalidate();
		this.repaint();
		
		//~ m.modif();
		System.out.println("test");
	}
	
	//~ public void creerTest(){
		//~ this.sonde = new Sonde(01, "Martin", "Ben", 160496, "06403020", "Cadre");
		//~ 
		//~ 
		//~ this.questionnaire = new Questionnaire("TestEnr 01", 01,01,00, 's');
		//~ 
		//~ Question q1 = new Question("Que Suis-je:", 'u', 00, 01);
		//~ q1.addProposition(new Proposition("une femme"));
		//~ q1.addProposition(new Proposition("un homme "));
		//~ q1.addProposition(new Proposition("autre"));
		//~ 
		//~ Question q2 = new Question("Quel note avez-vous eu au dernier devoir de BD", 'n', 10, 02);
//~ 
		//~ Question q3 = new Question("Ou allez-vous manger", 'l', 00, 03);
//~ 
		//~ Question q4 = new Question("Quel sont vos profeseurs preferere?", 'm', 00, 04);
		//~ q4.addProposition(new Proposition("Mme Anglade"));
		//~ q4.addProposition(new Proposition("Mme Prevost"));
		//~ q4.addProposition(new Proposition("Mme Kalla"));
		//~ q4.addProposition(new Proposition("Mme Jacob"));
		//~ q4.addProposition(new Proposition("Mme Bolengier"));
		//~ q4.addProposition(new Proposition("Mm Robert"));
		//~ q4.addProposition(new Proposition("Mm Arsouze"));
		//~ q4.addProposition(new Proposition("Mm Limet"));
		//~ q4.addProposition(new Proposition("Mm Parmentier"));
		//~ 
		//~ Question q5 = new Question("Classer les 3 premier entier naturels positif par ordre croissant", 'c', 03, 05);
		//~ q5.addProposition(new Proposition("-1"));
		//~ q5.addProposition(new Proposition("0"));
		//~ q5.addProposition(new Proposition("2"));
		//~ q5.addProposition(new Proposition("1"));
		//~ q5.addProposition(new Proposition("3"));
		//~ q5.addProposition(new Proposition("5"));
		//~ q5.addProposition(new Proposition("7"));
		//~ q5.addProposition(new Proposition("6"));
		//~ q5.addProposition(new Proposition("-3"));
		//~ q5.addProposition(new Proposition("-2"));
		//~ 
		//~ this.questionnaire.addQuestion(q1);
		//~ this.questionnaire.addQuestion(q2);
		//~ this.questionnaire.addQuestion(q3);
		//~ this.questionnaire.addQuestion(q4);
		//~ this.questionnaire.addQuestion(q5);
		//~ 
		//~ System.out.print(this.questionnaire);
	//~ }
	
}
