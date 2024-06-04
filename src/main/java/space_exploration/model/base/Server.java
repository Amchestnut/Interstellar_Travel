package space_exploration.model.base;

import space_exploration.model.utility.JDBCUtils;
import space_exploration.model.db_classes.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<CelestialBody> celestialBodies = new ArrayList<>();
    private final List<CelestialBody> habitableCelestialBodies = new ArrayList<>();
    //private final List<HabitabilityCriteria> habitabilityCriteria = new ArrayList<>();
    private final List<Mission> missions = new ArrayList<>();
    private final List<Journey> journeys = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private final List<JourneyUser> journeysUsers = new ArrayList<>();
    private final List<ResidentialBuilding> residentialBuildings = new ArrayList<>();
    private final List<HousingPurchase> housingPurchases = new ArrayList<>();
    private final List<Death> deaths = new ArrayList<>();
    private final List<User> avaiableUsers = new ArrayList<>();
    private Calendar today;

    private Server() {
        this.setCelestialBodies(JDBCUtils.selectAllFromCelestialBodies());
        //this.setHabitabilityCriteria(JDBCUtils.selectAllFromHabitabilityCriteria());
        this.setMissions(JDBCUtils.selectAllFromMissions());
        this.setJourneys(JDBCUtils.selectAllFromJourneys());
        this.setUsers(JDBCUtils.selectAllFromUsers());
        this.setJourneysUsers(JDBCUtils.selectAllFromJourneysUsers());
        this.setResidentialBuildings(JDBCUtils.selectAllFromResidentialBuildings());
        this.setHousingPurchases(JDBCUtils.selectAllFromHousingPurchases());
        this.setDeaths(JDBCUtils.selectAllFromDeaths());
        this.setToday(JDBCUtils.selectFromCalendar());
        this.setAvaiableUsers(JDBCUtils.selectAvailableUsers());
        this.setHabitableCelestialBodies(JDBCUtils.selectHabitableCelestialBodies());
    }

    public List<User> getAvaiableUsers() {
        return avaiableUsers;
    }
    private void setAvaiableUsers(List<User> avaiableUsers) {
        this.avaiableUsers.clear();
        this.avaiableUsers.addAll(avaiableUsers);
    }

    public Calendar getToday() {
        return today;
    }

    private void setToday(Calendar today) {
        this.today = today;
    }

    public List<CelestialBody> getCelestialBodies() {
        return celestialBodies;
    }

    private void setCelestialBodies(Collection<CelestialBody> celestialBodies) {
        this.celestialBodies.clear();
        this.celestialBodies.addAll(celestialBodies);
    }

    public List<CelestialBody> getHabitableCelestialBodies() {
        return habitableCelestialBodies;
    }
    private void setHabitableCelestialBodies(Collection<CelestialBody> celestialBodies) {
        this.habitableCelestialBodies.clear();
        this.habitableCelestialBodies.addAll(celestialBodies);
    }

//    public List<HabitabilityCriteria> getHabitabilityCriteria() {
//        return habitabilityCriteria;
//    }
//
//    public void setHabitabilityCriteria(Collection<HabitabilityCriteria> habitabilityCriteria) {
//        this.habitabilityCriteria.clear();
//        this.habitabilityCriteria.addAll(habitabilityCriteria);
//    }

    public List<Mission> getMissions() {
        return missions;
    }

    private void setMissions(Collection<Mission> missions) {
        this.missions.clear();
        this.missions.addAll(missions);
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    private void setJourneys(Collection<Journey> journeys) {
        this.journeys.clear();
        this.journeys.addAll(journeys);
    }

    public List<User> getUsers() {
        return users;
    }

    private void setUsers(Collection<User> users) {
        this.users.clear();
        this.users.addAll(users);
    }

    public List<JourneyUser> getJourneysUsers() {
        return journeysUsers;
    }

    private void setJourneysUsers(Collection<JourneyUser> journeysUsers) {
        this.journeysUsers.clear();
        this.journeysUsers.addAll(journeysUsers);
    }

    public List<ResidentialBuilding> getResidentialBuildings() {
        return residentialBuildings;
    }

    private void setResidentialBuildings(Collection<ResidentialBuilding> residentialBuildings) {
        this.residentialBuildings.clear();
        this.residentialBuildings.addAll(residentialBuildings);
    }

    public List<HousingPurchase> getHousingPurchases() {
        return housingPurchases;
    }

    private void setHousingPurchases(Collection<HousingPurchase> housingPurchases) {
        this.housingPurchases.clear();
        this.housingPurchases.addAll(housingPurchases);
    }

    public List<Death> getDeaths() {
        return deaths;
    }

    private void setDeaths(Collection<Death> deaths) {
        this.deaths.clear();
        this.deaths.addAll(deaths);
    }

}
