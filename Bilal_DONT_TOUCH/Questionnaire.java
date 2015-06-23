import java.util.ArrayList;


public class Questionnaire {
	String titreQuestionnaire;
	int numC, idU, idPan, idQ;
	char etat;
	ArrayList <Question> listeQuestions;
	public Questionnaire(String titreQuestionnaire, int numC, int idU, int idPan, char etat) {
		super();
		this.titreQuestionnaire = titreQuestionnaire;
		this.listeQuestions = new ArrayList <Question>();
		this.numC=numC;
		this.idU=idU;
		this.idPan=idPan;
		this.etat=etat;
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
	
	public int getNumC() {
		return numC;
	}
	public void setNumC(int numC) {
		this.numC = numC;
	}
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public int getIdPan() {
		return idPan;
	}
	public void setIdPan(int idPan) {
		this.idPan = idPan;
	}
	
	public char getEtat() {
		return etat;
	}
	public void setEtat(char etat) {
		this.etat = etat;
	}
	public int getIdQ() {
		return idQ;
	}

	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}

	@Override
	public String toString() {
		return "Questionnaire [titreQuestionnaire=" + titreQuestionnaire
				+ ", numC=" + numC + ", idU=" + idU + ", idPan=" + idPan
				+ ", listeQuestions=" + listeQuestions + "]";
	}

	
}
