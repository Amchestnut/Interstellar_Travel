package space_exploration.model.utility;

import space_exploration.Messages.MessageUpdate;
import space_exploration.model.db_classes.Calendar;
import space_exploration.model.db_classes.ResidentialBuilding;
import space_exploration.observer.ISubscriber;

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
