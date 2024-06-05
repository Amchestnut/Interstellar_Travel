package space_exploration.controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import space_exploration.ApplicationFramework;
import space_exploration.model.db_classes.CelestialBody;
import space_exploration.model.db_classes.Journey;
import space_exploration.model.db_classes.User;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.view.MainView;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelAction implements EventHandler<ActionEvent> {

    private MainView mainView;
    private CelestialBody selectedCelestialBody;
    private Journey selectedJourney;

    public TravelAction(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        selectedJourney = mainView.getJourneysLV().getSelectionModel().getSelectedItem();
        selectedCelestialBody = mainView.getCelestialBodiesTV().getSelectionModel().getSelectedItem();

        if(selectedCelestialBody != null && selectedJourney != null){
            List<User> ljudiKojiPutujuNaPlanetu = new ArrayList<>();
            ljudiKojiPutujuNaPlanetu.addAll(mainView.getPickedUsersOL());
            ljudiKojiPutujuNaPlanetu.add(ApplicationFramework.getInstance().getCurrentLoginedUser());

            if(JDBCUtils.hasHouse(ApplicationFramework.getInstance().getCurrentLoginedUser().getId(), selectedCelestialBody.getId())){
                for(User user : ljudiKojiPutujuNaPlanetu) {
                    JDBCUtils.insertIntoJourneysUsers(user.getId(), selectedJourney.getId());
                }
                mainView.update();
            }

        }
    }

}
