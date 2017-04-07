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
                int loc = 0;
                boolean special = false;
                for (String token : line) {
                    if (token.startsWith("[")) {
                        token = token.substring(1, token.length() - 1); //strip brackets
                        if (debug) {
                            System.out.println("token: " + token);
                        }
                        if (beginsAlphabetically(token)) {
                            if (debug) {
                                System.out.println("Found PC Counter or Register");
                            }
                            special = true;
                            //Set up a way to detect what register we're at later so we know where to store info

                        } else { //Line doesn't start with PC or R
                            token = token.substring(2, token.length());
                            loc = (int)parseHexString(token); // Converted to decimal int from string
                            if (debug) {

                                System.out.println("Stripped token: " + token);
                                System.out.println("Processed token: " + loc);
                            }
                        }
                        StartOfLine = false;
                    }
                    //information associated with address
                    else if (token.startsWith("0x") && !StartOfLine) {
                        if (debug) {
                            System.out.println("instr: " + token);
                        }
                        //Store data in loc/4 to location in memory
                        if(!special){
                            token = token.substring(2,token.length());
                            if(debug){
                                System.out.println("Stripped instr token:" + token);
                            }
                            MAIN_MEM[loc/4] = parseHexString(token);
                            if(debug){
                                System.out.println("Main memory " + loc/4 + " was set to " + "0x" + token + " (value of: " + Long.toBinaryString(parseHexString(token)) + ")");
                                System.out.println("Padded Binary String: " + padBinaryString(Long.toBinaryString(MAIN_MEM[loc/4])));
                                //System.out.println("Original length" + Long.toBinaryString(parseHexString(token)).length());
                                //System.out.println("Was less than 32 characters: " + (Long.toBinaryString(parseHexString(token)).length() < 32));

                            }
                        }

                    } else {
                        break;
                    }
                }
                //blank line to separate lines of debug
                if (debug) {
                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    //Using this to test what is inside the brackets.
    //If less than 64, we have a number, if More than 64 we have a letter. (ASCII Table)
    private static boolean beginsAlphabetically(String s) {
        return s.charAt(0) > 64;
    }

    private static long parseHexString(String s) {
        return Long.parseLong(s, 16);
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

