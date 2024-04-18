package gui;

import calculator.memory.ExpressionFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Slf4j
public class HistoryController {

    @FXML
    private Pane pane;

    @FXML
    private Button wholeHistory;

    @FXML
    private Button expressionUsable;

    @Getter
    @FXML
    private ListView<String> listHistory;

    @FXML
    private Button loadFile;

    @FXML
    private Button saveFile;

    private List<String> listFavoriteExpressions;

    private Stage stage;

    @FXML
    private void initialize() throws URISyntaxException {
        listFavoriteExpressions = new ArrayList<>();

        listFavoriteExpressions = ExpressionFileHandler.loadExpressionsAuto("/favoriteExpressions.txt");
        ObservableList<String> observableList = FXCollections.observableArrayList(Objects.requireNonNull(listFavoriteExpressions));
        listHistory.setItems(observableList);

        wholeHistory.setDisable(true);

        wholeHistory.setOnAction(event -> {
            wholeHistory.setDisable(true);
            expressionUsable.setDisable(false);
        });

        expressionUsable.setOnAction(event -> {
            wholeHistory.setDisable(false);
            expressionUsable.setDisable(true);
        });


        loadFile.setOnAction(event -> {
            List<String> loadExpressions = ExpressionFileHandler.loadExpressions(getStage());
            listHistory.setItems(FXCollections.observableArrayList(Objects.requireNonNull(loadExpressions)));

        });

        saveFile.setOnAction(event -> {
            List<String> saveExpressions = FXCollections.observableArrayList(listHistory.getItems());
            ExpressionFileHandler.saveExpressions(saveExpressions,getStage());
        });
    }

    public Stage getStage() {
        if (stage == null) {
        stage = (Stage) pane.getScene().getWindow();
        }
        return stage;
    }

}
