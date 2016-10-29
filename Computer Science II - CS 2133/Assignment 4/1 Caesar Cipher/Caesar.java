/**
 * Created by mmcquad on 10/6/16.
 */
public class Caesar {
    public static void main(String[] args)
    {
		//Close and print help if incorrect arguments
        if (args.length != 3) {
            usageHelp();
            return;
        }
		
        //Argument constants
        final int key = Integer.parseInt(args[0]);
		final String inFileName = args[1];
		final String outFileName = args[2];

		
		InputStream inFile = new InputStream(inFileName);
		OutputStream outFile = new OutputStream(outFileName);
		
		while(InputStream)
		{
			
		}
		
		
		
		
        System.out.println(caesarShift('K',key));


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
        System.out.println("Invalid number of arguments. Usage: java Caesar key infile outfile");
    }
}
