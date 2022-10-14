/*
* HashMap
* */
package org.vaadin.example;

import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.crud.CrudEditorPosition;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Route("")
public class CrudBasic extends Div {

    private Crud<Person> crud;

    PersonDataProvider dataProvider = new PersonDataProvider();

    private String NAME = "name";
    private String STREET = "street";
    private String CITY = "city";
    private String COUNTRY = "country";
    private String PHONE = "phone";
    private String EMAIL = "email";
    private String EDIT_COLUMN = "vaadin-crud-edit-column";

    public CrudBasic() {

        crud = new Crud<>(
                Person.class,
                createEditor()
        );


        crud.setDataProvider(dataProvider);

        crud.setEditorPosition(CrudEditorPosition.ASIDE);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Thread gripOperThread = new Thread(new GridOper());
        Thread addDeleteEventThread = new Thread(new AddDeleteEvent());
        Thread saveEvent = new Thread(new SaveEvent());
//        Thread editEvent = new Thread(new EditEvent());


        executorService.submit(gripOperThread);
        executorService.submit(addDeleteEventThread);
        executorService.submit(saveEvent);
//        executorService.submit(editEvent);

        executorService.shutdown();

        try {
            executorService.awaitTermination(1,TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

/*
        try {
            gripOperThread.run();
            saveEvent.run();
            addDeleteEventThread.run();

            gripOperThread.start();
            saveEvent.start();
            addDeleteEventThread.start();

            gripOperThread.join();
            saveEvent.join();
            addDeleteEventThread.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
*/

//        setupGrid();
//        setupDataProvider();

        add(crud);
    }

    private CrudEditor<Person> createEditor() {
        TextField name = new TextField("Name:");
        TextField street = new TextField("Street:");
        EmailField city = new EmailField("City:");
        TextField country = new TextField("Country:");
        TextField phone = new TextField("Phone:");
        EmailField email = new EmailField("Email:");
        FormLayout form = new FormLayout(name,street,city,country,phone,email);

        Binder<Person> binder = new Binder<>(Person.class);
        binder.forField(name).asRequired().bind(Person::getName, Person::setName);
        binder.forField(street).asRequired().bind(Person::getStreet,Person::setStreet);
        binder.forField(city).asRequired().bind(Person::getCity,Person::setCity);
        binder.forField(country).asRequired().bind(Person::getCountry,Person::setCountry);
        binder.forField(phone).asRequired().bind(Person::getPhone,Person::setPhone);
        binder.forField(email).asRequired().bind(Person::getEmail,Person::setEmail);

        return new BinderCrudEditor<>(binder, form);
    }

/*

    private void setupGrid() {
        Grid<Person> grid = crud.getGrid();

        List<String> visibleColumns = Arrays.asList(
                NAME,
                STREET,
                CITY,
                COUNTRY,
                PHONE,
                EMAIL,
                EDIT_COLUMN
        );
        grid.getColumns().forEach(column -> {
            String key = column.getKey();
            if (!visibleColumns.contains(key)) {
                grid.removeColumn(column);
            }
        });

        grid.setColumnOrder(
                grid.getColumnByKey(NAME),
                grid.getColumnByKey(STREET),
                grid.getColumnByKey(CITY),
                grid.getColumnByKey(COUNTRY),
                grid.getColumnByKey(PHONE),
                grid.getColumnByKey(EMAIL),
                grid.getColumnByKey(EDIT_COLUMN)
        );
    }

    private void setupDataProvider() {
        PersonDataProvider dataProvider = new PersonDataProvider();
        crud.setDataProvider(dataProvider);
        crud.addDeleteListener(deleteEvent ->
                dataProvider.delete(deleteEvent.getItem())
        );
        crud.addSaveListener(saveEvent ->
                dataProvider.persist(saveEvent.getItem())
        );
    }
*/

    class GridOper implements Runnable{
        @Override
        public void run() {
            Grid<Person> grid = crud.getGrid();

            List<String> visibleColumns = Arrays.asList(
                    NAME,
                    STREET,
                    CITY,
                    COUNTRY,
                    PHONE,
                    EMAIL,
                    EDIT_COLUMN
            );
            grid.getColumns().forEach(column -> {
                String key = column.getKey();
                if (!visibleColumns.contains(key)) {
                    grid.removeColumn(column);
                }
            });

            grid.setColumnOrder(
                    grid.getColumnByKey(NAME),
                    grid.getColumnByKey(STREET),
                    grid.getColumnByKey(CITY),
                    grid.getColumnByKey(COUNTRY),
                    grid.getColumnByKey(PHONE),
                    grid.getColumnByKey(EMAIL),
                    grid.getColumnByKey(EDIT_COLUMN)
            );
        }
    }

    class AddDeleteEvent implements Runnable{
        @Override
        public void run() {
            crud.addDeleteListener(deleteEvent -> {
                String message = dataProvider.delete(deleteEvent.getItem());
                Notification.show(message);
            });
        }
    }

    class SaveEvent implements Runnable{
        @Override
        public void run() {
            crud.addSaveListener(saveEvent ->{
                String message = dataProvider.persist(saveEvent.getItem());
                Notification.show(message);
            });
        }
    }

/*
    class EditEvent implements Runnable{

        @Override
        public void run() {

            crud.addEditListener(editEvent ->
                            crud.edit(editEvent.getItem(), Crud.EditMode.EXISTING_ITEM)
                    );
        }
    }*/

}