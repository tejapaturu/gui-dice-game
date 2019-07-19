package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class RollPlayerListener  implements ActionListener
{
    private GameEngine gameEngine;
    private JComboBox<Player> playerList;

    public RollPlayerListener(GameEngine gameEngine, JComboBox<Player> playerList)
    {
        this.gameEngine = gameEngine;
        this.playerList = playerList;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // Gets details from selevted player.
        Player player = (Player) playerList.getSelectedItem();


        
        if (player != null)
        {
            // Checks if players placed bets before rolling.
            if (player.getBet() == 0)
            {
                JOptionPane.showMessageDialog(null, "Please place a bet before rolling.");
                return;
            }

            // A new thread is created to roll the dice for player.
            Thread rollPlayerThread = new Thread(new rollPlayerThread(gameEngine, player));
            rollPlayerThread.start();
        }
    }
}

class rollPlayerThread implements Runnable
{
    private GameEngine gameEngine;
    private Player player;

    rollPlayerThread(GameEngine gameEngine, Player player)
    {
        this.gameEngine = gameEngine;
        this.player = player;
    }

    @Override
    public void run() 
    {
        gameEngine.rollPlayer(player, 0, 300, 10);
    }
}
