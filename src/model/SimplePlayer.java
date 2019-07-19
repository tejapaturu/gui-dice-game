package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
// This class implements the interface Player
public class SimplePlayer implements Player
{
    private String playerId;        // This stores the unique id given to a player.
    private String playerName;      // This stores name of the player
    private int points;             // This stores available points of a player
    private int bet;                // This stores the amount of points the player has placed a bet.
    private DicePair rollResult;    // This stores the dice roll outcome of the player.

    // Constructor for SimplePlayer, which sets playerId, playerName and points.
    public SimplePlayer(String playerId, String playerName, int initialPoints)
    {
        this.playerId = playerId;
        this.playerName = playerName;
        this.points = initialPoints;
    }

    // Returns playerName.
    @Override
    public String getPlayerName()
    {
        return playerName;
    }

    // Sets playerName.
    @Override
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    // Returns points.
    @Override
    public int getPoints()
    {
        return points;
    }

    // Sets points.
    @Override
    public void setPoints(int points)
    {
        this.points = points;
    }

    // Returns playerId.
    @Override
    public String getPlayerId()
    {
        return playerId;
    }

    // This method places a bet for the player if he has enough points to place it
    // and returns true. If he doesn't have sufficient money, doesn't place the bet
    // and returns false.
    @Override
    public boolean placeBet(int bet)
    {
        if (this.points < bet || bet < 0)
        {
            return false;
        }

        else
        {
            this.bet = bet;
            return true;
        }
    }

    // Returns bet.
    @Override
    public int getBet()
    {
        return bet;
    }

    // Returns rollResult.
    @Override
    public DicePair getRollResult()
    {
        return rollResult;
    }

    // Sets rollResult.
    @Override
    public void setRollResult(DicePair rollResult)
    {
        this.rollResult = rollResult;
    }

    // Returns a string which displays the player id, player name and his points
    // which is used in houseResult and result in GameEngineCallBackupImpl to get the output by
    // the logger.
    @Override
    public String toString()
    {
        return String.format("Player: id=%s, name=%s, points=%d", getPlayerId(), getPlayerName(), getPoints());
    }
}
