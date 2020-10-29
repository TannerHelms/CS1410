import java.util.ArrayList;

public class Recursion {
    public static void main(String[] args) {

        int[] sumMe = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        System.out.printf("Array Sum: %d\n", arraySum(sumMe, 0));

        int[] minMe = {0, 1, 1, 2, 3, 5, 8, -42, 13, 21, 34, 55, 89};
        System.out.printf("Array Min: %d\n", arrayMin(minMe, 0));

        String[] amISymmetric = {
                "You can cage a swallow can't you but you can't swallow a cage can you",
                "I still say cS 1410 is my favorite class"
        };
        for (String test : amISymmetric) {
            String[] words = test.toLowerCase().split(" ");
            System.out.println();
            System.out.println(test);
            System.out.printf("Is word symmetric: %b\n", isWordSymmetric(words, 0, words.length - 1));
        }

        double weights[][] = {
                {51.18},
                {55.90, 131.25},
                {69.05, 133.66, 132.82},
                {53.43, 139.61, 134.06, 121.63}
        };
        System.out.println();
        System.out.println("--- Weight Pyramid ---");
        for (int row = 0; row < weights.length; row++) {
            for (int column = 0; column < weights[row].length; column++) {
                double weight = computePyramidWeights(weights, row, column);
                System.out.printf("%.2f ", weight);
            }
            System.out.println();
        }

        char image[][] = {
                {'*', '*', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' '},
                {' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', '*', '*', ' ', ' '},
                {' ', '*', ' ', ' ', '*', '*', '*', ' ', ' ', ' '},
                {' ', '*', '*', ' ', '*', ' ', '*', ' ', '*', ' '},
                {' ', '*', '*', ' ', '*', '*', '*', '*', '*', '*'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' '},
                {' ', ' ', ' ', '*', '*', '*', ' ', ' ', '*', ' '},
                {' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', '*', ' '}
        };
        int howMany = howManyOrganisms(image);
        System.out.println();
        System.out.println("--- Labeled Organism Image ---");
        for (char[] line : image) {
            for (char item : line) {
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.printf("There are %d organisms in the image.\n", howMany);

    }

    public static long arraySum(int[] data, int position) {
        if (position == data.length - 1) {
            return data[data.length - 1];
        } else {
            return data[position] + arraySum(data, position + 1);
        }
    }

    public static int arrayMin(int[] data, int position) {
        if (data.length == 1) {
            return data[0];
        }
        if (position == data.length - 1) {
            return data[position];
        }
        return Math.min(data[position], arrayMin(data, position + 1));
    }

    public static boolean isWordSymmetric(String[] words, int start, int end) {
        if (start == end) {
            return true;
        } else if (start == end - 1){
            return true;
        } else if (words[start].equals(words[end]) ) {
            return isWordSymmetric(words, start + 1, end - 1);
        } else {
            return false;
        }

    }

    public static double computePyramidWeights(double[][] weights, int row, int column) {
        if (row < 0 || row > weights.length) {
            return 0;
        }else if (column < 0 || column >= weights[row].length) {
            return 0;
        } else if (row == 0 && column == 0) {
            return weights[0][0];
        } else if (row == 1) {
            return (weights[row][column] + weights[0][0] / 2);
        } else if (column == weights.length - 1) {
            return weights[row][column] + computePyramidWeights(weights, row - 1, column - 1) / 2;
        } else if (column == 0) {
            return weights[row][column] + computePyramidWeights(weights, row - 1, column) / 2;
        } else {
            return weights[row][column] + computePyramidWeights(weights, row - 1, column - 1) / 2 + computePyramidWeights(weights, row - 1, column) / 2;
        }
    }

    public static int howManyOrganisms(char[][] image) {
        char letter = 'A';
        int Organisms = 0;
        for (int col = 0; col < image.length; col++) {
            for (int row = 0; row < image[col].length - 1; row++) {
                if (image[col][row] == '*') {
                    image = howManyOrganisms(image, col, row, letter);
                    letter++;
                    Organisms++;


                }
            }
        }
        return Organisms;
    }
    public static char[][] howManyOrganisms(char[][] image, int col, int row, char letter){
        image[col][row] = letter;


        if (col + 1 < image.length) {
            if (image[col + 1][row] == '*') {
                howManyOrganisms(image, col + 1, row, letter);
            }
        }
        if (col - 1 >= 0) {
            if (image[col - 1][row] == '*') {
                howManyOrganisms(image,col-1, row, letter);
            }
        }
        if (row - 1 >= 0) {
            if (image[col][row - 1] == '*') {
                howManyOrganisms(image, col, row - 1, letter);
            }
        }
        if (row + 1 < image[col].length) {
            if (image[col][row + 1] == '*') {
                howManyOrganisms(image, col, row + 1, letter);
            }
        }
        return image;
    }
}
