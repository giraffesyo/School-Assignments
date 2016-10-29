import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class browserPanel extends JPanel {

    static JTextField addressBar;
    static JTextArea webContentArea;


    browserPanel(browserFrame Frame) {
        super();
        addressBar = new JTextField("", 100);
        addressBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == 10)
                    loadPage(addressBar.getText(), Frame);
            }
        });
        add(addressBar);
        webContentArea = new JTextArea(40, 100);
        webContentArea.setEditable(false);
        JScrollPane scrollableArea = new JScrollPane(webContentArea);
        add(scrollableArea);
    }

    public static void loadPage(String url, browserFrame Frame) {
        String line;
        String document = "";

        BufferedReader in = getWebContent(url);

        try {
            while ((line = in.readLine()) != null) {
                document += (line + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Frame.setTitle(document.substring(document.indexOf("<title>") + 7, document.indexOf("</title>")));
        document = document.replaceAll("<body.*>", "<body>");
        document = document.substring(document.indexOf("<body>") + 6, document.indexOf("</body>"));



        document = document.replaceAll("\\t", ""); //remove tab characters
        document = document.replaceAll("<script>[\\s\\S]*?</script>", ""); //remove scripts
        document = document.replaceAll("<!--.*-->", ""); //remove comments
        document = document.replaceAll("<a.*>.*</a>",""); //remove links
        document = document.replaceAll("<[\\s\\S]*?>",""); //remove rest of tags
        //document = document.replaceAll("[\\r\\n]+","");
        document = document.replaceAll("[\r\n]+", "\n");
        document = document.trim();


        /*int tagCount = countTags(document);

        for (int i = 0; i < tagCount; i++) {
            document = stripTag(document);
        }
*/
        System.out.println(document);
        webContentArea.setText(document);
    }

   /* public static int countTags(String webpage) {
        int numberOfTags = 0;
        for (int i = 0; i < webpage.length(); i++) {

            if (webpage.charAt(i) == '<')
                numberOfTags++;
        }
        return numberOfTags;
    }


    public static String stripTag(String webpage) {
        String strippedPage = "";
        strippedPage += webpage.substring(0, webpage.indexOf('<'));
        strippedPage += webpage.substring(webpage.indexOf('>') + 1, webpage.length());
        return strippedPage;
    }*/



    public static BufferedReader getWebContent(String url) {

        try {
            Socket socket = new Socket(url, 80);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.print("GET / HTTP/1.1\r\n");
            out.print("host: " + url + "\r\n\r\n");
            out.flush();
            return in;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}



