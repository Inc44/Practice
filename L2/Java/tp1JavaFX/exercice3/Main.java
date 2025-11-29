package tp1JavaFX.exercice3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Converter converter = new Converter();
	private TextField field1;
	private Label label1;
	private TextField field2;
	private Label label2;
	private Stage primaryStage;
	private Scene scene;
	private TextField field1Settings;
	private TextField field2Settings;
	private TextField field3Settings;
	private Scene sceneSettings;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		field1 = new TextField();
		label1 = new Label(converter.getCurrency1Name());
		field2 = new TextField();
		label2 = new Label(converter.getCurrency2Name());
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(4);
		gridPane.setVgap(4);
		gridPane.add(field1, 0, 0);
		gridPane.add(label1, 1, 0);
		gridPane.add(field2, 0, 1);
		gridPane.add(label2, 1, 1);
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
		Button settingsBtn = new Button("Réglages");
		gridPane.add(settingsBtn, 0, 2);
		settingsBtn.setOnAction(ev -> {
			field1Settings.setText(converter.getCurrency1Name());
			field2Settings.setText(converter.getCurrency2Name());
			field3Settings.setText(String.valueOf(converter.getRate()));
			primaryStage.setScene(sceneSettings);
		});
		scene = new Scene(gridPane, 185, 96);
		this.primaryStage = primaryStage;
		primaryStage.setScene(scene);
		primaryStage.show();
		GridPane gridPaneSettings = new GridPane();
		Label label1Settings = new Label("Monnaie 1 :");
		field1Settings = new TextField();
		Label label2Settings = new Label("Monnaie 2 :");
		field2Settings = new TextField();
		Label label3Settings = new Label("Parité 1 à 2 :");
		field3Settings = new TextField();
		gridPaneSettings.setAlignment(Pos.CENTER);
		gridPaneSettings.setHgap(4);
		gridPaneSettings.setVgap(4);
		gridPaneSettings.add(label1Settings, 0, 0);
		gridPaneSettings.add(field1Settings, 1, 0);
		gridPaneSettings.add(label2Settings, 0, 1);
		gridPaneSettings.add(field2Settings, 1, 1);
		gridPaneSettings.add(label3Settings, 0, 2);
		gridPaneSettings.add(field3Settings, 1, 2);
		Button saveBtn = new Button("Sauvegarder");
		gridPaneSettings.add(saveBtn, 0, 3);
		saveBtn.setOnAction(ev -> save());
		sceneSettings = new Scene(gridPaneSettings, 250, 128);
	}
	private void save() {
		converter.setCurrency1Name(field1Settings.getText());
		converter.setCurrency2Name(field2Settings.getText());
		try {
			converter.setRate(Double.parseDouble(field3Settings.getText()));
		} catch (NumberFormatException exception) { // Infinity is possible
		}
		label1.setText(converter.getCurrency1Name());
		label2.setText(converter.getCurrency2Name());
		primaryStage.setScene(scene);
	}
}