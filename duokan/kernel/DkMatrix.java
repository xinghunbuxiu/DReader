package com.duokan.kernel;

public class DkMatrix {
    public float mDx = 0.0f;
    public float mDy = 0.0f;
    public float mM11 = 1.0f;
    public float mM12 = 0.0f;
    public float mM21 = 0.0f;
    public float mM22 = 1.0f;

    public DkMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mM11 = f;
        this.mM12 = f2;
        this.mM21 = f3;
        this.mM22 = f4;
        this.mDx = f5;
        this.mDy = f6;
    }
}
