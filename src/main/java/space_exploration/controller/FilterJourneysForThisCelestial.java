package space_exploration.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import space_exploration.model.db_classes.CelestialBody;
import space_exploration.model.db_classes.Journey;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class FilterJourneysForThisCelestial implements EventHandler<ActionEvent> {

    private MainView mainView;
    private CelestialBody selectedItem;

    public FilterJourneysForThisCelestial(MainView mainView) {
        this.mainView = mainView;
    }



    @Override
    public void handle(ActionEvent actionSelected) {
        selectedItem = mainView.getCelestialBodiesTV().getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            List<Journey> filteredJourneys = JDBCUtils.getJourneysOnlyForThisCelestial(selectedItem);
            ObservableList<Journey> observableJourneyList = FXCollections.observableArrayList(filteredJourneys);
            mainView.getJourneysLV().setItems(observableJourneyList);  // Directly set items on ListView
            System.out.println("Filtered Journeys: " + observableJourneyList);
        }
    }

}
