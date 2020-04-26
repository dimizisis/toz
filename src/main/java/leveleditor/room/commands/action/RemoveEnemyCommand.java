package leveleditor.room.commands.action;

import engine.Engine;

public class RemoveEnemyCommand implements ActionCommand {

    private String room;
    private String enemyName;

    public RemoveEnemyCommand(String room, String enemyName){
        this.room = room;
        this.enemyName = enemyName;
    }

    public boolean execute() {
        for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(room).getEnemies().size(); i++)
        {
            if (Engine.engine.getPlayer().getWorld().get(room).getEnemies().get(i).getName()==enemyName)
            {
                Engine.engine.getPlayer().getWorld().get(room).getEnemies().remove(i);
            }
        }

        return true;
    }
}
