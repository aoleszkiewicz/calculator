package org.calculator.model;

public class MathHelper {
    public static Double calculateFactorial(double n) {
        Double result;

        if (n < 0) {
            return Double.NaN;
        }

        if (n != Math.floor(n)) {
            return Double.NaN;
        }

        if (n > Double.MAX_VALUE) {
            return Double.NaN;
        }

        if (n == 0 || n == 1) {
            return 1.0;
        }

        result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;

            if (result > Double.MAX_VALUE) {
                return Double.NaN;
            }
        }

        return result;
    }
}
