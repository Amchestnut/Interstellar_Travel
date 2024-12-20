package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class CelestialBody implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();
    private int id;
    private String name;
    private String type;
    private boolean researched;
    private float meanDistanceFromStar;
    private float lowestTemperature;
    private float highestTemperature;
    private float oxygenPercentage;
    private float otherGasPercentage;
    private float gravitationalFieldHeight;
    private float orbitalSpeed;

    public CelestialBody(int id, String name, String type, boolean researched, float meanDistanceFromStar, float lowestTemperature, float highestTemperature, float oxygenPercentage, float otherGasPercentage, float gravitationalFieldHeight, float orbitalSpeed) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.researched = researched;
        this.meanDistanceFromStar = meanDistanceFromStar;
        this.lowestTemperature = lowestTemperature;
        this.highestTemperature = highestTemperature;
        this.oxygenPercentage = oxygenPercentage;
        this.otherGasPercentage = otherGasPercentage;
        this.gravitationalFieldHeight = gravitationalFieldHeight;
        this.orbitalSpeed = orbitalSpeed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifySubscribers(new MessageUpdate(this));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifySubscribers(new MessageUpdate(this));

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        notifySubscribers(new MessageUpdate(this));

    }



    public boolean isResearched() {
        return researched;
    }

    public void setResearched(boolean researched) {
        this.researched = researched;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getMeanDistanceFromStar() {
        return meanDistanceFromStar;
    }

    public void setMeanDistanceFromStar(float meanDistanceFromStar) {
        this.meanDistanceFromStar = meanDistanceFromStar;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getLowestTemperature() {
        return lowestTemperature;
    }

    public void setLowestTemperature(float lowestTemperature) {
        this.lowestTemperature = lowestTemperature;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getHighestTemperature() {
        return highestTemperature;
    }

    public void setHighestTemperature(float highestTemperature) {
        this.highestTemperature = highestTemperature;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getOxygenPercentage() {
        return oxygenPercentage;
    }

    public void setOxygenPercentage(float oxygenPercentage) {
        this.oxygenPercentage = oxygenPercentage;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getOtherGasPercentage() {
        return otherGasPercentage;
    }

    public void setOtherGasPercentage(float otherGasPercentage) {
        this.otherGasPercentage = otherGasPercentage;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getGravitationalFieldHeight() {
        return gravitationalFieldHeight;
    }

    public void setGravitationalFieldHeight(float gravitationalFieldHeight) {
        this.gravitationalFieldHeight = gravitationalFieldHeight;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getOrbitalSpeed() {
        return orbitalSpeed;
    }

    public void setOrbitalSpeed(float orbitalSpeed) {
        this.orbitalSpeed = orbitalSpeed;
        notifySubscribers(new MessageUpdate(this));

    }


    @Override
    public String toString() {
        return "CelestialBody{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", researched=" + researched +
                ", meanDistanceFromStar=" + meanDistanceFromStar +
                ", lowestTemperature=" + lowestTemperature +
                ", highestTemperature=" + highestTemperature +
                ", oxygenPercentage=" + oxygenPercentage +
                ", otherGasPercentage=" + otherGasPercentage +
                ", gravitationalFieldHeight=" + gravitationalFieldHeight +
                ", orbitalSpeed=" + orbitalSpeed +'}';
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
