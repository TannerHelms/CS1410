import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        java.util.Scanner input = new Scanner(System.in);

        // Ask the user for the Coefficients.

        System.out.println("Enter A, B, C:");

        // Store the Coefficients so that the roots can be calculated

        var A = input.nextDouble();
        var B = input.nextDouble();
        var C = input.nextDouble();

        // Find the determinate to determine how many roots there are.

        var determinate = B * B - 4 * A * C;

        // Use the determinate in the if statement to know what type of calculation that needs to be computed.

        if (determinate > 0) {
            System.out.println("There are two roots for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + (-B + Math.pow(determinate, 0.5)) / (2 * A));
            System.out.println("r2 =  " + (-B - Math.pow(determinate, 0.5)) / (2 * A));
        } else if (determinate < 0) {
            System.out.println("There are no real roots for the quadratic equation with these coefficients.");

        } else {
            System.out.println("There is one real root for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + -B / 2 * A);
        }


    }
}