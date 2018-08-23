package info.aki017;

import org.newdawn.slick.*;

/**
 * A game using Slick2d
 */
public class Game extends BasicGame {

    /**
     * Screen width
     */
    private static final int WIDTH = 1024;
    /**
     * Screen height
     */
    private static final int HEIGHT = 768;
    Field field = new Field();
    /**
     * A counter...
     */
    private int counter;

    public Game() {
        super("A Slick2d game");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.setForceExit(false);
        app.start();
    }

    private static void renderStage(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(356, 64, 320, 640);
        g.fillRect(356 - 120, 64, 100, 160);
        g.fillRect(356 + 320 + 20, 64, 100, 160);
    }

    public void render(GameContainer container, Graphics g) {
        g.drawString("Hello, " + Integer.toString(counter) + "!", 50, 50);
        renderStage(g);
        field.render(g);
    }

    @Override
    public void init(GameContainer container) {
        counter = 0;
    }

    @Override
    public void update(GameContainer container, int delta) {
        counter++;
        field.update(container, delta);
    }

}
