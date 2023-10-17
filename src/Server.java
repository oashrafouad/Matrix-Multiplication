import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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

                ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                int[][] firstMatrix = (int[][]) objectInputStream.readObject();
                int[][] secondMatrix = (int[][]) objectInputStream.readObject();

                System.out.println(Arrays.deepToString(firstMatrix).replace("], ", "],\n"));
                System.out.println(Arrays.deepToString(secondMatrix).replace("], ", "],\n"));

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