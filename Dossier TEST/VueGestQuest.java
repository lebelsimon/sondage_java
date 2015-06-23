import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class VueGestQuest extends JFrame {
	DefaultListModel<String> listcat;
	JList<String> list;
	ConnexionMySQL connection;
	QuestionnaireBD qBD;
	ArrayList<Questionnaire> listeQ;
	Utilisateur util;
	public VueGestQuest(ConnexionMySQL c, Utilisateur util){
		this.connection = c;
		this.util = util;
		this.setTitle("Rapid Sond'");
		this.setSize(800,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		try{
			qBD = new QuestionnaireBD(connection);
		}
		catch (SQLException e) {
			System.out.println("questionnaireBD non créé");
		}
		
//		JPanel Fenetre = new JPanel();
//		Fenetre.setLayout(new GridLayout());
		// Panel Menu
		
//		JPanel Menu = new JPanel();
//		Menu.setLayout(new FlowLayout());
		
		
		JButton btnDeco = new JButton("");
		btnDeco.setName("Deconnexion");
		btnDeco.addActionListener(new ControleurVueGestQuest(this,connection,util));
		btnDeco.setIcon(new ImageIcon("../Ressources/gnome-logout-icone-4756-48.png"));
		btnDeco.setBounds(648, 11, 104, 62);
		getContentPane().add(btnDeco);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.setIcon(new ImageIcon("../Ressources/ajouter-vert-plus-icone-9549-48.png"));
		btnAjouter.addActionListener(new ControleurVueGestQuest(this,connection,util));
		btnAjouter.setName("Ajouter");
		btnAjouter.setBounds(44, 358, 146, 62);
		getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("");
		btnModifier.setIcon(new ImageIcon("../Ressources/bloc-notes-stylo-ecrire-icone-8970-48.png"));
		btnModifier.addActionListener(new ControleurVueGestQuest(this,connection,util));
		btnModifier.setName("Modifier");
		btnModifier.setBounds(326, 358, 146, 62);
		getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("");
		btnSupprimer.setIcon(new ImageIcon("../Ressources/supprimer-icone-5418-64.png"));
		btnSupprimer.addActionListener(new ControleurVueGestQuest(this,connection,util));
		btnSupprimer.setName("Supprimer");
		btnSupprimer.setBounds(596, 358, 146, 62);
		getContentPane().add(btnSupprimer);
		
		JLabel VosQuest = new JLabel("Vos questionnaires");
		VosQuest.setHorizontalAlignment(SwingConstants.CENTER);
		VosQuest.setFont(new Font("Tahoma", Font.BOLD, 15));
		VosQuest.setBounds(44, 109, 698, 22);
		getContentPane().add(VosQuest);

		listeQ = new ArrayList<Questionnaire>();

		for(Questionnaire elem:qBD.getListeQuestionnaire(util.getIdU(),"Concepteur")){
			System.out.println(elem);
			listeQ.add(elem);
		}
		listcat = new DefaultListModel<String>();

		for(Questionnaire elem:listeQ){
			listcat.addElement(elem.getTitreQuestionnaire());
		}
		
		
		
		JLabel labelAjouter = new JLabel("Ajouter");
		labelAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelAjouter.setHorizontalAlignment(SwingConstants.CENTER);
		labelAjouter.setBounds(44, 420, 146, 22);
		getContentPane().add(labelAjouter);
		
		JLabel labelModifier = new JLabel("Modifier");
		labelModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelModifier.setHorizontalAlignment(SwingConstants.CENTER);
		labelModifier.setBounds(326, 424, 146, 22);
		getContentPane().add(labelModifier);
		
		JLabel labelSupprimer = new JLabel("Supprimer");
		labelSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		labelSupprimer.setBounds(596, 424, 146, 22);
		getContentPane().add(labelSupprimer);
		
		JLabel labelDeco = new JLabel("Deconnexion");
		labelDeco.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeco.setBounds(648, 76, 104, 22);
		getContentPane().add(labelDeco);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 154, 647, 181);
		getContentPane().add(scrollPane);
		
		list = new JList<String>(listcat);
		scrollPane.setViewportView(list);
		list.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		
		this.setJMenuBar(new Menu(this));
		
		
		// END

		this.setVisible(true);
	}

// public static void main(String[] args) {
// 	VueGestQuest Appli = new VueGestQuest();
// 	}
}
