import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;

import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class VueCreatQuest extends JFrame {
	public String etat;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	public JList<String> listeQ;
	public DefaultListModel<String> list;
	public VueCreatQuest(String etat){
		this.etat = etat;
		this.setTitle("Rapid Sond' | Creation questionnaire");
		this.setSize(800,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JButton btnAjouter = new JButton("");
		btnAjouter.setName("Ajouter");
		btnAjouter.setIcon(new ImageIcon("../Ressources/ajouter-vert-plus-icone-9549-32.png"));
		btnAjouter.addActionListener(new ControleurVueCreatQuest(this));
		btnAjouter.setBounds(676, 188, 46, 34);
		getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("");
		btnModifier.setName("Modifier");
		btnModifier.setIcon(new ImageIcon("../Ressources/bloc-notes-stylo-ecrire-icone-8970-32.png"));
		btnModifier.addActionListener(new ControleurVueCreatQuest(this));
		btnModifier.setBounds(676, 263, 46, 34);
		getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("");
		btnSupprimer.setName("Supprimer");
		btnSupprimer.setIcon(new ImageIcon("../Ressources/supprimer-icone-5418-32.png"));
		btnSupprimer.addActionListener(new ControleurVueCreatQuest(this));
		btnSupprimer.setBounds(676, 335, 46, 34);
		getContentPane().add(btnSupprimer);
		
		JLabel labelCreaQuest = new JLabel("Creation questionnaire");
		labelCreaQuest.setHorizontalAlignment(SwingConstants.CENTER);
		labelCreaQuest.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCreaQuest.setBounds(44, 41, 698, 22);
		getContentPane().add(labelCreaQuest);
		
		String categories[] = { "Household", "Office", "Extended Family",
		        "Company (US)", "Company (World)", "Team", "Will",
		        "Birthday Card List", "High School", "Country", "Continent",
		        "Planet" };
		
		list = new DefaultListModel<String>();
		for(String elem:categories){
			list.addElement(elem);
		}
		JLabel labelListeQ = new JLabel("Liste des questions");
		labelListeQ.setHorizontalAlignment(SwingConstants.CENTER);
		labelListeQ.setBounds(64, 159, 586, 27);
		getContentPane().add(labelListeQ);
		
		JLabel labelNomQuest = new JLabel("Nom questionnaire :");
		labelNomQuest.setBounds(143, 83, 139, 27);
		getContentPane().add(labelNomQuest);
		
		textField  = new JTextField();
		textField.setBounds(292, 85, 215, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNumeroQuestionnaire = new JLabel("Numero questionnaire :");
		lblNumeroQuestionnaire.setBounds(143, 121, 139, 27);
		getContentPane().add(lblNumeroQuestionnaire);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(292, 123, 215, 22);
		getContentPane().add(textField_1);
		
		JLabel lblAssocierSociete = new JLabel("Associer societe :");
		lblAssocierSociete.setBounds(179, 384, 117, 27);
		getContentPane().add(lblAssocierSociete);
		
		JLabel lblAssocierPanel = new JLabel("Associer panel :");
		lblAssocierPanel.setBounds(189, 422, 117, 27);
		getContentPane().add(lblAssocierPanel);
		
		JComboBox<String> CBSociete = new JComboBox<String>();
		CBSociete.setBounds(292, 387, 215, 20);
		getContentPane().add(CBSociete);
		
		JComboBox<String> CBPanel = new JComboBox<String>();
		CBPanel.setBounds(292, 425, 215, 20);
		getContentPane().add(CBPanel);
		
		JButton btnValider = new JButton("");
		btnValider.setIcon(new ImageIcon("../Ressources/accepter-verifier-vert-ok-oui-icone-6380-48.png"));
		btnValider.setName("Valider");
		btnValider.addActionListener(new ControleurVueCreatQuest(this));
		btnValider.setBounds(653, 411, 89, 83);
		getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("");
		btnAnnuler.setName("Annuler");
		btnAnnuler.setIcon(new ImageIcon("../Ressources/supprimer-icone-5418-64.png"));
		btnAnnuler.addActionListener(new ControleurVueCreatQuest(this));
		btnAnnuler.setBounds(31, 411, 89, 83);
		getContentPane().add(btnAnnuler);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAjouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouter.setBounds(660, 220, 82, 22);
		getContentPane().add(lblAjouter);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifier.setBounds(660, 291, 82, 33);
		getContentPane().add(lblModifier);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupprimer.setBounds(660, 364, 82, 27);
		getContentPane().add(lblSupprimer);
		
		JButton btnDeco = new JButton("");
		btnDeco.setName("Deconnexion");
		btnDeco.setIcon(new ImageIcon("../Ressources/gnome-logout-icone-4756-48.png"));
		btnDeco.addActionListener(new ControleurVueCreatQuest(this));
		btnDeco.setBounds(657, 25, 104, 62);
		getContentPane().add(btnDeco);
		
		JLabel lblAnnuler = new JLabel("Annuler");
		lblAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnnuler.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnuler.setBounds(31, 489, 89, 34);
		getContentPane().add(lblAnnuler);
		
		JLabel lblValider = new JLabel("Deconnexion");
		lblValider.setHorizontalAlignment(SwingConstants.CENTER);
		lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValider.setBounds(667, 79, 89, 34);
		getContentPane().add(lblValider);
		
		JLabel lblDeco = new JLabel("Valider");
		lblDeco.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeco.setBounds(653, 489, 89, 34);
		getContentPane().add(lblDeco);
		
		listeQ = new JList<String>(list);
		listeQ.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		listeQ.setBounds(91, 189, 508, 181);
		
		JScrollPane scroll = new JScrollPane(listeQ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scroll);
		scroll.setBounds(64, 188, 586, 181);
	
		
		this.setJMenuBar(new Menu());
		
		
		// END


		
//		getContentPane().add(Menu,"NORTH");
		this.setVisible(true);
	}
	public static void main(String[] args) {
		VueCreatQuest Appli = new VueCreatQuest("c");
		}
}