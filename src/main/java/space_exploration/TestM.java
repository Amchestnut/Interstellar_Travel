package space_exploration;

import space_exploration.model.base.Server;
import space_exploration.model.db_classes.*;
import space_exploration.model.utility.JDBCUtils;
import java.sql.Date;
import java.sql.Timestamp;

public class TestM {
    public static void testRead() {
        Server server = Server.SERVER;


        System.out.println("\nCelestial Bodies:");
        for (CelestialBodies celestialBody : server.getCelestialBodies()) {
            System.out.println(celestialBody);
        }

        System.out.println("\nHabitability Criteria:");
        for (HabitabilityCriteria habitabilityCriteria : server.getHabitabilityCriteria()) {
            System.out.println(habitabilityCriteria);
        }

        System.out.println("\nMissions:");
        for (Missions mission : server.getMissions()) {
            System.out.println(mission);
        }

        System.out.println("\nJourneys:");
        for (Journeys journey : server.getJourneys()) {
            System.out.println(journey);
        }

        System.out.println("\nUsers:");
        for (Users user : server.getUsers()) {
            System.out.println(user);
        }

        System.out.println("\nJourneys Users:");
        for (JourneysUsers journeyUser : server.getJourneysUsers()) {
            System.out.println(journeyUser);
        }

        System.out.println("\nResidential Buildings:");
        for (ResidentialBuildings residentialBuilding : server.getResidentialBuildings()) {
            System.out.println(residentialBuilding);
        }

        System.out.println("\nHousing Purchases:");
        for (HousingPurchases housingPurchase : server.getHousingPurchases()) {
            System.out.println(housingPurchase);
        }

        System.out.println("\nDeaths:");
        for (Deaths death : server.getDeaths()) {
            System.out.println(death);
        }
    }
    public static void testInsert() {
        Server server = Server.SERVER;
        // Insert sample data into CelestialBodies
        JDBCUtils.insertIntoCelestialBodies("Earth", "Planet", Date.valueOf("2024-05-25"), true,
                149.6f, -88.0f, 58.0f, 21.0f, 79.0f, 9.8f, 29.8f, true);
        // Insert sample data into Deaths
        JDBCUtils.insertIntoDeaths(1, 1, Date.valueOf("2024-05-25"), 80);
        // Insert sample data into Journeys
        JDBCUtils.insertIntoJourneys(1, "ABC123", Timestamp.valueOf("2024-05-25 12:00:00"), Timestamp.valueOf("2024-05-26 12:00:00"));
        // Insert sample data into Missions
        JDBCUtils.insertIntoMissions(1, Date.valueOf("2024-05-25"), Date.valueOf("2024-05-26"));
        // Insert sample data into HabitabilityCriteria
        JDBCUtils.insertIntoHabitabilityCriteria(1.0f, 2.0f, -50.0f, 50.0f, -20.0f, 100.0f, 120.0f, 15.0f, 10.0f, 30.0f, 70.0f, 0.5f, 5.0f, 50.0f, 100, 100, 10.0f);
        // Insert sample data into Users
        JDBCUtils.insertIntoUsers("john_doe223123", "password123", "john.doe123123123@example.com", "John", "Doe", Date.valueOf("1990-01-01"), Date.valueOf("2024-05-25"));
        // Insert sample data into JourneysUsers
        JDBCUtils.insertIntoJourneysUsers(1, 1);
        // Insert sample data into ResidentialBuildings
        JDBCUtils.insertIntoResidentialBuildings("Building1", 1, 100, Date.valueOf("2020-01-01"));
        // Insert sample data into HousingPurchases
        JDBCUtils.insertIntoHousingPurchases(1, 1, Date.valueOf("2024-05-25"));
        // Insert sample data into Deaths
        JDBCUtils.insertIntoDeaths(1, 1, Date.valueOf("2024-05-25"), 80);
    }
    public static void testDelete() {
        JDBCUtils.deleteFromDeaths(1);
        JDBCUtils.deleteFromHousingPurchases(1);
        JDBCUtils.deleteFromJourneysUsers(1,1);
        JDBCUtils.deleteFromMissions(1);
        JDBCUtils.deleteFromJourneys(1);
        JDBCUtils.deleteFromResidentialBuildings(1);
        JDBCUtils.deleteFromUsers(1);
        JDBCUtils.deleteFromHabitabilityCriteria(1);
        JDBCUtils.deleteFromCelestialBodies(1);
    }

    public static void testUpdate() {
        Server server = Server.SERVER;
        JDBCUtils.updateCelestialBodies(1, "Updated Name", "Planet", new Date(2100,5,6), true, 100.0f, -100.0f, 100.0f, 21.0f, 79.0f, 9.8f, 29.8f, true);
        JDBCUtils.updateHabitabilityCriteria(1, 10.0f, 20.0f, -50.0f, -10.0f, -10.0f, 50.0f, 20.0f, 30.0f, 20.0f, 90.0f, 10.0f, 50.0f, 10.0f, 50.0f, 100, 24.0f);
        JDBCUtils.updateJourneys(1, 1, "Updated Vehicle Code", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        JDBCUtils.updateUsers(1, "user1", "pass1", "user1@example.com", "User1", "Surname1", new Date(2100,5,6), new Date(2100,5,6), "new_user1", "new_pass1", "new_user1@example.com", "New User1", "New Surname1", new Date(2100,5,6), new Date(2100,5,6));
        JDBCUtils.updateJourneysUsers(1, 1, 2, 2);
        JDBCUtils.updateResidentialBuildings(1, "Updated Building Name", 1, 100, new Date(2100,5,6));
        JDBCUtils.updateHousingPurchases(1, 1, 1, new Date(2100,5,6));
        JDBCUtils.updateDeaths(1, 1, 1, new Date(2100,5,6), 30);
    }

    public TestM() {
        JDBCUtils.connect();
//        testInsert();
//        testDelete();
        testUpdate();
        testRead();

    }
}
