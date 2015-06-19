import java.awt.*;


import javax.swing.*;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	static Module m;
	Fenetre(){
		super("Rapid'Sond");
		System.out.println("Fenetre deb");

		
		
		// mise en place d'une image de fond
		Fond f = new Fond();
		
		
		this.add(f);	
		this.pack();
		this.setSize(800,600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		Container c = this.getContentPane();

			// Menu
		this.setJMenuBar(new Menu());
		System.out.println("ajout menu");
		
			// creation espace module
		m = new ModuleSondage();

		c.add(m);
		
				// affichage en pleine ecran
		//~ GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//~ if (device.isFullScreenSupported()) {
			//~ device.setFullScreenWindow(this);
	    //~ } else {
	        //~ System.err.println("Le mode plein ecran n'est pas disponible");
	    //~ }
	    

		
		
	    
	    
		 this.setVisible(true);
		 this.revalidate();
		 this.repaint();
	}
	
	
	
	@SuppressWarnings("unused")
	public static void main ( String [] args){
		new Fenetre();
		
	}

}
