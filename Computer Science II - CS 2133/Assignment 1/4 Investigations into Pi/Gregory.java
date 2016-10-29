/**
 * Created by giraffe on 8/29/2016.
 */


public class Gregory {
    public static void main(String[] args)
    {
        int userInput = Integer.parseInt(args[0]);


        double approximatePi = 0;


        for( int i = 1; i < userInput; i++)
        {
            approximatePi = approximatePi + ((Math.pow(-1,i+1)) * 4.0 / (2.0 * i - 1));
        }


        System.out.println("The approximate value of Pi is: " + approximatePi);
        System.out.println("There is a " + (100 - Math.PI / approximatePi * 100) + "% difference from Java's PI");

    }

}
