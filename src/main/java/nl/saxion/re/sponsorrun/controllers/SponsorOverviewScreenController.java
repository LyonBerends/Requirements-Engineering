package nl.saxion.re.sponsorrun.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import nl.saxion.re.sponsorrun.data.Data;
import nl.saxion.re.sponsorrun.data.Runner;
import nl.saxion.re.sponsorrun.data.Sponsor;
import nl.saxion.re.sponsorrun.util.TableViewHelper;
import nl.saxion.re.sponsorrun.util.WindowHelper;

public class SponsorOverviewScreenController {
    @FXML
    private TableView<String[]> table1;

    @FXML
    protected void initialize() {
        // prepare the columns of the table
        String[] columns = {"Organization", "ContactPerson", "Amount", "Phone", "Email", "Remarks"};
        TableViewHelper.prepareTable(table1, columns);

        // add all politicians to the tableview
        for (Sponsor s : Data.sponsors) {
            String[] rowValues = {s.organization, s.contactPerson, s.amount, s.phone, s.email, s.remarks};
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
            Sponsor selectedSponsor = Data.sponsors.get(selectedIndex);
            // set it in the data as public "selectedPolitician", so the edit screen knows which data to edit
            Data.selectedSponsor = selectedSponsor;
            // open the other screen.
            WindowHelper.openWindow("sponsor-detail-screen.fxml", Data.selectedSponsor.organization, 400, 300);
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
