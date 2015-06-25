import javax.swing.*;
import java.util.*;
import java.sql.Connection;
import java.sql.*;
import java.util.Random;
import java.awt.*;

// Panel Module Sondage
@SuppressWarnings("serial")
public class Mod extends Module{
			
    JLabel nom;
    JLabel prenom;
    JLabel telephone;
    JLabel id;
    JPanel sondregroup;
    JPanel sonde; //contient le nom prenom tel du sonde
    JPanel idaff;
    JPanel idtot; //contient l'id et SondeGlobal
    JPanel sondeP;//contien les informations de la BD
    JPanel SondeGlobal;//contient sonde et sondeP pour la centrer par rapport a ':'
    JButton suivant;
    JButton appeler;
    ModuleSondage modsond;
			
    public Mod(ModuleSondage s){

	//creation des elements de la vue
	modsond=s;
	
	appeler = new JButton ("");
	suivant = new JButton("Suivant");
	
	sondregroup=new JPanel(new FlowLayout());
	idaff= new JPanel(new FlowLayout());
	sondeP=new JPanel(new GridLayout(5,2));
	sonde=new JPanel(new GridLayout(5,2));
	idtot=new JPanel(new BorderLayout());
	SondeGlobal= new JPanel(new BorderLayout());
				
	id = new JLabel("numero sonde : ");
	nom = new JLabel("nom : ");
	prenom = new JLabel("Prenom : ");
	telephone = new JLabel("telephone : ");
	
	
	
	//ajout des infos du sonde
	
	JLabel tid=new JLabel(Integer.toString(modsond.sonde.getNumSond()));
	JLabel tnom=new JLabel(modsond.sonde.getNomSond());
	JLabel tprenom=new JLabel(modsond.sonde.getPrenomSond());
	JLabel ttel=new JLabel(modsond.sonde.getTelephoneSond());
				
	//encadrement
	idtot.setBorder(BorderFactory.createLineBorder(Color.black));
	SondeGlobal.setBorder(BorderFactory.createLineBorder(Color.black));
				
	//alignement droite pour centrer
	id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
	nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
	prenom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
	telephone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				
	//ajout dans sondeP
				
	sondeP.add(tnom);
	sondeP.add(tprenom);
	sondeP.add(ttel);
	
				
	//ajout dans sonde
	sonde.add(nom);
	sonde.add(prenom);
	sonde.add(telephone);
	
	//positionnement des elements
	suivant.setPreferredSize(new Dimension(100, 40));
	appeler.setPreferredSize(new Dimension(100, 40));
				
	tid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
	idaff.add(id);
	idaff.add(tid);
	idtot.add(idaff,"North");
	idtot.add(SondeGlobal,"South");

	SondeGlobal.add(suivant,"East");
	SondeGlobal.add(appeler,"West");
	SondeGlobal.add(sondregroup,"North");
	sondregroup.add(sonde);
	sondregroup.add(sondeP);
	
	appeler.setIcon(new ImageIcon("Ressources/tel.png"));
	appeler.setToolTipText("Appeler le sonde");
	suivant.setToolTipText("Sonde suivant");
	appeler.setName("appeler");
	appeler.addActionListener(new QuestionnaireButton(appeler.getName(),this));
	suivant.setName("suivi");
	suivant.addActionListener(new QuestionnaireButton(suivant.getName(),this));
	
	
	//insertion de tous les elements
	this.add(idtot);
				
    }
}
