package com.post;

import java.util.Arrays;

class Parcel {
    
    public static final int MM = 1;
    public static final int CM = 10;
    public static final int M = 1000;
    public static final int G = 1;
    public static final int KG = 1000;
    
    private int length;
    private int width;
    private int height;
    private int weight;

    public Parcel(int[] dimensions, int weight) {
        // Let's define length > width > height
        Arrays.sort(dimensions);
        this.length = dimensions[2];
        this.width = dimensions[1];
        this.height = dimensions[0];
        this.weight = weight;
    }

    public boolean fitsIn(int[] dimensions) {
        Arrays.sort(dimensions);
        return this.length <= dimensions[2] && this.width <= dimensions[1] && this.height <= dimensions[0];
    }

    public int getWeight() {
        return this.weight;
    }

    public int getVolume() {
        return this.length * this.width * this.height;
    }
}