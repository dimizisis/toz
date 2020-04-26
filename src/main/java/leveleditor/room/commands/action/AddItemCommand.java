package leveleditor.room.commands.action;

import engine.Engine;
import leveleditor.items.Item;

public class AddItemCommand implements ActionCommand {

    private Item item;

    public AddItemCommand(Item item){
        this.item = item;
    }

    public boolean execute() {
        Engine.engine.getNavigateWindow().write("You've added "+item+" to your inventory\n");
        Engine.engine.getPlayer().getInventory().add(item);
        return true;
    }
}
