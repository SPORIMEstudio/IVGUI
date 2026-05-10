package com.sporime.ivgui;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyGLSurfaceView glView = new MyGLSurfaceView(this);
        setContentView(glView);
    }
}
