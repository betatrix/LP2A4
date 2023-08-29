import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ativo ouvindo a porta 12345.");

            Socket cliente1 = servidor.accept();
            System.out.println("Cliente 1 conectado!");

            Socket cliente2 = servidor.accept();
            System.out.println("Cliente 2 conectado!");

            ServidorThread1 servidorThread1 = new ServidorThread1(cliente1, cliente2);
            servidorThread1.start();

            ServidorThread2 servidorThread2 = new ServidorThread2(cliente1, cliente2);
            servidorThread2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ServidorThread1 extends Thread {
            private Socket cliente1;
            private Socket cliente2;


            public ServidorThread1(Socket cliente1, Socket cliente2) {
                this.cliente1 = cliente1;
                this.cliente2 = cliente2;
            }

            @Override
            public void run(){
                try{
                    InputStreamReader inputStreamReader = new InputStreamReader(cliente2.getInputStream());
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    String readingLine;
                    PrintStream output2 = new PrintStream(cliente1.getOutputStream());

                    while ((readingLine = reader.readLine()) != null){
                        output2.println(readingLine);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
}