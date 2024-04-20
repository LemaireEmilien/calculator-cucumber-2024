package calculator.memory;

import java.util.List;

public class ListSaver {
    public static List<String> listToSave;

    public static void saveListToFile(List<String> list) {
        listToSave = list;
    }


}
