import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class QuestionnaireVue extends JPanel{
	//static Questionnaire q, Sonde s;
	
	JLabel titreQuestionnaire;
	//Questionnaire questionnaire;
	ModuleSondage module;
	QuestionVue questionVue;
	Question question;
	int largeur, hauteur;
	
	//les boutons
	JButton qsuiv, qprec, qprem, qder;
	QuestionnaireVue(ModuleSondage mod){
		// initialisation des valeurs
		super();
		System.out.println("DEB crea Vue questionnaire");

		this.module = mod;
		//this.questionnaire = module.questionnaire;
		this.question = module.questionnaire.getListeQuestions().get(0);
		System.out.print("ma question: "+ question);
		System.out.print(module.fenetre);
		// la taille de l'espace Questionnaire est defini en fonction de la taille de la fenetre
		largeur = module.fenetre.getWidth()/2 - module.fenetre.getWidth()/10;
		hauteur = module.fenetre.getHeight() - module.fenetre.getHeight()/10;
		this.setPreferredSize(new Dimension(largeur, hauteur));
		
		this.setLayout(new BorderLayout());
		Random random = new Random();

		int numSonde = module.sonde.getNumSond();
		int numQuestionnaire = module.questionnaire.idQ; 
		//System.out.println("Ici");		
	
		
		
		System.out.println(question);

		// Creation du label Questionnaire:
		
		JPanel idQuestionnaireJ = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 4));
		titreQuestionnaire = new JLabel(module.questionnaire.getTitreQuestionnaire());
		idQuestionnaireJ.add(titreQuestionnaire);
		idQuestionnaireJ.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		// creation des boutons et de leur panel
		JPanel boutonsQuestions = new JPanel();
		
			// question suivante
		boutonsQuestions.setBorder(BorderFactory.createLineBorder(Color.black));
		qsuiv = new JButton(">");
		qsuiv.setName("suiv");
		qsuiv.setToolTipText("question suivante");
		qsuiv.addActionListener(new QuestionnaireButton(qsuiv.getName(), this));
		
			//question precedente
		qprec = new JButton("<");
		qprec.setName("prec");
		qprec.setToolTipText("question précédente");
		qprec.addActionListener(new QuestionnaireButton(qprec.getName(), this));
		
			//premiere question
		qprem = new JButton("<<<");
		qprem.setName("prem");
		qprem.setToolTipText("première question");
		qprem.addActionListener(new QuestionnaireButton(qprem.getName(), this));
		
			// derniere question
		qder = new JButton(">>>");
		qder.setName("dern");
		qder.setToolTipText("dernière question");
		qder.addActionListener(new QuestionnaireButton(qder.getName(), this));
		
		// ajout des boutons au panel boutons
		boutonsQuestions.add(qprem); 
		boutonsQuestions.add(qprec);
		boutonsQuestions.add(qsuiv); 
		boutonsQuestions.add(qder); 
		

		
		

		// creation de la vue de la question:

		questionVue = new QuestionVue(this);
		
		questionVue.setBorder(BorderFactory.createLineBorder(Color.black));
		questionVue.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		
		this.add(idQuestionnaireJ, BorderLayout.NORTH);
		this.add(questionVue, BorderLayout.CENTER);
		this.add(boutonsQuestions,BorderLayout.SOUTH); 		
		this.setBorder(BorderFactory.createLineBorder(Color.black));


		this.setPreferredSize(new Dimension(350,530));
		this.revalidate();

	}
	public void ChangerQuestion( QuestionnaireVue questionnaireVue ,Question q){
		System.out.println("deb ChangerQuestion");
		questionnaireVue.question = q;
		questionnaireVue.questionVue =  new QuestionVue(questionnaireVue);
		

	
		this.module.fenetre.revalidate();
		this.module.fenetre.repaint();
		System.out.println(q);
		
	}
}
