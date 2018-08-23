package info.aki017;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Field {

    static final int WIDTH = 10;
    static final int HEIGHT = 20;
    Tetrimino[] mino = Tetrimino.values();
    private Cell[][] field = new Cell[WIDTH][HEIGHT];
    private int pointX = 5;
    private int pointY = 0;
    private int time = 0;
    private Tetrimino current;
    private int rotation = 0;

    Field() {
        current = mino[(int) (Math.random() * 100) % mino.length];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                field[i][j] = new Cell();
            }
        }
    }

    public void update(GameContainer container, int delta) {
        time += delta;
        //ボタンが押されたら移動
        if (container.getInput().isKeyPressed(Input.KEY_RIGHT)) {
            if (isFree(pointX + 1, pointY)) {
                pointX++;
            }

        }
        if (container.getInput().isKeyPressed(Input.KEY_LEFT)) {
            if (isFree(pointX - 1, pointY)) {
                pointX--;
            }
        }

        if (container.getInput().isKeyDown(Input.KEY_DOWN)) {
            if (time < 400) {
                time = 400;
            }
        }

        //Z,Xで回転
        if (container.getInput().isKeyPressed(Input.KEY_Z)) {
            if (isFree((rotation + 90) % 360)) {
                rotation = (rotation + 90) % 360;
            }
        }
        if (container.getInput().isKeyPressed(Input.KEY_X)) {
            if (isFree((rotation + 270) % 360)) {
                rotation = (rotation + 270) % 360;
            }
        }

        //自然落下
        if (time < 500) {
            return;
        }

        time -= 500;

        if (isFree(pointX, pointY + 1)) {
            pointY += 1;

        } else {
            placeBlock();
            rotation = 0;
            pointY = 0;
            pointX = WIDTH / 2;
            current = mino[(int) (Math.random() * 100) % mino.length];
        }
    }

    public void render(Graphics g) {
        Vector2 v;
        for (Vector2 vector2 : current.blocks()) {
            v = vector2.rotate(rotation);
            renderBlock(g, pointX + v.x, pointY + v.y, current.getColor());

        }


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].isAlive()) {
                    renderBlock(g, i, j, field[i][j].getColor());
                }

            }
        }


    }

    private void placeBlock() {
        Vector2 v;
        for (Vector2 vector2 : current.blocks()) {
            v = vector2.rotate(rotation);
            field[pointX + v.x][pointY + v.y].setColor(current.getColor());
            field[pointX + v.x][pointY + v.y].setAlive(true);

        }
    }

    private void renderBlock(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(356 + x * 32, 64 + y * 32, 32, 32);
    }

    private boolean isFree(int rot) {
        return isFree(pointX, pointY, rot);
    }

    private boolean isFree(int x, int y) {
        return isFree(x, y, rotation);
    }

    private boolean isFree(int x, int y, int rot) {
        Vector2 v;
        for (Vector2 vector2 : current.blocks()) {
            v = vector2.rotate(rot);
            if (x + v.x < 0) {
                return false;
            }

            if (x + v.x >= WIDTH) {
                return false;
            }

            if (y + v.y < 0) {
                continue;
            }

            if (y + v.y >= HEIGHT) {
                return false;
            }

            if (field[x + v.x][y + v.y].isAlive()) {
                return false;
            }


        }
        return true;
    }


}
