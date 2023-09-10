import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        Scanner scanner = new Scanner(System.in);

        ClientThread clientThread = new ClientThread(socket);
        clientThread.start();
        PrintStream saida = new PrintStream(socket.getOutputStream());
        String keyboard = scanner.nextLine();
        saida.println(scanner.nextLine());
        }

}