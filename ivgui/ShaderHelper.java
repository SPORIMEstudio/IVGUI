package com.sporime.ivgui;
import android.opengl.GLES20;

public class ShaderHelper {
    public static int createProgram(String vs, String fs) {
        int vShader = loadShader(GLES20.GL_VERTEX_SHADER, vs);
        int fShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fs);
        int program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vShader);
        GLES20.glAttachShader(program, fShader);
        GLES20.glLinkProgram(program);
        return program;
    }

    private static int loadShader(int type, String shaderSrc) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderSrc);
        GLES20.glCompileShader(shader);
        return shader;
    }
}

