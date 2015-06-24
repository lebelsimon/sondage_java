import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VueSaisieQuestion extends JPanel {
	
	ConnexionMySQL c;
	Questionnaire questionnaire;
	Question question;
	JTextField enonceQuestion;
	JTextField textProposition;
	JList<Proposition> listePropositions;
	JScrollPane scroll;
	JList<String> liste2;
	DefaultListModel<String> liste;
	DefaultListModel<Proposition> listeProp;
	JPanel quest;
	JPanel haut;
	JPanel milieu;
	JPanel bas;
	JLabel numquestionnaire;
	JLabel numquest;
	JPanel titre;
	JLabel eq;
	JPanel enonce;
	String radionom;
	Utilisateur util;
	
	public VueSaisieQuestion(Questionnaire q, ConnexionMySQL maco, Utilisateur u){
		
		c=maco;
		util=u;
		this.questionnaire=q;
		this.question=new Question("");
		
		this.setLayout(new BorderLayout());
		// =====================================================================
		//                          Fenetre du container
		// =====================================================================
		JPanel fen = new JPanel(new BorderLayout());
		
		// =====================================================================
		//                   Fenetre de centre avec les questions
		// =====================================================================
		quest = new JPanel(new GridLayout(0,1));
		
		haut = new JPanel(new GridLayout(2,0));
		milieu = new JPanel(new FlowLayout());
		bas = new JPanel(new FlowLayout());
		
		// =====================================================================
		//                          Enoncee des questions
		// =====================================================================
		numquestionnaire = new JLabel("Questionnaire n°"+Integer.toString(questionnaire.getIdQ()));//
		numquest = new JLabel("Question n°"+Integer.toString(questionnaire.getListeQuestions().size()));//
		this.question.setNumQ(questionnaire.getListeQuestions().size());
		titre = new JPanel();
		titre.setLayout(new BorderLayout());
		numquestionnaire.setHorizontalAlignment(getX()/2);
		numquest.setHorizontalAlignment(getX()/2);
		
		eq = new JLabel("Enonce de la question : ");
		enonceQuestion = new JTextField(30);
		enonceQuestion.setText(question.getTexteQuestion());
		
		enonce = new JPanel();
		
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
		JRadioButton bChoixsimple= new JRadioButton("Simple");
		bChoixsimple.addActionListener(new ActionRadioBouton("Simple",this));
		JRadioButton bChoixmultiple= new JRadioButton("Multiple");
		bChoixmultiple.addActionListener(new ActionRadioBouton("Multiple",this));
		JRadioButton bClassement= new JRadioButton("Classement");
		bClassement.addActionListener(new ActionRadioBouton("Classement",this));
		JRadioButton bNote= new JRadioButton("Note");
		bNote.addActionListener(new ActionRadioBouton("Note",this));
		JRadioButton bLibre= new JRadioButton("Libre");
		bLibre.addActionListener(new ActionRadioBouton("Libre",this));
		// creation du groupe de bouton
		ButtonGroup choixOption = new ButtonGroup();
		// ajout des boutons au groupe de choix
		choixOption.add(bChoixsimple);
		choixOption.add(bChoixmultiple);
		choixOption.add(bClassement);
		choixOption.add(bNote);
		choixOption.add(bLibre);
		// creation du panel
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
		listePropositions = new JList<Proposition>(question.getPropositions());
		liste= new DefaultListModel<String>();
		
		//
		for(int i=0; i<question.getPropositions().getSize(); i++){
			liste.addElement(question.getPropositions().getElementAt(i).getTexte());
		}
		
		liste2 = new JList<String>(liste);
		
		
		DefaultListCellRenderer renderer =(DefaultListCellRenderer)liste2.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.LEFT);
		scroll = new JScrollPane(liste2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Dimension dim = new Dimension(300,145);
		scroll.setPreferredSize(dim);
		milieu.add(scroll);
		
		// =====================================================================
		//                           Les boutons
		// =====================================================================
		
		JButton ajouter = new JButton("");
		ajouter.setName("Ajouter");
		ajouter.setIcon(new ImageIcon("../Ressources/ajouter-vert-plus-icone-9549-32.png"));
		ajouter.addActionListener(new BoutonQuestion(this, "ajouter",c,util));
		//ajouter.setBounds(676, 188, 46, 34);
		
		JButton modifier = new JButton("");
		modifier.setName("Modifier");
		modifier.setIcon(new ImageIcon("../Ressources/bloc-notes-stylo-ecrire-icone-8970-32.png"));
		modifier.addActionListener(new BoutonQuestion(this, "modifier",c,util));
		//modifier.setBounds(676, 188, 46, 34);
		
		JButton supprimer = new JButton("");
		supprimer.setName("Supprimer");
		supprimer.setIcon(new ImageIcon("../Ressources/supprimer-icone-5418-32.png"));
		supprimer.addActionListener(new BoutonQuestion(this, "supprimer",c,util));
		//supprimer.setBounds(676, 188, 46, 34);

		JPanel pBouton = new JPanel(new GridLayout(0, 1, 0, 5));
		pBouton.add(ajouter);
		pBouton.add(modifier);
		pBouton.add(supprimer);

		milieu.add(pBouton);

		JButton valider = new JButton("Valider");
		//valider.setName("Valider");
		//valider.setIcon(new ImageIcon("../Ressources/accepter-verifier-vert-ok-oui-icone-6380-48.png"));
		valider.addActionListener(new BoutonQuestion(this, "valider",c,util));
		//valider.setBounds(200, 411, 89, 83);

		JButton annuler = new JButton("Annuler");
		//annuler.setName("Annuler");
		//annuler.setIcon(new ImageIcon("../Ressources/supprimer-icone-5418-64.png"));
		annuler.addActionListener(new BoutonQuestion(this, "annuler",c,util));
		//annuler.setBounds(500, 411, 89, 83);

		bas.add(annuler);
		bas.add(valider);
		
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
