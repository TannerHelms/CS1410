import java.util.Scanner;

public class Pyramid2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the rows you want:");
        int rows = input.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= (rows - i) * 2; j++) {


                System.out.print("  ");
            }
            for (int k=1; k<i; k++) {
                if (k==1) {
                    System.out.print("  " + k);
                } else {
                    // int p = (int) Math.pow(2,k);
                    System.out.print("  " + (int) Math.pow(2,k));
                }

            }
            for (int l=i; l>=1; l--) {

                if (l==1) {
                    System.out.print("  " + l);
                } else {
                    // int p = (int) Math.pow(2,k);
                    System.out.print("  " + (int) Math.pow(2,l));
                }
            }
            System.out.println();
        }
    }
}

