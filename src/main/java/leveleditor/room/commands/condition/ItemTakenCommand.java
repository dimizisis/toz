package leveleditor.room.commands.condition;

public class ItemTakenCommand implements ConditionCommand{

    private boolean isItemTaken;

    public ItemTakenCommand(boolean isItemTaken){
        this.isItemTaken = isItemTaken;
    }

    public boolean execute() {
        return isItemTaken;
    }
}
