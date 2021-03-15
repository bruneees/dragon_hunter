
public interface Playable
{
    
    void goRoom(String s);
    
    void feelDoor(String s);
    
    void takeItem();
    
    void putItem();

    void readBook(String s);
    
    boolean carryingBooks();
    
    boolean hasBook(String s);
    
    Room getCurrentRoom();
    
    void back();
    
    void help();
    
    String getCommandOptions();
    
}
