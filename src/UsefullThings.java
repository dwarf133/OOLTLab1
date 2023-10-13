public class UsefullThings {
    public static int factorial(int n) {
        if (n == 0) return 1;
        else return factorial(n-1) * n;
    }

    public static double lnFactorial(double n) {
        return n * Math.log(n) - n;
    }

    public static double fastFactorial(double n) {
        return Math.pow(Math.E, lnFactorial(n));
    }
}
