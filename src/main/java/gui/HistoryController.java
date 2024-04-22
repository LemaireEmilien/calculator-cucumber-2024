package gui;

import gui.memory.ExpressionFileHandler;
import gui.memory.ListSaver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class use to manage the history component
 */
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

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button useButton;

    @FXML
    private Label limitFav;

    @FXML
    private Button increaseButton;

    @FXML
    private Button decreaseButton;

    private List<String> listFavoriteExpressions;
    @Getter
    private List<String> listRecentHistory;


    private Stage stage;

    @Setter
    private Controller controller;

    private int number;

    /**
     * Method initialize to load the different components inside the history stage
     */
    @FXML
    private void initialize() {
        loadFiles();
        wholeHistoryLoad();
        expressionUsableLoad();
        buttonLoadingFileLoad();
        saveFileLoad();
        useButtonLoad();
        addButtonLoad();
        removeButtonLoad();
        incrementButtons();
        clearButtonLoad();

    }


    /**
     * method to set up the increase and decrease button to manage the size of favorite expressions
     */
    private void incrementButtons() {
        increaseButton.setOnAction(event -> incrementNumber());
        decreaseButton.setOnAction(event -> decrementNumber());
    }

    /**
     * method to increment the number and update the label for the size of favorite expressions
     */
    private void incrementNumber() {
        number++;
        updateNumberLabel();
    }

    /**
     * method to decrement the number and update the label for the size of favorite expressions
     */
    private void decrementNumber() {
        if (listFavoriteExpressions.size() - 1 < number) {
            number--;
            updateNumberLabel();
        }
    }

    /**
     * method to update the label for the size of favorite expression
     */
    private void updateNumberLabel() {
        String change = Integer.toString(number);
        limitFav.setText("Size of favorite : " + number);

        listFavoriteExpressions.set(0, change);

        saveFavorite(listFavoriteExpressions);
    }

    /**
     * method used to load the list of recent history and favorite expressions
     */
    private void loadFiles() {
        listFavoriteExpressions = new ArrayList<>();
        listRecentHistory = new ArrayList<>();

        listFavoriteExpressions = ExpressionFileHandler.loadExpressionsAuto(Utils.getFavoriteFile());
        listRecentHistory = ExpressionFileHandler.loadExpressionsAuto(Utils.getHistoryFile());

        try {
            if (!listFavoriteExpressions.isEmpty()) {
                number = Integer.parseInt(listFavoriteExpressions.getFirst());
            }
            else {
                number = 15;
                listFavoriteExpressions.add(Integer.toString(number));
            }

        } catch (NumberFormatException e) {
            log.error("{}", e.getMessage());
        }

        limitFav.setText("Size of favorite :" + number);
        ListSaver.setListToSave(listRecentHistory);
        ObservableList<String> observableList = FXCollections.observableArrayList(Objects.requireNonNull(listRecentHistory));
        listHistory.setItems(observableList);
    }


    /**
     * method used to manage the action of history button
     */
    private void wholeHistoryLoad() {
        wholeHistory.setDisable(true);
        wholeHistory.setOnAction(event -> {
            showVisible(true, false);

            listHistory.setItems(FXCollections.observableArrayList(listRecentHistory));
            listHistory.scrollTo(listHistory.getItems().size() - 1);

        });
    }

    /**
     * method to show which button must be visible or disable
     * @param first true/false value
     * @param second true/false value
     */
    private void showVisible(boolean first, boolean second) {
        wholeHistory.setDisable(first);
        addButton.setVisible(first);
        expressionUsable.setDisable(second);
        increaseButton.setVisible(second);
        decreaseButton.setVisible(second);
        limitFav.setVisible(second);
    }

    /**
     * method used to manage the action of favorite expression button
     */
    private void expressionUsableLoad() {
        expressionUsable.setOnAction(event -> {
            showVisible(false, true);
            if(!listFavoriteExpressions.isEmpty()) {
                listHistory.setItems(FXCollections.observableArrayList(listFavoriteExpressions.subList(1, listFavoriteExpressions.size())));
            }
            else{
                listHistory.getItems().clear();
            }
        });
    }

    /**
     * this method is used to manage the action of loading a file when we click on the button
     */
    private void buttonLoadingFileLoad() {
        loadFile.setOnAction(event -> {
            List<String> loadExpressions = ExpressionFileHandler.loadExpressions(getStage());
            listRecentHistory.addAll(loadExpressions);
            listHistory.setItems(FXCollections.observableArrayList(Objects.requireNonNull(listRecentHistory)));
            ListSaver.setListToSave(listRecentHistory);
            controller.setHistory(listRecentHistory);
        });
    }

    /**
     * this method is used to manage the action of saving a file when we click on the button
     */
    private void saveFileLoad() {
        saveFile.setOnAction(event -> {
            List<String> saveExpressions = FXCollections.observableArrayList(listHistory.getItems());
            ExpressionFileHandler.saveExpressions(saveExpressions, getStage());
        });
    }

    /**
     * method to reuse an expression or a result in the calculator
     */
    private void useButtonLoad() {
        useButton.setOnAction(event -> controller.setLabelCurrent(listHistory.getSelectionModel().getSelectedItem()));
    }

    /**
     * method to add an expression or a result to the favorite expressions
     */
    private void addButtonLoad() {
        addButton.setOnAction(event -> {

            int index = listHistory.getSelectionModel().getSelectedIndex();
            if (index % 2 == 0) {
                listFavoriteExpressions.add(listHistory.getSelectionModel().getSelectedItem());
                listFavoriteExpressions.add(listHistory.getItems().get(index + 1));
            } else {
                listFavoriteExpressions.add(listHistory.getItems().get(index - 1));
                listFavoriteExpressions.add(listHistory.getSelectionModel().getSelectedItem());

            }
            showVisible(false, true);
            updateFavoriteExpressions(listFavoriteExpressions.subList(1, listFavoriteExpressions.size()));
            saveFavorite(listFavoriteExpressions);
        });
    }

    /**
     * method to delete an expression or a result in the history or favorite expressions list
     */
    private void removeButtonLoad() {
        removeButton.setOnAction(event -> {
            int index = listHistory.getSelectionModel().getSelectedIndex();
            if (wholeHistory.isDisable()) {
                removeExpression(listRecentHistory, index);
                updateFavoriteExpressions(listRecentHistory);
            } else {
                removeExpression(listFavoriteExpressions, index);
                updateFavoriteExpressions(listFavoriteExpressions.subList(1, listFavoriteExpressions.size()));
                saveFavorite(listFavoriteExpressions);
            }
        });
    }

    /**
     * update the list of favorite expressions when we add a favorite expression
     * @param list new list of favorite expressions
     */
    private void updateFavoriteExpressions(List<String> list) {
        listHistory.setItems(FXCollections.observableArrayList(list));
        listHistory.scrollTo(listHistory.getItems().size() - 1);

    }

    /**
     * save the list of favorite expressions
     * @param list current list of favorite expressions
     */
    private static void saveFavorite(List<String> list) {
        try {
            ExpressionFileHandler.saveExpressionsAuto(list, Utils.getFavoriteFile());
        } catch (URISyntaxException e) {
            log.error("{}", e.getMessage());
        }
    }

    /**
     * method use to remove the expression and the result when we delete an expression or a result
     * @param expressions list of expressions
     * @param index choosen expression or result
     */
    private void removeExpression(List<String> expressions, int index) {
        expressions.remove(listHistory.getSelectionModel().getSelectedItem());
        if (index % 2 == 0) {
            expressions.remove(listHistory.getItems().get(index + 1));
        } else {
            expressions.remove(listHistory.getItems().get(index - 1));
        }
    }

    /**
     * this method allows us to remove the whole history or the whole favorite expressions list
     */
    private void clearButtonLoad() {
        clearButton.setOnAction(event -> {
            if(wholeHistory.isDisable()){
                controller.clear();
                listRecentHistory.clear();
            }
            else {
                listFavoriteExpressions.clear();
                listFavoriteExpressions.add(Integer.toString(number));
                saveFavorite(listFavoriteExpressions);
            }
            listHistory.getItems().clear();
        });

    }

    /**
     * method to get the current stage
     * @return current stage
     */
    public Stage getStage() {
        if (stage == null) {
            stage = (Stage) pane.getScene().getWindow();
        }
        return stage;
    }

    /**
     * method to update the current list of recent history
     */
    public void update() {
        if (wholeHistory.isDisable()) {
            listHistory.setItems(FXCollections.observableArrayList(listRecentHistory));
            listHistory.scrollTo(listHistory.getItems().size() - 1);
        }
        ListSaver.setListToSave(listRecentHistory);
    }

}
