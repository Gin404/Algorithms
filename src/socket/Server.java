package socket;

import sun.misc.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 * Single thread server
 * */
public class Server {
    public static void main(String[] args) throws IOException {
        RequestHandler requestHandler = new RequestHandler();
        try(ServerSocket serverSocket = new ServerSocket(6666)){
            System.out.println("Listening on "+serverSocket.getLocalSocketAddress());
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Incoming connection from " + clientSocket.getRemoteSocketAddress());
                new ClientHandler(clientSocket, requestHandler).run();
            }
        }
    }
}
