import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class Huff {

    public static final int BytePerms = 256;

    public static FileInputStream input;
    FileOutputStream output;
    public static byte[] bytes;


    public static void main(String[] args)
    {
        String FileName = args[0];

        try {
            input = new FileInputStream(FileName);
            bytes = new byte[input.available()];
            input.read(bytes);
        }catch(IOException e)
        {

        }
    }
}
