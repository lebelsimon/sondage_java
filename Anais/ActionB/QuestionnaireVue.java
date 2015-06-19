import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class QuestionnaireVue extends JPanel{
	//static Questionnaire q, Sonde s;
	
	JLabel titreQuestionnaire;
	Questionnaire questionnaire;
	mod m;
	QuestionVue questionVue;
	Question question;
	

	QuestionnaireVue(mod _m){
		
		// initialisation des valeurs
		super();
		this.m = _m;
		this.setLayout(new BorderLayout());
		Random random = new Random();
		int numSonde =199;
		System.out.println("Cacule des indice pour sond num 10");//+m.toto.getNumSond());
		System.out.println(m.info.getListeQuestionnairePourUnSonde(numSonde));//m.toto.getNumSond()));
		int ind = random.nextInt(m.info.getListeQuestionnairePourUnSonde(numSonde).size());
		//System.out.println("ind" +ind);
		//System.out.println("m.toto.getListeQuestionnaire().get(ind): "+m.toto.getListeQuestionnaire().get(10));//ind));
		int numQuestionnaire =  m.info.getListeQuestionnairePourUnSonde(numSonde).get(ind);
		System.out.println("Indice calculer");

		
		// creation du questionnaire
			// creation de la connection
		try {
			ConnexionMySQL co = new ConnexionMySQL(
					"jdbc:mysql://servinfo-db:3306/", "dbdmartin", "dbdmartin",
					"/home/dmartin");
		QuestionnaireBD BD = new QuestionnaireBD(co);
	
		Random randomQ = new Random();
		
		questionnaire = BD.creerQuestionnaire(numQuestionnaire);
		//~ int pif = random.nextInt( questionnaire.getListeQuestions().size());
		System.out.println("Ici");		
	
		
		question = questionnaire.getListeQuestions().get(0);
		System.out.println("Ici");	

		// Creation du label Questionnaire:
		
		JPanel idQuestionnaireJ = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 4));
		titreQuestionnaire = new JLabel(questionnaire.getTitreQuestionnaire());
		idQuestionnaireJ.add(titreQuestionnaire);
		idQuestionnaireJ.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		// creation des boutons et de leur panel
		JPanel boutonsQuestions = new JPanel();
		
			// question suivante
		boutonsQuestions.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton qsuiv = new JButton(">");
		qsuiv.setName("suiv");
		qsuiv.setToolTipText("question suivante");
		// qsuiv.addActionListener(new QuestionnaireButton(qsuiv.getName(), this));//, this.q));
		
			//question precedente
		JButton qprec = new JButton("<");
		qprec.setName("prec");
		qprec.setToolTipText("question précédente");
		// qprec.addActionListener(new QuestionnaireButton(qprec.getName(), this));//, this.q));
		
			//premiere question
		JButton qprem = new JButton("<<<");
		qprem.setName("prem");
		qprem.setToolTipText("première question");
		// qprem.addActionListener(new QuestionnaireButton(qprem.getName(), this));//, this.q));
		
			// derniere question
		JButton qder = new JButton(">>>");
		qder.setName("dern");
		qder.setToolTipText("dernière question");
		// qder.addActionListener(new QuestionnaireButton(qder.getName(), this));//, this.q));
		
		// ajout des boutons au panel boutons
		boutonsQuestions.add(qprem); 
		boutonsQuestions.add(qprec);
		boutonsQuestions.add(qsuiv); 
		boutonsQuestions.add(qder); 
		

		// creation de la vue de la question:
			// par la suite on donnera une question et il creera la vue en fonction de la question
		questionVue = new QuestionVue(question, this);
		
		questionVue.setBorder(BorderFactory.createLineBorder(Color.black));
		questionVue.setPreferredSize(new Dimension(300,150));
		questionVue.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//this.add(new JLabel("TESTTTTT"));
		this.add(idQuestionnaireJ, BorderLayout.NORTH);
		this.add(questionVue, BorderLayout.CENTER);
		this.add(boutonsQuestions,BorderLayout.SOUTH); 		
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		//this.add(new JLabel("coucou"));
		this.setPreferredSize(new Dimension(350,530));
		this.revalidate();
		//this.setVisible(true);
		
		} catch (Exception e) {
			System.out.println("connexion non établie");
		}
	}
	public void ChangerQuestion( QuestionnaireVue questionnaireVue ,Question q){
		System.out.println("deb ChangerQuestion");
		questionnaireVue.question = q;
		questionnaireVue.questionVue =  new QuestionVue(q, questionnaireVue);
		
		//~ System.out.println("changement du num");
		//~ this.questionVue.idQuestion.setText("Question numero: "+q.getNumQ());
		
		System.out.println(this.getParent().getParent().getParent().getParent());
		this.getParent().getParent().revalidate();
		this.getParent().getParent().repaint();
		System.out.println("fin ChangerQuestion");
		
	}
}
