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
    		i.dispose();
    		Analyse_Tableau j=new Analyse_Tableau(i.Nom_Questionnaire,i.Indice_Question,i.socio);
        }
    	else if(b.getName()=="Retour"){
    		i.dispose();
    		Analyse_Questionnaire k=new Analyse_Questionnaire(new ConnexionMySQL("jdbc:mysql://servinfo-db:3306/","dbdmartin","dbdmartin","/home/dmartin"));
        }
        else if(b.getName()=="Suivante"){
            try{
            i.dispose();
            Analyse_Graphique l=new Analyse_Graphique(i.Nom_Questionnaire,i.Indice_Question+1,i.socio);}
            catch(ArrayIndexOutOfBoundsException e){}
        }
        else if(b.getName()=="PDF"){
            Analyse_pdf p=new Analyse_pdf(i.Nom_Questionnaire);
        }
    		
    	
    }
}
