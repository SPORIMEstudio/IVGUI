package com.sporime.ivgui;

public class IVGUI {
    static IVGUIDrawList drawList = new IVGUIDrawList();

    // Layout cursor
    static float cursorX = 20;
    static float cursorY = 20;
    static float spacingY = 10;

    // Input state
    public static float touchX = -1;
    public static float touchY = -1;
    public static boolean isTouchDown = false;
    
        // Add to IVGUI.java
    static float windowX = 100;
    static float windowY = 100;
    static float windowW = 300;
    static float windowH = 200;
    
    static boolean dragging = false;
    static float dragOffsetX, dragOffsetY;
    
    public static boolean Begin(String title) {
    // Draw panel rect
    drawList.addQuad(windowX, windowY, windowW, windowH);

    // Draw title bar (top)
    drawList.addQuad(windowX, windowY, windowW, 30);

    // Check drag
    if (isTouchDown) {
        if (!dragging) {
            if (touchX >= windowX && touchX <= windowX + windowW &&
                touchY >= windowY && touchY <= windowY + 30) {
                dragging = true;
                dragOffsetX = touchX - windowX;
                dragOffsetY = touchY - windowY;
            }
        }
    } else {
        dragging = false;
    }

    if (dragging) {
        windowX = touchX - dragOffsetX;
        windowY = touchY - dragOffsetY;
    }

    // Set layout cursor relative to window
    cursorX = windowX + 10;
    cursorY = windowY + 40;

    return true; // Panel open
    }
   public static void End() {
    // For now just reset or pop state if needed
}

        
    public static void newFrame() {
        drawList.clear();
        cursorX = 20;
        cursorY = 20;
    }

    public static IVGUIDrawData render() {
        return new IVGUIDrawData(drawList);
    }

    public static void setCursor(float x, float y) {
        cursorX = x;
        cursorY = y;
    }

    public static void sameLine(float offsetX) {
        cursorY -= (30 + spacingY);
        cursorX += offsetX;
    }

    public static void handleTouch(float x, float y, boolean down) {
        touchX = x;
        touchY = y;
        isTouchDown = down;
    }
}

