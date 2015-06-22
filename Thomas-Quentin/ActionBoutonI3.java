import java.awt.event.*;

import javax.swing.JButton;

public class ActionBoutonI3 implements ActionListener{
    Analyse_Graphique i;
    
    public ActionBoutonI3(Analyse_Graphique i){
		this.i=i;
    }
    public void actionPerformed(ActionEvent arg0){
    	JButton b = (JButton)arg0.getSource();
    	
    	if (b.getName()=="Tableau"){
    		i.setVisible(false);
    		Analyse_Tableau j=new Analyse_Tableau(i.Nom_Questionnaire,i.Indice_Question);
        }
    	else if(b.getName()=="Retour"){
    		i.setVisible(false);
    		Analyse_Questionnaire k=new Analyse_Questionnaire();
        }
        else if(b.getName()=="Suivante"){
            try{
            i.setVisible(false);
            Analyse_Graphique l=new Analyse_Graphique(i.Nom_Questionnaire,i.Indice_Question+1);}
            catch(ArrayIndexOutOfBoundsException e){}
        }
        else if(b.getName()=="PDF"){
            Analyse_pdf p=new Analyse_pdf();
        }
    		
    	
    }
}
