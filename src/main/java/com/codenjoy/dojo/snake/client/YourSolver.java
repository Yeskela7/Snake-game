package com.codenjoy.dojo.snake.client;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.RandomDice;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private Dice dice;
    private Board board;
    private AiSnake aiSnake;

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        this.board = board;
        System.out.println(board.toString());
        int appleX = board.getApples().get(0).getX();
        int appleY = board.getApples().get(0).getY();

        int headX = board.getHead().getX();
        int headY = board.getHead().getY();

        int stoneX = board.getStones().get(0).getX();
        int stoneY = board.getStones().get(0).getY();

        Direction direction = Direction.STOP;
        {
            int difX = headX - appleX;
            int difY = headY - appleY;


            if (difX < 0) {
                direction = Direction.RIGHT;
            }
            if (difX > 0) {
                direction = Direction.LEFT;
            }
            if (difX == 0) {
                if (difY < 0) {
                    direction = Direction.UP;
                }
                if (difY > 0) {
                    direction = Direction.DOWN;
                }
            }

        }
        return direction.toString();
    }

    public static void main(String[] args) {
        WebSocketRunner.runClient(
                // paste here board page url from browser after registration
                "http://104.248.23.201/codenjoy-contest/board/player/62lu5levxin3q5iq9cvw?code=1972076043854070041",
                new YourSolver(new RandomDice()),
                new Board());
    }

}
