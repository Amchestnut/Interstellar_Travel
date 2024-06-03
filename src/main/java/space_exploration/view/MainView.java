package space_exploration.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import space_exploration.controller.AddControl;
import space_exploration.controller.FilterControl;
import space_exploration.model.Person;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.CelestialBodies;
import space_exploration.model.db_classes.HousingPurchases;
import space_exploration.model.db_classes.Journeys;
import space_exploration.model.db_classes.ResidentialBuildings;

import java.time.LocalDate;

public class MainView extends Scene {

    private BorderPane root;
    private Label controlPanel;
    private Button pickPersonButton;
    private Button pickPlanetButton;
    private Button filterButton;

    private ObservableList<Journeys> journeysOL;
    private ObservableList<ResidentialBuildings> housingOL;
    private ObservableList<CelestialBodies> celestialBodiesOL;

    private ListView<Journeys> journeysLV;
    private ListView<ResidentialBuildings> housingLV;

    private TableView<CelestialBodies> celestialBodiesTV;

    public MainView() {
        super(new BorderPane(), 1200, 900);
        this.root = (BorderPane) this.getRoot();

        initialisation();
        positioning();
        actions();
    }

    private void initialisation(){
        filterButton = new Button("Filter something");        /// maybe add money per resident ??? So they have money to buy
        pickPersonButton= new Button("Pick this person");               ///
        pickPlanetButton = new Button("Pick this planet");

        controlPanel = new Label("Control panel...");

        journeysOL = FXCollections.observableArrayList(Server.SERVER.getJourneys());
        housingOL = FXCollections.observableArrayList(Server.SERVER.getResidentialBuildings());
        /// here i want to check if the celestial body is habitale or not with a QUERY to database, saying WHERE AND SATYSFYING all the criteria for a celestial body to be habitable
        /// gpt gpt gpt gpt gpt
        celestialBodiesOL = FXCollections.observableArrayList(Server.SERVER.getCelestialBodies());

        journeysLV = new ListView<>(journeysOL);
        housingLV = new ListView<>(housingOL);                                   //   journeysLV.setItems(FXCollections.observableArrayList("Mission 1", "Mission 2", "Mission 3"));

        celestialBodiesTV = new TableView<>(celestialBodiesOL);

        TableColumn<CelestialBodies, String> column1 = new TableColumn<>("Name");
        TableColumn<CelestialBodies, String> column2 = new TableColumn<>("Type");
        TableColumn<CelestialBodies, String> column3 = new TableColumn<>("Researched");
        TableColumn<CelestialBodies, String> column4 = new TableColumn<>("Mean distance from star");
        TableColumn<CelestialBodies, String> column5 = new TableColumn<>("Lowest temperature");
        TableColumn<CelestialBodies, String> column6 = new TableColumn<>("Highest temperature");
        TableColumn<CelestialBodies, String> column7 = new TableColumn<>("Oxygen percentage");
        TableColumn<CelestialBodies, String> column8 = new TableColumn<>("Other gas percentage");
        TableColumn<CelestialBodies, String> column9 = new TableColumn<>("Gravitational field height");
        TableColumn<CelestialBodies, String> column10 = new TableColumn<>("Orbital speed");

        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("type"));
        column3.setCellValueFactory(new PropertyValueFactory<>("researched"));
        column4.setCellValueFactory(new PropertyValueFactory<>("meanDistanceFromStar"));
        column5.setCellValueFactory(new PropertyValueFactory<>("lowestTemperature"));
        column6.setCellValueFactory(new PropertyValueFactory<>("highestTemperature"));
        column7.setCellValueFactory(new PropertyValueFactory<>("oxygenPercentage"));
        column8.setCellValueFactory(new PropertyValueFactory<>("otherGasPercentage"));
        column9.setCellValueFactory(new PropertyValueFactory<>("gravitationalFieldHeight"));
        column10.setCellValueFactory(new PropertyValueFactory<>("orbitalSpeed"));


        //celestialBodiesTV.setItems(celestialBodiesOL);
        celestialBodiesTV.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);
    }

    private void positioning() {
        // Organize layout
        VBox leftVBox = new VBox(10, journeysLV);
        VBox rightVBox = new VBox(10, housingLV);
        VBox centerVBox = new VBox(10, controlPanel, pickPlanetButton, pickPersonButton, filterButton);
        centerVBox.setAlignment(Pos.CENTER);

        HBox topHBox = new HBox(50, leftVBox, centerVBox, rightVBox); // Increase spacing for better visual separation

        // Position elements in BorderPane
        root.setTop(topHBox);
        root.setCenter(celestialBodiesTV);  // Ensuring TableView is added
    }

    /*   (OLD POSITIONING, it sucks a bit)
    private void positioning() {
        VBox topsideLeft = new VBox(10);
        VBox middleVBox = new VBox(10);
        VBox topsideRight = new VBox(10);
        VBox bottomTabel = new VBox(10);
        HBox topHBox = new HBox(10);


        topsideLeft.setSpacing(20);
        topsideLeft.getChildren().addAll(journeysLV);

        topsideRight.setSpacing(20);
        topsideRight.getChildren().addAll(housingLV);

        middleVBox.getChildren().addAll(controlPanel, pickPlanetButton, pickPersonButton, filterButton);
        middleVBox.setStyle("-fx-alignment: center");
        middleVBox.setAlignment(Pos.CENTER);

        topHBox.getChildren().addAll(topsideLeft, middleVBox, topsideRight);
        topHBox.setSpacing(50); // Spacing between the ListViews

       // bottomTabel.getChildren().addAll(celestialBodiesTV);

        // Assembling the layout
        root.setTop(topHBox);
//        root.setCenter();
        root.setBottom(bottomTabel);
    }
     */

    private void actions() {
//        pickPlanetButton.setOnAction(new PickPlanetAction(this));      /// this je view
//        pickPersonButton.setOnAction(new PickPersonAction(this));
//        filterButton.setOnAction(new FilterSomething(this));
        // komentar
    }

}














/*
private HBox filterBox() {
        HBox hbox = new HBox(10, new Label("First name:"), this.tfFirstNameFilter,
                                new Label("Last name:"), this.tfLastNameFilter,
                                new Label("Year:"), this.tfYearFilter,
                                this.btFilter);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    private GridPane addBox() {
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("First name:"), this.tfFirstName);
        gridPane.addRow(1, new Label("Last name:"), this.tfLastName);
        gridPane.addRow(2, new Label("Date of birth:"), this.dpDateOfBirth);
        gridPane.add(this.btAdd, 1, 3);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }
 */