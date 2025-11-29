package tpJavaFXSuite.exercice1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 *
 * Exemple JavaFX et FXML
 *
 *
 * Avec un JDK version 11 ou +,
 * la JVM doit être lancée sous Windows avec les options suivantes,
 * en adaptant le chemin vers les librairies JavaFX,
 *
 * sur Windows :
 *   --module-path "C:\Program Files\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml
 *
 * sur Mac et linux :
 *   --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml
 *
 */

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Counter counter = new Counter();

		FXMLLoader mainWindowLoader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));
		mainWindowLoader.setController(new MainWindow(counter));

		Scene scene = new Scene(mainWindowLoader.load());

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
