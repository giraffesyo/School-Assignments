import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Robot {
    private static final String serverIP = "lear.cs.okstate.edu";
    private static final int serverPort = 9095;
    private static PrintWriter out;

    private static double speed = 0.00;
    private static final double baseSpeed = 0.13;


    static double linX = 0.0;
    static double linY = 0.0;
    static double linZ = 0.0;
    static double angZ = 0.0;

    static int lastCalled = 0;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(serverIP, serverPort);
            System.out.println("Connection to server " + serverIP + " successful");
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                printMenu();
                Scanner in = new Scanner(System.in);
                int choice = Integer.parseInt((in.nextLine()));
                processChoice(choice, out);
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        }
    }

    private static double round(double x){
        return Math.round(x * 100.0) / 100.0;
    }

    private static void rTakeoff(PrintWriter out) {
        String takeoff_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
        out.write(takeoff_msg);
        out.flush();
    }

    private static void rLand(PrintWriter out) {
        String landing_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";
        out.write(landing_msg);
        out.flush();
    }

    private static void rUp(PrintWriter out) {
        linX = 0;
        linY = 0;
        linZ = baseSpeed + speed;
        angZ = 0;
        lastCalled = 3;

        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }

    private static void rDown(PrintWriter out) {
        linX = 0;
        linY = 0;
        linZ = -baseSpeed + speed;
        angZ = 0;
        lastCalled = 4;

        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }

    private static void rForward(PrintWriter out) {
        linX = baseSpeed + speed;
        linY = 0;
        linZ = 0;
        angZ = 0;
        lastCalled = 5;

        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }

    private static void rBackward(PrintWriter out) {
        linX = -baseSpeed + speed;
        linY = 0;
        linZ = 0;
        angZ = 0;
        lastCalled = 6;

        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }

    private static void rLeft(PrintWriter out) {
        linX = 0;
        linY = baseSpeed + speed;
        linZ = 0;
        angZ = 0;
        lastCalled = 7;

        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }

    private static void rRight(PrintWriter out) {
        linX = 0;
        linY = -baseSpeed + speed;
        linZ = 0;
        angZ = 0;
        lastCalled = 8;


        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }
    private static void rALeft(PrintWriter out) {
        linX = 0;
        linY = 0;
        linZ = 0;
        angZ = baseSpeed + speed;
        lastCalled = 9;


        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }

    private static void rARight(PrintWriter out) {
        linX = 0;
        linY = 0;
        linZ = 0;
        angZ = -baseSpeed + speed;
        lastCalled = 10;


        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }
    private static void rSpeedUp(PrintWriter out) throws Exception{
        if (speed < 0.12) {
            speed += .02;
            processChoice(lastCalled, out);
        }
        else
            throw(new Exception("Already at maximum velocity"));
    }

    private static void rSlowDown(PrintWriter out) throws Exception{
        if (speed > -0.12){
            speed -= .02;
            processChoice(lastCalled, out);}
        else
            throw(new Exception("Already at minimum velocity"));
    }

    private static void rStop(PrintWriter out) {
        linX = 0;
        linY = 0;
        linZ = 0;
        angZ = 0;
        lastCalled = 13;


        out.write(createMoveString(linX, linY, linZ, angZ));
        out.flush();
    }



    private static String createMoveString(double linX, double linY, double linZ, double angZ) {
        return "{\"op\":\"publish\"," +
                "\"topic\":\"/cmd_vel\"," +
                "\"msg\":{\"linear\":{" +
                "\"x\":" + linX + "," +
                "\"y\":" + linY + "," +
                "\"z\":" + linZ + "}," +
                "\"angular\":{" +
                "\"x\":0," +
                "\"y\":0," +
                "\"z\":" + angZ + "}}}";
    }

    private static void printMenu() {
        System.out.println("Please choose a number to select an option");
        System.out.println("1: Takeoff");
        System.out.println("2: Land");
        System.out.println("3: Up");
        System.out.println("4: Down");
        System.out.println("5: Forward");
        System.out.println("6: Backward");
        System.out.println("7: Strafe Left");
        System.out.println("8: Strafe Right");
        System.out.println("9: Turn Left");
        System.out.println("10: Turn Right");
        System.out.println("11: Speed Up");
        System.out.println("12: Slow Down");
        System.out.println("13: Stop Movement");
        if (round(speed + baseSpeed) == 0.25)
            System.out.println("Current Speed: " + round(speed + baseSpeed) + " (Maximum Velocity)");
        else if (round(speed + baseSpeed) == 0.01)
            System.out.println("Current Speed: " + round(speed + baseSpeed) + " (Minimum Velocity)");
        else
            System.out.println("Current Speed: " + round(speed + baseSpeed));
        System.out.println("Choice: ");
    }

    private static void processChoice(int choice, PrintWriter out) {
        switch (choice) {
            case 1:
                rTakeoff(out);
                break;
            case 2:
                rLand(out);
                break;
            case 3:
                rUp(out);
                break;
            case 4:
                rDown(out);
                break;
            case 5:
                rForward(out);
                break;
            case 6:
                rBackward(out);
                break;
            case 7:
                rLeft(out);
                break;
            case 8:
                rRight(out);
                break;
            case 9:
                rALeft(out);
                break;
            case 10:
                rARight(out);
                break;
            case 11:
                try{
                    rSpeedUp(out);
                }catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            case 12:
                try {
                    rSlowDown(out);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 13:
                rStop(out);
                break;
            default:
                break;
        }

    }
}
