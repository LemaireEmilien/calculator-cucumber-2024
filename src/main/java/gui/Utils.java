package gui;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class Utils {
    private Utils() {
    }

    public static Path getConfigPath() {
        String os = System.getProperty("os.name");
        log.trace("OS is {}", os);
        String home = System.getProperty("user.home");
        Path path;
        if (os.equals("Linux")) {
            path = Paths.get(home, ".config/calc_cuc");
        } else if (os.contains("Windows")) {
            path = Paths.get(home, "Appdata\\Roaming\\calc_cuc");
        } else {
            path = Paths.get("./calc_cuc");
        }

        File dir = new File(path.toAbsolutePath().toString());
        if (!dir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            dir.mkdir();
        }
        return path;
    }

    private static File forceCreate(File f) {
        if (!f.exists()) {
            try {
                if (!f.createNewFile()){
                    log.error("Could not create file ");
                }
            } catch (IOException e) {
                log.error("Could not create file {}", e.getMessage());
            }
        }
        return f;
    }

    public static File getHistoryFile() {
        Path configPath = getConfigPath();
        Path path = configPath.resolve("recentHistory.txt");
        return forceCreate(new File(path.toAbsolutePath().toString()));
    }

    public static File getFavoriteFile() {
        Path configPath = getConfigPath();
        Path path = configPath.resolve("favoriteExpressions.txt");
        return forceCreate(new File(path.toAbsolutePath().toString()));
    }
}
