package space_exploration.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import space_exploration.model.Person;

import java.time.LocalDate;
import java.util.List;

public class PersonTable extends TableView<Person> {
    public PersonTable(List<Person> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Person, Integer> tcPersonId = new TableColumn<>("ID");
        TableColumn<Person, String> tcFirstName = new TableColumn<>("First Name");
        TableColumn<Person, String> tcLastName = new TableColumn<>("Last Name");
        TableColumn<Person, LocalDate> tcDOB = new TableColumn<>("Date of Birth");

        tcPersonId.setCellValueFactory(new PropertyValueFactory<>("personId"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        super.getColumns().add(tcPersonId);
        super.getColumns().add(tcFirstName);
        super.getColumns().add(tcLastName);
        super.getColumns().add(tcDOB);
    }
}
