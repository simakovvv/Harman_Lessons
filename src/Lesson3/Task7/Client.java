package Lesson3.Task7;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int serverPort = 6666;
    private static final String locahost = "127.0.0.1";

    public static void main(String[] args) {
        System.out.println("Client side is started" +
                "Connecting to the server " +
                "(IP address " + locahost +
                ", port " + serverPort + ")");
        Socket socket = null;
        try {
            InetAddress ipAddress = InetAddress.getByName(locahost);
            socket = new Socket(ipAddress, serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The connection is established.");
        System.out.println("\tLocalPort = " + socket.getLocalPort() +
                "\n\tInetAddress.HostAddress = " + socket.getInetAddress());
        // Creating I / O streams for a socket
        try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream oin = new ObjectInputStream(socket.getInputStream())) {
            String line = null;
            Object msg = null;
            // Create a stream for reading from the keyboard
            Scanner keyboard = new Scanner(System.in);
            System.out.println("To view server content, send the command \"index\" and press Enter\n");
            System.out.println();
            while (true) {
                // Processing user input
                msg = keyboard.nextLine();
                oos.writeObject(msg);
                oos.flush();
                try {
                    msg = oin.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (msg instanceof File[]) {
                    for (File f : (File[]) msg) {
                        System.out.println(f);
                    }
                    System.out.println("\n Enter a type \"get <File>\" command to get the desired file.");
                }
                if (msg instanceof File) {
                    printFile((File) msg);
                }
                if (msg instanceof String) {
                    //We look, messages if they string
                    line = (String) msg;
                    oos.writeObject(line);// send the string to the server
                    oos.flush();
                    try {
                        msg = oin.readObject();// We are waiting for a response from the server
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    if (msg.toString().endsWith("quit")) {
                        System.exit(0);

                    } else {
                        System.out.println("The server sent me this line: \n\t" + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





