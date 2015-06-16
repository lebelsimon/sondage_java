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
	private JTextField text;
	private JTable table;
	Analyse_Graphique(){
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
		
		text = new JTextField();
		text.setText("Nom_Question");
		text.setBounds(122, 27, 116, 20);
		panel_1.add(text);
		text.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(307, 71, 127, 93);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Circulaire");
		rdbtnNewRadioButton.setBounds(-2, 5, 112, 23);
		rdbtnNewRadioButton.setSelected(true);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnCategorieSociopro = new JRadioButton("B\u00E2tons");
		rdbtnCategorieSociopro.setBounds(-2, 33, 121, 23);
		panel_2.add(rdbtnCategorieSociopro);
		
		JRadioButton rdbtnCourbe = new JRadioButton("Courbe");
		rdbtnCourbe.setBounds(-2, 59, 121, 23);
		panel_2.add(rdbtnCourbe);
		
		JButton btnGraphique = new JButton("Tableau brut");
		btnGraphique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGraphique.setBounds(333, 199, 101, 23);
		panel_1.add(btnGraphique);
		

		JButton btnSuiv = new JButton(">");
		btnSuiv.setBounds(393, 249, 41, 33);
		panel_1.add(btnSuiv);
		btnSuiv.setIcon(new ImageIcon("../Ressources/gnome-logout-icone-4756-48.png"));
		
		// JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setBounds(445, 0, 19, 293);
		// panel_1.add(scrollPane);
		// scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.setBounds(395, 327, 89, 23);
		getContentPane().add(btnSuivant);
		

		JLabel labelSuiv = new JLabel("Suiv");
		labelSuiv.setHorizontalAlignment(SwingConstants.CENTER);
		labelSuiv.setBounds(648, 76, 104, 22);
		getContentPane().add(labelSuiv);
		
		// DefaultPieDataset union = new DefaultPieDataset();
  //       union.setValue("Pierre",20.0);
  //       union.setValue("Marie",20.0);
  //       union.setValue("Jean",20.0);
  //       union.setValue("Hime",20.0);
  //       union.setValue("Sarah",20.0);
  //       JFreeChart repart = 
  //           ChartFactory.createPieChart3D("Répartition par personne",
  //           union,true, true, false);
  //       ChartPanel crepart = new ChartPanel(repart);
  //       Plot plot = repart.getPlot();
  //       ((PiePlot)plot).setSectionPaint("Pierre", new Color(255,0,0));
  //       ((PiePlot)plot).setSectionPaint("Marie", new Color(255,255,0));
  //       ((PiePlot)plot).setSectionPaint("Jean", new Color(255,0,255));
  //       ((PiePlot)plot).setSectionPaint("Hime", new Color(0,0,255));
  //       ((PiePlot)plot).setSectionPaint("Sarah", new Color(0,255,255));
        
  //       this.add(crepart);
		
		
		this.setJMenuBar(new Menu());
		this.setVisible(true);

	}
	public static void main(String[] args) {
		Analyse_Graphique Appli = new Analyse_Graphique();
		}
}
