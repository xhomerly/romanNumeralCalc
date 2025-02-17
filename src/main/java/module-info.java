module com.xhomerly.romannumeralcalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.xhomerly.romannumeralcalc to javafx.fxml;
    exports com.xhomerly.romannumeralcalc;
}