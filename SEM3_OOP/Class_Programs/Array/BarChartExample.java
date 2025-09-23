public class BarChartExample {
    public static void main(String[] args) {
        int[] values = {4, 7, 1, 9, 5};

        for (int i = 0; i < values.length; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            for (int j = 0; j < values[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
