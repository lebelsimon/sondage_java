import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	Module m;
	
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
		JFrame Stock = this;
		m = new ModuleSondage(this);
		m.setOpaque(false);
		System.out.println("m :"+m+" f : "+this);
		//m.SetFrame(this);
		
		c.add(m,"Center");
		this.setVisible(true);
		rechargerPage();
	}


	public void rechargerPage(){
		Container c = this.getContentPane();
		c.removeAll();
		c.add(m);
		m.SetFrame(this);
		this.revalidate();
		this.repaint();
	}
	
	@SuppressWarnings("unused")
	public static void main ( String [] args){
		// Par la suite il faudra faire en sorte que la vue de base soit celle de Connection et que lors de la conection, la vue change
		
		new Fenetre();
	}
	
	
	
}
