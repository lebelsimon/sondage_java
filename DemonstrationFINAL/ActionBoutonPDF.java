import java.awt.event.*;

import javax.swing.JButton;

public class ActionBoutonPDF implements ActionListener{
    Analyse_pdf i;
    

    public ActionBoutonPDF(Analyse_pdf i){
		this.i=i;
        
    }
    public void actionPerformed(ActionEvent arg0){
    	JButton b = (JButton)arg0.getSource();
    	
    	if (b.getName()=="Retour"){
            i.dispose();
    		//i.setVisible(false);
    		Analyse_Questionnaire j=new Analyse_Questionnaire(new ConnexionMySQL("jdbc:mysql://servinfo-db:3306/","dbdmartin","dbdmartin","/home/dmartin"));

    		
    	}
    }
}

//i.total.get(i.list.getSelectedValue()).getQuestion(0))