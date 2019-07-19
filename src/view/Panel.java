package view;

import java.awt.*;

import javax.swing.*;

import model.DicePairImpl;
import model.interfaces.DicePair;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-    Sri Sai Teja Paturu 
 * Student id:- s3644335
 */

@SuppressWarnings("serial")
public class Panel extends JPanel 
{
    private JLabel playerDiceRoll;
    private JLabel houseDiceRoll;
    
    public Panel()
    {
        Font font = new Font("Raleway", Font.BOLD, 40);
        
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
        
        this.setLayout(new BorderLayout());
        
        playerDiceRoll = new JLabel();
        playerDiceRoll.setHorizontalAlignment(JLabel.CENTER);
//        playerDiceRoll.setVerticalAlignment(JLabel.CENTER);
        playerDiceRoll.setText("Player - Dice 1: 0, Dice 2: 0");
        playerDiceRoll.setFont(font);
        this.add(playerDiceRoll, BorderLayout.NORTH);
        
        houseDiceRoll = new JLabel();
        houseDiceRoll.setHorizontalAlignment(JLabel.CENTER);
//      houseDiceRoll.setVerticalAlignment(JLabel.CENTER);
        houseDiceRoll.setText("House - Dice 1: 0, Dice 2: 0");
        houseDiceRoll.setFont(font);
        this.add(houseDiceRoll, BorderLayout.SOUTH);
    }
    
    public void getPlayerDiceValue(DicePair dicePair)
    {
        if (dicePair == null)
        {
            dicePair = new DicePairImpl(0, 0, 6);
        }
        
        else
        {
            playerDiceRoll.setText(String.format("Player - Dice 1: %d, Dice 2: %d", dicePair.getDice1(), dicePair.getDice2()));
        }
    }
    
    public void getHouseDiceRoll(DicePair dicePair)
    {
        if (dicePair == null)
        {
            dicePair = new DicePairImpl(0, 0, 6);
        }
        
        else
        {
            houseDiceRoll.setText(String.format("House - Dice 1: %d, Dice 2: %d", dicePair.getDice1(), dicePair.getDice2()));
        }
    }
}
