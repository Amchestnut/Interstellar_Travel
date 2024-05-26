package space_exploration;

import javafx.application.Application;
import javafx.stage.Stage;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.MainView;
import space_exploration.view.RegistrationView;
import space_exploration.view.SignInView;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        appCore.initialize(stage);
    }
}
