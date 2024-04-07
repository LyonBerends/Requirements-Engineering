package nl.saxion.re.sponsorrun.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import nl.saxion.re.sponsorrun.data.Data;
import nl.saxion.re.sponsorrun.util.WindowHelper;

public class GoalsDetailScreenController {

    @FXML
    private TextField txtOrganization;
    @FXML
    private TextField txtContactPerson;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtMotivation;

    @FXML
    protected void initialize() {
        txtOrganization.setText(Data.selectedGoal.organization);
        txtContactPerson.setText(Data.selectedGoal.contactName);
        txtPhone.setText(Data.selectedGoal.contactPhone);
        txtEmail.setText(Data.selectedGoal.contactEmail);
        txtMotivation.setText(Data.selectedGoal.motivation);
    }
    @FXML
    protected void onCancelClick() {
        WindowHelper.closeWindow(txtOrganization);
    }

    @FXML
    protected void onOkClick() {
        Data.selectedGoal.organization = txtOrganization.getText();
        Data.selectedGoal.contactEmail = txtEmail.getText();
        Data.selectedGoal.contactName = txtContactPerson.getText();
        Data.selectedGoal.contactPhone = txtPhone.getText();
        Data.selectedGoal.motivation = txtMotivation.getText();

        WindowHelper.closeWindow(txtOrganization);
    }
}
