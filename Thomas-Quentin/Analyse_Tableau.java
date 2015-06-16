import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;

public class Analyse_Tableau extends JFrame {
	private JTextField txtEntrezVotreCommentaire;
	private JTable table;
	Analyse_Tableau(){
		this.setSize(500,400);
		this.setResizable(false);
		this.setTitle("Appli RapidSond");
		getContentPane().setLayout(null);
			
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 464, 19);
		getContentPane().add(panel);
		
		JLabel lblQuestionnaire = new JLabel("Questionnaire n°: 01");
		panel.add(lblQuestionnaire);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 29, 464, 293);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQuestionN = new JLabel("Question n\u00B0: 01/02");
		lblQuestionN.setBounds(20, 30, 92, 14);
		panel_1.add(lblQuestionN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(323, 30, 116, 68);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Age");
		rdbtnNewRadioButton.setBounds(-2, 5, 45, 23);
		rdbtnNewRadioButton.setSelected(true);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnCategorieSociopro = new JRadioButton("Categorie Socio-pro");
		rdbtnCategorieSociopro.setBounds(-2, 33, 121, 23);
		panel_2.add(rdbtnCategorieSociopro);
		
		JButton btnGraphique = new JButton("Graphique");
		btnGraphique.setBounds(333, 109, 89, 23);
		panel_1.add(btnGraphique);
		
		txtEntrezVotreCommentaire = new JTextField();
		txtEntrezVotreCommentaire.setText("Entrez votre commentaire");
		txtEntrezVotreCommentaire.setBounds(323, 143, 116, 113);
		panel_1.add(txtEntrezVotreCommentaire);
		txtEntrezVotreCommentaire.setColumns(1);
		
		// JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setToolTipText("");
		// scrollPane.setBounds(445, 0, 19, 293);
		// panel_1.add(scrollPane);
		// scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel lblNomquestion = new JLabel("NOM_Question");
		lblNomquestion.setBounds(127, 30, 100, 14);
		panel_1.add(lblNomquestion);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 55, 287, 227);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setToolTipText("");
		scrollPane_1.setBounds(268, 0, 19, 210);
		panel_3.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(0, 210, 268, 16);
		panel_3.add(scrollPane_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(0, 0, 267, 208);
		panel_3.add(table);
		
		JButton btnSuivant = new JButton("Retour");
		btnSuivant.setBounds(20, 327, 89, 23);
		getContentPane().add(btnSuivant);
		

		JLabel labelSuiv = new JLabel("Suiv");
		labelSuiv.setHorizontalAlignment(SwingConstants.CENTER);
		labelSuiv.setBounds(648, 76, 104, 22);
		getContentPane().add(labelSuiv);
		

		JButton btnSuiv = new JButton("Question suivante");
		btnSuiv.setBounds(335, 327, 126, 23);
		getContentPane().add(btnSuiv);
		btnSuiv.setIcon(new ImageIcon("../Ressources/gnome-logout-icone-4756-48.png"));
		
		ButtonGroup choixOption = new ButtonGroup();
		choixOption.add(rdbtnNewRadioButton);
		choixOption.add(rdbtnCategorieSociopro);
		//panel_2.add(choixOption);

		this.setJMenuBar(new Menu());
		this.setVisible(true);

	}
	public static void main(String[] args) {
		Analyse_Tableau Appli = new Analyse_Tableau();
		}
}
