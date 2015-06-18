import javax.swing.*;

import java.awt.*;

		// Panel Module Sondage
@SuppressWarnings("serial")
public class ModuleSondage extends Module{
	
	QuestionnaireVue questionnaire;
	
	// par la suite le module sondage sera initialisé avec une question et un sonde 
	// en cas d'erreur il y auras u pop-up indiquant qu'aucun questionnaire n'est disponible
	
	public ModuleSondage(){
		super();	
		this.setLayout( new FlowLayout());
		mod m= new mod(this);
		
		// creation de la vue du questionnaire
		System.out.println("debut creation du Questionnaire Vue");

		this.questionnaire = new QuestionnaireVue(m);
		System.out.println("QuestionnaireVue ok");
		System.out.println(questionnaire);
		System.out.println(m);

		
		this.add(m);
		this.add(questionnaire);

	}
}
