package com.example.mondelavictoria.happy_kids_reading;

/**
 * Created by Mon Dela Victoria on 8/30/2018.
 */

public class Game {
    private String name;
    private int imageSource;

    public Game (int imageSource, String name) {
        this.name = name;
        this.imageSource = imageSource;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageSource;
    }
}
