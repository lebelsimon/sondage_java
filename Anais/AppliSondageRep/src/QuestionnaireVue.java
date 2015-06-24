import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class QuestionnaireVue extends JPanel{
	//static Questionnaire q, Sonde s;
	
	JLabel titreQuestionnaire;
	Questionnaire questionnaire;
	ModuleSondage module;
	QuestionVue questionVue;
	QuestionnaireNonRempli qError;
	//Question question;
	int largeur, hauteur;
	JPanel boutonsQuestions;
	JButton qprec, qsuiv, qprem, qder, terminer;
	JPanel idQuestionnaireJ, questionJ;
	
	
QuestionnaireVue(ModuleSondage mod){
		// initialisation des valeurs
		super();
		System.out.println("DEB crea Vue questionnaire");

		this.module = mod;
		//this.questionnaire = module.questionnaire;// BD.getListeQuestionnaire().get(numQuestionnaire-1);
		//~ this.question = questionnaire.getListeQuestions().get(0);
		System.out.println(module.fenetre);
		largeur = module.fenetre.getWidth()/2 - module.fenetre.getWidth()/10;
		hauteur = module.fenetre.getHeight() - module.fenetre.getHeight()/10;
		this.setPreferredSize(new Dimension(largeur, hauteur));
		
		this.setLayout(new BorderLayout());
		Random random = new Random();
		System.out.println(module.sonde);//.getNumSond());
		int numSonde = module.sonde.getNumSond();//199;
		questionVue = new QuestionVue(module.questionnaire.getListeQuestions().get(0), this);

		int numQuestionnaire = module.questionnaire.idQ; 
		System.out.println("Indice calculer");

		

		// Creation du label Questionnaire:
		
		idQuestionnaireJ = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 4));
		titreQuestionnaire = new JLabel(module.questionnaire.getTitreQuestionnaire());
		idQuestionnaireJ.add(titreQuestionnaire);
		idQuestionnaireJ.setBorder(BorderFactory.createLineBorder(Color.black));
		
		System.out.println("CREATION BOUTONS");
		// creation des boutons et de leur panel
		boutonsQuestions = new JPanel();
		
			// question suivante
		boutonsQuestions.setBorder(BorderFactory.createLineBorder(Color.black));
		qsuiv = new JButton(">");
		qsuiv.setName("suiv");
		qsuiv.setToolTipText("question suivante");
		qsuiv.addActionListener(new QuestionnaireButton(qsuiv.getName(), this));//, this.q));
			//question precedente
		qprec = new JButton("<");
		qprec.setName("prec");
		qprec.setToolTipText("question precedente");
		qprec.addActionListener(new QuestionnaireButton(qprec.getName(), this));//, this.q));
		qprec.setEnabled(false);
		
			//premiere question
		qprem = new JButton("<<<");
		qprem.setName("prem");
		qprem.setToolTipText("premiere question");
		qprem.addActionListener(new QuestionnaireButton(qprem.getName(), this));//, this.q));
		qprem.setEnabled(false);
			// derniere question
		qder = new JButton(">>>");
		qder.setName("dern");
		qder.setToolTipText("derniere question");
		qder.addActionListener(new QuestionnaireButton(qder.getName(), this));//, this.q));
		
			// Terminer questionnaire
		terminer = new JButton("Terminer");
		terminer.setName("term");
		terminer.setToolTipText("Terminer questionnaire");
		terminer.addActionListener(new QuestionnaireButton(terminer.getName(), this));
		terminer.setEnabled(false);
		
			
		
		// ajout des boutons au panel boutons
		boutonsQuestions.add(qprem); 
		boutonsQuestions.add(qprec);
		boutonsQuestions.add(terminer);
		boutonsQuestions.add(qsuiv); 
		boutonsQuestions.add(qder); 
		
		
		System.out.println("QuestionVue creer");
		questionVue.setBorder(BorderFactory.createLineBorder(Color.black));
		//questionVue.setPreferredSize(new Dimension(300,150));
		questionVue.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		System.out.println(">Jusqu'il ça passe");


		
		System.out.println("CREATION BOUTONS FIN");
		// creation du panel contenant la vue de la question et le bouton terminer:
		questionJ = new JPanel(new BorderLayout());
		questionJ.add(questionVue, BorderLayout.CENTER);
			
		
		
		
		//this.add(new JLabel("TESTTTTT"));
		this.add(idQuestionnaireJ, BorderLayout.NORTH);
		this.add(questionJ, BorderLayout.CENTER);
		this.add(boutonsQuestions,BorderLayout.SOUTH); 		
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		//this.add(new JLabel("coucou"));
		this.setPreferredSize(new Dimension(350,530));
		this.revalidate();
		
		System.out.println("CREA QUESTIONNAIRE FIN");
	}
	
	public void ChangerQuestion(Question q){
		this.questionJ.removeAll();
		this.questionVue = null;
		questionVue = new QuestionVue(q, this);
		questionVue.setBorder(BorderFactory.createLineBorder(Color.black));
		questionVue.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		questionJ.add(questionVue, BorderLayout.CENTER);
		
		//this.add(questionJ, BorderLayout.CENTER);
		//this.questionVue.setVisible(true);
		this.revalidate();
		this.repaint();
		//this.module.fenetre.repaint();
		//this.module.fenetre.revalidate();
	}
	
	public void TerminerQuestionnaireError(){
		this.questionJ.remove(questionVue);		
		qError = new QuestionnaireNonRempli(this);

		this.questionJ.add(qError, BorderLayout.CENTER);
		this.questionJ.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
}

