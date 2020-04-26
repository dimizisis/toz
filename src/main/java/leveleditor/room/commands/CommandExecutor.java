package leveleditor.room.commands;

import leveleditor.room.ERoomEventAction;
import leveleditor.room.ERoomEventCondition;
import leveleditor.room.RoomEvent;
import leveleditor.room.commands.action.*;
import leveleditor.room.commands.action.HiddenRoomFoundCommand;
import leveleditor.room.commands.condition.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private Map<Enum<?>, Boolean> commandMap = new HashMap<Enum<?>, Boolean>(); /**************************** contains ACTION/CONDITION, COMMAND ****************************/
    private ArrayList<RoomEvent> events;
    int index;

    public CommandExecutor(ArrayList<RoomEvent> events, int index, boolean isEventAction){
        this.events = events;
        this.index = index;

        if (isEventAction)
            putEventActions();
        else
            putEventConditions();

       }

    private void putEventConditions(){
        commandMap.put(ERoomEventCondition.ENEMY_DIED, new leveleditor.room.commands.condition.EnemyDiedCommand(events.get(index).isEnemyDead()).execute());
        commandMap.put(ERoomEventCondition.ITEM_USED, new ItemUsedCommand(events.get(index).isItemused()).execute());
        commandMap.put(ERoomEventCondition.HIDDENROOM_FOUND, new leveleditor.room.commands.condition.HiddenRoomFoundCommand(events.get(index).getHiddenroomfound()).execute());
        commandMap.put(ERoomEventCondition.ITEM_TAKEN, new ItemTakenCommand(events.get(index).isItemtaken()).execute());
        commandMap.put(ERoomEventCondition.ROOM_ENTERED, new RoomEnteredCommand().execute());
        commandMap.put(ERoomEventCondition.ROOM_ENTERED_TWICE, new RoomEnteredTwiceCommand(events.get(index).getRoomenteredtimes()).execute());
//        commandMap.put(ERoomEventCondition.ITEM_GIVEN, new ItemGivenCommand().execute());
    }

    private void putEventActions(){
        commandMap.put(ERoomEventAction.ENEMY_ATTACK, new AttackEnemyCommand(events.get(index).getEnemyattack()).execute());
        commandMap.put(ERoomEventAction.ROOM_DESCRIPTION, new RoomDescCommand(events.get(index).getRoom(), events.get(index).getRoomdescription()).execute());
        commandMap.put(ERoomEventAction.HIDDENROOM_FOUND, new HiddenRoomFoundCommand(events.get(index).getAction(), events.get(index).getHiddenroomfound()).execute());
        commandMap.put(ERoomEventAction.ROOM_PLACEENEMY, new RoomPlaceEnemyCommand(events.get(index).getPlaceenemy(), events.get(index).getRoomdescription()).execute());
        commandMap.put(ERoomEventAction.TRIGGER_TRAP, new TriggerTrapCommand(events.get(index).getTrap(), events.get(index).getTrapdescription()).execute());
        commandMap.put(ERoomEventAction.ADD_ITEM, new AddItemCommand(events.get(index).getReceivedItem()).execute());
        commandMap.put(ERoomEventAction.REMOVE_ENEMY, new RemoveEnemyCommand(events.get(index).getRoom(), events.get(index).getEnemyattack().getName()).execute());
        commandMap.put(ERoomEventAction.REMOVE_NPC, new RemoveNPCCommand(events.get(index).getRoom(), events.get(index).getNpc()).execute());
        commandMap.put(ERoomEventAction.SET_HP_ENEMY, new SetHPEnemyCommand(events.get(index).getRoom(), events.get(index).getEnemyattack().getName(), events.get(index).getHP()).execute());
    }

    public void executeCommand(ERoomEventAction action){
        commandMap.get(action);

    }
    public void executeCommand(ERoomEventCondition condition){
        if (commandMap.get(condition))
            commandMap.get(events.get(index).getAction());
    }

}
