package space_exploration;
import space_exploration.model.base.Server;
import space_exploration.model.db_classes.*;
import space_exploration.model.utility.JDBCUtils;

public class Main {
    public static void main(String[] args) {
        new TestM();
        App.launch(App.class, args);
    }
}

