# Space Exploration: JDBC-Based Database Exploration Tool
**Space Exploration** is a comprehensive Java-based application designed to simulate and manage space exploration activities using a relational database. It provides users with interactive features to explore celestial bodies, manage space missions, and track journeys through intuitive views and backend database integration. The project leverages **JDBC** for database operations and JavaFX for the user interface, offering an educational and engaging experience in understanding database functionality and SQL queries.

## Features
**Interactive Database Exploration**:  
- Retrieve detailed data about celestial bodies, missions, and journeys.
- Query specific celestial bodies based on habitability criteria.
- View historical journey logs and user-owned buildings.

**Database Operations**:
- Perform **CRUD** operations (Create, Read, Update, Delete) on:
  - Celestial bodies
  - Missions
  - Journeys
  - Users
  - Residential buildings
  - Housing purchases
- Filter, search, and validate data seamlessly.

**Advanced Database Integration**:  
- Use **JDBC** for robust connection and query execution.
- Support for prepared statements and transaction management for secure and efficient operations.
- Real-time data updates with observable patterns for synchronization.

**User-Friendly Interface**:  
- Built with **JavaFX** for interactive and dynamic visuals.
- Navigate through different views such as:
  - Start View
  - Login View
  - Registration View
  - Main Dashboard
  - History and Filtered Journey Logs

**Educational Value**:  
- Gain insights into SQL queries and JDBC mechanics.
- Learn how backend data flows and interacts with a frontend UI.


## Example File: database_script.sql
This file contains the SQL script to generate and populate the necessary tables and data for the application. 
Replace database_script.sql with the following commands for your needs:

```
CREATE DATABASE IF NOT EXISTS spaceexploration;

USE spaceexploration;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL
);

CREATE TABLE CelestialBodies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    researched BOOLEAN DEFAULT FALSE,
    mean_distance_from_star FLOAT,
    lowest_temperature FLOAT,
    highest_temperature FLOAT,
    oxygen_percentage FLOAT,
    other_gas_percentage FLOAT,
    gravitational_field_height FLOAT,
    orbital_speed FLOAT
);

-- Add other tables like Missions, Journeys, ResidentialBuildings, etc.

-- Sample Data
INSERT INTO Users (username, password, email, name, surname, date_of_birth) VALUES 
('astro_admin', 'pass123', 'admin@example.com', 'Astro', 'Admin', '1980-01-01');

INSERT INTO CelestialBodies (name, type, researched, mean_distance_from_star) VALUES 
('Mars', 'Planet', TRUE, 227.9),
('Venus', 'Planet', FALSE, 108.2);
```

## Getting Started
**Prerequisites**  
- Java 11 or later
- MySQL Server (phpMyAdmin localhost)
- Maven
- JavaFX 12
  
**Installation**  
1) Clone the repository:
```
git clone https://github.com/your-username/space-exploration.git
```
2) Import the project into your IDE (e.g., IntelliJ IDEA).
3) Build the project using Maven:
```
mvn clean install
```
4) Set up the database:
Execute the SQL script in database_script.sql to generate the required tables and sample data.  


**Running the Application**  
1) Start the application:
2) Log in using the credentials from the sample data or register a new user.
  - username: john_doe
  - password: pass1234

## How to Use
**Navigation**:  
- **Start View**: Entry point of the application.
- **Login View**: Authenticate users.
- **Main Dashboard**: Access database features like journey history and building exploration.
  
**Database Interaction**:  
- Use pre-configured buttons to retrieve, filter, and update database records.
- Explore **CRUD** functionalities directly from the UI.

**Adding Custom Data**:  
- Modify the database_script.sql file for personalized setup.


## Tech Stack  
- **Languages**: Java  
- **Frameworks**: JavaFX  
- **Database**: MySQL (via JDBC)  
- **Build Tool**: Maven  
- **Libraries**:  
  - MySQL Connector/J  
  - JavaFX Controls  
    
## Code Example
**Fetch All Celestial Bodies**:  
```
List<CelestialBody> bodies = JDBCUtils.selectAllFromCelestialBodies();
for (CelestialBody body : bodies) {
    System.out.println(body);
}
```
  
**Insert a New User**:  
```
JDBCUtils.insertIntoUsers("new_user", "password", "new_user@example.com", "John", "Doe", Date.valueOf("1990-01-01"));
```

## Contributing
Contributions are welcome! Follow these steps:
1) Fork the repository.
2) Create a new branch for your feature or bug fix.
3) Commit your changes with descriptive messages.
4) Submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
