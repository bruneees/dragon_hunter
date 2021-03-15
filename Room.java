import java.util.Set;
import java.util.HashMap;
import java.util.*;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "Dragon Hunter" application. 
 * "Dragon Hunter" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * Bruna Nunes, Farzana Mim.
 * @version 2020
 */


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Stack<Item> items;
    private boolean dragon;
    
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new Stack<Item>();
        dragon = false;
    }
    
    public void setDragon(boolean hasDragon)
    {
        this.dragon = hasDragon;
    }
    
    public boolean hasDragon()
    {
        return this.dragon;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }
    
    public Stack < Item > getItems()
    {
        return items;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String output = "";
        output += "\nYou are in " + description + "." ; /* + ".\n" + getExitString() */;
        output += "\n" + getItemListString() + "\n";
        return output;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " | " + exit;
        }
        return  returnString + " |";
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public void placeItem(Item item)
    {
        items.push(item);
    }
    
    public Item takeItem()
    {
        if(!items.empty())
        {
            return items.pop();
        }
        return null;
    }
    
    
    public String getItemListString()
    {
        String output = "";
        
        if(items.empty())
        {
            output = "This room is empty.";
            return output;
        }else{   
            output = "Room Items: | ";
            for(Item item :items)
            {
                output += item.getDescription() + " | ";
            }
        }
        
        return output;
    }
    
    
    public boolean hasNorthDoor()
   {
       if (getExit("north door") == null)
       {
           return false;
       } else {
           return true;
       }
   }
   
   public boolean hasSouthDoor()
   {
       if (getExit("south door") == null)
       {
           return false;
       } else {
           return true;
       }
   }
   
   public boolean hasEastDoor()
   {
       if (getExit("east door") == null)
       {
           return false;
       } else {
           return true;
       }
   }
   
   public boolean hasWestDoor()
   {
       if (getExit("west door") == null)
       {
           return false;
       } else {
           return true;
       }
   }
}

