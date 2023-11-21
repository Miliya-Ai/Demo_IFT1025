import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Création du serveur sur le port 12345, ici on pas spécifié l'nombre de clients
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Serveur en attente de connexion");

            // Attente d'une connexion d'un client
            Socket socket = serverSocket.accept();
            System.out.println("Connexion établie");

            System.out.println("Adresse du client: " + socket);
            // Affiche l'adresse du client

            // Recevoir l'objet Mot envoyé par le client
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            // On récupère l'objet Mot
            Mot receivedMot = (Mot) objectInputStream.readObject();

            // On affiche le mot reçu
            System.out.println("Received Mot: " + receivedMot);

            // On ferme les flux
            objectInputStream.close();
            // On ferme la connexion
            socket.close();
            // On ferme le serveur
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
