package gui.memory;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ExpressionFileHandler {
    private ExpressionFileHandler() {
    }

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

    public static List<String> loadExpressionsAuto(File file) {
        return getStrings(file);
    }

    public static List<String> loadExpressions(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File selectedFile = fileChooser.showOpenDialog(stage);

        return getStrings(selectedFile);
    }

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
