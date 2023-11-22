import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PingClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            //  On crée un flux d'écriture
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // On crée un flux de lecture
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            for (int i = 0; i < 4; i++) {
                // Envoi de ping
                out.println("ping");

                // Réception de pong
                String response = in.readLine();
                System.out.println("Serveur : " + response);

                // On attend un peu (optionnel)
                Thread.sleep(1000);
            }

            socket.close();

            /*
            for (int i = 0; i < 4; i++) {
                // Send the "ping" command to the server
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject("ping");

                // Receive the "pong" response from the server
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String response = (String) objectInputStream.readObject();
                System.out.println("Received from server: " + response);

                // Close the streams
                objectOutputStream.close();
                objectInputStream.close();
            }

            // Close the socket
            socket.close();
             */
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
