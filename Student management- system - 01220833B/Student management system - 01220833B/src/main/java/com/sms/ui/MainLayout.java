package com.sms.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainLayout {
    private BorderPane root;

    private DashboardView dashboardView;
    private StudentsView studentsView;
    private ReportsView reportsView;
    private ImportExportView importExportView;
    private SettingsView settingsView;

    public MainLayout() {

        root = new BorderPane();

        dashboardView = new DashboardView();
        studentsView = new StudentsView();
        reportsView = new ReportsView();
        importExportView = new ImportExportView();
        settingsView = new SettingsView();

        VBox menu = new VBox(15);
        menu.setPadding(new Insets(20));
        menu.setStyle("-fx-background-color: #2c3e50;");

        Button btnDashboard = createButton("Dashboard");
        Button btnStudents = createButton("Students");
        Button btnReports = createButton("Reports");
        Button btnImportExport = createButton("Import / Export");
        Button btnSettings = createButton("Settings");

        btnDashboard.setOnAction(e -> root.setCenter(dashboardView.getView()));
        btnStudents.setOnAction(e -> root.setCenter(studentsView.getView()));
        btnReports.setOnAction(e -> root.setCenter(reportsView.getView()));
        btnImportExport.setOnAction(e -> root.setCenter(importExportView.getView()));
        btnSettings.setOnAction(e -> root.setCenter(settingsView.getView()));

        menu.getChildren().addAll(
                btnDashboard,
                btnStudents,
                btnReports,
                btnImportExport,
                btnSettings
        );

        root.setLeft(menu);
        root.setCenter(dashboardView.getView());
    }

    private Button createButton(String text) {
        Button btn = new Button(text);
        btn.setPrefWidth(180);
        btn.setStyle("-fx-background-color: #34495e; -fx-text-fill: white;");
        return btn;
    }

    public Parent getRoot() {
        return root;
    }

}
