package th.mfu;

import java.io.*;
import java.net.*;

// call mockup server at port 8080
public class MockWebClient {
    public static void main(String[] args) {

        // TODO: Create a socket to connect to the web server on port 8080
        String serverAddress = "localhost";
        int portNumber = 8080;

        // :TODO Create input and output streams for the socket
        try (Socket socket = new Socket(serverAddress, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

        // TODO: send an HTTP GET request to the web server
        String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";

        // Read the response from the web server and print out to console
        while (!(request = stdIn.readLine()).equals("")) {
                out.println(request);
                System.out.println("Server response: " + in.readLine());
            }

        // Close the socket
        in.close();
        out.close();
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }

    }

}
