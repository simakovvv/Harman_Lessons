package Lesson3.Task7;


import java.io.*;
import java.net.Socket;

public class Server extends Thread {
    private String TEMP_MSG = "The client '%d' sent me message : ";
    private String TEMP_CONN = "The client '%d' closed the connection";

    private Socket socket;
    private int num;
    private String path;

    public Server() {
    }

    public void setSocket(int num, Socket socket, String path) {
        // determining connection and socket number values
        this.num = num;
        this.socket = socket;
        this.path = path;
        //Discovery deamon - thread
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    public void run() {
        //Creating I / O streams for a socket
        try (ObjectOutputStream oos = new ObjectOutputStream((socket.getOutputStream()));
             ObjectInputStream oin = new ObjectInputStream((socket.getInputStream()))){
            String line = null;
            Object msg = null;
            while (true) {
                try {
                    //we read the come object
                    msg = oin.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                line = (String) msg;
                System.out.println(String.format(TEMP_MSG, num) + line);
                if(line.equals("index")){
                    msg = getFoldersMember(path);
                    oos.writeObject(msg);
                    oos.flush();
                } else {
                    oos.writeObject("Server recieve text: unknown team");
                    // Finish object transfer
                    oos.flush();
                }
                System.out.println();
                if (line.equalsIgnoreCase("quit")) {
                    socket.close();
                    System.out.println(String.format(TEMP_CONN, num));
                    break;
                }

            }
        } catch (IOException e) {
            System.out.println("Exeption : " + e);
        }
    }
    public File[] getFoldersMember(String path) {
        File dir1 = new File(path);
        return dir1.listFiles();
    }
}

