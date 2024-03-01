module dev.kenuki.snakegamejavafx {
	requires javafx.controls;
	requires javafx.fxml;
	requires kotlin.stdlib;

	opens dev.kenuki.snakegamejavafx to javafx.fxml;
	exports dev.kenuki.snakegamejavafx;
}
