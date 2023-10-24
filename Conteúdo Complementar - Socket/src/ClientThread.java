import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    public ClientThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try{
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputReader);
            String x;
            while ((x = reader.readLine())!= null){
                System.out.println("Client: " + x);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}