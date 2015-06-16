import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BoutonValider implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane jop = new JOptionPane();
	    jop.showMessageDialog(null, "Votre question a bien été enregistré ", "Sauvegarde de la question", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
