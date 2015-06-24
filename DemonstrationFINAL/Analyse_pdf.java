import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.Canvas;


public class Analyse_pdf extends JFrame {
	String Nom_Questionnaire;
	public Analyse_pdf(String Nom_Questionnaire) {
		this.Nom_Questionnaire=Nom_Questionnaire;
		this.setTitle("Rapid'Sond | Analyse");
		this.setSize(800,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fond f = new Fond();
		this.setContentPane(f);
		getContentPane().setLayout(null);
		
		String categories[] = { "Household", "Office", "Extended Family",
		        "Company (US)", "Company (World)", "Team", "Will",
		        "Birthday Card List", "High School", "Country", "Continent",
		        "Planet" };
		
		JPanel panel = new JPanel();
		panel.setBounds(134, 83, 498, 431);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setBounds(134, 50, 498, 34);
		
		JLabel VosQuest = new JLabel("Questionnaire : "+Nom_Questionnaire);
		panel_1.add(VosQuest);
		VosQuest.setHorizontalAlignment(SwingConstants.CENTER);
		VosQuest.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(134, 65, 237, 180);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblQuestionsAnalyses = new JLabel("Question 1 ");
		lblQuestionsAnalyses.setBounds(39, 44, 158, 19);
		panel_2.add(lblQuestionsAnalyses);
		lblQuestionsAnalyses.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionsAnalyses.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblQuestion = new JLabel("Question 2 ");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuestion.setBounds(39, 74, 158, 19);
		panel_2.add(lblQuestion);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 0, 19, 431);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel labelModifier = new JLabel("Envoyer");
		labelModifier.setBounds(176, 329, 146, 22);
		panel.add(labelModifier);
		labelModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelModifier.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnModifier = new JButton("");
		btnModifier.setBounds(176, 268, 146, 62);
		panel.add(btnModifier);
		btnModifier.setIcon(new ImageIcon("../Ressources/send2.png"));
		
		JButton btnRetour = new JButton("");
		btnRetour.setName("Retour");
		btnRetour.setBounds(17, 353, 91, 44);
		panel.add(btnRetour);
		btnRetour.addActionListener(new ActionBoutonPDF(this));
		btnRetour.setIcon(new ImageIcon("../Ressources/retourback.png"));
		
		JLabel lblRetour = new JLabel("Retour");
		lblRetour.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetour.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRetour.setBounds(17, 398, 91, 22);
		panel.add(lblRetour);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(134, 38, 237, 28);
		panel.add(panel_3);
		
		JLabel label_1 = new JLabel("Question 1 ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(39, 44, 158, 19);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("Question 2 ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(39, 74, 158, 19);
		panel_3.add(label_2);
		
		JLabel label = new JLabel("Questions analys\u00E9es ");
		label.setBounds(39, 5, 158, 17);
		panel_3.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		
		this.setJMenuBar(new Menu(this));
		
		
		// END

		this.setVisible(true);
	}


			

		// public static void main(String[] args) {
		// 	Analyse_pdf Appli = new Analyse_pdf();
		// 	}
	}


