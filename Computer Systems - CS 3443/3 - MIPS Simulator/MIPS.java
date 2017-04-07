// Simulates MIPS

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MIPS {

    static private Scanner sc; // static for testing

    private static final int MEMAMT = 1048576; // (2^20)
    private static long MAIN_MEM[] = new long[MEMAMT]; //integer arrays are automatically instantiated to 0
    private static int GEN_REG[] = GEN_REG = new int[32]; //32 general purpose registers
    private static int SP_REG[] = new int[4]; // 4 special purpose registers: PC, nPC, LO, and HI
    private static final boolean debug = true;

    //So we don't have to remember which register is which
    private final static int PC_addr = 0;
    private final static int nPC_addr = 1;
    private final static int LO_addr = 2;
    private final static int HI_addr = 3;


    public static void main(String[] args) {
        //String inputFileName = args[0];
        String inputFileName = "input.txt"; //hardcoded for testing purposes

        try {
            sc = new Scanner(new File(inputFileName));
            while (sc.hasNextLine()) {
                boolean StartOfLine = true;
                String current = sc.nextLine();
                String line[] = current.split("[\\s]");
                for (String token : line) {
                    if (token.startsWith("[")) {
                        token = token.substring(1, token.length() - 1); //strip brackets
                        System.out.println("loc: " + token);
                        StartOfLine = false;
                    } else if (token.startsWith("0x") && !StartOfLine) {
                        System.out.println("addr: " + token);
                    } else {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }


    }

    private static String padBinaryString(String s)
    {
        if(s.length() < 32)
        {
            int diff = 32 - s.length();
            return String.format("%0" + diff + "d%s", 0, s);
        }
        else{
            return s;
        }
    }

}

