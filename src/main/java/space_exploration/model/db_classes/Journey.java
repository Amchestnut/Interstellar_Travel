package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Journey implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    private int id;
    private int destinationBodyId;
    private String vehicleCode;
    private Timestamp departureDate;
    private Timestamp arrivalDate;

    public Journey(int id, int destinationBodyId, String vehicleCode, Timestamp departureDate, Timestamp arrivalDate) {
        this.id = id;
        this.destinationBodyId = destinationBodyId;
        this.vehicleCode = vehicleCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifySubscribers(new MessageUpdate(this));

    }

    public int getDestinationBodyId() {
        return destinationBodyId;
    }

    public void setDestinationBodyId(int destinationBodyId) {
        this.destinationBodyId = destinationBodyId;
        notifySubscribers(new MessageUpdate(this));

    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
        notifySubscribers(new MessageUpdate(this));

    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
        notifySubscribers(new MessageUpdate(this));

    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
        notifySubscribers(new MessageUpdate(this));

    }
    @Override
    public String toString() {
        return "Journey to : " + JDBCUtils.getCelestialBodiesNameFromID(this.destinationBodyId) + " departureDate : " + departureDate + " arrivalDate :" + arrivalDate + " vehicleCode: " + vehicleCode;
    }
    @Override
    public void addSubscriber(ISubscriber iSubscriber) {
        this.subscribers.add(iSubscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber iSubscriber) {
        this.subscribers.remove(iSubscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for(ISubscriber sub: subscribers)
            sub.update(notification);
    }
}
