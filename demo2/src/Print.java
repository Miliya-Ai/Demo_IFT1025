/*public class Print {

    public static void print(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        int n = 13;
        print( n );
    }
}*/

//------------------------------------------------------------
// Solution 1: Faite de la méthode print une méthode statique
/*public class Print {

    public static void print(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        int n = 13;
        print(n);
    }
}*/

// Solution 2: Créez un objet de type Print et appelez la méthode print sur cet objet

/**
 * Classe permettant d'afficher un entier
 */
public class Print {

    public void print(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        int n = 13;
        Print printer = new Print(); // Crée une instance de la classe Print
        printer.print(n); // Appelle la méthode print sur l'instance créée
    }
}
