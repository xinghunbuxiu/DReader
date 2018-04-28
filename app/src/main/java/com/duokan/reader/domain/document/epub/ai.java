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
import com.duokan.reader.common.C0543b;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C1011x;
import com.duokan.reader.domain.document.bb;
import java.io.File;
import java.util.Collections;
import java.util.List;

public final class ai {
    /* renamed from: a */
    static final /* synthetic */ boolean f4484a = (!ai.class.desiredAssertionStatus());

    /* renamed from: a */
    public static aq m6506a(String str, ap apVar) {
        return m6507a(str, apVar, null);
    }

    /* renamed from: a */
    public static aq m6507a(String str, ap apVar, Callback callback) {
        DkeBook dkeBookEx;
        String[] strArr = null;
        aq aqVar = new aq();
        File file = new File(Uri.parse(str).getPath());
        if (apVar instanceof ag) {
            dkeBookEx = new DkeBookEx(file.getAbsolutePath(), ah.m6500e().m6503c(), callback, ((ag) apVar).f4477b);
        } else if (apVar instanceof al) {
            al alVar = (al) apVar;
            String[] a = m6517a(alVar.f4485b);
            dkeBookEx = new DkeBookEx(file.getAbsolutePath(), a, "", "", ah.m6500e().m6503c(), alVar.f4486c);
            strArr = a;
        } else {
            dkeBookEx = new DkeBookEx(file.getAbsolutePath(), ah.m6500e().m6503c(), callback, (byte[][]) null);
        }
        aqVar.f4488a = strArr;
        aqVar.f4489b = dkeBookEx;
        return aqVar;
    }

    /* renamed from: a */
    public static void m6512a(aq aqVar) {
        if (aqVar.f4489b != null && aqVar.f4489b.isValid()) {
            aqVar.f4489b.close();
        }
        aqVar.f4489b = null;
        aqVar.f4488a = null;
    }

    /* renamed from: a */
    public static C0936c m6508a(long j, long j2, long j3) {
        return new C0936c(j, j2, j3);
    }

    /* renamed from: a */
    public static ce m6509a(C0936c c0936c, C0936c c0936c2) {
        return new ce(c0936c, c0936c2);
    }

    /* renamed from: a */
    public static void m6511a(DkeBook dkeBook, C0896a c0896a) {
        if (c0896a instanceof C0936c) {
            ((C0936c) c0896a).m6772a(dkeBook);
        } else if (c0896a instanceof ce) {
            ((ce) c0896a).m6806a(dkeBook);
        }
    }

