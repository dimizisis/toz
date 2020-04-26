package leveleditor.room.commands.action;

import engine.Engine;

public class RoomDescCommand implements ActionCommand {

    private String room, roomDesc;

    public RoomDescCommand(String room, String roomDesc){
        this.room = room;
        this.roomDesc = roomDesc;
    }

    public boolean execute() {
        try{
            Engine.engine.getPlayer().getWorld().get(room).setDescription(roomDesc);
        }catch (Exception e)
        {
            Engine.engine.getNavigateWindow().write(roomDesc+"\n");
        }

        return true;
    }
}
