package space_exploration.model.utility;

import javafx.scene.control.Alert;
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

    public static List<CelestialBodies> selectAllFromCelestialBodies() {
        List<CelestialBodies> bodies = new ArrayList<>();
        String query = "SELECT * FROM CelestialBodies";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String type = resultSet.getString(3);
                Date discoveredDate = resultSet.getDate(4);
                boolean researched = resultSet.getBoolean(5);
                float meanDistanceFromStar = resultSet.getFloat(6);
                float lowestTemperature = resultSet.getFloat(7);
                float highestTemperature = resultSet.getFloat(8);
                float oxygenPercentage = resultSet.getFloat(9);
                float otherGasPercentage = resultSet.getFloat(10);
                float gravitationalFieldHeight = resultSet.getFloat(11);
                float orbitalSpeed = resultSet.getFloat(12);
                boolean habitable = resultSet.getBoolean(13);

                CelestialBodies body = new CelestialBodies(id, name, type, discoveredDate, researched, meanDistanceFromStar, lowestTemperature, highestTemperature, oxygenPercentage, otherGasPercentage, gravitationalFieldHeight, orbitalSpeed, habitable);
                bodies.add(body);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bodies;
    }
    public static List<HabitabilityCriteria> selectAllFromHabitabilityCriteria() {
        List<HabitabilityCriteria> criteriaList = new ArrayList<>();
        String query = "SELECT * FROM HabitabilityCriteria";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                float meanDistanceFromStarMin = resultSet.getFloat(2);
                float meanDistanceFromStarMax = resultSet.getFloat(3);
                float lowestTemperatureMin = resultSet.getFloat(4);
                float lowestTemperatureMax = resultSet.getFloat(5);
                float highestTemperatureMin = resultSet.getFloat(6);
                float highestTemperatureMax = resultSet.getFloat(7);
                float temperatureDifferenceMax = resultSet.getFloat(8);
                float oxygenPercentageMin = resultSet.getFloat(9);
                float oxygenPercentageMax = resultSet.getFloat(10);
                float totalGasPercentageMin = resultSet.getFloat(11);
                float totalGasPercentageMax = resultSet.getFloat(12);
                float gravitationalFieldHeightMin = resultSet.getFloat(13);
                float orbitalSpeedMin = resultSet.getFloat(14);
                float orbitalSpeedMax = resultSet.getFloat(15);
                int maxDeathsUnder40LastYear = resultSet.getInt(16);
                float maxTimeSpentOnBody = resultSet.getFloat(17);

                HabitabilityCriteria criteria = new HabitabilityCriteria(id, meanDistanceFromStarMin, meanDistanceFromStarMax, lowestTemperatureMin, lowestTemperatureMax, highestTemperatureMin, highestTemperatureMax, temperatureDifferenceMax, oxygenPercentageMin, oxygenPercentageMax, totalGasPercentageMin, totalGasPercentageMax, gravitationalFieldHeightMin, orbitalSpeedMin, orbitalSpeedMax, maxDeathsUnder40LastYear, maxTimeSpentOnBody);
                criteriaList.add(criteria);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return criteriaList;
    }
    public static List<Missions> selectAllFromMissions() {
        List<Missions> missionsList = new ArrayList<>();
        String query = "SELECT * FROM Missions";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int celestialBodyId = resultSet.getInt(2);
                Date startDate = resultSet.getDate(3);
                Date endDate = resultSet.getDate(4);

                Missions mission = new Missions(id, celestialBodyId, startDate, endDate);
                missionsList.add(mission);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return missionsList;
    }
    public static List<Journeys> selectAllFromJourneys() {
        List<Journeys> journeysList = new ArrayList<>();
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

                Journeys journey = new Journeys(id, destinationBodyId, vehicleCode, departureDate, arrivalDate);
                journeysList.add(journey);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return journeysList;
    }
    public static List<Users> selectAllFromUsers() {
        List<Users> usersList = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String email = resultSet.getString(4);
                String name = resultSet.getString(5);
                String surname = resultSet.getString(6);
                Date dateOfBirth = resultSet.getDate(7);
                Date lastRegistrationDate = resultSet.getDate(8);

                Users user = new Users(id, username, password, email, name, surname, dateOfBirth, lastRegistrationDate);
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public static List<JourneysUsers> selectAllFromJourneysUsers() {
        List<JourneysUsers> journeysUsersList = new ArrayList<>();
        String query = "SELECT * FROM JourneysUsers";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                int journeyId = resultSet.getInt(2);

                JourneysUsers journeysUser = new JourneysUsers(userId, journeyId);
                journeysUsersList.add(journeysUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return journeysUsersList;
    }
    public static List<ResidentialBuildings> selectAllFromResidentialBuildings() {
        List<ResidentialBuildings> buildingsList = new ArrayList<>();
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

                ResidentialBuildings building = new ResidentialBuildings(id, name, celestialBodyId, capacity, buildDate);
                buildingsList.add(building);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return buildingsList;
    }
    public static List<HousingPurchases> selectAllFromHousingPurchases() {
        List<HousingPurchases> purchasesList = new ArrayList<>();
        String query = "SELECT * FROM HousingPurchases";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int userId = resultSet.getInt(2);
                int buildingId = resultSet.getInt(3);
                Date purchaseDate = resultSet.getDate(4);

                HousingPurchases purchase = new HousingPurchases(id, userId, buildingId, purchaseDate);
                purchasesList.add(purchase);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchasesList;
    }
    public static List<Deaths> selectAllFromDeaths() {
        List<Deaths> deathsList = new ArrayList<>();
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

                Deaths death = new Deaths(id, celestialBodyId, userId, deathDate, ageAtDeath);
                deathsList.add(death);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deathsList;
    }


    public static void insertIntoCelestialBodies(String name, String type, Date discoveredDate, boolean researched,
                                                 float meanDistanceFromStar, float lowestTemperature, float highestTemperature,
                                                 float oxygenPercentage, float otherGasPercentage, float gravitationalFieldHeight,
                                                 float orbitalSpeed, boolean habitable) {
        String query = "INSERT INTO CelestialBodies (name, type, discovered_date, researched, mean_distance_from_star, " +
                "lowest_temperature, highest_temperature, oxygen_percentage, other_gas_percentage, gravitational_field_height, " +
                "orbital_speed, habitable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setDate(3, discoveredDate);
            statement.setBoolean(4, researched);
            statement.setFloat(5, meanDistanceFromStar);
            statement.setFloat(6, lowestTemperature);
            statement.setFloat(7, highestTemperature);
            statement.setFloat(8, oxygenPercentage);
            statement.setFloat(9, otherGasPercentage);
            statement.setFloat(10, gravitationalFieldHeight);
            statement.setFloat(11, orbitalSpeed);
            statement.setBoolean(12, habitable);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertIntoHabitabilityCriteria(float meanDistanceFromStarMin, float meanDistanceFromStarMax,
                                                      float lowestTemperatureMin, float lowestTemperatureMax,
                                                      float highestTemperatureMin, float highestTemperatureMax,
                                                      float temperatureDifferenceMax, float oxygenPercentageMin,
                                                      float oxygenPercentageMax, float totalGasPercentageMin,
                                                      float totalGasPercentageMax, float gravitationalFieldHeightMin,
                                                      float orbitalSpeedMin, float orbitalSpeedMax, int maxDeathsUnder40LastYear,
                                                      float maxTimeSpentOnBody, float v) {
        String query = "INSERT INTO HabitabilityCriteria (mean_distance_from_star_min, mean_distance_from_star_max, " +
                "lowest_temperature_min, lowest_temperature_max, highest_temperature_min, highest_temperature_max, " +
                "temperature_difference_max, oxygen_percentage_min, oxygen_percentage_max, total_gas_percentage_min, " +
                "total_gas_percentage_max, gravitational_field_height_min, orbital_speed_min, orbital_speed_max, " +
                "max_deaths_under_40_last_year, max_time_spent_on_body) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setFloat(1, meanDistanceFromStarMin);
            statement.setFloat(2, meanDistanceFromStarMax);
            statement.setFloat(3, lowestTemperatureMin);
            statement.setFloat(4, lowestTemperatureMax);
            statement.setFloat(5, highestTemperatureMin);
            statement.setFloat(6, highestTemperatureMax);
            statement.setFloat(7, temperatureDifferenceMax);
            statement.setFloat(8, oxygenPercentageMin);
            statement.setFloat(9, oxygenPercentageMax);
            statement.setFloat(10, totalGasPercentageMin);
            statement.setFloat(11, totalGasPercentageMax);
            statement.setFloat(12, gravitationalFieldHeightMin);
            statement.setFloat(13, orbitalSpeedMin);
            statement.setFloat(14, orbitalSpeedMax);
            statement.setInt(15, maxDeathsUnder40LastYear);
            statement.setFloat(16, maxTimeSpentOnBody);
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
    public static void insertIntoUsers(String username, String password, String email, String name, String surname, Date dateOfBirth, Date lastRegistrationDate) {
        String checkUsernameQuery = "SELECT COUNT(*) FROM Users WHERE username = ?";
        String checkEmailQuery = "SELECT COUNT(*) FROM Users WHERE email = ?";
        String insertQuery = "INSERT INTO Users (username, password, email, name, surname, date_of_birth, last_registration_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            // Check if username exists
            try (PreparedStatement checkUsernameStatement = connection.prepareStatement(checkUsernameQuery)) {
                checkUsernameStatement.setString(1, username);
                try (ResultSet rs = checkUsernameStatement.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        showAlert("Error","Username already exists.");
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
                        showAlert("Error","Username already exists.");

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
                insertStatement.setDate(7, lastRegistrationDate);
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

    public static void deleteFromHabitabilityCriteria(int criteriaId) {
        String query = "DELETE FROM HabitabilityCriteria WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, criteriaId);
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

    public static void updateCelestialBodies(int id, String name, String type, Date discoveredDate, boolean researched,
                                             float meanDistanceFromStar, float lowestTemperature, float highestTemperature,
                                             float oxygenPercentage, float otherGasPercentage, float gravitationalFieldHeight,
                                             float orbitalSpeed, boolean habitable) {
        String query = "UPDATE CelestialBodies SET name=?, type=?, discovered_date=?, researched=?, " +
                "mean_distance_from_star=?, lowest_temperature=?, highest_temperature=?, oxygen_percentage=?, " +
                "other_gas_percentage=?, gravitational_field_height=?, orbital_speed=?, habitable=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setDate(3, discoveredDate);
            statement.setBoolean(4, researched);
            statement.setFloat(5, meanDistanceFromStar);
            statement.setFloat(6, lowestTemperature);
            statement.setFloat(7, highestTemperature);
            statement.setFloat(8, oxygenPercentage);
            statement.setFloat(9, otherGasPercentage);
            statement.setFloat(10, gravitationalFieldHeight);
            statement.setFloat(11, orbitalSpeed);
            statement.setBoolean(12, habitable);
            statement.setInt(13, id);
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
    public static void updateHabitabilityCriteria(int id, float meanDistanceFromStarMin, float meanDistanceFromStarMax,
                                                  float lowestTemperatureMin, float lowestTemperatureMax,
                                                  float highestTemperatureMin, float highestTemperatureMax,
                                                  float temperatureDifferenceMax, float oxygenPercentageMin,
                                                  float oxygenPercentageMax, float totalGasPercentageMin,
                                                  float totalGasPercentageMax, float gravitationalFieldHeightMin,
                                                  float orbitalSpeedMin, float orbitalSpeedMax, int maxDeathsUnder40LastYear,
                                                  float maxTimeSpentOnBody) {
        String query = "UPDATE HabitabilityCriteria SET mean_distance_from_star_min=?, mean_distance_from_star_max=?, " +
                "lowest_temperature_min=?, lowest_temperature_max=?, highest_temperature_min=?, highest_temperature_max=?, " +
                "temperature_difference_max=?, oxygen_percentage_min=?, oxygen_percentage_max=?, total_gas_percentage_min=?, " +
                "total_gas_percentage_max=?, gravitational_field_height_min=?, orbital_speed_min=?, orbital_speed_max=?, " +
                "max_deaths_under_40_last_year=?, max_time_spent_on_body=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setFloat(1, meanDistanceFromStarMin);
            statement.setFloat(2, meanDistanceFromStarMax);
            statement.setFloat(3, lowestTemperatureMin);
            statement.setFloat(4, lowestTemperatureMax);
            statement.setFloat(5, highestTemperatureMin);
            statement.setFloat(6, highestTemperatureMax);
            statement.setFloat(7, temperatureDifferenceMax);
            statement.setFloat(8, oxygenPercentageMin);
            statement.setFloat(9, oxygenPercentageMax);
            statement.setFloat(10, totalGasPercentageMin);
            statement.setFloat(11, totalGasPercentageMax);
            statement.setFloat(12, gravitationalFieldHeightMin);
            statement.setFloat(13, orbitalSpeedMin);
            statement.setFloat(14, orbitalSpeedMax);
            statement.setInt(15, maxDeathsUnder40LastYear);
            statement.setFloat(16, maxTimeSpentOnBody);
            statement.setInt(17, id);
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
    public static void updateUsers(int id, String username, String password, String email, String name, String surname, Date dateOfBirth, Date lastRegistrationDate,
                                   String newUsername, String newPassword, String newEmail, String newName, String newSurname, Date newDateOfBirth, Date newLastRegistrationDate) {
        String query = "UPDATE Users SET username=?, password=?, email=?, name=?, surname=?, date_of_birth=?, last_registration_date=? WHERE id=? AND username=? AND password=? AND email=? AND name=? AND surname=? AND date_of_birth=? AND last_registration_date=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            statement.setString(3, newEmail);
            statement.setString(4, newName);
            statement.setString(5, newSurname);
            statement.setDate(6, newDateOfBirth);
            statement.setDate(7, newLastRegistrationDate);
            statement.setInt(8, id);
            statement.setString(9, username);
            statement.setString(10, password);
            statement.setString(11, email);
            statement.setString(12, name);
            statement.setString(13, surname);
            statement.setDate(14, dateOfBirth);
            statement.setDate(15, lastRegistrationDate);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
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
        String query = "SELECT EXISTS(SELECT 1 FROM Users WHERE username=? AND password=?)";
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
