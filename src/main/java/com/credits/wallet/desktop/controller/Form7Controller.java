package com.credits.wallet.desktop.controller;


import com.credits.wallet.desktop.App;
import com.credits.wallet.desktop.AppState;
import com.credits.wallet.desktop.utils.Convertor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Rustem.Saidaliyev on 26.01.2018.
 */
public class Form7Controller extends Controller implements Initializable {

    @FXML
    private TextField toAddress;

    @FXML
    private Label amountInCs;

    @FXML
    private Label transactionFeeValue;

    @FXML
    private Label transactionFee;

    @FXML
    private TextField transactionCode;

    @FXML
    private void handleGenerate() {
        AppState.transactionHash = transactionCode.getText();
        App.showForm("/fxml/form8.fxml", "Wallet");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.toAddress.setText(AppState.toAddress);
        this.amountInCs.setText(Convertor.toString(AppState.amount) + " CS");
        this.transactionFeeValue.setText(Convertor.toString(AppState.transactionFeeValue) + " CS");
        this.transactionFee.setText(Convertor.toString(AppState.transactionFeePercent) + " %");
    }

}
