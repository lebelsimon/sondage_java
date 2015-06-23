import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.util.ArrayList;

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
	// en cas d'erreur il y auras u pop-up indiquant qu'aucun questionnaire n'est disponible
	
	public ModuleSondage(ConnexionMySQL connexion, Utilisateur util){
		super();	
		this.setLayout( new FlowLayout());
		Sonde sonde;
		Questionnaire questionnaire;
		maCo = connexion;
		utilisateur = util;
		
		Random random = new Random();
		// On creer un client au assart dans la liste 
		try{
			info = new SondeBD(maCo);
			QuestionnaireBD QBD = new QuestionnaireBD(maCo);
			
			this.sonde = this.selectSond();	
			System.out.println("sonde "+ this.sonde);
			// calcul du Questionnaire 
			System.out.println("\nlisteQuestionnaire: "+QBD.getListeQuestionnaireSonde(this.sonde.getNumSond(), util.getIdU(), "Sondeur"));
			int pif = random.nextInt( QBD.getListeQuestionnaireSonde(this.sonde.getNumSond(), util.getIdU(), "Sondeur").size());
			this.questionnaire = QBD.getListeQuestionnaireSonde(this.sonde.getNumSond(), util.getIdU(), "Sondeur").get(pif);
			
			
		}catch( Exception e){
			System.out.println("pas de connexion"+ e);
		}
		
		
		
		// creation de la vue consernant les information du Sonde
		this.espaceSonde= new mod(this);
		
		// creation de la vue du questionnaire
		this.questionnaireVue = new QuestionnaireVue(this);
		
		this.add(espaceSonde);
		this.add(questionnaireVue);

	}
	 public Sonde selectSond() throws Exception{

		ArrayList <Sonde> list=info.getListeSonde(utilisateur.getIdU());
		Random random = new Random();
		int ind=random.nextInt(list.size());	
		sonde = new Sonde(list.get(ind));
		//info.supprimerSonde(sonde.getNumSond());

		return sonde;
	}
}
