package W10.p3;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(2));
    }

    private static double squareRoot(double value) {
        double min = 1;
        double max = value;
        double i = 0.000001;
        while (max - min > i) {
            double mid = (min + max) / 2;
            if (mid * mid > value) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }


}
