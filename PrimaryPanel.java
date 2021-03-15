import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PrimaryPanel
{
    private PrimaryGUI gui;
    private JPanel panel = new JPanel();
        
    private JButton open = new JButton("open");
    private JButton feel = new JButton("feel");
    private JButton take = new JButton("take");
    private JButton put  = new JButton("put");
    private JButton read = new JButton("read");
    private JButton back = new JButton("back");
    private JButton help = new JButton("help");
    private JButton quit = new JButton("quit");
    private JButton clear = new JButton("clear text");

    public PrimaryPanel(PrimaryGUI gui)
    {
        this.gui = gui;
    }
    
    public JPanel getPrimaryPanel()
    {
        addButtonsToPanel();
        setButtonListeners();
        return panel;
    }

    public void setButtonListeners()
    {
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.open("\nChoose a door.");
            }
        });
        
        feel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.feel("\nChoose a door.");
            }
        });
        
        take.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.player.takeItem();
            }
        });
        
        put.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.player.putItem();
            }
        });
        
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.read();
            }
        });
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.player.back();
            }
        });
        
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.player.help();
            }
        });
        
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.quit();
            }
        });
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.textArea.setText(null);
            }
        });
    }

    public void addButtonsToPanel()
    {
        panel.add(open);
        panel.add(feel);
        panel.add(take);
        panel.add(put);
        panel.add(read);
        panel.add(back);
        panel.add(help);
        panel.add(quit);
        panel.add(clear);
    }
}
