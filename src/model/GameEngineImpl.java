package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */

// This class implements the interface GameEngine
public class GameEngineImpl implements GameEngine
{
    // The default size of a casino die.
    private static int NUM_FACES = 6;

    // Creating an arraylist of GameEngineCallbacks which is used to add, remove and
    // loop through all the gameEngineCallbackups that were added.
    private ArrayList<GameEngineCallback> gameEngineCallbackList = new ArrayList<GameEngineCallback>();
    private int gameEngineCallbackListCount = 0; // Keeps a count of the gameEngineCallBackups in the array list to be
                                                 // used in loops.

    // Creating an arraylist of GameEngineCallbacks which is used to add, remove and
    // loop through all the gameEngineCallbackups that were added.
    private ArrayList<Player> players = new ArrayList<Player>();
    private int playerCount = 0; // Keeps a count of the players in the array list to be used in loops.

    // Used to place bet for individual players.
    @Override
    public boolean placeBet(Player player, int bet)
    {
        return player.placeBet(bet);
    }

    // Rolls die and calculates result for individual player with the appropriate
    // delay calculated by the parameters. The delay starts from initialDelay and
    // goes until the finalDelay with incrementing each time by the dealyIncrement.
    @Override
    public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement)
    {
        Roller(player, initialDelay, finalDelay, delayIncrement);
    }

    // Same as rollPlayer, but calculates results for the house.
    @Override
    public void rollHouse(int initialDelay, int finalDelay, int delayIncrement)
    {
        Roller(null, initialDelay, finalDelay, delayIncrement);
    }

    // Adds player to the players array list.
    @Override
    public void addPlayer(Player player)
    {
        players.add(playerCount, player);
        playerCount++;
    }

    // Retrieves a player from players array list by their id.
    @Override
    public Player getPlayer(String id)
    {
        for (int i = (playerCount - 1); i >= 0; i--)
        {
            if (id.equals((players.get(i)).getPlayerId()))
            {
                return players.get(i);
            }
        }
        return null;
    }

    // Removes the given player from the players array list. Returns true if the
    // player is found and removed. Returns false if the player is not in the array
    // list.
    @Override
    public boolean removePlayer(Player player)
    {
//        String playerId = player.getPlayerId();
//
//        for (int i = (playerCount - 1); i >= 0; i--)
//        {
//            if (playerId.equals((players.get(i)).getPlayerId()))
//            {
//                players.remove(i);
//                return true;
//            }
//        }
//        return false;
        return players.remove(player);
    }

    // Adds gameEngineCallback to the GameEngineCallbackList array list.
    @Override
    public void addGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
        gameEngineCallbackList.add(gameEngineCallbackListCount, gameEngineCallback);
        gameEngineCallbackListCount++;
    }

    // Removes the given gameEngineCallback from the GameEngineCallbackList array
    // list. Returns true if the gameEngineCallback is found and removed. Returns
    // false if the gameEngineCallback is not in the array list.
    @Override
    public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback)
    {
//        for (int i = (gameEngineCallbackListCount - 1); i >= 0; i--)
//        {
//            if (gameEngineCallback.equals(gameEngineCallbackList.get(i)))
//            {
//                players.remove(i);
//                return true;
//            }
//        }
//        return false;
        return gameEngineCallbackList.remove(gameEngineCallback);
    }

    // Return the players array list.
    @Override
    public Collection<Player> getAllPlayers()
    {
        return Collections.unmodifiableCollection(players);
    }

    // This helper method is used to create a random die, used by Roller for
    // rollPlayer and rollHouse.
    private DicePair getRandomDice()
    {
        Random random = new Random();

        int n1 = random.nextInt(6) + 1; // gets a pseudo random number ranging from 1 to 6.
        int n2 = random.nextInt(6) + 1; // gets a pseudo random number ranging from 1 to 6.

        DicePair dicePair = new DicePairImpl(n1, n2, NUM_FACES); // new die with random dice1 and dice2 are created.
        return dicePair;
    }

    // This helper method does everything for rollPlayer and rollHouse.
    private void Roller(Player player, int initialDelay, int finalDelay, int delayIncrement)
    {
        // The delay starts from initialDelay increments until finalDelay by increasing
        // each time by delayIncrement.
        for (int i = initialDelay; i < finalDelay; i += delayIncrement)
        {
            try
            {
                // Causes delay.
                Thread.sleep(i);
            } catch (InterruptedException e)
            {
                // it is empty since GameEngine should'nt print anything.
            }
            
            // Goes though all gameENgineCallbacks.
            for (GameEngineCallback gameEngineCallback : gameEngineCallbackList)
            {
                // create a random dicePair
                DicePair dicepair = getRandomDice();
               

                // If player is null calls intermediateHouseResult or calls intermediateResult.
                if (player == null)
                {
                    gameEngineCallback.intermediateHouseResult(dicepair, this);
                } else
                {
                    gameEngineCallback.intermediateResult(player, dicepair, this);
                }
            }
        }
       
        try
        {
            // Causes delay.
            Thread.sleep(finalDelay);
        } catch (InterruptedException e)
        {
            // it is empty since GameEngine should'nt print anything.
        }
        
        // create another random dicePair for the final result.
        DicePair dicepair = getRandomDice();

        // Goes though all gameENgineCallbacks.
        for (GameEngineCallback gameEngineCallback : gameEngineCallbackList)
        {
            
            
            // If player is null calls houseResult or calls result and sets player result.
            if (player == null)
            {
                gameEngineCallback.houseResult(dicepair, this);
            } else
            {
                gameEngineCallback.result(player, dicepair, this);
                player.setRollResult(dicepair);
            }
        }

    }
}
