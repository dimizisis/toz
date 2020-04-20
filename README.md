# Tower of Zaldagor Refactoring

## Description

University project for Software Quality course.

Three approaches for refactoring the game "Tower of Zaldagor" (3 different branches).

## Code Changes

Use of [Command Pattern](https://refactoring.guru/design-patterns/command "Command Pattern - Refactoring.Guru"). Instead of many conditional statements, we define a Handler (one in our case), which based on a specific value executes a specific command (code segment), through its handle() method.
Therefore, each command corresponds to a value. We achieve this by using a HashMap command. CommandMap takes the form of <Key, Handler>, where Key in our case is a Condition or an Action. This is how command-value registration is done:

```
commandMap.put(ERoomEventCondition.ITEM_USED, new EventHandler() {
   public void handle(int index) {
      if (events.get(index).isItemused())
         evaluateAction(index);
   }
});
```

With the application of this pattern, a huge code block has shrunk, since now the work of if ... else has been undertaken by EventHandler:

![alt text](https://i.imgur.com/4V5PBe4.png "Application of Command Pattern")

Also, in the same class (EventRoom) there was a duplication code, which differed only in a few points (because it had to do with directions at one point it had engine.get (... getNorth ()) ...)), while in another getEast () etc). That's why I added 2 methods to 2 different classes (from the ones that called getNorth (), getSouth (), etc.):

  •	getAllDirections () (sends list with the results of getNorth (), getSouth () ...)

  •	getAllDirectionsBtn () (sends list with getNorth (), getSouth () results ..., but for JButton data)
  
So, as you can see in the following picture the code shrank quite a bit at that point:

![alt text](https://i.imgur.com/vKlP8pF.png "Duplication Removal")

## Metrics

The metrics refer to the two classes that were modified.

### EventRoom.class

|                  | WMC | DIT | NOC | CBO | RFC | LCOM |  Ce | NPM |
|------------------|:---:|:---:|:---:|:---:|:---:|:----:|:---:|:---:|
|```Initial Code```|  7  |  0  |  1  |  12 |  64 |   0  |  1  |  6  |
|  ```New Code```  | 12  |  0  |  1  |  21 |  38 |  20  |  1  |  6  |

### Room.class

|                  |  WMC | DIT | NOC | CBO | RFC | LCOM |  Ce |  NPM |
|------------------|:----:|:---:|:---:|:---:|:---:|:----:|:---:|:----:|
|```Initial Code```|  37  |  1  |  1  |  0  |  39 |  598 |  1  |  37  |
|  ```New Code```  |  38  |  1  |  1  |  0  |  42 |  695 |  1  |  38  |


## References:

[Tower of Zaldagor (SourceForge)](https://sourceforge.net/projects/toz/)

[Creator](https://sourceforge.net/u/sarquah/profile/)
