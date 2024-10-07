package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force > 0;

		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[Equipement.values().length];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " '" + texte + "' ");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forse_avant = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forse_avant > force;
	}

    private boolean possedeDejaEquipement(Equipement equip) {
        for (int i = 0; i < nbEquipement; i++) {
            if (equipements[i] == equip) {
                return true;
            }
        }
        return false;
    }

    private void equiper(Equipement equip){
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equip.toString() + " !");
        equipements[nbEquipement] = equip;
        nbEquipement++;
    }

	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
			case 2:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1:
                if(possedeDejaEquipement(equip)){
                    System.out.println("Le soldat " + nom + " possède déjà un " + equip.toString() + " !");
                    break;
                }
				else equiper(equip);
                break;
			case 0:
                equiper(equip);
				break;
            default:
                System.out.println("Erreur inattendue dans sEquiper");
                break;
		}
	}

	public static void main(String[] args) {
		Romain romain = new Romain("Minus", 3);
		System.out.println(romain);
		romain.prendreParole();
		romain.parler("Hello");
		romain.recevoirCoup(1);

		romain.sEquiper(Equipement.CASQUE);
        romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
        romain.sEquiper(Equipement.BOUCLIER);
		romain.recevoirCoup(1);
		romain.recevoirCoup(1);

	}
}
