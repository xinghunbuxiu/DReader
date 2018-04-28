package com.duokan.reader.domain.document.txt;

import android.graphics.Rect;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.txtlib.DktParserOption;

public final class ab {
    /* renamed from: a */
    public static C0986b m7382a(long j) {
        return new C0986b(j);
    }

    /* renamed from: a */
    public static at m7381a(C0986b c0986b, C0986b c0986b2) {
        return new at(c0986b, c0986b2);
    }

    /* renamed from: a */
    public static long m7379a(C0986b c0986b) {
        return c0986b.m7539g();
    }

    /* renamed from: a */
    public static DktParserOption m7380a(ad adVar) {
        int max = Math.max(adVar.a, 20);
        int max2 = Math.max(adVar.b, 20);
        Rect a = adVar.m6083a();
        DktParserOption dktParserOption = new DktParserOption();
        dktParserOption.mPageBox = new DkBox();
        dktParserOption.mPageBox.mX0 = 0.0f;
        dktParserOption.mPageBox.mY0 = 0.0f;
        dktParserOption.mPageBox.mX1 = (float) max;
        dktParserOption.mPageBox.mY1 = (float) max2;
        dktParserOption.mPaddingBox = new DkBox();
        dktParserOption.mPaddingBox.mX0 = (float) a.left;
        dktParserOption.mPaddingBox.mY0 = (float) a.top;
        dktParserOption.mPaddingBox.mX1 = (float) (max - a.right);
        dktParserOption.mPaddingBox.mY1 = (float) (max2 - a.bottom);
        dktParserOption.mMeasureType = 0;
        dktParserOption.mBleed = adVar.e;
        return dktParserOption;
    }
}
