import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            // 127.0.0.1 => Adresse spéciale qui correspond toujours à la machine locale (localhost)

            // Création d'un objet Mot
            Mot mot = new Mot("Bonjour");

            // Envoi de l'objet Mot au serveur, on crée un flux de sortie
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(mot); // On envoie l'objet
            objectOutputStream.close(); // On ferme le flux
            socket.close(); // On ferme la connexion
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
