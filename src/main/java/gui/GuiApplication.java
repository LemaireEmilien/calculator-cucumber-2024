package gui;

import gui.memory.ExpressionFileHandler;
import gui.memory.ListSaver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class GuiApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/calculator-design.fxml"));
        FXMLLoader historyLoader = new FXMLLoader(getClass().getResource("/history.fxml"));
        Parent root = mainLoader.load();
        Parent historyPage = historyLoader.load();
        Controller controller = mainLoader.getController();
        HistoryController historyController = historyLoader.getController();

        controller.setHistoryController(historyController);
        historyController.setController(controller);

        Scene scene = new Scene(root, 400, 1000);
        stage.setTitle("Calculator App");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {
            try {
                ExpressionFileHandler.saveExpressionsAuto(ListSaver.getListToSave(), Utils.getHistoryFile());
            } catch (URISyntaxException e) {
                log.error("{}", e.getMessage());
            }
        });

        Stage stageHistory = new Stage();
        stageHistory.setTitle("History");
        stageHistory.setScene(new Scene(historyPage, 600, 400));

        controller.setStage(stageHistory);
    }
}
