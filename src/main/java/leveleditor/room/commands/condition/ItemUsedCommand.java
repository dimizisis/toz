package leveleditor.room.commands.condition;

public class ItemUsedCommand implements ConditionCommand {

    private boolean isItemUsed;

    public ItemUsedCommand(boolean isItemUsed){
        this.isItemUsed = isItemUsed;
    }

    public boolean execute() {
        return isItemUsed;
    }
}
