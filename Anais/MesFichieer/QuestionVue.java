import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author LAVOREL anais
 * @param q: ne question
 * @param questV: un QuestionnaireVue
 * Cree la Vue de la question contenant tout les elements necesaire
 */
public class QuestionVue extends JPanel{
	JLabel idQuestion;
	JTextArea enonce;
	int numQuestion;
	int nombreVal;
	char typeQuestion ;
	DefaultListModel<Proposition> propositions;
	Question question;
	QuestionnaireVue questionnaireVue;
	String enonceQuestion;
	JButton suprSelect;
	JPanel choix ;
	
	QuestionVue( Question q, QuestionnaireVue questV){
		this.setLayout( new BorderLayout( 40,50));
		question = q;
		questionnaireVue = questV;
		numQuestion = question.getNumQ();
		propositions = question.getPropositions();
		nombreVal = propositions.size();
		typeQuestion = question.getIdT();
		enonceQuestion = question.getTexteQuestion();
		
		
		
		// creations des elements de la vue
		idQuestion = new JLabel("Question numero: "+numQuestion + " / "+ questionnaireVue.module.questionnaire.getListeQuestions().size());
		idQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		
		enonce = new JTextArea(enonceQuestion);
		enonce.setEditable(false);
		enonce.setLineWrap(true);
		
		//creation du panel contenant l'identifiant et l'enonce de la question	
		JPanel haut = new JPanel(new GridLayout(2,1));
		
			// suprimer la selection
		suprSelect = new JButton("Supprimer la Selection");
		suprSelect.setName("supr");
		suprSelect.setToolTipText("Supprimer la selection, remettre la reponce a '' ");
		suprSelect.addActionListener(new QuestionButton(this));
		suprSelect.setAlignmentX(CENTER_ALIGNMENT);

		this.add(suprSelect, "South");
		
		// ajout des element a la vue QUestion
		haut.add(idQuestion);
		haut.add(enonce);
		this.add(haut,"North");
		
		// creation des proposition
		choix = this.creerProposition(typeQuestion);
		this.add(choix, "Center");
		this.revalidate();
		this.repaint();
	}
	
	// cree la liste des propositon en fonction du type de question
	public JPanel creerProposition(char typeQuestion){
		JPanel res; 
		if (typeQuestion=='l'){
			res = new PropositionChoixLibre(this);
		}
		else if( typeQuestion=='c'){
			res = new PropositionChoixOrdonnee(this);
		}
		else if ( typeQuestion=='m'){
			res = new PropositionChoixX(this);
		}
		else if( typeQuestion=='n'){
			res = new PropositionChoixNote(this);
		}
		else{
			res = new PropositionChoix1(this);
		}
		return res;
	}
	
	public void placerRep(){
		switch (this.question.idT){
			case 'l':
				boolean trouve = false;
				for( int i=0; i< ((PropositionChoixLibre)this.choix).lesPropositions.size(); i++){
					if (((PropositionChoixLibre)this.choix).lesPropositions.get(i).texte.equals(questionnaireVue.questionnaire.listeReponses.get(question.numQ))){
						((PropositionChoixLibre)this.choix).listePropositions.setSelectedIndex(i);
						trouve = true;
					}
				}
				if (!trouve){
						((PropositionChoixLibre)this.choix).marep.setText(questionnaireVue.questionnaire.listeReponses.get(question.numQ));

				}
				break;
			case 'm':
				for( int i=0; i< ((PropositionChoixX)this.choix).lesPropositions.size(); i++){
					if (questionnaireVue.questionnaire.listeReponses.get(question.numQ).contains(((PropositionChoixX)this.choix).lesPropositions.get(i).texte) )
						((PropositionChoixX)this.choix).mesBox.get(i).setState(true);;
				}
				break;
			case 'u':
				for( int i=0; i< ((PropositionChoix1)this.choix).lesPropositions.length; i++){
					if (((PropositionChoix1)this.choix).lesPropositions[i].texte.equals(questionnaireVue.questionnaire.listeReponses.get(question.numQ))) 
						((PropositionChoix1)this.choix).listePropositions.setSelectedIndex(i);
				}
				break;
			case 'n':
				((PropositionChoixNote) this.choix).val = Integer.parseInt(questionnaireVue.questionnaire.listeReponses.get(question.numQ));
				((PropositionChoixNote) this.choix).slide.setValue(((PropositionChoixNote) this.choix).val);
				
				break;
			case 'c':

				break;
				
		}
	}
	
	
		
}
		
		
