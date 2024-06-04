package space_exploration.model.utility;

import javafx.scene.control.Alert;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spaceexploration", properties);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<CelestialBody> selectAllFromCelestialBodies() {
        List<CelestialBody> bodies = new ArrayList<>();
        String query = "SELECT * FROM CelestialBodies";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // Fetching values from the result set
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String type = resultSet.getString(3);
                boolean researched = resultSet.getBoolean(4);
                float meanDistanceFromStar = resultSet.getFloat(5);
                float lowestTemperature = resultSet.getFloat(6);
                float highestTemperature = resultSet.getFloat(7);
                float oxygenPercentage = resultSet.getFloat(8);
                float otherGasPercentage = resultSet.getFloat(9);
                float gravitationalFieldHeight = resultSet.getFloat(10);
                float orbitalSpeed = resultSet.getFloat(11);

                // Creating CelestialBody object and adding it to the list
                CelestialBody body = new CelestialBody(id, name, type, researched, meanDistanceFromStar, lowestTemperature, highestTemperature, oxygenPercentage, otherGasPercentage, gravitationalFieldHeight, orbitalSpeed);
                bodies.add(body);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bodies;
    }
    public static Calendar selectFromCalendar() {
        String query = "SELECT * FROM Calendar";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Date date = resultSet.getDate(1);
                Calendar today = new Calendar(date);
                today.addSubscriber(Updater.getUpdater());
                return today;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static List<CelestialBody> selectHabitableCelestialBodies() {
        List<CelestialBody> habitableBodies = new ArrayList<>();
        Calendar calendar = selectFromCalendar();
        String query = "SELECT cb.* " +
                "FROM CelestialBodies cb " +
                "WHERE cb.mean_distance_from_star BETWEEN 100 AND 200 " +
                "AND cb.lowest_temperature BETWEEN 150 AND 250 " +
                "AND cb.highest_temperature BETWEEN 250 AND 350 " +
                "AND (cb.highest_temperature - cb.lowest_temperature) <= 120 " +
                "AND cb.oxygen_percentage BETWEEN 15 AND 25 " +
                "AND (cb.oxygen_percentage + cb.other_gas_percentage) BETWEEN 90 AND 99 " +
                "AND cb.gravitational_field_height >= 1000 " +
                "AND cb.orbital_speed BETWEEN 25 AND 35 " +
                "AND (SELECT COUNT(*) FROM Deaths d " +
                "WHERE d.celestial_body_id = cb.id " +
                "AND d.age_at_death < 40 " +
                "AND d.death_date BETWEEN DATE_SUB(?, INTERVAL 1 YEAR) AND ?) <= 20";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, calendar.getToday());
            statement.setDate(2, calendar.getToday());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String type = resultSet.getString("type");
                    boolean researched = resultSet.getBoolean("researched");
                    float meanDistanceFromStar = resultSet.getFloat("mean_distance_from_star");
                    float lowestTemperature = resultSet.getFloat("lowest_temperature");
                    float highestTemperature = resultSet.getFloat("highest_temperature");
                    float oxygenPercentage = resultSet.getFloat("oxygen_percentage");
                    float otherGasPercentage = resultSet.getFloat("other_gas_percentage");
                    float gravitationalFieldHeight = resultSet.getFloat("gravitational_field_height");
                    float orbitalSpeed = resultSet.getFloat("orbital_speed");

                    CelestialBody celestialBody = new CelestialBody(id, name, type, researched, meanDistanceFromStar,
                            lowestTemperature, highestTemperature, oxygenPercentage, otherGasPercentage,
                            gravitationalFieldHeight, orbitalSpeed);
                    habitableBodies.add(celestialBody);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return habitableBodies;
    }

    public static List<Mission> selectAllFromMissions() {
        List<Mission> missionsList = new ArrayList<>();
        String query = "SELECT * FROM Missions";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int celestialBodyId = resultSet.getInt(2);
                Date startDate = resultSet.getDate(3);
                Date endDate = resultSet.getDate(4);

                Mission mission = new Mission(id, celestialBodyId, startDate, endDate);
                missionsList.add(mission);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return missionsList;
    }
    public static List<Journey> selectAllFromJourneys() {
        List<Journey> journeysList = new ArrayList<>();
        String query = "SELECT * FROM Journeys";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int destinationBodyId = resultSet.getInt(2);
                String vehicleCode = resultSet.getString(3);
                Timestamp departureDate = resultSet.getTimestamp(4);
                Timestamp arrivalDate = resultSet.getTimestamp(5);

                Journey journey = new Journey(id, destinationBodyId, vehicleCode, departureDate, arrivalDate);
                journeysList.add(journey);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return journeysList;
    }

    public static List<Journey> getJourneysOnlyForThisCelestial(CelestialBody celestialBody) {
        List<Journey> journeysList = new ArrayList<>();
        String query = "SELECT * FROM Journeys WHERE destination_body_id = ? AND departure_date >= ?";
        Server server = Server.SERVER;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, celestialBody.getId());
            statement.setDate(2,server.getToday().getToday());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int destinationBodyId = resultSet.getInt("destination_body_id");
                    String vehicleCode = resultSet.getString("vehicle_code");
                    Timestamp departureDate = resultSet.getTimestamp("departure_date");
                    Timestamp arrivalDate = resultSet.getTimestamp("arrival_date");

                    Journey journey = new Journey(id, destinationBodyId, vehicleCode, departureDate, arrivalDate);
                    journeysList.add(journey);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return journeysList;
    }

    public static List<User> selectAllFromUsers() {
        List<User> usersList = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Date dateOfBirth = resultSet.getDate("date_of_birth");

                User user = new User(id, username, password, email, name, surname, dateOfBirth);
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public static List<JourneyUser> selectAllFromJourneysUsers() {
        List<JourneyUser> journeysUsersList = new ArrayList<>();
        String query = "SELECT * FROM JourneysUsers";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                int journeyId = resultSet.getInt(2);

                JourneyUser journeysUser = new JourneyUser(userId, journeyId);
                journeysUsersList.add(journeysUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return journeysUsersList;
    }
    public static List<ResidentialBuilding> selectAllFromResidentialBuildings() {
        List<ResidentialBuilding> buildingsList = new ArrayList<>();
        String query = "SELECT * FROM ResidentialBuildings";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int celestialBodyId = resultSet.getInt(3);
                int capacity = resultSet.getInt(4);
                Date buildDate = resultSet.getDate(5);

                ResidentialBuilding building = new ResidentialBuilding(id, name, celestialBodyId, capacity, buildDate);
                buildingsList.add(building);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return buildingsList;
    }
    public static List<ResidentialBuilding> selectAllAvailableFromResidentialBuildings() {
        List<ResidentialBuilding> buildingsList = new ArrayList<>();
        String query = "SELECT * FROM ResidentialBuildings WHERE capacity > 0 ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int celestialBodyId = resultSet.getInt(3);
                int capacity = resultSet.getInt(4);
                Date buildDate = resultSet.getDate(5);

                ResidentialBuilding building = new ResidentialBuilding(id, name, celestialBodyId, capacity, buildDate);
                buildingsList.add(building);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return buildingsList;
    }

    public static List<ResidentialBuilding> getResidentialBuildingsForThisPlanet(CelestialBody celestialBody) {
        List<ResidentialBuilding> buildingsList = new ArrayList<>();

        String query = "SELECT * FROM ResidentialBuildings WHERE celestial_body_id = ?"; // Fixed query

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, celestialBody.getId()); // Assuming celestialBody has a getId() method

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int celestialBodyId = resultSet.getInt("celestial_body_id");
                    int capacity = resultSet.getInt("capacity");
                    Date buildDate = resultSet.getDate("build_date");

                    ResidentialBuilding building = new ResidentialBuilding(id, name, celestialBodyId, capacity, buildDate);
                    building.addSubscriber(Updater.getUpdater());
                    buildingsList.add(building);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return buildingsList;
    }



    public static List<HousingPurchase> selectAllFromHousingPurchases() {
        List<HousingPurchase> purchasesList = new ArrayList<>();
        String query = "SELECT * FROM HousingPurchases";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int userId = resultSet.getInt(2);
                int buildingId = resultSet.getInt(3);
                Date purchaseDate = resultSet.getDate(4);

                HousingPurchase purchase = new HousingPurchase(id, userId, buildingId, purchaseDate);
                purchasesList.add(purchase);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchasesList;
    }
    public static List<Death> selectAllFromDeaths() {
        List<Death> deathsList = new ArrayList<>();
        String query = "SELECT * FROM Deaths";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int celestialBodyId = resultSet.getInt(2);
                int userId = resultSet.getInt(3);
                Date deathDate = resultSet.getDate(4);
                int ageAtDeath = resultSet.getInt(5);

                Death death = new Death(id, celestialBodyId, userId, deathDate, ageAtDeath);
                deathsList.add(death);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deathsList;
    }


    public static void insertIntoCelestialBodies(String name, String type, boolean researched,
                                                 float meanDistanceFromStar, float lowestTemperature, float highestTemperature,
                                                 float oxygenPercentage, float otherGasPercentage, float gravitationalFieldHeight,
                                                 float orbitalSpeed) {
        String query = "INSERT INTO CelestialBodies (name, type, researched, mean_distance_from_star, " +
                "lowest_temperature, highest_temperature, oxygen_percentage, other_gas_percentage, " +
                "gravitational_field_height, orbital_speed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setBoolean(3, researched);
            statement.setFloat(4, meanDistanceFromStar);
            statement.setFloat(5, lowestTemperature);
            statement.setFloat(6, highestTemperature);
            statement.setFloat(7, oxygenPercentage);
            statement.setFloat(8, otherGasPercentage);
            statement.setFloat(9, gravitationalFieldHeight);
            statement.setFloat(10, orbitalSpeed);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void insertIntoMissions(int celestialBodyId, Date startDate, Date endDate) {
        String query = "INSERT INTO Missions (celestial_body_id, start_date, end_date) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, celestialBodyId);
            statement.setDate(2, startDate);
            statement.setDate(3, endDate);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertIntoJourneys(int destinationBodyId, String vehicleCode, Timestamp departureDate, Timestamp arrivalDate) {
        String query = "INSERT INTO Journeys (destination_body_id, vehicle_code, departure_date, arrival_date) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, destinationBodyId);
            statement.setString(2, vehicleCode);
            statement.setTimestamp(3, departureDate);
            statement.setTimestamp(4, arrivalDate);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertIntoUsers(String username, String password, String email, String name, String surname, Date dateOfBirth) {
        String checkUsernameQuery = "SELECT COUNT(*) FROM Users WHERE username = ?";
        String checkEmailQuery = "SELECT COUNT(*) FROM Users WHERE email = ?";
        String insertQuery = "INSERT INTO Users (username, password, email, name, surname, date_of_birth) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            // Check if username exists
            try (PreparedStatement checkUsernameStatement = connection.prepareStatement(checkUsernameQuery)) {
                checkUsernameStatement.setString(1, username);
                try (ResultSet rs = checkUsernameStatement.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        showAlert("Error", "Username already exists.");
                        System.out.println("Username already exists.");
                        return;
                    }
                }
            }

            // Check if email exists
            try (PreparedStatement checkEmailStatement = connection.prepareStatement(checkEmailQuery)) {
                checkEmailStatement.setString(1, email);
                try (ResultSet rs = checkEmailStatement.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        showAlert("Error", "Email already exists.");
                        System.out.println("Email already exists.");
                        return;
                    }
                }
            }

            // Insert new user if both checks pass
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, username);
                insertStatement.setString(2, password);
                insertStatement.setString(3, email);
                insertStatement.setString(4, name);
                insertStatement.setString(5, surname);
                insertStatement.setDate(6, dateOfBirth);
                insertStatement.executeUpdate();
                connection.commit();
                System.out.println("User successfully inserted.");
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoJourneysUsers(int userId, int journeyId) {
        String query = "INSERT INTO JourneysUsers (user_id, journey_id) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, userId);
            statement.setInt(2, journeyId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertIntoResidentialBuildings(String name, int celestialBodyId, int capacity, Date buildDate) {
        String query = "INSERT INTO ResidentialBuildings (name, celestial_body_id, capacity, build_date) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.setInt(2, celestialBodyId);
            statement.setInt(3, capacity);
            statement.setDate(4, buildDate);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertIntoHousingPurchases(int userId, int buildingId, Date purchaseDate) {
        String query = "INSERT INTO HousingPurchases (user_id, building_id, purchase_date) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, userId);
            statement.setInt(2, buildingId);
            statement.setDate(3, purchaseDate);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertIntoDeaths(int celestialBodyId, int userId, Date deathDate, int ageAtDeath) {
        String query = "INSERT INTO Deaths (celestial_body_id, user_id, death_date, age_at_death) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, celestialBodyId);
            statement.setInt(2, userId);
            statement.setDate(3, deathDate);
            statement.setInt(4, ageAtDeath);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteFromCelestialBodies(int bodyId) {
        String query = "DELETE FROM CelestialBodies WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, bodyId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromMissions(int missionId) {
        String query = "DELETE FROM Missions WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, missionId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromJourneys(int journeyId) {
        String query = "DELETE FROM Journeys WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, journeyId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromUsers(int userId) {
        String query = "DELETE FROM Users WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, userId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromJourneysUsers(int userId, int journeyId) {
        String query = "DELETE FROM JourneysUsers WHERE user_id = ? AND journey_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, userId);
            statement.setInt(2, journeyId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromResidentialBuildings(int buildingId) {
        String query = "DELETE FROM ResidentialBuildings WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, buildingId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromHousingPurchases(int purchaseId) {
        String query = "DELETE FROM HousingPurchases WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, purchaseId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromDeaths(int deathId) {
        String query = "DELETE FROM Deaths WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, deathId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateCelestialBodies(int id, String name, String type, boolean researched,
                                             float meanDistanceFromStar, float lowestTemperature, float highestTemperature,
                                             float oxygenPercentage, float otherGasPercentage, float gravitationalFieldHeight,
                                             float orbitalSpeed) {
        String query = "UPDATE CelestialBodies SET name=?, type=?, researched=?, " +
                "mean_distance_from_star=?, lowest_temperature=?, highest_temperature=?, oxygen_percentage=?, " +
                "other_gas_percentage=?, gravitational_field_height=?, orbital_speed=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setBoolean(3, researched);
            statement.setFloat(4, meanDistanceFromStar);
            statement.setFloat(5, lowestTemperature);
            statement.setFloat(6, highestTemperature);
            statement.setFloat(7, oxygenPercentage);
            statement.setFloat(8, otherGasPercentage);
            statement.setFloat(9, gravitationalFieldHeight);
            statement.setFloat(10, orbitalSpeed);
            statement.setInt(11, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Define update functions for other tables in a similar way
    public static void updateDeaths(int id, int celestialBodyId, int userId, Date deathDate, int ageAtDeath) {
        String query = "UPDATE Deaths SET celestial_body_id=?, user_id=?, death_date=?, age_at_death=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, celestialBodyId);
            statement.setInt(2, userId);
            statement.setDate(3, deathDate);
            statement.setInt(4, ageAtDeath);
            statement.setInt(5, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateResidentialBuildings(int id, String name, int celestialBodyId, int capacity, Date buildDate) {
        String query = "UPDATE ResidentialBuildings SET name=?, celestial_body_id=?, capacity=?, build_date=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.setInt(2, celestialBodyId);
            statement.setInt(3, capacity);
            statement.setDate(4, buildDate);
            statement.setInt(5, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateJourneys(int id, int destinationBodyId, String vehicleCode, Timestamp departureDate, Timestamp arrivalDate) {
        String query = "UPDATE Journeys SET destination_body_id=?, vehicle_code=?, departure_date=?, arrival_date=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, destinationBodyId);
            statement.setString(2, vehicleCode);
            statement.setTimestamp(3, departureDate);
            statement.setTimestamp(4, arrivalDate);
            statement.setInt(5, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateJourneysUsers(int userId, int journeyId, int newUserId, int newJourneyId) {
        String query = "UPDATE JourneysUsers SET user_id=?, journey_id=? WHERE user_id=? AND journey_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, newUserId);
            statement.setInt(2, newJourneyId);
            statement.setInt(3, userId);
            statement.setInt(4, journeyId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateMissions(int id, int celestialBodyId, Date startDate, Date endDate, int newCelestialBodyId, Date newStartDate, Date newEndDate) {
        String query = "UPDATE Missions SET celestial_body_id=?, start_date=?, end_date=? WHERE id=? AND celestial_body_id=? AND start_date=? AND end_date=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, newCelestialBodyId);
            statement.setDate(2, newStartDate);
            statement.setDate(3, newEndDate);
            statement.setInt(4, id);
            statement.setInt(5, celestialBodyId);
            statement.setDate(6, startDate);
            statement.setDate(7, endDate);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateUsers(int id, String username, String password, String email, String name, String surname,
                                   String newUsername, String newPassword, String newEmail, String newName, String newSurname, Date newDateOfBirth) {
        String query = "UPDATE Users SET username=?, password=?, email=?, name=?, surname=?, date_of_birth=? WHERE id=? AND username=? AND password=? AND email=? AND name=? AND surname=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            statement.setString(3, newEmail);
            statement.setString(4, newName);
            statement.setString(5, newSurname);
            statement.setDate(6, newDateOfBirth);
            statement.setInt(7, id);
            statement.setString(8, username);
            statement.setString(9, password);
            statement.setString(10, email);
            statement.setString(11, name);
            statement.setString(12, surname);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                throw new RuntimeException(rollbackEx);
            }
            throw new RuntimeException(e);
        }
    }
    public static void updateCalendar(Calendar calendar){
        String query = "UPDATE Calendar SET today=? WHERE today=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setDate(1,calendar.getToday());
            statement.setDate(2,Date.valueOf(calendar.getToday().toLocalDate().minusDays(1)));
            statement.executeUpdate();
            connection.commit();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateHousingPurchases(int id, int userId, int buildingId, Date purchaseDate) {
        String query = "UPDATE HousingPurchases SET user_id=?, building_id=?, purchase_date=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, userId);
            statement.setInt(2, buildingId);
            statement.setDate(3, purchaseDate);
            statement.setInt(4, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean checkLogin(String userName, String password) {
        String query = "SELECT EXISTS(SELECT 1 FROM Users u LEFT JOIN Deaths d ON u.id = d.user_id WHERE username = ? AND password = ? AND d.id IS NULL)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                return resultSet.getBoolean(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static List<User> selectAvailableUsers() {
        List<User> singleUsers = new ArrayList<>();
        String query = "SELECT * " +
                "FROM Users u " +
                "LEFT JOIN Deaths d ON u.id = d.user_id " +
                "LEFT JOIN HousingPurchases hp ON u.id = hp.user_id " +
                "WHERE d.id IS NULL AND hp.id IS NULL";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String email = resultSet.getString(4);
                String name = resultSet.getString(5);
                String surname = resultSet.getString(6);
                Date dateOfBirth = resultSet.getDate(7);

                User user = new User(id, username, password, email, name, surname, dateOfBirth);
                singleUsers.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return singleUsers;
    }
    public static List<User> selectAliveUsers() {
        List<User> aliveUsersList = new ArrayList<>();
        String query = "SELECT u.*" +
                "FROM Users u " +
                "LEFT JOIN Deaths d ON u.id = d.user_id " +
                "WHERE d.user_id IS NULL";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Date dateOfBirth = resultSet.getDate("date_of_birth");

                User user = new User(id, username, password, email, name, surname, dateOfBirth);
                aliveUsersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aliveUsersList;
    }
    public static Journey getLastJourneyForUser(User user) {
        String query = "SELECT j.id, j.destination_body_id, j.vehicle_code, j.departure_date, j.arrival_date " +
                "FROM Journeys j " +
                "JOIN JourneysUsers ju ON j.id = ju.journey_id " +
                "WHERE ju.user_id = ? " +
                "ORDER BY j.arrival_date DESC " +
                "LIMIT 1";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int destinationBodyId = resultSet.getInt("destination_body_id");
                String vehicleCode = resultSet.getString("vehicle_code");
                Timestamp departureDate = resultSet.getTimestamp("departure_date");
                Timestamp arrivalDate = resultSet.getTimestamp("arrival_date");

                return new Journey(id, destinationBodyId, vehicleCode, departureDate, arrivalDate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static String getCelestialBodiesNameFromID(int id){
        String query = "SELECT name FROM CelestialBodies WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    private JDBCUtils() {
    }
    private static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
