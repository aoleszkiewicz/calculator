package lab.calc.calculator;

public class CalculatorImpl implements Calculator {

    private Operation operation;
    public double num1;
    public double num2;
    public double total;

    @Override
    public final void clear() {
        operation = Operation.NULL;
        num1 = 0.0;
        num2 = 0.0;
        total = 0.0;
    }

    public CalculatorImpl() {
        operation = Operation.NULL;
        num1 = 0.0;
        num2 = 0.0;
        total = 0.0;
    }

    @Override
    public final void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public final void setNumber(Double number) {
        num1 = number;
    }

    @Override
    public final void setNextNumber(Double number) {
        num2 = number;
    }

    @Override
    public Double calculate() throws IllegalArgumentException {
        if (operation != null) {
            switch (operation) {
                case SQRT:
                    total = Math.sqrt(num1);
                    break;
                case PERCENT:
                    total = num1 / 100.0;
                    break;
                case LOG:
                    total = Math.log(num1);
                    break;
                case REVERSE:
                    total = 1 / num1;
                    break;
                case ADD:
                    total = num1 + num2;
                    break;
                case SUBTRACT:
                    total = num1 - num2;
                    break;
                case DIVIDE:
                    if (num2 == 0 || num2 == 0.0) {
                        throw new IllegalArgumentException("Nie można dzielić przez zero");
                    }
                    total = num1 / num2;

                    break;
                case MULTIPLY:
                    total = num1 * num2;
                    break;
                case SQUARED:
                    total = Math.pow(num1, 2);
                    break;
                case CUBED:
                    total = Math.pow(num1, 3);
                    break;
                case FACTORIAL:
                    total = calculateFactorial(num1);
                    break;
                default:
                    throw new IllegalArgumentException("Operacja nie jest obsługiwana");
            }
        }
        return total;
    }

    public Double calculateFactorial(double n) {
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

        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;

            if (result > Double.MAX_VALUE) {
                return Double.NaN;
            }
        }

        return result;
    }
}
