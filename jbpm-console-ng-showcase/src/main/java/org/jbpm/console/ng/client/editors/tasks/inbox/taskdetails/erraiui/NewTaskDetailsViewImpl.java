/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.console.ng.client.editors.tasks.inbox.taskdetails.erraiui;

import com.google.gwt.event.dom.client.ClickEvent;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jbpm.console.ng.client.editors.tasks.inbox.events.TaskSelectionEvent;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;



import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

import java.util.Calendar;
import java.util.Date;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Dependent
@Templated(value = "NewTaskDetailsViewImpl.html")
public class NewTaskDetailsViewImpl extends Composite
        implements
        NewTaskDetailsPresenter.InboxView {

    @Inject
    private PlaceManager placeManager;
    private NewTaskDetailsPresenter presenter;
    @Inject
    @DataField
    public TextBox taskIdText;
    @Inject
    @DataField
    public TextBox userText;
    @Inject
    @DataField
    public TextBox groupText;
    @Inject
    @DataField
    public TextBox taskNameText;
    @Inject
    @DataField
    public TextArea taskDescriptionTextArea;
    @Inject
    @DataField
    public ListBox taskPriorityListBox;
    @Inject
    @DataField
    public ListBox subTaskStrategyListBox;
    @Inject
    @DataField
    public DateBox dueDate;
    
    @Inject
    @DataField
    public Button updateButton;
    @Inject
    @DataField
    public Button refreshButton;
    private String[] subTaskStrategies = {"NoAction", "EndParentOnAllSubTasksEnd", "SkipAllSubTasksOnParentSkip"};
    private String[] priorities = {"0 - High", "1", "2", "3", "4", "5 - Medium", "6", "7", "8", "9", "10 - Low"};
   
    @Inject
    private Event<NotificationEvent> notification;

    @Override
    public void init(NewTaskDetailsPresenter presenter) {
        this.presenter = presenter;


        for (String strategy : subTaskStrategies) {
            subTaskStrategyListBox.addItem(strategy);

        }

        for (String priority : priorities) {
            taskPriorityListBox.addItem(priority);

        }

     
    }

    @EventHandler("updateButton")
    public void updateTaskButton(ClickEvent e) {
        presenter.updateTask(Long.parseLong(taskIdText.getText()),
                taskDescriptionTextArea.getText(),
                subTaskStrategyListBox.getItemText(subTaskStrategyListBox.getSelectedIndex()),
                dueDate.getValue(), 
                taskPriorityListBox.getSelectedIndex());

    }

    public void receiveSelectedNotification(@Observes TaskSelectionEvent event) {
        taskIdText.setText(String.valueOf(event.getTaskId()));
        presenter.refreshTask(Long.parseLong(taskIdText.getText()));
    }

    @EventHandler("refreshButton")
    public void refreshButton(ClickEvent e) {
        presenter.refreshTask(Long.parseLong(taskIdText.getText()));
    }

    public TextBox getUserText() {
        return userText;
    }

    public TextBox getTaskIdText() {
        return taskIdText;
    }

    public TextBox getGroupText() {
        return groupText;
    }

    public TextBox getTaskNameText() {
        return taskNameText;
    }

    public TextArea getTaskDescriptionTextArea() {
        return taskDescriptionTextArea;
    }

    public ListBox getTaskPriorityListBox() {
        return taskPriorityListBox;
    }

    public DateBox getDueDate() {
        return dueDate;
    }

    public ListBox getSubTaskStrategyListBox() {
        return subTaskStrategyListBox;
    }

    public void displayNotification(String text) {
        notification.fire(new NotificationEvent(text));
    }

    public String[] getSubTaskStrategies() {
        return subTaskStrategies;
    }

    public String[] getPriorities() {
        return priorities;
    }

  
}
