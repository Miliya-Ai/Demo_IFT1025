# 1. Écrire une classe abstraite Personnage

Un personnage a une représentation ASCII et un nom

Le constructeur devrait être : public Personnage(String nom)

La méthode personnage.afficher() devrait afficher la tête, le corps et
les jambes


# 2. Écrire une sous-classe Humain et une sous-classe Pokemon

Leurs représentations ASCII sont les suivantes :

Humain :
```
       -----
      ( o.o )
       -----
         |
      <--|-->
        / \
       /   \
```

Pokemon :
```
           ___
          (ô.ô)
           -v-
         <(   )>
          (___)
           m m
```


Un pokémon peut être dans un des deux états : capturé ou non.

Dans le cas où le pokémon est capturé, on va plutôt afficher une
pokéball comme représentation :


Pokeball :
```
    -------
  -/       \-
 /           \
 +-----O-----+
 \.........../
  -\......./-
    -------
```

# 3. Ajouter une méthode attaquer(Personnage autre) et un attribut HP
(health points) dans la classe abstraite Personnage

Lorsqu'un personnage attaque un autre personnage, on décrémente les HP
de la victime.


Lorsque les HP d'un Pokemon tombent à 0, il devient capturé

Lorsque les HP d'un Humain tombent à 0, sa représentation ASCII
devient :

```
       -----
      ( x.x )
       -----
         |
      <--|-->
        / \
       /   \

```

# 4. Redéfinir la méthode toString() de Personnage pour qu'elle affiche:

    Nom : HP

Avec le nom et le nombre de HP du personnage

Redéfinir également la méthode toString() de Pokemon pour qu'elle ajoute :

    Nom : HP (capturé)

Dans le cas où le pokémon est capturé

Tester tout ça dans le main()


# 5. Surchargez la fonction attaquer() de Pokemon :

attaquer(Pokemon autre)

Lorsqu'on demande à un Pokemon d'attaquer à un autre Pokemon, il ne
l'attaque pas et dit plutôt (à coups de System.out.println) :

    Pika pika pika pika !!

    (Traduction : Je trouve révoltant qu'en 2023, on tente encore de
    me faire combattre à des fins de compétitions. Je refuse de me
    battre contre l'un de mes confrères)


# 6. Que se passe-t-il si on exécute ce code ?

```java

Personnage[] ennemis = new Personnage[2];

ennemis[0] = new Humain("Jimmy Whooper");
ennemis[1] = new Pokemon("Squirtle");


Pokemon pokemon = new Pokemon("Pikachu");

pokemon.attaquer(ennemis[0]);
pokemon.attaquer(ennemis[1]);

```

Expliquer ce qui se passe

Trouver une façon de faire fonctionner "correctement" :

```java
pokemon.attaquer(ennemis[0]); // Attaque l'Humain
pokemon.attaquer(ennemis[1]); // Refuse d'attaquer le Pokemon
```


