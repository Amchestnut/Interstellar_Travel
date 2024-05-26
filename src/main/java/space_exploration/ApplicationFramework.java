package space_exploration;


import javafx.stage.Stage;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.SignInView;

public class ApplicationFramework {

    private static ApplicationFramework instance;
//    private MessageGenerator messageGenerator;


    public static ApplicationFramework getInstance() {
        if (instance == null) {
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public void initialize(Stage stage) {
        JDBCUtils.connect();
        stage = new SignInView();
        stage.show();
    }
}