package org.academiadecodigo.thefellowshift;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(10,10);
        Player player = new Player(field);
        player.keyboard();
        field.init();


    }
}