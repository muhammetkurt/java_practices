package org.vaadin.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.vaadin.data.TaskProvider;
import org.vaadin.enums.Fields;
import org.vaadin.enums.Priority;
import org.vaadin.work.Task;
import oshi.jna.platform.mac.SystemB;

import java.util.List;

@Route("")
public class MainWorkTracker {

    VerticalLayout filterLayout;

    VerticalLayout taskListLayout;

    VerticalLayout contentLayout;

    VerticalLayout actionLayout;

    public MainWorkTracker() {
        VerticalLayout mainLayout = new VerticalLayout();
        VerticalLayout leftSideLayout = new VerticalLayout();
        VerticalLayout rightSideLayout = new VerticalLayout();

        createFilterLayout();
        createTaskListLayout();
        createContentLayout(new Task());
        mainLayout.add(filterLayout,taskListLayout);
    }

    public void createActionLayout(){
        actionLayout = new VerticalLayout();




    }

    public void createContentLayout(Task selectedTask){
        contentLayout = new VerticalLayout();
        TextField reporter = new TextField("Reporter");
        TextField assignee = new TextField("Assignee");
//        DatePicker deadline = new DatePicker(Fields.DEADLINE.getValue());
        reporter.setValue(selectedTask.getReporter().getName());
        assignee.setValue(selectedTask.getAssignee().getName());
//        deadline.setValue();
        HorizontalLayout taskBarLayout = new HorizontalLayout();
        taskBarLayout.add(reporter,assignee);

        HorizontalLayout contentSubLayout = new HorizontalLayout();
        TextArea contentField = new TextArea();
        contentField.setWidthFull();
        contentField.setLabel("Description");
        contentField.setValue(selectedTask.getContent());
        contentSubLayout.add(contentField);

        contentLayout.add(taskBarLayout,contentSubLayout);
    }

    public void createTaskListLayout(){
        taskListLayout = new VerticalLayout();
        Grid<Task> grid = new Grid<>();

        grid.addColumn(Task::getReporter).setHeader("Reporter");
        grid.addColumn(Task::getAssignee).setHeader("Assignee");
        grid.addColumn(Task::getDeadline).setHeader("Deadline");
        grid.addColumn(Task::getPriority).setHeader("Priority");

        grid.setItems(TaskProvider.createTaskMap().values());
        taskListLayout.add(grid);
    }

    public void createFilterLayout(){
        filterLayout = new VerticalLayout();
        TextField reporter = new TextField("Reporter");
        TextField assignee = new TextField("Assignee");
        DatePicker deadline = new DatePicker(Fields.DEADLINE.getValue());

        Select<String> select = new Select<>();
        select.setLabel("Priority");
        select.setItems(Priority.LOW.getValue(),Priority.MEDIUM.getValue(),Priority.HIGH.getValue(),Priority.TRIVIAL.getValue());
        select.setPlaceholder("Select priority");

        Component[] components = {reporter,assignee,deadline,select};
        filterLayout.add(components);
    }


}
