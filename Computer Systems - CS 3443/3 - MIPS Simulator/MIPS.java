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
    private static final boolean parseDebug = false;
    private static final boolean debug = true;

    //So we don't have to remember which register is which
    private final static int PC_addr = 0;
    private final static int nPC_addr = 1;
    private final static int LO_addr = 2;
    private final static int HI_addr = 3;

    private static int MemoryAllocation = 524288;


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
        final int offset = 4;


        while (true) {
            int Instr = (int) MAIN_MEM[SP_REG[PC_addr] / 4];
            int source = (Instr >> 21) & 0b11111;
            int target = (Instr >> 16) & 0b11111;
            int destination = (Instr >> 11) & 0b11111;
            int shift = (Instr >> 6) & 0b11111;
            int immediate = Instr & 0xFFFF;
            int jumptarget = Instr & 0b1111_1111_1111_1111_1111_111111;

            // PC, Current Instruction in Hex, the registers, have ways to write command to get values from main memory
            if (debug) {
                System.out.println("PC: " + String.format("0x%X", SP_REG[PC_addr]) + '\t' + "Current Instr: " + String.format("0x%08X", Instr) +
                        " Current source: " + source + " Current target: " + target + " Immediate: " + immediate);

                while (true) {
                    System.out.println();
                    System.out.println("Enter to continue, else try: registers, memory");
                    Scanner userDebug = new Scanner(System.in);
                    String readString = userDebug.nextLine();
                    if (readString.isEmpty()) {
                        System.out.println("Continuing...");
                        break;
                    } else if (readString.toLowerCase().equals("registers")) {
                        // dump all registers
                        System.out.println("Registers: ");
                        for (int i = 0; i < 32; i++) {
                            System.out.println("Register " + i + ": " + String.format("0x%08X", GEN_REG[i]));
                        }
                    } else if (readString.toLowerCase().equals("memory")) {
                        // ask for memory address
                        System.out.print("Memory address: ");
                        int readInt = userDebug.nextInt();
                        System.out.println("Address " + readInt + " contains: " + String.format("0x%08X", MAIN_MEM[readInt]));
                    }
                }
            }

            if ((Instr & MASK1) == ADD_INSTR) {
                //$d = $s + $t; advance_pc (4);
                GEN_REG[destination] = GEN_REG[source] + GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK2) == ADDI_INSTR) {
                //$t = $s + imm; advance_pc (4);
                //TODO: Make sign extended
                GEN_REG[target] = GEN_REG[source] + immediate;
                advance_pc(offset);
            } else if ((Instr & MASK2) == ADDIU_INSTR) {
                //$t = $s + imm; advance_pc (4);
                //No difference between ADDI
                //TODO: Make sign extended
                //TODO: Unsigned
                GEN_REG[target] = GEN_REG[source] + immediate;
                advance_pc(offset);
            } else if ((Instr & MASK1) == ADDU_INSTR) {
                //$d = $s + $t; advance_pc (4);
                //same as ADD instruction
                //TODO: Unsigned
                GEN_REG[destination] = GEN_REG[source] + GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK1) == AND_INSTR) {
                //$d = $s & $t; advance_pc (4);
                GEN_REG[destination] = GEN_REG[source] & GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK2) == ANDI_INSTR) {
                //$t = $s & imm; advance_pc (4);
                GEN_REG[target] = GEN_REG[source] & immediate;
                advance_pc(offset);
            } else if ((Instr & MASK2) == BEQ_INSTR) {
                //if $s == $t advance_pc (offset << 2)); else advance_pc (4);
                if (GEN_REG[source] == GEN_REG[target])
                    advance_pc(offset << 2);
                else advance_pc(offset);
            } else if ((Instr & MASK3) == BGEZ_INSTR) {
                //if $s >= 0 advance_pc (offset << 2)); else advance_pc (4);
                if (GEN_REG[source] >= 0)
                    advance_pc(offset << 2);
                else
                    advance_pc(offset);
            } else if ((Instr & MASK3) == BGEZAL_INSTR) {
                //if $s >= 0 $31 = PC + 8 (or nPC + 4); advance_pc (offset << 2)); else advance_pc (4);
                if (GEN_REG[source] >= 0) {
                    GEN_REG[31] = SP_REG[PC_addr] + 8;
                    advance_pc(offset << 2);
                } else
                    advance_pc(offset);
            } else if ((Instr & MASK3) == BGTZ_INSTR) {
                //if $s > 0 advance_pc (offset << 2)); else advance_pc (4);
                if (GEN_REG[source] > 0)
                    advance_pc(offset << 2);
                else
                    advance_pc(offset);
            } else if ((Instr & MASK3) == BLEZ_INSTR) {
                //if $s <= 0 advance_pc (offset << 2)); else advance_pc (4);
                if (GEN_REG[source] <= 0)
                    advance_pc(offset << 2);
                else
                    advance_pc(offset);
            } else if ((Instr & MASK3) == BLTZ_INSTR) {
                //if $s < 0 advance_pc (offset << 2)); else advance_pc (4);
                if (GEN_REG[source] < 0)
                    advance_pc(offset << 2);
                else
                    advance_pc(offset);
            } else if ((Instr & MASK3) == BLTZAL_INSTR) {
                //if $s < 0 $31 = PC + 8 (or nPC + 4); advance_pc (offset << 2)); else advance_pc (4);
                if (GEN_REG[source] < 0) {
                    GEN_REG[31] = SP_REG[PC_addr] + 8;
                    advance_pc(offset << 2);
                } else
                    advance_pc(offset);

            } else if ((Instr & MASK2) == BNE_INSTR) {
                //if $s != $t advance_pc (offset << 2)); else advance_pc (4);
                if (GEN_REG[source] != GEN_REG[target])
                    advance_pc(offset << 2);
                else
                    advance_pc(offset);
            } else if ((Instr & MASK4) == DIV_INSTR) {
                //$LO = $s / $t; $HI = $s % $t; advance_pc (4);
                SP_REG[LO_addr] = GEN_REG[source] / GEN_REG[target];
                SP_REG[HI_addr] = GEN_REG[source] % GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK4) == MULT_INSTR) {
                //$LO = $s * $t; advance_pc (4);
                SP_REG[LO_addr] = GEN_REG[source] * GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK2) == J_INSTR) {
                //PC = nPC; nPC = (PC & 0xf0000000) | (target << 2);
                SP_REG[PC_addr] = SP_REG[nPC_addr];
                SP_REG[nPC_addr] = (SP_REG[PC_addr] & 0xf0000000) | (jumptarget << 2);
            } else if ((Instr & MASK2) == JAL_INSTR) {
                //$31 = PC + 8 (or nPC + 4); PC = nPC; nPC = (PC & 0xf0000000) | (target << 2);
                GEN_REG[31] = SP_REG[PC_addr] + 8; //PC+8
                SP_REG[PC_addr] = SP_REG[nPC_addr]; // PC = nPC
                SP_REG[nPC_addr] = (SP_REG[PC_addr] & 0xf0000000) | (jumptarget << 2); // nPC = (PC & 0xf0000000) | (target <<2)
            } else if ((Instr & MASK5) == JR_INSTR) {
                //PC = nPC; nPC = $s;
                SP_REG[PC_addr] = SP_REG[nPC_addr];
                SP_REG[nPC_addr] = GEN_REG[source];
            } else if ((Instr & MASK2) == LB_INSTR) {
                //$t = MEM[$s + offset]; advance_pc (4);
                GEN_REG[target] = (int) MAIN_MEM[source + immediate];
                advance_pc(offset);
            } else if ((Instr & MASK2) == LUI_INSTR) {
                //$t = (imm << 16); advance_pc (4);
                GEN_REG[target] = (immediate << 16);
                advance_pc(offset);
            } else if ((Instr & MASK2) == LW_INSTR) {
                //$t = MEM[$s + offset]; advance_pc (4);
                GEN_REG[target] = (int) MAIN_MEM[source + immediate];
                advance_pc(offset);
            } else if ((Instr & MASK6) == MFHI_INSTR) {
                //$d = $HI; advance_pc (4);
                GEN_REG[destination] = SP_REG[HI_addr];
                advance_pc(offset);
            } else if ((Instr & MASK6) == MFLO_INSTR) {
                //$d = $LO; advance_pc (4);
                GEN_REG[destination] = SP_REG[LO_addr];
                advance_pc(offset);
            } else if ((Instr & MASK1) == OR_INSTR) {
                //$d = $s | $t; advance_pc (4);
                GEN_REG[destination] = GEN_REG[source] | GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK2) == ORI_INSTR) {
                //$t = $s | imm; advance_pc (4);
                GEN_REG[target] = GEN_REG[source] | immediate;
                advance_pc(offset);
            } else if ((Instr & MASK2) == SB_INSTR) {
                //MEM[$s + offset] = (0xff & $t); advance_pc (4);
                MAIN_MEM[source + offset] = (0xff & GEN_REG[target]);
                advance_pc(offset);
            } else if ((Instr & MASK8) == SLL_INSTR) {
                //$d = $t << h; advance_pc (4);
                GEN_REG[destination] = GEN_REG[target] << shift;
                advance_pc(offset);
            } else if ((Instr & MASK8) == SLLV_INSTR) {
                //$d = $t << $s; advance_pc (4);
                GEN_REG[destination] = GEN_REG[target] << GEN_REG[source];
                advance_pc(offset);
            } else if ((Instr & MASK1) == SLT_INSTR) {
                //if $s < $t $d = 1; advance_pc (4); else $d = 0; advance_pc (4);
                if (GEN_REG[source] < GEN_REG[target]) {
                    GEN_REG[destination] = 1;
                    advance_pc(offset);
                } else {
                    GEN_REG[destination] = 0;
                    advance_pc(offset);
                }
            } else if ((Instr & MASK2) == SLTI_INSTR) {
                //if $s < imm $t = 1; advance_pc (4); else $t = 0; advance_pc (4);
                if (GEN_REG[source] < immediate) {
                    GEN_REG[target] = 1;
                    advance_pc(offset);
                } else {
                    GEN_REG[target] = 0;
                    advance_pc(offset);
                }
            } else if ((Instr & MASK2) == SLTIU_INSTR) {
                //if $s < imm $t = 1; advance_pc (4); else $t = 0; advance_pc (4);
                //TODO: Should be Unsigned immediate
                if (GEN_REG[source] < immediate) {
                    GEN_REG[target] = 1;
                    advance_pc(offset);
                } else {
                    GEN_REG[target] = 0;
                    advance_pc(offset);
                }
            } else if ((Instr & MASK1) == SLTU_INSTR) {
                //if $s < $t $d = 1; advance_pc (4); else $d = 0; advance_pc (4);
                //TODO: Unsigned (duplicate of SLT)
                if (GEN_REG[source] < GEN_REG[target]) {
                    GEN_REG[destination] = 1;
                    advance_pc(offset);
                } else {
                    GEN_REG[destination] = 0;
                    advance_pc(offset);
                }
            } else if ((Instr & MASK8) == SRA_INSTR) {
                //$d = $t >> h; advance_pc (4);
                GEN_REG[destination] = GEN_REG[target] >> shift;
                advance_pc(offset);
            } else if ((Instr & MASK8) == SRL_INSTR) {
                //$d = $t >> h; advance_pc (4);
                GEN_REG[destination] = GEN_REG[target] >> shift;
                advance_pc(offset);
            } else if ((Instr & MASK1) == SRLV_INSTR) {
                //$d = $t >> $s; advance_pc (4);
                GEN_REG[destination] = GEN_REG[target] >> GEN_REG[source];
                advance_pc(offset);
            } else if ((Instr & MASK1) == SUB_INSTR) {
                //$d = $s - $t; advance_pc (4);
                GEN_REG[destination] = GEN_REG[source] - GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK1) == SUBU_INSTR) {
                //$d = $s - $t; advance_pc (4);
                GEN_REG[destination] = GEN_REG[source] - GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK2) == SW_INSTR) {
                //MEM[$s + offset] = $t; advance_pc (4);
                MAIN_MEM[source + offset] = GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK8) == SYSCALL_INSTR) {
                //advance_pc (4);
                if (GEN_REG[2] == 1) // Print integer
                {
                    System.out.print(GEN_REG[4]);
                } else if (GEN_REG[2] == 4) // Print String (null-terminated)
                {
                    //String is stored in Main memory at the address stored in $a0 (Register 4)

                    int address = GEN_REG[4];
                    while (true) {
                        //get character out of int array
                        //check if its \0, if \0 break;
                        int temp = (int) MAIN_MEM[address / 4];
                        //System.out.println("Next address: " + (int)MAIN_MEM[address/4+1]);
                        //System.out.printf("Temp Hex: %x%n", temp);
                        temp >>= (address % 4) * 8;
                        temp &= 0xFF;
                        //System.out.println("Temp before break: " + temp);
                        if (temp == '\0')
                            break;
                        address++;
                        System.out.print((char) temp);
                    }
                } else if (GEN_REG[2] == 11) //Print Character
                {
                    System.out.print((char) GEN_REG[4]);
                } else if (GEN_REG[2] == 5) // Read Integer
                {
                    Scanner keyIn = new Scanner(System.in);
                    GEN_REG[2] = keyIn.nextInt();
                } else if (GEN_REG[2] == 8) //Read String
                {
                    /*
                    (8) Read string – Reads a string into address pointed to by $a0=$4, up to $a1-1 characters,
                     and null terminates the string. Note that the characters must be stored as bytes,
                     so you will have to deal with converting a string from the language used for your simulator to a null terminated string stored in an array of ints.
                     */
                    Scanner keyIn = new Scanner(System.in);
                    //MAIN_MEM[GEN_REG[4]] = a string
                    int size = GEN_REG[5] - 1; // $A1 - 1
                    String userString = keyIn.nextLine();
                    for (int i = 0; i < size; i++) {
                        MAIN_MEM[GEN_REG[4 + i]] = (int) userString.charAt(i);
                    }
                } else if (GEN_REG[2] == 9) // Allocate Memory
                {
                    int space = GEN_REG[4];
                    GEN_REG[2] = MemoryAllocation;
                    MemoryAllocation += space;
                } else if (GEN_REG[2] == 10) // Exit
                {
                    System.exit(0);
                }
                advance_pc(offset);
            } else if ((Instr & MASK8) == XOR_INSTR) {
                //$d = $s ^ $t; advance_pc (4);
                GEN_REG[destination] = GEN_REG[source] ^ GEN_REG[target];
                advance_pc(offset);
            } else if ((Instr & MASK2) == XORI_INSTR) {
                //$t = $s ^ imm; advance_pc (4);
                GEN_REG[target] = GEN_REG[source] ^ immediate;
            }
            GEN_REG[0] = 0; // register 0 should always be zero.
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
                        if (parseDebug) {
                            System.out.println();
                        }
                        continue;
                    }

                    if (token.startsWith("[")) {
                        token = token.substring(1, token.length() - 1); //strip brackets
                        if (parseDebug) {
                            System.out.println("token: " + token);
                        }
                        if (beginsAlphabetically(token)) {
                            special = true;
                            if (token.charAt(0) == 'R') {
                                token = token.substring(1, token.length());
                                register = Integer.parseInt(token);
                                if (parseDebug) {
                                    System.out.println("Found Register: " + register);
                                }
                            } else {
                                PC = true;
                                if (parseDebug) {
                                    System.out.println("Found PC");
                                }
                            }


                            //Set up a way to detect what register we're at later so we know where to store info

                        } else { //Line doesn't start with PC or R
                            token = token.substring(2, token.length());
                            loc = (int) parseHexString(token); // Converted to decimal int from string
                            if (parseDebug) {

                                System.out.println("Stripped token: " + token);
                                System.out.println("Processed token: " + loc);
                            }
                        }
                        StartOfLine = false;
                    }
                    //information associated with address

                    else if (token.startsWith("0x") && !StartOfLine) {
                        if (parseDebug) {
                            System.out.println("instr: " + token + " Associated with loc: " + loc);
                        }
                        //Store data in loc/4 to location in memory
                        if (!special) {
                            token = token.substring(2, token.length());
                            if (parseDebug) {
                                System.out.println("Stripped instr token:" + token);
                            }
                            MAIN_MEM[loc / 4 + (dataNumber)] = parseHexString(token);
                            if (parseDebug) {
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
                                if (parseDebug) {
                                    System.out.println("PC was set to: " + temporary);
                                }
                                special = false;
                                PC = false;
                            } else // we're a register
                            {
                                token = token.substring(2, token.length());
                                long temporary = parseHexString(token);
                                GEN_REG[register] = (int) temporary;
                                if (parseDebug) {
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
                //blank line to separate lines of parseDebug
                if (parseDebug) {
                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


}

