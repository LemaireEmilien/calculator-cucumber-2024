package gui.memory;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * class use to save the recent history list when closing the app
 */
public class ListSaver {
    private ListSaver() {
    }

    @Getter
    @Setter
    protected static List<String> listToSave;

}
