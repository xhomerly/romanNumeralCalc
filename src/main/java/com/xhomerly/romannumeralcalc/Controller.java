package com.xhomerly.romannumeralcalc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField romanInput1;
    @FXML private TextField romanInput2;
    @FXML private Button plus, minus, multiply, divide;
    @FXML private Label output;

    public void initialize() {
        plus.setOnAction(calculate("+"));
        minus.setOnAction(calculate("-"));
        multiply.setOnAction(calculate("*"));
        divide.setOnAction(calculate("/"));
    }

    public EventHandler<ActionEvent> calculate(String operator) {
        return event -> {
            String input1 = romanInput1.getText();
            int input1Int = Integer.parseInt(input1);
            String input2 = romanInput2.getText();
            int input2Int = Integer.parseInt(input2);
            double result = 0;
            switch (operator) {
                case "+":
                    result = input1Int + input2Int;
                    break;
                case "-":
                    result = input1Int - input2Int;
                    break;
                case "*":
                    result = input1Int * input2Int;
                    break;
                case "/":
                    if (input2Int == 0) {
                        output.setText("Error: Division by zero");
                        return;
                    }
                    result = (double) input1Int / input2Int;
                    break;
            }
            output.setText(""+result);
        };
    }
}