package gui;

import calculator.memory.ExpressionFileHandler;
import calculator.memory.ListSaver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class GuiApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/calculator-design.fxml")));

        Scene scene = new Scene(root, 400, 800);
        stage.setTitle("Calculator App");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {
            try {
                ExpressionFileHandler.saveExpressionsAuto(ListSaver.listToSave, "recentHistory.txt");
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
