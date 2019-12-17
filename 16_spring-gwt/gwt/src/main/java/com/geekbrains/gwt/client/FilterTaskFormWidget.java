package com.geekbrains.gwt.client;

import com.geekbrains.gwt.common.StatusDto;
import com.geekbrains.gwt.common.TaskDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class FilterTaskFormWidget extends Composite {
    @UiField
    FormPanel filter;
    @UiField
    TextBox nameText;
    @UiField
    TextBox ownerText;
    @UiField
    TextBox executorText;
    @UiField
    ListBox status;

    private TasksTableWidget tasksTableWidget;
    private TasksClient client;

    @UiTemplate("FilterTaskForm.ui.xml")
    interface FilterTaskFormBinder extends UiBinder<Widget, FilterTaskFormWidget> {
    }

    private static FilterTaskFormWidget.FilterTaskFormBinder uiBinder = GWT.create(FilterTaskFormWidget.FilterTaskFormBinder.class);

    public FilterTaskFormWidget(TasksTableWidget tasksTableWidget) {
        this.initWidget(uiBinder.createAndBindUi(this));
        this.tasksTableWidget = tasksTableWidget;
        client = GWT.create(TasksClient.class);

        client.getStatuses(new MethodCallback<List<StatusDto>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                GWT.log(throwable.toString());
                GWT.log(throwable.getMessage());
                Window.alert("Невозможно получить список Статусов: " + throwable.getMessage());
            }

            @Override
            public void onSuccess(Method method, List<StatusDto> i) {
                GWT.log("Received " + i.size() + " statuses");
                for (StatusDto o: i) {
                    status.addItem(o.getRusName(), o.getStatusId().toString());
                }
            }
        });
    }

    @UiHandler("btnSubmit")
    public void submitClick(ClickEvent event) {
        client.getAllTasks(nameText.getText()
                            ,ownerText.getText()
                            ,executorText.getText()
                            ,Long.parseLong(status.getSelectedValue())
                            , new MethodCallback<List<TaskDto>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                GWT.log(throwable.toString());
                GWT.log(throwable.getMessage());
                Window.alert("Невозможно получить список tasks: Сервер не отвечает");
            }

            @Override
            public void onSuccess(Method method, List<TaskDto> i) {
                GWT.log("Received " + i.size() + " tasks");
                tasksTableWidget.loadTable(i);
            }
        });
    }
}
