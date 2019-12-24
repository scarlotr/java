package com.geekbrains.gwt.client;

import com.geekbrains.gwt.common.TaskDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public class AddTaskFormWidget extends Composite {
    @UiField
    FormPanel form;
    @UiField
    TextBox nameText;
    @UiField
    TextBox ownerText;
    @UiField
    TextBox executorText;
    @UiField
    TextBox descriptionText;

    private TasksTableWidget tasksTableWidget;

    @UiTemplate("AddTaskForm.ui.xml")
    interface AddTaskFormBinder extends UiBinder<Widget, AddTaskFormWidget> {
    }

    private static AddTaskFormWidget.AddTaskFormBinder uiBinder = GWT.create(AddTaskFormWidget.AddTaskFormBinder.class);

    public AddTaskFormWidget(TasksTableWidget tasksTableWidget) {
        this.initWidget(uiBinder.createAndBindUi(this));
        this.form.setAction(Defaults.getServiceRoot().concat("tasks"));
        this.tasksTableWidget = tasksTableWidget;
    }

    @UiHandler("btnSubmit")
    public void submitClick(ClickEvent event) {
        TasksClient client = GWT.create(TasksClient.class);
        TaskDto taskDto = new TaskDto(nameText.getText(), ownerText.getText(), executorText.getText(), descriptionText.getText());
        client.save(Storage.getLocalStorageIfSupported().getItem("jwt")
                    ,taskDto
                    ,new MethodCallback<Void>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert("Ошибка при добавлении товара");
            }

            @Override
            public void onSuccess(Method method, Void aVoid) {
                tasksTableWidget.refresh();
            }
        });
    }
}
