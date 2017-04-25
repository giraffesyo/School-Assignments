// Simulates MIPS

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MIPS {

    /*
    TODO: Maybe all of this parsing would be better if it was in a tree?
     */
    static private Scanner sc; // static for testing

    private static final int MEMAMT = 1048576; // (2^20)
    private static long MAIN_MEM[] = new long[MEMAMT]; //integer arrays are automatically instantiated to 0
    private static int GEN_REG[] = new int[32]; //32 general purpose registers
    private static int SP_REG[] = new int[4]; // 4 special purpose registers: PC, nPC, LO, and HI
    private static final boolean fulldebug = true;

    //So we don't have to remember which register is which
    private final static int PC_addr = 0;
    private final static int nPC_addr = 1;
    private final static int LO_addr = 2;
    private final static int HI_addr = 3;


    private final static int ADD_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0000;
    private final static int ADDI_INSTR = 0b0010_0000_0000_0000_0000_0000_0000_0000;
    private final static int ADDIU_INSTR = 0b0010_0100_0000_0000_0000_0000_0000_0000;
    private final static int ADDU_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0001;
    private final static int AND_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0100;
    private final static int ANDI_INSTR = 0b0011_0000_0000_0000_0000_0000_0000_0000;
    private final static int BEQ_INSTR = 0b0001_0000_0000_0000_0000_0000_0000_0000;
    private final static int BGEZ_INSTR = 0b0000_0100_0000_0001_0000_0000_0000_0000;
    private final static int BGEZAL_INSTR = 0b0000_0100_0001_0001_0000_0000_0000_0000;
    private final static int BGTZ_INSTR = 0b0001_1100_0000_0000_0000_0000_0000_0000;
    private final static int BLEZ_INSTR = 0b0001_1000_0000_0000_0000_0000_0000_0000;
    private final static int BLTZ_INSTR = 0b0000_0100_0000_0000_0000_0000_0000_0000;
    private final static int BLTZAL_INSTR = 0b0000_0100_0001_0000_0000_0000_0000_0000;
    private final static int BNE_INSTR = 0b0001_0100_0000_0000_0000_0000_0000_0000;
    private final static int DIV_INSTR = 0b0000_0000_0000_0000_0000_0000_0001_1010;
    private final static int J_INSTR = 0b0000_1000_0000_0000_0000_0000_0000_0000;
    private final static int JAL_INSTR = 0b0000_1100_0000_0000_0000_0000_0000_0000;
    private final static int JR_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_1000;
    private final static int LB_INSTR = 0b1000_0000_0000_0000_0000_0000_0000_0000;
    private final static int LUI_INSTR = 0b0011_1100_0000_0000_0000_0000_0000_0000;
    private final static int LW_INSTR = 0b1000_1100_0000_0000_0000_0000_0000_0000;
    private final static int MFHI_INSTR = 0b0000_0000_0000_0000_0000_0000_0001_0000;
    private final static int MFLO_INSTR = 0b0000_0000_0000_0000_0000_0000_0001_0010;
    private final static int MULT_INSTR = 0b0000_0000_0000_0000_0000_0000_0001_1000;
    private final static int OR_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0101;
    private final static int ORI_INSTR = 0b0011_0100_0000_0000_0000_0000_0000_0000;
    private final static int SB_INSTR = 0b1010_0000_0000_0000_0000_0000_0000_0000;
    private final static int SLL_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0000;
    private final static int SLLV_INSTR = 0b0000_0000_00000_0000_0000_0000_0000_0100;
    private final static int SLT_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_1010;
    private final static int SLTI_INSTR = 0b0010_1000_0000_0000_0000_0000_0000_0000;
    private final static int SLTIU_INSTR = 0b0010_1100_0000_0000_0000_0000_0000_0000;
    private final static int SLTU_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_1011;
    private final static int SRA_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0011;
    private final static int SRL_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0010;
    private final static int SRLV_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_0110;
    private final static int SUB_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0010;
    private final static int SUBU_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0011;
    private final static int SW_INSTR = 0b1010_1100_0000_0000_0000_0000_0000_0000;
    private final static int SYSCALL_INSTR = 0b0000_0000_0000_0000_0000_0000_0000_1100;
    private final static int XOR_INSTR = 0b0000_0000_0000_0000_0000_0000_0010_0110;
    private final static int XORI_INSTR = 0b0011_1000_0000_0000_0000_0000_0000_0000;

    private final static int MASK1 = 0b1111_1100_0000_0000_0000_0111_1111_1111; // ADD, ADDU, AND, OR, SLT, SLTU, SRLV, SUB, SUBU
    private final static int MASK2 = 0b1111_1100_0000_0000_0000_0000_0000_0000; // ADDI, ADDIU, ANDI, BEQ, BNE, J, JAL, LB, LUI, LW, ORI, SB, SLTI, SLTIU, SW, XORI
    private final static int MASK3 = 0b1111_1100_0001_1111_0000_0000_0000_0000; // BGEZ, BGEZAL, BGTZ, BLEZ, BLTZ, BLTZAL,
    private final static int MASK4 = 0b1111_1100_0000_0000_1111_1111_1111_1111; // DIV, MULT
    private final static int MASK5 = 0b1111_1100_0001_1111_1111_1111_1111_1111; // JR
    private final static int MASK6 = 0b1111_1111_1111_1111_0000_0111_1111_1111; // MFHI, MFLO
    //private final static int MASK7 = 0b1111_1111_1111_1111_1111_1111_1111_1111; // NOOP
    private final static int MASK8 = 0b1111_1100_0000_0000_0000_0000_0011_1111; // SLL, SLLV, SRA, SRL, SYSCALL, XOR



    public static void main(String[] args) {
        //String inputFileName = args[0];
        String inputFileName = "input.txt"; //hardcoded for testing purposes
        parseInputFile(inputFileName);

        long Instr = MAIN_MEM[SP_REG[PC_addr]/4];

        if((Instr & MASK1) == ADD_INSTR)
        {
            //$d = $s + $t; advance_pc (4);
        } else if((Instr & MASK2 ) == ADDI_INSTR )
        {
            //$t = $s + imm; advance_pc (4);
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

    private static String padBinaryString(String s) {
        if (s.length() < 32) {
            int diff = 32 - s.length();
            return String.format("%0" + diff + "d%s", 0, s);
        } else {
            return s;
        }
    }

    private static void advance_pc(int offset) {
        SP_REG[PC_addr] = SP_REG[nPC_addr];
        SP_REG[nPC_addr] += offset;
    }

    private static void parseInputFile(String inputFileName) {
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
                int dataNumber = 0;
                for (String token : line) {
                    if (token.equals("")) {
                        if (fulldebug) {
                            System.out.println();
                        }
                        continue;
                    }

                    if (token.startsWith("[")) {
                        token = token.substring(1, token.length() - 1); //strip brackets
                        if (fulldebug) {
                            System.out.println("token: " + token);
                        }
                        if (beginsAlphabetically(token)) {
                            special = true;
                            if (token.charAt(0) == 'R') {
                                token = token.substring(1, token.length());
                                register = Integer.parseInt(token);
                                if (fulldebug) {
                                    System.out.println("Found Register: " + register);
                                }
                            } else {
                                PC = true;
                                if (fulldebug) {
                                    System.out.println("Found PC");
                                }
                            }


                            //Set up a way to detect what register we're at later so we know where to store info

                        } else { //Line doesn't start with PC or R
                            token = token.substring(2, token.length());
                            loc = (int) parseHexString(token); // Converted to decimal int from string
                            if (fulldebug) {

                                System.out.println("Stripped token: " + token);
                                System.out.println("Processed token: " + loc);
                            }
                        }
                        StartOfLine = false;
                    }
                    //information associated with address

                    else if (token.startsWith("0x") && !StartOfLine) {
                        if (fulldebug) {
                            System.out.println("instr: " + token + " Associated with loc: " + loc);
                        }
                        //Store data in loc/4 to location in memory
                        if (!special) {
                            token = token.substring(2, token.length());
                            if (fulldebug) {
                                System.out.println("Stripped instr token:" + token);
                            }
                            MAIN_MEM[loc / 4 + (dataNumber * 4)] = parseHexString(token);
                            if (fulldebug) {
                                System.out.println("Main memory " + loc / 4 + "(" + loc + "/4) with offset of: " + (dataNumber * 4) + " was set to " + "0x" + token + " (value of: " + Long.toBinaryString(parseHexString(token)) + ")");
                                System.out.println("Padded Binary String: " + padBinaryString(Long.toBinaryString(MAIN_MEM[loc / 4])));
                                //System.out.println("Original length" + Long.toBinaryString(parseHexString(token)).length());
                                //System.out.println("Was less than 32 characters: " + (Long.toBinaryString(parseHexString(token)).length() < 32));
                            }
                            dataNumber++;
                        } else { // we're a pc or register
                            if (PC) // we're the PC
                            {
                                token = token.substring(2, token.length());
                                long temporary = parseHexString(token);
                                SP_REG[PC_addr] = (int) parseHexString(token);
                                if (fulldebug) {
                                    System.out.println("PC was set to: " + temporary);
                                }
                                special = false;
                                PC = false;
                            } else // we're a register
                            {
                                token = token.substring(2, token.length());
                                long temporary = parseHexString(token);
                                GEN_REG[register - 1] = (int) temporary;
                                if (fulldebug) {
                                    System.out.println("Register " + register + " set to : " + temporary);
                                }
                                special = false;
                            }
                        }
                    } else {
                        //System.out.println("We weren't a start of line or a valid token");
                        break;
                    }
                }
                //blank line to separate lines of fulldebug
                if (fulldebug) {
                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }



}

