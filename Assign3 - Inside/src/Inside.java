/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = {1, 2, 3, 4};
        double[] ptY = {1, 2, 3, 4};
        double[] circleX = {0, 5};
        double[] circleY = {0, 5};
        double[] circleRadius = {3, 3};
        double[] rectLeft = {-2.5, -2.5};
        double[] rectTop = {2.5, 5.0};
        double[] rectWidth = {6.0, 5.0};
        double[] rectHeight = {5.0, 2.5};
        System.out.println();

        System.out.println("--- Report of Points and Circles ---");
        for (int j = 0; j < circleX.length; j++) {
            for (int i = 0; i < ptX.length; i++) {
                reportPoint(ptX[i], ptY[i]);
                if (isPointInsideCircle(ptX[i], ptY[i], circleX[j], circleY[j], circleRadius[j])) {
                    reportCircle(circleX[j], circleY[j], circleRadius[j]);
                } else {
                    System.out.printf(" is outside Circle(%s, %s) Radius: %s\n", circleX[j], circleY[j], circleRadius[j]);
                }

            }
        }
        System.out.println();

        System.out.println("--- Report of Points and Rectangles ---");
        for (int j = 0; j < rectWidth.length; j++) {
            for (int i = 0; i < ptX.length; i++) {
                reportPoint(ptX[i], ptY[i]);
                if (isPointInsideRectangle(ptX[i], ptY[i], rectLeft[j], rectTop[j], rectWidth[j], rectHeight[j])) {
                    reportRectangle(rectLeft[j], rectTop[j], rectWidth[j], rectHeight[j]);
                } else {
                    System.out.printf(" is outside Rectangle(%s, %s, %s, %s)\n", rectLeft[j], rectTop[j], rectLeft[j] + rectWidth[j], rectTop[j] - rectHeight[j]);
                }

            }
        }
        System.out.println();
        System.out.println();
    }
    static void reportPoint(double x, double y) {

        System.out.printf("Point(%s, %s)", x, y);
    }
    public static void reportCircle(double x, double y, double r) {
        System.out.printf(" is inside Circle(%s, %s) Radius: %s\n", x, y, r);
    }

    public static void reportRectangle(double left, double top, double width, double height) {
        System.out.printf(" is inside Rectangle(%s, %s, %s, %s)\n", left, top, left + width, top - height);
    }

    public static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        if (Math.pow((ptX - circleX), 2) + Math.pow((ptY - circleY), 2) <= Math.pow(circleRadius, 2)) {
            return true;
        }
        return false;
    }

    public static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        double rBottom = rTop - rHeight;
        if (ptX > rLeft && ptX < rLeft + rWidth && ptY < rTop && ptY > rBottom) {
            return true;
        }
        return false;
    }
}