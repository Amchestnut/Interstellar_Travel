package space_exploration.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import space_exploration.model.Person;
import space_exploration.model.base.Server;
import space_exploration.model.utility.JDBCUtils;

import java.time.LocalDate;
import java.util.List;

public class AddControl implements EventHandler<ActionEvent> {

    private final TextField firstNameTextField;
    private final TextField lastNameTextField;
    private final DatePicker dateOfBirthPicker;

    private final TableView<Person> personTableView;

    public AddControl(TextField firstNameTextField, TextField lastNameTextField, DatePicker dateOfBirthPicker, TableView<Person> personTableView) {
        this.firstNameTextField = firstNameTextField;
        this.lastNameTextField = lastNameTextField;
        this.dateOfBirthPicker = dateOfBirthPicker;
        this.personTableView = personTableView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
