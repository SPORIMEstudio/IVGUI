package com.sporime.ivgui;

import java.util.ArrayList;

public class IVGUIDrawList {
    public ArrayList<IVGUIVertex> vertices = new ArrayList<>();
    public ArrayList<Short> indices = new ArrayList<>();

    public void clear() {
        vertices.clear();
        indices.clear();
    }

    public void addQuad(float x, float y, float w, float h) {
        int idx = vertices.size();
        vertices.add(new IVGUIVertex(x, y, 0, 0));
        vertices.add(new IVGUIVertex(x + w, y, 1, 0));
        vertices.add(new IVGUIVertex(x + w, y + h, 1, 1));
        vertices.add(new IVGUIVertex(x, y + h, 0, 1));

        indices.add((short) (idx + 0));
        indices.add((short) (idx + 1));
        indices.add((short) (idx + 2));
        indices.add((short) (idx + 0));
        indices.add((short) (idx + 2));
        indices.add((short) (idx + 3));
    }
}
