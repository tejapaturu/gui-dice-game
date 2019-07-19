package view;

import java.util.Collection;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-    Sri Sai Teja Paturu 
 * Student id:- s3644335
 */



// This class implements the interface GameEngineCallback
public class GameEngineCallbackImpl implements GameEngineCallback
{
    private Logger logger = Logger.getLogger("assignment1");

    public GameEngineCallbackImpl()
    {
        // FINE shows rolling output, INFO shows the final result
        logger.setLevel(Level.FINE);

        // consoleHandleris used to output level.FINE to console
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
    }

    // Shows the output while the dice are rolling for the player.
    @Override
    public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
    {
        String s = String.format("%s: ROLLING %s", player.getPlayerName(), dicePair.toString());
        // intermediate results logged at Level.FINE
        logger.log(Level.FINE, s);
    }

    // Shows the output after the dice have finished rolling for the player.
    @Override
    public void result(Player player, DicePair result, GameEngine gameEngine)
    {
        String s = String.format("%s: *RESULT* %s", player.getPlayerName(), result.toString());
        // final results logged at Level.INFO
        logger.log(Level.INFO, s);
    }

    // Shows the output while the dice are rolling for the house.
    @Override
    public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine)
    {
        String s = String.format("House: ROLLING %s", dicePair.toString());

        // intermediate results logged at Level.FINE
        logger.log(Level.FINE, s);

    }

    // Shows the output after the dice have finished rolling for the house and
    // calculates the bets by the players and displays their info.
    @Override
    public void houseResult(DicePair result, GameEngine gameEngine)
    {
        String s = String.format("House: *RESULT* %s", result.toString());
        // final results logged at Level.INFO
        logger.log(Level.INFO, s);

        // getting all players from gameEngine.
        Collection<Player> players = gameEngine.getAllPlayers();

        // Calculating result for each player.
        for (Player Player : players)
        {

            // calculating the bet

            int houseDiceResult = (result.getDice1() + result.getDice2()); // The total die outcome of the house
            int playerDiceResult = (Player.getRollResult().getDice1() + Player.getRollResult().getDice2()); // The total
                                                                                                            // die
                                                                                                            // outcome
                                                                                                            // of the
                                                                                                            // player

            int playerInitialPoints = Player.getPoints(); // Getting player's current points.
            int playerBet = Player.getBet(); // Getting the amount of points the player has used for betting.

            // final Player points after the result. It is initialized as the same points of
            // the player due to a case of a draw it doesn't get changed.
            int finalPlayerpoints = playerInitialPoints;

            // if player wins, points are added.
            if (playerDiceResult > houseDiceResult)
            {
                finalPlayerpoints = playerInitialPoints + playerBet;
            }

            // If player looses, points are deducted.
            else if (playerDiceResult < houseDiceResult)
            {
                finalPlayerpoints = playerInitialPoints - playerBet;
            }

            // finalPoints are set.
            Player.setPoints(finalPlayerpoints);

            logger.log(Level.INFO, Player.toString()); // Info about the players is displayed.
        }
    }
}
