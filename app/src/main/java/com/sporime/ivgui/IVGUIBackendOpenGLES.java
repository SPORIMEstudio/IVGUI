package com.sporime.ivgui;

import android.opengl.GLES20;
import java.nio.*;

public class IVGUIBackendOpenGLES {
    private int program;
    private int aPos, uMVP;

    private FloatBuffer vertexBuffer;
    private ShortBuffer indexBuffer;

    public void init() {
        program = ShaderHelper.createProgram(VERTEX, FRAGMENT);
        aPos = GLES20.glGetAttribLocation(program, "aPos");
    }

    public void render(IVGUIDrawData data, int screenW, int screenH) {
        int vertexCount = data.drawList.vertices.size();
        int indexCount = data.drawList.indices.size();

        float[] verts = new float[vertexCount * 2];
        for (int i = 0; i < vertexCount; i++) {
            IVGUIVertex v = data.drawList.vertices.get(i);
            verts[i * 2 + 0] = (v.x / screenW) * 2 - 1;
            verts[i * 2 + 1] = -((v.y / screenH) * 2 - 1);
        }

        short[] inds = new short[indexCount];
        for (int i = 0; i < indexCount; i++) inds[i] = data.drawList.indices.get(i);

        vertexBuffer = ByteBuffer.allocateDirect(verts.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        vertexBuffer.put(verts).position(0);

        indexBuffer = ByteBuffer.allocateDirect(inds.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        indexBuffer.put(inds).position(0);

        GLES20.glUseProgram(program);
        GLES20.glEnableVertexAttribArray(aPos);
        GLES20.glVertexAttribPointer(aPos, 2, GLES20.GL_FLOAT, false, 2 * 4, vertexBuffer);

        GLES20.glDrawElements(GLES20.GL_TRIANGLES, inds.length, GLES20.GL_UNSIGNED_SHORT, indexBuffer);

        GLES20.glDisableVertexAttribArray(aPos);
    }

    static final String VERTEX =
            "attribute vec2 aPos;" +
            "void main() { gl_Position = vec4(aPos, 0.0, 1.0); }";

    static final String FRAGMENT =
            "precision mediump float;" +
            "void main() { gl_FragColor = vec4(0.2, 0.7, 0.8, 1.0); }";
}
