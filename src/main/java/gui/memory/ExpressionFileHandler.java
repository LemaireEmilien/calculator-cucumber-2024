package gui.memory;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class use to save and load files
 */

@Slf4j
public class ExpressionFileHandler {
    private ExpressionFileHandler() {
    }

    /**
     * Method to save expression in a choosed file
     * @param expressions list of expressions we want to save
     * @param stage stage where we use the file chooser
     */
    public static void saveExpressions(List<String> expressions, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Expressions File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        if (file == null) {
            log.warn("Nor file selected");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String expression : expressions) {
                writer.write(expression);
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }
    }

    /**
     * Method to save automatically the list in a file defined
     * @param expressions list of expressions to save
     * @param file file where we save the list
     */
    public static void saveExpressionsAuto(List<String> expressions, File file) throws URISyntaxException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String expression : expressions) {
                writer.write(expression);
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }
    }

    /**
     * Method to load directly the expressions in recent history and favorite expressions
     * @param file file which contains the expressions we want to load
     * @return the list of expression to load in history component
     */
    public static List<String> loadExpressionsAuto(File file) {
        return getStrings(file);
    }

    /**
     * Method use to load a file which contain a list of expression
     * @return the list of expression to load in history component
     */
    public static List<String> loadExpressions(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File selectedFile = fileChooser.showOpenDialog(stage);

        return getStrings(selectedFile);
    }

    /**
     * Method use to read the file
     * @param file file to read
     * @return the list of expressions read
     */
    private static List<String> getStrings(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Count lines to initialize the array
            List<String> expressions = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                expressions.add(line);
            }
            return expressions;
        } catch (IOException e) {
            log.error("{}", e.getMessage());
            return Collections.emptyList();
        }
    }

}
