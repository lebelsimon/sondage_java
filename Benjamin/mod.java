import javax.swing.*;
import java.util.*;
import java.sql.Connection;
import java.sql.*;
import java.util.Random;
import java.awt.*;

// Panel Module Sondage
@SuppressWarnings("serial")
public class mod extends Module{
			
    JLabel nom;
    JLabel prenom;
    JLabel telephone;
    JLabel id;
    JPanel sonde; //contient le nom prenom tel du sonde
    JPanel idaff;
    JPanel idtot; //contient l'id et SondeGlobal
    JPanel sondeP;//contien les informations de la BD
    JPanel SondeGlobal;//contient sonde et sondeP pour la centrer par rapport a ':'
    Sonde toto;
    SondeBD info;
			
    public mod(){
	try{
	    ConnexionMySQL co = new ConnexionMySQL("jdbc:mysql://servinfo-db:3306/","dbdmartin","dbdmartin","/home/dmartin");
	    info = new SondeBD(co);

	}
	catch(Exception e){
	    System.out.println(e);
	    System.out.println("coucou");
	}
	
				
			
	idaff= new JPanel(new FlowLayout());
	sondeP=new JPanel(new GridLayout(4,2));
	sonde=new JPanel(new GridLayout(4,2));
	idtot=new JPanel(new BorderLayout());
	SondeGlobal= new JPanel(new FlowLayout());
				
	id = new JLabel("numero sonde : ");
	nom = new JLabel("nom : ");
	prenom = new JLabel("Prenom : ");
	telephone = new JLabel("telephone : ");
	
	Sonde toto = selectSond();
	
	//ajout des infos du sonde
	JLabel tid=new JLabel(Integer.toString(toto.getNumSond()));
	JLabel tnom=new JLabel(toto.getNomSond());
	JLabel tprenom=new JLabel(toto.getPrenomSond());
	JLabel ttel=new JLabel(toto.getTelephoneSond());
				
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
				
	//ajout dans SondeGlobal
	SondeGlobal.add(sonde);
	SondeGlobal.add(sondeP);
				
				
	tid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
	idaff.add(id);
	idaff.add(tid);
	idtot.add(idaff,"North");
	idtot.add(SondeGlobal,"South");
				
				
	this.add(idtot);
				
    }
    public Sonde selectSond(){

		ArrayList <Sonde> list=info.getListeSonde();
		Random random = new Random();
		int ind=random.nextInt(list.size());	
		toto = new Sonde(list.get(ind));
		info.supprimerSonde(toto.getNumSond());
		//~ list.remove(ind);
		//~ System.out.println(toto.getNumSond()+"tes");
		return toto;
	}
}
