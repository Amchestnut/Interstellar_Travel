package space_exploration;

import javafx.scene.Scene;
import javafx.stage.Stage;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.User;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.*;

public class ApplicationFramework {

    private User currentLoginedUser;
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

    public void showMainView() {
        MainView mainView = new MainView();
        mainStage.setScene(mainView);
    }

    public void showAllBoughtBuildingView() {
        JDBCUtils.getAllUsersResidentialBuildings();
        AllBoughtBuildingsView allBoughtBuildingsView = new AllBoughtBuildingsView();
        mainStage.setScene(allBoughtBuildingsView);
    }

    public void showHistoryJourneysView() {
        JDBCUtils.getAllUsersJourneys();
        HistoryJourneysView historyJourneysView = new HistoryJourneysView();
        mainStage.setScene(historyJourneysView);
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public User getCurrentLoginedUser() {
        return currentLoginedUser;
    }

    public void setCurrentLoginedUser(User currentLoginedUser) {
        this.currentLoginedUser = currentLoginedUser;
    }
}