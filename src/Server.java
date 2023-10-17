import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try
        {
            while (true)
            {
                ServerSocket serverSocket = new ServerSocket(1234);
                System.out.println("Listening");

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                String data = dataInputStream.readUTF();
                System.out.println(data);
                clientSocket.close();
                serverSocket.close();
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}