import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;


@SuppressWarnings("serial")
public class ApplicationSondage extends JFrame {
	public ApplicationSondage(){
		super("Rapid'Sond");
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel Fenetre = new JPanel();
		Fenetre.setLayout( new GridLayout() );
		// Panel Menu
		
		JPanel Menu = new JPanel();
		Menu.setLayout( new FlowLayout());
		
		
		
		
		// Panel Module
		
		JPanel Module = new JPanel();
		// depend du module, a completer
		Module.setLayout(new FlowLayout());
		
		
		// END
		
		Fenetre.add(Menu,"NORTH");
		Fenetre.add(Module,"SOUTH");
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationSondage test = new ApplicationSondage();
	}
}
