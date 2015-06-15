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
		
		
		
		
		
		// creation des listes deroulantes
		JPanel listeChoixB = new JPanel(new GridLayout(3,1));
		listeChoixB.add(b1);
		listeChoixB.add(b2);
		listeChoixB.add(b3);
		
		// ajout à  la liste des choix
		JPanel listeChoixL = new JPanel(new GridLayout(3,1));
		listeChoixL.add(Ltest1);
		listeChoixL.add(Ltest2);
		listeChoixL.add(Ltest3);
		
		// Creation du contenaire
		GridLayout g = new  GridLayout(1,2);
		g.setHgap(4);
		
		JPanel listeChoix = new JPanel(g);
		
		listeChoix.add(listeChoixB);
		listeChoix.add(listeChoixL);
		this.add(listeChoix);

	}
}
		
		
