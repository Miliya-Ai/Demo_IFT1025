import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PongServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);

            System.out.println("Serveur en attente de connexion...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté !");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            for (int i = 0; i < 4; i++) {
                // Receive ping
                String request = in.readLine();
                System.out.println("Client says: " + request);

                // Envoi de pong
                out.println("pong");

                // On attend un peu (optionnel)
                Thread.sleep(1000);
            }

            serverSocket.close();

            /*
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            for (int i = 0; i < 4; i++) {
                // Receive the "ping" command from the client
                String command = (String) objectInputStream.readObject();
                System.out.println("Received from client: " + command);

                // Respond with the "pong" command
                objectOutputStream.writeObject("pong");
            }

            // Close the streams and the socket
            objectInputStream.close();
            objectOutputStream.close();
            clientSocket.close();
            serverSocket.close();
             */
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
