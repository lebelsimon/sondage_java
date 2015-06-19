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
	private JButton btnModifier;
	public boolean visible;
	public Analyse_Questionnaire() {
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
		
		String categories[] = { "Questionnaire 1", "Questionnaire 2", "Questionnaire3",
		        "Questionnaire 3", "Questionnaire 4", "Questionnaire 5", "Questionnaire 6"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 154, 698, 181);
		getContentPane().add(scrollPane);
		
		JList<String> list = new JList<String>(categories);
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


