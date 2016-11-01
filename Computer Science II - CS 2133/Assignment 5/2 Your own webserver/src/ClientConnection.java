import java.io.*;
import java.net.Socket;

public class ClientConnection implements Runnable {

    private Socket s;
    String request;
    BufferedReader file;
    final boolean debug = true;

    String OKString = "HTTP/1.1 200 OK\r\n";
    String ContentTypeHTML = "Content-type: text/html\r\n\r\n";
    String NotFoundString = "HTTP/1.1 404 Not Found\r\n\r\n";
    String InternalErrorString = "HTTP/1.1 500 Internal Server Error\r\n\r\n";

    ClientConnection(Socket socket) {
        s = socket;
    }


    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
            out.write(ContentTypeHTML, 0, ContentTypeHTML.length());
            out.flush();
            String line;
            request = "";
            while ((line = in.readLine()) != null) {
                request += line + "\r\n";
            }
            request += "\r\n";
            switch (processRequest()) {
                case 0:
                    if(debug)
                        System.out.println("Reached sendSuccess()");



                    out.write(OKString);
                    out.flush();

                    if (debug)
                        System.out.println(OKString);



                        while ((line = file.readLine()) != null) {
                            line += "\r\n";
                            out.write(line, 0, line.length());
                            out.flush();
                            if (debug)
                                System.out.println(line + "\r\n");
                        }

                    out.flush();
                    break;
                case 2:
                    sendFileNotFound(out);
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //strips request and returns result
    private int processRequest() {
        int result;
        if (debug)
            System.out.println("request at top of processRequest() is: " + request);
        if (request.contains("GET")) {
            request = request.substring(request.indexOf("GET") + 5);
            request = request.substring(0, request.indexOf(".html") + 5);
            result = 0;
            if (debug) {
                System.out.println("result substring in processRequest() is: " + request);
                System.out.println("int result in processRequest() is: " + result);
            }
        } else {
            result = 1;
            if (debug)
                System.out.println("int result in processRequest() is: " + result);
            return result;
        }


        try {
            file = new BufferedReader(new FileReader(request));
        } catch (IOException e) {
            e.printStackTrace();
            return 2;
        }

        return result;
    }

 /*   private void sendSuccess(OutputStreamWriter out) throws IOException {
        if(debug)
            System.out.println("Reached sendSuccess()");



        out.write(OKString);
        out.flush();

        if (debug)
            System.out.println(OKString);

        String line;
        try {
            while ((line = file.readLine()) != null) {
                line += "\r\n";
                out.write(line, 0, line.length());
                out.flush();
                if (debug)
                    System.out.println(line + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
    }
*/
    private void sendFileNotFound(OutputStreamWriter out) throws IOException {

        out.write(NotFoundString);
        out.flush();
        if (debug)
            System.out.println(NotFoundString);
    }

    private void sendInternalServerError(OutputStreamWriter out) throws IOException {

        out.append(InternalErrorString);
        if (debug)
            System.out.println(InternalErrorString);
    }
}