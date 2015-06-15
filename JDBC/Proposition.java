
public class Proposition {
	String texte;
	boolean valide;
	
	public Proposition(String texte, boolean valide) {
		super();
		this.texte = new String(texte);
		this.valide = valide;
	}
	
	// Constructeur permettant de recopier une proposition 
	public Proposition(Proposition p) {
		super();
		this.texte = new String(p.texte);
		this.valide = p.valide;
	}
	
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = new String(texte);
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	@Override
	public String toString() {
		if (valide)
			return texte + " [V]";
		else
			return texte + " [F]";
	}
	
}
