import javax.swing.*;

@SuppressWarnings("serial")
public class QuestionSQ extends JFrame {
	private String enonce;
	private DefaultListModel<PropositionSQ> lesPropositions;
	
	public QuestionSQ(String e){
		enonce=e;
		lesPropositions= new DefaultListModel<PropositionSQ>();
	}
	
	public void setEnonce(String enonce){
		this.enonce=enonce;
	}
	
	public String getEnonce(){
		return enonce;
	}
	
	public void addProposition(PropositionSQ prop, int i){
		lesPropositions.add(i, prop);
	}
	
	public void deltProposition(int i){
		lesPropositions.remove(i);
	}
	
	public DefaultListModel<PropositionSQ> getProp(){
		return lesPropositions;
	}
	
	public void setProp(DefaultListModel<PropositionSQ> p){
		lesPropositions=p;
	}
	
	
}
