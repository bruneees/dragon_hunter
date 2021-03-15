

/**
 * This class holds the information for items used by class Game, Room and PlayerState.
 *Such as: the name of the item, its description and its information(for books).
 *
 * @author Bruna Nunes, Farzana Mim
 * @version 2020
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private String information;
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description)
    {
        // initialise instance variables
        this.name = name; 
        this.description = description;
        this.information = "not a book";
    }
    
    public String getName()
    {
       return this.name;
    }
    
    public String getDescription()
    {
       return this.description;
    }
    
    public String getInformation()
    {
        return this.information;
    }
    
    public void setInformation(String information)
    {
       this.information = information;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
