package personnages;

@SuppressWarnings("unused")
public class Trophee {
	private Gaulois gaulois;
	private Equipement[] equipements = new Equipement[2];

	public Trophee(Equipement[] equipements) {
		this.equipements = equipements;
	}
	
	public void donnerNom(Gaulois gaulois) {
		this.gaulois = gaulois;
	}
	
	public Equipement[] getequipements() {
		return equipements;
	}
}
