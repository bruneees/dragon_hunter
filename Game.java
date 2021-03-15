
 
import java.util.*;
/**
*  This class is the main class of the "Dragon Hunter" application. 
*  "Dragon Hunter" is a very simple, text based adventure game.  Users 
*  can walk around some scenery. That's all. It should really be extended 
*  to make it more interesting!
* 
*  To play this game, create an instance of this class and call the "play"
*  method.
* 
*  This main class creates and initialises all the others: it creates all
*  rooms, creates the parser and starts the game.  It also evaluates and
*  executes the commands that the parser returns.
* 
* @author  Michael Kölling and David J. Barnes, Bruna Nunes, Farzana Mim
* @version 2020
*/

public class Game 
{
    private Room startRoom;
    private static Game game;
    private Addressable player;
   
    public Game() 
    {
        createGame();     
    }
    
    public static Game getGame()
    {
        if(game == null)
        {
            game = new Game();
        }
        return game;
    }
    
    private void createGame()
    {
        createRooms();
    }
    
    private void createRooms()
    {
        Room hall, livingRoom, queenBedroom, kingBedroom, diningRoom, ballroom, kitchen, library, princeBedroom;
      
        // create the rooms
        hall = new Room("the hall room");
        livingRoom = new Room("the living room");
        queenBedroom = new Room("the queen's bedroom");
        kingBedroom = new Room("the king's bedroom");
        diningRoom = new Room("the dining room");
        ballroom = new Room("the ballroom");
        kitchen = new Room("the kitchen");
        library = new Room("the library");
        princeBedroom = new Room("the prince's bedroom");
       
        // initialise room exits
        hall.setExit("north door", livingRoom);
        
        //living room
        livingRoom.setExit("west door", library);
        livingRoom.setExit("east door", princeBedroom);
        livingRoom.setExit("north door", queenBedroom);
        livingRoom.setExit("south door", hall);
        
        //library
        library.setExit("east door", livingRoom);
        library.setExit("north door", kingBedroom);
        Item bookOfDragon = new Item("silver dragon", "Book: The Silver Dragon");
        bookOfDragon.setInformation("The Silver Dragon, this beast has been an enemy of the kingdom for many years.\n" + 
        "It hates the royal family out of jealousy, it too wishes to be wealty and important.\n" + 
        "This monster has notoriously thick scales which can only be pierced by \nThe Sword of Goremack.");
        library.placeItem(bookOfDragon);
        Item harryPotter = new Item("harry potter", "Book: Harry Potter and the Prisioner of Askaban");
        harryPotter.setInformation("You sit in the corner and read an entire Harry Potter book.\n"+
        "It takes 12 hours, the prince is fine but hurry.");
        library.placeItem(harryPotter);
        
        //king's bedroom
        kingBedroom.setExit("west door", ballroom);
        kingBedroom.setExit("east door", queenBedroom);
        kingBedroom.setExit("south door", library);
        kingBedroom.setDragon(true);
        
        //prince's bedroom
        princeBedroom.setExit("west door", livingRoom);
        princeBedroom.setExit("north door", diningRoom);
        Item princeSword = new Item("sword of prince", "Prince's Sword");
        princeBedroom.placeItem( princeSword );
        
        //queen's bedroom
        queenBedroom.setExit("west door", kingBedroom);
        queenBedroom.setExit("east door", diningRoom);
        queenBedroom.setExit("south door", livingRoom);
        
        //ballroom
        ballroom.setExit("east door", kingBedroom);
        
        //dining room
        diningRoom.setExit("west door", queenBedroom);
        diningRoom.setExit("east door", kitchen);
        diningRoom.setExit("south door", princeBedroom);
        
        //kitchen
        kitchen.setExit("west door", diningRoom);
        Item goremackSword = new Item("sword of goremack","Sword of Goremack");
        kitchen.placeItem( goremackSword );
        Item bookOfGoremack = new Item("goremack's sword", "Book: The Sword of Goremack");
        bookOfGoremack.setInformation("The Sword of Goremack, it has existed for ten thousand years." +
        " \nForged by the legendary warrior Goremack, it has been \nused to slay all sorts of diferent monsters." +
        " \nLegend says only the worthy can wield it.");
        kitchen.placeItem( bookOfGoremack );
        
        startRoom = hall; //start in the main hall

    }

    private void printWelcome()
    {
        player.message("\nWelcome to the Dragon Hunter!");
        player.message("\nYou are a warrior princess and you have been sent into a castle\n" + 
        "to kill the dragon that's keeping the prince hostage. The dragon is hiding in one of\n" + 
        "the rooms of the castle and carrying the scared prince with him wrapped around his tail.\n" + 
        "Good Luck!");
        player.message("\n\nClick 'help' if you need help.");
        player.message("\n");
        player.message(startRoom.getLongDescription());
        
    }
    
    public Room start(Addressable player)
    {
        if(this.player == null)
        {
            this.player = player;
            printWelcome();
            return startRoom;
        }
        else  
        {
            player.message("You have already started the game!");
            return null;
        }
    }
    
    public void showLosingText()
    {
        player.message("\nYou encounter a fire breathing dragon!\n"+
        "The beast shoots fire at you. You are dead. Game Over.\n");
    }
    
    public void showWinningText()
    {
        player.message("\nYou encounter a fire breathing dragon!\n" +
        "The beast speaks.\n\n" + 
        "Silver Dragon: Why have you come here?\n\n" +
        "Warrior Princess: I've come to kill you dragon.\n\n" +
        "Silver Dragon: Hahahahahaha, many have tried, all met a fiery grave.\n\n" +
        "Prince: Help me!\n\n" +
        "You pull out the Sword of Goremack.\n\n" +
        "Silver Dragon: What? No! Impossible!\n\n" + 
        "Prince: I have no ideia what's going on.\n\n" +
        "Warrior Princess: Prepare to die!\n\n" +
        "An epic battle soon ensued, oh man, if only you could see it,\n" +
        "such an awesome freaking battle, wow. You killed the dragon, saved the day.\n" +
        "Congratulations, the prince is saved, you are a true hero.\n\n" + 
        "\nYour quest is over but feel free to walk around the castle." );
    }
    
    public Room restart()
    {
        createGame();
        printWelcome();
        return startRoom;
    }
    
    
}
