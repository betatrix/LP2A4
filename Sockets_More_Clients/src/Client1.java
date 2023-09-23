import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        Scanner scan = new Scanner(System.in);

        ServerThread serverThread = new ServerThread(socket);
        serverThread.start();
        PrintStream saida = new PrintStream(socket.getOutputStream());

        while (true) {
            String message = scan.nextLine();
            saida.println(message);
        }
    }
}
