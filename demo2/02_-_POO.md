# 0.Rappeler que :
#### ==>  Toutes les questions générales vont sur le forum [Piazza](https://piazza.com/umontreal.ca/fall2023/1025/) du cours

# 1. Essayez de compiler le programme suivant :

```java
public class Print {

    public void print(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        int n = 13;
        print( n );
    }
}
```

Expliquez le problème.
### Solution:
  La méthode print est non statique(Print est défini comme une classe et non comme une méthode). 
  Donc on ne peut pas l,appeler dans le main qui est statique. Cela provoque une erreur de compilation.


# 2. Présenter les slides de JavaDoc et commenter la classe `De` précédente

**Souligner que le standard de documentation JavaDoc sera celui demandé 
pour la suite du cours.**
```java
/**
 * This is a Javadoc comment with <b>bold</b> and <i>italic</i> text.
 * You can also create a <a href="https://www.example.com">link</a>.
 */
public class MyClass {
    // Class implementation
}

/**
 * This is a Javadoc comment with an image:
 * <img src="images/myimage.png" alt="My Image">
 */
public class MyClass {
	// Class implementation
}

/**
 * This is a Javadoc comment with a <b>bold text</b> and a <a href="https://www.example.com">link</a>.
 * You can also create a list:
 * <ul>
 *   <li>Item 1</li>
 *   <li>Item 2</li>
 *   <li>Item 3</li>
 * </ul>
 */
public class MyClass {
	// Class implementation
}


```
[intellij et javadoc](https://www.jetbrains.com/help/idea/javadocs.html)

# 3. Concevez et écrivez une classe `De`, sachant que :

- Un dé a un certain nombre de faces (d6, d12, d20, autres)
- On peut lancer le dé pour obtenir un résultat allant de 1 à [maximum
  selon le nombre de côtés]
- On peut instancier un objet qui génère des nombres aléatoires avec :

    Random rand = new Random();
    rand.nextInt(maxN);

où rand.nextInt(maxN) retourne une valeur comprise entre 0 (inclus) et
maxN (exclus)

### Quels sont les attributs de l'objet ?
	solution:
    1. `nombreFaces` : c'est un attribut privé qui stocke le nombre de faces du dé(par exemple, 6 pour un dé à 6 faces). 
    Cet attribut est initialisé dans le constructeur.
    2. `rand`: C'est un object de la classe `Random` qui sera utilisé pour générer des nombres aléatoires. 

### Quel est le constructeur ?
    solution: Le constructeur public De(int nombreFaces) est utilisé pour créer une instance de la classe De. Lorsque 
    vous instanciez un objet de cette classe, vous spécifiez le nombre de faces du dé en paramètre, ce qui permet d'initialiser les attributs nombreFaces et rand.


### A-t-on besoin de variables/méthodes statiques ?
	solution: Non, vous n'avez pas besoin de varibles statique pour cette classe, car chaque instance de la classe De 
      encapsule les infos sur un dé spécifique et utilise un générateur de nombre aléatoires intépendant pour produire des résultats aléatoires.

#### Variebles statiques et méthodes statiques
1. `Constantes partagées` :
```java
public class Math {
	public static final double PI = 3.14159265358979323846;
}
```
2. Méthodes utilitaires :
```java
public class UtilitairesMath {
    public static double carre(double x) {
        return x * x;
    }
}
```

# 4. On veut modéliser un village, ces habitants et la collecte des impôts au fil des années. 
Spécifications:
 - Les villageois commencent tous avec 100$
 - Chaque année, un villageois gagne son âge x10 en salaire
 - L'impôt n'est pas récolté pour les villageois de moins de 20 ans
 - Le taux d'impôt est de 10% (0.1).
 
 Planification:
 - A. Création de la classe Villageois
 - B. Création de la classe Village
 - C. Clacul des impôts récoltés sur 5 ans
 
#### A. Création de la classe Villageois
	- Pour représenter un villageois, il doit posséder:
		 - un prenom (string)
		 - un nom (String)
		 - Un age (int)
		 - Une propriété «argent» (double)
		 - Un constructeur qui prend des arguments correspondant aux propriétés et qui les initialise
		 - Une méthode «vieillir» qui accepte un nombre d'années et qui augmente la propriété «age» de ce nombre
	- Notre premier Villageois!
		- Dans la méthode statique main de notre classe Main, créer un villageois
		- Ensuite, on l'affiche
		- Ensuite, on le fait veillir de 10 ans et on le réaffiche
		
#### B. Création de la classe Village
	- Notre village doit avoir:
		- un nom (String)
		- une population (tableau de Villageois)
		- une proprieté fondsPublics (double)
		- Un constructeur qui prend des arguments correspondant aux propriétés et qui les initialise
	- Noter premier Village!
		- Dans la méthode main de la classe Main, créer:
			- La variable «population», un table de Villageois
			- La variable «ProgLand», un Village avec le nom «ProgLand» et la population créée à l'étape précédente
		- Afficher le village
			- Ajouter la méhtode .toString() au village.
				-Celui-ci doit retourner un joli String contenant le nom du village, la valeur des fondsPublics et la population

#### C. Calcul des impôts
	 - Évoluons la fonctionnalité au Villageois
		- Ajouter la méthode recevoirArgent qui prend un montant et l'ajoute à la proprieté argent du Villageois
		- Ajouter la méthode payerImpot qui prend un taux d'impôt (double). Avec ce taux elle calcule le montant à payer, retire ce nombre à la propriété argent et le retourne
		
	 - Évoluons la fonctionnalité au Village
		- Ajouter la méthode «avancerUnAn» qui fait vieillir tous les habitants de 1 an et qui les paye
		- Ajouter la méthode «recolterImpot» qui accepte un taux d'impôt. Elle fait la somme de la recolte des impôts de tous le villageois (qui ont plus de 20 ans) et augmente la propriété fondsPublics de cette somme

```java
public class Main {
	public static void main(String[] args) {
		double tauxImpot = 0.1; // 10%
		
		Villageois[] population = {
			new Villageois("Jean", "Til", 38),
			new Villageois("Roxanne", "PotDeVin", 16),
			new Villageois("Jeanne", "Manse", 27),
			new Villageois("Paul", "Picard", 44),
			new Villageois("Stéphane", "ChampsGauche", 10),
			new Villageois("Annie", "Tyr", 78),
		};

		Village progLand = new Village("ProgLand", population);
		System.out.println("Fonds publics initiaux: " + progLand.getFondsPublics() + "$");

		for (int i = 0; i < 5; i++) { // récolte des impôts sur 5 ans
			progLand.avancerUnAn();
			progLand.recolterImpot(tauxImpot);
		}

		System.out.println("Fonds publics finaux: " + progLand.getFondsPublics() + "$"); // 2929.1631000000007$
	}
}
```
