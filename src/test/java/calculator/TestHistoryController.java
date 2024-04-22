package calculator;
import gui.Controller;
import gui.HistoryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class TestHistoryController extends ApplicationTest {
    private HistoryController historyController;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/calculator-design.fxml"));
        FXMLLoader historyLoader = new FXMLLoader(getClass().getResource("/history.fxml"));
        mainLoader.load();
        Parent historyPage = historyLoader.load();
        Controller controller = mainLoader.getController();
        historyController = historyLoader.getController();
        controller.setHistoryController(historyController);
        historyController.setController(controller);
        stage.setScene(new Scene(historyPage));
        stage.show();
    }


    @Test
    public void testLoadFiles() {
        historyController.loadFiles();
        assertTrue(historyController.getListRecentHistory().size() > 1);
        assertNotNull(historyController.getListFavoriteExpressions());
    }

    @Test
    public void clear(){
        historyController.getListRecentHistory().add("s");
        clickOn("#clearButton");
        assertEquals(0, historyController.getListRecentHistory().size());
    }

    @Test
    public void incrementNumber(){
        int numberToCompare = historyController.getNumber();
        clickOn("#expressionUsable");
        clickOn("#increaseButton");
        assertEquals(numberToCompare+1, historyController.getNumber());

    }
    @Test
    public void decrementNumber(){
        int numberToCompare = historyController.getNumber();
        clickOn("#expressionUsable");
        clickOn("#decreaseButton");
        assertEquals(numberToCompare-1, historyController.getNumber());

    }

    @Test
    public void historyLoad(){
        historyController.loadFiles();
        clickOn("#wholeHistory");
        assertEquals(historyController.getListRecentHistory(), historyController.getListHistory().getItems());
    }

    @Test
    public void favoriteLoad(){
        historyController.loadFiles();
        clickOn("#expressionUsable");
        assertEquals(historyController.getListFavoriteExpressions(), historyController.getListHistory().getItems());
    }
}

