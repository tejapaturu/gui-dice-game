package view;

import java.awt.*;

import javax.swing.*;

import model.interfaces.GameEngine;
/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-    Sri Sai Teja Paturu 
 * Student id:- s3644335
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame 
{
    private GameEngine gameEngine;
    private MenuBar menuBar;
    private ToolBar toolBar;
    private StatusBar statusBar;
    private Panel panel;

    // Constructor to setup the GUI components
    public MainFrame(GameEngine gameEngine) 
    {
        this.gameEngine = gameEngine;

        // Starting JFrame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding Menu Bar
        menuBar = new MenuBar(gameEngine);
        setJMenuBar(menuBar);

        // Adding Tool Bar 
        toolBar = new ToolBar(gameEngine, this);
        this.add(toolBar, BorderLayout.NORTH);

        // Adding Panel
        panel = new Panel();
        this.add(panel, BorderLayout.CENTER);

        // Adding Status Bar
        statusBar = new StatusBar(gameEngine);
        this.add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }


    public GameEngine getGameEngine() 
    {
        return gameEngine;
    }

    public StatusBar getStatusBar() 
    {
        return statusBar;
    }

    public Panel getPanel() 
    {
        return panel;
    }

    public ToolBar getToolBar() 
    {
        return toolBar;
    }

}