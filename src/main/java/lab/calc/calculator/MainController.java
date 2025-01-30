package lab.calc.calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField txt;
    private final Calculator calculator;
    private boolean resultDisplayed = false;
    private boolean commaSet = false;

    public void initialize() {
        txt.setStyle("-fx-text-fill: white; -fx-background-color: #252729;");
    }

    public MainController() {
        calculator = new CalculatorImpl();
    }

    private boolean isNotEmpty(String text) {
        return text != null && !text.trim().isEmpty();
    }

    private void formatAndDisplayResult(Double result) {
        DecimalFormat df = new DecimalFormat("#.##############", DecimalFormatSymbols.getInstance(Locale.US));
        String formattedResult = df.format(result);
        txt.setText(result.isInfinite() ? "NaN" : formattedResult);
        resultDisplayed = true;
        commaSet = true;
    }

    @FXML
    public void onNumBtns(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        String btnValue = btn.getText();
        txt.appendText(btnValue);

        if (resultDisplayed) {
            txt.clear();
            txt.appendText(btnValue);
            resultDisplayed = false;
        }
    }

    @FXML
    public void onCommaBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            try {
                double num1 = Double.parseDouble(getText);
                if (!commaSet && num1 > 0.0) {
                    txt.appendText(".");
                    commaSet = true;
                }
            } catch (NumberFormatException e) {
                txt.setText("NaN");
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void onClearBtn() {
        calculator.clear();
        txt.clear();
        commaSet = false;
        resultDisplayed = false;
    }

    @FXML
    public void onEqualsBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            double currentNumber = Double.parseDouble(getText);
            calculator.setNextNumber(currentNumber);
            try {
                Double result = calculator.calculate();
                formatAndDisplayResult(result);
            } catch (IllegalArgumentException e) {
                txt.setText("NaN");
            }
        }
    }

    private void handleOperation(Operation operation) {
        String txtValue = txt.getText();
        if (isNotEmpty(txtValue)) {
            double num1 = Double.parseDouble(txtValue);
            calculator.setNumber(num1);
            txt.setText("");
            calculator.setOperation(operation);
        }
        commaSet = false;
    }

    @FXML
    public void onPlusBtn() {
        handleOperation(Operation.ADD);
    }

    @FXML
    public void onMinusBtn() {
        handleOperation(Operation.SUBTRACT);
    }

    @FXML
    public void onDivideBtn() {
        handleOperation(Operation.DIVIDE);
    }

    @FXML
    public void onMultiplyBtn() {
        handleOperation(Operation.MULTIPLY);
    }

    @FXML
    public void onSqrtBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            try {
                double num1 = Double.parseDouble(getText);
                calculator.setNumber(num1);
                calculator.setOperation(Operation.SQRT);
                Double result = calculator.calculate();
                formatAndDisplayResult(result);
            } catch (NumberFormatException e) {
                txt.setText("NaN");
            }
        } else {
            txt.setText("");
        }
    }

    @FXML
    public void onPercentBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber(num1);
            calculator.setOperation(Operation.PERCENT);
            Double result = calculator.calculate();
            if (result != null) {
                formatAndDisplayResult(result);
            }
        }
    }

    @FXML
    public void onLogBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber(num1);
            calculator.setOperation(Operation.LOG);
            Double result = calculator.calculate();
            if (result != null) {
                formatAndDisplayResult(result);
            }
        }
    }

    @FXML
    public void onReverseBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber(num1);
            calculator.setOperation(Operation.REVERSE);
            Double result = calculator.calculate();
            if (result != null) {
                formatAndDisplayResult(result);
            }
        }
    }

    @FXML
    public void onSquareBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber(num1);
            calculator.setOperation(Operation.SQUARED);
            Double result = calculator.calculate();
            formatAndDisplayResult(result);
        }
    }

    @FXML
    public void onCubeBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber(num1);
            calculator.setOperation(Operation.CUBED);
            Double result = calculator.calculate();
            formatAndDisplayResult(result);
        }
    }

    @FXML
    public void onFactorialBtn() {
        String getText = txt.getText();
        if (isNotEmpty(getText)) {
            double num1 = Double.parseDouble(getText);
            calculator.setNumber(num1);
            calculator.setOperation(Operation.FACTORIAL);
            Double result = calculator.calculate();
            formatAndDisplayResult(result);
        }
    }
}
