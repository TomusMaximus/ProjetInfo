package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom; 
		this.effetPotionMax = effetPotionMax;
		this.effetPotionMin = effetPotionMin;
		parler(" Bonjour , je suis le druide " + nom + " et ma position peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}
	public void parler (String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	public int preparerPotion() {
		 Random generateur = new Random();
		 int forcePotion = generateur.nextInt(effetPotionMax-effetPotionMin);
		 if  (forcePotion > 7) {
			parler(" J'ai préparé une super potion de force : " + forcePotion);
		}
		else {
			parler(" Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force : " + forcePotion);
		}
		 return forcePotion;
	}
	
	public void booster(Gaulois gaulois, int forcePotion) {
		if (gaulois.getNom() == "Obelix") {
			parler("Non, Obélix!... Tu n'auras pas de potion magique !");
		}
		else {
			gaulois.boirePotion(forcePotion);
		}
	}

	private String prendreParole() {
		return "Le druide " + nom + ";";
	}

	public static void main(String[] args) {
		Druide test = new Druide("Test", 5, 10);
		test.preparerPotion();
	}


}
