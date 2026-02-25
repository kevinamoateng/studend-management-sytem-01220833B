package com.sms.ui;

import com.sms.repository.StudentRepository;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application{
    @Override
    public void start(Stage stage) {

        StudentRepository repo = new StudentRepository();
        repo.createTable();

        MainLayout mainLayout = new MainLayout();

        Scene scene = new Scene(mainLayout.getRoot(), 1000, 600);

        stage.setTitle("SMS Plus");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}
