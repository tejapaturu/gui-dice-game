package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class AddPlayerListener extends GameEngineImpl implements ActionListener 
{
    private final GameEngine gameEngine;
    private String playerName;
    private String pointsInput;
    
    private int points = 0;
    private int playerCount = 0;

    public AddPlayerListener(GameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
    }

 // Verifies user input for player name and points. Then adds player to the Game Engine if checks are passed
    @Override 
    public void actionPerformed(ActionEvent e) 
    {
        //Verifying user input for player name.
        do 
        {
            this.playerName = JOptionPane.showInputDialog("Please enter player name:");

            if (playerName.trim() == null || playerName.trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid name");
            }
        } 
        while (playerName.trim().equals(""));

        //Verifying user input for player name.
        do 
        {
            points = 0;
            this.pointsInput = JOptionPane.showInputDialog("Please enter initial points:");

            if (pointsInput == null)
            {
                return;
            }

            else
            {
                try 
                {
                    this.points = Integer.parseInt(pointsInput);
                }

                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        }
        while (points == 0);

     // Adds player to the Game Engine
        int initialPlayerCount = 0;
        
        synchronized (gameEngine)
        {
            for (int i = 0; i < gameEngine.getAllPlayers().size(); i++) 
            {
                if (gameEngine.getPlayer("" + i) == null) 
                {
                    initialPlayerCount = i;
                    playerCount = initialPlayerCount;
                    break;
                }
            }
            
            if (initialPlayerCount == 0)
            {
                playerCount = gameEngine.getAllPlayers().size();
            }
            
            gameEngine.addPlayer(new SimplePlayer(Integer.toString(playerCount), this.playerName, this.points));
            JOptionPane.showMessageDialog(null, "Player: " + this.playerName + ", with " + this.points + " points has been added." +
                    "\nCurrent player count is: " + playerCount);
            gameEngine.notifyAll();
        }
    }
}

