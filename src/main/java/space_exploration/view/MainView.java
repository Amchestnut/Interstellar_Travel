package space_exploration.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import space_exploration.controller.FilterBuildingForThisCelestial;
import space_exploration.controller.FilterJourneysForThisCelestial;
import space_exploration.controller.PickPersonAction;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.CelestialBodies;
import space_exploration.model.db_classes.Journeys;
import space_exploration.model.db_classes.ResidentialBuildings;
import space_exploration.model.db_classes.Users;


public class MainView extends Scene {

    private BorderPane root;
    private Label controlPanelLB;
    private Label pickAnyPlanetYouWantLB;
    private Label allAvailablePeopleLB;
    private Label allPickedPeopleLB;
    private Button pickPersonButton;
    private Button pickPlanetButton;        /// I THINK ITS REDUNDENT
    private Button filterBuldingsForThisCelestialButton;
    private Button filterJourneysForThisCelestialButton;

    private ObservableList<Journeys> journeysOL;
    private ObservableList<ResidentialBuildings> housingOL;
    private ObservableList<Users> allUsersOL;
    private ObservableList<Users> pickedUsersOL;
    private ObservableList<CelestialBodies> celestialBodiesOL;

    private ListView<Journeys> journeysLV;      /// trains for all planets!!! We shows them all, but also add a filter button so it shows only trains for the picked CELESTIAL, and user can be able to pick any spacecraft and go interstellar
    private ListView<ResidentialBuildings> housingLV;
    private ListView<Users> allUsersLV;
    private ListView<Users> pickedUsersLV;

    private TableView<CelestialBodies> celestialBodiesTV;

    public MainView() {
        super(new BorderPane(), 1300, 1000);
        this.root = (BorderPane) this.getRoot();

        initialisation();
        positioning();
        actions();
    }

    private void initialisation(){
        filterJourneysForThisCelestialButton = new Button("Filter me only journeys for the picked planet");
        filterBuldingsForThisCelestialButton = new Button("Filter homes for the picked planet");        /// maybe add money per resident ??? So they have money to buy
        pickPersonButton= new Button("Pick this person");               ///
        pickPlanetButton = new Button("Pick this planet");

        controlPanelLB = new Label("Control panel...");
        pickAnyPlanetYouWantLB = new Label("Pick any planet or satellite you want to move on. Every one of them is habitable (for now ;))");
        allAvailablePeopleLB = new Label("List of every person available to travel with you");
        allPickedPeopleLB = new Label("List of every person you have picked to go on interstellar journey with you");

        journeysOL = FXCollections.observableArrayList(Server.SERVER.getJourneys());
        housingOL = FXCollections.observableArrayList(Server.SERVER.getResidentialBuildings());
        /// here i want to check if the celestial body is habitale or not with a QUERY to database, saying WHERE AND SATYSFYING all the criteria for a celestial body to be habitable

        /// TODO: treba fixovati ovaj allUsersOL da ne daje bas sve usere, nego samo one koji mogu u tom trenutku da putuju (vidi todo ispod)
        allUsersOL = FXCollections.observableArrayList(Server.SERVER.getUsers());     // TODO: Query koji ce da izvuce sve usere koji su slobodni (koji nisu mrtvi, i koji se jos nisu nigde naselili (ali jesu registrovani)
        /// TODO: da li staviti trenutnog logovanog usera u pickovane usere??
        pickedUsersOL = FXCollections.observableArrayList();                          // TODO: na pocetku prazno, a posle prilikom clicka na button, dodacemo usera jednog po jednog u listu izabranih za putovanje

        celestialBodiesOL = FXCollections.observableArrayList(Server.SERVER.getCelestialBodies());

        journeysLV = new ListView<>(journeysOL);
        housingLV = new ListView<>(housingOL);                                   //   journeysLV.setItems(FXCollections.observableArrayList("Mission 1", "Mission 2", "Mission 3"));
        allUsersLV = new ListView<>(allUsersOL);
        pickedUsersLV = new ListView<>(pickedUsersOL);

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
        VBox centerVBox = new VBox(10, controlPanelLB, filterJourneysForThisCelestialButton, pickPlanetButton, pickPersonButton, filterBuldingsForThisCelestialButton);
        centerVBox.setAlignment(Pos.CENTER);
        allUsersLV.setMaxHeight(150);
        pickedUsersLV.setMaxHeight(150);
        VBox lastRightVbox = new VBox(10, allAvailablePeopleLB, allUsersLV, pickPersonButton, allPickedPeopleLB, pickedUsersLV);

        HBox topHBox = new HBox(50, leftVBox, centerVBox, rightVBox, lastRightVbox); // Increase spacing for better visual separation

        // Position elements in BorderPane
        root.setTop(topHBox);

        VBox bottomVbox = new VBox(10, pickAnyPlanetYouWantLB, celestialBodiesTV);
        bottomVbox.setAlignment(Pos.CENTER);
        root.setCenter(bottomVbox);  // Ensuring TableView is added
    }

