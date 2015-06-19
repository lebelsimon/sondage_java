import javax.swing.*;
import java.awt.*;

public class QuestionVueChoixOrdonnee extends QuestionVue{
	JButton Btest1;
	JButton Btest2;
	JButton Btest3;
	
	QuestionVueChoixOrdonnee(){
		super();
		
		// creation de la liste deroulante et des elements
		String [] opts = {"","1","2","3","4","5","6","7"};
		JComboBox<String> b1 = new JComboBox<String>(opts);
		JComboBox<String> b2 = new JComboBox<String>(opts);
		JComboBox<String> b3 = new JComboBox<String>(opts);
		

		
		
		JLabel Ltest1 = new JLabel("test1");
		JLabel Ltest2 = new JLabel("test2");
		JLabel Ltest3 = new JLabel("test3");
		
		
		
		
		
		Ltest1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Ltest2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Ltest3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		//~ // creation des listes deroulantes
		//~ JPanel listeChoixB = new JPanel(new GridLayout(3,1));
		//~ 
		//~ 
		//~ // ajout à  la liste des choix
		//~ JPanel listeChoixL = new JPanel(new GridLayout(3,1));
		
		
		// Creation du contenaire
		GridLayout g = new  GridLayout(3,2);
		JPanel listeChoix = new JPanel(g);
		
		g.setHgap(4);
		g.setVgap(4);
		
		listeChoix.add(b1);
		listeChoix.add(Ltest1);
		
		listeChoix.add(b2);
		listeChoix.add(Ltest2);
		
		listeChoix.add(b3);
		listeChoix.add(Ltest3);
		
		
		
		
		
		
		this.add(listeChoix);

	}
}
		
		
