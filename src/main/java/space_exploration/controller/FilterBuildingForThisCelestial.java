package space_exploration.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import space_exploration.model.db_classes.CelestialBody;
import space_exploration.model.db_classes.ResidentialBuilding;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class FilterBuildingForThisCelestial implements EventHandler<ActionEvent> {

    private MainView mainView;
    private CelestialBody selectedItem;

    public FilterBuildingForThisCelestial(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        selectedItem = mainView.getCelestialBodiesTV().getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            List<ResidentialBuilding> onlyBuildingsOnThisPlanet = new ArrayList<>();
            onlyBuildingsOnThisPlanet = JDBCUtils.getResidentialBuildingsForThisPlanet(selectedItem);
            mainView.setHousingOL((ObservableList<ResidentialBuilding>) onlyBuildingsOnThisPlanet);
            mainView.getHousingLV().refresh();
        }
    }
}
