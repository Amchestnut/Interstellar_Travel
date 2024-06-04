package space_exploration.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import space_exploration.model.db_classes.CelestialBody;
import space_exploration.model.db_classes.Journey;
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
            List<ResidentialBuilding> onlyBuildingsOnThisPlanet = JDBCUtils.getResidentialBuildingsForThisPlanet(selectedItem);
            ObservableList<ResidentialBuilding> buildingObservableList = FXCollections.observableArrayList(onlyBuildingsOnThisPlanet);
            mainView.getHousingLV().setItems(buildingObservableList);
            System.out.println("Filtered Buildings on this planet: " + buildingObservableList);
        }
    }

}
