package space_exploration.model.utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import space_exploration.ApplicationFramework;
import space_exploration.Messages.MessageUpdate;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.*;
import space_exploration.observer.ISubscriber;
import space_exploration.view.MainView;

import java.util.List;
import java.util.Random;

public class Updater implements ISubscriber {

    private static Updater instance;
    private Updater() {}

    @Override
    public void update(Object notification) {
        if (notification instanceof MessageUpdate) {
            MessageUpdate update = (MessageUpdate) notification;
            if(update.getCaller() instanceof ResidentialBuilding){
                ResidentialBuilding building = (ResidentialBuilding) update.getCaller();
                JDBCUtils.updateResidentialBuildings(building.getId(), building.getName(), building.getCelestialBodyId(), building.getCapacity(), building.getBuildDate());
            }
            else if(update.getCaller() instanceof Calendar){
                Calendar calendar = (Calendar) update.getCaller();
                JDBCUtils.updateCalendar(calendar);
                Random random = new Random();
                for(User user : JDBCUtils.selectAliveUsers())
                    if (random.nextInt(100) < 1) { // 1% chance
                        Journey lastJourney = JDBCUtils.getLastJourneyForUser(user);
                        JDBCUtils.insertIntoDeaths((lastJourney != null)?lastJourney.getDestinationBodyId():3, user.getId(), calendar.getToday(),calendar.getToday().getYear() - user.getDate_of_birth().getYear());
                    }
                if(ApplicationFramework.getInstance().getMainStage().getScene() instanceof MainView){
                    MainView mainView = (MainView) ApplicationFramework.getInstance().getMainStage().getScene();
                    mainView.update();
                }


            }
        }
    }
    public static Updater getUpdater() {
        if (instance == null) {
            instance = new Updater();
        }
        return instance;
    }
}
