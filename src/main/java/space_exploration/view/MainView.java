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
import space_exploration.ApplicationFramework;
import space_exploration.controller.*;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.*;
import space_exploration.model.utility.JDBCUtils;
import java.util.List;


public class MainView extends Scene {

    private BorderPane root;
    private Label controlPanelLB;
    private Label pickAnyPlanetYouWantLB;
    private Label allAvailablePeopleLB;
    private Label allPickedPeopleLB;
    private Label todaysDateLB;
    private Button pickPersonButton;
    private Button pickPlanetButton;        /// I THINK ITS REDUNDENT
    private Button filterBuldingsForThisCelestialButton;
    private Button filterJourneysForThisCelestialButton;
    private Button nextDaybutton;
    private Button buyHousePlaceButton;
    private Button travelButton;

    private ObservableList<Journey> journeysOL;
    private ObservableList<ResidentialBuilding> housingOL;
    private ObservableList<User> allUsersOL;
    private ObservableList<User> pickedUsersOL;
    private ObservableList<CelestialBody> celestialBodiesOL;

    private ListView<Journey> journeysLV;      /// trains for all planets!!! We shows them all, but also add a filter button so it shows only trains for the picked CELESTIAL, and user can be able to pick any spacecraft and go interstellar
    private ListView<ResidentialBuilding> housingLV;
    private ListView<User> allUsersLV;
    private ListView<User> pickedUsersLV;

    private TableView<CelestialBody> celestialBodiesTV;

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
        nextDaybutton = new Button("Skip to next day");
        buyHousePlaceButton = new Button("Buy house place in selected residential building");
        travelButton = new Button("TRAVEL");

        controlPanelLB = new Label("Control panel...");
        pickAnyPlanetYouWantLB = new Label("Pick any planet or satellite you want to move on. Every one of them is habitable (for now ;))");
        allAvailablePeopleLB = new Label("List of every person available to travel with you");
        allPickedPeopleLB = new Label("List of every person you have picked to go on interstellar journey with you");
        todaysDateLB = new Label(Server.SERVER.getToday().toString());

        journeysOL = FXCollections.observableArrayList();
        //housingOL = FXCollections.observableArrayList(Server.SERVER.getResidentialBuildings());
        housingOL = FXCollections.observableArrayList();
        /// here i want to check if the celestial body is habitale or not with a QUERY to database, saying WHERE AND SATYSFYING all the criteria for a celestial body to be habitable

        allUsersOL = FXCollections.observableArrayList(Server.SERVER.getAvailableUsers());
        /// TODO: da li staviti trenutnog logovanog usera u pickovane usere??
        pickedUsersOL = FXCollections.observableArrayList();                          // TODO: na pocetku prazno, a posle prilikom clicka na button, dodacemo usera jednog po jednog u listu izabranih za putovanje

        Journey lastJourneyForUser= JDBCUtils.getLastJourneyForUser(ApplicationFramework.getInstance().getCurrentLoginedUser());
        boolean goToEarth = (lastJourneyForUser != null && lastJourneyForUser.getDestinationBodyId() != 3);

        celestialBodiesOL = FXCollections.observableArrayList(((goToEarth)?List.of(Server.SERVER.getCelestialBodies().get(2)):Server.SERVER.getHabitableCelestialBodies()));

        journeysLV = new ListView<>(journeysOL);
        housingLV = new ListView<>(housingOL);                                   //   journeysLV.setItems(FXCollections.observableArrayList("Mission 1", "Mission 2", "Mission 3"));
        allUsersLV = new ListView<>(allUsersOL);
        pickedUsersLV = new ListView<>(pickedUsersOL);

        celestialBodiesTV = new TableView<>(celestialBodiesOL);

        TableColumn<CelestialBody, String> column1 = new TableColumn<>("Name");
        TableColumn<CelestialBody, String> column2 = new TableColumn<>("Type");
        TableColumn<CelestialBody, String> column3 = new TableColumn<>("Researched");
        TableColumn<CelestialBody, String> column4 = new TableColumn<>("Mean distance from star");
        TableColumn<CelestialBody, String> column5 = new TableColumn<>("Lowest temperature");
        TableColumn<CelestialBody, String> column6 = new TableColumn<>("Highest temperature");
        TableColumn<CelestialBody, String> column7 = new TableColumn<>("Oxygen percentage");
        TableColumn<CelestialBody, String> column8 = new TableColumn<>("Other gas percentage");
        TableColumn<CelestialBody, String> column9 = new TableColumn<>("Gravitational field height");
        TableColumn<CelestialBody, String> column10 = new TableColumn<>("Orbital speed");

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
        VBox centerVBox = new VBox(10, controlPanelLB, todaysDateLB, filterJourneysForThisCelestialButton, buyHousePlaceButton, pickPersonButton, filterBuldingsForThisCelestialButton);
        centerVBox.setAlignment(Pos.CENTER);
        allUsersLV.setMaxHeight(150);
        pickedUsersLV.setMaxHeight(150);
        VBox lastRightVbox = new VBox(10, allAvailablePeopleLB, allUsersLV, pickPersonButton, allPickedPeopleLB, pickedUsersLV);

        HBox topHBox = new HBox(50, leftVBox, centerVBox, rightVBox, lastRightVbox); // Increase spacing for better visual separation

