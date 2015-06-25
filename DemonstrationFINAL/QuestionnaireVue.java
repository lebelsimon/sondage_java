// ATTENTION IL FAUT VERIFIER QUE SI LE QUESTIONNAIRE NE CONTIEN QU'UNE REP, ON A ACCES A TERMINER QUESTIONNAIRE

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author LAVOREL Anais
 */
public class QuestionnaireVue extends JPanel{

	
	JLabel titreQuestionnaire;
	Questionnaire questionnaire;
	ModuleSondage module;
	QuestionVue questionVue;
	QuestionnaireNonRempli qError;
	int largeur, hauteur;
	JPanel boutonsQuestions;
	JButton qprec, qsuiv, qprem, qder, terminer;
	JPanel idQuestionnaireJ, questionJ;
	
	
QuestionnaireVue(ModuleSondage Mod){

		super();
		this.module = Mod;
		this.questionnaire = module.questionnaire;

			// on defini la taille
		largeur = module.fenetre.getWidth()/2 - module.fenetre.getWidth()/10;
		hauteur = module.fenetre.getHeight() - module.fenetre.getHeight()/10;
		this.setSize(new Dimension(largeur, hauteur));
		
		this.setLayout(new BorderLayout());
		int numSonde = module.sonde.getNumSond();
		questionVue = new QuestionVue(module.questionnaire.getListeQuestions().get(0), this);
		int numQuestionnaire = module.questionnaire.idQ; 


		

		// Creation du label Questionnaire:
		
		idQuestionnaireJ = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 4));
		titreQuestionnaire = new JLabel(module.questionnaire.getTitreQuestionnaire());
		idQuestionnaireJ.add(titreQuestionnaire);
		idQuestionnaireJ.setBorder(BorderFactory.createLineBorder(Color.black));
		

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
		qprem = new JButton("|<");
		qprem.setName("prem");
		qprem.setToolTipText("premiere question");
		qprem.addActionListener(new QuestionnaireButton(qprem.getName(), this));//, this.q));
		qprem.setEnabled(false);
			// derniere question
		qder = new JButton(">|");
		qder.setName("dern");
		qder.setToolTipText("derniere question");
		qder.addActionListener(new QuestionnaireButton(qder.getName(), this));//, this.q));
		
			// Terminer questionnaire
		terminer = new JButton("Terminer");
		terminer.setName("term");
		terminer.setToolTipText("Terminer questionnaire");
		terminer.addActionListener(new QuestionnaireButton(terminer.getName(), this));
		terminer.setEnabled(false);
		
		// a tester des que POSIBLE
		if ( this.questionVue.question.numQ == this.questionnaire.listeReponses.size()){
			qder.setEnabled(false);
			qsuiv.setEnabled(false);
			terminer.setEnabled(true);
		}
		
		// ajout des boutons au panel boutons
		boutonsQuestions.add(qprem); 
		boutonsQuestions.add(qprec);
		boutonsQuestions.add(terminer);
		boutonsQuestions.add(qsuiv); 
		boutonsQuestions.add(qder); 
		
		

		questionVue.setBorder(BorderFactory.createLineBorder(Color.black));
		questionVue.setBorder(new EmptyBorder(10, 10, 10, 10));
		

		questionJ = new JPanel(new BorderLayout());
		questionJ.add(questionVue, BorderLayout.CENTER);
			


		this.add(idQuestionnaireJ, BorderLayout.NORTH);
		this.add(questionJ, BorderLayout.CENTER);
		this.add(boutonsQuestions,BorderLayout.SOUTH); 		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(350,530));
		this.revalidate();

	}
	
	public void ChangerQuestion(Question q){
		this.questionJ.removeAll();
		this.questionVue = null;
		questionVue = new QuestionVue(q, this);
		if (this.questionnaire.listeReponses.containsKey(q.numQ)){
			questionVue.placerRep();
		}
		questionVue.setBorder(BorderFactory.createLineBorder(Color.black));
		questionVue.setBorder(new EmptyBorder(10, 10, 10, 10));
		questionJ.add(questionVue, BorderLayout.CENTER);
				
		this.revalidate();
		this.repaint();

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

