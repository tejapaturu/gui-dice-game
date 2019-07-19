package view;


import controller.UpdateDetailsListener;
import model.interfaces.*;
import view.MainFrame;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-    Sri Sai Teja Paturu 
 * Student id:- s3644335
 */

@SuppressWarnings("serial")
public class GameEngineCallbackGUI implements GameEngineCallback 
{
    private MainFrame mainFrame;

    public GameEngineCallbackGUI(MainFrame mainFrame) 
    {
        this.mainFrame = mainFrame;
    }

    @Override // Shows Player's dice rolling with delay
    public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) 
    {
        if (mainFrame.getToolBar().getPlayerList().getSelectedItem() == player) 
        {
            mainFrame.getStatusBar().setStatus("Rolling...");
            mainFrame.getPanel().getPlayerDiceValue(dicePair);
        }
    }

    @Override
    public void result(Player player, DicePair result, GameEngine gameEngine) 
    {
        if (mainFrame.getToolBar().getPlayerList().getSelectedItem() == player) 
        {
            mainFrame.getStatusBar().setStatus("Finished Rolling");
            mainFrame.getPanel().getPlayerDiceValue(result);
        }
    }

    @Override // Shows House's dice rolling with delay
    public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) 
    {
        mainFrame.getStatusBar().getHouseStatusBar().setHouseStatus("Rolling...");
        mainFrame.getPanel().getHouseDiceRoll(dicePair);
    }

    // Updates the player points after house finishes rolling
    @Override
    public void houseResult(DicePair result, GameEngine gameEngine) 
    {
        mainFrame.getStatusBar().getHouseStatusBar().setHouseStatus("Waiting for players to place bet and roll...");
        mainFrame.getPanel().getHouseDiceRoll(result);
        new UpdateDetailsListener(mainFrame.getToolBar().getPlayerList(),mainFrame).print((Player) mainFrame.getToolBar().getPlayerList().getSelectedItem());
        synchronized (gameEngine) 
        {
            gameEngine.notifyAll();
        }
    }
}

