package com.test.clickimageviewlibrary.utils;

import java.util.Vector;

public class Polygon {
    private String id;
    Vector<Float> xArray = new Vector<Float>();
    Vector<Float> yArray = new Vector<Float>();

    public Polygon(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void add(float x, float y) {
        xArray.add(x);
        yArray.add(y);
    }

    public boolean contains(float px, float py) {
        int verticesNum = xArray.size();

        if (verticesNum < 3)
            return false;

        boolean oddNodes = false;
        float x2 = xArray.get(verticesNum - 1);
        float y2 = yArray.get(verticesNum - 1);
        float x1, y1;
        for (int i = 0; i < verticesNum; x2 = x1, y2 = y1, ++i) {
            x1 = xArray.get(i);
            y1 = yArray.get(i);
            if (((y1 < py) && (y2 >= py))
                    || (y1 >= py) && (y2 < py)) {
                if ((py - y1) / (y2 - y1)
                        * (x2 - x1) < (px - x1))
                    oddNodes = !oddNodes;
            }
        }
        return oddNodes;
    }
}
