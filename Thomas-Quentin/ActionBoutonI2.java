import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ActionBoutonI2 implements ActionListener{
    Analyse_Tableau i;
    
    public ActionBoutonI2(Analyse_Tableau i){
		this.i=i;
    }
    public void actionPerformed(ActionEvent arg0){
    	JButton b = (JButton)arg0.getSource();
        //JRadioButton rb =(JRadioButton)arg0.getSource();
    	
    	if (b.getName()=="Graphique"){
    		i.dispose();
    		Analyse_Graphique j=new Analyse_Graphique(i.Nom_Questionnaire,i.Indice_Question,i.socio);}
    	else if(b.getName()=="Retour"){
    		i.dispose();
    		Analyse_Questionnaire k=new Analyse_Questionnaire(new ConnexionMySQL("jdbc:mysql://servinfo-db:3306/","dbdmartin","dbdmartin","/home/dmartin"));}
    	else if(b.getName()=="Suivant"){
            try{
            i.dispose();
            
            Analyse_Tableau l=new Analyse_Tableau(i.Nom_Questionnaire,i.Indice_Question+1,i.socio);}
            catch(ArrayIndexOutOfBoundsException e){}
        }
        else if(b.getName()=="PDF"){
            Analyse_pdf p=new Analyse_pdf(i.Nom_Questionnaire);
        }
        // else if(i.rdbtnAge.getSelected()){
        //     i.dispose();
        //     Analyse_Tableau l=new Analyse_Tableau(i.Nom_Questionnaire,i.Indice_Question,false);
        //     //l.socio=false;

        // }
        // else if(i.rdbtnCategorieSociopro.getSelected()){
        //     i.dispose();
        //     Analyse_Tableau l=new Analyse_Tableau(i.Nom_Questionnaire,i.Indice_Question,true);
        //     //l.socio=true;

        // }
        

        
    	
    }
}
//NullPointerException
//ArrayIndexOutOfBoundsException