package personnages;

@SuppressWarnings("unused")
public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois; 
	private int nbVillageois=0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterhabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois +=1;
	}

	public Gaulois trouverHabitant(int nb_cherche) {
		return villageois[nb_cherche];
	}
	
	public void afficherGaulois() {
		System.out.println("Dans le village du chef "+ chef.getNom() + " vivent les légendaires gaulois");
		for (int i=0; i<nbVillageois; ++i){
			System.out.println("-" + villageois[i].getNom());	
		}
	}
	
	public static void main(String[] args) {
		Village irreductible= new Village("Village des Irréductibles", 30);
		Chef abraracourcix = new Chef("Abraracourcix", 6, irreductible);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		irreductible.setChef(abraracourcix);
		irreductible.ajouterhabitant(obelix);
		irreductible.ajouterhabitant(asterix);
		System.out.println(irreductible.trouverHabitant(0));
		irreductible.afficherGaulois();
		
		/*Gaulois gaulois = village.trouverHabitant(30);*/
		/*Gaulois gaulois = village.trouverHabitant(1);*/
		/*System.out.println(gaulois);*/
		
	}
}
