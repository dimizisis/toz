package leveleditor.room.commands.condition;

public class EnemyDiedCommand implements ConditionCommand {

    private boolean isEnemyDead;

    public EnemyDiedCommand(boolean isEnemyDead){
        this.isEnemyDead = isEnemyDead;
    }

    public boolean execute() {
        return isEnemyDead;
    }
}
