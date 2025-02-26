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

//    TODO: Romčův kódík

//    public class HelloController {
//
//        @FXML
//        private Button deleno_B;
//
//        @FXML
//        private TextField firstNumber_TF;
//
//        @FXML
//        private Button krat_B;
//
//        @FXML
//        private Button minus_B;
//
//        @FXML
//        private Button plus_B;
//
//        @FXML
//        private TextField secondNumber_TF;
//
//        @FXML
//        private Label vysledek_L;
//
//        @FXML
//        void calc(ActionEvent event) {
//            System.out.println(event.getSource());
//            if (!firstNumber_TF.getText().equals("") && !secondNumber_TF.getText().equals("")) {
//                int tmp = convert_Roman_To_Int(firstNumber_TF.getText());
//                int tmp2 = convert_Roman_To_Int(secondNumber_TF.getText());
//                System.out.println("První: " + tmp + "| Druhe: " + tmp2);
//                if (event.getSource() == plus_B) {
//                    vysledek_L.setText(convert_Int_To_Roman(tmp + tmp2));
//                    System.out.println(tmp + tmp2);
//                }
//                else if (event.getSource() == minus_B) {
//                    vysledek_L.setText(convert_Int_To_Roman(tmp - tmp2));
//                    System.out.println(tmp - tmp2);
//                }
//                else if (event.getSource() == krat_B) {
//                    vysledek_L.setText(convert_Int_To_Roman(tmp * tmp2));
//                    System.out.println(tmp * tmp2);
//                }
//                else if (event.getSource() == deleno_B) {
//                    vysledek_L.setText(convert_Int_To_Roman(tmp / tmp2));
//                    System.out.println(tmp / tmp2);
//                }
//            }
//        }
//
//        public int convert_Roman_To_Int(String rn) {
//            int romanAsInt = 0;
//            int x = 0;
//
//            while (x < rn.length()) {
//                int currentValue = getRomanValue(rn.charAt(x));
//
//                if (x + 1 < rn.length()) {
//                    int nextValue = getRomanValue(rn.charAt(x + 1));
//                    if (currentValue < nextValue) {
//                        romanAsInt -= currentValue;
//                    } else {
//                        romanAsInt += currentValue;
//                    }
//                } else {
//                    romanAsInt += currentValue;
//                }
//                x++;
//            }
//
//            return romanAsInt;
//        }
//
//        private int getRomanValue(char romanChar) {
//            switch (romanChar) {
//                case 'M': return 1000;
//                case 'D': return 500;
//                case 'C': return 100;
//                case 'L': return 50;
//                case 'X': return 10;
//                case 'V': return 5;
//                case 'I': return 1;
//                default: throw new NumberFormatException("Illegal character in Roman numeral");
//            }
//        }
//
//
//        public String convert_Int_To_Roman(int n) {
//            String roman = "";
//
//            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//
//            for (int i = 0; i < values.length; i++) {
//                while (n >= values[i]) {
//                    roman += symbols[i];
//                    n -= values[i];
//                }
//            }
//
//            return roman;
//        }
//
//    }
}