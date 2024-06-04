package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ResidentialBuilding implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    private int id;
    private String name;
    private int celestialBodyId;
    private int capacity;
    private Date buildDate;

    public ResidentialBuilding(int id, String name, int celestialBodyId, int capacity, Date buildDate) {
        this.id = id;
        this.name = name;
        this.celestialBodyId = celestialBodyId;
        this.capacity = capacity;
        this.buildDate = buildDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        // notifySubscribers(new MessageUpdate(this));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        // notifySubscribers(new MessageUpdate(this));

    }

    public int getCelestialBodyId() {
        return celestialBodyId;
    }

    public void setCelestialBodyId(int celestialBodyId) {
        this.celestialBodyId = celestialBodyId;
        // notifySubscribers(new MessageUpdate(this));

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        // notifySubscribers(new MessageUpdate(this));

    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
        // notifySubscribers(new MessageUpdate(this));

    }
    public void lowerCapacity() {
        this.capacity --;
        notifySubscribers(new MessageUpdate(this));
    }

    @Override
    public String toString() {
        return "ResidentialBuilding{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", celestialBodyId=" + celestialBodyId +
                ", capacity=" + capacity +
                ", buildDate=" + buildDate +
                '}';
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
