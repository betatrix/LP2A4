import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteServidorThread extends Thread {
    private Socket cliente;

    public ClienteServidorThread(Socket cliente){
        this.cliente = cliente;
    }

    @Override
    public void run(){
        InputStreamReader inputStreamReader = null;

        try {
            inputStreamReader = new InputStreamReader(cliente.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String reading;

            while ((reading = reader.readLine()) != null){
                System.out.println("Usuário: " + reading);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
