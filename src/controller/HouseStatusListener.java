package controller;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class HouseStatusListener implements Runnable 
{

    private MainFrame mainFrame;
    private final GameEngine gameEngine;

    public HouseStatusListener(GameEngine gameEngine, MainFrame mainFrame) 
    {
        this.gameEngine = gameEngine;
        this.mainFrame = mainFrame;
    }

    @Override 
    // Updates House status
  public void run() 
   {
      while (true) 
       {
            boolean status = true;
          
            synchronized (gameEngine) 
           {
               //Checks if all the added players have rolled and displays message accordingly.
                for (Player player : gameEngine.getAllPlayers()) 
                {
                    if (player.getRollResult() == null) 
                    {
                        status = false;
                        mainFrame.getStatusBar().getHouseStatusBar().setHouseStatus("Waiting for all players to roll...");
                        break;
                    }
                }

                //If all the players that have been added have place bets and rolled then it is true.
           if (status) 
            {
                  mainFrame.getStatusBar().getHouseStatusBar().setHouseStatus("House is ready to roll");
                    
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
}
