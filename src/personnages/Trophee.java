package personnages;

@SuppressWarnings("unused")
public class Trophee {
	private Gaulois gaulois;
	private Equipement[] equipements = new Equipement[2];


	public Trophee(Gaulois gaulois, Equipement[] equipements) {
		this.gaulois = gaulois;
		this.equipements = equipements;
	}

	public void donnerNom(Gaulois gaulois) {
		this.gaulois = gaulois;
	}
	
}
