import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ativo ouvindo a porta 12345.");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado!");

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