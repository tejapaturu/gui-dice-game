package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import controller.PlaceBetListener;
import controller.RollPlayerListener;
import controller.SelectPlayerListener;
import controller.UpdateDetailsListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;
/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-    Sri Sai Teja Paturu 
 * Student id:- s3644335
 */

@SuppressWarnings("serial")
public class ToolBar extends JToolBar
{
    
    private GameEngine gameEngine;
    private JComboBox<Player> playerList;

    ToolBar(GameEngine gameEngine, MainFrame mainFrame) 
    {
        this.gameEngine = gameEngine;

        mainFrame.setName("Tool Bar");
        setRollover(true);

        // Produces combo box where added players can be selected and functions can be performed.
        playerList = new JComboBox<>();
        playerList.addActionListener(new UpdateDetailsListener(playerList, mainFrame));
        add(playerList);

        Thread playerListThread = new Thread((new SelectPlayerListener(gameEngine, playerList)));
        playerListThread.start();

        // Creates button to Place Bet
        JButton betButton = new JButton("Place Bet");
        betButton.addActionListener(new PlaceBetListener(gameEngine, mainFrame, playerList));
        add(betButton);

        // Creates button to Roll the selected Player
        JButton rollButton = new JButton("Roll Selected Player");
        rollButton.addActionListener(new RollPlayerListener(gameEngine, playerList));
        add(rollButton);
    }
    
    public GameEngine getGameEngine() 
        {
            return gameEngine;
        }
        
    public JComboBox<Player> getPlayerList() 
        {
            return playerList;
        }

}
