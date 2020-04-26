package leveleditor.room.commands.action;

import engine.Engine;
import leveleditor.room.ERoomEventAction;

import javax.swing.*;
import java.util.ArrayList;

public class HiddenRoomFoundCommand implements ActionCommand {

    private ERoomEventAction action;
    private String hiddenRoomFound;

    public HiddenRoomFoundCommand(ERoomEventAction action, String hiddenRoomFound){
        this.action = action;
        this.hiddenRoomFound = hiddenRoomFound;
    }

    public boolean execute() {
        if (action== ERoomEventAction.HIDDENROOM_FOUND)
        {
            ArrayList<String> directions = Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getAllDirections();
            ArrayList<JButton> directionsBtn = Engine.engine.getNavigateWindow().getAllDirectionsBtn();
            for(int i=0; i<directions.size(); ++i){
                if (directions.get(i) != null)
                {
                    if (Engine.engine.getPlayer().getWorld().get(directions.get(i)).isHiddenEvent())
                    {
                        if (directions.get(i)==hiddenRoomFound)
                        {
                            Engine.engine.getPlayer().getWorld().get(directions.get(i)).setHiddenEvent(false);
                            Engine.engine.getPlayer().getWorld().get(directions.get(i)).setHidden(false);
                            Engine.engine.getNavigateWindow().write(Engine.engine.getPlayer().getWorld().get(directions.get(i)).getHiddenDescription()+"\n");
                            directionsBtn.get(i).setEnabled(true);
                        }
                    }
                }
            }
            Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).setRevealed(true);
        }

        return true;
    }
}
