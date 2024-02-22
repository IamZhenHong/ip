package duke;

import javafx.application.Application;
import javafx.scene.Scene;
import duke.Duke;
/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher {
    public static void main(String[] args) {

        Application.launch(Duke.class, args);

    }
}