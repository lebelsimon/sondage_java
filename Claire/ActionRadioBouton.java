import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class ActionRadioBouton implements ActionListener,FocusListener{
	
	static final int SIMPLE=0;
	static final int MULTIPLE=1;
	static final int CLASSEMENT=2;
	static final int NOTE=3;
	static final int LIBRE=4;
	
	
	VueSaisieQuestion formulaireQuestion; // la vue
	
	int idBouton;
	
	public ActionRadioBouton(String nomBouton, VueSaisieQuestion vue) {
		super();
		this.formulaireQuestion=vue;
		switch (nomBouton){
		case "Simple": this.idBouton=SIMPLE;break;
		case "Multiple": this.idBouton=MULTIPLE;break;
		case "Classement": this.idBouton=CLASSEMENT;break;
		case "Note": this.idBouton=NOTE;break;
		case "Libre": this.idBouton=LIBRE;break;
		default: this.idBouton=-1;
		}
	}

	// methodes utilitaires pour les boutons
	private void simple(){
		formulaireQuestion.question.setIdT('u');
	}
	
	private void multiple(){
		formulaireQuestion.question.setIdT('m');
		formulaireQuestion.question.setMaxVal(formulaireQuestion.question.getPropositions().getSize());
	}
	
	private void classement(){
		formulaireQuestion.question.setIdT('c');
		formulaireQuestion.question.setMaxVal(3);
	}
	
	private void note(){
		formulaireQuestion.question.setIdT('n');
		formulaireQuestion.question.setMaxVal(10);
	}
	
	private void libre(){
		formulaireQuestion.question.setIdT('l');
	}

	@Override
	public void focusGained(FocusEvent arg0) {}

	@Override
	public void focusLost(FocusEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (idBouton){
		case SIMPLE: simple();break;
		case MULTIPLE: multiple();break;
		case CLASSEMENT: classement();break;
		case NOTE: note();break;
		case LIBRE: libre();break;
		

		
	}
		
	}
		
	
	

}
