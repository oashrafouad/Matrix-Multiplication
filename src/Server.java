import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(1234);

                System.out.println("Listening for client 1");
                Socket clientSocket1 = serverSocket.accept();
                System.out.println("Client 1 connected");

                ObjectInputStream objectInputStream1 = new ObjectInputStream(clientSocket1.getInputStream());
                int[][] matrix1 = (int[][]) objectInputStream1.readObject();

                System.out.println("Listening for client 2");
                Socket clientSocket2 = serverSocket.accept();
                System.out.println("Client 2 connected");

                ObjectInputStream objectInputStream2 = new ObjectInputStream(clientSocket2.getInputStream());
                int[][] matrix2 = (int[][]) objectInputStream2.readObject();

                System.out.println(Arrays.deepToString(matrix1).replace("], ", "],\n"));
                System.out.println(Arrays.deepToString(matrix2).replace("], ", "],\n"));

                clientSocket1.close();
                clientSocket2.close();
                serverSocket.close();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}