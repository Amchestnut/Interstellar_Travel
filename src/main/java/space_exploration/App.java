package space_exploration;

import javafx.application.Application;
import javafx.stage.Stage;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.MainView;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        JDBCUtils.connect();
        //MainFrame.getInstance().setVisible(true);

        stage = new MainView();
        stage.show();

    }
}
