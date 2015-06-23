import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Component;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ActionRadioButton implements ActionListener{
	Analyse_Tableau t;
	Analyse_Graphique g;
	String type, page;
	

	public ActionRadioButton(Analyse_Tableau t, String type,String page){
		this.t=t;
		this.type=type;
		this.page=page;
	}

	public ActionRadioButton(Analyse_Graphique g, String type){
		this.g=g;
		this.type=type;
	}

	@Override
	public void actionPerformed(ActionEvent arg0){
			if(page=="tab"){

				switch(this.type){
					case "age": 
						if(t.cptS==0){
							t.setVisible(false);
							Analyse_Tableau at=new Analyse_Tableau(t.Nom_Questionnaire,t.Indice_Question,false);
							page="";
							at.cptS+=1;
							t.cptA=0;} 
						break;
					case "cat": 
						if(t.cptA==0){
							t.setVisible(false);
							Analyse_Tableau at2=new Analyse_Tableau(t.Nom_Questionnaire,t.Indice_Question,true);
							page="";
							at2.cptA+=1;
							t.cptS=0;}
						break;
				}
			}
			// else
			// 	switch(this.type){
			// 		case "age": t.socio=false; break;
			// 		case "cat": t.socio=true; break;	
			// 	}
	}
}