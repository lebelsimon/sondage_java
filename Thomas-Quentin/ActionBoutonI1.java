import java.awt.event.*;

import javax.swing.JButton;

public class ActionBoutonI1 implements ActionListener{
    Analyse_Questionnaire i;
    
    public ActionBoutonI1(Analyse_Questionnaire i){
		this.i=i;
    }
    public void actionPerformed(ActionEvent arg0){
    	JButton b = (JButton)arg0.getSource();
    	
    	if (b.getName()=="Analyse"){
    		i.setVisible(false);
    		Analyse_Tableau j=new Analyse_Tableau(i.list.getSelectedValue(),0);}
    	else if(b.getName()=="Deco"){
    		System.exit(0);
    		
    	}
    }
}

//i.total.get(i.list.getSelectedValue()).getQuestion(0))