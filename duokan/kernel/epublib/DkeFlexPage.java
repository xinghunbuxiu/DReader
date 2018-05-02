package com.duokan.kernel.epublib;

import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkPos;

public class DkeFlexPage extends DkNative {
    private final long mDkeHandle;

    private static native long createDkeHandleFromHtmlBytes(byte[] bArr, String str);

    private static native long createDkeHandleFromHtmlFile(String str);

    private static native void destroyDkeHandle(long j);

    public native void calcPageLayout();

    public native void clearLayoutResult();

    public native DkeHitTestInfo[] getImages();

    public native double getLayoutHeight();

    public native double getLayoutWidth();

    public native DkFlowPosition[] getSelectionRange(DkPos dkPos, DkPos dkPos2);

    public native String getTextContentOfRange(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native DkBox[] getTextRects(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native DkeLinkInfo hitTestLink(DkPos dkPos);

    public native DkeHitTestInfo hitTestObject(DkPos dkPos);

    public native DkFlowPosition[] hitTestTextRange(DkPos dkPos);

    public native DkFlowPosition[] hitTestTextRangeByMode(DkPos dkPos, int i);

    public native void measureSize();

    public native void render(DkFlowRenderOption dkFlowRenderOption);

    public native void renderArea(DkFlowRenderOption dkFlowRenderOption, DkBox dkBox);

    public native void resetAllTextColor();

    public native void setFirstLineIndent(double d);

    public native void setFontSize(double d);

    public native void setLineGap(double d);

    public native void setPageHeight(double d);

    public native void setPageTopLeft(DkPos dkPos);

    public native void setPageWidth(double d);

    public native void setParaSpacing(double d);

    public native void setTabStop(double d);

    public native void setTextColor(DkArgbColor dkArgbColor);

    public DkeFlexPage(String str) {
        this.mDkeHandle = createDkeHandleFromHtmlFile(str);
    }

    public DkeFlexPage(byte[] bArr, String str) {
        this.mDkeHandle = createDkeHandleFromHtmlBytes(bArr, str);
    }

    protected DkeFlexPage(long j) {
        this.mDkeHandle = j;
    }

    public long getHandle() {
        return this.mDkeHandle;
    }

    protected void finalize() {
        destroyDkeHandle(this.mDkeHandle);
        super.finalize();
    }
}
