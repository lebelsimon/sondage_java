import java.awt.*;

import javax.swing.*;


public class Fenetre extends JFrame{
	Fenetre(){
		super("Rapid'Sond");
		System.out.println("Fenetre deb");

		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		Container c = this.getContentPane();

			// Menu
		this.setJMenuBar(new Menu());
		System.out.println("ajout menu");
		
			// creation espace module
		Question question = new Question("Aimes-tu les cookies ?");
		VueSaisieQuestion QCM1 = new VueSaisieQuestion(question);
		c.add(QCM1);
		
				// affichage en pleine ecran
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (device.isFullScreenSupported()) {
			device.setFullScreenWindow(this);
	    } else {
	        System.err.println("Le mode plein ecran n'est pas disponible");
	    }
	    

		

	    
	    
		 this.setVisible(true);
	}
	
	
	
	@SuppressWarnings("unused")
	public static void main ( String [] args){
		new Fenetre();
		
	}

}
