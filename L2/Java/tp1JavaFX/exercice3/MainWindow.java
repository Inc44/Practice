package tp1JavaFX.exercice3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class MainWindow {
	private Converter converter;
	private Stage primaryStage;
	@FXML private Label label1;
	@FXML private Label label2;
	@FXML private TextField field1;
	@FXML private TextField field2;
	MainWindow(Converter converter, Stage primaryStage) {
		this.converter = converter;
		this.primaryStage = primaryStage;
	}
	@FXML
	public void initialize() {
		label1.setText(converter.getCurrency1Name());
		label2.setText(converter.getCurrency2Name());
		field1.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (field1.isFocused()) {
					try {
						double currency = Double.parseDouble(newValue);
						field2.setText(String.valueOf(converter.currency1To2(currency)));
					} catch (NumberFormatException exception) { // Infinity is possible
						field2.setText("");
					}
				}
			}
		});
		field2.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (field2.isFocused()) {
					try {
						double currency = Double.parseDouble(newValue);
						field1.setText(String.valueOf(converter.currency2To1(currency)));
					} catch (NumberFormatException exception) { // Infinity is possible
						field1.setText("");
					}
				}
			}
		});
	}
	@FXML
	private void settings(ActionEvent event) throws IOException {
		FXMLLoader settingsWindowLoader =
			new FXMLLoader(getClass().getResource("settingsWindow.fxml"));
		settingsWindowLoader.setController(new SettingsWindow(converter, primaryStage));
		Scene settingsScene = new Scene(settingsWindowLoader.load());
		primaryStage.setScene(settingsScene);
	}
}