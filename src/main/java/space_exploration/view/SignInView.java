package space_exploration.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import space_exploration.controller.SignInAction;

public class SignInView extends Stage {

    private Label usernameLB;
    private Label passwordLB;
    private TextField usernameTF;
    private PasswordField passwordTF;
    private Button loginBtn;

    public SignInView() {
        initialization();
        positioning();
        actions();
        setupStage();
    }

    private void initialization() {
        usernameLB = new Label("Username:");
        passwordLB = new Label("Password:");

        usernameTF = new TextField();
        passwordTF = new PasswordField();

        loginBtn = new Button("click here to login");
    }

    private void positioning() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(usernameLB, 0, 0);
        grid.add(usernameTF, 1, 0);
        grid.add(passwordLB, 0, 1);
        grid.add(passwordTF, 1, 1);


        loginBtn = new Button("Click here to register");
        grid.add(loginBtn, 1, 7, 2, 1);
//        loginBtn.setOnAction(e -> onSubmit());

        Scene scene = new Scene(grid, 400, 450);
        this.setScene(scene);
    }

    private void actions() {
        loginBtn.setOnAction(new SignInAction(this));  // GPT: or should i send text entered in textfield here to the class SubmitRegistrationAction?
        // Define button actions or other event responses here
    }

    private void setupStage() {
        this.setTitle("Registration Form");
        this.show();
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
        return loginBtn;
    }

    public void setLoginBtn(Button loginBtn) {
        this.loginBtn = loginBtn;
    }
}
