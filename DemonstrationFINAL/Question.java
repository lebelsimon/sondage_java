import javax.swing.DefaultListModel;


public class Question {
	String texteQuestion;
	char idT;
	int maxVal;
	int numQ;
	DefaultListModel<Proposition> propositions;
	
	public Question(String texteQuestion) {
		super();
		this.texteQuestion = new String(texteQuestion);
		this.propositions = new DefaultListModel<Proposition>();
	}
	
	public Question(String texteQuestion, char idT, int maxVal, int numQ) {
		super();
		this.texteQuestion = new String(texteQuestion);
		this.propositions = new DefaultListModel<Proposition>();
		this.idT=idT;
		this.maxVal=maxVal;
		this.numQ=numQ;
	}
	
	// constructeur permettant la recopie d'un question
	public Question(Question q){
		super();
		this.texteQuestion=new String(q.texteQuestion);

		int nbP=q.getPropositions().size();
		this.propositions=new DefaultListModel<Proposition>();
		for (int i=0;i<nbP;i++){
			this.addProposition(new Proposition(q.getPropositions().get(i)));
		}
	}
	//retourne le texte de la question
	public String getTexteQuestion() {
		return texteQuestion;
	}
	//permet de modifier le texte de la question
	public void setTexteQuestion(String texteQuestion) {
		this.texteQuestion = new String(texteQuestion);
	}
	

	public DefaultListModel<Proposition> getPropositions() {
		return propositions;
	}
	public void setPropositions(DefaultListModel<Proposition> reponses) {
		this.propositions = reponses;
	}
	//permet d'ajouter des propositions
	public void addProposition(Proposition rep){
		this.propositions.addElement(rep);
	}
	
	public void removeProposition(int index){
		this.propositions.remove(index);
	}
	// getter + setter
	public char getIdT() {
		return idT;
	}

	public void setIdT(char idT) {
		this.idT = idT;
	}

	public int getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(int maxVal) {
		this.maxVal = maxVal;
	}

	public int getNumQ() {
		return numQ;
	}

	public void setNumQ(int numQ) {
		this.numQ = numQ;
	}

	@Override
	public String toString() {
		return "Question [texteQuestion=" + texteQuestion + ", idT=" + idT
				+ ", maxVal=" + maxVal + ", numQ=" + numQ + ", propositions="
				+ propositions + "]\n";
	}


}
