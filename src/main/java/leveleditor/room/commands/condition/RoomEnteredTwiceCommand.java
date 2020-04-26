package leveleditor.room.commands.condition;

public class RoomEnteredTwiceCommand implements ConditionCommand {

    private int roomEnteredTimes;

    public RoomEnteredTwiceCommand(int roomEnteredTimes){
        this.roomEnteredTimes = roomEnteredTimes;
    }

    public boolean execute() {
        return roomEnteredTimes == 2;
    }
}
