/***
 * 
 * Démonstration #03
Insister sur le fait que l'indentation est automatisée dans les IDEs
et qu'il n'y a pas d'excuse pour remettre un code non-indenté...

Mentionner qu'il faudrait commencer à utiliser la JavaDoc.

1. Écrire une classe abstraite Personnage

Un personnage a une représentation ASCII et un nom

Le constructeur devrait être : public Personnage(String nom)

La méthode personnage.afficher() devrait afficher la tête, le corps et
les jambes

 *
 */

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

	public void setHP(int hP) {
		HP = hP;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void afficher(){
	}

	/*
	 * 
4. Redéfinir la méthode toString() de Personnage pour qu'elle
   affiche :
    Nom : HP

Avec le nom et le nombre de HP du personnage

Tester tout ça dans le main()
	 * */


	public String toString() {
		return nom + ": " + HP;
	}


	/*
	 * 
	3. Ajouter une méthode attaquer(Personnage autre) et un attribut HP
	(health points) dans la classe abstraite Personnage

	Lorsqu'un personnage attaque un autre personnage, on décrémente les HP
	de la victime.

	Lorsque les HP d'un Pokemon tombent à 0, il devient capturé

	Lorsque les HP d'un Humain tombent à 0, sa représentation ASCII
	devient :

	       -----
	      ( x.x )
	       -----
	         |
	      <--|-->
	        / \
	       /   \


	 * */

	public void attaquer(Personnage autre){
		autre.HP--; //Lorsqu'un personnage attaque un autre personnage, on décrémente les HP
		//		de la victime.
	}


}
