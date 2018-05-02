package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;

public class DkTxtLib extends DkNative {
    public native boolean charsInFont(String str, String str2);

    public native boolean closeDocument(long j);

    public native boolean destroy();

    public native boolean initialize(String str);

    public native long openDocument(String str, String str2);

    public native void registerFont(String str, String str2);

    public native DkBox renderText(DkFlowRenderOption dkFlowRenderOption, DkBox dkBox, String str, DkArgbColor dkArgbColor, String str2, String str3, double d, double d2);

    public native void setBackupFont(String str);

    public native void setChsToCht(boolean z);

    public native void setDefaultFont(String str, int i);

    public native void setUseBookStyle(boolean z);
}
