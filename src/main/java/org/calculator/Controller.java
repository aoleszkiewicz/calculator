package org.calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.calculator.enums.Operation;
import org.calculator.interfaces.ICalculator;
import org.calculator.model.Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextField textField;
    public ICalculator calculator;
    public boolean displayResult = false;
    public boolean commaSet = false;

    public Controller() {
        calculator = new Calculator();
    }

    public void initialize() {
        textField.setStyle("-fx-text-fill: white; -fx-background-color: #252729;");
    }

    private boolean isNotEmpty(String text) {
        return text != null && !text.trim().isEmpty();
    }

    private void formatAndDisplayResult(Double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##############", DecimalFormatSymbols.getInstance(Locale.US));
        String formattedResult = decimalFormat.format(result);
        textField.setText(result.isInfinite() ? "NaN" : formattedResult);
        displayResult = true;
        commaSet = true;
    }

    @FXML
    public void onNumberButtonClickHandler(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String buttonValue = button.getText();
        textField.appendText(buttonValue);

        if (displayResult) {
            textField.clear();
            textField.appendText(buttonValue);
            displayResult = false;
        }
    }

    @FXML
    public void onCommaButtonClickHandler(ActionEvent actionEvent) {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            try {
                double num1 = Double.parseDouble(getText);
                if (!commaSet && num1 > 0.0) {
                    textField.appendText(".");
                    commaSet = true;
                }
            } catch (NumberFormatException e) {
                textField.setText("NaN");
                throw new NumberFormatException();
            }
        }
    }

    @FXML
    public void onClearButtonClickHandler(ActionEvent actionEvent) {
        calculator.clear();
        textField.clear();
        commaSet = false;
        displayResult = false;
    }

    @FXML
    public void onResultButtonClickHandler(ActionEvent actionEvent) {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            double currentNumber = Double.parseDouble(getText);
            calculator.setNumber2(currentNumber);
            try {
                Double result = calculator.calculate();
                formatAndDisplayResult(result);
            } catch (IllegalArgumentException e) {
                textField.setText("NaN");
                throw new NumberFormatException();
            }
        }
    }

    private void handleOperation(Operation operation) {
        String txtValue = textField.getText();
        if (isNotEmpty(txtValue)) {
            double num1 = Double.parseDouble(txtValue);
            calculator.setNumber1(num1);
            textField.setText("");
            calculator.setOperation(operation);
        }
        commaSet = false;
    }

    @FXML
    public void onPlusButtonClickHandler() {
        handleOperation(Operation.ADD);
    }

    @FXML
    public void onMinusButtonClickHandler() {
        handleOperation(Operation.SUBTRACT);
    }

    @FXML
    public void onDivButtonClickHandler() {
        handleOperation(Operation.DIVIDE);
    }

    @FXML
    public void onMultiplyButtonClickHandler() {
        handleOperation(Operation.MULTIPLY);
    }

    @FXML
    public void onSqrtButtonClickHandler() {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            try {
                double num1 = Double.parseDouble(getText);
                calculator.setNumber1(num1);
                calculator.setOperation(Operation.SQRT);
                Double result = calculator.calculate();
                formatAndDisplayResult(result);
            } catch (NumberFormatException e) {
                textField.setText("NaN");
                throw new NumberFormatException();
            }
        } else {
            textField.setText("");
        }
    }

    @FXML
    public void onPercentButtonClickHandler() {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber1(num1);
            calculator.setOperation(Operation.PERCENT);
            Double result = calculator.calculate();
            if (result != null) {
                formatAndDisplayResult(result);
            }
        }
    }

    @FXML
    public void onLogButtonClickHandler() {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber1(num1);
            calculator.setOperation(Operation.LOG);
            Double result = calculator.calculate();
            if (result != null) {
                formatAndDisplayResult(result);
            }
        }
    }

    @FXML
    public void onRevertButtonClickHandler() {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber1(num1);
            calculator.setOperation(Operation.REVERSE);
            Double result = calculator.calculate();
            if (result != null) {
                formatAndDisplayResult(result);
            }
        }
    }

    @FXML
    public void onSquareButtonClickHandler() {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber1(num1);
            calculator.setOperation(Operation.SQUARED);
            Double result = calculator.calculate();
            formatAndDisplayResult(result);
        }
    }

    @FXML
    public void onCubeButtonClickHandler() {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber1(num1);
            calculator.setOperation(Operation.CUBED);
            Double result = calculator.calculate();
            formatAndDisplayResult(result);
        }
    }

    @FXML
    public void onFactorialButtonClickHandler() {
        String getText = textField.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber1(num1);
            calculator.setOperation(Operation.FACTORIAL);
            Double result = calculator.calculate();
            formatAndDisplayResult(result);
        }
    }
}
