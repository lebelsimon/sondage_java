import javax.swing.JFrame;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Canvas;
import java.util.ArrayList;
import java.sql.*;
import java.util.HashMap;

public class Analyse_Questionnaire extends JFrame {
	private JButton btnModifier;
	public boolean visible;
	public ConnexionMySQL co;
	public QuestionnaireBD qbd;
	public JList<String> list;
	public HashMap<String,Questionnaire> total;
	public Analyse_Questionnaire() {
		co=new ConnexionMySQL("jdbc:mysql://servinfo-db:3306/","dbdmartin","dbdmartin","/home/dmartin");
		
		this.visible=true;
		this.setTitle("Rapid Sond'");
		this.setSize(800,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
//		JPanel Fenetre = new JPanel();
//		Fenetre.setLayout(new GridLayout());
		// Panel Menu
		
//		JPanel Menu = new JPanel();
//		Menu.setLayout(new FlowLayout());
		try{qbd=new QuestionnaireBD(co);}
		catch(SQLException e){}
		
		JButton btnDeco = new JButton("");
		btnDeco.setName("Deco");
		btnDeco.setIcon(new ImageIcon("../Ressources/gnome-logout-icone-4756-48.png"));
		btnDeco.setBounds(648, 11, 104, 62);
		getContentPane().add(btnDeco);
		btnDeco.addActionListener(new ActionBoutonI1(this));
		
		
		JButton btnAnalyse = new JButton("");
		btnAnalyse.setName("Analyse");
		btnAnalyse.setIcon(new ImageIcon("../Ressources/analyse.png"));
		btnAnalyse.setBounds(326, 358, 146, 62);
		getContentPane().add(btnAnalyse);
		btnAnalyse.addActionListener(new ActionBoutonI1(this));
		
		JLabel VosQuest = new JLabel("Vos questionnaires");
		VosQuest.setHorizontalAlignment(SwingConstants.CENTER);
		VosQuest.setFont(new Font("Tahoma", Font.BOLD, 15));
		VosQuest.setBounds(44, 109, 698, 22);
		getContentPane().add(VosQuest);
		
		//System.out.println("entrez boucle");
		DefaultListModel<String> Liste=new DefaultListModel<String>();
		//ArrayList<String> liste=new ArrayList<String>();
		total=new HashMap<String,Questionnaire>();
		for(Questionnaire q: qbd.getListeQuestionnaire(1,"Sondeur")){
			Liste.addElement(q.getTitreQuestionnaire());
			total.put(q.getTitreQuestionnaire(),q);
			System.out.println(total);
			//System.out.println(Liste);
		}
		// String categories[] = { "Questionnaire 1", "Questionnaire 2", "Questionnaire3",
		//         "Questionnaire 3", "Questionnaire 4", "Questionnaire 5", "Questionnaire 6"};
		//System.out.println("sortie boucle");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 154, 698, 181);
		getContentPane().add(scrollPane);
		
		list = new JList<String>(Liste);
		
		scrollPane.setViewportView(list);
		list.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		
		JLabel labelModifier = new JLabel("Analyser");
		labelModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelModifier.setHorizontalAlignment(SwingConstants.CENTER);
		labelModifier.setBounds(326, 424, 146, 22);
		getContentPane().add(labelModifier);
		
		JLabel labelDeco = new JLabel("Deconnexion");
		labelDeco.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeco.setBounds(648, 76, 104, 22);
		getContentPane().add(labelDeco);
	
		
		
		this.setJMenuBar(new Menu());
		
		
		// END

		this.setVisible(this.visible);
	}


			

		public static void main(String[] args) {
			Analyse_Questionnaire Appli = new Analyse_Questionnaire();
			}
		
	public Icon getBtnModifierIcon() {
		return btnModifier.getIcon();
	}
	public void setBtnModifierIcon(Icon icon) {
		btnModifier.setIcon(icon);
	}

	}


