import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonAnnuler implements ActionListener{
	
	ApplicationSondage appli;
	
	//BoutonAnnuler(ApplicationSondage ap){
		//appli=ap;
		
	//}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		appli.dispose();
		
	}

}
