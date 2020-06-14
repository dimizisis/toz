# Tower of Zaldagor Refactoring

## Description

University project for Software Quality Assurance course.

Three approaches for refactoring the game "Tower of Zaldagor" (3 different branches).

## Code Changes

### Command Pattern

Use of [Command Pattern](https://refactoring.guru/design-patterns/command "Command Pattern - Refactoring.Guru"). Instead of many conditional statements, did the following:

1. Created a Command interface, which contains only a method execute() (without Body)
2. Created 2 interfaces that extend the Command interface: 


*  ActionCommand

*  ConditionCommand

**Each action will be a class that implements ActionCommand**

**Each condtion will be a class tha implements ConditionCommand**

```
A command is an object whose role is to store all the information required for executing an action
```

3. Created a command executor, which contains a commandMap (HashMap). CommandMap has the form of <Key, Command>, where Key in our case is a Condition or an Action (Key is Enum<> Type).

```
commandMap.put(ERoomEventCondition.ENEMY_DIED, new EnemyDiedCommand(events.get(index).isEnemyDead()).execute());
```

```
The CommandExecutor class (aka invoker) is responsible for initiating requests. 
This class must have a field for storing a reference to a command object. 
The CommandExecutor triggers that command instead of sending the request directly to the receiver. 
Note that the sender isn’t responsible for creating the command object. 
Usually, it gets a pre-created command from the client via the constructor.
```

With the application of this pattern, a huge code block has shrunk, since now the work of if ... else has been undertaken by CommandExecutor:

![alt text](https://i.imgur.com/thxeV9c.png "Application of Command Pattern")

### Duplication Issue

Also, in class action.HiddenRoomFoundCommand there was a duplication code, which differed only in a few points (because it had to do with directions at one point it had engine.get (... getNorth ()) ...)), while in another getEast () etc). That's why I added 2 methods to 2 different classes (from the ones that called getNorth (), getSouth (), etc.):

  •	getAllDirections () (sends list with the results of getNorth (), getSouth () ...)

  •	getAllDirectionsBtn () (sends list with getNorth (), getSouth () results ..., but for JButton data)
  
So, as you can see in the following picture the code shrank quite a bit at that point:

![alt text](https://i.imgur.com/Yd9MiXx.png "Duplication Removal")

## Metrics

The metrics refer to the two classes that were modified.

### EventRoom.class

| Name          | WMC  | DIT | NOCC | CBO  | RFC  | LCOM  | WMC                 | DIT | NOCC | RFC  | LCOM  | NOM  | MPC   | DAC | SIZE1 | SIZE2 | DSC | NOH | ANA | DAM | DCC  | CAMC | MOA | MFA | NOP | CIS  | NOM  | Reusability         | Flexibility | Understandability    | Functionality | Extendibility | Effectiveness | FanIn |
|---------------|------|-----|------|------|------|-------|---------------------|-----|------|------|-------|------|-------|-----|-------|-------|-----|-----|-----|-----|------|------|-----|-----|-----|------|------|---------------------|-------------|----------------------|---------------|---------------|---------------|-------|
| Org_EventRoom | 6,0  | 2,0 | 1,0  | 16,0 | 70,0 | 0,0   | 7,42 | 2,0 | 1,0  | 70,0 | 0,0   | 6,0  | 503,0 | 0,0 | 33,0  | 9,0   | 1,0 | 0,0 | 1,0 | 1,0 | 12,0 | 0,2  | 1,0 | 0,0 | 0,0 | 5,0  | 6,0  | 3,04 | 0,8         | -2255,0              | 1,3           | 0,5           | 0,6           | 4,0   |
| Org_Room      | 36,0 | 1,0 | 1,0  | 5,0  | 75,0 | 598,0 | 1,0                 | 1,0 | 1,0  | 75,0 | 598,0 | 36,0 | 5,0   | 0,0 | 132,0 | 55,0  | 1,0 | 1,0 | 0,0 | 1,0 | 0,0  | 0,2  | 0,0 | 0,0 | 0,0 | 36,0 | 36,0 | 1,850 | 0,3         | -11825000000000000,0 | 8,4           | 0,0           | 0,2           | 5,0   |

### Room.class

| Name          | WMC   | DIT  | NOCC | CBO   | RFC   | LCOM   | WMC                  | DIT  | NOCC | RFC   | LCOM   | NOM   | MPC   | DAC  | SIZE1  | SIZE2 | DSC  | NOH  | ANA  | DAM  | DCC  | CAMC | MOA  | MFA  | NOP  | CIS   | NOM   | Reusability         | Flexibility | Understandability     | Functionality       | Extendibility | Effectiveness | FanIn |
|---------------|-------|------|------|-------|-------|--------|----------------------|------|------|-------|--------|-------|-------|------|--------|-------|------|------|------|------|------|------|------|------|------|-------|-------|---------------------|-------------|-----------------------|---------------------|---------------|---------------|-------|
| New_EventRoom | 5,00  | 2,00 | 1,00 | 9,00  | 18,00 | 1,00   | 11666666269302300,00 | 2,00 | 1,00 | 18,00 | 1,00   | 5,00  | 7,00  | 0,00 | 27,00  | 8,00  | 1,00 | 0,00 | 1,00 | 1,00 | 5,00 | 0,20 | 1,00 | 0,00 | 0,00 | 5,00  | 5,00  | 3,05                | 0,75        | -19140000000000000,00 | 1344,00             | 0,50          | 0,60          | 4,00  |
| New_Room      | 37,00 | 1,00 | 1,00 | 12,00 | 79,00 | 635,00 | 1,00                 | 1,00 | 1,00 | 79,00 | 635,00 | 37,00 | 11,00 | 0,00 | 139,00 | 56,00 | 1,00 | 1,00 | 0,00 | 1,00 | 0,00 | 0,16 | 0,00 | 0,00 | 0,00 | 37,00 | 37,00 | 1904054054054050,00 | 0,25        | -12156486486486400,00 | 8599459459459460,00 | 0,00          | 0,20          | 12,00 |


## References:

[Tower of Zaldagor (SourceForge)](https://sourceforge.net/projects/toz/)

[Creator](https://sourceforge.net/u/sarquah/profile/)
