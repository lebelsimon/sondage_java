import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class Connexion extends JFrame{
    ConnexionMySQL c;
    JTextField texteID;    
    JPasswordField texteMdp;
    
	public Connexion(ConnexionMySQL c){
		super("Projet Sondage");
		this.c=c;
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("icon1.jpg").getImage());
		Container cont= this.getContentPane();
		cont.setLayout(new BorderLayout());
		
		//JPanel pour regrouper tout ce qu'il faut pour la connexion
		JPanel total = new JPanel(new FlowLayout());
		
		//JLabel pour le logo
		JLabel image = new JLabel(new ImageIcon("logo1.png"));

		
		//Panel de l'identifiant
		JPanel identifiant = new JPanel(new FlowLayout());
		JLabel utilisateur = new JLabel("Nom d'utilisateur :");
		texteID = new JTextField(20);
		
		identifiant.add(utilisateur,"North");
		identifiant.add(texteID,"Center");
		
		//Panel du mot de passe
		JPanel mdp = new JPanel(new FlowLayout());
		JLabel mdpID = new JLabel("Mot de passe :");
		texteMdp = new JPasswordField(20);
		
		mdp.add(mdpID);
		mdp.add(texteMdp);
		
		//Bouton de validation 
		JButton connect = new JButton("Connexion");
		connect.addActionListener(new ActionBouton("connexion", this));
		//Bouton d'oubli des informations
		JButton oubli = new JButton("Mot de passe oublié?");
		oubli.addActionListener(new ActionBouton("mdp", this));
		
		JPanel boutons = new JPanel(new FlowLayout());
		boutons.add(connect,"North");
		boutons.add(oubli,"South");
		
		//Positionnement des éléments
		total.add(identifiant,"North");
		total.add(mdp,"Center");
		total.add(boutons,"South");
		
		cont.add(image, "North");
		cont.add(total,"Center");
		this.setVisible(true);
		
	}
	
	//Executable
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Connexion monLogin = new Connexion(new ConnexionMySQL("jdbc:mysql://servinfo-db:3306/", "dbdmartin", "dbdmartin","/home/dmartin"));
	    
		
		
		
	    
	    
	    
	}
}
