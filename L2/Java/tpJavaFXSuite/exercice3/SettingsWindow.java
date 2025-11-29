package tpJavaFXSuite.exercice3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class SettingsWindow {
	private Converter converter;
	private Stage primaryStage;
	@FXML private TextField field1;
	@FXML private TextField field2;
	@FXML private TextField field3;
	SettingsWindow(Converter converter, Stage primaryStage) {
		this.converter = converter;
		this.primaryStage = primaryStage;
	}
	@FXML
	public void initialize() {
		field1.setText(converter.getCurrency1Name());
		field2.setText(converter.getCurrency2Name());
		field3.setText(String.valueOf(converter.getRate()));
	}
	@FXML
	private void save(ActionEvent event) throws IOException {
		converter.setCurrency1Name(field1.getText());
		converter.setCurrency2Name(field2.getText());
		try {
			converter.setRate(Double.parseDouble(field3.getText()));
		} catch (NumberFormatException exception) { // Infinity is possible
		}
		FXMLLoader mainWindowLoader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));
		mainWindowLoader.setController(new MainWindow(converter, primaryStage));
		Scene scene = new Scene(mainWindowLoader.load());
		primaryStage.setScene(scene);
	}
}