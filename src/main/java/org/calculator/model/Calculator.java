package org.calculator.model;

import org.calculator.enums.Operation;
import org.calculator.interfaces.ICalculator;

public final class Calculator implements ICalculator {
    public Operation operation;
    public double num1;
    public double num2;
    public double result;

    public Calculator() {
        this.clear();
    }

    @Override
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void setNumber1(Double number) {
        this.num1 = number;
    }

    @Override
    public void setNumber2(Double number) {
        this.num2 = number;
    }

    @Override
    public Double calculate() {
        switch (operation) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                if (num2 == 0) throw new IllegalArgumentException("Division by zero not allowed");
                result = num1 / num2;
                break;
            case SQRT:
                result = Math.sqrt(num1);
                break;
            case PERCENT:
                result = num1 / 100.0;
                break;
            case LOG:
                result = Math.log(num1);
                break;
            case REVERSE:
                result = 1 / num1;
                break;
            case SQUARED:
                result = Math.pow(num1, 2);
                break;
            case CUBED:
                result = Math.pow(num1, 3);
                break;
            case FACTORIAL:
                result = MathHelper.calculateFactorial(num1);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
        return result;
    }

    @Override
    public void clear() {
        operation = Operation.NULL;
        num1 = 0.0;
        num2 = 0.0;
        result = 0.0;
    }
}
