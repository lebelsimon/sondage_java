import javax.swing.*;
import java.awt.*;

// note:  a refaire pour mettre une liste deroulante

public class QuestionVueChoixLibre extends QuestionVue{
	//private Question q;
	
	JRadioButton test1;
	JRadioButton test2;
	JRadioButton test3;
	
	// scroll
	JScrollPane  scroll;
	QuestionVueChoixLibre(){//Question q){
		super();
		
		// Creation des boutons et du groupement de bouton car 1 seule reponce est attendu
		//~ ButtonGroup lesChoix = new ButtonGroup();
		
		// Choix pre rentre
		//~ test1 = new JRadioButton(" test 1") ;
		//~ test2 = new JRadioButton(" test 2") ;
		//~ test3 = new JRadioButton(" test 3") ;
		
		// Centrage des elements
		//~ test1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		//~ test2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		//~ test3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		//~ lesChoix.add(test1);
		//~ lesChoix.add(test2);
		//~ lesChoix.add(test3);
		
		
		// creation du choix libre
		JTextField marep = new JTextField(20);
		
		
		
		
		// creation du panel contenant les choix et ajout: 
		// ATTENTION 
		
		JPanel RadioButon = new JPanel(new GridLayout(3,1));
		
		GridLayout g = new GridLayout(2,1);
		g.setHgap(10);
		JPanel listeChoix = new JPanel(g);
		//~ RadioButon.add(test1);
		//~ RadioButon.add(test2);
		//~ RadioButon.add(test3);
		
		listeChoix.add(RadioButon);
		listeChoix.add(marep);
		
		//~ listeChoix.setLayoutOrientation(JList.VERTICAL_WRAP);
		
		System.out.println("deb crea scroll");
		
		
		// scroll bar
		scroll = new JScrollPane(listeChoix, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize( new Dimension(300,400));
		//scroll.setBorder(javax.swing.border.Border);
		//~ scroll.setBorder();
		

		
		
		
		this.add(scroll, BorderLayout.WEST);
		
		this.setSize(300, 500);
		this.revalidate();
		
	}
}
