import javax.swing.JFrame;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Canvas;


public class Analyse_Questionnaire extends JFrame {
	public Analyse_Questionnaire() {
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
		
		
		JButton btnDeco = new JButton("");
		btnDeco.setIcon(new ImageIcon("../Ressources/gnome-logout-icone-4756-48.png"));
		btnDeco.setBounds(648, 11, 104, 62);
		getContentPane().add(btnDeco);
		
		JButton btnModifier = new JButton("");
		btnModifier.setIcon(new ImageIcon("../Ressources/bloc-notes-stylo-ecrire-icone-8970-48.png"));
		btnModifier.setBounds(326, 358, 146, 62);
		getContentPane().add(btnModifier);
		
		JLabel VosQuest = new JLabel("Vos questionnaires");
		VosQuest.setHorizontalAlignment(SwingConstants.CENTER);
		VosQuest.setFont(new Font("Tahoma", Font.BOLD, 15));
		VosQuest.setBounds(44, 109, 698, 22);
		getContentPane().add(VosQuest);
		
		String categories[] = { "Household", "Office", "Extended Family",
		        "Company (US)", "Company (World)", "Team", "Will",
		        "Birthday Card List", "High School", "Country", "Continent",
		        "Planet" };
		
		JList<String> list = new JList<String>(categories);
		list.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		list.setBounds(44, 154, 698, 181);
		getContentPane().add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(740, 154, 19, 181);
		//~ scrollPane.add(list);
		getContentPane().add(scrollPane);
		
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

		this.setVisible(true);
	}


			

		public static void main(String[] args) {
			Analyse_Questionnaire Appli = new Analyse_Questionnaire();
			}
		
	}


