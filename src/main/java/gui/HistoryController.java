package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
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
    private void initialize() {
        wholeHistory.setDisable(true);

        wholeHistory.setOnAction(event -> {
            wholeHistory.setDisable(true);
            expressionUsable.setDisable(false);
        });

        expressionUsable.setOnAction(event -> {
            wholeHistory.setDisable(false);
            expressionUsable.setDisable(true);
        });
    }

}
