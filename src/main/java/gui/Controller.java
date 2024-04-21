package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.IllegalExpression;
import calculator.memory.ExpressionFileHandler;
import calculator.operand.MyBigNumber;
import calculator.parser.Parser;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.math.BigDecimal;

@Slf4j
public class Controller {
    private enum CalculatorType {
        INTEGER, RATIONAL, REAL
    }

    @FXML
    private Button expressionHistory;
    @FXML
    private ChoiceBox<CalculatorType> typeBox;
    @Getter
    @Setter
    @FXML
    private Slider precisionSlider;
    @FXML
    private Label currentExpression;
    @FXML
    private ListView<String> history;
    @FXML
    private Button operatorEquals;
    @FXML
    private Button operatorPlus;
    @FXML
    private Button operatorMinus;
    @FXML
    private Button operatorTimes;
    @FXML
    private Button operatorDivide;
    @FXML
    private Button digitZero;

    @FXML
    private Button optionUndo;
    @FXML
    private Button optionAnswer;
    @FXML
    private Button undo;
    @FXML
    private Button redo;
    @FXML
    private Button optionDegRad;

    @FXML
    private GridPane mainPane;
    @Setter
    private Stage stage;
    @Setter
    private HistoryController historyController;

    @FXML
    private void initialize()throws IOException {
        typeBox.getItems().setAll(CalculatorType.values());
        typeBox.setValue(CalculatorType.INTEGER);
        precisionSlider.setValue(MyBigNumber.getPrecision());
        for (int i = 0; i < 9; i++) {
            final String s = String.valueOf(i + 1);
            Button b = new Button(s);
            b.setStyle("-fx-font: 32 system;");
            b.getStyleClass().add("button-number");
            b.setOnAction(actionEvent -> addCharacter(s));
            mainPane.add(b, i % 3, i / 3 + 1);
        }

        digitZero.setOnAction(event -> addCharacter("0"));
        operatorPlus.setOnAction(event -> addCharacter("+"));
        operatorMinus.setOnAction(event -> addCharacter("-"));
        operatorTimes.setOnAction(event -> addCharacter("*"));
        operatorDivide.setOnAction(event -> addCharacter("/"));
        optionUndo.setOnAction(event -> removeCharacter());
        operatorEquals.setOnAction(event -> evaluate());
        optionAnswer.setOnAction(event -> addCharacter("ans"));
        expressionHistory.setOnAction(event -> moveToHistory());
        optionDegRad.setOnAction(event -> convertDegToRad());
        expressionHistory.setOnAction(event -> moveToHistory());
        precisionSlider.setOnMouseReleased(event -> MyBigNumber.setPrecision((int) precisionSlider.getValue()));

        List<String> listRecentHistory = ExpressionFileHandler.loadExpressionsAuto("recentHistory.txt");
        List<String> redoElements = new ArrayList<>();
        history.setItems(FXCollections.observableArrayList(listRecentHistory));
        history.scrollTo(history.getItems().size()-1);

        undo.setOnAction(event -> {
            if(!history.getItems().isEmpty()){
                if(redo.isDisable()){
                    redo.setDisable(false);
                }
                String expression = history.getItems().get(history.getItems().size()-2);
                String result = history.getItems().getLast();
                redoElements.add(expression);
                redoElements.add(result);
                historyController.getListRecentHistory().removeLast();
                historyController.getListRecentHistory().removeLast();
                historyController.update();
                currentExpression.setText(expression);
                listRecentHistory.remove(result);
                listRecentHistory.remove(expression);
                history.setItems(FXCollections.observableArrayList(listRecentHistory));
            }
            else if(!currentExpression.getText().isEmpty()){
                currentExpression.setText("");
                undo.setDisable(true);
            }

        });

        redo.setOnAction(event -> {
            if(listRecentHistory.isEmpty() && currentExpression.getText().isEmpty()){
                currentExpression.setText(redoElements.get(redoElements.size()-2));
            }
            else {
                if(undo.isDisable()){
                    undo.setDisable(false);
                }
                String expression = redoElements.get(redoElements.size()-2);
                String result = redoElements.getLast();
                listRecentHistory.add(expression);
                listRecentHistory.add(result);
                historyController.getListRecentHistory().add(expression);
                historyController.getListRecentHistory().add(result);
                historyController.update();
                redoElements.remove(expression);
                redoElements.remove(result);
                history.setItems(FXCollections.observableArrayList(listRecentHistory));
                history.scrollTo(history.getItems().size() - 1);
                if(!redoElements.isEmpty()) {
                    currentExpression.setText(redoElements.get(redoElements.size() - 2));
                }
                else {
                    redo.setDisable(true);
                }
            }

        });

    }

    private void convertDegToRad() {
        if (optionDegRad.getText().equals("Deg")) {
            optionDegRad.setText("Rad");
            MyBigNumber rad = new MyBigNumber(new BigDecimal(currentExpression.getText()));
            MyBigNumber deg = new MyBigNumber(new BigDecimal(rad.radToDeg().toString()));
            currentExpression.setText(deg.toString());
        } else {
            optionDegRad.setText("Deg");
            MyBigNumber deg = new MyBigNumber(new BigDecimal(currentExpression.getText()));
            MyBigNumber rad = new MyBigNumber(new BigDecimal(deg.degToRad().toString()));
            currentExpression.setText(rad.toString());
        }
    }
    @FXML
    private void handleKeyboard(KeyEvent event) {
        log.trace("Key pressed: {}", event.getCode());
        if (event.getCode() == KeyCode.BACK_SPACE && !currentExpression.getText().isEmpty()) {
            removeCharacter();
        } else if (event.getCode() == KeyCode.ENTER) {
            evaluate();
        } else {
            addCharacter(event.getText());
        }
    }

    private void addCharacter(String character) {
        currentExpression.setTextFill(Color.WHITE);
        currentExpression.setText(currentExpression.getText() + character);
    }

    private void removeCharacter() {
        currentExpression.setTextFill(Color.WHITE);
        if (!currentExpression.getText().isEmpty()) {
            String temp = currentExpression.getText().substring(0, currentExpression.getText().length() - 1);
            currentExpression.setText(temp);
        }
    }

    private void evaluate() {
        switch (typeBox.getValue()) {
            case INTEGER -> evaluateT(Parser::stringToInteger);
            case RATIONAL -> evaluateT(Parser::stringToRational);
            case REAL -> evaluateT(Parser::stringToBigDecimal);
        }
    }

    private <T> void evaluateT(Parser.From<T> parser) {
        Parser<T> p = new Parser<>();
        Expression<T> e;
        try {
            e = p.parse(currentExpression.getText(), parser);
        } catch (IllegalExpression i) {
            log.warn("Supplied expression is not correct : {}", currentExpression.getText());
            currentExpression.setTextFill(Color.RED);
            return;
        }
        Calculator<T> c = new Calculator<>();
        if (!currentExpression.getText().isEmpty()) {
            String r =c.eval(e).getVal().toString();
            history.getItems().add(currentExpression.getText());
            history.getItems().add(c.eval(e).getVal().toString());
            historyController.getListRecentHistory().add(currentExpression.getText());
            historyController.getListRecentHistory().add(r);
            historyController.update();
            currentExpression.setText(r);
            history.scrollTo(history.getItems().size()-1);
        }
    }

    private void moveToHistory() {
        stage.show();
    }

    public void setLabelCurrent(String expression){
        currentExpression.setText(currentExpression.getText() + expression);
    }
}
