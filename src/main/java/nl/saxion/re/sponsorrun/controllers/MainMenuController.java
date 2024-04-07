package nl.saxion.re.sponsorrun.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nl.saxion.re.sponsorrun.util.WindowHelper;

public class MainMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onRunnersButtonClick() {
        WindowHelper.openWindow("overview-screen.fxml", "Overview of Runners", 1200, 600);
    }

    @FXML
    protected void onSponsorsButtonClick() {
        WindowHelper.openWindow("sponsor-overview-screen.fxml", "Overview of Sponsors", 1200, 600);
    }

    @FXML
    protected void onGoalsButtonClick() {
        WindowHelper.openWindow("goals-overview-screen.fxml", "Overview of Goals", 1200, 600);
    }
}