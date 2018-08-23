package info.aki017;

import org.newdawn.slick.Color;

public class Cell {
    private boolean isAlive;
    private Color color;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
