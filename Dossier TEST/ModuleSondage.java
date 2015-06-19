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
		this.questionnaire = new QuestionnaireVue(m);
		
		
		this.add(m);
		this.add(questionnaire);
	}
}
