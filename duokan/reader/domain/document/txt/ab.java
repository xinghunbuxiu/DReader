package com.duokan.reader.domain.document.txt;

import android.graphics.Rect;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.txtlib.DktParserOption;

public final class ab {
    public static b a(long j) {
        return new b(j);
    }

    public static at a(b bVar, b bVar2) {
        return new at(bVar, bVar2);
    }

    public static long a(b bVar) {
        return bVar.g();
    }

    public static DktParserOption a(ad adVar) {
        int max = Math.max(adVar.a, 20);
        int max2 = Math.max(adVar.b, 20);
        Rect a = adVar.a();
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
