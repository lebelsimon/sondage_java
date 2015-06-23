
public class Proposition {
	String texte;

	public Proposition(){
		this.texte=texte;
	}
	
	// Constructeur permettant de recopier une proposition 
	public Proposition(Proposition p) {
		super();
		this.texte = new String(p.texte);

	}
	
	// creer pour les test
	public Proposition(String t) {
		super();
		this.texte = t;

	}
	
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = new String(texte);
	}

	@Override
	public String toString() {
		return texte;
	}
	
}
