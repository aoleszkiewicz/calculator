package lab.calc.calculator;

public interface Calculator {

    void setOperation(Operation operation);

    void setNumber(Double number);

    void setNextNumber(Double number);

    Double calculate();

    void clear();
}
