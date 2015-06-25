import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class QuestionnaireButton implements ActionListener {
	
	// Lien vers le questionnaire pour pouvoir modifier certaines de ses propriétés
	//~ Questionnaire q;
	
	 // nom du bouton:
	String nom;
	mod mo;
	ModuleSondage modsond;
	QuestionnaireVue questionnaireVue;
	char typeQ;
	
	// Constructeur
	public QuestionnaireButton(String _nom, QuestionnaireVue qVue){
		this.questionnaireVue=qVue;
		this.nom=_nom;
		this.mo=null;
		this.modsond=null;
		this.typeQ = this.questionnaireVue.questionVue.question.getIdT();
	}
	public QuestionnaireButton(String _nom, mod mo){

		this.nom=_nom;
		this.mo=mo;
		this.modsond=mo.modsond;
		this.typeQ = 'x';
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source;
			// on change l'affichage en fonction du boutons choisi
			
			source =  arg0.getSource();
			int newNumQ;
			Question newQ;
			switch (nom){	
				case "prec": 
					System.out.println("bouton prec"); 
					//System.out.print(questionnaireVue.questionVue.question.getNumQ());
					int nb = (questionnaireVue.questionVue.question.getNumQ())-2;
					//System.out.println(nb);
					//System.out.println(questionnaireVue.module.questionnaire.getListeQuestions().get(nb));
					if ( questionnaireVue.module.questionnaire.getListeQuestions().get(nb).getNumQ() ==1){
						questionnaireVue.qprec.setEnabled(false);
						questionnaireVue.qprem.setEnabled(false);
					}
					questionnaireVue.qsuiv.setEnabled(true);
					questionnaireVue.qder.setEnabled(true);
					
					
					this.AjoutValeur(questionnaireVue);
					System.out.println(questionnaireVue.module.questionnaire.getListeReponses());
					questionnaireVue.ChangerQuestion(questionnaireVue.module.questionnaire.getListeQuestions().get(nb));
					
					break;
					
				case "suiv": 
					System.out.println("bouton suiv"); 
					System.out.println(questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ()));
					if (questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ()) == questionnaireVue.module.questionnaire.getListeQuestions().get((questionnaireVue.module.questionnaire.getListeQuestions().size())-1)){
						questionnaireVue.qder.setEnabled(false);
						questionnaireVue.qsuiv.setEnabled(false);
						questionnaireVue.terminer.setEnabled(true);
					}
					questionnaireVue.qprec.setEnabled(true);
					questionnaireVue.qprem.setEnabled(true);
					this.AjoutValeur(questionnaireVue);
					questionnaireVue.ChangerQuestion(questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ())); //newQ);

					
					break;
				case "prem": 
					System.out.println("bouton prem");
					System.out.println(questionnaireVue.module.questionnaire.getListeQuestions().get(0));
					questionnaireVue.qprec.setEnabled(false);
					questionnaireVue.qprem.setEnabled(false);
					questionnaireVue.qsuiv.setEnabled(true);
					questionnaireVue.qder.setEnabled(true);
					this.AjoutValeur(questionnaireVue);	
					questionnaireVue.ChangerQuestion( questionnaireVue.module.questionnaire.getListeQuestions().get(0));
					break;
					
				case "dern":
					System.out.println("bouton dern"); 
					System.out.println(questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.module.questionnaire.getListeQuestions().size()-1));
					questionnaireVue.qsuiv.setEnabled(false);
					questionnaireVue.qder.setEnabled(false);
					questionnaireVue.qprec.setEnabled(true);
					questionnaireVue.qprem.setEnabled(true);
					questionnaireVue.terminer.setEnabled(true);
					this.AjoutValeur(questionnaireVue);	

					questionnaireVue.ChangerQuestion( questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.module.questionnaire.getListeQuestions().size()-1));
					break;				
				
				case "suivi":
					System.out.println("suiv");
					modsond.modif();
					break;
				case "appeler":
					BoiteDialogue bt=new BoiteDialogue(5000);
					bt.start();
					Icon tel = new ImageIcon("../Ressources/tel.png");
					Object[] options = {"Annuler" };
					bt.showOptionDialog(null,"Appel en cours ...", "Appel",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,tel, options, options[0]);
					System.out.println("terminer");break;
					
				case "term":
					this.AjoutValeur(questionnaireVue);	
					if ( questionnaireVue.module.questionnaire.getListeReponses().size() != questionnaireVue.module.questionnaire.getListeQuestions().size()){
							System.out.println("ERROR des reponces sont incomplete");
							questionnaireVue.TerminerQuestionnaireError();
						}
					else {
						System.out.println("le questionnaire a bien ete rempli");
					}

			}
			
	}
			
	public String AjoutValeur(QuestionnaireVue q) {
		
		QuestionVue questionVue = questionnaireVue.questionVue;
		String res ="";
		System.out.println("AjoutValeur");
		switch ( questionVue.typeQuestion) {
	
			case 'n':
				//System.out.println("ValNote: "+ questionVue.typeQuestion);
				if ( ((PropositionChoixNote) questionVue.choix).val != null)
					res+= ((PropositionChoixNote) questionnaireVue.questionVue.choix).val.toString();

				break;
			case 'u':
				if ( ((PropositionChoix1) questionVue.choix).listePropositions.getSelectedValue() != null)
					res+= ((PropositionChoix1) questionVue.choix).listePropositions.getSelectedValue().toString() ;
				break;
				
			case 'l':
				System.out.println("ListeProp selec: "+((PropositionChoixLibre) questionVue.choix).listePropositions.getSelectedValue());
				System.out.println("maRep: "+ ((PropositionChoixLibre) questionVue.choix).marep.getText());
				if (( ((PropositionChoixLibre) questionVue.choix).listePropositions.getSelectedValue() != null) && !((PropositionChoixLibre) questionVue.choix).marep.getText().equals(""))
					res+= ((PropositionChoix1) questionVue.choix).listePropositions.getSelectedValue().toString();
				else if( !((PropositionChoixLibre) questionVue.choix).marep.getText().equals( ""))
					res+=((PropositionChoixLibre) questionVue.choix).marep.getText();
				break;
				
			case 'm':
				for( int i=0; i< ((PropositionChoixX)questionVue.choix).mesBox.size(); i++){
					if  (((PropositionChoixX)questionVue.choix).mesBox.get(i).getState())
						res+=((PropositionChoixX)questionVue.choix).mesBox.get(i).getLabel();
				}
				break;
				
			case 'c':
				String[] stock= new String[((PropositionChoixOrdonnee)questionVue.choix).nbValOrdonne];
				for( int i=0; i<((PropositionChoixOrdonnee)questionVue.choix).mesBoutons.size(); i++){
					
					Integer monNb = ((PropositionChoixOrdonnee)questionVue.choix).mesBoutons.get(i).getSelectedIndex();

					if( !monNb.equals(-1) ){
							stock[ ((Integer)((PropositionChoixOrdonnee)questionVue.choix).mesBoutons.get(i).getSelectedItem())-1] = i+1+"" ;	
					}
				}
				
				for( int i=0; i< ((PropositionChoixOrdonnee)questionVue.choix).nbValOrdonne; i++){
					res+= stock[i]+"; ";
				}
				res = res.substring(0,res.length()-2);
				break;
				
		}
			if (!res.equals(""))
				questionnaireVue.module.questionnaire.ajouterReponse(questionnaireVue.questionVue.numQuestion, res);
		return res;
	}

}
