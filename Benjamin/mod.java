import javax.swing.*;
import java.util.*;

import java.awt.*;

		// Panel Module Sondage
		@SuppressWarnings("serial")
		public class mod extends Module{
			JLabel nom;
			JLabel prenom;
			JLabel telephone;
			JLabel id;
			JPanel sonde; //contient le nom prenom tel du sonde
			JPanel idtot; //contient l'id et SondeGlobal
			JPanel sondeP;//contien les informations de la BD
			JPanel SondeGlobal;//contient sonde et sondeP pour la centrer par rapport a ':'
			//liste de sonde bidon en attendant la BD
			ArrayList<String> son = new ArrayList<String>();
			
			public mod(){
				
				sondeP=new JPanel(new GridLayout(4,2));
				sonde=new JPanel(new GridLayout(4,2));
				idtot=new JPanel(new BorderLayout());
				SondeGlobal= new JPanel(new FlowLayout());
				
				id = new JLabel("identifiant sonde: ");
				nom = new JLabel("nom: ");
				prenom = new JLabel("Prenom: ");
				telephone = new JLabel("telephone: ");
				
				//test alignement
				JLabel t1=new JLabel("toto");
				JLabel t2=new JLabel("tataqgtergaertg");
				JLabel t3=new JLabel("0606441017");
				
				//encadrement
				idtot.setBorder(BorderFactory.createLineBorder(Color.black));
				SondeGlobal.setBorder(BorderFactory.createLineBorder(Color.black));
				
				//alignement droite pour centrer
				nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				prenom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				telephone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				
				//alignement gauche pour centrer
				t1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
				t2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
				
				//ajout dans sondeP
				sondeP.add(t1);
				sondeP.add(t2);
				sondeP.add(t3);
				
				//ajout dans sonde
				sonde.add(nom);
				sonde.add(prenom);
				sonde.add(telephone);
				
				//ajout dans SondeGlobal
				SondeGlobal.add(sonde);
				SondeGlobal.add(sondeP);
				
				
				idtot.add(id,"North");
				idtot.add(SondeGlobal,"South");
				
				
				this.add(idtot);
				
			}
		}
