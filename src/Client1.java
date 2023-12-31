import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1233);
            System.out.println("Connected");
            ObjectOutputStream dataOutputStream = new ObjectOutputStream(socket.getOutputStream());

            int[][] matrix1 = new int[][]{
                    {0, 1, 2},
                    {2, 3, 4},
                    {2, 1, 5}
            };

            dataOutputStream.writeObject(matrix1);
            dataOutputStream.flush();
            socket.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}