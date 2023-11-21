### 1. Faire le code Client serializer et envoyer un objet Mot (codes/Fichiers/Mot.java) à le serveur et faire le serveur deserialiser l'objet et l'imprimer.
    - Écrivez un sérialiseur côté client pour envoyer des objets Mot au serveur.
    - Écrivez un désérialiseur côté serveur qui reçoit l'objet Mot envoyé par le client et le désérialise.
    - Imprimez l'objet Mot désérialisé sur le serveur.

### 2. Envoyer un liste des Mots via un socket, comme ci-dessus. Discuter les deux options: le faire ``en transferrant un objet ArrayList<Mot>`` ou ``transferrer un Mot à la fois et faire le serveur recreer sa propre ArrayList``.
### Sujets: overhead de sérialisation, granularité de controle, latence, gérer interruptions réseau, complexité du code
   ```text
   en transferrant un objet ArrayList<Mot>:
    - overhead de sérialisation
    - granularité de controle
    - latence
    - gérer interruptions réseau
    - complexité du code
    
   transferrer un Mot à la fois et faire le serveur recreer sa propre ArrayList:
    - overhead de sérialisation
    - granularité de controle
    - latence
    - gérer interruptions réseau
    - complexité du code
   ```

| Tables                     | un objet ArrayList<Mot> | un Mot à la fois |
|----------------------------|:-----------------------:|-----------------:|
| overhead de sérialisation  |            ✅            |                  |
| granularité de controle    |                         |                  |
| latence                    |                         |                  |
| gérer interruptions réseau |                         |                  |
| complexité du code         |                         |                  |

### 3. Adaptez le code Client.java et SimpleJavaServer.java pour que le client envoie la commande ping au serveur et le serveur repond avec la commande pong via un seul socket. Faire un ping-pong 4 fois.

### 4. La même chose mais avec JavaServer et event handlers.

