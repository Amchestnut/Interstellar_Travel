package space_exploration.model.db_classes;

import space_exploration.Messages.MessageUpdate;
import space_exploration.observer.IPublisher;
import space_exploration.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class HabitabilityCriteria implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    private int id;
    private float meanDistanceFromStarMin;
    private float meanDistanceFromStarMax;
    private float lowestTemperatureMin;
    private float lowestTemperatureMax;
    private float highestTemperatureMin;
    private float highestTemperatureMax;
    private float temperatureDifferenceMax;
    private float oxygenPercentageMin;
    private float oxygenPercentageMax;
    private float totalGasPercentageMin;
    private float totalGasPercentageMax;
    private float gravitationalFieldHeightMin;
    private float orbitalSpeedMin;
    private float orbitalSpeedMax;
    private int maxDeathsUnder40LastYear;
    private float maxTimeSpentOnBody;

    public HabitabilityCriteria(int id, float meanDistanceFromStarMin, float meanDistanceFromStarMax, float lowestTemperatureMin, float lowestTemperatureMax, float highestTemperatureMin, float highestTemperatureMax, float temperatureDifferenceMax, float oxygenPercentageMin, float oxygenPercentageMax, float totalGasPercentageMin, float totalGasPercentageMax, float gravitationalFieldHeightMin, float orbitalSpeedMin, float orbitalSpeedMax, int maxDeathsUnder40LastYear, float maxTimeSpentOnBody) {
        this.id = id;
        this.meanDistanceFromStarMin = meanDistanceFromStarMin;
        this.meanDistanceFromStarMax = meanDistanceFromStarMax;
        this.lowestTemperatureMin = lowestTemperatureMin;
        this.lowestTemperatureMax = lowestTemperatureMax;
        this.highestTemperatureMin = highestTemperatureMin;
        this.highestTemperatureMax = highestTemperatureMax;
        this.temperatureDifferenceMax = temperatureDifferenceMax;
        this.oxygenPercentageMin = oxygenPercentageMin;
        this.oxygenPercentageMax = oxygenPercentageMax;
        this.totalGasPercentageMin = totalGasPercentageMin;
        this.totalGasPercentageMax = totalGasPercentageMax;
        this.gravitationalFieldHeightMin = gravitationalFieldHeightMin;
        this.orbitalSpeedMin = orbitalSpeedMin;
        this.orbitalSpeedMax = orbitalSpeedMax;
        this.maxDeathsUnder40LastYear = maxDeathsUnder40LastYear;
        this.maxTimeSpentOnBody = maxTimeSpentOnBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getMeanDistanceFromStarMin() {
        return meanDistanceFromStarMin;
    }

    public void setMeanDistanceFromStarMin(float meanDistanceFromStarMin) {
        this.meanDistanceFromStarMin = meanDistanceFromStarMin;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getMeanDistanceFromStarMax() {
        return meanDistanceFromStarMax;
    }

    public void setMeanDistanceFromStarMax(float meanDistanceFromStarMax) {
        this.meanDistanceFromStarMax = meanDistanceFromStarMax;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getLowestTemperatureMin() {
        return lowestTemperatureMin;
    }

    public void setLowestTemperatureMin(float lowestTemperatureMin) {
        this.lowestTemperatureMin = lowestTemperatureMin;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getLowestTemperatureMax() {
        return lowestTemperatureMax;
    }

    public void setLowestTemperatureMax(float lowestTemperatureMax) {
        this.lowestTemperatureMax = lowestTemperatureMax;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getHighestTemperatureMin() {
        return highestTemperatureMin;
    }

    public void setHighestTemperatureMin(float highestTemperatureMin) {
        this.highestTemperatureMin = highestTemperatureMin;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getHighestTemperatureMax() {
        return highestTemperatureMax;
    }

    public void setHighestTemperatureMax(float highestTemperatureMax) {
        this.highestTemperatureMax = highestTemperatureMax;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getTemperatureDifferenceMax() {
        return temperatureDifferenceMax;
    }

    public void setTemperatureDifferenceMax(float temperatureDifferenceMax) {
        this.temperatureDifferenceMax = temperatureDifferenceMax;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getOxygenPercentageMin() {
        return oxygenPercentageMin;
    }

    public void setOxygenPercentageMin(float oxygenPercentageMin) {
        this.oxygenPercentageMin = oxygenPercentageMin;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getOxygenPercentageMax() {
        return oxygenPercentageMax;
    }

    public void setOxygenPercentageMax(float oxygenPercentageMax) {
        this.oxygenPercentageMax = oxygenPercentageMax;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getTotalGasPercentageMin() {
        return totalGasPercentageMin;
    }

    public void setTotalGasPercentageMin(float totalGasPercentageMin) {
        this.totalGasPercentageMin = totalGasPercentageMin;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getTotalGasPercentageMax() {
        return totalGasPercentageMax;
    }

    public void setTotalGasPercentageMax(float totalGasPercentageMax) {
        this.totalGasPercentageMax = totalGasPercentageMax;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getGravitationalFieldHeightMin() {
        return gravitationalFieldHeightMin;
    }

    public void setGravitationalFieldHeightMin(float gravitationalFieldHeightMin) {
        this.gravitationalFieldHeightMin = gravitationalFieldHeightMin;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getOrbitalSpeedMin() {
        return orbitalSpeedMin;
    }

    public void setOrbitalSpeedMin(float orbitalSpeedMin) {
        this.orbitalSpeedMin = orbitalSpeedMin;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getOrbitalSpeedMax() {
        return orbitalSpeedMax;
    }

    public void setOrbitalSpeedMax(float orbitalSpeedMax) {
        this.orbitalSpeedMax = orbitalSpeedMax;
        notifySubscribers(new MessageUpdate(this));

    }

    public int getMaxDeathsUnder40LastYear() {
        return maxDeathsUnder40LastYear;
    }

    public void setMaxDeathsUnder40LastYear(int maxDeathsUnder40LastYear) {
        this.maxDeathsUnder40LastYear = maxDeathsUnder40LastYear;
        notifySubscribers(new MessageUpdate(this));

    }

    public float getMaxTimeSpentOnBody() {
        return maxTimeSpentOnBody;
    }

    public void setMaxTimeSpentOnBody(float maxTimeSpentOnBody) {
        this.maxTimeSpentOnBody = maxTimeSpentOnBody;
        notifySubscribers(new MessageUpdate(this));

    }

    @Override
    public String toString() {
        return "HabitabilityCriteria{" +
                "id=" + id +
                ", meanDistanceFromStarMin=" + meanDistanceFromStarMin +
                ", meanDistanceFromStarMax=" + meanDistanceFromStarMax +
                ", lowestTemperatureMin=" + lowestTemperatureMin +
                ", lowestTemperatureMax=" + lowestTemperatureMax +
                ", highestTemperatureMin=" + highestTemperatureMin +
                ", highestTemperatureMax=" + highestTemperatureMax +
                ", temperatureDifferenceMax=" + temperatureDifferenceMax +
                ", oxygenPercentageMin=" + oxygenPercentageMin +
                ", oxygenPercentageMax=" + oxygenPercentageMax +
                ", totalGasPercentageMin=" + totalGasPercentageMin +
                ", totalGasPercentageMax=" + totalGasPercentageMax +
                ", gravitationalFieldHeightMin=" + gravitationalFieldHeightMin +
                ", orbitalSpeedMin=" + orbitalSpeedMin +
                ", orbitalSpeedMax=" + orbitalSpeedMax +
                ", maxDeathsUnder40LastYear=" + maxDeathsUnder40LastYear +
                ", maxTimeSpentOnBody=" + maxTimeSpentOnBody +
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
