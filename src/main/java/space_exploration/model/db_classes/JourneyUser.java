package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class JourneyUser implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    private int userId;
    private int journeyId;

    public JourneyUser(int userId, int journeyId) {
        this.userId = userId;
        this.journeyId = journeyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        notifySubscribers(new MessageUpdate(this));

    }

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
        notifySubscribers(new MessageUpdate(this));

    }

    @Override
    public String toString() {
        return "JourneyUser{" +
                "userId=" + userId +
                ", journeyId=" + journeyId +
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
