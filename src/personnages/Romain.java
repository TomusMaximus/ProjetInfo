package personnages;

import java.util.Objects;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement;
	private String texte;
	
	
	public Romain(String nom, int force) {
		assert force >0;
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
	
//	public void recevoirCoup(int forceCoup) {
//		force -= forceCoup;
//		if (force >0) {
//			parler("A�e");
//		}
//		else {
//			parler("J'abandonne...");
//		}
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculresistanceequiment(forceCoup);
		force -= forceCoup;
		if (force >= 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculresistanceequiment(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
				resistanceEquipement += 8;
			} else {
			System.out.println("Equipement casque");
			resistanceEquipement += 5;
			}
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (resistanceEquipement < forceCoup) {
			forceCoup -= resistanceEquipement;
		}
		else {
			forceCoup = 1;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;		
	}
	


	public void sEquiper(Equipement armure) {
		switch(nbEquipement){
			case 0:
				equipements[0] = armure;
				System.out.println("Le soldat " + nom + " s'�quipe avec un "+ armure.toString());
				nbEquipement = 1;
				break;
			case 1:
				if (Objects.equals(equipements[0].toString(), armure.toString())) {
					System.out.println("Le soldat " + nom + " poss�de d�j� un " + armure.toString() + ".");
				}
				else {
					equipements[1] = armure;
					System.out.println("Le soldat " + nom + " s'�quipe avec un "+ armure.toString());
					nbEquipement = 2;
				}
			break;
			default:
				System.out.println("Le soldat " + nom + " est d�j� bien prot�g� !");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain maximus = new Romain("Maximus", 5);
		System.out.println(maximus.nom);
		maximus.prendreParole();
		maximus.parler("Non s'il vous plait.");
		maximus.recevoirCoup(4);
		Romain minus = new Romain("Minus", 3);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
