import javax.swing.*;

import java.util.Random;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author LAVOREL anais
 * @author REPULES Benjamin
 * Cree un Panel contenant la JListe des question a remplir
 */
// Panel Module Sondage
@SuppressWarnings("serial")
public class ModuleSondage extends Module{

	Sonde sonde=null;
	Questionnaire questionnaire;
	Mod espaceSonde;
	QuestionnaireVue questionnaireVue;
	SondeBD info;
	ConnexionMySQL maCo;
	Utilisateur utilisateur;
	JFrame fenetre;
	QuestionnaireBD QBD;
	// en cas d'erreur il y auras u pop-up indiquant qu'aucun questionnaire n'est disponible
	
	public ModuleSondage(ConnexionMySQL connexion, Utilisateur util, JFrame f){ //
		
		super();
		this.setLayout( new FlowLayout());
		this.setOpaque(false);
		maCo = connexion;
		utilisateur = util;
		fenetre = f;

		Random random = new Random();
		
		// On creer un client au assart dans la liste 
		
		
		try{
			info = new SondeBD(maCo);
			QBD = new QuestionnaireBD(maCo);
			this.sonde = this.selectSond();	
			// calcul du Questionnaire 
			int pif = random.nextInt( QBD.getListeQuestionnaireSonde(this.sonde.getNumSond(), util.getIdU(), "Sondeur").size());
			this.questionnaire = QBD.getListeQuestionnaireSonde(this.sonde.getNumSond(), util.getIdU(), "Sondeur").get(pif);
			
		}catch( Exception e){
			System.out.println("pas de connexion"+ e);
		}
		
		//~ this.creerTest();
		
		
		// creation de la vue consernant les information du Sonde
		this.espaceSonde= new Mod(this);
		
		// creation de la vue du questionnaire
		this.questionnaireVue = new QuestionnaireVue(this);
		
		this.add(espaceSonde);
		this.add(questionnaireVue);


	}
	//Selectionne un sonde aleatoirement
	 public Sonde selectSond() throws Exception{

		ArrayList <Sonde> list=info.getListeSonde(utilisateur.getIdU());
		Random random = new Random();
		int ind=random.nextInt(list.size());	
		sonde = new Sonde(list.get(ind));

		return sonde;
	}
	
	//rafraichisement de la page avec modification du sonde et donc du questionnaire
	public void modif(){
		this.removeAll();
		try{
			this.sonde = this.selectSond();
		}
		catch( Exception e){
			System.out.println("pas de connexion"+ e);
		}
		this.espaceSonde= new Mod(this);
		System.out.println(espaceSonde);
		this.questionnaireVue = new QuestionnaireVue(this);
		this.add(espaceSonde);
		this.add(questionnaireVue);
		this.revalidate();
		this.repaint();
		
		//~ m.modif();
	}
	

}
