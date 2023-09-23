import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<ServerThread> clients = new ArrayList<>();
    public static String serverAddress;

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
//      serverAddress = InetAddress.getLocalHost().getHostAddress(); //caso o servidor fosse de outro IP
        System.out.println("Server ativo ouvindo a porta 12345.");

        while (true) {
            for (int i = 1; i > 0; i++){ //só para fazer graça
                Socket socket = servidor.accept();
                System.out.println("Cliente " + i + " conectado!");

                ServerThread serverThread = new ServerThread(socket);
                clients.add(serverThread);
                serverThread.start();
            }
        }
    }
    public static void broadcast (String readingline, ServerThread remetente) {
        for (ServerThread client : clients) {
            if (client != remetente) {
                client.sendMessage(readingline);
            }
        }
    }
}
