import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            Socket cliente = new Socket("localhost", 12345);

            ClienteServidorThread clienteServidorThread = new ClienteServidorThread(cliente);
            clienteServidorThread.start();
            PrintStream saida = new PrintStream(cliente.getOutputStream());

            while (true){
                String mensagem = scan.nextLine();
                saida.println(mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
