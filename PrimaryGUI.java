import java.awt.BorderLayout;
import javax.swing.*;

public class PrimaryGUI{
    
  private JFrame frame;
  public JTextArea textArea;
  private JPanel panel;
  public Playable player;
  
  public PrimaryGUI(Player player)
  {
    frame = new JFrame("Dragon Hunter");
    frame.setSize(700, 700);
    frame.setLocation(0, 0);
    textArea = new JTextArea(10, 40);
    frame.getContentPane().add(BorderLayout.CENTER, textArea);
    this.player = player;
  }
 
  public void showMainPanel()
  {
      frame.dispose();
  }
  
  public void startGUI() 
  {
     panel = new PrimaryPanel(this).getPrimaryPanel();
     frame.getContentPane().add(BorderLayout.SOUTH, panel); 
     frame.setVisible(true);
  }
  
  public void print(String msg)
  {
      textArea.append(msg);
  }
  
  public void primary()
  {
      frame.getContentPane().remove(panel);
      panel = new PrimaryPanel(this).getPrimaryPanel();
      frame.getContentPane().add(BorderLayout.SOUTH, panel);
  }
  
  public void open(String msg)
  {
      textArea.append(msg);
      frame.getContentPane().remove(panel);
      panel = new DoorActionPanel(this,"open").getDoorActionPanel();
      frame.getContentPane().add(BorderLayout.SOUTH, panel);
  }
  
  public void feel(String msg)
  {
      textArea.append(msg);
      frame.getContentPane().remove(panel);
      panel = new DoorActionPanel(this,"feel").getDoorActionPanel();
      frame.getContentPane().add(BorderLayout.SOUTH, panel);
  }
  
  public void read()
  {   
      if(player.carryingBooks())
      {
          frame.getContentPane().remove(panel);
          panel = new ReadPanel(this).getReadPanel();
          frame.getContentPane().add(BorderLayout.SOUTH, panel);
      }
  }
  
  public void quit()
  {
      frame.dispose();
  }
  

}