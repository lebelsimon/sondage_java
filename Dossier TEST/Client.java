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

    public int getNumero() {
	return numero;
    }

    public void setNumero(int numero) {
	this.numero = numero;
    }

    public String getRaisonSociale() {
	return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
	this.raisonSociale = raisonSociale;
    }

    public String getAdresse1() {
	return adresse1;
    }

    public void setAdresse1(String adresse1) {
	this.adresse1 = adresse1;
    }

    public String getAdresse2() {
	return adresse2;
    }

    public void setAdresse2(String adresse2) {
	this.adresse2 = adresse2;
    }

    public int getCodePostal() {
	return codePostal;
    }

    public void setCodePostal(int codePostal) {
	this.codePostal = codePostal;
    }

    public String getVille() {
	return ville;
    }

    public void setVille(String ville) {
	this.ville = ville;
    }

    public String getTelephone() {
	return telephone;
    }

    public void setTelephone(String telephone) {
	this.telephone = telephone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
	
    public void affiche(){
	System.out.println("Numero :"+this.numero+ "\nRaison sociale : "+this.raisonSociale);
	System.out.println("Adresse : "+this.adresse1);
	System.out.println("          "+this.adresse2);
	System.out.println("          "+this.codePostal+ " "+this.ville);
	System.out.println("Telephone :"+this.telephone+" Email :"+this.email);
    }
	
	
}
