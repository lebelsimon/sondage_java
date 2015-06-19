import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonSupprimer implements ActionListener{
	
	VueSaisieQuestion quest;
	String q;
	
	public BoutonSupprimer(VueSaisieQuestion vue){
		quest=vue;
		q=vue.liste2.getSelectedValue();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		quest.liste.removeElement(quest.liste2.getSelectedValue());
	}

}