    private void actions() {
//        pickPlanetButton.setOnAction(new PickPlanetAction(this));      /// this je view
//        pickPersonButton.setOnAction(new PickPersonAction(this));
//        filterButton.setOnAction(new FilterSomething(this));
        filterBuldingsForThisCelestialButton.setOnAction(new FilterBuildingForThisCelestial(this));
        filterJourneysForThisCelestialButton.setOnAction(new FilterJourneysForThisCelestial(this));
        pickPersonButton.setOnAction(new PickPersonAction(this));
    }


    public Label getControlPanelLB() {
        return controlPanelLB;
    }

    public void setControlPanelLB(Label controlPanelLB) {
        this.controlPanelLB = controlPanelLB;
    }

    public Label getPickAnyPlanetYouWantLB() {
        return pickAnyPlanetYouWantLB;
    }

    public void setPickAnyPlanetYouWantLB(Label pickAnyPlanetYouWantLB) {
        this.pickAnyPlanetYouWantLB = pickAnyPlanetYouWantLB;
    }

    public Button getPickPersonButton() {
        return pickPersonButton;
    }

    public void setPickPersonButton(Button pickPersonButton) {
        this.pickPersonButton = pickPersonButton;
    }

    public Button getPickPlanetButton() {
        return pickPlanetButton;
    }

    public void setPickPlanetButton(Button pickPlanetButton) {
        this.pickPlanetButton = pickPlanetButton;
    }

    public Button getFilterBuldingsForThisCelestialButton() {
        return filterBuldingsForThisCelestialButton;
    }

    public void setFilterBuldingsForThisCelestialButton(Button filterBuldingsForThisCelestialButton) {
        this.filterBuldingsForThisCelestialButton = filterBuldingsForThisCelestialButton;
    }

    public ObservableList<Journeys> getJourneysOL() {
        return journeysOL;
    }

    public void setJourneysOL(ObservableList<Journeys> journeysOL) {
        this.journeysOL = journeysOL;
    }

    public ObservableList<ResidentialBuildings> getHousingOL() {
        return housingOL;
    }

    public void setHousingOL(ObservableList<ResidentialBuildings> housingOL) {
        this.housingOL = housingOL;
    }

    public ObservableList<CelestialBodies> getCelestialBodiesOL() {
        return celestialBodiesOL;
    }

    public void setCelestialBodiesOL(ObservableList<CelestialBodies> celestialBodiesOL) {
        this.celestialBodiesOL = celestialBodiesOL;
    }

    public ListView<Journeys> getJourneysLV() {
        return journeysLV;
    }

    public void setJourneysLV(ListView<Journeys> journeysLV) {
        this.journeysLV = journeysLV;
    }

    public ListView<ResidentialBuildings> getHousingLV() {
        return housingLV;
    }

    public void setHousingLV(ListView<ResidentialBuildings> housingLV) {
        this.housingLV = housingLV;
    }

    public TableView<CelestialBodies> getCelestialBodiesTV() {
        return celestialBodiesTV;
    }

    public void setCelestialBodiesTV(TableView<CelestialBodies> celestialBodiesTV) {
        this.celestialBodiesTV = celestialBodiesTV;
    }

    public Button getFilterJourneysForThisCelestialButton() {
        return filterJourneysForThisCelestialButton;
    }

    public void setFilterJourneysForThisCelestialButton(Button filterJourneysForThisCelestialButton) {
        this.filterJourneysForThisCelestialButton = filterJourneysForThisCelestialButton;
    }

    public ObservableList<Users> getAllUsersOL() {
        return allUsersOL;
    }

    public void setAllUsersOL(ObservableList<Users> allUsersOL) {
        this.allUsersOL = allUsersOL;
    }

    public ObservableList<Users> getPickedUsersOL() {
        return pickedUsersOL;
    }

    public void setPickedUsersOL(ObservableList<Users> pickedUsersOL) {
        this.pickedUsersOL = pickedUsersOL;
    }

    public ListView<Users> getAllUsersLV() {
        return allUsersLV;
    }

    public void setAllUsersLV(ListView<Users> allUsersLV) {
        this.allUsersLV = allUsersLV;
    }

    public ListView<Users> getPickedUsersLV() {
        return pickedUsersLV;
    }

    public void setPickedUsersLV(ListView<Users> pickedUsersLV) {
        this.pickedUsersLV = pickedUsersLV;
    }
}












