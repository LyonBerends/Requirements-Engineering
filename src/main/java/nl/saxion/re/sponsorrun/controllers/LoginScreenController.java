package nl.saxion.re.sponsorrun.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nl.saxion.re.sponsorrun.util.WindowHelper;

public class LoginScreenController {

    @FXML
    private Label txtLabel;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    public void onSubmit()
    {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if(username.equals("root") && password.equals("toor"))
        {
            // start the main menu window
            WindowHelper.openWindow("main-menu.fxml", "Sponsor Run App", 320, 240);
        }
        else
        {
            txtLabel.setText("Wrong username or password");
        }
    }
}
