package com.duokan.reader.domain.document.a;

import android.graphics.Rect;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpFlowParserOption;

public class p {
    public static long a(DkpBook dkpBook, s sVar) {
        if (sVar.b()) {
            return Math.max(1, Math.min(sVar.j().g() + 1, (long) dkpBook.getPageCount()));
        }
        v vVar = (v) sVar;
        return Math.max(1, Math.min((vVar.b + vVar.f) + 1, (long) dkpBook.getPageCount()));
    }

    public static long a(DkpBook dkpBook, a aVar) {
        return Math.max(1, Math.min(aVar.g() + 1, (long) dkpBook.getPageCount()));
    }

    public static a a(DkFlowPosition dkFlowPosition) {
        return new a(dkFlowPosition.mChapterIndex - 1, dkFlowPosition.mParaIndex, dkFlowPosition.mAtomIndex);
    }

    public static ag a(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        return new ag(a(dkFlowPosition), a(dkFlowPosition2));
    }

    public static DkFlowPosition a(a aVar) {
        return new DkFlowPosition(aVar.g() + 1, aVar.h(), aVar.i());
    }

    public static DkpFlowParserOption a(q qVar) {
        int max = Math.max(qVar.a, 20);
        int max2 = Math.max(qVar.b, 20);
        Rect a = qVar.a();
        DkpFlowParserOption dkpFlowParserOption = new DkpFlowParserOption();
        dkpFlowParserOption.mPageBox.mX0 = (float) a.left;
        dkpFlowParserOption.mPageBox.mY0 = (float) a.top;
        dkpFlowParserOption.mPageBox.mX1 = (float) (max - a.right);
        dkpFlowParserOption.mPageBox.mY1 = (float) (max2 - a.bottom);
        if (qVar.m.length > 0) {
            dkpFlowParserOption.mOddSubPageBox.mX0 = qVar.m[0].left;
            dkpFlowParserOption.mOddSubPageBox.mY0 = qVar.m[0].top;
            dkpFlowParserOption.mOddSubPageBox.mX1 = 1.0f - qVar.m[0].right;
            dkpFlowParserOption.mOddSubPageBox.mY1 = 1.0f - qVar.m[0].bottom;
        }
        if (qVar.m.length > 1) {
            dkpFlowParserOption.mEvenSubPageBox.mX0 = qVar.m[1].left;
            dkpFlowParserOption.mEvenSubPageBox.mY0 = qVar.m[1].top;
            dkpFlowParserOption.mEvenSubPageBox.mX1 = 1.0f - qVar.m[1].right;
            dkpFlowParserOption.mEvenSubPageBox.mY1 = 1.0f - qVar.m[1].bottom;
        }
        dkpFlowParserOption.mScale = qVar.l;
        dkpFlowParserOption.mLineGap = (float) qVar.g;
        dkpFlowParserOption.mParaSpacing = (float) qVar.h;
        dkpFlowParserOption.mFastMode = false;
        return dkpFlowParserOption;
    }
}
