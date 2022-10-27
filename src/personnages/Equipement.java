package personnages;

public enum Equipement {
	BOUCLIER("Bouclier"), CASQUE("Casque");
	private String nom;
	
	private Equipement(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}

}