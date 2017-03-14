// Simulates MIPS

class MIPS {

    private int MAIN_MEM[];


    private int GEN_REG[];
    private int SP_REG[];

    MIPS(){
        final int MEMAMT = 4194304; // 4(2^20) == 4 MB
        MAIN_MEM = new int[MEMAMT]; //integer arrays are automatically instantiated to 0

        GEN_REG = new int[32]; //32 general purpose registers
        SP_REG = new int[4]; // 4 special purpose registers: PC, nPC, LO, and HI
    }

    





}
