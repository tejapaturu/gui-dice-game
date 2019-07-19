package client;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.*;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */
public class GUI_Test_Client 
{
    public static void main(String[] args) 
    {
        GameEngine gameEngine = new GameEngineImpl();
        gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
        gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(new MainFrame(gameEngine)));
    }
}