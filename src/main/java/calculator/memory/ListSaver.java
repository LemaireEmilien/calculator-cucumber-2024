package calculator.memory;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ListSaver {
    public static List<String> listToSave;

    public static void saveListToFile(List<String> list) {
        listToSave = list;
    }
}
