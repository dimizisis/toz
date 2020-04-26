package leveleditor.room.commands.condition;

public class HiddenRoomFoundCommand implements ConditionCommand {

    private String hiddenRoomFound;

    public HiddenRoomFoundCommand(String hiddenRoomFound){
        this.hiddenRoomFound = hiddenRoomFound;
    }

    public boolean execute() {
        return hiddenRoomFound != null;
    }
}
