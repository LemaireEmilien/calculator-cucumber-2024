package calculator.memory;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ExpressionFileHandler {
    private ExpressionFileHandler(){}

    public static void saveExpressions(List<String> expressions, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Expressions File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String expression : expressions) {
                writer.write(expression);
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("{}",e.getMessage());
        }
    }

    public static void saveExpressionsAuto(List<String> expressions,String nameFile) throws URISyntaxException {

        File file = new File(Objects.requireNonNull(getSourcePath(nameFile)));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String expression : expressions) {
                writer.write(expression);
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("{}",e.getMessage());
        }
    }

    public static List<String> loadExpressionsAuto(String nameFile){
        File file = new File(Objects.requireNonNull(getSourcePath(nameFile)));
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
            log.error("{}",e.getMessage());
            return Collections.emptyList();
        }
    }

    public static String getSourcePath(String namefile) {
        String projectRoot;
        try {
            projectRoot = new File(".").getCanonicalPath();
        } catch (IOException e) {
            log.error("{}",e.getMessage());
            return null;
        }
        return Paths.get(projectRoot, "src/main/java/calculator/memory/files/",namefile).toString();
    }

}
