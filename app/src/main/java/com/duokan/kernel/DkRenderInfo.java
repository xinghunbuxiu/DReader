package com.duokan.kernel;

import android.graphics.Bitmap;

public class DkRenderInfo {
    public Bitmap mBitmap = null;
    public long mPageNum = -1;
    public DkBox mPageRect = new DkBox();
    public float mScale = 1.0f;
}
