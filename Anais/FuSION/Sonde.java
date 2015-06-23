import java.util.ArrayList;

/**
 * 
 */

/**
 * @author dmartin
 * 
 */
public class Sonde {
	private int numSond, dateNaissSond;
	private String nomSond, prenomSond, telephoneSond;
	private String idC;
	private ArrayList<Integer> listeQuestionnaire;

	// constructeur
	public Sonde(int numSond, String nomSond, String prenomSond, int dateNaissSond, String telephone, String idCategorie) {
		this.numSond = numSond;
		this.nomSond = nomSond;
		this.prenomSond = prenomSond;
		this.dateNaissSond = dateNaissSond;
		this.telephoneSond = telephone;
		this.idC = idCategorie;
		this.listeQuestionnaire = new ArrayList<Integer>();
	}

	public Sonde(Sonde s) {
		this.numSond = s.getNumSond();
		this.nomSond = s.getNomSond();
		this.prenomSond = s.getPrenomSond();
		this.dateNaissSond = s.getDateNaissSond();
		this.telephoneSond = s.getTelephoneSond();
		this.idC=s.getIdC();
	}

	// getters et setters
	public int getNumSond() {
		return numSond;
	}

	public void setNumSond(int numSond) {
		this.numSond = numSond;
	}

	public int getDateNaissSond() {
		return dateNaissSond;
	}

	public void setDateNaissSond(int dateNaissSond) {
		this.dateNaissSond = dateNaissSond;
	}

	public String getNomSond() {
		return nomSond;
	}

	public void setNomSond(String nomSond) {
		this.nomSond = nomSond;
	}

	public String getPrenomSond() {
		return prenomSond;
	}

	public void setPrenomSond(String prenomSond) {
		this.prenomSond = prenomSond;
	}

	public String getTelephoneSond() {
		return telephoneSond;
	}

	public void setTelephoneSond(String telephoneSond) {
		this.telephoneSond = telephoneSond;
	}

	public String getIdC() {
		return idC;
	}

	public void setIdC(String idC) {
		this.idC = idC;
	}

	public void addQuestionnaire(int idQ){
		this.listeQuestionnaire.add(idQ);
	}
	
	public ArrayList<Integer> getListeQuestionnaire(){
		return this.listeQuestionnaire;
	}
	
	@Override
	public String toString() {
		return "Sonde [numSond=" + numSond + ", dateNaissSond=" + dateNaissSond
				+ ", nomSond=" + nomSond + ", prenomSond=" + prenomSond
				+ ", telephoneSond=" + telephoneSond + ", idC=" + idC + ", listeQuestionnaire="+ listeQuestionnaire+ "]";
	}

}
