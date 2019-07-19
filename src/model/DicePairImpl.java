package model;

import model.interfaces.DicePair;

/**
 * Assignment 2 for SADI s1 2018 
 * Done by:-        Sri Sai Teja Paturu 
 * Student id:-     s3644335
 */

// This class implements the interface DicePair
public class DicePairImpl implements DicePair
{
    private int dice1;      // The face of die-1 can be any number from 1 to numFaces.
    private int dice2;      // The face of die-2 can be any number from 1 to numFaces.
    private int numFaces;   // The number of faces of a die. The standard die has 6 faces, but in several
                            // board games there are dies of different number of faces.

    // Constructor for DicePairImpl, which sets dice1, dice2 and numFaces.
    public DicePairImpl(int dice1, int dice2, int numFaces)
    {
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.numFaces = numFaces;
    }

    // Returns dice1
    @Override
    public int getDice1()
    {
        return dice1;
    }

    // Returns dice2
    @Override
    public int getDice2()
    {
        return dice2;
    }

    // Returns numFaces.
    @Override
    public int getNumFaces()
    {
        return numFaces;
    }

    // Returns a string with the value of dice1 and dice2 and their total. Used in
    // GameEngineCallBackupImpl by the logger in intermediateResult and
    // intermediateHouseResult to get the output.
    @Override
    public String toString()
    {
        return String.format("Dice 1: %d,  Dice 2: %d .. Total: %d", getDice1(), getDice2(), (getDice1() + getDice2()));
    }
}
