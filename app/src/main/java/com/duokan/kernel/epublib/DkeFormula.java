package com.duokan.kernel.epublib;

import com.duokan.kernel.DkAtomRenderOption;

public class DkeFormula {
    private final long mDkeHandle;

    public native float getHeight();

    public native float getWidth();

    public native long render(DkAtomRenderOption dkAtomRenderOption);

    public DkeFormula(long j) {
        this.mDkeHandle = j;
    }
}
