package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkBox;

public class DktParserOption {
    public boolean mBleed = false;
    public int mDpi;
    public int mMeasureType;
    public DkBox mPaddingBox;
    public DkBox mPageBox;

    public boolean equals(Object obj) {
        DktParserOption dktParserOption = (DktParserOption) obj;
        return this.mPageBox.equals(dktParserOption.mPageBox) && this.mPaddingBox.equals(dktParserOption.mPaddingBox) && this.mMeasureType == dktParserOption.mMeasureType && this.mDpi == dktParserOption.mDpi;
    }
}
