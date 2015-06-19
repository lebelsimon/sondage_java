import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VueSaisieQuestion extends JPanel {
	QuestionSQ model;
	JTextField enonceQuestion;
	JTextField textProposition;
	JList<PropositionSQ> listePropositions;
	JScrollPane scroll;
	JList<String> liste2;
	DefaultListModel<String> liste;
	
	public VueSaisieQuestion(QuestionSQ q){
		
		this.setLayout(new BorderLayout());
		// =====================================================================
		//                          Fenetre du container
		// =====================================================================
		JPanel fen = new JPanel(new BorderLayout());
		
		// =====================================================================
		//                   Fenetre de centre avec les questions
		// =====================================================================
		JPanel quest = new JPanel(new GridLayout(0,1));
		
		JPanel haut = new JPanel(new GridLayout(2,0));
		JPanel milieu = new JPanel(new FlowLayout());
		JPanel bas = new JPanel();
		
		// =====================================================================
		//                          Enoncee des questions
		// =====================================================================
		JLabel numquestionnaire = new JLabel("Questionnaire numero X");
		JLabel numquest = new JLabel("Question numero X");
		JPanel titre = new JPanel();
		titre.setLayout(new BorderLayout());
		numquestionnaire.setHorizontalAlignment(getX()/2);
		numquest.setHorizontalAlignment(getX()/2);
		
		JLabel eq = new JLabel("Enonce de la question : ");
		enonceQuestion = new JTextField();
		enonceQuestion.setText(q.getEnonce());
		
		JPanel enonce = new JPanel();
		
		titre.add(numquestionnaire, BorderLayout.NORTH);
		titre.add(numquest, BorderLayout.CENTER);
		enonce.add(eq);
		enonce.add(enonceQuestion);
		haut.add(titre);
		haut.add(enonce);
		
		// =====================================================================
		//                         Choix du type de question
		// =====================================================================
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
		
		// =====================================================================
		//                         Liste des propositions
		// =====================================================================
		listePropositions = new JList<PropositionSQ>(q.getProp());
		liste= new DefaultListModel<String>();
		//
		for(int i=0; i<q.getProp().getSize(); i++){
			liste.addElement(q.getProp().getElementAt(i).getText());
		}
		
		liste2 = new JList<String>(liste);
		
		
		DefaultListCellRenderer renderer =(DefaultListCellRenderer)liste2.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.LEFT);
		scroll = new JScrollPane(liste2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Dimension dim = new Dimension(300,125);
		scroll.setPreferredSize(dim);
		milieu.add(scroll);
		
		// =====================================================================
		//                              Les boutons
		// =====================================================================
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new BoutonAjouter());
		JButton modifier = new JButton("Modier");
		modifier.addActionListener(new BoutonModifier());
		JButton supprimer = new JButton("Supprimer");
		supprimer.addActionListener(new BoutonSupprimer());
		
		JPanel pBouton = new JPanel(new GridLayout(0,1,0,20));
		pBouton.add(ajouter);
		pBouton.add(modifier);
		pBouton.add(supprimer);
		
		milieu.add(pBouton);
		
		JButton valider = new JButton ("Valider");
		valider.addActionListener(new BoutonValider());
		
		bas.add(valider);
		
		
		model=q;
		
		// =====================================================================
		//                       Assemblement des panel
		// =====================================================================
		quest.add(haut);
		quest.add(milieu);
		quest.add(bas);
		
		fen.add(quest,"Center");
		this.add(fen);
		
		
	}

}
