package space_exploration.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.SignInView;


public class SignInAction implements EventHandler<ActionEvent> {

    private SignInView signInView;

    public SignInAction(SignInView signInView) {
        this.signInView = signInView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(validateInput()){
            String username = signInView.getUsernameTF().getText();
            String password = signInView.getPasswordTF().getText(); // Consider hashing this in a real application

            if(JDBCUtils.checkLogin(username, password)){
                // ok
            }
            else{
                // not ok
            }
        }

    }

    private boolean validateInput() {
        if (signInView.getUsernameTF().getText().isEmpty() || signInView.getPasswordTF().getText().isEmpty()) {
            showAlert("Validation Error", "Please fill in all fields.");
            return false;
        }

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
