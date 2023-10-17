import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected");
            ObjectOutputStream dataOutputStream = new ObjectOutputStream(socket.getOutputStream());

            int[][] matrix1 = new int[][]{
                    {0, 1, 2},
                    {2, 3, 4},
                    {0, 3, 5}
            };

            int[][] matrix2 = new int[][]{
                    {0, 1, 2},
                    {2, 3, 4},
                    {0, 3, 6}
            };

            dataOutputStream.writeObject(matrix1);
            dataOutputStream.writeObject(matrix2);
            dataOutputStream.flush();
            socket.close();

//            System.out.println(Arrays.deepToString(matrix).replace("], ", "],\n"));
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}