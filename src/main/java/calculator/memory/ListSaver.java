package calculator.memory;

import java.util.List;

public class ListSaver {
    public static List<String> listToSave;
    public static List<String> listFavoriteToSave;

    public static void saveListToFile(List<String> list) {
        listToSave = list;
    }

    public static void saveListFavoriteToFile(List<String> list) {
        listFavoriteToSave = list;
    }
}
