package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain minus= new Romain("Minus", 8);
		Gaulois asterix = new Gaulois("Asterix", 6);
		Gaulois obelix = new Gaulois("Obélix", 30);
		panoramix.preparerPotion();
		panoramix.parler("JE vais aller préparer une petite potion...");
		int potion = panoramix.preparerPotion();
		panoramix.booster(obelix, potion);
		obelix.parler("Par Bélénos ce n'est pas juste !");
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		while (minus.getforce() > 0) {
			asterix.frapper(minus);
		}

	}
}
