package com.sms.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ImportExportView {
    private VBox view;

    public ImportExportView() {

        view = new VBox(20);
        view.setPadding(new Insets(40));

        Button importBtn = new Button("Import CSV");
        Button exportAllBtn = new Button("Export All Students");
        Button exportTopBtn = new Button("Export Top Performers");

        Label resultLabel = new Label("Import results will appear here.");

        view.getChildren().addAll(
                importBtn,
                exportAllBtn,
                exportTopBtn,
                resultLabel
        );
    }

    public Parent getView() {
        return view;
    }

}
