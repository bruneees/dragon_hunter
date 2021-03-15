import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoorActionPanel
{
   private PrimaryGUI gui;
   private String action;
   private JPanel panel = new JPanel();
   private JButton north = new JButton("north door");
   private JButton south = new JButton("south door");
   private JButton east = new JButton("east door");
   private JButton west  = new JButton("west door");

   public DoorActionPanel(PrimaryGUI gui, String action)
   {
       this.gui = gui;
       this.action = action;
   }
   
   public JPanel getDoorActionPanel()
   {
        addDoorListeners();
        checkExistingDoors();
        return panel;
   }

   public void doorAction(String door, String action)
   {
        if (action.equals("feel"))
        {
            gui.player.feelDoor(door);
        } 
        else if (action.equals("open"))
        {
            gui.player.goRoom(door);
        }

        gui.primary();
   }

   public void checkExistingDoors()
   {
        if(gui.player.getCurrentRoom().hasNorthDoor())
        {
            panel.add(north);
        }
        if(gui.player.getCurrentRoom().hasSouthDoor())
        {
            panel.add(south);
        }
        if(gui.player.getCurrentRoom().hasEastDoor())
        {
            panel.add(east);
        }
        if(gui.player.getCurrentRoom().hasWestDoor())
        {
            panel.add(west);
        }
   }

   public void addDoorListeners()
   {
    north.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            doorAction("north door", action);
        }
    });
    
    south.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            doorAction("south door", action);
        }
    });
    
    east.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            doorAction("east door", action);
        }
    });
    
    west.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            doorAction("west door", action);
        }
    });
   }
}
