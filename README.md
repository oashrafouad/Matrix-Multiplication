# Matrix-Multiplication
This is a Java app we made as an assignment part of the Big Data course I took in university. It uses Socket connection to input two matrices from two clients into a server and multiplies them. You can run the Server and Clients locally on the same device or run them on different devices in the same network.
# How to Run
* If you are running Server and Clients on different devices you need to obtain the IP address of the Server device. Open the terminal on the Server device and execute:

  * On Linux: `hostname -I`
  
  * On Mac: `ipconfig getifaddr en0` (`en0` for wireless,`en1` for wired connection)

* Otherwise, if you are running Server and Clients on the same device, then the Server's IP address will be `localhost` 

Then proceed with the steps:
1. Open `Server.java` file and change this line to choose the port you want to open a `ServerSocket` on (you can also leave it as `1233`)
```java
ServerSocket serverSocket = new ServerSocket(1233);
```
2. Open `Client1.java` and `Client2.java` files and modify this line to use the port you specified in the Server file and the IP address of the server you obtained
```java
Socket socket = new Socket("localhost", 1233);
```
3. Run `Server.java` and your console should print `Listening for client 1`, then run `Client1.java` and you should see the first matrix printed on the server's console, then run `Client2.java` and the second matrix should be printed then the multiplication result.
