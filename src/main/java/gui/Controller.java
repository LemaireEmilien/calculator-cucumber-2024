package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.IllegalExpression;
import calculator.operand.MyBigNumber;
import calculator.parser.Parser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

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
    @FXML
    private Slider precisionSlider;
    @FXML
    private Label currentExpression;
    @FXML
    private Label history;

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
    private Button optionDegRad;

    @FXML
    private GridPane mainPane;

    private Stage stage;


    @FXML
    private void initialize() throws IOException {
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
        optionDegRad.setOnAction(event -> convertDegToRad());
        expressionHistory.setOnAction(event -> moveToHistory());
        //precisionSlider.setOnDragDone(event -> MyBigNumber.setPrecision((int) precisionSlider.getValue()));
        precisionSlider.setOnMouseReleased(event -> MyBigNumber.setPrecision((int) precisionSlider.getValue()));
    }

    private void convertDegToRad() {
        if (optionDegRad.getText().equals("Deg")) {
            optionDegRad.setText("Rad");
            MyBigNumber rad = new MyBigNumber(new BigDecimal(currentExpression.getText()));
            MyBigNumber deg = new MyBigNumber(new BigDecimal(rad.radToDeg().toString()));
            currentExpression.setText(deg.toString());
        }
        else {
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
            case RATIONAL -> {
            } //todo
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
            history.setText(history.getText() + "\n" + r);
            currentExpression.setText(r);
        }
    }

    private void moveToHistory() {
        stage.show();
    }

}
