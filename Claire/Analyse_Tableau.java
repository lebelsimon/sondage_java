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
	//public boolean visible;
	Analyse_Tableau(){
		this.setSize(800,600);
		this.setResizable(false);
		this.setTitle("Appli RapidSond");
		getContentPane().setLayout(null);
			
		JPanel panel = new JPanel();
		panel.setBounds(39, 41, 718, 19);
		getContentPane().add(panel);
		
		JLabel lblQuestionnaire = new JLabel("Questionnaire n: 01");
		panel.add(lblQuestionnaire);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 60, 718, 415);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQuestionN = new JLabel("Question n\u00B0: 01/02");
		lblQuestionN.setBounds(20, 30, 159, 14);
		panel_1.add(lblQuestionN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(498, 56, 190, 67);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnAge = new JRadioButton("Age");
		rdbtnAge.setBounds(-2, 5, 121, 23);
		rdbtnAge.setSelected(true);
		panel_2.add(rdbtnAge);
		
		JRadioButton rdbtnCategorieSociopro = new JRadioButton("Categorie Socio-pro");
		rdbtnCategorieSociopro.setBounds(-2, 33, 167, 28);
		panel_2.add(rdbtnCategorieSociopro);
		
		txtEntrezVotreCommentaire = new JTextField();
		txtEntrezVotreCommentaire.setText("Entrez votre commentaire");
		txtEntrezVotreCommentaire.setBounds(498, 231, 190, 147);
		panel_1.add(txtEntrezVotreCommentaire);
		txtEntrezVotreCommentaire.setColumns(1);
		
		JLabel lblNomquestion = new JLabel("NOM_Question");
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
				{null, null, null, null, null, null, null, null}
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(0, 0, 434, 312);
		panel_3.add(table);
		
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
		

		JButton btnSuiv = new JButton("");
		btnSuiv.setName("Suivant");
		btnSuiv.setBounds(653, 496, 104, 43);
		getContentPane().add(btnSuiv);
		btnSuiv.setIcon(new ImageIcon("../Ressources/suivant1.png"));
		btnSuiv.addActionListener(new ActionBoutonI2(this));
		btnSuiv.setToolTipText("Suivant");
		ButtonGroup choixOption = new ButtonGroup();
		choixOption.add(rdbtnAge);
		choixOption.add(rdbtnCategorieSociopro);
		
		this.setJMenuBar(new Menu(this));
		this.setVisible(true);

	}
	public static void main(String[] args) {
		Analyse_Tableau Appli = new Analyse_Tableau();
		}
}
