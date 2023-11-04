package Server;

import Server.ServerThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kimdo
 */
public class Server {

    static final int PORT = 8000;
    private ServerSocket server = null;

    public Server() {
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//     private static CopyOnWriteArrayList<Socket> connectedClients = new CopyOnWriteArrayList<>();

    public void action() throws IOException {
        Socket socket = null;
        int i = 1;
        System.out.println("Server is running...");
        try {
            while ((socket = server.accept()) != null) {
                new ServerThread(socket, "Client#" + i);
//                System.out.printf("Thread for Client#%d generating...%n", i++);
//                connectedClients.add(socket);
//                 System.out.println("Tổng số tài khoản đang online : " + connectedClients.size());
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().action();
    }
}
