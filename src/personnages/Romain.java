package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert force > 0;
		
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forse_avant = force;
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		assert forse_avant > force;
	}
	
	public static void main(String[] args) {
		Romain romain = new Romain("romain", 3);
		System.out.println(romain);
		romain.prendreParole();
		romain.parler("Hello");
		romain.recevoirCoup(4);
	}
}
