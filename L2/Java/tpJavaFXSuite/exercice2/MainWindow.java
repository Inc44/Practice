package tpJavaFXSuite.exercice2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainWindow {
	private Converter converter;
	@FXML private TextField euroField;
	@FXML private TextField yenField;
	MainWindow(Converter converter) {
		this.converter = converter;
	}
	@FXML
	public void initialize() {
		euroField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (euroField.isFocused()) {
					try {
						double euro = Double.parseDouble(newValue);
						yenField.setText(String.valueOf(converter.euroToYen(euro)));
					} catch (NumberFormatException exception) { // Infinity is possible
						yenField.setText("");
					}
				}
			}
		});
		yenField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (yenField.isFocused()) {
					try {
						double yen = Double.parseDouble(newValue);
						euroField.setText(String.valueOf(converter.yenToEuro(yen)));
					} catch (NumberFormatException exception) { // Infinity is possible
						euroField.setText("");
					}
				}
			}
		});
	}
}