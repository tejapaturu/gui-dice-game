package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class RollHouseListener  implements ActionListener
{
    private GameEngine gameEngine;
    
    public RollHouseListener(GameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Thread rollHouseThread = new Thread(new RollHouseThread(gameEngine));
        rollHouseThread.start();
    }
}

class RollHouseThread implements Runnable
{
    private GameEngine gameEngine;
    
    RollHouseThread(GameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
    }
    
    @Override
    public void run() 
    {
        //If no players are added.
        if (gameEngine.getAllPlayers().size() == 0)
        {
            JOptionPane.showMessageDialog(null, "You need at least one player to play.");
            return;
        }
        
        // Checks if all the players rolled.
        else
        {
            for (Player player : gameEngine.getAllPlayers())
            {
                if (player.getRollResult() == null)
                {
                    JOptionPane.showMessageDialog(null, "All players must roll first before the house rolls.");
                    return;
                }
            }
        }
        gameEngine.rollHouse(0, 300, 10);
    }
}

