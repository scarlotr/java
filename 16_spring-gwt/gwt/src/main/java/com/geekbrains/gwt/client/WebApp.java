package com.geekbrains.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.*;

public class WebApp implements EntryPoint {
    public void onModuleLoad() {
        Defaults.setServiceRoot("http://localhost:8189/gwt-rest");
        TasksTableWidget tasksTableWidget = new TasksTableWidget();
        VerticalPanel verticalPanel = new VerticalPanel();
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(new AddTaskFormWidget(tasksTableWidget));
        horizontalPanel.add(new FilterTaskFormWidget(tasksTableWidget));
        verticalPanel.add(horizontalPanel);
        verticalPanel.add(tasksTableWidget);
        RootPanel.get().add(verticalPanel);
    }
}