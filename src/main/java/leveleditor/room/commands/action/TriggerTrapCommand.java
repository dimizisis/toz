package leveleditor.room.commands.action;

import battle.Trap;

public class TriggerTrapCommand implements ActionCommand {

    private Trap trap;
    private String trapDesc;

    public TriggerTrapCommand(Trap trap, String trapDesc){
        this.trap = trap;
        this.trapDesc = trapDesc;
    }

    public boolean execute() {
        trap.trigger();
        trap.setTrapdescription(trapDesc);

        return true;
    }
}
