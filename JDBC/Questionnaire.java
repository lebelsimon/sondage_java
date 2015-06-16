import java.util.ArrayList;


public class Questionnaire {
	String titreQuestionnaire;
	ArrayList <Question> listeQuestions;
	public Questionnaire(String titreQuestionnaire) {
		super();
		this.titreQuestionnaire = titreQuestionnaire;
		this.listeQuestions = new ArrayList <Question>();
	}
	public String getTitreQuestionnaire() {
		return titreQuestionnaire;
	}
	public void setTitreQuestionnaire(String titreQuestionnaire) {
		this.titreQuestionnaire = titreQuestionnaire;
	}
	public ArrayList<Question> getListeQuestions() {
		return listeQuestions;
	}
	public void setListeQuestions(ArrayList<Question> listeQuestions) {
		this.listeQuestions = listeQuestions;
	}
	public void addQuestion(Question q){
		this.listeQuestions.add(q);
	}
	public void delQuestion(int ind){
		this.listeQuestions.remove(ind);
	}
	public int nbQuestions(){
		return this.listeQuestions.size();
	}
	public Question getQuestion(int ind){
		return this.listeQuestions.get(ind);
	}
	public void setQuestion(int ind,Question q){
		this.listeQuestions.set(ind, q);
	}
	@Override
	public String toString() {
		return "Questionnaire [titreQuestionnaire=" + titreQuestionnaire
				+ ", listeQuestions=" + listeQuestions + "]\n";
	}
	
}
