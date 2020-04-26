package leveleditor.room.commands.action;

import engine.Engine;
import leveleditor.actors.Enemy;

public class RoomPlaceEnemyCommand implements ActionCommand{

    Enemy enemy;
    String roomDesc;

    public RoomPlaceEnemyCommand(Enemy enemy, String roomDesc){
        this.enemy = enemy;
        this.roomDesc = roomDesc;
    }

    public boolean execute() {
        Engine.engine.getNavigateWindow().write(roomDesc+"\n");
        Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().add(enemy);
        Engine.engine.getNavigateWindow().getAttack().setEnabled(true);

        return true;
    }
}
