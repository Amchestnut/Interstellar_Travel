package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Missions implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    private int id;
    private int celestialBodyId;
    private Date startDate;
    private Date endDate;

    public Missions(int id, int celestialBodyId, Date startDate, Date endDate) {
        this.id = id;
        this.celestialBodyId = celestialBodyId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifySubscribers(new MessageUpdate(this));

    }

    public int getCelestialBodyId() {
        return celestialBodyId;
    }

    public void setCelestialBodyId(int celestialBodyId) {
        this.celestialBodyId = celestialBodyId;
        notifySubscribers(new MessageUpdate(this));

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        notifySubscribers(new MessageUpdate(this));

    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        notifySubscribers(new MessageUpdate(this));

    }

    @Override
    public String toString() {
        return "Missions{" +
                "id=" + id +
                ", celestialBodyId=" + celestialBodyId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
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
