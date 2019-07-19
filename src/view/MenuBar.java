package view;


import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


import controller.AddPlayerListener;
import controller.ExitActionListener;
import controller.RemovePlayerListener;
import model.interfaces.GameEngine;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-    Sri Sai Teja Paturu 
 * Student id:- s3644335
 */

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar 
{
    public MenuBar(GameEngine gameEngine) 
    {
        // Creating a Menu
        JMenu menu = new JMenu("Menu");
        //Adding the menu
        add(menu);
        
        
        //Creating Menu Items
        JMenuItem addPlayer = new JMenuItem("Add Player", KeyEvent.VK_N);
        JMenuItem removePlayer = new JMenuItem("Remove Player");
        JMenuItem quit = new JMenuItem("Quit", KeyEvent.VK_X); 
        
        // Adding actionListeners to options under 'File;
        addPlayer.addActionListener(new AddPlayerListener(gameEngine));
        removePlayer.addActionListener(new RemovePlayerListener(gameEngine));
        quit.addActionListener(new ExitActionListener());
        
        //Adding descriptions for options
        addPlayer.getAccessibleContext().setAccessibleDescription("Add Player to the Game-Console.");
        removePlayer.getAccessibleContext().setAccessibleDescription("Remove player from the Game-Console.");
        quit.getAccessibleContext().setAccessibleDescription("Exit from the Game-Console.");
        
        //Adding accelerators
        addPlayer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.CTRL_MASK));
        removePlayer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        quit.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_MASK));
        
        //Adding menu options.
        menu.add(addPlayer);
        menu.add(removePlayer);
        menu.add(quit);
    }
}
