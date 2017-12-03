package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.kernel.epublib.DkeBook.Callback;
import com.duokan.kernel.epublib.DkeBookEx;
import com.duokan.kernel.epublib.DkeFuzzyMatchResult;
import com.duokan.kernel.epublib.DkePage;
import com.duokan.kernel.epublib.DkeParserOption;
import com.duokan.reader.common.b;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.x;

import java.io.File;
import java.util.Collections;
import java.util.List;

public final class ai {
    static final /* synthetic */ boolean a = (!ai.class.desiredAssertionStatus());

    public static aq a(String str, ap apVar) {
        return a(str, apVar, null);
    }

    public static aq a(String str, ap apVar, Callback callback) {
        DkeBook dkeBookEx;
        String[] strArr = null;
        aq aqVar = new aq();
        File file = new File(Uri.parse(str).getPath());
        if (apVar instanceof ag) {
            dkeBookEx = new DkeBookEx(file.getAbsolutePath(), ah.e().c(), callback, ((ag) apVar).b);
        } else if (apVar instanceof al) {
            al alVar = (al) apVar;
            String[] a = a(alVar.b);
            dkeBookEx = new DkeBookEx(file.getAbsolutePath(), a, "", "", ah.e().c(), alVar.c);
            strArr = a;
        } else {
            dkeBookEx = new DkeBookEx(file.getAbsolutePath(), ah.e().c(), callback, (byte[][]) null);
        }
        aqVar.a = strArr;
        aqVar.b = dkeBookEx;
        return aqVar;
    }

    public static void a(aq aqVar) {
        if (aqVar.b != null && aqVar.b.isValid()) {
            aqVar.b.close();
        }
        aqVar.b = null;
        aqVar.a = null;
    }

    public static c a(long j, long j2, long j3) {
        return new c(j, j2, j3);
    }

    public static ce a(c cVar, c cVar2) {
        return new ce(cVar, cVar2);
    }

    public static void a(DkeBook dkeBook, Document_a aVar) {
        if (aVar instanceof c) {
            ((c) aVar).a(dkeBook);
        } else if (aVar instanceof ce) {
            ((ce) aVar).a(dkeBook);
        }
    }

