package org.calculator.interfaces;

import org.calculator.enums.Operation;

public interface ICalculator {
    void setOperation(Operation operation);
    void setNumber1(Double number);
    void setNumber2(Double number);
    Double calculate();
    void clear();
}
