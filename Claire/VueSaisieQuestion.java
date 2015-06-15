import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class VueSaisieQuestion extends JPanel {
	Question model;
	JTextField enonceQuestion;
	JTextField textProposition;
	JList<Proposition> listePropositions;
	JScrollPane scroll;
	
	public VueSaisieQuestion(Question q){
		
		this.setLayout(new BorderLayout());//new BoxLayout(this, BoxLayout.Y_AXIS)
		JPanel quest = new JPanel(new BorderLayout());
		
		
		JPanel haut = new JPanel();
		JPanel milieu = new JPanel(new FlowLayout());
		JPanel bas = new JPanel();
		
		
		// Enoncé des questions ===============================================
		JLabel eq = new JLabel("Enonce de la question: ");
		enonceQuestion = new JTextField();
		enonceQuestion.setText(q.getEnonce());
		
		haut.add(eq);
		haut.add(enonceQuestion);
		
		
		
		// Choix du type de question ==========================================
		// creation des radio boutons
		JRadioButton bChoixsimple= new JRadioButton("Choix simple");
		JRadioButton bChoixmultiple= new JRadioButton("Choix multiple");
		JRadioButton bClassement= new JRadioButton("Classement");
		JRadioButton bNote= new JRadioButton("Note");
		JRadioButton bLibre= new JRadioButton("Libre");
		// création du groupe de bouton
		ButtonGroup choixOption = new ButtonGroup();
		// ajout des boutons au groupe de choix
		choixOption.add(bChoixsimple);
		choixOption.add(bChoixmultiple);
		choixOption.add(bClassement);
		choixOption.add(bNote);
		choixOption.add(bLibre);
		// création du panel
		JPanel panelChoix = new JPanel();
		// on va mettre les choix les uns en dessous des autres 
		panelChoix.setLayout(new BoxLayout(panelChoix, BoxLayout.Y_AXIS));
		// on entoure les choix d'un trait et on met un titre
		panelChoix.setBorder(new TitledBorder("Type de Question"));
		// ajout des radio boutons au panel
		panelChoix.add(bChoixsimple);
		panelChoix.add(bChoixmultiple);
		panelChoix.add(bClassement);
		panelChoix.add(bNote);
		panelChoix.add(bLibre);
		
		milieu.add(panelChoix);
		
		// Liste des propositions ===================================================
		listePropositions = new JList<Proposition>(q.getProp());
		JPanel liste = new JPanel(new FlowLayout());
		liste.add(listePropositions);
		DefaultListCellRenderer renderer =(DefaultListCellRenderer)listePropositions.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER); 
		scroll = new JScrollPane(listePropositions, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Dimension dim = new Dimension(300,100);
		scroll.setPreferredSize(dim);
		milieu.add(scroll);
		
		// Les boutons =============================================================
		JButton ajouter = new JButton("Ajouter");
		JButton supprimer = new JButton("Supprimer");
		
		JPanel pBouton = new JPanel(new GridLayout(0,1));
		pBouton.add(ajouter);
		pBouton.add(supprimer);
		
		milieu.add(pBouton);
		
		JButton valider = new JButton ("Valider");
		
		bas.add(valider);
		
		
		
		
		model=q;
		
		
		quest.add(haut,"North");
		quest.add(milieu,"Center");
		quest.add(bas,"South");
		
		this.add(quest);
		
	}

}
