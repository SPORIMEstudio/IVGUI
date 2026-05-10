package com.sporime.ivgui;
public class IVGUIWidgets {

    public static boolean Button(String label) {
        float w = label.length() * 15 + 40;  // estimate width by text
        float h = 50;

        int base = IVGUI.drawList.vertices.size();
        IVGUI.drawList.addQuad(IVGUI.cursorX, IVGUI.cursorY, w, h);

        boolean pressed = false;
        if (IVGUI.isTouchDown &&
            IVGUI.touchX >= IVGUI.cursorX && IVGUI.touchX <= IVGUI.cursorX + w &&
            IVGUI.touchY >= IVGUI.cursorY && IVGUI.touchY <= IVGUI.cursorY + h) {
            pressed = true;
        }

        IVGUI.cursorY += h + IVGUI.spacingY;

        return pressed;
    }

}
