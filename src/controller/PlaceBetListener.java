package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class PlaceBetListener extends GameEngineImpl implements ActionListener 
{   
    private GameEngine gameEngine;
    private MainFrame mainFrame;
    private JComboBox<Player> playerList;
    private String input;

    public PlaceBetListener(GameEngine gameEngine, MainFrame mainFrame, JComboBox<Player> playerList)
    {
        this.gameEngine = gameEngine;
        this.mainFrame = mainFrame;
        this.playerList = playerList;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //gets details of selected players.
        Player player = (Player) playerList.getSelectedItem();

        if (player != null) 
        {
            int bet = 0;

            do 
            {
                // Alerts to place bet
                this.input = JOptionPane.showInputDialog("Please place your bet: ");

                if (input == null) 
                {
                    return;
                }

                try 
                {
                    bet = Integer.parseInt(input);
                } 

                //If an invalid bet is entered
                
                catch(NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                }

                //If bet is more than the available points.
                if (bet > player.getPoints()) 
                {
                    JOptionPane.showMessageDialog(null, "Insufficient points to place bet. Please lower the bet amount or top up points.");
                }
            }
            while(!gameEngine.placeBet(player, bet) || bet == 0);

            mainFrame.getStatusBar().setBet(bet);
            mainFrame.getStatusBar().setStatus("Ready to Roll");
        }
    }
}
