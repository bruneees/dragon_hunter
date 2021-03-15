import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadPanel
{
   private PrimaryGUI gui;

   private JPanel panel = new JPanel();
        
   private JButton goremacksSword = new JButton("GoreMack's Sword");
   private JButton silverDragon = new JButton("The Silver Dragon");
   private JButton harryPotter = new JButton("Harry Potter");
   
   public ReadPanel(PrimaryGUI g)
   {
       this.gui = g;
   }
   
   public JPanel getReadPanel()
   {
        addButtons();
        addButtonListeners();
        return panel;
   }

   public void addButtonListeners()
   {
    goremacksSword.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.player.readBook("goremack's sword");
            gui.primary();
        }
    });
    
    silverDragon.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.player.readBook("silver dragon");
            gui.primary();
        }
    });
    
    harryPotter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.player.readBook("harry potter");
            gui.primary();
        }
    });
   }

   public void addButtons()
   {
        if(gui.player.hasBook("goremack's sword"))
        {
            panel.add(goremacksSword);
        }
        if(gui.player.hasBook("silver dragon"))
        {
            panel.add(silverDragon);
        }
        if(gui.player.hasBook("harry potter"))
        {
            panel.add(harryPotter);
        }
   }
}
