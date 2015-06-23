/**
 * 
 */

/**
 * @author dmartin
 *
 */
public class Utilisateur {
	private int idU;
	private String nomU, prenomU, login, motDePasse, role;
	
	public Utilisateur(int idU, String nomU, String prenomU, String login, String motDePasse, String role){
		this.idU=idU;
		this.nomU=nomU;
		this.prenomU=prenomU;
		this.login=login;
		this.motDePasse=motDePasse;
		this.role=role;
	}	

	// getters et setters
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getNomU() {
		return nomU;
	}
	public void setNomU(String nomU) {
		this.nomU = nomU;
	}
	public String getPrenomU() {
		return prenomU;
	}
	public void setPrenomU(String prenomU) {
		this.prenomU = prenomU;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	@Override
	public String toString(){
		String res="";
		res+="Nom : "+this.nomU+"\n";
		res+="Prenom : "+this.prenomU+"\n";
		res+="idU : "+this.idU+"\n";
		res+="Login : "+this.login+"\n";
		res+="Mot de passe : "+this.motDePasse+"\n";
		res+="Role : "+this.role+"\n";
		return res;

	}
}
