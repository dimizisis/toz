package leveleditor.room.commands.action;

import engine.Engine;

public class SetHPEnemyCommand implements ActionCommand {

    private String room;
    private String enemyName;
    private int hp;

    public SetHPEnemyCommand(String room, String enemyName, int hp){
        this.room = room;
        this.enemyName = enemyName;
        this.hp = hp;
    }

    public boolean execute() {
        for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(room).getEnemies().size(); i++)
        {
            if (Engine.engine.getPlayer().getWorld().get(room).getEnemies().get(i).getName()==enemyName)
            {
                if (room==Engine.engine.getPlayer().getCurrentroom())
                {
                    Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().get(i).setInitHp(hp);
                }
                else
                {
                    Engine.engine.getPlayer().getWorld().get(room).getEnemies().get(i).setInitHp(hp);
                }
            }
        }

        return true;
    }
}
