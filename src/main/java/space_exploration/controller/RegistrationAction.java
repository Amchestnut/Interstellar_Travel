package space_exploration.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import space_exploration.ApplicationFramework;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.RegistrationView;
import java.sql.*;
import java.time.LocalDate;
import java.util.Random;

public class RegistrationAction implements EventHandler<ActionEvent> {
    private RegistrationView registrationView;

    public RegistrationAction(RegistrationView registrationView) {
        this.registrationView = registrationView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(validateInput()){
            String username = registrationView.getUsernameTF().getText();
            String password = registrationView.getPasswordTF().getText(); // Consider hashing this in a real application
            String email = registrationView.getEmailTF().getText();
            String name = registrationView.getNameTF().getText();
            String surname = registrationView.getSurnameTF().getText();

            JDBCUtils.insertIntoUsers(username,password,email,name,surname);
            ApplicationFramework.getInstance().showStartView();
            // TODO: Dodati popup prozor gde pise uspesna registracija!!!
        }
    }

    private boolean validateInput() {
        // Check for non-empty fields
        if (registrationView.getUsernameTF().getText().isEmpty() ||
                registrationView.getPasswordTF().getText().isEmpty() ||
                registrationView.getEmailTF().getText().isEmpty() ||
                registrationView.getNameTF().getText().isEmpty() ||
                registrationView.getSurnameTF().getText().isEmpty() ||
                registrationView.getDateOfBirthDP().getValue() == null) {
            showAlert("Validation Error", "Please fill in all fields.");
            return false;
        }

        // Email validation regex
        if (!registrationView.getEmailTF().getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            showAlert("Validation Error", "Invalid email format.");
            return false;
        }

        // Password complexity check (example: at least 8 characters)
        if (registrationView.getPasswordTF().getText().length() < 8) {
            showAlert("Validation Error", "Password must be at least 8 characters long.");
            return false;
        }

        // Additional checks can be added here (e.g., checking date formats)

        return true;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
