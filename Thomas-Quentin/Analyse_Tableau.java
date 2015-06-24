import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class Analyse_Tableau extends JFrame {
	private JTextField txtEntrezVotreCommentaire;
	//private JTable table;
	public String Nom_Questionnaire;
	public int Indice_Question;
	public Analyse_Questionnaire Aq;
	public boolean socio;
	public JRadioButton rdbtnAge;
	public JRadioButton rdbtnCategorieSociopro;
	public ButtonGroup groupeRadioBouton;
	public int cptA, cptS;
	public ReponseBD rbd;
	//public boolean visible;
	Analyse_Tableau(String Nom_Questionnaire,int Indice_Question,boolean socio){
		Aq=new Analyse_Questionnaire();
		int indicebis=Indice_Question+1;
		this.Indice_Question=Indice_Question;
		this.Nom_Questionnaire=Nom_Questionnaire;
		this.socio=socio;
		try{
			rbd=new ReponseBD(Aq.co);
		}
		catch(SQLException e){System.out.println(e);}
		cptA=0;
		cptS=0;
		//boolean age = !socio;
		this.setSize(800,600);
		this.setResizable(false);
		this.setTitle("Appli RapidSond");
		getContentPane().setLayout(null);
			
		JPanel panel = new JPanel();
		panel.setBounds(39, 41, 718, 19);
		getContentPane().add(panel);
		
		JLabel lblQuestionnaire = new JLabel("Questionnaire : "+Nom_Questionnaire);
		panel.add(lblQuestionnaire);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 60, 718, 415);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblQuestionN = new JLabel("Question 0"+indicebis+"/0"+Aq.total.get(Nom_Questionnaire).getListeQuestions().size()+" : ");
		lblQuestionN.setBounds(20, 30, 159, 14);
		panel_1.add(lblQuestionN);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(498, 56, 190, 67);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		// on crée le groupe de radiobouton
		groupeRadioBouton = new ButtonGroup();
		
		rdbtnAge = new JRadioButton("Age");
		rdbtnAge.setName("Age");
		rdbtnAge.setBounds(-2, 5, 121, 23);
		rdbtnAge.setSelected(true);
		//rdbtnAge.addActionListener(new ActionBoutonI2(this));

		rdbtnAge.addActionListener(new ActionRadioButton(this, "age","tab"));
		groupeRadioBouton.add(rdbtnAge);
		panel_2.add(rdbtnAge);
		
		rdbtnCategorieSociopro = new JRadioButton("Categorie Socio-pro");
		rdbtnCategorieSociopro.setName("Socio");
		rdbtnCategorieSociopro.setBounds(-2, 33, 167, 28);
		//rdbtnCategorieSociopro.addActionListener(new ActionBoutonI2(this));

		groupeRadioBouton.add(rdbtnCategorieSociopro);
		rdbtnCategorieSociopro.addActionListener(new ActionRadioButton(this, "cat", "tab"));
		panel_2.add(rdbtnCategorieSociopro);

		
		txtEntrezVotreCommentaire = new JTextField();
		txtEntrezVotreCommentaire.setText("Entrez votre commentaire");
		txtEntrezVotreCommentaire.setBounds(498, 231, 190, 147);
		panel_1.add(txtEntrezVotreCommentaire);
		txtEntrezVotreCommentaire.setColumns(1);
		
		JLabel lblNomquestion = new JLabel(Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getTexteQuestion());
		lblNomquestion.setBounds(155, 30, 333, 14);
		panel_1.add(lblNomquestion);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 55, 444, 323);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setToolTipText("");
		scrollPane_1.setBounds(425, 0, 19, 305);
		panel_3.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(0, 304, 444, 19);
		panel_3.add(scrollPane_2);
		
		panel_3.add(this.tableau(socio));
		
		JLabel lblGraphique = new JLabel("Graphique");
		lblGraphique.setBounds(557, 188, 100, 20);
		panel_1.add(lblGraphique);
		
		JButton btnGraphique = new JButton("");
		btnGraphique.setName("Graphique");
		btnGraphique.setIcon(new ImageIcon("../Ressources/graphique.png"));
		btnGraphique.setBounds(543, 130, 102, 53);
		panel_1.add(btnGraphique);
		btnGraphique.addActionListener(new ActionBoutonI2(this));
		
		JButton btnRetour = new JButton("");
        btnRetour.setName("Retour");
        btnRetour.setIcon(new ImageIcon("../Ressources/retoutpetit.png"));
        btnRetour.setBounds(39, 496, 104, 43);
        getContentPane().add(btnRetour);
        btnRetour.setToolTipText("Retour");
        btnRetour.addActionListener(new ActionBoutonI2(this));
		
        if (indicebis != Aq.total.get(Nom_Questionnaire).getListeQuestions().size()){
		JButton btnSuiv = new JButton("");
		btnSuiv.setName("Suivant");
		btnSuiv.setBounds(653, 496, 104, 43);
		getContentPane().add(btnSuiv);
		btnSuiv.setIcon(new ImageIcon("../Ressources/suivant1.png"));
		btnSuiv.addActionListener(new ActionBoutonI2(this));
		btnSuiv.setToolTipText("Suivant");}
		else{
			JButton btnPDF = new JButton("");
		btnPDF.setName("PDF");
		btnPDF.setBounds(653, 496, 104, 43);
		getContentPane().add(btnPDF);
		btnPDF.setIcon(new ImageIcon("../Ressources/pdf1.png"));
		btnPDF.addActionListener(new ActionBoutonI2(this));
		btnPDF.setToolTipText("Envoyer PDF");
		}



		ButtonGroup choixOption = new ButtonGroup();
		choixOption.add(rdbtnAge);
		choixOption.add(rdbtnCategorieSociopro);
		
		//this.setJMenuBar(new Menu());
		this.setVisible(true);

	}
	// public static void main(String[] args) {
	// 	Analyse_Tableau Appli = new Analyse_Tableau(list.getSelectedValue());
	// 	}

	public JTable tableau(boolean socio){
		JTable table=new JTable();
		int ligneMax;
		if (!socio){
		rdbtnAge.setSelected(true);
				table.setModel(new DefaultTableModel(new String[Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getPropositions().size()+2][8],new String[] {"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"}));
			
			if(Character.toString(Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getIdT())=="n"){
				ligneMax=Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getMaxVal();
				
			}
			else{
				ligneMax=Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getPropositions().size();
			}
			for(int i=0;i<ligneMax+2;i++){
				for(int j=0;j<8;j++){
					if(i==0){
						switch(j){
							case 0:table.setValueAt("Age",i,j);break;
							case 1:table.setValueAt("20-30",i,j);break;
							case 2:table.setValueAt("30-40",i,j);break;
							case 3:table.setValueAt("40-50",i,j);break;
							case 4:table.setValueAt("50-60",i,j);break;
							case 5:table.setValueAt("60-70",i,j);break;
							case 6:table.setValueAt("70+",i,j);break;
							case 7:table.setValueAt("Total",i,j);break;
						}
					}

					if(i>0){
						// System.out.println(Character.toString(Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getIdT()));
						// System.out.println(Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getMaxVal());
						// System.out.println(Aq.list.getSelectedIndex());
						// System.out.println(Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question));
						//System.out.println(Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getIdT());
						try{
						table.setValueAt(rbd.getReponsesParAge(Aq.list.getSelectedIndex(),Indice_Question,Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getIdT())[i][j],i+1,j+1);}
						catch(NullPointerException e){}
					}
					if(i==Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getPropositions().size()+1){
						switch(j){
							case 0:table.setValueAt("Total",i,j);break;
						}
					}
				}
			}
		table.setBounds(0, 0, 434, 312);
		
		}
		if (socio){
			rdbtnCategorieSociopro.setSelected(true);
			table.setModel(new DefaultTableModel(
			new Object[Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getPropositions().size()+2][8],new Object[] {"pouet", "New column", "New column", "New column", "New column", "New column", "New column", "New column"}));
			for(int i=0;i<Aq.total.get(Nom_Questionnaire).getQuestion(Indice_Question).getPropositions().size()+2;i++){
				for(int j=0;j<8;j++){
					if(i==0){
						switch(j){
							case 0:table.setValueAt("Socio-pro",i,j);break;
							case 1:table.setValueAt("Agri",i,j);break;
							case 2:table.setValueAt("Artis",i,j);break;
							case 3:table.setValueAt("Cadres",i,j);break;
							case 4:table.setValueAt("Ouvriers",i,j);break;
							case 5:table.setValueAt("Employés",i,j);break;
							case 6:table.setValueAt("Autres",i,j);break;
							case 7:table.setValueAt("Total",i,j);break;
						}

					}
				}
			}
		
		table.setBounds(0, 0, 434, 312);
		
		}
		return table;

	}

}
