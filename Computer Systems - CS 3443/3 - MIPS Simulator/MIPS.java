// Simulates MIPS

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MIPS {

    static private Scanner sc; // static for testing

    private static final int MEMAMT = 1048576; // (2^20)
    private static long MAIN_MEM[] = new long[MEMAMT]; //integer arrays are automatically instantiated to 0
    private static int GEN_REG[] = new int[32]; //32 general purpose registers
    private static int SP_REG[] = new int[4]; // 4 special purpose registers: PC, nPC, LO, and HI
    private static final boolean debug = true;

    //So we don't have to remember which register is which
    private final static int PC_addr = 0;
    private final static int nPC_addr = 1;
    private final static int LO_addr = 2;
    private final static int HI_addr = 3;


    private final int ADD_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0000;
    private final int ADDI_INSTR = 0b0010_0000_0000_0000_0000_0000_0000_0000;
    private final int ADDIU_INSTR = 0b0010_0100_0000_0000_0000_0000_0000_0000;
    private final int ADDU_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0001;
    private final int AND_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0100;
    private final int ANDI_INSTR = 0b0011_0000_0000_0000_0000_0000_0000_0000;
    private final int BEQ_INSTR = 0b0001_0000_0000_0000_0000_0000_0000_0000;
    private final int BGEZ_INSTR = 0b0000_0100_0000_0001_0000_0000_0000_0000;
    private final int BGEZAL_INSTR = 0b0000_0100_0001_0001_0000_0000_0000_0000;
    private final int BGTZ_INSTR = 0b0001_1100_0000_0000_0000_0000_0000_0000;
    private final int BLEZ_INSTR = 0b0001_1000_0000_0000_0000_0000_0000_0000;
    private final int BLTZ_INSTR = 0b0000_0100_0000_0000_0000_0000_0000_0000;
    private final int BLTZAL_INSTR = 0b0000_0100_0001_0000_0000_0000_0000_0000;
    private final int BNE_INSTR = 0b0001_0100_0000_0000_0000_0000_0000_0000;
    private final int DIV_INSTR = 0b0000_0000_0000_0000_0000_0000_0001_1010;
    private final int J_INSTR = 0b0000_1000_0000_0000_0000_0000_0000_0000;
    private final int JAL_INSTR = 0b0000_1100_0000_0000_0000_0000_0000_0000;
    private final int JR_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_1000;
    private final int LB_INSTR = 0b1000_0000_0000_0000_0000_0000_0000_0000;
    private final int LUI_INSTR = 0b0011_1100_0000_0000_0000_0000_0000_0000;
    private final int LW_INSTR = 0b1000_1100_0000_0000_0000_0000_0000_0000;
    private final int MFHI_INSTR = 0b0000_0000_0000_0000_0000_0000_0001_0000;
    private final int MFLO_INSTR = 0b0000_0000_0000_0000_0000_0000_0001_0010;
    private final int MULT_INSTR = 0b0000_0000_0000_0000_0000_0000_0001_1000;
    private final int NOOP_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0000;
    private final int OR_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0101;
    private final int ORI_INSTR = 0b0011_0100_0000_0000_0000_0000_0000_0000;
    private final int SB_INSTR = 0b1010_0000_0000_0000_0000_0000_0000_0000;
    private final int SLL_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0000;
    private final int SLLV_INSTR = 0b0000_0000_00000_0000_0000_0000_0000_0100;
    private final int SLT_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_1010;
    private final int SLTI_INSTR = 0b0010_1000_0000_0000_0000_0000_0000_0000;
    private final int SLTIU_INSTR = 0b0010_1100_0000_0000_0000_0000_0000_0000;
    private final int SLTU_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_1011;
    private final int SRA_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0011;
    private final int SRL_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0010;
    private final int SRLV_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0110;
    private final int SUB_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0010;
    private final int SUBU_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0011;
    private final int SW_ISNTR = 0b1010_1100_0000_0000_0000_0000_0000_0000;
    private final int SYSCALL_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_1100;
    private final int XOR_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0110;
    private final int XORI_INSTR = 0b0011_1000_0000_0000_0000_0000_0000_0000;

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
				boolean PC = false;
				int register = -1;
                for (String token : line) {
					if(token.equals("")){
						if(debug)
						{
							System.out.println();
						}
						continue;
						}
					if (token.startsWith("[")) {
                        token = token.substring(1, token.length() - 1); //strip brackets
                        if (debug) {
                            System.out.println("token: " + token);
                        }
                        if (beginsAlphabetically(token)) {
                            special = true;
							if ( token.charAt(0) == 'R' )
							{
								token = token.substring(1,token.length());
								register = Integer.parseInt(token);
								if(debug){
									System.out.println("Found Register: " + register);
								}
							} else
							{
								PC = true;
								if (debug){
									System.out.println("Found PC");
								}
							}
							
							
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
                        } else { // we're a pc or register 
							if (PC) // we're the PC
							{
								token = token.substring(2,token.length());
								long temporary = parseHexString(token);
								SP_REG[PC_addr] = (int)parseHexString(token);
								if(debug)
								{
									System.out.println("PC was set to: " + temporary);
								}
								special = false;
								PC = false;
							}
							else // we're a register
							{
								token = token.substring(2,token.length());
								long temporary = parseHexString(token);
								GEN_REG[register - 1] =  (int)temporary;
								if(debug)
								{
									System.out.println("Register " + register + " set to : " + temporary );
								}
								special = false;
							} 
						}
                    } else {
						//System.out.println("We weren't a start of line or a valid token");
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

