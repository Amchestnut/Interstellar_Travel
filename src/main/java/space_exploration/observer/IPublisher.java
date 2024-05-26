package space_exploration.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber iSubscriber);
    void removeSubscriber(ISubscriber iSubscriber);
    void notifySubscribers(Object notification);
}
