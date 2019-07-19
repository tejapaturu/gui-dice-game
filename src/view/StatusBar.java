package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import model.interfaces.GameEngine;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-    Sri Sai Teja Paturu 
 * Student id:- s3644335
 */

@SuppressWarnings("serial")
public class StatusBar extends JPanel
{
    private JLabel bet, points, status;
    private HouseStatusBar houseStatusBar;

    public StatusBar(GameEngine gameEngine)
    {
        BevelBorder border = new BevelBorder(BevelBorder.LOWERED);
        Font font = new Font("Raleway", Font.BOLD, 12);

        // Sets size for House & Player Status Bar
        setPreferredSize(new Dimension(650, 90));

        // Adds House Status Bar
        houseStatusBar = new HouseStatusBar(gameEngine);
        add(houseStatusBar);

        // Adds Player Status Bar
        JPanel statusBar = new JPanel();
        statusBar.setBorder(border);
        statusBar.setPreferredSize(new Dimension(675, 30));
        statusBar.setLayout(new GridLayout(1,3));
        add(statusBar);

        // Adds a section for a Bet section in Player Status Bar
        bet = new JLabel();
        bet.setText(" Bet Placed: ");
        bet.setFont(font);
        bet.setPreferredSize(new Dimension(225, 25));
        bet.setBorder(border);
        statusBar.add(bet);

        // A section to show points
        points = new JLabel();
        points.setText(" Points Available: ");
        points.setFont(font);
        points.setPreferredSize(new Dimension(225, 25));
        points.setBorder(border);
        statusBar.add(points);

        // A section to show Status
        status = new JLabel();
        status.setText("Current Status: ");
        status.setFont(font);
        status.setPreferredSize(new Dimension(225, 25));
        status.setBorder(border);
        statusBar.add(status);
    }

    public void setBet(int bet)
    {
        this.bet.setText("Bet Placed: " + bet);
    }

    public void setPoints(int points)
    {
        this.points.setText("Points Available: " + points);
    }

    public void setStatus(String string)
    {
        this.status.setText("Current Status: " + string);
    }

    public HouseStatusBar getHouseStatusBar()
    {
        return houseStatusBar;
    }
}
