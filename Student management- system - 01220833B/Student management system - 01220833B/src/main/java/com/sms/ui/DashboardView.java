package com.sms.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DashboardView {
    private GridPane view;

    public DashboardView() {

        view = new GridPane();
        view.setPadding(new Insets(40));
        view.setHgap(40);
        view.setVgap(40);

        Label total = createCard("Total Students", "0");
        Label active = createCard("Active Students", "0");
        Label inactive = createCard("Inactive Students", "0");
        Label avgGpa = createCard("Average GPA", "0.00");

        view.add(total, 0, 0);
        view.add(active, 1, 0);
        view.add(inactive, 0, 1);
        view.add(avgGpa, 1, 1);
    }

    private Label createCard(String title, String value) {
        Label label = new Label(title + "\n\n" + value);
        label.setStyle("-fx-border-color: #2c3e50; -fx-padding: 20; -fx-font-size: 16;");
        label.setPrefSize(250, 150);
        return label;
    }

    public Parent getView() {
        return view;
    }

}
