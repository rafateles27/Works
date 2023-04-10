package org.academiadecodigo.thefellowshift;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    private int col;
    private int row;
    private int width;
    private int height;
    private boolean isPainted;
    public static final int PADDING = 10;
    //private int cellSize = 10;
    private Rectangle[] eachRectangle;

    public Field(int col,int row) {
        this.col = col;
        this.row = row;
        eachRectangle = new Rectangle[col * row];
        isPainted = false;
        width = this.col * Player.CELL_SIZE;
        height = this.row * Player.CELL_SIZE;
    }
    public void init() {

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Rectangle rectangle = new Rectangle(i * Player.CELL_SIZE + PADDING,j * Player.CELL_SIZE + PADDING, Player.CELL_SIZE, Player.CELL_SIZE);
                eachRectangle[count] = rectangle;
                rectangle.draw();
                count++;
            }
        }

    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
