import java.awt.*;
import javax.swing.*;

public class Question extends JFrame {
	private String enonce;
	private DefaultListModel<Proposition> lesPropositions;
	
	public Question(String e){
		enonce=e;
		lesPropositions= new DefaultListModel<Proposition>();
	}
	
	public void setEnonce(String enonce){
		this.enonce=enonce;
	}
	
	public String getEnonce(){
		return enonce;
	}
	
	public void addProposition(Proposition prop, int i){
		lesPropositions.add(i, prop);
	}
	
	public void deltProposition(int i){
		lesPropositions.remove(i);
	}
	
	public DefaultListModel<Proposition> getProp(){
		return lesPropositions;
	}
	
	public void setProp(DefaultListModel<Proposition> p){
		lesPropositions=p;
	}
	
}
