package com.sms.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SettingsView {
    private VBox view;

    public SettingsView() {

        view = new VBox(20);
        view.setPadding(new Insets(40));

        Label label = new Label("At-Risk GPA Threshold:");
        TextField thresholdField = new TextField("2.0");
        Button saveBtn = new Button("Save");

        view.getChildren().addAll(label, thresholdField, saveBtn);
    }

    public Parent getView() {
        return view;
    }

}
