package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondTask extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label("Hello World");
        label.setStyle("-fx-font-size: 14px; -fx-text-fill: red;");
        CheckBox checkBox1 = new CheckBox();
        checkBox1.setSelected(true);

        DatePicker datePicker = new DatePicker();
        CheckBox checkBox2 = new CheckBox();
        checkBox2.setSelected(true);

        TextField textField = new TextField();
        CheckBox checkBox3 = new CheckBox();
        checkBox3.setSelected(true);

        checkBox1.setOnAction(event -> {
            label.visibleProperty().set(checkBox1.isSelected());
        });
        checkBox2.setOnAction(event -> {
            datePicker.visibleProperty().set(checkBox2.isSelected());
        });
        checkBox3.setOnAction(event -> {
            textField.visibleProperty().set(checkBox3.isSelected());
        });

        HBox hbox1 = new HBox(label, checkBox1);
        hbox1.setSpacing(5);
        HBox hbox2 = new HBox(datePicker, checkBox2);
        hbox2.setSpacing(5);
        HBox hbox3 = new HBox(textField, checkBox3);
        hbox3.setSpacing(5);

        VBox pane = new VBox(hbox1, hbox2, hbox3);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setSpacing(10);
        pane.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(pane, 250, 120);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
