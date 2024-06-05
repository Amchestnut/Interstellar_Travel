package space_exploration.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import space_exploration.ApplicationFramework;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.Calendar;
import space_exploration.model.db_classes.CelestialBody;
import space_exploration.model.db_classes.ResidentialBuilding;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.MainView;

public class BuyHousePlaceAction implements EventHandler<ActionEvent> {
    private MainView mainView;
    private ResidentialBuilding selectedResidentialBuilding;

    public BuyHousePlaceAction(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        selectedResidentialBuilding = mainView.getHousingLV().getSelectionModel().getSelectedItem();

        if(selectedResidentialBuilding != null){
            JDBCUtils.insertIntoHousingPurchases(ApplicationFramework.getInstance().getCurrentLoginedUser().getId(), selectedResidentialBuilding.getId(), Server.SERVER.getToday().getToday());
            selectedResidentialBuilding.lowerCapacity();
        }
    }

}

