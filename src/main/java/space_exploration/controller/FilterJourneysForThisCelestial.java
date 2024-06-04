package space_exploration.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import space_exploration.model.db_classes.CelestialBodies;
import space_exploration.model.db_classes.Journeys;
import space_exploration.model.db_classes.ResidentialBuildings;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class FilterJourneysForThisCelestial implements EventHandler<ActionEvent> {

    private MainView mainView;
    private CelestialBodies selectedItem;

    public FilterJourneysForThisCelestial(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // TODO: handluj da ako user klikne ovaj filter button, izbaci mu samo journeys na odabrani Celestial
        selectedItem = mainView.getCelestialBodiesTV().getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            List<Journeys> onlyJourneysForThisCelestial = new ArrayList<>();
            onlyJourneysForThisCelestial = JDBCUtils.getJourneysOnlyForThisCelestial(selectedItem);       /// TODO: ovaj query
            mainView.setJourneysOL((ObservableList<Journeys>) onlyJourneysForThisCelestial);
            mainView.getJourneysLV().refresh();
        }

    }
}
