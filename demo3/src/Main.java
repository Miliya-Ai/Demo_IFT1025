public class Main {

    public static void main(String[] args) {
        Personnage[] ennemis = new Personnage[2];

        ennemis[0] = new Humain("Jimmy Whooper", 100, 100);
        ennemis[1] = new Pokemon("Squirtle", 100, 100);


        Pokemon pokemon = new Pokemon("Pikachu", 100, 100);

        pokemon.attaquer(ennemis[0]);
        pokemon.attaquer(ennemis[1]);

    }
}
