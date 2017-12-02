package com.duokan.kernel.pdflib;

import com.duokan.kernel.DkNative;

public class DkPdfLib extends DkNative {
    protected native void closeBook(DkpBook dkpBook);

    public native boolean initialize(String str);

    public native DkpBook openBook(String str);

    public native void registerFont(String str, String str2);

    public native void setDeviceParams(int i);

    public native void setUseBookStyle(boolean z);
}
