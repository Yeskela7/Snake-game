package com.codenjoy.dojo.snake.client.lee;

import java.util.ArrayList;

public class Lee {
    private final static ArrayList deltas = new ArrayList<>() {{
        add(new LeePoint(1, 0));
        add(new LeePoint(0, 1));
        add(new LeePoint(-1, 0));
        add(new LeePoint(0, -1));
    }};
    //board
    private int dimX;
    private int dimY;
    private int[][] board;
    //constants
    private final static int START = -1;
    private final static int OBSTACLE = -10;

    //constructor
    public Lee(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.board = new int[dimX][dimY];
    }

    public int get(LeePoint point){
        return this.board[point.x()][point.y()];
    }

    public void set(LeePoint point, int value){
        this.board[point.x()][point.y()] = value;
    }


}
