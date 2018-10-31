package Lesson3.Task7;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServerListener {
    private static int port = 6666;
    private static String IP = "localhost";

    public static void main(String[] args) {

        // This method runs in a parallel stream and listens to new connections all the time.
        //If hears, creates stream - demon
        int i = 0; // Connection count
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(IP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // Connection socet to local host
        try (ServerSocket serverSocket = new ServerSocket(port, 0, inetAddress)) {
            System.out.println("Server started\n\n");
            while (true) {
                //Waiting connection
                Socket socket = serverSocket.accept();
                System.err.println("Server : Client Accepted");
                //We start a separate stream for work with the client
                new Server().setSocket(i++, socket,args[0]);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

