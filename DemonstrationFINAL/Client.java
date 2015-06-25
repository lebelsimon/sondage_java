/**
 * @author Damien MARTIN
 */

public class Client {
    int numero;
    String raisonSociale;
    String adresse1;
    String adresse2;
    int codePostal;
    String ville;
    String telephone;
    String email;
	
    public Client(int numero, String raisonSociale, String adresse1,
		  String adresse2, int codePostal, String ville, String telephone,
		  String email) {
	super();
	this.numero = numero;
	this.raisonSociale = raisonSociale;
	this.adresse1 = adresse1;
	this.adresse2 = adresse2;
	this.codePostal = codePostal;
	this.ville = ville;
	this.telephone = telephone;
	this.email = email;
    }

    public Client(String raisonSociale, String adresse1, String adresse2,
		  int codePostal, String ville, String telephone, String email) {
	super();
	this.numero=-1;
	this.raisonSociale = raisonSociale;
	this.adresse1 = adresse1;
	this.adresse2 = adresse2;
	this.codePostal = codePostal;
	this.ville = ville;
	this.telephone = telephone;
	this.email = email;
    }
	
	//retourne l'identifiant du client
    public int getNumero() {
	return numero;
    }
	

	//permet de modifier l'identifiant du client
    public void setNumero(int numero) {
	this.numero = numero;
    }
	
	//retourne la raison sociale du client
    public String getRaisonSociale() {
	return raisonSociale;
    }

	//permet de modifier la raison sociale
    public void setRaisonSociale(String raisonSociale) {
	this.raisonSociale = raisonSociale;
    }

	//retourne la premiere adresse du client
    public String getAdresse1() {
	return adresse1;
    }
	
	//permet de modifier la premiere adresse du client
    public void setAdresse1(String adresse1) {
	this.adresse1 = adresse1;
    }

	//retourne la seconde adresse du client
    public String getAdresse2() {
	return adresse2;
    }

	//permet de modifier la premiere adresse du client
    public void setAdresse2(String adresse2) {
	this.adresse2 = adresse2;
    }

	//retourne le code postal du client
    public int getCodePostal() {
	return codePostal;
    }

	//permet de modifier le code postal du client
    public void setCodePostal(int codePostal) {
	this.codePostal = codePostal;
    }

	//retourne la ville du client
    public String getVille() {
	return ville;
    }

	//permet de modifier la ville du client
    public void setVille(String ville) {
	this.ville = ville;
    }

	//retourne le numero de telephone du client
    public String getTelephone() {
	return telephone;
    }

	//permet de modifier le code postal du client
    public void setTelephone(String telephone) {
	this.telephone = telephone;
    }

	//retourne l'email du client
    public String getEmail() {
	return email;
    }

	//permet de modifier l'email du client
    public void setEmail(String email) {
	this.email = email;
    }
	
	//permet d'afficher les informations d'un client
    public void affiche(){
	System.out.println("Numero :"+this.numero+ "\nRaison sociale : "+this.raisonSociale);
	System.out.println("Adresse : "+this.adresse1);
	System.out.println("          "+this.adresse2);
	System.out.println("          "+this.codePostal+ " "+this.ville);
	System.out.println("Telephone :"+this.telephone+" Email :"+this.email);
    }
	
	
}
