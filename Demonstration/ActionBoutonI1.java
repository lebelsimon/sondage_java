import java.awt.event.*;

import javax.swing.JButton;

public class ActionBoutonI1 implements ActionListener{
    Analyse_Questionnaire i;
    ConnexionMySQL co;

    public ActionBoutonI1(Analyse_Questionnaire i,ConnexionMySQL co){
		this.i=i;
        this.co=co;
    }
    public void actionPerformed(ActionEvent arg0){
    	JButton b = (JButton)arg0.getSource();
    	
    	if (b.getName()=="Analyse"){
    		i.setVisible(false);
    		Analyse_Tableau j=new Analyse_Tableau(i.list.getSelectedValue(),0,false);}
    	else if(b.getName()=="Deco"){
    		//System.exit(0);
            i.dispose();
            Connexion c=new Connexion(co);

    		
    	}
    }
}

//i.total.get(i.list.getSelectedValue()).getQuestion(0))