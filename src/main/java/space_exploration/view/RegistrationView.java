package space_exploration.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import space_exploration.ApplicationFramework;
import space_exploration.controller.RegistrationAction;

public class RegistrationView extends Scene {
    private GridPane grid;
    private Label usernameLB;
    private Label passwordLB;
    private Label emailLB;
    private Label nameLB;
    private Label surnameLB;
    private Label dateOfBirthLB;

    private TextField usernameTF;
    private PasswordField passwordTF;
    private TextField emailTF;
    private TextField nameTF;
    private TextField surnameTF;
    private DatePicker dateOfBirthDP;

    private Button submitBtn;
    private Button backButton;

    public RegistrationView() {
        super(new GridPane(), 400, 450);
        this.grid = (GridPane) this.getRoot();
        initialization();
        positioning();
        actions();
    }

    private void initialization() {
        usernameLB = new Label("Username:");
        passwordLB = new Label("Password:");
        emailLB = new Label("Email:");
        nameLB = new Label("Name:");
        surnameLB = new Label("Surname:");
        dateOfBirthLB = new Label("Date of birth:");

        usernameTF = new TextField();
        passwordTF = new PasswordField();
        emailTF = new TextField();
        nameTF = new TextField();
        surnameTF = new TextField();
        dateOfBirthDP = new DatePicker();

        submitBtn = new Button("Click here to register");
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
        grid.add(emailLB, 0, 2);
        grid.add(emailTF, 1, 2);
        grid.add(nameLB, 0, 3);
        grid.add(nameTF, 1, 3);
        grid.add(surnameLB, 0, 4);
        grid.add(surnameTF, 1, 4);
        grid.add(dateOfBirthLB, 0, 5);
        grid.add(dateOfBirthDP, 1, 5);

        grid.add(backButton, 1, 8);
        grid.add(submitBtn, 1, 7, 2, 1);
    }

    private void actions() {
        submitBtn.setOnAction(new RegistrationAction(this));  // GPT: or should i send text entered in textfield here to the class SubmitRegistrationAction?
        backButton.setOnAction(e -> ApplicationFramework.getInstance().showStartView());
    }


    /// getters setters
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

    public Label getEmailLB() {
        return emailLB;
    }

    public void setEmailLB(Label emailLB) {
        this.emailLB = emailLB;
    }

    public Label getNameLB() {
        return nameLB;
    }

    public void setNameLB(Label nameLB) {
        this.nameLB = nameLB;
    }

    public Label getSurnameLB() {
        return surnameLB;
    }

    public void setSurnameLB(Label surnameLB) {
        this.surnameLB = surnameLB;
    }

    public Label getDateOfBirthLB() {
        return dateOfBirthLB;
    }

    public void setDateOfBirthLB(Label dateOfBirthLB) {
        this.dateOfBirthLB = dateOfBirthLB;
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

    public TextField getEmailTF() {
        return emailTF;
    }

    public void setEmailTF(TextField emailTF) {
        this.emailTF = emailTF;
    }

    public TextField getNameTF() {
        return nameTF;
    }

    public void setNameTF(TextField nameTF) {
        this.nameTF = nameTF;
    }

    public TextField getSurnameTF() {
        return surnameTF;
    }

    public void setSurnameTF(TextField surnameTF) {
        this.surnameTF = surnameTF;
    }

    public DatePicker getDateOfBirthDP() {
        return dateOfBirthDP;
    }

    public void setDateOfBirthDP(DatePicker dateOfBirthDP) {
        this.dateOfBirthDP = dateOfBirthDP;
    }

    public Button getSubmitBtn() {
        return submitBtn;
    }

    public void setSubmitBtn(Button submitBtn) {
        this.submitBtn = submitBtn;
    }
}



