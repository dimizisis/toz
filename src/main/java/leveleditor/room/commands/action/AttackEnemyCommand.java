package leveleditor.room.commands.action;

import engine.Engine;
import leveleditor.actors.Enemy;

public class AttackEnemyCommand implements ActionCommand{

    private Enemy enemy;

    public AttackEnemyCommand(Enemy enemy){
        this.enemy = enemy;
    }

    public boolean execute() {
        try {
            for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().size(); i++) {
                if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().get(i) == enemy) {
                    Engine.engine.attackedBy(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().get(i));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }
}
