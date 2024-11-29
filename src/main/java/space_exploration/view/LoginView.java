package space_exploration.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import space_exploration.ApplicationFramework;
import space_exploration.controller.LoginAction;

public class LoginView extends Scene {

    private GridPane grid;
    private Label usernameLB;
    private Label passwordLB;
    private TextField usernameTF;
    private PasswordField passwordTF;
    private Button loginButton;
    private Button backButton;

    public LoginView() {
        super(new GridPane(), 400, 450); // Pass the GridPane directly to the Scene constructor
        this.grid = (GridPane) this.getRoot();  // Retrieve the root as GridPane
        initialization();
        positioning();
        actions();
    }

    private void initialization() {
        usernameLB = new Label("Username:");
        passwordLB = new Label("Password:");
        usernameTF = new TextField();
        passwordTF = new PasswordField();
        loginButton = new Button("Click here to login");
        backButton = new Button("Back");
    }

    private void positioning() {
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(usernameLB, 0, 0);
        grid.add(usernameTF, 1, 0);
        grid.add(passwordLB, 0, 1);
        grid.add(passwordTF, 1, 1);
        grid.add(loginButton, 1, 2); // Adjusted grid placement for the button
        grid.add(backButton, 1, 3);  // Position the back button
    }

    private void actions() {
        loginButton.setOnAction(new LoginAction(this));  // GPT: Adjust based on your event handling strategy
        backButton.setOnAction(e -> ApplicationFramework.getInstance().showStartView());
    }



    /// geteri seteri


    public Label getUsernameLB() {
        return usernameLB;
    }

    public void setUsernameLB(Label usernameLB) {
        this.usernameLB = usernameLB;
    }

    public Label getPasswordLB() {
        return passwordLB;
    }

    public void setPasswordLB(Label passwordLB) {
        this.passwordLB = passwordLB;
    }

    public TextField getUsernameTF() {
        return usernameTF;
    }

    public void setUsernameTF(TextField usernameTF) {
        this.usernameTF = usernameTF;
    }

    public PasswordField getPasswordTF() {
        return passwordTF;
    }

    public void setPasswordTF(PasswordField passwordTF) {
        this.passwordTF = passwordTF;
    }

    public Button getLoginBtn() {
        return loginButton;
    }

    public void setLoginBtn(Button loginBtn) {
        this.loginButton = loginBtn;
    }
}
