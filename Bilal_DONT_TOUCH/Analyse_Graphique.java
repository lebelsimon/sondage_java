import javax.swing.*;

import java.awt.Color;
import javax.swing.JPanel;
// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.JFreeChart;
// import org.jfree.chart.plot.PiePlot;
// import org.jfree.chart.plot.Plot;
// import org.jfree.data.general.DefaultPieDataset;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;

public class Analyse_Graphique extends JFrame {
	private JTable table;
	Analyse_Graphique(){
		this.setSize(800,600);
		this.setResizable(false);
		this.setTitle("Appli RapidSond");
		getContentPane().setLayout(null);
			
		JPanel panel = new JPanel();
		panel.setBounds(39, 39, 718, 23);
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
		panel_2.setBounds(547, 98, 121, 92);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnCirculaire = new JRadioButton("Circulaire");
		rdbtnCirculaire.setBounds(-2, 5, 112, 23);
		rdbtnCirculaire.setSelected(true);
		panel_2.add(rdbtnCirculaire);
		
		JRadioButton rdbtnBaton = new JRadioButton("B\u00E2tons");
		rdbtnBaton.setBounds(-2, 33, 121, 23);
		panel_2.add(rdbtnBaton);
		
		JRadioButton rdbtnCourbe = new JRadioButton("Courbe");
		rdbtnCourbe.setBounds(-2, 59, 121, 23);
		panel_2.add(rdbtnCourbe);
		
		JButton btnTableau = new JButton("");
		btnTableau.setName("Tableau");
		btnTableau.setBounds(547, 238, 121, 45);
		panel_1.add(btnTableau);
		btnTableau.setIcon(new ImageIcon("../Ressources/tableau2.png"));

		btnTableau.addActionListener(new ActionBoutonI3(this));
		
		JLabel lblTableauBrut = new JLabel("Tableau brut");
		lblTableauBrut.setBounds(562, 294, 100, 20);
		panel_1.add(lblTableauBrut);
		
		JLabel label = new JLabel("NOM_Question");
		label.setBounds(155, 30, 333, 14);
		panel_1.add(label);
        
        JButton button = new JButton("");
        button.setName("Retour");
        button.setIcon(new ImageIcon("../Ressources/retoutpetit.png"));
        button.setBounds(39, 496, 104, 43);
        getContentPane().add(button);
        
        button.setToolTipText("Retour");
                
                
        JButton btnSuivant = new JButton("");
        btnSuivant.setBounds(657, 486, 104, 44);
        getContentPane().add(btnSuivant);
                btnSuivant.setIcon(new ImageIcon("../Ressources/suivant1.png"));
        btnSuivant.setToolTipText("Suivant");
        button.addActionListener(new ActionBoutonI3(this));
		
		ButtonGroup choixOption = new ButtonGroup();
		choixOption.add(rdbtnCourbe);
		choixOption.add(rdbtnBaton);
		choixOption.add(rdbtnCirculaire);
		
		this.setJMenuBar(new Menu(this));
		this.setVisible(true);

	}
	public static void main(String[] args) {
		Analyse_Graphique Appli = new Analyse_Graphique();
		}
}
