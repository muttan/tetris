package info.aki017;

import org.newdawn.slick.Color;

public enum Tetrimino {
    I, O, S, Z, J, L, T;

    public Vector2[] blocks() {

        switch (this) {
            case I:
                return new Vector2[]{new Vector2(0, 0), new Vector2(0, -1), new Vector2(0, -2), new Vector2(0, 1)};
            case O:
                return new Vector2[]{new Vector2(0, 0), new Vector2(0, 1), new Vector2(1, 1), new Vector2(1, 0)};
            case S:
                return new Vector2[]{new Vector2(0, 0), new Vector2(1, 0), new Vector2(0, 1), new Vector2(-1, 1)};
            case Z:
                return new Vector2[]{new Vector2(0, 0), new Vector2(-1, 0), new Vector2(0, 1), new Vector2(1, 1)};
            case J:
                return new Vector2[]{new Vector2(0, 0), new Vector2(0, 1), new Vector2(0, -1), new Vector2(-1, 1)};
            case L:
                return new Vector2[]{new Vector2(0, 0), new Vector2(0, 1), new Vector2(0, -1), new Vector2(1, 1)};
            case T:
                return new Vector2[]{new Vector2(0, 0), new Vector2(0, 1), new Vector2(1, 0), new Vector2(0, -1)};
            default:
                return null;
        }
    }

    public Color getColor() {
        switch (this) {

            case I:
                return Color.cyan;
            case O:
                return Color.yellow;
            case S:
                return Color.green;
            case Z:
                return Color.red;
            case J:
                return Color.blue;
            case L:
                return Color.orange;
            case T:
                return Color.magenta;
            default:
                return null;
        }
    }
}
