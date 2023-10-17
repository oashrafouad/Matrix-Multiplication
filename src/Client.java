import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try
        {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected");
            DataOutputStream dataOutputStream =  new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Hello");
            dataOutputStream.flush();
            socket.close();

        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}