
public class Executable {

	public static void main(String[] args) {
		Questionnaire questionnaire = new Questionnaire("Bidule",4, 12, 42, 69, 'v');
		Question question = new Question("Aimes-tu les cookies ?");
		Proposition p1 = new Proposition("Oui");
		Proposition p2 = new Proposition("Non");
		Proposition p3 = new Proposition("Peut etre");
		question.addProposition(p1);
		question.addProposition(p2);
		question.addProposition(p3);
		questionnaire.addQuestion(question);
		VueSaisieQuestion QCM1 = new VueSaisieQuestion(questionnaire, question);
		Menu men = new Menu();
		
		System.out.println(question.getTexteQuestion());
		System.out.println(questionnaire.getIdQ());
		System.out.println(question.getNumQ());
		
		ApplicationSondage c = new ApplicationSondage(men, QCM1);
       
		
		
	}

}
