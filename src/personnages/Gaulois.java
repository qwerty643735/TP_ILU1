package personnages;

public class Gaulois {

	private String nom;
    private int force;
    private int nbTrophees;
	private int effetPotion = 1;
    private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

    private String prendreParole() {
        return "Le gaulois " + nom + " : ";
    }

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup(force*effetPotion / 3);
//	}

    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
                Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
        for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
            this.trophees[nbTrophees] = trophee[i];
        }
    }

	public void boirePotion(int forcePotion) {
		effetPotion += forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois decuplee");
	}

	public String params() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Hello");
		Romain romain = new Romain("romain", 3);
		asterix.frapper(romain);
		asterix.boirePotion(6);
        System.out.println(asterix.params());
	}
}
