package controller;

import javax.swing.JComboBox;

import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class SelectPlayerListener  implements Runnable
{
    private final GameEngine gameEngine;
    private JComboBox<Player> playerList;

    public SelectPlayerListener(GameEngine gameEngine, JComboBox<Player> playerList) 
    {
        this.gameEngine = gameEngine;
        this.playerList = playerList;
    }

    @Override
    public void run() 
    {
        while (true)
        {
            synchronized (gameEngine) 
            {
                // Updates player list when new players are added
                for (Player player : gameEngine.getAllPlayers()) 
                {
                    boolean newPlayer = true;
                    for (int i = 0; i < playerList.getItemCount(); i++) 
                    {
                        Player selectedItem = playerList.getItemAt(i);
                        if (player == selectedItem) 
                        {
                            newPlayer = false;
                            break;
                        }
                    }
                    if (newPlayer) 
                    {
                        playerList.addItem(player);
                    }
                }

                // Updates player list when new players are removed
                for (int i = 0; i < playerList.getItemCount(); i++) 
                {
                    boolean playerRemoved = true;
                    Player selectedItem = playerList.getItemAt(i);
                    for (Player player : gameEngine.getAllPlayers()) 
                    {
                        if (player == selectedItem) 
                        {
                            playerRemoved = false;
                            break;
                        }
                    }

                    if (playerRemoved) 
                    {
                        playerList.removeItem(selectedItem);
                    }
                }

                try 
                {
                    gameEngine.wait();
                }

                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
}


