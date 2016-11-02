import java.io.*;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ClientConnection implements Runnable {

    private Socket s;

    BufferedReader bufferedReader;
    PrintWriter printWriter;
    int contentType = 0;


    final String OKString = "HTTP/1.1 200 OK\r\n";
    final String NotFoundString = "HTTP/1.1 404 Not Found\r\n\r\n";
    final String InternalErrorString = "HTTP/1.1 500 Internal Server Error\r\n\r\n";

    final String ContentTypeHTML = "Content-type: text/html\r\n\r\n";
    final String ContentTypeJPG = "Content-type: image/jpeg\r\n\r\n";
    final String ContentTypePNG = "Content-type: image/png\r\n\r\n";
    final String ContentTypeICO = "Content-type: image/x-icon\r\n\r\n";


    ClientConnection(Socket socket) {
        s = socket;
    }


    public void run() {
        try {

            //setup and receive socket connection
            bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));

            OutputStream out = s.getOutputStream();
            printWriter = new PrintWriter(out, true);


            //Gets file name from input socket
            String fileName = getRequestedFileString();
            System.out.println("The client has requested: " + fileName);

            //ContentType
            if (new File(fileName).exists()) {
                printWriter.print(OKString);
                printWriter.flush();
                System.out.println("Sent client message 200, connection OK");
                if (contentType == 0) {
                    printWriter.print(ContentTypeHTML);
                    printWriter.flush();
                    System.out.println("Sent client HTML Content Type");
                } else if (contentType == 1) {
                    printWriter.print(ContentTypeJPG);
                    printWriter.flush();
                    System.out.println("Sent client JPG Content Type");
                } else if (contentType == 2) {
                    printWriter.print(ContentTypePNG);
                    printWriter.flush();
                    System.out.println("Sent client PNG Content Type");
                } else if (contentType == 3) {
                    printWriter.print(ContentTypeICO);
                    printWriter.flush();
                    System.out.println("Sent client ICO Content Type");
                }
            }


            //Reads the file that we got from getRequestedFileString() and sends it through our socket
            Path filePath = FileSystems.getDefault().getPath(fileName);
            Files.copy(filePath, out);
            printWriter.flush();
            printWriter.close();

        } catch (NoSuchFileException e) {
            printWriter.print(NotFoundString);
            printWriter.println("File not found");
            System.out.println("Sent client 404 header");
            printWriter.close();
        } catch (IOException e) {
            printWriter.print(InternalErrorString);
            printWriter.flush();
            System.out.println("Sent client Internal Server Error header");
            printWriter.close();
            e.printStackTrace();
        }
    }

    String getRequestedFileString() {
        String RequestedFile = "";

        //catch directory manipulators

        try {
            RequestedFile = bufferedReader.readLine();

            //strip .. so no funny business from client
            if(RequestedFile.contains("..")) {
            RequestedFile = RequestedFile.replace("\\.\\.","");
            }


            //Removes everything besides file name
            RequestedFile = RequestedFile.replaceAll("GET /*", "");
            RequestedFile = RequestedFile.replaceAll(" HTTP[/s/S]*.*", "");

            if (RequestedFile.contains(".jpg")) {
                contentType = 1;
            } else if (RequestedFile.contains(".png")) {
                contentType = 2;
            } else if (RequestedFile.contains(".ico")) {
                contentType = 3;
            }

            //Give index.html if they don't choose a page on the server
            if (RequestedFile.equals("")) {
                RequestedFile = "index.html";
            }
        } catch (IOException e)

        {
            e.printStackTrace();
        }

        return RequestedFile;
    }

}
