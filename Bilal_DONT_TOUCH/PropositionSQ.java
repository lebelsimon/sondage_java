import javax.swing.*;

@SuppressWarnings("serial")
public class PropositionSQ extends JFrame {
	private String text;
	private Boolean valide;
	
	public PropositionSQ(String t, boolean v){
		text=t;
		valide=v;
		
	}
	
	public void setText(String text){
		this.text=text;
	}
	
	public void setValide(boolean valide){
		this.valide=valide;
	}
	
	public String getText(){
		return text;
	}
	
	public Boolean getValide(){
		return valide;
	}
	
	public String toString(String [] args){
		return text+"["+valide+"]";
	}
}
