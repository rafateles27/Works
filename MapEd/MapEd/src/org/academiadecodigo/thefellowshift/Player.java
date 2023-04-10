package org.academiadecodigo.thefellowshift;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {
    public static final int CELL_SIZE = 30;
    private Rectangle userRectangle;
    private Rectangle paintRectangle;
    private Field field;


    public Player(Field field) {
        this.userRectangle = userRectangle;
        this.field = field;
        userRectangle = new Rectangle(Field.PADDING, Field.PADDING, CELL_SIZE, CELL_SIZE);
        userRectangle.setColor(Color.RED);
        userRectangle.draw();
        userRectangle.fill();
    }
    public void paint() {
        paintRectangle = new Rectangle(userRectangle.getX(), userRectangle.getY() , CELL_SIZE, CELL_SIZE );
        paintRectangle.fill();
        paintRectangle.draw();
        paintRectangle.setColor(Color.BLACK);
    }
    public void delete() {
        paintRectangle = new Rectangle(userRectangle.getX(), userRectangle.getY() , CELL_SIZE, CELL_SIZE );
        paintRectangle.delete();
        paintRectangle.draw();

    }

    public void keyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent filling = new KeyboardEvent();
        KeyboardEvent exit = new KeyboardEvent();
        KeyboardEvent erase = new KeyboardEvent();

        right.setKey(KeyboardEvent.KEY_RIGHT);
        left.setKey(KeyboardEvent.KEY_LEFT);
        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        filling.setKey(KeyboardEvent.KEY_SPACE);
        exit.setKey(KeyboardEvent.KEY_Q);
        erase.setKey(KeyboardEvent.KEY_C);

        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        filling.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        exit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        erase.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(down);
        keyboard.addEventListener(filling);
        keyboard.addEventListener(exit);
        keyboard.addEventListener(erase);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (userRectangle.getX() < field.getWidth() - CELL_SIZE)
                    userRectangle.translate(CELL_SIZE, 0);
                break;
            case KeyboardEvent.KEY_LEFT:
                if (userRectangle.getX() > Field.PADDING)
                    userRectangle.translate(-CELL_SIZE, 0);
                break;
            case KeyboardEvent.KEY_UP:
                if (userRectangle.getY() > Field.PADDING)
                    userRectangle.translate(0, -CELL_SIZE);
                break;
            case KeyboardEvent.KEY_DOWN:
                if (userRectangle.getY() < field.getHeight() - CELL_SIZE)
                    userRectangle.translate(0, CELL_SIZE);
                break;
            case KeyboardEvent.KEY_SPACE:
                paint();
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_C:
                delete();
                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
