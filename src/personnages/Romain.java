package personnages;

@SuppressWarnings("unused")
public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement;
	
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
	
	public void sEquiper(Equipement armure) {
		switch(nbEquipement){
			case 0:
				equipements[0] = armure;
				System.out.println("Le soldat " + nom + " s'équipe avec un "+ armure.toString());
				nbEquipement = 1;
				break;
			case 1:
				if (equipements[0].toString() == armure.toString()) {
					System.out.println("Le soldat " + nom + " possède déjà un " + armure.toString() + ".");
				}
				else {
					equipements[1] = armure;
					System.out.println("Le soldat " + nom + " s'équipe avec un "+ armure.toString());
					nbEquipement = 2;
				}
			break;
			default:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain maximus = new Romain("Maximus", 5);
		System.out.println(maximus.nom);
		maximus.prendreParole();
		maximus.parler("Non s'il vous plait.");
		maximus.recevoirCoups(4);
		Romain minus = new Romain("Minus", 3);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
