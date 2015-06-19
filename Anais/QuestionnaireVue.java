import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class QuestionnaireVue extends JPanel{
	//static Questionnaire q, Sonde s;
	private JLabel idQuestionnaire;
	Questionnaire questionnaire;
	
	
	// pour l'instant je crée un affichage vide, mais par la suite le constructeur prendra en parametre:
	//		Questionnaire q, Sonde s
	QuestionnaireVue(){
		super();
		this.setLayout(new BorderLayout());

		// initialisation
		String nomQuestionnaire = questionnaire.getTitreQuestionnaire();
		
		// Creation du label Questionnaire:
		
		JPanel idQuestionnaireJ = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 4));
		
		
		idQuestionnaire = new JLabel(nomQuestionnaire);
		idQuestionnaireJ.add(idQuestionnaire);
		idQuestionnaireJ.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		// creation des boutons et de leur panel
		
		JPanel boutonsQuestions = new JPanel();
		
		boutonsQuestions.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton qsuiv = new JButton(">");
		qsuiv.setName("suiv");
		qsuiv.addActionListener(new QuestionnaireButton(qsuiv.getName(), this.questionnaire));
		
		JButton qprec = new JButton("<");
		qprec.setName("prec");
		qprec.addActionListener(new QuestionnaireButton(qprec.getName(), this.questionnaire));
		
		JButton qprem = new JButton("<<<");
		qprem.setName("prem");
		qprem.addActionListener(new QuestionnaireButton(qprem.getName(), this.questionnaire));
		
		JButton qder = new JButton(">>>");
		qder.setName("dern");
		qder.addActionListener(new QuestionnaireButton(qder.getName(), this.questionnaire));
		
		boutonsQuestions.add(qprem); 
		boutonsQuestions.add(qprec);
		boutonsQuestions.add(qsuiv); 
		boutonsQuestions.add(qder); 

		// creation de la vue de la question:
			// par la suite on donnera une question et il creera la vue en fonction de la question
		QuestionVue questionVue = new QuestionVueChoixOrdonnee();
		
		questionVue.setBorder(BorderFactory.createLineBorder(Color.black));
		questionVue.setPreferredSize(new Dimension(300,150));
		questionVue.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//this.add(new JLabel("TESTTTTT"));
		this.add(idQuestionnaireJ, BorderLayout.NORTH);
		this.add(questionVue, BorderLayout.CENTER);
		this.add(boutonsQuestions,BorderLayout.SOUTH); 		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
	}
}
