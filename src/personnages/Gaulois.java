package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Equipement[] getTrophees() {
		return trophees;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + ":";
//	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + "envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbtrophees++) {
			this.trophees[nbtrophees] = trophees[i];
		}
		System.out.println(nom + "envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force/3)*effetPotion);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonnation(Musee musee) {
		if (trophees == null)
			return;
		parler("Je donne au musee tous mes trophees :");
		for (int i=0; i < trophees.length; i++) {
//			musee.donnerTrophees() +=1;
			System.out.println("\n -"+ trophees[i]);	
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.nom);
		asterix.parler("Par Tentoutatix");
		Romain julius = new Romain("Jules", 5);
		asterix.boirePotion(5);
		asterix.frapper(julius);
	}
}
 