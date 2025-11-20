package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstTask extends Application {

    private boolean leftToRight = true;

    @Override
    public void start(Stage stage) throws Exception {

        TextField textField1 = new TextField();
        Button button1 = new Button("->");
        TextField textField2 = new TextField();
        textField2.setEditable(false);

        button1.setOnAction(actionEvent -> {
            if (leftToRight) {
                textField2.setText(textField1.getText());
                textField1.clear();
                textField1.setEditable(false);
                textField2.setEditable(true);
                button1.setText("<-");
                leftToRight = false;
            }
            else {
                textField1.setText(textField2.getText());
                textField2.clear();
                textField2.setEditable(false);
                textField1.setEditable(true);
                button1.setText("->");
                leftToRight = true;
            }
        });

        HBox pane = new HBox();
        pane.getChildren().addAll(textField1, button1, textField2);
        pane.setSpacing(10);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 400, 70);
        stage.setScene(scene);
        stage.setTitle("First Task");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
