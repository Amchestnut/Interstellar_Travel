package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class Calendar implements IPublisher{
    private List<ISubscriber> subscribers = new ArrayList<>();

    private Date today;

    public Calendar(Date today) {
        this.today = today;
    }
    public void nextDay(){
        today = Date.valueOf(today.toLocalDate().plusDays(1));
        notifySubscribers(new MessageUpdate(this));
    }
    public Date getToday() {
        return today;
    }

    @Override
    public String toString() {
        return "today = " + today;
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
