package nl.saxion.re.sponsorrun.data;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import javafx.scene.control.Alert;
import nl.saxion.re.sponsorrun.util.WindowHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    // the data fields
    public static ArrayList<Sponsor> sponsors = new ArrayList<>();
    public static Sponsor selectedSponsor;

    public static ArrayList<Runner> runners = new ArrayList<>();
    public static Runner selectedRunner;

    public static ArrayList<Goal> goals = new ArrayList<>();
    public static Goal selectedGoal;

    public static void updateFromDisk() {
        // clear the list
        sponsors.clear();
        runners.clear();
        goals.clear();

        parseRunners();
        parseSponsors();
        parseGoals();
    }

    private static void parseRunners()
    {
        // read all rows and columns from the csv
        ArrayList<String[]> allRows = readData("runners.csv", ';', true);

        // create politician objects from all the rows/columns and add to the ArrayList.
        for (String[] row : allRows) {
            for(String s : row)
            {
                String[] arr = s.split(",");
                Runner runner = new Runner();
                runner.name = arr[0];
                runner.address = arr[1];
                runner.postalCode = arr[2];
                runner.city = arr[3];
                runner.country = arr[4];
                runner.email = arr[5];
                runner.phoneNumber = arr[6];
                runner.registrationFee = arr[7];

                runners.add(runner);
            }
        }
    }

    private static void parseSponsors()
    {
        ArrayList<String[]> allRows = readData("sponsors.csv", ';', true);

        // create politician objects from all the rows/columns and add to the ArrayList.
        for (String[] row : allRows) {
            for(String s : row)
            {
                String[] arr = s.split(",");

                Sponsor sponsor = new Sponsor();

                sponsor.organization = arr[0].isEmpty() ? "NULL" : arr[0];
                sponsor.contactPerson = arr[1];
                sponsor.amount = arr[2];
                sponsor.phone = arr[3];
                sponsor.email = arr[4];
                sponsor.remarks = arr[5];

                sponsors.add(sponsor);
            }
        }
    }

    public static void parseGoals()
    {
        ArrayList<String> allRows = new ArrayList<>();

        final File file = new File("goals.csv");
        try {
            Scanner scanner = new Scanner(file);

            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                allRows.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //ArrayList<String[]> allRows = readData("goals.csv", ';', true);

        // create politician objects from all the rows/columns and add to the ArrayList.
        for (String s : allRows) {
            String[] arr = s.split(",");

            for(int i = 0; i < arr.length; i++)
            {
                arr[i] = arr[i].substring(1, arr[i].length() - 1);
//                System.out.println(String.format("%d: %s", i, arr[i]));
            }

            Goal goal = new Goal();;

            goal.organization = arr[0];
            goal.contactName = arr[1];
            goal.contactEmail = arr[2];
            goal.contactPhone = arr[3];
            goal.motivation = arr[4];

            goals.add(goal);
        }
    }


    private static ArrayList<String[]> readData(String csvFile, char separator, boolean skipRow) {
        try {
            // what a horrible syntax for configuring the csvparser. But ok.
            CSVReaderBuilder readerBuilder = new CSVReaderBuilder(new FileReader(csvFile));
            if (skipRow) {
                readerBuilder.withSkipLines(1);
            }
            CSVParserBuilder parserBuilder = new CSVParserBuilder();
            parserBuilder.withSeparator(separator);
            readerBuilder.withCSVParser(parserBuilder.build());
            CSVReader reader = readerBuilder.build();

            ArrayList<String[]> allLines = new ArrayList<>(reader.readAll());
            return allLines;
        } catch (IOException e) {
            WindowHelper.showAlert("An error occurred reading " + csvFile + "\n\n" + e, Alert.AlertType.ERROR);
        }
        return new ArrayList<>();
    }

}
