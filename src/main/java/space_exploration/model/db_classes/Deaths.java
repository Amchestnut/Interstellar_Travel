package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Deaths implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    private int id;
    private int celestialBodyId;
    private int userId;
    private Date deathDate;
    private int ageAtDeath;

    public Deaths(int id, int celestialBodyId, int userId, Date deathDate, int ageAtDeath) {
        this.id = id;
        this.celestialBodyId = celestialBodyId;
        this.userId = userId;
        this.deathDate = deathDate;
        this.ageAtDeath = ageAtDeath;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        notifySubscribers(new MessageUpdate(this));

    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
        notifySubscribers(new MessageUpdate(this));

    }

    public int getAgeAtDeath() {
        return ageAtDeath;
    }

    public void setAgeAtDeath(int ageAtDeath) {
        this.ageAtDeath = ageAtDeath;
        notifySubscribers(new MessageUpdate(this));

    }

    @Override
    public String toString() {
        return "Deaths{" +
                "id=" + id +
                ", celestialBodyId=" + celestialBodyId +
                ", userId=" + userId +
                ", deathDate=" + deathDate +
                ", ageAtDeath=" + ageAtDeath +
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
