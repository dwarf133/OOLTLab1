final public class ResultThird {
    public static int arrayLength = 4;
    static double[] E = {0.001, 0.0001, 0.00001, 0.000001};
    double[] sum;
    int[] N;

    public ResultThird() {
        sum = new double[arrayLength];
        N = new int[arrayLength];
    }

    public void addToN(int pos, int val) {
        if (pos < arrayLength) {
            N[pos] = val;
        }
    }

    public void addToSum(int pos, double val) {
        if (pos < arrayLength) {
            sum[pos] = val;
        }
    }

    public int getFromN(int pos) {
        if (pos < arrayLength) {
            return N[pos];
        }
        return 0;
    }

    public double getFromSum(int pos) {
        if (pos < arrayLength) {
            return sum[pos];
        }
        return 0;
    }
}
