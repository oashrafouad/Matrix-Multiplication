import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected");
            ObjectOutputStream dataOutputStream = new ObjectOutputStream(socket.getOutputStream());

            int[][] matrix1 = new int[][]{
                    {0, 1, 2},
                    {2, 3, 4},
            };

            dataOutputStream.writeObject(matrix1);
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