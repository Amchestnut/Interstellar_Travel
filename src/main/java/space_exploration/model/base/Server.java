package space_exploration.model.base;

import space_exploration.model.*;
import space_exploration.model.utility.JDBCUtils;
import space_exploration.model.db_classes.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<CelestialBodies> celestialBodies = new ArrayList<>();
    private final List<HabitabilityCriteria> habitabilityCriteria = new ArrayList<>();
    private final List<Missions> missions = new ArrayList<>();
    private final List<Journeys> journeys = new ArrayList<>();
    private final List<Users> users = new ArrayList<>();
    private final List<JourneysUsers> journeysUsers = new ArrayList<>();
    private final List<ResidentialBuildings> residentialBuildings = new ArrayList<>();
    private final List<HousingPurchases> housingPurchases = new ArrayList<>();
    private final List<Deaths> deaths = new ArrayList<>();

    private Server() {
        this.setCelestialBodies(JDBCUtils.selectAllFromCelestialBodies());
        this.setHabitabilityCriteria(JDBCUtils.selectAllFromHabitabilityCriteria());
        this.setMissions(JDBCUtils.selectAllFromMissions());
        this.setJourneys(JDBCUtils.selectAllFromJourneys());
        this.setUsers(JDBCUtils.selectAllFromUsers());
        this.setJourneysUsers(JDBCUtils.selectAllFromJourneysUsers());
        this.setResidentialBuildings(JDBCUtils.selectAllFromResidentialBuildings());
        this.setHousingPurchases(JDBCUtils.selectAllFromHousingPurchases());
        this.setDeaths(JDBCUtils.selectAllFromDeaths());
    }


    public List<CelestialBodies> getCelestialBodies() {
        return celestialBodies;
    }

    public void setCelestialBodies(Collection<CelestialBodies> celestialBodies) {
        this.celestialBodies.clear();
        this.celestialBodies.addAll(celestialBodies);
    }

    public List<HabitabilityCriteria> getHabitabilityCriteria() {
        return habitabilityCriteria;
    }

    public void setHabitabilityCriteria(Collection<HabitabilityCriteria> habitabilityCriteria) {
        this.habitabilityCriteria.clear();
        this.habitabilityCriteria.addAll(habitabilityCriteria);
    }

    public List<Missions> getMissions() {
        return missions;
    }

    public void setMissions(Collection<Missions> missions) {
        this.missions.clear();
        this.missions.addAll(missions);
    }

    public List<Journeys> getJourneys() {
        return journeys;
    }

    public void setJourneys(Collection<Journeys> journeys) {
        this.journeys.clear();
        this.journeys.addAll(journeys);
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(Collection<Users> users) {
        this.users.clear();
        this.users.addAll(users);
    }

    public List<JourneysUsers> getJourneysUsers() {
        return journeysUsers;
    }

    public void setJourneysUsers(Collection<JourneysUsers> journeysUsers) {
        this.journeysUsers.clear();
        this.journeysUsers.addAll(journeysUsers);
    }

    public List<ResidentialBuildings> getResidentialBuildings() {
        return residentialBuildings;
    }

    public void setResidentialBuildings(Collection<ResidentialBuildings> residentialBuildings) {
        this.residentialBuildings.clear();
        this.residentialBuildings.addAll(residentialBuildings);
    }

    public List<HousingPurchases> getHousingPurchases() {
        return housingPurchases;
    }

    public void setHousingPurchases(Collection<HousingPurchases> housingPurchases) {
        this.housingPurchases.clear();
        this.housingPurchases.addAll(housingPurchases);
    }

    public List<Deaths> getDeaths() {
        return deaths;
    }

    public void setDeaths(Collection<Deaths> deaths) {
        this.deaths.clear();
        this.deaths.addAll(deaths);
    }

}
