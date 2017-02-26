import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
<<<<<<< Updated upstream
import java.util.HashMap;

=======
import java.util.*;
>>>>>>> Stashed changes

public class Huff {

    //public static final int BytePerms = 256; //not used

    public static FileInputStream input;
    FileOutputStream output;
    public static byte[] bytes;


    public static void main(String[] args) {
        //ensure filename specified
        /*if (args.length != 1)
        {
            System.out.println("Usage: java Huff fileName.ext");
            System.exit(1);
        }
*/


        //String FileName = args[0];
        String FileName = "/assn1.pdf"; //temp


        try {
<<<<<<< Updated upstream
            input = new FileInputStream(FileName);
            bytes = new byte[input.available()];
            input.read(bytes);



        }catch(IOException e)
        {
=======
            input = new FileInputStream(FileName); //file to get bytes from
            bytes = new byte[input.available()]; //available is total amount of bytes in file
            input.read(bytes); // reads file in as bytes and stores into "bytes"

            HashMap<Byte, Integer> frequencies = new HashMap<>();

            //count frequencies by putting bytes into hashmap
            for (byte b : bytes) {
                if (frequencies.containsKey(b)) {
                    frequencies.replace(b, frequencies.get(b) + 1);
                } else {
                    frequencies.put(b, 1);
                }


            }




            /*
            //create iterator with each keypaid, call fqiterator.next to get each pair
            //values return such as "-1=685"
            //Iterator fqiterator = frequencies.entrySet().iterator();

            //print keypairs
            while(fqiterator.hasNext())
            {
                System.out.println(fqiterator.next());
            }
            */

            PriorityQueue<HuffmanNode> NodesPQ = new PriorityQueue<>();

            for (int i = -128; i < 128; i++) {
                //use Integer object so we can store null
                Integer currentFreq = frequencies.get((byte) (i));

                //null is returned by Map.get() when no key matched
                if (currentFreq == null)
                    continue; // skip to next iteration
                NodesPQ.add(new HuffmanNode((byte) (i), currentFreq));


            }

            //Connect all the nodes
            while (NodesPQ.size() > 1) {
                NodesPQ.add(new HuffmanNode(NodesPQ.poll(), NodesPQ.poll()));
            }

            //Last node forms a tree!
            HuffmanNode Tree = NodesPQ.poll();



            //test tree and see where bottom is
            HuffmanNode test = Tree.one;

            while(test.zero != null)
            {
                test = test.one;
                System.out.print(test.getFreq());
                System.out.print(", ");
                System.out.print(test.getValue());
                System.out.println();
            }

>>>>>>> Stashed changes

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
