import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1233);
            System.out.println("Connected");
            ObjectOutputStream dataOutputStream = new ObjectOutputStream(socket.getOutputStream());

            int[][] matrix2 = new int[][]{
                    {0, 1, 2},
                    {2, 3, 4},
                    {2, 4, 5}
            };

            dataOutputStream.writeObject(matrix2);
            dataOutputStream.flush();
            socket.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}