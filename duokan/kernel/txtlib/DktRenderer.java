package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkNative;

public class DktRenderer extends DkNative {
    private final long mDktHandle = createDktHandle();

    private static native long createDktHandle();

    private static native void destroyDktHandle(long j);

    public native DkBox getRenderBoxByHeight(String str, DktLayoutOption dktLayoutOption, float f, float f2, boolean z);

    public native DkBox getRenderBoxByLineCount(String str, DktLayoutOption dktLayoutOption, float f, int i, boolean z);

    public native DktRenderDetailInfo getRenderDetailByHeight(String str, DktLayoutOption dktLayoutOption, float f, float f2, boolean z);

    public native DktRenderDetailInfo getRenderDetailByLineCount(String str, DktLayoutOption dktLayoutOption, float f, int i, boolean z);

    public native DktRenderTextInfo getRenderInfoByHeight(String str, DktLayoutOption dktLayoutOption, float f, float f2, boolean z);

    public native DktRenderTextInfo getRenderInfoByLineCount(String str, DktLayoutOption dktLayoutOption, float f, int i, boolean z);

    public void finalize() {
        destroyDktHandle(this.mDktHandle);
    }
}
