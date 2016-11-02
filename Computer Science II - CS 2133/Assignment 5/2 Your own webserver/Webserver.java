import java.io.IOException;
import java.net.ServerSocket;



public class Webserver {
    final static int port = 8080;

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            while (true) {
                Thread conn = new Thread(new ClientConnection(server.accept()));
                conn.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

