package com.duokan.reader.domain.document.p045a;

import android.graphics.Rect;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpFlowParserOption;

/* renamed from: com.duokan.reader.domain.document.a.p */
public class C0916p {
    /* renamed from: a */
    public static long m6078a(DkpBook dkpBook, C0921s c0921s) {
        if (c0921s.m5777b()) {
            return Math.max(1, Math.min(c0921s.mo1278j().m5795g() + 1, (long) dkpBook.getPageCount()));
        }
        C0925v c0925v = (C0925v) c0921s;
        return Math.max(1, Math.min((c0925v.f4371b + c0925v.f4375f) + 1, (long) dkpBook.getPageCount()));
    }

    /* renamed from: a */
    public static long m6077a(DkpBook dkpBook, C0898a c0898a) {
        return Math.max(1, Math.min(c0898a.m5795g() + 1, (long) dkpBook.getPageCount()));
    }

    /* renamed from: a */
    public static C0898a m6081a(DkFlowPosition dkFlowPosition) {
        return new C0898a(dkFlowPosition.mChapterIndex - 1, dkFlowPosition.mParaIndex, dkFlowPosition.mAtomIndex);
    }

    /* renamed from: a */
    public static ag m6082a(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        return new ag(C0916p.m6081a(dkFlowPosition), C0916p.m6081a(dkFlowPosition2));
    }

    /* renamed from: a */
    public static DkFlowPosition m6079a(C0898a c0898a) {
        return new DkFlowPosition(c0898a.m5795g() + 1, c0898a.m5796h(), c0898a.m5797i());
    }

    /* renamed from: a */
    public static DkpFlowParserOption m6080a(C0918q c0918q) {
        int max = Math.max(c0918q.a, 20);
        int max2 = Math.max(c0918q.b, 20);
        Rect a = c0918q.m6083a();
        DkpFlowParserOption dkpFlowParserOption = new DkpFlowParserOption();
        dkpFlowParserOption.mPageBox.mX0 = (float) a.left;
        dkpFlowParserOption.mPageBox.mY0 = (float) a.top;
        dkpFlowParserOption.mPageBox.mX1 = (float) (max - a.right);
        dkpFlowParserOption.mPageBox.mY1 = (float) (max2 - a.bottom);
        if (c0918q.f4341m.length > 0) {
            dkpFlowParserOption.mOddSubPageBox.mX0 = c0918q.f4341m[0].left;
            dkpFlowParserOption.mOddSubPageBox.mY0 = c0918q.f4341m[0].top;
            dkpFlowParserOption.mOddSubPageBox.mX1 = 1.0f - c0918q.f4341m[0].right;
            dkpFlowParserOption.mOddSubPageBox.mY1 = 1.0f - c0918q.f4341m[0].bottom;
        }
        if (c0918q.f4341m.length > 1) {
            dkpFlowParserOption.mEvenSubPageBox.mX0 = c0918q.f4341m[1].left;
            dkpFlowParserOption.mEvenSubPageBox.mY0 = c0918q.f4341m[1].top;
            dkpFlowParserOption.mEvenSubPageBox.mX1 = 1.0f - c0918q.f4341m[1].right;
            dkpFlowParserOption.mEvenSubPageBox.mY1 = 1.0f - c0918q.f4341m[1].bottom;
        }
        dkpFlowParserOption.mScale = c0918q.f4340l;
        dkpFlowParserOption.mLineGap = (float) c0918q.g;
        dkpFlowParserOption.mParaSpacing = (float) c0918q.h;
        dkpFlowParserOption.mFastMode = false;
        return dkpFlowParserOption;
    }
}
