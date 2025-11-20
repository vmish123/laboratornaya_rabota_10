package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FifthTask extends Application {

    @Override
    public void start(Stage stage) {
        ToggleGroup stripe1 = new ToggleGroup();
        RadioButton r1 = new RadioButton("Красный"); r1.setToggleGroup(stripe1);
        RadioButton g1 = new RadioButton("Зелёный"); g1.setToggleGroup(stripe1);
        RadioButton b1 = new RadioButton("Синий");   b1.setToggleGroup(stripe1);
        VBox pane1 = new VBox(5, new Label("Полоса 1:"), r1, g1, b1);

        ToggleGroup stripe2 = new ToggleGroup();
        RadioButton r2 = new RadioButton("Красный"); r2.setToggleGroup(stripe2);
        RadioButton g2 = new RadioButton("Зелёный"); g2.setToggleGroup(stripe2);
        RadioButton b2 = new RadioButton("Синий");   b2.setToggleGroup(stripe2);
        VBox pane2 = new VBox(5, new Label("Полоса 2:"), r2, g2, b2);

        ToggleGroup stripe3 = new ToggleGroup();
        RadioButton r3 = new RadioButton("Красный"); r3.setToggleGroup(stripe3);
        RadioButton g3 = new RadioButton("Зелёный"); g3.setToggleGroup(stripe3);
        RadioButton b3 = new RadioButton("Синий");   b3.setToggleGroup(stripe3);
        VBox pane3 = new VBox(5, new Label("Полоса 3:"), r3, g3, b3);

        Button btn = new Button("Нарисовать");
        Label resultLabel = new Label();

        btn.setOnAction(e -> {
            RadioButton s1 = (RadioButton) stripe1.getSelectedToggle();
            RadioButton s2 = (RadioButton) stripe2.getSelectedToggle();
            RadioButton s3 = (RadioButton) stripe3.getSelectedToggle();

            if (s1 == null || s2 == null || s3 == null) {
                resultLabel.setText("Выберите цвет для всех трёх полос");
                return;
            }

            resultLabel.setText(
                    s1.getText() + ", " +
                            s2.getText() + ", " +
                            s3.getText()
            );
        });

        HBox stripes = new HBox(40, pane1, pane2, pane3);
        stripes.setPadding(new Insets(20));
        stripes.setAlignment(Pos.TOP_CENTER);

        VBox pane = new VBox(20, stripes, btn, resultLabel);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20));

        Scene scene = new Scene(pane, 450, 300);
        stage.setScene(scene);
        stage.setTitle("Fifth Task");
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}