        // Position elements in BorderPane
        root.setTop(topHBox);

        HBox skipAndTravel = new HBox(1000, nextDaybutton, travelButton);
        VBox bottomVbox = new VBox(10, pickAnyPlanetYouWantLB, celestialBodiesTV, skipAndTravel);
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
        nextDaybutton.setOnAction(e->Server.SERVER.getToday().nextDay());       // TODO oni koji su pickovani, ne treba ponovo da se pojave u originalnoj listi !! opasno
        buyHousePlaceButton.setOnAction(new BuyHousePlaceAction(this));
        travelButton.setOnAction(new TravelAction(this));
    }


    public Label getAllAvailablePeopleLB() {
        return allAvailablePeopleLB;
    }

    public void setAllAvailablePeopleLB(Label allAvailablePeopleLB) {
        this.allAvailablePeopleLB = allAvailablePeopleLB;
    }

    public Label getAllPickedPeopleLB() {
        return allPickedPeopleLB;
    }

    public void setAllPickedPeopleLB(Label allPickedPeopleLB) {
        this.allPickedPeopleLB = allPickedPeopleLB;
    }

    public Label getTodaysDateLB() {
        return todaysDateLB;
    }

    public void setTodaysDateLB(Label todaysDateLB) {
        this.todaysDateLB = todaysDateLB;
    }

    public Button getNextDaybutton() {
        return nextDaybutton;
    }

    public void setNextDaybutton(Button nextDaybutton) {
        this.nextDaybutton = nextDaybutton;
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

    public ObservableList<Journey> getJourneysOL() {
        return journeysOL;
    }

    public void setJourneysOL(ObservableList<Journey> journeysOL) {
        this.journeysOL = journeysOL;
    }

    public ObservableList<ResidentialBuilding> getHousingOL() {
        return housingOL;
    }

    public void setHousingOL(ObservableList<ResidentialBuilding> housingOL) {
        this.housingOL = housingOL;
    }

    public ObservableList<CelestialBody> getCelestialBodiesOL() {
        return celestialBodiesOL;
    }

    public void setCelestialBodiesOL(ObservableList<CelestialBody> celestialBodiesOL) {
        this.celestialBodiesOL = celestialBodiesOL;
    }

    public ListView<Journey> getJourneysLV() {
        return journeysLV;
    }

    public void setJourneysLV(ListView<Journey> journeysLV) {
        this.journeysLV = journeysLV;
    }

    public ListView<ResidentialBuilding> getHousingLV() {
        return housingLV;
    }

    public void setHousingLV(ListView<ResidentialBuilding> housingLV) {
        this.housingLV = housingLV;
    }

    public TableView<CelestialBody> getCelestialBodiesTV() {
        return celestialBodiesTV;
    }

    public void setCelestialBodiesTV(TableView<CelestialBody> celestialBodiesTV) {
        this.celestialBodiesTV = celestialBodiesTV;
    }

    public Button getFilterJourneysForThisCelestialButton() {
        return filterJourneysForThisCelestialButton;
    }

    public void setFilterJourneysForThisCelestialButton(Button filterJourneysForThisCelestialButton) {
        this.filterJourneysForThisCelestialButton = filterJourneysForThisCelestialButton;
    }

    public ObservableList<User> getAllUsersOL() {
        return allUsersOL;
    }

    public void setAllUsersOL(ObservableList<User> allUsersOL) {
        this.allUsersOL = allUsersOL;
    }

    public ObservableList<User> getPickedUsersOL() {
        return pickedUsersOL;
    }

    public void setPickedUsersOL(ObservableList<User> pickedUsersOL) {
        this.pickedUsersOL = pickedUsersOL;
    }

    public ListView<User> getAllUsersLV() {
        return allUsersLV;
    }

    public void setAllUsersLV(ListView<User> allUsersLV) {
        this.allUsersLV = allUsersLV;
    }

    public ListView<User> getPickedUsersLV() {
        return pickedUsersLV;
    }

    public void setPickedUsersLV(ListView<User> pickedUsersLV) {
        this.pickedUsersLV = pickedUsersLV;
    }
    public void update(){
        Calendar calendar = Server.SERVER.getToday();



        this.getJourneysLV().getItems().clear();
        this.getHousingLV().getItems().clear();

        List<User> filteredUser = JDBCUtils.selectAvailableUsers();
        ObservableList<User> observableList = FXCollections.observableList(filteredUser);
        this.getAllUsersLV().setItems(observableList);

        this.getPickedUsersLV().getItems().clear();

        this.getTodaysDateLB().setText(calendar.toString());

        Journey lastJourneyForUser= JDBCUtils.getLastJourneyForUser(ApplicationFramework.getInstance().getCurrentLoginedUser());
        boolean goToEarth = (lastJourneyForUser != null && lastJourneyForUser.getDestinationBodyId() != 3);
        this.getCelestialBodiesTV().setItems(FXCollections.observableArrayList(((goToEarth)?List.of(Server.SERVER.getCelestialBodies().get(2)):Server.SERVER.getHabitableCelestialBodies())));
        this.getHousingLV().refresh();
        this.getPickedUsersLV().refresh();
        this.getCelestialBodiesTV().refresh();
        this.getAllUsersLV().refresh();
    }
}













