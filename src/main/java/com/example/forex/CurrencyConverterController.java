package com.example.forex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CurrencyConverterController {

    @FXML
    private ComboBox<String> sourceCurrencyComboBox;

    @FXML
    private ComboBox<String> targetCurrencyComboBox;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label resultLabel;

    private static final double USD_TO_EUR_RATE = 0.85;
    private static final double CAD_TO_USD_RATE = 0.75;

    private static final double CAD_TO_EUR_RATE = 0.68;
    private static final double CAD_TO_RUP = 62.02;
    private static final double EUR_TO_RUP = 91.14;
    private static final double USD_TO_RUP = 83.07;

    @FXML
    private void initialize() {
        // Initialize ComboBox items
        sourceCurrencyComboBox.getItems().addAll("CAD","USD", "EUR","RUP");
        targetCurrencyComboBox.getItems().addAll("CAD","USD", "EUR","RUP");

        // Set default values
        sourceCurrencyComboBox.setValue("CAD");
        targetCurrencyComboBox.setValue("USD");
    }

    @FXML
    private void convert(ActionEvent event) {
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            String sourceCurrency = sourceCurrencyComboBox.getValue();
            String targetCurrency = targetCurrencyComboBox.getValue();

            // Perform the conversion
            double convertedAmount;
            if (sourceCurrency.equals("USD") && targetCurrency.equals("EUR")) {
                convertedAmount = amount * USD_TO_EUR_RATE;
            } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("USD")) {
                convertedAmount = amount / USD_TO_EUR_RATE;
            }else if(sourceCurrency.equals("CAD")&& targetCurrency.equals("USD")) {
                convertedAmount = amount * CAD_TO_USD_RATE;
            }
            else if (sourceCurrency.equals("USD")&& targetCurrency.equals("CAD")){
                convertedAmount = amount / CAD_TO_USD_RATE;
            }
            else if (sourceCurrency.equals("CAD")&& targetCurrency.equals("EUR")){
                convertedAmount = amount * CAD_TO_EUR_RATE;
            }
            else if (sourceCurrency.equals("EUR")&& targetCurrency.equals("CAD")){
                convertedAmount = amount / CAD_TO_EUR_RATE;
            }
            else if (sourceCurrency.equals("CAD")&& targetCurrency.equals("RUP")){
                convertedAmount = amount * CAD_TO_RUP;
            }
            else if (sourceCurrency.equals("RUP")&& targetCurrency.equals("CAD")){
                convertedAmount = amount / CAD_TO_RUP;
            }
            else if ( sourceCurrency.equals("EUR")&& targetCurrency.equals("RUP")){
                convertedAmount = amount * EUR_TO_RUP;
            }
            else if (sourceCurrency.equals("RUP")&& targetCurrency.equals("EUR")){
                convertedAmount = amount / EUR_TO_RUP;
            }
            else if (sourceCurrency.equals("USD")&& targetCurrency.equals("RUP")){
                convertedAmount = amount * USD_TO_RUP;
            }
            else if ( sourceCurrency.equals("RUP")&& targetCurrency.equals("USD")){
                convertedAmount = amount / USD_TO_RUP;
            }
            else {
                resultLabel.setText("Unsupported conversion");
                return;
            }

            // Display the result
            resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, sourceCurrency, convertedAmount, targetCurrency));

        } catch (NumberFormatException e) {
            // Handle invalid input
            resultLabel.setText("Invalid input");
        }
    }
}