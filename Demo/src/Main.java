public class Main {
    public static void main(String[] args) {

        Personnage[] ennemis = new Personnage[2];

        ennemis[0] = new Humain("Jimmy Whooper");
        ennemis[1] = new Pokemon("Squirtle"); // le type de REFERENCE est Personnage

        Pokemon newSquirtle = new Pokemon("newSquirtle");

        Pokemon pokemon = new Pokemon("Pikachu");

		System.out.println(ennemis[0].toString()); // Jimmy Whooper
		System.out.println(ennemis[1].toString()); // Squirtle
		System.out.println(newSquirtle.toString()); // Squirtle
		ennemis[0].afficher();  // dessin
		ennemis[1].afficher();  //dessin
		newSquirtle.afficher();
        System.out.println(pokemon);  //Pikachu

        pokemon.attaquer(ennemis[0]); //Pikachu attaque Jimmy Whooper
        pokemon.attaquer(ennemis[1]);  //Pikachu attaque Squirtle (censé refuser mais attaque qd meme)
        pokemon.attaquer(newSquirtle); // refuse

        System.out.println(ennemis[0].toString()); // Jimmy Whooper (après attaque)
        System.out.println(ennemis[1].toString()); // Squirtle (après attaque)
        System.out.println(newSquirtle.toString()); //new Squirtle (après attaque) - pas réellement attaqué
        ennemis[0].afficher(); // dessin Jimmy Whooper (après attaque)
        ennemis[1].afficher(); // dessin Squirtle (après attaque)
        newSquirtle.afficher(); // dessin newSquirtle (après attaque) - pas réellement attaqué

    }
}
