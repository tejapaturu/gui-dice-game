package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.Player;
import view.MainFrame;
import view.Panel;
import view.StatusBar;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class UpdateDetailsListener implements ActionListener
{
    private JComboBox<Player> playerList;
    private MainFrame mainFrame;

    public UpdateDetailsListener(JComboBox<Player> playerList, MainFrame mainFrame) 
    {
        this.playerList = playerList;
        this.mainFrame = mainFrame;
    }

    // Updates the points of selected player after rolled.
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Player player = (Player) playerList.getSelectedItem();
        print(player);
    }

    public void print(Player player)
    {
        if (player != null) 
        {
            StatusBar statusBar = mainFrame.getStatusBar();
            Panel panel = mainFrame.getPanel();

            if (player.getBet() == 0) 
            {
                statusBar.setStatus("Place your bet");
            }

            else if (player.getRollResult() == null) 
            {
                statusBar.setStatus("Ready to Roll");
            }

            else 
            {
                statusBar.setStatus("Finished Rolling");
            }

            statusBar.setPoints(player.getPoints());
            statusBar.setBet(player.getBet());
            panel.getPlayerDiceValue(player.getRollResult());
        }
    }
}