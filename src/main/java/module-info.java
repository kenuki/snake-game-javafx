module dev.kenuki.snakegamejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.kenuki.snakegamejavafx to javafx.fxml;
    exports dev.kenuki.snakegamejavafx;
    exports dev.kenuki.snakegamejavafx.util;
    opens dev.kenuki.snakegamejavafx.util to javafx.fxml;
}