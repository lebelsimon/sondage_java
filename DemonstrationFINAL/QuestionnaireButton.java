import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * @author LAVOREL Anais
 * @author REPULES Benjamin
 */
public class QuestionnaireButton implements ActionListener {
	String nom;
	Mod mo;
	ModuleSondage modsond;
	QuestionnaireVue questionnaireVue;
	char typeQ;
	
	// Constructeur pour le QuestionnaireVue
	public QuestionnaireButton(String _nom, QuestionnaireVue qVue){
		this.questionnaireVue=qVue;
		this.nom=_nom;
		this.mo=null;
		this.modsond=null;
		this.typeQ = this.questionnaireVue.questionVue.question.getIdT();
	}
	
	// Constructeur pour le Mod
	public QuestionnaireButton(String _nom, Mod mo){

		this.nom=_nom;
		this.mo=mo;
		this.modsond=mo.modsond;
		this.typeQ = 'x';
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source;
		source =  arg0.getSource();
		int newNumQ;
		Question newQ;
		switch (nom){	
			
			case "prec": 
				int nb = (questionnaireVue.questionVue.question.getNumQ())-2;
				
				// on desactive les boutons precedent et premiere question si on arrive sur la 1er question du questionnaire
				if ( questionnaireVue.module.questionnaire.getListeQuestions().get(nb).getNumQ() ==1){
					questionnaireVue.qprec.setEnabled(false);
					questionnaireVue.qprem.setEnabled(false);
				}
				questionnaireVue.qsuiv.setEnabled(true);
				questionnaireVue.qder.setEnabled(true);
				
				// ajoute la reponse au dictionnaire de reponse si elle existe
				this.AjoutValeur(questionnaireVue);
				
				// on change la vue
				questionnaireVue.ChangerQuestion(questionnaireVue.module.questionnaire.getListeQuestions().get(nb));
				
				break;
				
			case "suiv": 
				// on desactive les boutons precedent et premiere question si on arrive sur la derniere question du questionnaire
				if (questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ()) == questionnaireVue.module.questionnaire.getListeQuestions().get((questionnaireVue.module.questionnaire.getListeQuestions().size())-1)){
					questionnaireVue.qder.setEnabled(false);
					questionnaireVue.qsuiv.setEnabled(false);
					questionnaireVue.terminer.setEnabled(true);
				}
				questionnaireVue.qprec.setEnabled(true);
				questionnaireVue.qprem.setEnabled(true);
				
				// ajoute la reponse au dictionnaire de reponse si elle existe
				this.AjoutValeur(questionnaireVue);
				
				// on change la vue
				questionnaireVue.ChangerQuestion(questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.questionVue.question.getNumQ())); 
				break;
				
			case "prem": 

				questionnaireVue.qprec.setEnabled(false);
				questionnaireVue.qprem.setEnabled(false);
				questionnaireVue.qsuiv.setEnabled(true);
				questionnaireVue.qder.setEnabled(true);
				this.AjoutValeur(questionnaireVue);	
				questionnaireVue.ChangerQuestion( questionnaireVue.module.questionnaire.getListeQuestions().get(0));
				break;
				
			case "dern":
				
				questionnaireVue.qsuiv.setEnabled(false);
				questionnaireVue.qder.setEnabled(false);
				questionnaireVue.qprec.setEnabled(true);
				questionnaireVue.qprem.setEnabled(true);
				questionnaireVue.terminer.setEnabled(true);
				this.AjoutValeur(questionnaireVue);	
				questionnaireVue.ChangerQuestion( questionnaireVue.module.questionnaire.getListeQuestions().get(questionnaireVue.module.questionnaire.getListeQuestions().size()-1));
				break;				
			
			case "suivi":
				modsond.modif();
				break;
				
			case "appeler":
				BoiteDialogue bt=new BoiteDialogue(5000);
				bt.start();
				Icon tel = new ImageIcon("Ressources/tel.png");
				Object[] options = {"Annuler" };
				bt.showOptionDialog(null,"Appel en cours ...", "Appel",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,tel, options, options[0]);
				break;
				
			case "term":
				this.AjoutValeur(questionnaireVue);
				if ( questionnaireVue.module.questionnaire.getListeReponses().size() != questionnaireVue.module.questionnaire.getListeQuestions().size()){
						questionnaireVue.TerminerQuestionnaireError();
					}
				else {
					questionnaireVue.module.QBD.ajouterReponses(questionnaireVue.module.questionnaire, questionnaireVue.module.sonde.getIdC());
					
					// ATTENTION suprime le sonde de la liste interoger
					questionnaireVue.module.info.supprimerSonde(questionnaireVue.module.sonde.getNumSond());
					questionnaireVue.module.modif();
				}
					break;
			}
			
	}
	
	/**
	 * @param Un QuestionnaireVue
	 * Ajoute la reponce au dictionnaire de reponse, si cette derniere est valide
	 */		
	public String AjoutValeur(QuestionnaireVue q) {
		
		QuestionVue questionVue = questionnaireVue.questionVue;
		String res ="";
		
		switch ( questionVue.typeQuestion) {

			case 'n':
				if ( ((PropositionChoixNote) questionVue.choix).val != null)
					res+= ((PropositionChoixNote) questionnaireVue.questionVue.choix).val.toString();
				break;
				
			case 'u':
				if ( ((PropositionChoix1) questionVue.choix).listePropositions.getSelectedValue() != null)
					res+= ((PropositionChoix1) questionVue.choix).listePropositions.getSelectedValue().toString() ;
				break;
				
				
			case 'l':
					// on parcourt la JListe des propostion et si elle contien un element selectionner, on l'ajoute au dictionnaire de reponse
				if (( ((PropositionChoixLibre) questionVue.choix).listePropositions.getSelectedValue() != null) && ((PropositionChoixLibre) questionVue.choix).marep.getText().equals(""))
					res+= ((PropositionChoixLibre) questionVue.choix).listePropositions.getSelectedValue().toString();
				
					// sinon on regarde si le champ de texte a ete rempli
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
				// avant tout ajout, on verifie qu'il n'y a pas de valeur null, ni de champVide a ajouté
			if (!res.equals("") && !res.contains("null"))
				questionnaireVue.module.questionnaire.ajouterReponse(questionnaireVue.questionVue.numQuestion, res);
		return res;
	}

}
