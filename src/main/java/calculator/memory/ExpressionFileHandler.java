package calculator.memory;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpressionFileHandler {
    public static void saveExpressions(List<String> expressions, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Expressions File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String expression : expressions) {
                System.out.println("Expression: " + expression);
                writer.write(expression);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadExpressionsAuto(String nameFile) throws URISyntaxException {
        File file = new File(Paths.get(Objects.requireNonNull(ExpressionFileHandler.class.getResource(nameFile)).toURI()).toString());
        return getStrings(file);
    }

    private static List<String> getStrings(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Count lines to initialize the array
            List<String> expressions = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                expressions.add(line);
            }

            reader.close();

            return expressions;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> loadExpressions(Stage stage) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File selectedFile = fileChooser.showOpenDialog(stage);

        return getStrings(selectedFile);
    }
}
