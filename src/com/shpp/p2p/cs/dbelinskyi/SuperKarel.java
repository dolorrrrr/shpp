package com.shpp.p2p.cs.dbelinskyi;

import com.shpp.karel.KarelTheRobot;

public class SuperKarel extends KarelTheRobot
{
    //------CARDINAL DIRECTIONS-----------
    //Prerequisite: none
    //Result: Karel turned to the SOUTH
    public void turnSouth() throws Exception
    {
        while (notFacingSouth())
        {
            turnLeft();
        }
    }

    //Prerequisite: none
    //Result: Karel turned to the EAST
    public void turnEast() throws Exception
    {
        while (notFacingEast())
        {
            turnLeft();
        }
    }

    //Prerequisite: none
    //Result: Karel turned to the NORTH
    public void turnNorth() throws Exception
    {
        while (notFacingNorth())
        {
            turnLeft();
        }
    }

    //Prerequisite: none
    //Result: Karel turned to the WEST
    public void turnWest() throws Exception
    {
        while (notFacingWest()){
            turnLeft();
        }
    }

    //----------OTHER BASIC COMMANDS----------
    //Prerequisite: none
    //Result: Karel stopped in front of the wall
    public void moveToTheWall() throws Exception
    {
        while (frontIsClear())
        {
            move();
        }
    }

    //Prerequisite: none
    //Result: Karel turned around by making two left turns.
    public void turnAround() throws Exception
    {
        turnLeft();
        turnLeft();
    }

    //Prerequisite: none
    //Result: Karel turned on the Right by making three left turns
    public void turnRight() throws Exception
    {
        for(int i = 0; i < 3; i++){
            turnLeft();
        }
    }
}

