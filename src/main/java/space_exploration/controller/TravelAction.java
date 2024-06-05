package space_exploration.controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import space_exploration.view.MainView;

public class TravelAction implements EventHandler<ActionEvent> {

    private MainView mainView;

    public TravelAction(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }

}