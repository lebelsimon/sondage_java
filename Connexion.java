import java.awt.*;
import javax.swing.*;

public class Connexion extends JFrame{
	public Connexion(){
		super("Projet Sondage");
		this.setSize(450,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont= this.getContentPane();
		cont.setLayout(new BorderLayout());
		
		//JPanel pour regrouper tout ce qu'il faut pour la connexion
		JPanel total = new JPanel(new FlowLayout());
		
		//Panel de l'identifiant
		JPanel identifiant = new JPanel(new FlowLayout());
		JLabel utilisateur = new JLabel("Nom d'utilisateur :");
		JTextField texteID = new JTextField(20);
		
		identifiant.add(utilisateur,"North");
		identifiant.add(texteID,"Center");
		
		//Panel du mot de passe
		JPanel mdp = new JPanel(new FlowLayout());
		JLabel mdpID = new JLabel("Mot de passe :");
		JTextField texteMdp = new JTextField(20);
		
		mdp.add(mdpID);
		mdp.add(texteMdp);
		
		//Bouton de validation 
		JButton connect = new JButton("Connexion");
		
		//Positionnement des éléments
		total.add(identifiant,"North");
		total.add(mdp,"Center");
		total.add(connect,"South");
		
		cont.add(total,"Center");
		this.setVisible(true);
		
	}
	
	//Executable
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connexion monLogin = new Connexion();
	}
}
