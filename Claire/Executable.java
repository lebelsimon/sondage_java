
public class Executable {

	public static void main(String[] args) {
		Question question = new Question("Aimes-tu les cookies ?");
		Proposition p1 = new Proposition("Oui", true);
		Proposition p2 = new Proposition("Non", false);
		Proposition p3 = new Proposition("Peut être", false);
		question.addProposition(p1,0);
		question.addProposition(p2,1);
		question.addProposition(p3,2);
		VueSaisieQuestion QCM1 = new VueSaisieQuestion(question);
		Menu men = new Menu();
		ApplicationSondage c = new ApplicationSondage(men, QCM1);
       
		
		
	}

}
