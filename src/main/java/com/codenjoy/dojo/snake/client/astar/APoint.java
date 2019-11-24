package com.codenjoy.dojo.snake.client.astar;

import com.codenjoy.dojo.services.Point;

import java.util.Objects;

public class APoint {

    private int x;
    private int y;

    public APoint(Point point) {
        this(point.getX(), point.getY());
    }

    APoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x(){
        return this.x;
    }

    private int y(){
        return this.y;
    }

    public APoint delta(APoint delta){
        return new APoint(
                this.x + delta.x,
                this.y + delta.y);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("APoint{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        APoint aPoint = (APoint) that;
        return x == aPoint.x &&
                y == aPoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
