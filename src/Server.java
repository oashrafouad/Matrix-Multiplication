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
                System.out.println("First matrix:");
                System.out.println(Arrays.deepToString(matrix1).replace("], ", "],\n"));
                System.out.println("Second matrix:");
                System.out.println(Arrays.deepToString(matrix2).replace("], ", "],\n"));

                int rowsMatrix1 = matrix1.length;
                int colsMatrix1 = matrix1[0].length;
                int rowsMatrix2 = matrix2.length;
                int colsMatrix2 = matrix2[0].length;

                if (colsMatrix1 == rowsMatrix2)
                {

                    //initializing the matrix multiplication data
                    int[][] finalResult = new int[rowsMatrix1][colsMatrix2];
                    //initializing the final result with the size of the resulted matrix from multiplication
                    //performing the needed for loops
                    for (int i = 0; i < rowsMatrix1; i++) {
                        for (int j = 0; j < colsMatrix2; j++) {
                            for (int k = 0; k < colsMatrix1; k++) {
                                finalResult[i][j] += matrix1[i][k] * matrix2[k][j];
                            }
                        }
                    }

                    System.out.println("Multiplication result:");
                    System.out.println(Arrays.deepToString(finalResult).replace("], ", "],\n"));

                }
                else {
                    System.out.println("These two matrices can't be multiplied");
                }

                clientSocket1.close();
                clientSocket2.close();
                serverSocket.close();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}