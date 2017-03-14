// Simulates MIPS

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MIPS {

    static public Scanner sc; // static for testing
    private int MAIN_MEM[];
    private int GEN_REG[];
    private int SP_REG[];


    MIPS() {
        final int MEMAMT = 4194304; // 4(2^20) == 4 MB
        MAIN_MEM = new int[MEMAMT]; //integer arrays are automatically instantiated to 0

        GEN_REG = new int[32]; //32 general purpose registers
        SP_REG = new int[4]; // 4 special purpose registers: PC, nPC, LO, and HI
    }


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
                    if (token.startsWith("[")  ) {
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

        } catch (
                IOException e)

        {
            e.printStackTrace();
            System.exit(0);
        }


    }


}

