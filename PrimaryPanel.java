import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PrimaryPanel
{
    private PrimaryGUI gui;
    public PrimaryPanel(PrimaryGUI gui)
    {
        this.gui = gui;
    }
    
    public JPanel getPrimaryPanel()
    {
        JPanel panel = new JPanel();
        
        JButton open = new JButton("open");
        JButton feel = new JButton("feel");
        JButton take = new JButton("take");
        JButton put  = new JButton("put");
        JButton read = new JButton("read");
        JButton back = new JButton("back");
        JButton help = new JButton("help");
        JButton quit = new JButton("quit");
        JButton clear = new JButton("clear text");
        
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
        
        panel.add(open);
        panel.add(feel);
        panel.add(take);
        panel.add(put);
        panel.add(read);
        panel.add(back);
        panel.add(help);
        panel.add(quit);
        panel.add(clear);
        
        return panel;
    }
}
