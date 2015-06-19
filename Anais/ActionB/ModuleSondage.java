import javax.swing.*;

import java.awt.*;

		// Panel Module Sondage
@SuppressWarnings("serial")
public class ModuleSondage extends Module{
	mod m;
	QuestionnaireVue questionnaireVue;
	
	// en cas d'erreur il y auras u pop-up indiquant qu'aucun questionnaire n'est disponible
	
	public ModuleSondage(){
		super();	
		this.setLayout( new FlowLayout());
		mod m= new mod(this);
		
		// creation de la vue du questionnaire
		//~ System.out.println("debut creation du Questionnaire Vue");

		this.questionnaireVue = new QuestionnaireVue(m);
		//~ System.out.println("QuestionnaireVue ok");
		

		
		this.add(m);
		this.add(questionnaireVue);

	}
}
