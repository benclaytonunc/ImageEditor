package com.comp301.a06image;

import java.awt.*;
import java.lang.*;

public class ZoomDecorator implements Image {
    private Image im;
    private int multiple;
    public ZoomDecorator(Image image, int multiplier) {
        this.im = image;
        this.multiple = multiplier;
        if (multiple < 0) {
            throw new IllegalArgumentException();
        }

    }
    public ZoomDecorator(Image image) {
        this(image, 2);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        if (x >= getWidth() || y >= getHeight()) {
            throw new IllegalArgumentException();
        }
        return im.getPixelColor(x,y);
    }

    @Override
    public int getWidth() {
        return getWidth()*multiple;
    }

    @Override
    public int getHeight() {
        return getHeight()*multiple;
    }

    @Override
    public int getNumLayers() {
        return 1+im.getNumLayers();
    }
}