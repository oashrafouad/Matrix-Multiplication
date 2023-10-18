import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) {
        int numberOfClients = 2;

        int[][] result = new int[0][0];

        for (int counter = 0; counter < numberOfClients; counter++) {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(1224);

                System.out.println("Listening for client");
                Socket clientSocket = serverSocket.accept();
                System.out.println(counter);
                System.out.println("Client connected");

                ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                int[][] matrix = (int[][]) objectInputStream.readObject();

//                System.out.println(Arrays.deepToString(matrix).replace("], ", "],\n"));

                if (counter == 0) {
                    result = matrix;
                    System.out.println("Counter == 0 executed");

                } else {
                    System.out.println("Operation executed");
                    // result = result * matrix;
                    int rowsR = result.length;
                    int colsR = result[0].length;
                    int colsM = matrix[0].length;
                    //initializing the matrix multiplication data
                    int[][] finalResult = new int[rowsR][colsM];
                    //initializing the final result with the size of the resulted matrix from multiplication
                    //performing the needed for loops
                    for (int i = 0; i < rowsR; i++) {
                        for (int j = 0; j < colsM; j++) {
                            for (int k = 0; k < colsR; k++) {
                                finalResult[i][j] += result[i][k] * matrix[k][j];
                            }
                        }
                    }
                    int[][] x = null;

                    System.out.println(Arrays.deepToString(finalResult).replace("], ", "],\n"));

                }


                clientSocket.close();
                serverSocket.close();

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

        }


//        while (true) {
//
//        }


    }
}