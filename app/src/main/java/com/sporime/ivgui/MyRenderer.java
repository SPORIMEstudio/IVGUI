package com.sporime.ivgui;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.sporime.ivgui.IVGUI;
import com.sporime.ivgui.IVGUIWidgets;
import com.sporime.ivgui.IVGUIBackendOpenGLES;
import com.sporime.ivgui.IVGUIDrawData;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyRenderer implements GLSurfaceView.Renderer {

    private IVGUIBackendOpenGLES backend;

    private int screenWidth, screenHeight;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        backend = new IVGUIBackendOpenGLES();
        backend.init();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        screenWidth = width;
        screenHeight = height;
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        IVGUI.newFrame();
    
        if (IVGUIWidgets.Button("Hello")) {
            System.out.println("Button clicked!");
        }
        if(IVGUIWidgets.Button("hello iam noob "))
        {
            System.out.println("i");
        }
        
    
    if (IVGUI.Begin("My Panel")) {
        if (IVGUIWidgets.Button("OK")) {
            System.out.println("Clicked OK");
        }
        if (IVGUIWidgets.Button("Cancel")) {
            System.out.println("Clicked Cancel");
        }
    }
    IVGUI.End();
    
        IVGUIDrawData drawData = IVGUI.render();
        backend.render(drawData, screenWidth, screenHeight);
    }
}

