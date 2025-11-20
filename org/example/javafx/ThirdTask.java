package org.example.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ThirdTask extends Application {

    public static class Dish {
        private String name;
        private double price;
        private Integer quantity;
        private  CheckBox checkBox;
        private Label quanityLabel;
        private Button plusButton;
        private Button minusButton;

        public Dish(String name, double price) {
            this.name = name;
            this.price = price;
            this.quantity = 0;

            checkBox = new CheckBox(name + " <" + price + " Rub>");
            quanityLabel = new Label("1");
            quanityLabel.setDisable(true);

            plusButton = new Button("+");
            minusButton = new Button("-");
            plusButton.setDisable(true);
            minusButton.setDisable(true);

            checkBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal) {
                    quantity = 1;
                    quanityLabel.setText("1");
                    quanityLabel.setDisable(false);
                    plusButton.setDisable(false);
                    minusButton.setDisable(false);
                }
                else {
                    quantity = 0;
                    quanityLabel.setDisable(true);
                    plusButton.setDisable(true);
                    minusButton.setDisable(true);
                }
            });

            minusButton.setOnAction(e -> {
                if (checkBox.isSelected() && quantity > 1) {
                    quantity--;
                    quanityLabel.setText(String.valueOf(quantity));
                    if (quantity == 1) {
                        minusButton.setDisable(true);
                    }
                }
            });

            plusButton.setOnAction(e -> {
                if (checkBox.isSelected()) {
                    quantity++;
                    quanityLabel.setText(String.valueOf(quantity));
                    minusButton.setDisable(false);
                }
            });
        }

        public double getCheck() {
            return price * quantity;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<Dish> dishes = FXCollections.observableArrayList(
                new Dish("Суп", 100),
                new Dish("Стейк", 200),
                new Dish("Паста", 300),
                new Dish("Салат", 400),
                new Dish("Мясная тарелка", 500)
        );

        Button checkButton = new Button("Сформировать чек");
        TextArea checkArea = new TextArea();
        checkArea.setEditable(false);
        checkButton.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            double sum = 0;
            sb.append("ЧЕК:\n");
            for (Dish dish : dishes) {
                if (dish.quantity > 0) {
                    sb.append(String.format("%s - %d шт. - %.2f Rub\n", dish.name, dish.quantity, dish.getCheck()));
                    sum += dish.getCheck();
                }
            }
            sb.append("Итого: ").append(sum).append(" Rub");

            checkArea.setText(sb.toString());
        });

        VBox pane = new VBox();
        for (Dish d : dishes) {
            HBox row = new HBox(10);
            row.getChildren().addAll(d.checkBox, d.minusButton, d.quanityLabel, d.plusButton);
            pane.getChildren().add(row);
        }

        VBox finalPane = new VBox(pane, checkButton, checkArea);
        finalPane.setPadding(new Insets(10));
        Scene scene = new Scene(finalPane, 480, 320);
        stage.setScene(scene);
        stage.setTitle("Third Task");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}