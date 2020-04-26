package leveleditor.room.commands.action;

import engine.Engine;
import leveleditor.actors.NPC;

import java.util.ArrayList;

public class RemoveNPCCommand implements ActionCommand {

    private String npc;
    private String room;

    public RemoveNPCCommand(String npc, String room){
        this.npc = npc;
        this.room = room;
    }

    public boolean execute() {
        for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(room).getNpcs().size(); i++)
        {
            if (Engine.engine.getPlayer().getWorld().get(room).getNpcs().get(i).getName()==npc)
            {
                Engine.engine.getPlayer().getWorld().get(room).getNpcs().remove(i);
            }
        }
        return true;
    }
}
