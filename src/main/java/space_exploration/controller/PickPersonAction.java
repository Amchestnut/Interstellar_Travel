package space_exploration.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import space_exploration.model.db_classes.User;
import space_exploration.view.MainView;

public class PickPersonAction implements EventHandler<ActionEvent> {

    private MainView mainView;
    private User personPicked;

    public PickPersonAction(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        personPicked = mainView.getAllUsersLV().getSelectionModel().getSelectedItem();
        if(personPicked != null){

            // TODO: IZBACUJE SE USER KOJI JE UPRAVO IZABRAN iz liste  (pretpostavljam da treba samo da uradimo add  u ARRAYLISTU, ali mora svasta u bazi da se namesti)
            User pickedUser = mainView.getAllUsersLV().getSelectionModel().getSelectedItem();
            mainView.getAllUsersLV().getItems().remove(pickedUser);

            // TODO: /// DODAJE SE USER KOJI JE UPRAVO IZABRAN iz liste
            mainView.getPickedUsersLV().getItems().add(pickedUser);
            mainView.getAllUsersLV().refresh();     /// IZBACUJE SE USER KOJI JE UPRAVO IZABRAN iz liste  (samo osvezi view da sad vidimo sve osvezeno)
            mainView.getPickedUsersLV().refresh();  /// DODAJE SE USER KOJI JE UPRAVO IZABRAN iz liste

        }
    }
}


// TODO: moracemo da imamo neki button koji ce da bude OKIDAC.
//  Kada user klikne taj okidac, izvrsava se SELIDBA, i u tom trenutku moramo da izbacimo iz baze SVIH SLOBODNIH USERA ZA PUTOVANJE ove pickovane usere
// takodje moracemo da smanjimo CAPACITY residential buildinga na toj planeti za broj osoba koji su otisli na putovanje  (i jos neke stvari ako se setim)
// Koristi samo residential.lowerCapacity i to ce da smanji i u bazi