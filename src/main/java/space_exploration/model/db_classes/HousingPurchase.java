package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HousingPurchase implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    private int id;
    private int userId;
    private int buildingId;
    private Date purchaseDate;

    public HousingPurchase(int id, int userId, int buildingId, Date purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.buildingId = buildingId;
        this.purchaseDate = purchaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifySubscribers(new MessageUpdate(this));

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        notifySubscribers(new MessageUpdate(this));

    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
        notifySubscribers(new MessageUpdate(this));

    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
        notifySubscribers(new MessageUpdate(this));

    }

    @Override
    public String toString() {
        return "HousingPurchase{" +
                "id=" + id +
                ", userId=" + userId +
                ", buildingId=" + buildingId +
                ", purchaseDate=" + purchaseDate +
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
