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
		
		
		// Fenetre du container
		JPanel fen = new JPanel(new BorderLayout());
		
		
		// Fenetre de centre avec les questions
		JPanel quest = new JPanel(new GridLayout(0,1));
		
		JPanel haut = new JPanel(new GridLayout(2,0));
		JPanel milieu = new JPanel(new FlowLayout());
		JPanel bas = new JPanel();
		
		
		// EnoncÃ© des questions ===============================================
		JLabel numquestionnaire = new JLabel("Questionnaire n° X");
		JLabel numquest = new JLabel("Question n° X");
		JPanel titre = new JPanel(new BorderLayout());
		//titre.setLayout();    A remodifier
		
		
		JLabel eq = new JLabel("Enonce de la question: ");
		enonceQuestion = new JTextField();
		enonceQuestion.setText(q.getEnonce());
		
		JPanel enonce = new JPanel();
		
		titre.add(numquestionnaire);
		titre.add(numquest);
		enonce.add(eq);
		enonce.add(enonceQuestion);
		haut.add(titre);
		haut.add(enonce);
		
		
		// Choix du type de question ==========================================
		// creation des radio boutons
		JRadioButton bChoixsimple= new JRadioButton("Choix simple");
		JRadioButton bChoixmultiple= new JRadioButton("Choix multiple");
		JRadioButton bClassement= new JRadioButton("Classement");
		JRadioButton bNote= new JRadioButton("Note");
		JRadioButton bLibre= new JRadioButton("Libre");
		// crÃ©ation du groupe de bouton
		ButtonGroup choixOption = new ButtonGroup();
		// ajout des boutons au groupe de choix
		choixOption.add(bChoixsimple);
		choixOption.add(bChoixmultiple);
		choixOption.add(bClassement);
		choixOption.add(bNote);
		choixOption.add(bLibre);
		// crÃ©ation du panel
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
		
		JPanel pBouton = new JPanel(new GridLayout(0,1,0,40));
		pBouton.add(ajouter);
		pBouton.add(supprimer);
		
		milieu.add(pBouton);
		
		JButton valider = new JButton ("Valider");
		
		bas.add(valider);
		
		
		model=q;
		
		
		
		// Assemblement des panel
		
		quest.add(haut);
		quest.add(milieu);
		quest.add(bas);
		
		fen.add(quest,"Center");
		this.add(fen);
		
		
	}

}
