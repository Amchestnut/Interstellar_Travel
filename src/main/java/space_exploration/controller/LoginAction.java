package space_exploration.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import space_exploration.ApplicationFramework;
import space_exploration.model.db_classes.User;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.LoginView;


public class LoginAction implements EventHandler<ActionEvent> {

    private LoginView loginView;

    public LoginAction(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(validateInput()){
            String username = loginView.getUsernameTF().getText();
            String password = loginView.getPasswordTF().getText();

            User loggedInUser = JDBCUtils.checkLogin(username, password);
            if(loggedInUser != null){
                ApplicationFramework.getInstance().setCurrentLoginedUser(loggedInUser);
                ApplicationFramework.getInstance().showMainView();          // if everythings ok, go to main view
            }
            else {
                // Not ok
                // should pop up an ERROR WINDOW and say: "Username or password incorrect, try again."
                // There should indeed exist a "go back" button so the user can go back to registrate first!
            }
        }
    }


    private boolean validateInput() {
        if (loginView.getUsernameTF().getText().isEmpty() || loginView.getPasswordTF().getText().isEmpty()) {
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