    /* renamed from: a */
    public static boolean m6516a(DkeBook dkeBook, List<C1011x<ce>> list) {
        boolean z = false;
        Collections.sort(list, new aj());
        C0936c c0936c = null;
        C1011x c1011x = null;
        int i = 0;
        while (i < list.size()) {
            boolean z2;
            C1011x c1011x2 = (C1011x) list.get(i);
            if (!((ce) c1011x2.m7779a()).m5777b()) {
                z2 = z;
            } else if (((ce) c1011x2.m7779a()).mo1191d()) {
                C0936c c0936c2;
                int a;
                if (c1011x == null || ((ce) c1011x.m7779a()).m6813j().m6780g() != ((ce) c1011x2.m7779a()).m6813j().m6780g()) {
                    c0936c2 = new C0936c(((ce) c1011x2.m7779a()).m6813j().m6780g(), 0, 0, "", ((ce) c1011x2.m7779a()).m6813j().m6784k(), -1, "");
                } else {
                    c0936c2 = c0936c;
                }
                boolean a2 = m6514a(dkeBook, c0936c2, c1011x2);
                if (a2) {
                    c0936c2 = ((ce) c1011x2.m7779a()).m6813j();
                    z2 = a2;
                } else {
                    a = m6515a(dkeBook, c1011x2);
                }
                z2 = a | z;
                c0936c = c0936c2;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m6514a(DkeBook dkeBook, C0936c c0936c, C1011x<ce> c1011x) {
        if (((ce) c1011x.m7779a()).m6813j().m6783j() == null) {
            return false;
        }
        if (dkeBook.getBookRevision() == null) {
            return false;
        }
        if (dkeBook.getBookRevision().compareTo(((ce) c1011x.m7779a()).m6813j().m6783j()) <= 0) {
            return false;
        }
        if (TextUtils.isEmpty(c1011x.m7782b())) {
            return false;
        }
        String chapterId;
        if (C0543b.m2422a(c1011x.m7782b())) {
            if (c1011x.m7782b().length() < 40) {
                return false;
            }
        } else if (c1011x.m7782b().length() < 10) {
            return false;
        }
        if (TextUtils.isEmpty(c0936c.m6784k())) {
            chapterId = dkeBook.getChapterId(c0936c.m6780g());
        } else {
            chapterId = c0936c.m6784k();
        }
        DkFlowPosition b = c0936c.m6774b(dkeBook);
        b.mChapterIndex = dkeBook.getChapterIndex(chapterId);
        DkeFuzzyMatchResult fuzzyMatch = dkeBook.fuzzyMatch(chapterId, b, c1011x.m7782b());
        if (fuzzyMatch == null) {
            return false;
        }
        DkeFuzzyMatchResult dkeFuzzyMatchResult;
        if (!fuzzyMatch.isEmpty() || (b.mParaIndex == 0 && b.mAtomIndex == 0)) {
            dkeFuzzyMatchResult = fuzzyMatch;
        } else {
            b.mParaIndex = 0;
            b.mAtomIndex = 0;
            dkeFuzzyMatchResult = dkeBook.fuzzyMatch(chapterId, b, c1011x.m7782b());
        }
        if (dkeFuzzyMatchResult.isEmpty()) {
            return false;
        }
        bb ceVar = new ce(new C0936c(dkeFuzzyMatchResult.mStartPos.mChapterIndex, dkeFuzzyMatchResult.mStartPos.mParaIndex, dkeFuzzyMatchResult.mStartPos.mAtomIndex, dkeBook.getBookRevision(), dkeBook.getChapterId(dkeFuzzyMatchResult.mStartPos.mChapterIndex), dkeFuzzyMatchResult.mStartOffset, ah.m6500e().m6501a()), new C0936c(dkeFuzzyMatchResult.mEndPos.mChapterIndex, dkeFuzzyMatchResult.mEndPos.mParaIndex, dkeFuzzyMatchResult.mEndPos.mAtomIndex, dkeBook.getBookRevision(), dkeBook.getChapterId(dkeFuzzyMatchResult.mEndPos.mChapterIndex), dkeFuzzyMatchResult.mEndOffset, ah.m6500e().m6501a()));
        chapterId = dkeBook.getChapterTextOfRange(ceVar.m6813j().m6774b(dkeBook), ceVar.m6814k().m6774b(dkeBook));
        c1011x.m7780a(ceVar);
        c1011x.m7781a(chapterId);
        return true;
    }

    /* renamed from: a */
    private static boolean m6515a(DkeBook dkeBook, C1011x<ce> c1011x) {
        bb bbVar = null;
        if (!(((ce) c1011x.m7779a()).m6813j().m6783j() == null || dkeBook.getBookRevision() == null || dkeBook.getBookRevision().compareTo(((ce) c1011x.m7779a()).m6813j().m6783j()) <= 0)) {
            long j;
            long chapterIndex = dkeBook.getChapterIndex(((ce) c1011x.m7779a()).m6813j().m6784k());
            long chapterIndex2 = dkeBook.getChapterIndex(((ce) c1011x.m7779a()).m6814k().m6784k());
            if (chapterIndex < 0) {
                chapterIndex = ((ce) c1011x.m7779a()).m6813j().m6780g();
            }
            C0936c c0936c = new C0936c(chapterIndex, ((ce) c1011x.m7779a()).m6813j().m6781h(), ((ce) c1011x.m7779a()).m6813j().m6782i(), dkeBook.getBookRevision(), ((ce) c1011x.m7779a()).m6813j().m6784k(), ((ce) c1011x.m7779a()).m6813j().m6785l(), ((ce) c1011x.m7779a()).m6813j().m6786m());
            if (chapterIndex2 >= 0) {
                j = chapterIndex2;
            } else {
                j = ((ce) c1011x.m7779a()).m6814k().m6780g();
            }
            bbVar = new ce(c0936c, new C0936c(j, ((ce) c1011x.m7779a()).m6814k().m6781h(), ((ce) c1011x.m7779a()).m6814k().m6782i(), dkeBook.getBookRevision(), ((ce) c1011x.m7779a()).m6814k().m6784k(), ((ce) c1011x.m7779a()).m6814k().m6785l(), ((ce) c1011x.m7779a()).m6814k().m6786m()));
        }
        if (!((ce) c1011x.m7779a()).m6813j().m6786m().equals(ah.m6500e().m6501a())) {
            if (bbVar == null) {
                bbVar = new ce(new C0936c(((ce) c1011x.m7779a()).m6813j().m6780g(), ((ce) c1011x.m7779a()).m6813j().m6781h(), ((ce) c1011x.m7779a()).m6813j().m6782i(), ((ce) c1011x.m7779a()).m6813j().m6783j(), ((ce) c1011x.m7779a()).m6813j().m6784k(), ((ce) c1011x.m7779a()).m6813j().m6785l(), ((ce) c1011x.m7779a()).m6813j().m6786m()), new C0936c(((ce) c1011x.m7779a()).m6814k().m6780g(), ((ce) c1011x.m7779a()).m6814k().m6781h(), ((ce) c1011x.m7779a()).m6814k().m6782i(), ((ce) c1011x.m7779a()).m6814k().m6783j(), ((ce) c1011x.m7779a()).m6814k().m6784k(), ((ce) c1011x.m7779a()).m6814k().m6785l(), ((ce) c1011x.m7779a()).m6814k().m6786m()));
            }
            m6511a(dkeBook, (C0896a) bbVar);
        }
        if (bbVar == null) {
            return false;
        }
        c1011x.m7780a(bbVar);
        return true;
    }

    /* renamed from: a */
    public static void m6510a(DkeBook dkeBook, long j, long j2, DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        if (!f4484a && dkFlowPosition == null) {
            throw new AssertionError();
        } else if (f4484a || dkFlowPosition2 != null) {
            DkePage pageOfChapterEx = dkeBook.getPageOfChapterEx(j, j2);
            if (f4484a || pageOfChapterEx != null) {
                pageOfChapterEx.getBeginPosition(dkFlowPosition);
                pageOfChapterEx.getEndPosition(dkFlowPosition2);
                return;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static boolean m6513a(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2, DkFlowPosition dkFlowPosition3) {
        if (!f4484a && dkFlowPosition2.mChapterIndex != dkFlowPosition3.mChapterIndex) {
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

    /* renamed from: a */
    public static DkeParserOption m6505a(am amVar, long j) {
        int max = Math.max(amVar.a, 20);
        int max2 = Math.max(amVar.b, 20);
        Rect a = amVar.m6083a();
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
        dkeParserOption.mStuffings = amVar.f4487l.containsKey(Long.valueOf(j)) ? ((Integer) amVar.f4487l.get(Long.valueOf(j))).intValue() : 0;
        dkeParserOption.mBleed = amVar.e;
        return dkeParserOption;
    }

    /* renamed from: a */
    public static String[] m6517a(an anVar) {
        String[] strArr = new String[(anVar.mo1067a() * 2)];
        for (int i = 0; i < anVar.mo1067a(); i++) {
            C0809b a = anVar.mo1069a(i);
            strArr[i * 2] = a.mo1056a();
            strArr[(i * 2) + 1] = a.mo1058c();
        }
        return strArr;
    }
}
