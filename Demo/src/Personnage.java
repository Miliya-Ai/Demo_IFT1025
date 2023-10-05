public abstract class Personnage {
	private int HP; 
	private String nom; 

	public Personnage(String nom) {
		this.nom = nom;
		this.HP = 1;
	}

	public int getHP() {
		return HP;
	}

	public void afficher(){
	}

	public String toString() {
		return nom + ": " + HP;
	}

	public void attaquer(Personnage autre){
		autre.HP--;
	}


}
