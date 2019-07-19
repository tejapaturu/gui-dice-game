package view;

import controller.RollHouseListener;
import model.interfaces.GameEngine;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-    Sri Sai Teja Paturu 
 * Student id:- s3644335
 */

@SuppressWarnings("serial")
public class HouseStatusBar extends JPanel 
{
    private JLabel houseStatus;

    // Creates HouseStatusBar and update House status
    public HouseStatusBar(GameEngine gameEngine) 
    {
        BevelBorder border = new BevelBorder(BevelBorder.LOWERED);
        Font font = new Font("Raleway", Font.BOLD, 12);

        houseStatus = new JLabel();
        houseStatus.setText(" House Status: Waiting for players to finilize on bets and roll ...");
        houseStatus.setPreferredSize(new Dimension(500, 25));
        houseStatus.setBorder(border);
        houseStatus.setFont(font);

        JButton rollHouse = new JButton("Roll House");
        rollHouse.setPreferredSize(new Dimension(125, 25));
        rollHouse.setFocusPainted(false);
        rollHouse.addActionListener(new RollHouseListener(gameEngine));

        add(houseStatus);
        add(rollHouse);
    }

    public void setHouseStatus(String status) 
    {
        houseStatus.setText(" House Status: " + status);
    }

    public String getHouseStatus() 
    {
        return houseStatus.getText();
    }
}

