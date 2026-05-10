package com.sporime.ivgui;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import com.sporime.ivgui.IVGUI;

public class MyGLSurfaceView extends GLSurfaceView {
    private final MyRenderer renderer;

    public MyGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        renderer = new MyRenderer();
        setRenderer(renderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
            IVGUI.handleTouch(event.getX(), event.getY(), true);
        } else {
            IVGUI.handleTouch(event.getX(), event.getY(), false);
        }
        return true;
    }
}

