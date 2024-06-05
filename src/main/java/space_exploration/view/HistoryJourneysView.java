package space_exploration.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import space_exploration.ApplicationFramework;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.JourneyUser;

public class HistoryJourneysView extends Scene {
    private GridPane grid;
    private Label nameOfUserLB;
    private Label surnameOfUserLB;

    private ObservableList allJourneysOL;
    private ListView<JourneyUser> allJourneysLV;

    private Button backButton;


    public HistoryJourneysView() {
        super(new GridPane(), 400, 450);
        this.grid = (GridPane) this.getRoot();
        initialization();
        positioning();
        actions();
    }

    private void initialization() {
        nameOfUserLB = new Label(ApplicationFramework.getInstance().getCurrentLoginedUser().getName());
        surnameOfUserLB = new Label(ApplicationFramework.getInstance().getCurrentLoginedUser().getSurname());
        Server.SERVER.update();
        allJourneysOL = FXCollections.observableArrayList(Server.SERVER.getUsersJourneys());

        allJourneysLV = new ListView<>(allJourneysOL);

        backButton = new Button("Back");
    }

    private void positioning() {
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(nameOfUserLB, 0, 0);
        grid.add(surnameOfUserLB, 0, 1);
        grid.add(new Label("Journeys:"), 0, 2);
        grid.add(allJourneysLV, 0, 3, 2, 1);
        grid.add(backButton, 0, 4);
    }

    private void actions() {
        backButton.setOnAction(e -> ApplicationFramework.getInstance().showMainView());
    }


}
