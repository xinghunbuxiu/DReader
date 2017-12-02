package com.duokan.kernel;

import android.graphics.Bitmap;

public class DkUtils extends DkNative {
    public static native void blurBitmap(Bitmap bitmap, int i);

    public static native String calcUniversalBookId(String str);

    public static native boolean charsInFont(String str, String str2);

    public static native String chs2chtText(String str);

    public static native String cht2chsText(String str);

    public static native byte[] decodeSimpleDrm(byte[] bArr);

    public static native String getDeviceId();

    public static native void initWordSeg(String str);

    public static native boolean isLineBreak(char c);

    public static native boolean isPunctuation(char c);

    public static boolean isZhFont(String str) {
        return charsInFont("中文", str);
    }
}
