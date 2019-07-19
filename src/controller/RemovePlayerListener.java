package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class RemovePlayerListener  implements ActionListener
{
    private final GameEngine gameEngine;

    public RemovePlayerListener(GameEngine gameEngine) 
    {
        this.gameEngine = gameEngine;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JComboBox<Player> playerList = new JComboBox<>();

        synchronized (gameEngine) 
        {
            // Add all the players who were created.
            for (Player player : gameEngine.getAllPlayers()) 
            {
                playerList.addItem(player);
            }
            
            // If 1 or more players are added, then adds remove function.
            if (playerList.getItemCount() > 0)
            {
                int reply = JOptionPane.showConfirmDialog(null, playerList, "Remove Player?", JOptionPane.YES_NO_OPTION);
               
                if (reply == JOptionPane.YES_OPTION) 
                {
                    Player selectedPlayer = (Player) playerList.getSelectedItem();
                    JOptionPane.showMessageDialog(null, selectedPlayer.getPlayerName() + " has been removed successfully.");
                    gameEngine.removePlayer(selectedPlayer);
                    gameEngine.notifyAll();
                }
            }
            
            // If no players were added.
            else
            {
                JOptionPane.showMessageDialog(null, "There are currently no players to remove from the player list.");
                return;
            }
            gameEngine.notifyAll();
        }
    }
    
}