package space_exploration;


import javafx.scene.Scene;
import javafx.stage.Stage;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.RegistrationView;
import space_exploration.view.LoginView;
import space_exploration.view.StartView;

public class ApplicationFramework {

    private Stage mainStage;
    private static ApplicationFramework instance;

    public static ApplicationFramework getInstance() {
        if (instance == null) {
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public void initialize(Stage stage) {
        this.mainStage = stage;
        JDBCUtils.connect(); // Initialize your DB connection

        showStartView();     // FIRST SCREEN
        mainStage.show();
    }

    public void showStartView() {
        Scene startScene = new StartView();
        mainStage.setScene(startScene);
    }

    public void showLoginView() {
        Scene loginScene = new LoginView();
        mainStage.setScene(loginScene);
    }

    public void showRegistrationView() {
        Scene registrationScene = new RegistrationView();
        mainStage.setScene(registrationScene);
    }
}