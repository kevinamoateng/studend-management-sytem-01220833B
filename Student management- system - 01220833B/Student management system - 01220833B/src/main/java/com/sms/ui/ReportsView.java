package com.sms.ui;

import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;

public class ReportsView {
    private TabPane view;

    public ReportsView() {

        view = new TabPane();

        Tab topTab = new Tab("Top Performers");
        topTab.setContent(new TableView());

        Tab riskTab = new Tab("At Risk Students");
        riskTab.setContent(new TableView());

        Tab gpaTab = new Tab("GPA Distribution");
        gpaTab.setContent(new TableView());

        Tab progTab = new Tab("Programme Summary");
        progTab.setContent(new TableView());

        view.getTabs().addAll(topTab, riskTab, gpaTab, progTab);
    }

    public Parent getView() {
        return view;
    }

}
