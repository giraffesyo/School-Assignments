// Simulates MIPS

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MIPS {

    private int MAIN_MEM[];


    private int GEN_REG[];
    private int SP_REG[];
    static public Scanner sc;


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
            String state = "none";
            while (sc.hasNext())
            {
                String current = sc.next();
                if(current.startsWith("["))
                {
                    current = current.substring(1,current.length()-1);
                    System.out.println(current);
                    state = "addr";

                }
                else if ( state.equals("addr"))
                {
                    System.out.println(current);
                    sc.nextLine();
                    state = "none";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }



    }


}
