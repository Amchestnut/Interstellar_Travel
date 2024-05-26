package space_exploration.Messages;

public class MessageUpdate {
    private Object caller;

    public MessageUpdate(Object caller){
        this.caller = caller;
    }

    public Object getCaller() {
        return caller;
    }

    public void setCaller(Object caller) {
        this.caller = caller;
    }
}
