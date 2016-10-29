/**
 * Created by giraffe on 9/10/2016.
 */

/**
 * Due to the use of doubles in our Factorial program, we will be unable to calculate Pi with more accuracy.
 * While we are only able to use 5 as our highest input here due to the 4 * i passed to our Factorial() method,
 * this is still a very fast method of finding Pi compared to the Gregory series.
 * If we were to store these Factorial values using BigInteger we could calculate Pi to arbitrarily long decimal values.
 * The Factorial currently uses long which overflows if we give it more than a 20 for input.
 * Double accuracy is in base 2, which is much less accurate than base 10 for the representation of numbers that
 * we are used to working with. However, BigInteger and BigDecimal are stored in based 10. While we still cannot
 * accurately portray fractions such as 1/3 or 1/7 with them, we can do many other common calculations with greater
 * expected accuracy.
 */

public class Ramanujan {

    public static void main(String[] args)
    {
        int userInput = Integer.parseInt(args[0]);


        double approximatePi = 0;


        for( int i = 0; i < userInput; i++)
        {
            approximatePi = (approximatePi + (Factorial.calculate((4 * i)) * 11013+26390 * i) / (Math.pow(Factorial.calculate(i),4) * Math.pow(396,4*i)));
        }
        approximatePi *= 2 * Math.sqrt(2)/ 9801;

        System.out.println("The approximate value of Pi is: " + approximatePi);
        System.out.println("The margin of error is: " +  approximatePi / Math.PI);

    }

}
