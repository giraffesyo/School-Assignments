import java.io.*;

/**
 * Created by mmcquad on 10/6/16.
 */
public class Caesar {
    public static void main(String[] args)
    {
		//Close and print help if incorrect arguments
        if (args.length < 2 || args.length > 3) {
            usageHelp();
            return;
        }

        //Determine File or Screen output
        boolean OutputToFile = false;
        if (args.length == 3)
        {
            OutputToFile = true;
        }

        //Argument constants
        final int key = Integer.parseInt(args[0]);
		final String inFileName = args[1];
        final String outFileName;
		if (OutputToFile)
		{
            outFileName = args[2];
        }
        else
        {
            outFileName = null;
        }

        //input setup
        BufferedReader input;
        try{
            input = new BufferedReader(new FileReader(inFileName));
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return; //so we don't hit while loop without intialized input
        }

        //output setup
        BufferedWriter output;
        if (OutputToFile) {
            try
            {
                output = new BufferedWriter(new FileWriter(outFileName));
            }
            catch(IOException e)
            {
                e.printStackTrace();
                return; // so we don't hit while loop without initialized output
            }
        }
        else
        {
            output = null;
        }


        //Main processing of data
        while(true)
		{
		    try
            {
                int next = input.read();
                if(next == -1)
                    break;
                if (OutputToFile) {
                    output.write(caesarShift((char)next, key));
                    output.flush();
                } else {
                    System.out.print(caesarShift((char)next,key));
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
                break;
            }

        }

    }

    public static char caesarShift(char charToShift, int shiftAmount)
    {
        int charValue = (int)charToShift + shiftAmount;
        if (charToShift < 32 || charToShift > 126)
            return charToShift; //don't touch non-english characters
        if (charValue > 126)
			charValue -= 95;
		else if (charValue < 32)
			charValue += 95;
		return (char)(charValue);		
	}

    public static void usageHelp()
    {
        System.out.println("Invalid number of arguments. Usage: java Caesar key infile [outfile]");
    }
}
