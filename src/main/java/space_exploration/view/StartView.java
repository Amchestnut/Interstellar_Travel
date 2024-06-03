package space_exploration.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import space_exploration.ApplicationFramework;

public class StartView extends Scene {
    private GridPane grid;
    private Label welcomeUser;
    private Label registrate_if_need;
    private Label login_if_possible;

//    private TextField usernameTF;
//    private PasswordField passwordTF;
    private Button proceedOnLogin;
    private Button proceedOnRegistration;


    public StartView() {
        super(new GridPane(), 400, 450);
        this.grid = (GridPane) this.getRoot();  // Retrieve the root as GridPane
        initialization();
        positioning();
        actions();
    }

    private void initialization() {
        welcomeUser = new Label("Welcome to interstellar traveling!");
        registrate_if_need = new Label("You first need to registrate on our list of passengers to be able to travel");
        login_if_possible = new Label("If you already registrated before, just proceed and login");

        proceedOnLogin = new Button("Login");
        proceedOnRegistration = new Button("Registrate here");
    }

    private void positioning() {
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(welcomeUser, 0, 0, 2, 1);
        grid.add(registrate_if_need, 0, 1, 2, 1);
        grid.add(login_if_possible, 0, 2, 2, 1);
        grid.add(proceedOnLogin, 0, 3);
        grid.add(proceedOnRegistration, 0, 4);
    }

    private void actions() {
        proceedOnLogin.setOnAction(e -> ApplicationFramework.getInstance().showLoginView());
        proceedOnRegistration.setOnAction(e -> ApplicationFramework.getInstance().showRegistrationView());
    }
}
