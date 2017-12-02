package com.duokan.kernel.epublib;

import android.util.Log;

public class DKFileInfo {
    private static final String LOG_TAG = "com.duokan.epublib.DKFileInfo";
    public byte[] data;
    public long dataLength = 0;
    public String extension;

    public void initExtension(byte[] bArr) {
        try {
            this.extension = new String(bArr, "UTF-32LE");
        } catch (Throwable e) {
            Log.e(LOG_TAG, "Unsupported encoding exception...", e);
        }
    }

    public void initData(long j) {
        this.dataLength = j;
        this.data = new byte[((int) j)];
    }
}
