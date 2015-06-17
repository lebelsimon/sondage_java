import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class QuestionnaireVue extends JPanel{
	//static Questionnaire q, Sonde s;
	private JLabel idQuestionnaire;
	Questionnaire questionnaire;
	mod m;
	
	// pour l'instant je crée un affichage vide, mais par la suite le constructeur prendra en parametre:
	//		Questionnaire q, Sonde s
	QuestionnaireVue(mod _m){
		super();
		this.m = _m;
		this.setLayout(new BorderLayout());
		Random random = new Random();
		int ind = random.nextInt( m.info.getListeSonde().size());
		
		int numQuestionnaire = m.info.getListeQuestionnaire().get(ind);
		QuestionnaireBD QBD = new QuestionnaireBD();
		
		for (questionnaire q: QBD.getListeQuestionnaire()){
			if( numQuestionnaire == q.getIdQ())
				questionnaire = q;
		}

		// Creation du label Questionnaire:
		
		JPanel idQuestionnaireJ = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 4));
		idQuestionnaire = new JLabel(questionnaire.getTitreQuestionnaire());
		idQuestionnaireJ.add(idQuestionnaire);
		idQuestionnaireJ.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		// creation des boutons et de leur panel
		
		JPanel boutonsQuestions = new JPanel();
		
			// question suivante
		boutonsQuestions.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton qsuiv = new JButton(">");
		qsuiv.setName("suiv");
		qsuiv.setToolTipText("question suivante");
		qsuiv.addActionListener(new QuestionnaireButton(qsuiv.getName()));//, this.q));
		
			//question precedente
		JButton qprec = new JButton("<");
		qprec.setName("prec");
		qprec.setToolTipText("question précédente");
		qprec.addActionListener(new QuestionnaireButton(qprec.getName()));//, this.q));
		
			//premiere question
		JButton qprem = new JButton("<<<");
		qprem.setName("prem");
		qprem.setToolTipText("première question");
		qprem.addActionListener(new QuestionnaireButton(qprem.getName()));//, this.q));
		
			// derniere question
		JButton qder = new JButton(">>>");
		qder.setName("dern");
		qder.setToolTipText("dernière question");
		qder.addActionListener(new QuestionnaireButton(qder.getName()));//, this.q));
		
		boutonsQuestions.add(qprem); 
		boutonsQuestions.add(qprec);
		boutonsQuestions.add(qsuiv); 
		boutonsQuestions.add(qder); 

		// creation de la vue de la question:
			// par la suite on donnera une question et il creera la vue en fonction de la question
		QuestionVue questionVue = new QuestionVue1Choix();
		
		questionVue.setBorder(BorderFactory.createLineBorder(Color.black));
		questionVue.setPreferredSize(new Dimension(300,150));
		questionVue.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//this.add(new JLabel("TESTTTTT"));
		this.add(idQuestionnaireJ, BorderLayout.NORTH);
		this.add(questionVue, BorderLayout.CENTER);
		this.add(boutonsQuestions,BorderLayout.SOUTH); 		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setPreferredSize(new Dimension(350,530));
		this.revalidate();
		
		
	}
}
