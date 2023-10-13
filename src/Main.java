import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static ResultFirst first(double A) {
        double sum = 0;
        int N = 1;
        for( ; sum <= A; ++N) {
            sum += (double) 1/N;
        }
        return new ResultFirst(N, sum);
    }

    private static double second(double X, int N) {
        double sum = 0;
        for (int i = 1; i <= N; ++i) {
            int sign = (i-1) % 2 != 0 ? -1 : 1;
            sum += sign * Math.pow(X, i) / i;
        }
        return sum;
    }

    private static ResultThird third(double X) {
        ResultThird result = new ResultThird();
        for (int i=0; i < ResultThird.arrayLength; i++) {
            double tempSum = 0;
            int k = 0;
            double tempRes = 0;
            do {
                tempSum += tempRes;
                tempRes = Math.pow(-1, k) * Math.pow((X / 2), 2 * (k+1)) / Math.pow(UsefullThings.fastFactorial((double) k+1), 2);
                k += 1;
            }
            while (Math.abs(tempRes) > ResultThird.E[i]);
            result.addToN(i, k);
            result.addToSum(i, tempSum);
        }
        return result;
    }

    private static ArrayList<ResultFourth> fourth() {
        final boolean IS_EVEN = false;
        final int LEFT_BORDER = 190061;
        final int RIGHT_BORDER = 190072;
        ArrayList<ResultFourth> list = new ArrayList<ResultFourth>();
        for (int i = LEFT_BORDER; i <= RIGHT_BORDER; i++) {
            if (i % 2 == 0) continue;
            int founded = 0;
            boolean fuck = true;
            for (int k = 2; k*k < i; k++) {
                if (i % k == 0) {
                    if ((i / k) % 2 == 0) {
                        fuck = true;
                        break;
                    }
                    if (founded != 0) {
                        fuck = true;
                        break;
                    }
                    founded = i / k;
                    fuck = false;
                }
            }
            if (!fuck) {
                list.add(new ResultFourth(i, Math.max(founded, i / founded)));
            }
        }
        return list;
    }

    private static int fiveth(int X) {
        String input = Integer.toString(X);
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    private static void runSecond(Scanner in) {
        System.out.print("Введите числа X и N, (|X| < 1, N > 0): ");
        double X = in.nextDouble();
        int N = in.nextInt();
        double result = second(X, N);
        System.out.printf("Сумма: %f", result);
    }

    private static void runFirst(Scanner in) {
        System.out.print("Введите число А, (А > 1): ");
        double A = in.nextDouble();
        ResultFirst result = first(A);
        System.out.printf("N: %d, Сумма: %f", result.getN(), result.getSum());
    }

    private static void runThird(Scanner in) {
        System.out.print("Введите число X: ");
        double X = in.nextDouble();

        ResultThird result = third(X);

        Object[][] table = new String[ResultThird.arrayLength][];
        for (int i=0; i < ResultThird.arrayLength; i++){
            table[i] = new String[] {
                    Double.toString(ResultThird.E[i]),
                    Double.toString(Math.round(result.getFromSum(i) * 1e5)),
                    Integer.toString(result.getFromN(i)),
            };
        }

        System.out.format("%-15s%-15s%-15s\n", "E", "Сумма", "N");
        for (Object[] row : table) {
            System.out.format("%-15s%-15s%-15s\n", row[0], row[1], row[2]);
        }
    }

    private static void runFourth(Scanner in) {
        ArrayList<ResultFourth> list = fourth();

        Object[][] table = new String[list.size()][];
        for (int i=0; i < list.size(); i++){
            table[i] = new String[] {
                    Integer.toString(list.get(i).getFirst()),
                    Integer.toString(list.get(i).getFirst()),
                    Integer.toString(list.get(i).getSecond()),
            };
        }

        System.out.format("%-15s%-15s%-15s\n", "Число", "Делитель 1", "Делитель 2");
        for (Object[] row : table) {
            System.out.format("%-15s%-15s%-15s\n", row[0], row[1], row[2]);
        }
    }

    private static void runFiveth(Scanner in) {
        System.out.print("Введите число X: ");
        int X = in.nextInt();

        int result = fiveth(X);

        System.out.printf("Реверснутое: %d", result);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Выберите таску: ");
        int taskNumber = in.nextInt();
        switch (taskNumber){
            case 1: runFirst(in);
            case 2: runSecond(in);
            case 3: runThird(in);
            case 4: runFourth(in);
            case 5: runFiveth(in);
        }

    }
}