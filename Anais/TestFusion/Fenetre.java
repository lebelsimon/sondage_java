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
		
		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setContentPane(f);
		Container c = this.getContentPane();

			// Menu
		this.setJMenuBar(new Menu());
		System.out.println("ajout menu");
		
			// creation espace module
		m = new ModuleSondage();
		m.setOpaque(false);
		
		c.add(m,"Center");
		
		
	    

		

	    
	    
		 this.setVisible(true);
		 this.revalidate();
		 this.repaint();
	}
	
	
	
	@SuppressWarnings("unused")
	public static void main ( String [] args){
		new Fenetre();
		
	}

}
