package com.xhomerly.romannumeralcalc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField romanInput1;
    @FXML
    private TextField romanInput2;
    @FXML
    private Button plus, minus, multiply, divide;
    @FXML
    private Label output;

    public void initialize() {
        plus.setOnAction(calculate("+"));
        minus.setOnAction(calculate("-"));
        multiply.setOnAction(calculate("*"));
        divide.setOnAction(calculate("/"));
    }

    public EventHandler<ActionEvent> calculate(String operator) {
        return event -> {
            if (romanInput1.getText().matches("[I;V;X;L;C;D;M]")&& romanInput2.getText().matches("[I;V;X;L;C;D;M]")){
                String input1 = romanInput1.getText();
                int input1Int = romanToDecimal(input1);
                String input2 = romanInput2.getText();
                int input2Int = romanToDecimal(input2);
                double result = 0;
                switch (operator) {
                    case "+" -> result = input1Int + input2Int;
                    case "-" -> result = input1Int - input2Int;
                    case "*" -> result = input1Int * input2Int;
                    case "/" -> {
                        if (input2Int == 0) {
                            output.setText("Error: Division by zero");
                            return;
                        }
                        result = (double) input1Int / input2Int;
                    }
                }
                System.out.println(result);
                output.setText(decimalToRoman((int) result));
            } else {
                output.setText("Error: Invalid Roman Number");
            }
        };
    }

    public int value(char input) {
        switch (input) {
            case 'I' -> {
                return 1;
            }
            case 'V' -> {
                return 5;
            }
            case 'X' -> {
                return 10;
            }
            case 'L' -> {
                return 50;
            }
            case 'C' -> {
                return 100;
            }
            case 'D' -> {
                return 500;
            }
            case 'M' -> {
                return 1000;
            }
        }
        return -1;
    }

    public int romanToDecimal(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));

            // Getting value of symbol s[i+1]
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    result = result + s1;
                } else {
                    // Value of current symbol is
                    // less than the next symbol
                    result = result + s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
            }
        }

        return result;
    }

    public String decimalToRoman(int input) {
        if (input < 1 || input > 3000)
            return "Invalid Roman Number Value";
        StringBuilder s = new StringBuilder();
        while (input >= 1000) {
            s.append("M");
            input -= 1000;
        }
        while (input >= 900) {
            s.append("CM");
            input -= 900;
        }
        while (input >= 500) {
            s.append("D");
            input -= 500;
        }
        while (input >= 400) {
            s.append("CD");
            input -= 400;
        }
        while (input >= 100) {
            s.append("C");
            input -= 100;
        }
        while (input >= 90) {
            s.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            s.append("L");
            input -= 50;
        }
        while (input >= 40) {
            s.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            s.append("X");
            input -= 10;
        }
        while (input >= 9) {
            s.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            s.append("V");
            input -= 5;
        }
        while (input >= 4) {
            s.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            s.append("I");
            input -= 1;
        }
        return s.toString();
    }
}
