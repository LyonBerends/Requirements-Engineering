package nl.saxion.re.sponsorrun.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import nl.saxion.re.sponsorrun.data.Data;
import nl.saxion.re.sponsorrun.util.WindowHelper;

public class DetailScreenController {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPostalCode;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtCountry;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private TextField txtRegistrationFee;

    @FXML
    protected void initialize() {
        txtName.setText(Data.selectedRunner.name);
        txtAddress.setText(Data.selectedRunner.address);
        txtPostalCode.setText(Data.selectedRunner.postalCode);
        txtCity.setText(Data.selectedRunner.city);
        txtCountry.setText(Data.selectedRunner.country);
        txtEmail.setText(Data.selectedRunner.email);
        txtPhoneNumber.setText(Data.selectedRunner.phoneNumber);
        txtRegistrationFee.setText(Data.selectedRunner.registrationFee);
    }
    @FXML
    protected void onCancelClick() {
        WindowHelper.closeWindow(txtName);
    }

    @FXML
    protected void onOkClick() {
        // update fields of the selected runner
        Data.selectedRunner.name = txtName.getText();
        Data.selectedRunner.address = txtAddress.getText();
        Data.selectedRunner.postalCode = txtPostalCode.getText();
        Data.selectedRunner.city = txtCity.getText();
        Data.selectedRunner.country = txtCountry.getText();
        Data.selectedRunner.email = txtEmail.getText();
        Data.selectedRunner.phoneNumber = txtPhoneNumber.getText();
        Data.selectedRunner.registrationFee = txtRegistrationFee.getText();

        WindowHelper.closeWindow(txtName);
    }
}
