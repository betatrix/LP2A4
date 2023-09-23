import java.io.*;
import java.net.Socket;


public class ServerThread extends Thread {
    private Socket socket;
    private PrintWriter out;

    public ServerThread(Socket socket) {
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String readingLine;

            while ((readingLine = reader.readLine()) != null) {
                System.out.println("Usuário " + socket.getInetAddress().getHostAddress() + ": " + readingLine);
                Server.broadcast(readingLine, this);

/*              if (!socket.getInetAddress().getHostAddress().equals(Server.serverAddress)) { //para ignorar o servidor caso fosse de outro IP
                    Server.broadcast(readingLine, this);
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String readLine) {
        out.println(readLine);
    }
}
