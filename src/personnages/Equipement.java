package personnages;

public enum Equipement {
	CASQUE("casque"),
	BOUCLIER("bouclier");

	String nom;

	Equipement(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}
}
