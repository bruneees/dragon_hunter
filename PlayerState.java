import java.util.*;
/** this Class behaves like a "Save state" of the current room and items
 * for the player(class Game).
 * Necessary for the method Back().
 * Write a description of class PlayerState here.
 *
 * @author Bruna Nunes, Farzana Mim
 * @version 2020
 */
public class PlayerState
{
    // instance variables - replace the example below with your own
    private Room currentRoom;
    private Stack< Item > items;
    
    /**
     * Constructor for objects of class PlayerState
     */
    public PlayerState(Room currentRoom,Stack< Item > items)
    {
        this.currentRoom = currentRoom;
        this.items = items;
    }
    
    public Room getCurrentRoom()
    {
        return this.currentRoom;
    }
    
    public Stack< Item > getItems()
    {
        return this.items;
    }
    

}
