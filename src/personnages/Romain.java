package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getforce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(texte);
	}
	
	private String prendreParole() {
		return "Le romain" + nom +" : ";
	}
	
	public void recevoirCoups(int forceCoup) {
		force -= forceCoup;
		if (force >0) {
			parler("Aïe");
		}
		else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		Romain maximus = new Romain("Maximus", 5);
		System.out.println(maximus.nom);
		maximus.prendreParole();
		maximus.parler("Non s'il vous plaît.");
		maximus.recevoirCoups(4);
	}
}
