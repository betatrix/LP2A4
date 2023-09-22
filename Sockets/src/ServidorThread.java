import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServidorThread extends Thread {
    private Socket cliente1;
    private Socket cliente2;


    public ServidorThread(Socket cliente1, Socket cliente2) {
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
    }

    @Override
    public void run(){
        try{
            //Input: entrada, Output: saída
            InputStreamReader inputStreamReader = new InputStreamReader(cliente2.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String readingLine;
            //Aqui o PrintStream é utilizado para gravar registros em arquivos de saída.
            PrintStream output1 = new PrintStream(cliente1.getOutputStream());

            while ((readingLine = reader.readLine()) != null){
                output1.println(readingLine);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
