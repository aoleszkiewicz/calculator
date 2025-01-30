module lab.calc.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab.calc.calculator to javafx.fxml;
    exports lab.calc.calculator;
}
