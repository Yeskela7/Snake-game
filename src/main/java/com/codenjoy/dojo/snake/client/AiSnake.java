package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;

import java.util.ArrayList;

public class AiSnake {

    public Direction AiSnake(Board board) {

        int appleX = board.getApples().get(0).getX();
        int appleY = board.getApples().get(0).getY();

        int headX = board.getHead().getX();
        int headY = board.getHead().getY();

        Direction direction = Direction.STOP;

        while (!board.isGameOver()) {
            int difX = headX - appleX;
            int difY = headY - appleY;

            if (difX < 0) {
                direction = Direction.RIGHT;
                return direction;
            }
            if (difX > 0) {
                direction = Direction.LEFT;
                return direction;
            }
            if (difY < 0) {
                direction = Direction.UP;
                return direction;
            }
            if (difY > 0) {
                direction = Direction.DOWN;
                return direction;
            }
        }
        return direction;
    }
}
