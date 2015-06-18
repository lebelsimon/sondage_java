import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;


@SuppressWarnings("serial")
public class ApplicationSondage extends JFrame {
	public ApplicationSondage(Menu menu, VueSaisieQuestion qcm){
		super("Rapid'Sond");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(qcm);
		JPanel Fenetre = new JPanel();
		Fenetre.setLayout( new GridLayout() );
		this.setJMenuBar(new Menu());
		

		this.setVisible(true);
	}

}
