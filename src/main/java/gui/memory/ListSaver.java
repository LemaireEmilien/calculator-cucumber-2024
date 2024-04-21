package gui.memory;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListSaver {
    private ListSaver() {
    }

    @Getter
    @Setter
    protected static List<String> listToSave;

}