    public static boolean a(DkeBook dkeBook, List list) {
        boolean z = false;
        Collections.sort(list, new aj());
        c cVar = null;
        x xVar = null;
        int i = 0;
        while (i < list.size()) {
            boolean z2;
            x xVar2 = (x) list.get(i);
            if (!((ce) xVar2.a()).b()) {
                z2 = z;
            } else if (((ce) xVar2.a()).d()) {
                c cVar2;
                int a;
                if (xVar == null || ((ce) xVar.a()).j().g() != ((ce) xVar2.a()).j().g()) {
                    cVar2 = new c(((ce) xVar2.a()).j().g(), 0, 0, "", ((ce) xVar2.a()).j().k(), -1, "");
                } else {
                    cVar2 = cVar;
                }
                boolean a2 = a(dkeBook, cVar2, xVar2);
                if (a2) {
                    cVar2 = ((ce) xVar2.a()).j();
                    z2 = a2;
                } else {
                    a = a(dkeBook, xVar2);
                }
                z2 = a | z;
                cVar = cVar2;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        return z;
    }

    private static boolean a(DkeBook dkeBook, c cVar, x xVar) {
        if (((ce) xVar.a()).j().j() == null) {
            return false;
        }
        if (dkeBook.getBookRevision() == null) {
            return false;
        }
        if (dkeBook.getBookRevision().compareTo(((ce) xVar.a()).j().j()) <= 0) {
            return false;
        }
        if (TextUtils.isEmpty(xVar.b())) {
            return false;
        }
        String chapterId;
        if (b.a(xVar.b())) {
            if (xVar.b().length() < 40) {
                return false;
            }
        } else if (xVar.b().length() < 10) {
            return false;
        }
        if (TextUtils.isEmpty(cVar.k())) {
            chapterId = dkeBook.getChapterId(cVar.g());
        } else {
            chapterId = cVar.k();
        }
        DkFlowPosition b = cVar.b(dkeBook);
        b.mChapterIndex = dkeBook.getChapterIndex(chapterId);
        DkeFuzzyMatchResult fuzzyMatch = dkeBook.fuzzyMatch(chapterId, b, xVar.b());
        if (fuzzyMatch == null) {
            return false;
        }
        DkeFuzzyMatchResult dkeFuzzyMatchResult;
        if (!fuzzyMatch.isEmpty() || (b.mParaIndex == 0 && b.mAtomIndex == 0)) {
            dkeFuzzyMatchResult = fuzzyMatch;
        } else {
            b.mParaIndex = 0;
            b.mAtomIndex = 0;
            dkeFuzzyMatchResult = dkeBook.fuzzyMatch(chapterId, b, xVar.b());
        }
        if (dkeFuzzyMatchResult.isEmpty()) {
            return false;
        }
        bb ceVar = new ce(new c(dkeFuzzyMatchResult.mStartPos.mChapterIndex, dkeFuzzyMatchResult.mStartPos.mParaIndex, dkeFuzzyMatchResult.mStartPos.mAtomIndex, dkeBook.getBookRevision(), dkeBook.getChapterId(dkeFuzzyMatchResult.mStartPos.mChapterIndex), dkeFuzzyMatchResult.mStartOffset, ah.e().a()), new c(dkeFuzzyMatchResult.mEndPos.mChapterIndex, dkeFuzzyMatchResult.mEndPos.mParaIndex, dkeFuzzyMatchResult.mEndPos.mAtomIndex, dkeBook.getBookRevision(), dkeBook.getChapterId(dkeFuzzyMatchResult.mEndPos.mChapterIndex), dkeFuzzyMatchResult.mEndOffset, ah.e().a()));
        chapterId = dkeBook.getChapterTextOfRange(ceVar.j().b(dkeBook), ceVar.k().b(dkeBook));
        xVar.a(ceVar);
        xVar.a(chapterId);
        return true;
    }

    private static boolean a(DkeBook dkeBook, x xVar) {
        bb bbVar = null;
        if (!(((ce) xVar.a()).j().j() == null || dkeBook.getBookRevision() == null || dkeBook.getBookRevision().compareTo(((ce) xVar.a()).j().j()) <= 0)) {
            long j;
            long chapterIndex = dkeBook.getChapterIndex(((ce) xVar.a()).j().k());
            long chapterIndex2 = dkeBook.getChapterIndex(((ce) xVar.a()).k().k());
            if (chapterIndex < 0) {
                chapterIndex = ((ce) xVar.a()).j().g();
            }
            c cVar = new c(chapterIndex, ((ce) xVar.a()).j().h(), ((ce) xVar.a()).j().i(), dkeBook.getBookRevision(), ((ce) xVar.a()).j().k(), ((ce) xVar.a()).j().l(), ((ce) xVar.a()).j().m());
            if (chapterIndex2 >= 0) {
                j = chapterIndex2;
            } else {
                j = ((ce) xVar.a()).k().g();
            }
            bbVar = new ce(cVar, new c(j, ((ce) xVar.a()).k().h(), ((ce) xVar.a()).k().i(), dkeBook.getBookRevision(), ((ce) xVar.a()).k().k(), ((ce) xVar.a()).k().l(), ((ce) xVar.a()).k().m()));
        }
        if (!((ce) xVar.a()).j().m().equals(ah.e().a())) {
            if (bbVar == null) {
                bbVar = new ce(new c(((ce) xVar.a()).j().g(), ((ce) xVar.a()).j().h(), ((ce) xVar.a()).j().i(), ((ce) xVar.a()).j().j(), ((ce) xVar.a()).j().k(), ((ce) xVar.a()).j().l(), ((ce) xVar.a()).j().m()), new c(((ce) xVar.a()).k().g(), ((ce) xVar.a()).k().h(), ((ce) xVar.a()).k().i(), ((ce) xVar.a()).k().j(), ((ce) xVar.a()).k().k(), ((ce) xVar.a()).k().l(), ((ce) xVar.a()).k().m()));
            }
            a(dkeBook, (Document_a) bbVar);
        }
        if (bbVar == null) {
            return false;
        }
        xVar.a(bbVar);
        return true;
    }

    public static void a(DkeBook dkeBook, long j, long j2, DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        if (!a && dkFlowPosition == null) {
            throw new AssertionError();
        } else if (a || dkFlowPosition2 != null) {
            DkePage pageOfChapterEx = dkeBook.getPageOfChapterEx(j, j2);
            if (a || pageOfChapterEx != null) {
                pageOfChapterEx.getBeginPosition(dkFlowPosition);
                pageOfChapterEx.getEndPosition(dkFlowPosition2);
                return;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    public static boolean a(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2, DkFlowPosition dkFlowPosition3) {
        if (!a && dkFlowPosition2.mChapterIndex != dkFlowPosition3.mChapterIndex) {
            throw new AssertionError();
        } else if (dkFlowPosition.mChapterIndex < dkFlowPosition2.mChapterIndex || dkFlowPosition.mChapterIndex > dkFlowPosition3.mChapterIndex) {
            return false;
        } else {
            if (dkFlowPosition2.mParaIndex == dkFlowPosition3.mParaIndex) {
                if (dkFlowPosition.mParaIndex != dkFlowPosition2.mParaIndex || dkFlowPosition.mAtomIndex < dkFlowPosition2.mAtomIndex || dkFlowPosition.mAtomIndex >= dkFlowPosition3.mAtomIndex) {
                    return false;
                }
                return true;
            } else if (dkFlowPosition.mParaIndex < dkFlowPosition2.mParaIndex || dkFlowPosition.mParaIndex > dkFlowPosition3.mParaIndex) {
                return false;
            } else {
                if (dkFlowPosition.mParaIndex == dkFlowPosition2.mParaIndex && dkFlowPosition.mAtomIndex < dkFlowPosition2.mAtomIndex) {
                    return false;
                }
                if (dkFlowPosition.mParaIndex != dkFlowPosition3.mParaIndex || dkFlowPosition.mAtomIndex < dkFlowPosition3.mAtomIndex) {
                    return true;
                }
                return false;
            }
        }
    }

    public static DkeParserOption a(am amVar, long j) {
        int max = Math.max(amVar.a, 20);
        int max2 = Math.max(amVar.b, 20);
        Rect a = amVar.a();
        DkeParserOption dkeParserOption = new DkeParserOption();
        dkeParserOption.mPageBox = new DkBox();
        dkeParserOption.mPageBox.mX0 = 0.0f;
        dkeParserOption.mPageBox.mY0 = 0.0f;
        dkeParserOption.mPageBox.mX1 = (float) max;
        dkeParserOption.mPageBox.mY1 = (float) max2;
        dkeParserOption.mPaddingBox = new DkBox();
        dkeParserOption.mPaddingBox.mX0 = (float) a.left;
        dkeParserOption.mPaddingBox.mY0 = (float) a.top;
        dkeParserOption.mPaddingBox.mX1 = (float) (max - a.right);
        dkeParserOption.mPaddingBox.mY1 = (float) (max2 - a.bottom);
        dkeParserOption.mPageTableMode = 1;
        dkeParserOption.mChapterIndex = j;
        dkeParserOption.mStuffings = amVar.l.containsKey(Long.valueOf(j)) ? ((Integer) amVar.l.get(Long.valueOf(j))).intValue() : 0;
        dkeParserOption.mBleed = amVar.e;
        return dkeParserOption;
    }

    public static String[] a(an anVar) {
        String[] strArr = new String[(anVar.a() * 2)];
        for (int i = 0; i < anVar.a(); i++) {
            b a = anVar.a(i);
            strArr[i * 2] = a.a();
            strArr[(i * 2) + 1] = a.c();
        }
        return strArr;
    }
}
