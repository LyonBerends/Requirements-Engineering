package nl.saxion.re.sponsorrun.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import nl.saxion.re.sponsorrun.data.Data;
import nl.saxion.re.sponsorrun.util.WindowHelper;

public class SponsorDetailScreenController {

    @FXML
    private TextField txtOrganization;
    @FXML
    private TextField txtContactPerson;
    @FXML
    private TextField txtAmount;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtRemarks;

    @FXML
    protected void initialize() {
        txtOrganization.setText(Data.selectedSponsor.organization);
        txtContactPerson.setText(Data.selectedSponsor.contactPerson);
        txtAmount.setText(Data.selectedSponsor.amount);
        txtPhone.setText(Data.selectedSponsor.phone);
        txtEmail.setText(Data.selectedSponsor.email);
        txtRemarks.setText(Data.selectedSponsor.remarks);
    }
    @FXML
    protected void onCancelClick() {
        WindowHelper.closeWindow(txtOrganization);
    }

    @FXML
    protected void onOkClick() {
        // update fields of the selected runner
//        Data.selectedRunner.name = txtName.getText();
//        Data.selectedRunner.address = txtAddress.getText();
//        Data.selectedRunner.postalCode = txtPostalCode.getText();
//        Data.selectedRunner.city = txtCity.getText();
//        Data.selectedRunner.country = txtCountry.getText();
//        Data.selectedRunner.email = txtEmail.getText();
//        Data.selectedRunner.phoneNumber = txtPhoneNumber.getText();
//        Data.selectedRunner.registrationFee = txtRegistrationFee.getText();

        Data.selectedSponsor.organization = txtOrganization.getText();
        Data.selectedSponsor.contactPerson = txtContactPerson.getText();
        Data.selectedSponsor.amount = txtAmount.getText();
        Data.selectedSponsor.phone = txtPhone.getText();
        Data.selectedSponsor.email = txtEmail.getText();
        Data.selectedSponsor.remarks = txtRemarks.getText();

        WindowHelper.closeWindow(txtOrganization);
    }
}
