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

import java.time.LocalDate;

public class MainView extends Stage {

    private final BorderPane root = new BorderPane();
    private Label controlPanel;
    private Button pickPersonBtn;
    private Button pickPlanetBtn;
    private Button filterBtn;

    private ObservableList<Journeys> journeysOL;
    private ObservableList<HousingPurchases> housingOL;
    private ObservableList<CelestialBodies> celestialBodiesOL;

    private ListView<Journeys> journeysLV;

    private ListView<HousingPurchases> housingLV;

    private TableView<CelestialBodies> celestialBodiesTV;

    public MainView() {
        super.setTitle("Interstellar");

        initialisation();
        positioning();
        actions();

        Scene scene = new Scene(root, 1200, 900);
        super.setScene(scene);
       // super.setScene(new Scene(this.root));
    }

    private void initialisation(){
        filterBtn = new Button("Filter something");        /// maybe add money per resident ??? So they have money to buy
        pickPersonBtn= new Button("Pick this person");               ///
        pickPlanetBtn = new Button("Pick this planet");

        controlPanel = new Label("Control panel...");

        journeysOL = FXCollections.observableArrayList(Server.SERVER.getJourneys());
        housingOL = FXCollections.observableArrayList(Server.SERVER.getHousingPurchases());

        journeysLV = new ListView<>(journeysOL);
        housingLV = new ListView<>(housingOL);                                   //   journeysLV.setItems(FXCollections.observableArrayList("Mission 1", "Mission 2", "Mission 3"));

        celestialBodiesOL = FXCollections.observableArrayList(Server.SERVER.getCelestialBodies());
        TableColumn<CelestialBodies, String> column1 = new TableColumn<>("Name");
        TableColumn<CelestialBodies, String> column2 = new TableColumn<>("Type");
        TableColumn<CelestialBodies, String> column3 = new TableColumn<>("Discovered date");
        TableColumn<CelestialBodies, String> column4 = new TableColumn<>("Researched");
        TableColumn<CelestialBodies, String> column5 = new TableColumn<>("Mean distance from star");
        TableColumn<CelestialBodies, String> column6 = new TableColumn<>("Lowest temperature");
        TableColumn<CelestialBodies, String> column7 = new TableColumn<>("Highest temperature");
        TableColumn<CelestialBodies, String> column8 = new TableColumn<>("Oxygen percentage");
        TableColumn<CelestialBodies, String> column9 = new TableColumn<>("Other gas percentage");
        TableColumn<CelestialBodies, String> column10 = new TableColumn<>("Gravitational field height");
        TableColumn<CelestialBodies, String> column11 = new TableColumn<>("Orbital speed");
        TableColumn<CelestialBodies, String> column12 = new TableColumn<>("Habitable");

        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("type"));
        column3.setCellValueFactory(new PropertyValueFactory<>("discovered_date"));
        column4.setCellValueFactory(new PropertyValueFactory<>("researched"));
        column5.setCellValueFactory(new PropertyValueFactory<>("mean_distance_from_star"));
        column6.setCellValueFactory(new PropertyValueFactory<>("lowest_temperature"));
        column7.setCellValueFactory(new PropertyValueFactory<>("highest_temperature"));
        column8.setCellValueFactory(new PropertyValueFactory<>("oxygen_percentage"));
        column9.setCellValueFactory(new PropertyValueFactory<>("other_gas_percentage"));
        column10.setCellValueFactory(new PropertyValueFactory<>("gravitational_field_height"));
        column11.setCellValueFactory(new PropertyValueFactory<>("orbital_speed"));
        column12.setCellValueFactory(new PropertyValueFactory<>("habitable"));

        celestialBodiesTV.setItems(celestialBodiesOL);
        celestialBodiesTV.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12);
    }

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

        middleVBox.getChildren().addAll(controlPanel, pickPlanetBtn, pickPersonBtn, filterBtn);
        middleVBox.setStyle("-fx-alignment: center");
        middleVBox.setAlignment(Pos.CENTER);

        topHBox.getChildren().addAll(topsideLeft, middleVBox, topsideRight);
        topHBox.setSpacing(50); // Spacing between the ListViews

        bottomTabel.getChildren().addAll(celestialBodiesTV);

        // Assembling the layout
        root.setTop(topHBox);
//        root.setCenter();
        root.setBottom(bottomTabel);
    }


    private void actions() {
//        pickPlanetBtn.setOnAction(new PickPlanetAction(this));      /// this je view
//        pickPersonBtn.setOnAction(new PickPersonAction(this));
//        filterBtn.setOnAction(new FilterSomething(this));
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