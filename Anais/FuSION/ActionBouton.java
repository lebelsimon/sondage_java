import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class ActionBouton implements ActionListener {
	
    // Lien vers le questionnaire pour pouvoir modifier certaines de ses propriétés
    //~ Questionnaire q;
	
    // nom du bouton:
    String nom;
    Connexion conn;
	
    // Constructeur
    public ActionBouton(String _nom, Connexion conn){
	this.nom=_nom;
	this.conn=conn;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	String role="";
	int idU;
	Utilisateur u=null;
	// on change l'affichage en fonction du boutons choisi
	switch (this.nom){	
	case "connexion":
	    UtilisateurBD utili=null;
	    try{
		utili = new UtilisateurBD(this.conn.c);
	    }
	    catch(SQLException e){System.out.println(e);}
	    u=utili.connexionUtilisateur(this.conn.texteID.getText(), this.conn.texteMdp.getText());
	    role=u.getRole();
	    //idU=u.getIdU();
	    break;

	case "mdp":
	    System.out.println("mdp oublié");
	}
	System.out.println(role);
	switch(role){
	//~ case "Concepteur":
	    //~ conn.dispose();
	    //~ VueGestQuest Appli = new VueGestQuest(this.conn.c);
	    //~ break;
	case "Sondeur":
	    conn.dispose();
		System.out.print("yooooo");
	    Fenetre fen = new Fenetre(u);
	    fen.SetModule(new ModuleSondage(this.conn.c, u, fen));
	    break;
	//~ case "Analyste":
	    //~ conn.dispose();
	    //~ Analyse_Questionnaire analyse = new Analyse_Questionnaire();
	    //~ break;
	 }
    }

}
