package tp1JavaFX.exercice2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Converter converter = new Converter();
		FXMLLoader mainWindowLoader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));
		mainWindowLoader.setController(new MainWindow(converter));
		Scene scene = new Scene(mainWindowLoader.load());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}