import java.util.*;

public class Player implements Playable, Addressable
{
   private Stack< Item > items;
   private Game game;
   private Room currentRoom;
   private boolean swordOfGoremack;
   private Stack< PlayerState > playerStates;
   private String commandOptions;
   private PrimaryGUI gui;
   
   public Player()
   {
       items = new Stack< Item >();
       swordOfGoremack = false;
       playerStates = new Stack< PlayerState > ();
       game = Game.getGame();
       gui = new PrimaryGUI(this);
       gui.startGUI();
       commandOptions = "primary commands";
   }
   
   public Room getCurrentRoom()
   {
       return this.currentRoom;
   }
   
   public void goRoom(String door)
   {
       Room nextRoom = currentRoom.getExit(door);
       playerStates.push(new PlayerState(currentRoom, items));
       currentRoom = nextRoom;
       
       //check if room has a dragon
       if(currentRoom.hasDragon())
       {
           for(Item item : items)
           {
               if( item.getName().equals("sword of goremack") )
               {
                   this.swordOfGoremack = true;
               }
           }
           //you lose the game
           if(!swordOfGoremack)
           {
               game.showLosingText();
               currentRoom = game.restart();
               restartPlayer();
               playerStates.push( new PlayerState(currentRoom, items) );
           }
           //you win the game
           else
           {
               game.showWinningText();
               currentRoom.setDragon(false);
           }
           
           return;
       }
       
       gui.print("\n" + currentRoom.getLongDescription());
   }
   
   public void feelDoor(String door)
   {
       Room nextRoom = currentRoom.getExit(door);
       if(nextRoom.hasDragon())
       {
           gui.print("\nThis door feels warm.");
       }
       else
       {
           gui.print("\nThis door feel normal.\n");
       }
   }
   
   public void restartPlayer()
   {
       items = new Stack< Item >();
   }
   
   public void message(String msg)
   {
       gui.print(msg);
   }
   
   public void play()
   {
       currentRoom = game.start(this);
       if(currentRoom == null)
       {
           return;
       }
        
       playerStates.push( new PlayerState(currentRoom, items) );
   }
   
   public void takeItem()
   {
        if(currentRoom.getItems().empty())
        {
            gui.print("\nNothing to take.\n");
        }
        else
        {
            Item item = currentRoom.takeItem();
            items.push( item );
            gui.print("\nYou have taken the " + item.getDescription() + ".\n");
        }
   }
   
   public void putItem()
   {
       if(items.size() == 0)
       {
            gui.print("\nNothing to put.\n");
       } else {
            Item item = items.pop();
            currentRoom.placeItem(item);
            gui.print("\nYou have put the " + item.getDescription()
            + " in " + currentRoom.getShortDescription() + ".\n");
       } 
   }
   
   public void back()
   {
       if(!playerStates.isEmpty())
       {
            PlayerState previousState = playerStates.pop();
            this.currentRoom = previousState.getCurrentRoom();
            gui.print(currentRoom.getLongDescription());
       } 
       else 
       {
            gui.print("\nYou have nowhere to go back to!");
       }
   }
   
   public void help()
   {
       gui.print("\nDon't forget to feel the doors!\n");
   }
   
   public boolean hasBook(String bookName)
   {
       for(Item i : items)
       {
           if(i.getName() == bookName)
           {
               return true;
           }
       }
       return false;
   }
   
   public boolean carryingBooks()
   {
       HashMap< String, Item > books = new HashMap< String, Item >();
       
       for(Item item : items)
       {
           if( item.getInformation() != "not a book" )
           {
               books.put( item.getName(), item );
           }
       }
       
       if(books.size() == 0)
       {
           gui.print("\nNothing to read.\n");
           return false;
       }
       gui.print("\nChoose a book.\n");
       return true;
   }
   
   public void readBook(String book)
   {
       String information = "";
       for(Item i : items)
       {
           if(i.getName() == book)
           {
               information = i.getInformation();
               gui.print("\n"  + information + "\n");
           }
       }
   }
   
   public String getCommandOptions()
   {
       return commandOptions;
   };
}
