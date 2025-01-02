public class Main {
    public static void main(String[] args) {
        long[] z = new long[8];//for number 1
        for (int i = 18; i >=4; i-=2){
            z[Math.abs(i/2-9)] = i;
        }

        double[] x = new double[15];//for number 2
        for (int i = 0; i < 15; i++) {
            x[i] = Math.random()*17 - 3;
        }

        double[][] z1 = new double[8][15]; // for number 3
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 15; j++) {
                z1[i][j] = calculateElement(z[i], x[j]);
            }
        }

        printMatrix(z1); // for number 4
    }

    public static double calculateElement(long zValue, double xValue) {
        if (zValue == 12) {
            return Math.sin(Math.pow((2.0 / 3.0) / xValue, xValue / 3.0));
        } else if (zValue == 4 || zValue == 6 || zValue == 14 || zValue == 16) {
            return Math.tan(Math.tan(Math.pow(xValue, (xValue / 3.0) / 4.0)));
        } else {
            return Math.pow(Math.pow(Math.cos(Math.pow(xValue, 1.0 / 3.0)) / 2.0, Math.pow((1.0 - Math.sin(xValue)), 3.0))  *0.5, 3.0);
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%6.3f\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
