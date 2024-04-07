package nl.saxion.re.sponsorrun.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import nl.saxion.re.sponsorrun.data.Data;
import nl.saxion.re.sponsorrun.data.Goal;
import nl.saxion.re.sponsorrun.util.TableViewHelper;
import nl.saxion.re.sponsorrun.util.WindowHelper;

public class GoalOverviewScreenController {
    @FXML
    private TableView<String[]> table1;

    @FXML
    protected void initialize() {
        // prepare the columns of the table
        String[] columns = {"Organization", "ContactPerson", "Phone", "Email", "Motivation"};
        TableViewHelper.prepareTable(table1, columns);

        // add all politicians to the tableview
        for (Goal g : Data.goals) {
            String[] rowValues = {g.organization, g.contactName, g.contactPhone, g.contactEmail, g.motivation};
            table1.getItems().add(rowValues);
        }
    }

    @FXML
    protected void onButtonOkClick() {
        // find which item was selected
        int selectedIndex = table1.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            // no item was selected, show an "error" to the user
            WindowHelper.showAlert("You have to select one item");
        } else {
            // find the selected politician in the data
            Goal selectedGoal = Data.goals.get(selectedIndex);
            // set it in the data as public "selectedPolitician", so the edit screen knows which data to edit
            Data.selectedGoal = selectedGoal;
            // open the other screen.
            WindowHelper.openWindow("goals-detail-screen.fxml", Data.selectedGoal.organization, 400, 300);
            // close this window
            closeWindow();
        }
    }

    @FXML
    protected void onButtonCancelClick() {
        closeWindow();
    }

    private void closeWindow() {
        WindowHelper.closeWindow(table1);
    }
}
