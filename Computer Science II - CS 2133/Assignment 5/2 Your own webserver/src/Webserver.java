import java.io.IOException;
import java.net.ServerSocket;


public class Webserver {


    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(8080);
            while (true) {
                Thread conn = new Thread(new ClientConnection(server.accept()));
                conn.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

