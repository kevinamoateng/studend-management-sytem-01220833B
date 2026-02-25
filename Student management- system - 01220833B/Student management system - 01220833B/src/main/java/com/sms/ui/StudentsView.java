package com.sms.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class StudentsView {
    private BorderPane view;
    private TableView table;

    public StudentsView() {

        view = new BorderPane();
        view.setPadding(new Insets(20));

        table = new TableView();
        table.setPlaceholder(new Label("No students available"));

        TableColumn idCol = new TableColumn("Student ID");
        TableColumn nameCol = new TableColumn("Full Name");
        TableColumn progCol = new TableColumn("Programme");
        TableColumn levelCol = new TableColumn("Level");
        TableColumn gpaCol = new TableColumn("GPA");
        TableColumn statusCol = new TableColumn("Status");

        table.getColumns().addAll(
                idCol, nameCol, progCol, levelCol, gpaCol, statusCol
        );

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        TextField idField = new TextField();
        TextField nameField = new TextField();
        TextField programmeField = new TextField();
        TextField levelField = new TextField();
        TextField gpaField = new TextField();
        TextField emailField = new TextField();
        TextField phoneField = new TextField();

        ComboBox<String> statusBox = new ComboBox<>();
        statusBox.getItems().addAll("Active", "Inactive");

        form.add(new Label("ID:"), 0, 0);
        form.add(idField, 1, 0);
        form.add(new Label("Name:"), 0, 1);
        form.add(nameField, 1, 1);
        form.add(new Label("Programme:"), 0, 2);
        form.add(programmeField, 1, 2);
        form.add(new Label("Level:"), 0, 3);
        form.add(levelField, 1, 3);
        form.add(new Label("GPA:"), 0, 4);
        form.add(gpaField, 1, 4);
        form.add(new Label("Email:"), 0, 5);
        form.add(emailField, 1, 5);
        form.add(new Label("Phone:"), 0, 6);
        form.add(phoneField, 1, 6);
        form.add(new Label("Status:"), 0, 7);
        form.add(statusBox, 1, 7);

        Button addBtn = new Button("Add");
        Button editBtn = new Button("Edit");
        Button deleteBtn = new Button("Delete");
        Button refreshBtn = new Button("Refresh");

        VBox buttons = new VBox(10, addBtn, editBtn, deleteBtn, refreshBtn);
        buttons.setPadding(new Insets(10));

        view.setCenter(table);
        view.setRight(new VBox(20, form, buttons));
    }

    public Parent getView() {
        return view;
    }

}
