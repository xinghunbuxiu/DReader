package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.C0366o;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.kernel.epublib.DkePage;
import com.duokan.kernel.epublib.DkeResourceDescriptor;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0899j;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0908f;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.C0930b;
import com.duokan.reader.domain.document.C1012y;
import com.duokan.reader.domain.document.C1013z;
import com.duokan.reader.domain.document.FootnoteStyle;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.EpubTypesettingContext.ChapterState;
import java.lang.Thread.State;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.duokan.reader.domain.document.epub.s */
public class C0952s extends C0903n implements at {
    /* renamed from: i */
    static final /* synthetic */ boolean f4722i = (!C0952s.class.desiredAssertionStatus());
    /* renamed from: j */
    private final ae f4723j;
    /* renamed from: k */
    private C0934e f4724k = null;
    /* renamed from: l */
    private final LinkedList<EpubTypesettingContext> f4725l = new LinkedList();
    /* renamed from: m */
    private final Semaphore f4726m = new Semaphore(0);
    /* renamed from: n */
    private final Semaphore f4727n = new Semaphore(0);
    /* renamed from: o */
    private final am f4728o;
    /* renamed from: p */
    private String f4729p = "";
    /* renamed from: q */
    private boolean f4730q = false;
    /* renamed from: r */
    private long f4731r = 0;
    /* renamed from: s */
    private final Thread f4732s;
    /* renamed from: t */
    private final Thread f4733t;
    /* renamed from: u */
    private final ThreadLocal<HashSet<av>> f4734u = new ThreadLocal();
    /* renamed from: v */
    private final ThreadLocal<HashSet<av>> f4735v = new ThreadLocal();
    /* renamed from: w */
    private au f4736w = null;
    /* renamed from: x */
    private final ExecutorService f4737x = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public /* synthetic */ ak mo1213a(long j) {
        return m7075h(j);
    }

    /* renamed from: a */
    public /* synthetic */ bb mo1216a(C0897d c0897d, C0897d c0897d2) {
        return m7053b(c0897d, c0897d2);
    }

    /* renamed from: c */
    public /* synthetic */ ak mo1230c(av avVar) {
        return m7063d(avVar);
    }

    /* renamed from: d */
    public /* synthetic */ ak mo1232d(ak akVar) {
        return m7082k(akVar);
    }

    /* renamed from: e */
    public /* synthetic */ ak mo1235e(ak akVar) {
        return m7084l(akVar);
    }

    /* renamed from: f */
    public /* synthetic */ ak mo1237f(ak akVar) {
        return m7086m(akVar);
    }

    /* renamed from: g */
    public /* synthetic */ ak mo1239g(ak akVar) {
        return m7088n(akVar);
    }

    /* renamed from: h */
    public /* synthetic */ C0911h mo1240h() {
        return m7028E();
    }

    /* renamed from: l */
    public /* synthetic */ C0923m mo1246l() {
        return m7030G();
    }

    /* renamed from: q */
    public /* synthetic */ av mo1248q() {
        return m7031H();
    }

    /* renamed from: r */
    public /* synthetic */ ak mo1249r() {
        return m7032I();
    }

    public C0952s(ae aeVar) {
        WebLog.init().w(m5889A());
        DkUtils.initWordSeg(ah.m6500e().m6502b());
        this.f4723j = aeVar;
        this.f4728o = new am();
        this.f4736w = new au();
        this.f4732s = new Thread(new C0953t(this));
        this.f4733t = new Thread(new C0954u(this));
    }

    /* renamed from: B */
    public String m7025B() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4724k.mo1365h().getBookRevision();
        }
        return "";
    }

    /* renamed from: C */
    public an m7026C() {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return null;
        }
        C0919l c = this.f4724k.mo1257c();
        return c instanceof al ? ((al) c).f4485b : null;
    }

    /* renamed from: D */
    public long m7027D() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4724k.mo1366i();
        }
        return 0;
    }

    /* renamed from: b */
    public long m7050b(long j) {
        WebLog.init().w(m5889A());
        if (m7027D() <= 0) {
            return 0;
        }
        long b = m7001b(m6979L(), j);
        if (b < 0) {
            return 0;
        }
        return b;
    }

    /* renamed from: c */
    public C0930b[] m7060c(long j) {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4724k.mo1364a(j);
        }
        return new C0930b[0];
    }

    /* renamed from: a */
    public static C0936c m6987a(long j, long j2, long j3) {
        return new C0936c(j, j2, j3);
    }

    /* renamed from: a */
    public static C0936c m6988a(long j, long j2, long j3, String str, String str2, long j4, String str3) {
        return new C0936c(j, j2, j3, str, str2, j4, str3);
    }

    /* renamed from: a */
    public ce m7043a(C0936c c0936c, C0936c c0936c2) {
        WebLog.init().w(m5889A());
        return new ce(c0936c, c0936c2);
    }

    /* renamed from: s */
    public bb mo1250s() {
        WebLog.init().w(m5889A());
        return new ce();
    }

    /* renamed from: a */
    public ar m7041a(long j, long j2) {
        WebLog.init().w(m5889A());
        return new ay(m6979L(), j, 0, 0, j2);
    }

    /* renamed from: a */
    public ar m7042a(long j, String str) {
        WebLog.init().w(m5889A());
        return new ay(m6979L(), j, str, 0);
    }

    /* renamed from: d */
    public av m7064d(long j) {
        WebLog.init().w(m5889A());
        if (!m5945p() || this.f4723j == null) {
            return null;
        }
        av a = this.f4723j.mo1060a(new aw(this.f4724k.mo1365h().getChapterResource(j)), false);
        if (!a.mo1072h()) {
            a = null;
        }
        return a;
    }

    /* renamed from: e */
    public boolean m7068e(long j) {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4724k.mo1365h().isDrmChapter(j);
        }
        return false;
    }

    /* renamed from: f */
    public String m7071f(long j) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return "";
        }
        C0934e c0934e = this.f4724k;
        if (c0934e.m6464c(j)) {
            return c0934e.mo1365h().getChapterId(j);
        }
        return "";
    }

    /* renamed from: g */
    public String m7074g(long j) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return "";
        }
        String chapterPackUri = this.f4724k.mo1365h().getChapterPackUri(j);
        return TextUtils.equals(chapterPackUri, "/") ? "" : chapterPackUri;
    }

    /* renamed from: b */
    public static aw[] m7006b(String str) {
        int i = 0;
        ap apVar = new ap();
        apVar.a = str;
        aq a = ai.m6507a(str, apVar, null);
        if (!a.f4489b.isValid()) {
            return new aw[0];
        }
        DkeBook dkeBook = a.f4489b;
        DkeResourceDescriptor[] allResources = dkeBook.getAllResources();
        aw[] awVarArr = new aw[allResources.length];
        while (i < awVarArr.length) {
            awVarArr[i] = new aw(allResources[i]);
            i++;
        }
        dkeBook.close();
        return awVarArr;
    }

    /* renamed from: c */
    public WritingDirection mo1228c() {
        if (!m5945p()) {
            return WritingDirection.TOP_TO_BOTTOM;
        }
        switch (this.f4724k.mo1365h().getWritingMode()) {
            case 0:
                return WritingDirection.TOP_TO_BOTTOM;
            case 1:
                return WritingDirection.RIGHT_TO_LEFT;
            case 2:
                return WritingDirection.LEFT_TO_RIGHT;
            default:
                return WritingDirection.TOP_TO_BOTTOM;
        }
    }

    /* renamed from: d */
    public FootnoteStyle mo1231d() {
        if (!m5945p()) {
            return FootnoteStyle.NONE;
        }
        switch (this.f4724k.mo1365h().getFootnoteAppearanceType()) {
            case 1:
                return FootnoteStyle.BUBBLE;
            case 2:
                return FootnoteStyle.PAPERTAPE;
            default:
                return FootnoteStyle.NONE;
        }
    }

    /* renamed from: e */
    public long mo1234e() {
        long b;
        WebLog.init().w(m5889A());
        synchronized (this) {
            EpubTypesettingContext epubTypesettingContext = (EpubTypesettingContext) this.f4725l.getLast();
            if (f4722i || epubTypesettingContext != null) {
                b = epubTypesettingContext.m5839b();
            } else {
                throw new AssertionError();
            }
        }
        return b;
    }

    /* renamed from: f */
    public int mo1236f() {
        WebLog.init().w(m5889A());
        return 0;
    }

    /* renamed from: g */
    public float mo1238g() {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return 0.0f;
        }
        EpubTypesettingContext L = m6979L();
        C0934e e = L.mo1369e();
        if (e != null) {
            return (((float) L.f4453k) / ((float) e.mo1366i())) * 100.0f;
        }
        return 0.0f;
    }

    /* renamed from: E */
    public C0935g m7028E() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return (C0935g) this.f4724k.mo1258d();
        }
        return null;
    }

    /* renamed from: F */
    public C0919l m7029F() {
        WebLog.init().w(m5889A());
        EpubTypesettingContext L = m6979L();
        return L == null ? null : L.m6454i();
    }

    /* renamed from: i */
    public boolean mo1242i() {
        boolean z = true;
        WebLog.init().w(m5889A());
        synchronized (this) {
            if (this.f4725l.size() <= 1) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: j */
    public boolean mo1244j() {
        WebLog.init().w(m5889A());
        return m6979L().mo1272c();
    }

    /* renamed from: k */
    public C0917k mo1245k() {
        C0917k j;
        WebLog.init().w(m5889A());
        synchronized (this) {
            EpubTypesettingContext epubTypesettingContext = (EpubTypesettingContext) this.f4725l.getLast();
            if (f4722i || epubTypesettingContext != null) {
                j = epubTypesettingContext.m6455j();
            } else {
                throw new AssertionError();
            }
        }
        return j;
    }

    /* renamed from: a */
    public void mo1218a(C0917k c0917k) {
        WebLog.init().w(m5889A());
        if (f4722i || c0917k != null) {
            synchronized (this) {
                EpubTypesettingContext L = m6979L();
                if (!L.m6455j().equals(c0917k)) {
                    this.f4725l.addLast(new ad(this, L.m6454i(), new am((am) c0917k), this.f4726m));
                }
            }
            this.f4726m.release();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: G */
    public au m7030G() {
        WebLog.init().w(m5889A());
        return this.f4736w;
    }

    /* renamed from: a */
    public void mo1220a(C0923m c0923m) {
        WebLog.init().w(m5889A());
        if (f4722i || c0923m != null) {
            this.f4736w = (au) c0923m;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public C0908f mo1247m() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return this.f4724k.mo1259e();
        }
        return null;
    }

    /* renamed from: a */
    public void mo1219a(C0919l c0919l) {
        WebLog.init().m762a(this.a);
        if (!this.a) {
            if (this.f4732s.getState() == State.NEW) {
                this.f4725l.addLast(new ad(this, (ap) c0919l, this.f4728o, this.f4726m));
                this.f4732s.start();
                return;
            }
            synchronized (this) {
                this.f4725l.addLast(new ad(this, (ap) c0919l, m6979L().m6455j(), this.f4726m));
            }
            this.f4726m.release();
        }
    }

    /* renamed from: j */
    public float m7080j(ak akVar) {
        WebLog.init().w(m5889A());
        if (!mo1233d((C0896a) akVar) || !akVar.mo1192e()) {
            return 0.0f;
        }
        float f;
        float max;
        long chapterPackSize;
        C0934e c0934e = this.f4724k;
        ak akVar2 = (ak) mo1229c((C0896a) akVar);
        C0936c c0936c = (C0936c) akVar2.mo1198g();
        C0936c c0936c2 = (C0936c) akVar2.mo1199h();
        long g = c0936c.m6780g();
        long chapterCount = c0934e.mo1365h().getChapterCount();
        if (c0934e.mo1257c() instanceof al) {
            f = 1.0f / ((float) chapterCount);
            max = ((float) Math.max(0, g - 1)) / ((float) chapterCount);
        } else {
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (j3 < chapterCount) {
                chapterPackSize = c0934e.mo1365h().getChapterPackSize(j3);
                j2 += chapterPackSize;
                if (j3 < g) {
                    chapterPackSize += j;
                } else if (j3 == g) {
                    j4 = chapterPackSize;
                    chapterPackSize = j;
                } else {
                    chapterPackSize = j;
                }
                j3 = 1 + j3;
                j = chapterPackSize;
            }
            f = Math.max(0.0f, Math.min(((float) j4) / ((float) j2), 1.0f));
            max = Math.max(0.0f, Math.min(((float) j) / ((float) j2), 1.0f));
        }
        chapterPackSize = c0934e.mo1365h().getChapterOffsetRange(g)[1];
        return (Math.max(0.0f, Math.min(chapterPackSize == 0 ? 1.0f : ((float) c0936c2.m6785l()) / ((float) chapterPackSize), 1.0f)) * f) + max;
    }

    /* renamed from: b */
    public long mo1223b(ak akVar) {
        WebLog.init().w(m5889A());
        if (!mo1233d((C0896a) akVar) || !akVar.mo1192e()) {
            return -1;
        }
        C0936c c0936c = (C0936c) akVar.mo1198g();
        EpubTypesettingContext L = m6979L();
        if (f4722i || L != null) {
            return L.m6441a(c0936c.m6780g(), c0936c.m6781h(), c0936c.m6782i());
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public long mo1209a(av avVar) {
        C0936c c0936c = (C0936c) avVar;
        EpubTypesettingContext L = m6979L();
        if (f4722i || L != null) {
            return L.m6441a(c0936c.m6780g(), c0936c.m6781h(), c0936c.m6782i());
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public long mo1227c(ak akVar) {
        WebLog.init().w(m5889A());
        return -1;
    }

    /* renamed from: b */
    public long mo1224b(av avVar) {
        WebLog.init().w(m5889A());
        return -1;
    }

    /* renamed from: b */
    public int mo1222b(int i) {
        WebLog.init().w(m5889A());
        return -1;
    }

    /* renamed from: c */
    public int mo1226c(int i) {
        WebLog.init().w(m5889A());
        return -1;
    }

    /* renamed from: H */
    public C0936c m7031H() {
        WebLog.init().w(m5889A());
        if (m5945p()) {
            return C0952s.m6987a(this.f4724k.mo1365h().getLeadingChapterIndex(), 0, 0);
        }
        return C0952s.m6987a(0, 0, 0);
    }

    /* renamed from: k */
    public C0940h m7082k(ak akVar) {
        WebLog.init().w(m5889A());
        EpubTypesettingContext L = m6979L();
        if (akVar instanceof C0940h) {
            return (C0940h) mo1214a((C0940h) akVar, 0);
        }
        if (!(akVar instanceof ay)) {
            return null;
        }
        ay ayVar = (ay) akVar;
        EpubTypesettingContext j = ayVar.m6532j();
        if (ayVar.m5777b() || j == L || mo1233d((C0896a) ayVar)) {
            return new C0940h(L, ayVar, 0);
        }
        return null;
    }

    /* renamed from: I */
    public ar m7032I() {
        WebLog.init().w(m5889A());
        return new ay(m6979L(), m7027D() - 1, Long.MAX_VALUE, 0, -1);
    }

    /* renamed from: c */
    public C0896a mo1229c(C0896a c0896a) {
        WebLog.init().w(m5889A());
        WebLog.init().w(c0896a != null);
        if (!m5945p()) {
            return null;
        }
        if (mo1233d(c0896a) && c0896a.mo1192e()) {
            C0934e c0934e = this.f4724k;
            if (c0896a instanceof C0936c) {
                C0936c c0936c = (C0936c) c0896a;
                return C0952s.m6988a(c0936c.m6780g(), c0936c.m6781h(), c0936c.m6782i(), c0934e.mo1365h().getBookRevision(), c0934e.mo1365h().getChapterId(c0936c.m6780g()), C0952s.m7000a(c0934e.mo1365h(), c0936c.m6774b(c0934e.mo1365h()), new DkFlowPosition(c0936c.m6780g(), Long.MAX_VALUE, 0))[0], ah.m6500e().m6501a());
            } else if (c0896a instanceof ce) {
                ce ceVar = (ce) c0896a;
                r9 = ceVar.m6813j();
                r13 = ceVar.m6814k();
                r15 = C0952s.m7000a(c0934e.mo1365h(), r9.m6774b(c0934e.mo1365h()), r13.m6774b(c0934e.mo1365h()));
                r12 = ah.m6500e().m6501a();
                return m7043a(C0952s.m6988a(r9.m6780g(), r9.m6781h(), r9.m6782i(), c0934e.mo1365h().getBookRevision(), c0934e.mo1365h().getChapterId(r9.m6780g()), r15[0], r12), C0952s.m6988a(r13.m6780g(), r13.m6781h(), r13.m6782i(), c0934e.mo1365h().getBookRevision(), c0934e.mo1365h().getChapterId(r13.m6780g()), r15[1], r12));
            } else if (c0896a instanceof ar) {
                ar arVar = (ar) c0896a;
                r9 = (C0936c) arVar.mo1198g();
                r13 = (C0936c) arVar.mo1199h();
                r15 = C0952s.m7000a(c0934e.mo1365h(), r9.m6774b(c0934e.mo1365h()), r13.m6774b(c0934e.mo1365h()));
                r12 = ah.m6500e().m6501a();
                return new ay(m6979L(), C0952s.m6988a(r9.m6780g(), r9.m6781h(), r9.m6782i(), c0934e.mo1365h().getBookRevision(), c0934e.mo1365h().getChapterId(r9.m6780g()), r15[0], r12), C0952s.m6988a(r13.m6780g(), r13.m6781h(), r13.m6782i(), c0934e.mo1365h().getBookRevision(), c0934e.mo1365h().getChapterId(r13.m6780g()), r15[1], r12));
            }
        }
        return null;
    }

    /* renamed from: b */
    public ce m7053b(C0897d c0897d, C0897d c0897d2) {
        return m7043a((C0936c) c0897d, (C0936c) c0897d2);
    }

    /* renamed from: h */
    public ay m7075h(long j) {
        WebLog.init().w(m5889A());
        return new ay(m6979L(), 0, 0, 0, j);
    }

    /* renamed from: d */
    public ar m7063d(av avVar) {
        WebLog.init().w(m5889A());
        EpubTypesettingContext L = m6979L();
        C0936c c0936c = (C0936c) avVar;
        if (f4722i || c0936c != null) {
            return new ay(L, c0936c.m6780g(), c0936c.m6781h(), c0936c.m6782i(), 0);
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    public ar m7084l(ak akVar) {
        WebLog.init().w(m5889A());
        if (!f4722i && (akVar == null || !akVar.mo1186a())) {
            throw new AssertionError();
        } else if (akVar instanceof C0940h) {
            return (ar) mo1214a(((C0940h) akVar).m6846j(), 0);
        } else {
            if (akVar instanceof ay) {
                return (ar) mo1214a((ay) akVar, 0);
            }
            return null;
        }
    }

    /* renamed from: m */
    public ar m7086m(ak akVar) {
        WebLog.init().w(m5889A());
        return (ar) mo1214a(akVar, 1);
    }

    /* renamed from: n */
    public ar m7088n(ak akVar) {
        WebLog.init().w(m5889A());
        return (ar) mo1214a(akVar, -1);
    }

    /* renamed from: a */
    public ak mo1214a(ak akVar, int i) {
        WebLog.init().w(m5889A());
        if (f4722i || (akVar != null && akVar.mo1186a())) {
            EpubTypesettingContext L = m6979L();
            EpubTypesettingContext j;
            if (akVar instanceof C0940h) {
                C0940h c0940h = (C0940h) akVar;
                j = c0940h.m6846j().m6532j();
                if (c0940h.m5777b() || j == L || mo1233d((C0896a) c0940h)) {
                    return new C0940h(L, c0940h, (long) i);
                }
                return null;
            } else if (!(akVar instanceof ay)) {
                return null;
            } else {
                ay ayVar = (ay) akVar;
                j = ayVar.m6532j();
                if (ayVar.m5777b() || j == L || mo1233d((C0896a) ayVar)) {
                    return new ay(L, ayVar, (long) i);
                }
                return null;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public boolean mo1241h(ak akVar) {
        boolean z = true;
        WebLog.init().w(m5889A());
        if (akVar instanceof C0940h) {
            C0940h c0940h = (C0940h) akVar;
            if (mo1241h(c0940h.m6847k()) || mo1241h(c0940h.m6848l())) {
                return true;
            }
            return false;
        } else if (!(akVar instanceof ay)) {
            return false;
        } else {
            akVar = (ay) akVar;
            if (akVar.m5777b()) {
                if (!(akVar.m6533k().m6780g() == 0 && m6985a((ay) akVar) == 0)) {
                    z = false;
                }
                return z;
            }
            if (!(mo1233d((C0896a) akVar) && akVar.mo1192e() && mo1241h(akVar))) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: i */
    public boolean mo1243i(ak akVar) {
        boolean z = true;
        WebLog.init().w(m5889A());
        if (akVar instanceof C0940h) {
            C0940h c0940h = (C0940h) akVar;
            if (mo1243i(c0940h.m6848l()) || mo1243i(c0940h.m6847k())) {
                return true;
            }
            return false;
        } else if (!(akVar instanceof ay)) {
            return false;
        } else {
            akVar = (ay) akVar;
            if (akVar.m5777b()) {
                long g = akVar.m6533k().m6780g();
                long b = m7050b(g);
                if (b < 1) {
                    return false;
                }
                if (!(g == m7027D() - 1 && m6985a((ay) akVar) == b - 1)) {
                    z = false;
                }
                return z;
            } else if (akVar.f4503b == m7027D() - 1 && akVar.f4506e == Long.MAX_VALUE && akVar.f4508g == -1) {
                return true;
            } else {
                if (!(mo1233d((C0896a) akVar) && akVar.mo1192e() && mo1243i(akVar))) {
                    z = false;
                }
                return z;
            }
        }
    }

    /* renamed from: d */
    public boolean mo1233d(C0896a c0896a) {
        WebLog.init().w(m5889A());
        if (!f4722i && c0896a == null) {
            throw new AssertionError();
        } else if (!f4722i && !c0896a.mo1186a()) {
            throw new AssertionError();
        } else if (!c0896a.mo1186a()) {
            return false;
        } else {
            if (c0896a.m5777b()) {
                return true;
            }
            if (c0896a instanceof C0940h) {
                C0940h c0940h = (C0940h) c0896a;
                EpubTypesettingContext j = c0940h.m6846j().m6532j();
                synchronized (this) {
                    if (j.a) {
                        j.m6444a(c0940h, null);
                    } else {
                        return false;
                    }
                }
            }
            if (c0896a instanceof ay) {
                ay ayVar = (ay) c0896a;
                EpubTypesettingContext j2 = ayVar.m6532j();
                synchronized (this) {
                    if (j2.a) {
                        j2.m6443a(ayVar, null);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    public as mo1215a(ak akVar, C0923m c0923m) {
        WebLog.init().w(m5889A());
        if (f4722i || akVar != null) {
            au G = c0923m == null ? m7030G() : (au) c0923m;
            mo1233d((C0896a) akVar);
            EpubTypesettingContext L = m6979L();
            if (akVar instanceof C0940h) {
                return new C0942i(L, (C0940h) akVar, G, this.g, this);
            }
            if (akVar instanceof ay) {
                return new az(L, (ay) akVar, G, this.g, this);
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Bitmap mo1210a(String str, Rect rect, int i, int i2) {
        Bitmap c = C0544a.m2447c(i, i2, Config.RGB_565);
        c.eraseColor(-1);
        new DkFlowRenderOption().mBitmap = c;
        DkBox dkBox = new DkBox((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        dkBox = new DkBox(0.0f, 0.0f, (float) i, (float) i2);
        m6980M();
        return c;
    }

    /* renamed from: a */
    public aa mo1212a(av avVar, String str, int i) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return new aa(str);
        }
        if (avVar == null) {
            avVar = C0952s.m6987a(0, 0, 0);
        }
        C0934e c0934e = this.f4724k;
        c0934e.mo1260f();
        return m6986a(c0934e, avVar, str, i);
    }

    /* renamed from: a */
    public aa mo1211a(aa aaVar, int i) {
        WebLog.init().w(m5889A());
        if (!f4722i && aaVar == null) {
            throw new AssertionError();
        } else if (!m5945p()) {
            return new aa(aaVar.f4314a);
        } else {
            if (aaVar.f4315b.length < 1) {
                return new aa(aaVar.f4314a);
            }
            C0934e c0934e = this.f4724k;
            c0934e.mo1260f();
            return m6986a(c0934e, aaVar.f4315b[aaVar.f4315b.length - 1].f5024a.mo1199h(), aaVar.f4314a, i);
        }
    }

    /* renamed from: a */
    public C1012y mo1217a(String str) {
        WebLog.init().w(m5889A());
        if (!m5945p()) {
            return null;
        }
        C0899j c0899j = this.f4724k;
        return new C1012y(c0899j, c0899j.mo1365h().getFileStream(str));
    }

    /* renamed from: t */
    protected void mo1251t() {
        synchronized (this) {
            ad adVar = new ad(this, m6979L().m6454i(), new am(), this.f4726m);
            adVar.c = true;
            this.f4725l.add(adVar);
        }
        this.f4726m.release();
    }

    /* renamed from: a */
    public void mo1221a(C0903n c0903n, as asVar) {
        m5905a(asVar);
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
        m5917b(asVar);
    }

    /* renamed from: a */
    private String m6990a(EpubTypesettingContext epubTypesettingContext) {
        C0934e e = epubTypesettingContext.mo1369e();
        if (epubTypesettingContext.m6454i() instanceof al) {
            return m7002b(epubTypesettingContext);
        }
        if (e.mo1365h().isLinear()) {
            return m7007c(epubTypesettingContext);
        }
        return m7009d(epubTypesettingContext);
    }

    /* renamed from: b */
    private String m7002b(EpubTypesettingContext epubTypesettingContext) {
        an anVar = ((al) epubTypesettingContext.m6454i()).f4485b;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < anVar.mo1067a(); i++) {
            stringBuilder.append(anVar.mo1069a(i).mo1058c()).append(';');
        }
        return C0366o.m1034b(stringBuilder.toString(), "md5");
    }

    /* renamed from: c */
    private String m7007c(EpubTypesettingContext epubTypesettingContext) {
        int i;
        C0934e e = epubTypesettingContext.mo1369e();
        DkeResourceDescriptor[] allResources = e.mo1365h().getAllResources();
        LinkedList linkedList = new LinkedList();
        for (DkeResourceDescriptor dkeResourceDescriptor : allResources) {
            if (dkeResourceDescriptor.resourceType == 0 || dkeResourceDescriptor.resourceType == 3 || dkeResourceDescriptor.resourceType == 1) {
                linkedList.add(dkeResourceDescriptor.packUri);
            }
        }
        if (this.f4723j != null) {
            for (DkeResourceDescriptor dkeResourceDescriptor2 : allResources) {
                if ((dkeResourceDescriptor2.resourceType == 0 || dkeResourceDescriptor2.resourceType == 3 || dkeResourceDescriptor2.resourceType == 1) && !this.f4723j.mo1060a(new aw(dkeResourceDescriptor2), false).mo1073i()) {
                    linkedList.remove(dkeResourceDescriptor2.packUri);
                }
            }
        } else {
            linkedList.clear();
        }
        if (epubTypesettingContext.f4453k == e.mo1366i()) {
            for (i = 0; ((long) i) < e.mo1366i(); i++) {
                for (av g : epubTypesettingContext.m6448c((long) i)) {
                    linkedList.remove(g.mo1071g().f4492a);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next()).append(';');
        }
        stringBuilder.append("drm=").append(epubTypesettingContext.m6454i() instanceof ag);
        return C0366o.m1034b(stringBuilder.toString(), "md5");
    }

    /* renamed from: d */
    private String m7009d(EpubTypesettingContext epubTypesettingContext) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("drm=").append(epubTypesettingContext.m6454i() instanceof ag);
        return C0366o.m1034b(stringBuilder.toString(), "md5");
    }

    /* renamed from: a */
    private ak m6986a(C0934e c0934e, av avVar, String str, int i) {
        if (f4722i || avVar != null) {
            Object c0955v = new C0955v(this, str, i, avVar, c0934e, str);
            if (this.f4737x.isShutdown()) {
                c0955v.b = new C1013z[0];
                m5904a((aa) c0955v);
            } else {
                this.f4737x.execute(c0955v);
            }
            return c0955v;
        }
        throw new AssertionError();
    }

    /* renamed from: J */
    private void m6977J() {
        while (true) {
            try {
                if (this.f4730q) {
                    this.f4727n.tryAcquire(10, TimeUnit.MILLISECONDS);
                } else {
                    this.f4727n.acquireUninterruptibly();
                }
            } catch (InterruptedException e) {
                if (!f4722i) {
                    throw new AssertionError();
                }
            }
            synchronized (this) {
                EpubTypesettingContext epubTypesettingContext = (ad) this.f4725l.getFirst();
                int i = this.f4725l.size() > 1 ? 1 : 0;
            }
            if (epubTypesettingContext.b) {
                ch chVar;
                C0934e e2 = epubTypesettingContext.mo1369e();
                synchronized (epubTypesettingContext) {
                    Iterator it = epubTypesettingContext.n.iterator();
                    while (it.hasNext()) {
                        ch chVar2 = (ch) it.next();
                        if (!f4722i && chVar2 == null) {
                            throw new AssertionError();
                        } else if (!f4722i && chVar2.f4664c == null) {
                            throw new AssertionError();
                        } else if (!chVar2.f4664c.m6795b()) {
                            chVar = null;
                            break;
                        } else if (chVar2.f4664c.m6797d()) {
                            it.remove();
                            if (chVar2.f4663b != null) {
                                chVar2.f4663b.mo1378b(chVar2.f4664c);
                            }
                        } else if (chVar2.f4664c.m6796c()) {
                            it.remove();
                            chVar = chVar2;
                            break;
                        } else if (m6998a(epubTypesettingContext, chVar2)) {
                            it.remove();
                            chVar = chVar2;
                            break;
                        }
                    }
                    chVar = null;
                    Object obj;
                    if (epubTypesettingContext.n.size() > 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (chVar != null) {
                    if (chVar.f4662a.mo1189c()) {
                        C0936c a;
                        C0936c c0936c;
                        C0936c a2;
                        if (chVar.f4664c.f4649c) {
                            a2 = C0952s.m6987a(0, Long.MIN_VALUE, 0);
                            a2.m6769a(epubTypesettingContext);
                            a2.f4625a = chVar.f4664c.f4648b;
                            a = C0952s.m6987a(0, Long.MIN_VALUE, 0);
                            a.m6769a(epubTypesettingContext);
                            a.f4625a = chVar.f4664c.f4648b;
                            c0936c = a2;
                        } else if (chVar.f4664c.f4650d) {
                            a2 = C0952s.m6987a(chVar.f4664c.f4647a, Long.MAX_VALUE, 0);
                            a2.m6769a(epubTypesettingContext);
                            a2.f4625a = chVar.f4664c.f4648b;
                            a = C0952s.m6987a(chVar.f4664c.f4647a, Long.MAX_VALUE, 0);
                            a.m6769a(epubTypesettingContext);
                            a.f4625a = chVar.f4664c.f4648b;
                            c0936c = a2;
                        } else {
                            DkFlowPosition dkFlowPosition = new DkFlowPosition();
                            DkFlowPosition dkFlowPosition2 = new DkFlowPosition();
                            ai.m6510a(e2.mo1365h(), chVar.f4664c.f4647a, chVar.f4664c.f4648b, dkFlowPosition, dkFlowPosition2);
                            a2 = C0952s.m6987a(dkFlowPosition.mChapterIndex, dkFlowPosition.mParaIndex, dkFlowPosition.mAtomIndex);
                            a2.m6769a(epubTypesettingContext);
                            a2.f4625a = chVar.f4664c.f4648b;
                            a = C0952s.m6987a(dkFlowPosition2.mChapterIndex, dkFlowPosition2.mParaIndex, dkFlowPosition2.mAtomIndex);
                            a.m6769a(epubTypesettingContext);
                            a.f4625a = chVar.f4664c.f4648b;
                            c0936c = a2;
                        }
                        chVar.f4662a.m6525a(c0936c, a);
                    }
                    if (chVar.f4663b != null) {
                        chVar.f4663b.mo1377a(chVar.f4664c);
                    }
                }
                if (i == 1 && obj == null && chVar == null && epubTypesettingContext.m5837a()) {
                    synchronized (this) {
                        if (epubTypesettingContext.m6456k() == null) {
                            epubTypesettingContext.a = false;
                            this.f4725l.removeFirst();
                            this.f4727n.drainPermits();
                            this.f4726m.release();
                            if (((EpubTypesettingContext) this.f4725l.getFirst()).c) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: K */
    private void m6978K() {
        /*
        r16 = this;
        r6 = 0;
    L_0x0001:
        monitor-enter(r16);
        r0 = r16;
        r2 = r0.f4725l;	 Catch:{ all -> 0x003b }
        r2 = r2.size();	 Catch:{ all -> 0x003b }
        r3 = 1;
        if (r2 <= r3) goto L_0x0027;
    L_0x000d:
        r2 = 1;
        r7 = r2;
    L_0x000f:
        r0 = r16;
        r2 = r0.f4725l;	 Catch:{ all -> 0x003b }
        r2 = r2.getFirst();	 Catch:{ all -> 0x003b }
        r0 = r2;
        r0 = (com.duokan.reader.domain.document.epub.ad) r0;	 Catch:{ all -> 0x003b }
        r4 = r0;
        r2 = r4.c;	 Catch:{ all -> 0x003b }
        if (r2 == 0) goto L_0x002a;
    L_0x001f:
        monitor-exit(r16);	 Catch:{ all -> 0x003b }
        r16.m6983P();
        r16.m5953x();
    L_0x0026:
        return;
    L_0x0027:
        r2 = 0;
        r7 = r2;
        goto L_0x000f;
    L_0x002a:
        monitor-exit(r16);	 Catch:{ all -> 0x003b }
        if (r6 == r4) goto L_0x04f6;
    L_0x002d:
        r2 = f4722i;
        if (r2 != 0) goto L_0x003e;
    L_0x0031:
        r2 = r4.b;
        if (r2 == 0) goto L_0x003e;
    L_0x0035:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x003b:
        r2 = move-exception;
        monitor-exit(r16);	 Catch:{ all -> 0x003b }
        throw r2;
    L_0x003e:
        if (r6 == 0) goto L_0x0043;
    L_0x0040:
        r2 = 0;
        r6.b = r2;
    L_0x0043:
        r2 = r4.m6454i();
        if (r2 != 0) goto L_0x0059;
    L_0x0049:
        r0 = r16;
        r3 = r0.f4723j;
        if (r6 != 0) goto L_0x00be;
    L_0x004f:
        r2 = 0;
    L_0x0050:
        r0 = r16;
        r2 = r3.mo1059a(r0, r2);
        r4.m6445a(r2);
    L_0x0059:
        if (r6 != 0) goto L_0x00c8;
    L_0x005b:
        r2 = r4.m6454i();
        r0 = r16;
        r2 = r0.m6989a(r2);
        r0 = r16;
        r0.f4724k = r2;
        r0 = r16;
        r2 = r0.f4724k;
        if (r2 == 0) goto L_0x00c3;
    L_0x006f:
        r0 = r16;
        r2 = r0.f4724k;
        r4.f4476p = r2;
        r16.m5950u();
        r2 = 0;
        r2 = (long[][]) r2;
        r0 = r16;
        r3 = r0.f4733t;
        r3.start();
        r5 = r2;
    L_0x0084:
        r0 = r16;
        r2 = r0.f4724k;
        r8 = r4.f4476p;
        r0 = r16;
        r0.f4724k = r8;
        r0 = r16;
        r3 = r0.f4724k;
        r3 = r2.equals(r3);
        if (r3 != 0) goto L_0x00a4;
    L_0x009a:
        r3 = new com.duokan.reader.domain.document.epub.w;
        r0 = r16;
        r3.<init>(r0, r2);
        com.duokan.core.sys.C0367t.m1038a(r3);
    L_0x00a4:
        r2 = r4.m6455j();
        r9 = r2.j;
        r2 = com.duokan.reader.domain.document.epub.ah.m6500e();
        r10 = r2.m6504d();
        r2 = f4722i;
        if (r2 != 0) goto L_0x02b5;
    L_0x00b6:
        if (r10 != 0) goto L_0x02b5;
    L_0x00b8:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x00be:
        r2 = r6.m6454i();
        goto L_0x0050;
    L_0x00c3:
        r16.m5951v();
        goto L_0x0026;
    L_0x00c8:
        r2 = r4.m6454i();
        r3 = r6.m6454i();
        if (r2 == r3) goto L_0x02a3;
    L_0x00d2:
        r2 = r6.f4476p;
        r2 = (com.duokan.reader.domain.document.epub.ab) r2;
        r5 = r2.mo1365h();
        r3 = r4.m6454i();
        r3 = r3 instanceof com.duokan.reader.domain.document.epub.al;
        if (r3 == 0) goto L_0x0194;
    L_0x00e4:
        r2 = r2.f4463c;
        r2 = (com.duokan.reader.domain.document.epub.al) r2;
        r8 = r2.f4485b;
        r2 = r4.m6454i();
        r2 = (com.duokan.reader.domain.document.epub.al) r2;
        r9 = r2.f4485b;
        r2 = r9.mo1068a(r8);
        r3 = 2;
        if (r2 != r3) goto L_0x0128;
    L_0x00fb:
        r2 = r4.m6454i();
        r0 = r16;
        r2 = r0.m6989a(r2);
        if (r2 == 0) goto L_0x0110;
    L_0x0107:
        r4.f4476p = r2;
        r2 = 0;
        r2 = (long[][]) r2;
    L_0x010d:
        r5 = r2;
        goto L_0x0084;
    L_0x0110:
        r2 = com.duokan.core.diagnostic.C0328a.init();
        r3 = 0;
        r2.w(r3);
        r2 = r6.f4476p;
        r4.f4476p = r2;
        r2 = r4.m6455j();
        r2 = r6.m6446a(r2);
        goto L_0x010d;
    L_0x0128:
        r3 = 1;
        if (r2 != r3) goto L_0x0183;
    L_0x012b:
        r3 = new com.duokan.reader.domain.document.epub.ab;
        r10 = r4.m6454i();
        r2 = r4.m6454i();
        r2 = (com.duokan.reader.domain.document.epub.al) r2;
        r2 = r2.f4485b;
        r2 = com.duokan.reader.domain.document.epub.ai.m6517a(r2);
        r0 = r16;
        r3.<init>(r0, r10, r5, r2);
        r4.f4476p = r3;
        r2 = r4.m6455j();
        r3 = r6.m6446a(r2);
        if (r3 == 0) goto L_0x04f8;
    L_0x014f:
        r2 = 0;
    L_0x0150:
        r10 = r9.mo1067a();
        if (r2 >= r10) goto L_0x0181;
    L_0x0156:
        r10 = r9.mo1069a(r2);
        r11 = r10.mo1058c();
        r12 = r8.mo1069a(r2);
        r12 = r12.mo1058c();
        r11 = android.text.TextUtils.equals(r11, r12);
        if (r11 != 0) goto L_0x017e;
    L_0x016c:
        r11 = r10.mo1056a();
        r10 = r10.mo1058c();
        r5.redirectChapter(r11, r10);
        r10 = (long) r2;
        r5.clearChapterData(r10);
        r10 = 0;
        r3[r2] = r10;
    L_0x017e:
        r2 = r2 + 1;
        goto L_0x0150;
    L_0x0181:
        r2 = r3;
        goto L_0x010d;
    L_0x0183:
        r2 = r6.f4476p;
        r4.f4476p = r2;
        r2 = r4.m6455j();
        r2 = r6.m6446a(r2);
        goto L_0x010d;
    L_0x0194:
        r2 = r2.mo1257c();
        r2 = r2.f4342a;
        r3 = r4.m6454i();
        r3 = r3.a;
        r2 = android.text.TextUtils.equals(r2, r3);
        if (r2 != 0) goto L_0x0218;
    L_0x01a6:
        r2 = r4.m6454i();
        r0 = r16;
        r2 = r0.m6989a(r2);
        if (r2 == 0) goto L_0x0200;
    L_0x01b2:
        r4.f4476p = r2;
        r2 = 0;
        r2 = (long[][]) r2;
    L_0x01b8:
        r3 = r2;
    L_0x01b9:
        if (r3 == 0) goto L_0x04f8;
    L_0x01bb:
        r2 = r4.f4476p;
        r5 = r2.mo1365h();
        r2 = 0;
    L_0x01c4:
        r8 = (long) r2;
        r10 = r4.f4476p;
        r10 = r10.mo1366i();
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 >= 0) goto L_0x04f8;
    L_0x01d1:
        r8 = r3[r2];
        if (r8 == 0) goto L_0x01fd;
    L_0x01d5:
        r8 = r3[r2];
        r8 = r8.length;
        r9 = 1;
        if (r8 > r9) goto L_0x01fd;
    L_0x01db:
        r8 = r5.isLinear();
        if (r8 == 0) goto L_0x029e;
    L_0x01e1:
        r8 = (long) r2;
        r8 = r5.getChapterResource(r8);
        r0 = r16;
        r9 = r0.f4723j;
        r10 = new com.duokan.reader.domain.document.epub.aw;
        r10.<init>(r8);
        r8 = 0;
        r8 = r9.mo1060a(r10, r8);
        r8 = r8.mo1073i();
        if (r8 == 0) goto L_0x01fd;
    L_0x01fa:
        r8 = 0;
        r3[r2] = r8;
    L_0x01fd:
        r2 = r2 + 1;
        goto L_0x01c4;
    L_0x0200:
        r2 = com.duokan.core.diagnostic.C0328a.init();
        r3 = 0;
        r2.w(r3);
        r2 = r6.f4476p;
        r4.f4476p = r2;
        r2 = r4.m6455j();
        r2 = r6.m6446a(r2);
        goto L_0x01b8;
    L_0x0218:
        r2 = r4.m6454i();
        r2 = r2 instanceof com.duokan.reader.domain.document.epub.ag;
        if (r2 == 0) goto L_0x0257;
    L_0x0220:
        r2 = r4.m6454i();
        r2 = (com.duokan.reader.domain.document.epub.ag) r2;
        r3 = r2.a;
        r3 = android.net.Uri.parse(r3);
        r3 = r3.getPath();
        r8 = com.duokan.reader.domain.document.epub.ah.m6500e();
        r8 = r8.m6503c();
        r2 = r2.f4477b;
        r5.openDrm(r3, r8, r2);
        r2 = new com.duokan.reader.domain.document.epub.ab;
        r3 = r4.m6454i();
        r8 = 0;
        r0 = r16;
        r2.<init>(r0, r3, r5, r8);
        r4.f4476p = r2;
        r2 = r4.m6455j();
        r2 = r6.m6446a(r2);
        r3 = r2;
        goto L_0x01b9;
    L_0x0257:
        r2 = r6.m6454i();
        r2 = r2 instanceof com.duokan.reader.domain.document.epub.ag;
        if (r2 == 0) goto L_0x028c;
    L_0x025f:
        r2 = r4.m6454i();
        r0 = r16;
        r2 = r0.m6989a(r2);
        if (r2 == 0) goto L_0x0274;
    L_0x026b:
        r4.f4476p = r2;
        r2 = 0;
        r2 = (long[][]) r2;
    L_0x0271:
        r3 = r2;
        goto L_0x01b9;
    L_0x0274:
        r2 = com.duokan.core.diagnostic.C0328a.init();
        r3 = 0;
        r2.w(r3);
        r2 = r6.f4476p;
        r4.f4476p = r2;
        r2 = r4.m6455j();
        r2 = r6.m6446a(r2);
        goto L_0x0271;
    L_0x028c:
        r2 = r6.f4476p;
        r4.f4476p = r2;
        r2 = r4.m6455j();
        r2 = r6.m6446a(r2);
        r3 = r2;
        goto L_0x01b9;
    L_0x029e:
        r8 = 0;
        r3[r2] = r8;
        goto L_0x01fd;
    L_0x02a3:
        r2 = r6.f4476p;
        r4.f4476p = r2;
        r2 = r4.m6455j();
        r2 = r6.m6446a(r2);
        r5 = r2;
        goto L_0x0084;
    L_0x02b5:
        r2 = f4722i;
        if (r2 != 0) goto L_0x02c1;
    L_0x02b9:
        if (r9 != 0) goto L_0x02c1;
    L_0x02bb:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x02c1:
        r2 = r9.entrySet();
        r11 = r2.iterator();
    L_0x02c9:
        r2 = r11.hasNext();
        if (r2 == 0) goto L_0x0302;
    L_0x02cf:
        r2 = r11.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r12 = android.text.TextUtils.isEmpty(r3);
        if (r12 != 0) goto L_0x02c9;
    L_0x02e1:
        r12 = new java.io.File;
        r2 = r2.getValue();
        r2 = (java.lang.String) r2;
        r2 = android.net.Uri.parse(r2);
        r2 = r2.getPath();
        r12.<init>(r2);
        r2 = r12.exists();
        if (r2 == 0) goto L_0x02c9;
    L_0x02fa:
        r2 = r12.getAbsolutePath();
        r10.registerFont(r3, r2);
        goto L_0x02c9;
    L_0x0302:
        r2 = "CUSTOM_FONT_EN";
        r2 = com.duokan.reader.domain.document.C0903n.m5886a(r9, r2);
        r3 = "DEFAULT_FONT_EN";
        r3 = com.duokan.reader.domain.document.C0903n.m5886a(r9, r3);
        r11 = "CUSTOM_FONT_ZH";
        r11 = com.duokan.reader.domain.document.C0903n.m5887b(r9, r11);
        r12 = "DEFAULT_FONT_ZH";
        r12 = com.duokan.reader.domain.document.C0903n.m5887b(r9, r12);
        r13 = "FALLBACK_FONT";
        r9 = com.duokan.reader.domain.document.C0903n.m5888c(r9, r13);
        r13 = android.text.TextUtils.isEmpty(r2);
        if (r13 != 0) goto L_0x0408;
    L_0x0326:
        r10.registerFont(r2, r2);
        r13 = r8.mo1365h();
        r14 = 0;
        r13.setBodyFontFamily(r2, r14);
    L_0x0331:
        r13 = android.text.TextUtils.isEmpty(r11);
        if (r13 != 0) goto L_0x0414;
    L_0x0337:
        r10.registerFont(r11, r11);
        r13 = r8.mo1365h();
        r14 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r13.setBodyFontFamily(r11, r14);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x035f;
    L_0x0349:
        r2 = r8.mo1365h();
        r2 = r2.getBookId();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x035f;
    L_0x0357:
        r2 = r8.mo1365h();
        r13 = 0;
        r2.setBodyFontFamily(r11, r13);
    L_0x035f:
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x0421;
    L_0x0365:
        r10.registerFont(r3, r3);
        r2 = 0;
        r10.setDefaultFont(r3, r2);
    L_0x036c:
        r2 = android.text.TextUtils.isEmpty(r12);
        if (r2 != 0) goto L_0x0429;
    L_0x0372:
        r10.registerFont(r12, r12);
        r2 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r10.setDefaultFont(r12, r2);
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 == 0) goto L_0x0384;
    L_0x0380:
        r2 = 0;
        r10.setDefaultFont(r12, r2);
    L_0x0384:
        r2 = android.text.TextUtils.isEmpty(r9);
        if (r2 != 0) goto L_0x0432;
    L_0x038a:
        r10.registerFont(r9, r9);
        r10.setBackupFont(r9);
    L_0x0390:
        r2 = r4.m6455j();
        r2 = r2.f;
        r3 = 2;
        r2 = java.lang.Math.max(r2, r3);
        r3 = r8.mo1365h();
        r10 = (double) r2;
        r3.setBodyFontSize(r10);
        r2 = r4.m6455j();
        r2 = r2.g;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 >= 0) goto L_0x0439;
    L_0x03af:
        r2 = com.duokan.reader.domain.document.epub.ah.m6500e();
        r2 = r2.m6504d();
        r3 = 1;
        r2.setUseBookStyle(r3);
    L_0x03bb:
        r2 = r8.mo1365h();
        r2.clearAllParsedPages();
        r2 = r8.mo1366i();
        r2 = (int) r2;
        r2 = new long[r2][];
        r4.i = r2;
        r2 = r8.mo1366i();
        r2 = (int) r2;
        r2 = new com.duokan.reader.domain.document.epub.EpubTypesettingContext.ChapterState[r2];
        r4.j = r2;
        r2 = r4.j;
        r3 = com.duokan.reader.domain.document.epub.EpubTypesettingContext.ChapterState.NOT_TYPESETTED;
        java.util.Arrays.fill(r2, r3);
        r2 = r4.l;
        r10 = r8.mo1366i();
        r3 = (int) r10;
        r2.ensureCapacity(r3);
        r2 = r4.m;
        r10 = r8.mo1366i();
        r3 = (int) r10;
        r2.ensureCapacity(r3);
        r2 = 0;
    L_0x03f0:
        r10 = (long) r2;
        r12 = r8.mo1366i();
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 >= 0) goto L_0x046e;
    L_0x03f9:
        r3 = r4.l;
        r9 = 0;
        r3.add(r9);
        r3 = r4.m;
        r9 = 0;
        r3.add(r9);
        r2 = r2 + 1;
        goto L_0x03f0;
    L_0x0408:
        r13 = r8.mo1365h();
        r14 = "";
        r15 = 0;
        r13.setBodyFontFamily(r14, r15);
        goto L_0x0331;
    L_0x0414:
        r2 = r8.mo1365h();
        r11 = "";
        r13 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r2.setBodyFontFamily(r11, r13);
        goto L_0x035f;
    L_0x0421:
        r2 = "";
        r11 = 0;
        r10.setDefaultFont(r2, r11);
        goto L_0x036c;
    L_0x0429:
        r2 = "";
        r3 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r10.setDefaultFont(r2, r3);
        goto L_0x0384;
    L_0x0432:
        r2 = "";
        r10.setBackupFont(r2);
        goto L_0x0390;
    L_0x0439:
        r2 = com.duokan.reader.domain.document.epub.ah.m6500e();
        r2 = r2.m6504d();
        r3 = 0;
        r2.setUseBookStyle(r3);
        r2 = r8.mo1365h();
        r3 = r4.m6455j();
        r10 = r3.g;
        r2.setLineGap(r10);
        r2 = r8.mo1365h();
        r3 = r4.m6455j();
        r10 = r3.h;
        r2.setParaSpacing(r10);
        r2 = r8.mo1365h();
        r3 = r4.m6455j();
        r10 = r3.i;
        r2.setFirstLineIndent(r10);
        goto L_0x03bb;
    L_0x046e:
        if (r5 != 0) goto L_0x04e5;
    L_0x0470:
        r0 = r16;
        r0.m6993a(r4, r6);
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.f4731r = r2;
    L_0x047d:
        r16.m5955z();
        r2 = 1;
        r4.b = r2;
    L_0x0483:
        r2 = r4.m6456k();
        if (r2 == 0) goto L_0x04ae;
    L_0x0489:
        r3 = 1;
        r0 = r16;
        r0.f4730q = r3;
        r0 = r16;
        r3 = r0.f4727n;
        r3.release();
        r0 = r16;
        r0.m6994a(r2, r4);
        r3 = 0;
        r0 = r16;
        r0.f4730q = r3;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.f4731r = r8;
        r0 = r16;
        r3 = r0.f4727n;
        r3.release();
    L_0x04ae:
        if (r2 != 0) goto L_0x04e2;
    L_0x04b0:
        r0 = r16;
        r2 = r0.f4727n;
        r2.release();
        r2 = r4.m6455j();
        r0 = r16;
        r3 = r0.f4728o;
        if (r2 == r3) goto L_0x04e8;
    L_0x04c1:
        if (r7 != 0) goto L_0x04e8;
    L_0x04c3:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r6 = r0.f4731r;
        r2 = r2 - r6;
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x04e8;
    L_0x04d2:
        r2 = 1;
        r0 = r16;
        r2 = r0.m6999a(r4, r2);
        if (r2 != 0) goto L_0x04e2;
    L_0x04db:
        r0 = r16;
        r2 = r0.f4726m;
        r2.acquireUninterruptibly();
    L_0x04e2:
        r6 = r4;
        goto L_0x0001;
    L_0x04e5:
        r4.i = r5;
        goto L_0x047d;
    L_0x04e8:
        r0 = r16;
        r2 = r0.f4726m;	 Catch:{ Exception -> 0x04f4 }
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Exception -> 0x04f4 }
        r2.tryAcquire(r6, r3);	 Catch:{ Exception -> 0x04f4 }
        goto L_0x04e2;
    L_0x04f4:
        r2 = move-exception;
        goto L_0x04e2;
    L_0x04f6:
        r4 = r6;
        goto L_0x0483;
    L_0x04f8:
        r2 = r3;
        goto L_0x010d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.s.K():void");
    }

    /* renamed from: a */
    private void m6993a(EpubTypesettingContext epubTypesettingContext, EpubTypesettingContext epubTypesettingContext2) {
        long[][] jArr = (long[][]) null;
        if (this.f4723j != null) {
            jArr = this.f4723j.mo1064a(this, m6990a(epubTypesettingContext), epubTypesettingContext.m6455j());
        }
        if (jArr != null && ((long) jArr.length) == epubTypesettingContext.mo1369e().mo1366i()) {
            epubTypesettingContext.f4451i = jArr;
            m6999a(epubTypesettingContext, false);
        }
    }

    /* renamed from: a */
    private boolean m6999a(EpubTypesettingContext epubTypesettingContext, boolean z) {
        if (f4722i || epubTypesettingContext != null) {
            C0934e e = epubTypesettingContext.mo1369e();
            if (!f4722i && e.mo1366i() < 0) {
                throw new AssertionError();
            } else if (epubTypesettingContext.f4453k == e.mo1366i()) {
                return false;
            } else {
                long i = e.mo1366i() - 1;
                while (i >= 0) {
                    if (m7001b(epubTypesettingContext, i) < 0 && (i == 0 || m7001b(epubTypesettingContext, i - 1) >= 0)) {
                        m6992a(epubTypesettingContext, i, epubTypesettingContext.m6455j());
                        break;
                    }
                    i--;
                }
                long j = 0;
                for (i = 0; i < e.mo1366i(); i++) {
                    if (m7001b(epubTypesettingContext, i) >= 0) {
                        j++;
                    }
                }
                epubTypesettingContext.f4453k = j;
                if (epubTypesettingContext.f4453k == e.mo1366i()) {
                    m7012e(epubTypesettingContext);
                    if (this.f4723j != null && z) {
                        this.f4723j.mo1061a(this, m6990a(epubTypesettingContext), epubTypesettingContext.m6455j(), epubTypesettingContext.f4451i);
                    }
                    m5954y();
                    return false;
                }
                m5954y();
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m6994a(com.duokan.reader.domain.document.epub.ch r25, com.duokan.reader.domain.document.epub.EpubTypesettingContext r26) {
        /*
        r24 = this;
        r4 = f4722i;
        if (r4 != 0) goto L_0x000c;
    L_0x0004:
        if (r26 != 0) goto L_0x000c;
    L_0x0006:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x000c:
        r4 = f4722i;
        if (r4 != 0) goto L_0x0018;
    L_0x0010:
        if (r25 != 0) goto L_0x0018;
    L_0x0012:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x0018:
        r14 = r26.mo1369e();
        r4 = f4722i;
        if (r4 != 0) goto L_0x0030;
    L_0x0020:
        r4 = r14.mo1366i();
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 > 0) goto L_0x0030;
    L_0x002a:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x0030:
        r0 = r25;
        r4 = r0.f4662a;
        r4 = r4.mo1189c();
        if (r4 == 0) goto L_0x0057;
    L_0x003a:
        r0 = r25;
        r4 = r0.f4662a;
        r4 = r4.f4504c;
        r4 = java.lang.Float.isNaN(r4);
        if (r4 != 0) goto L_0x0057;
    L_0x0046:
        r0 = r25;
        r4 = r0.f4662a;
        r4 = r4.f4503b;
        r6 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r4, r6);
    L_0x0057:
        r0 = r25;
        r4 = r0.f4662a;
        r4 = r4.mo1189c();
        if (r4 == 0) goto L_0x007e;
    L_0x0061:
        r0 = r25;
        r4 = r0.f4662a;
        r4 = r4.f4505d;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x007e;
    L_0x006d:
        r0 = r25;
        r4 = r0.f4662a;
        r4 = r4.f4503b;
        r6 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r4, r6);
    L_0x007e:
        r0 = r24;
        r1 = r26;
        r2 = r25;
        r4 = r0.m7005b(r1, r2);
        r5 = 0;
        r6 = r4[r5];
        r5 = 1;
        r8 = r4[r5];
        r5 = 2;
        r10 = r4[r5];
        r5 = 3;
        r16 = r4[r5];
        r0 = r25;
        r4 = r0.f4662a;
        r4 = r4.m5777b();
        if (r4 == 0) goto L_0x00c2;
    L_0x009e:
        r0 = r25;
        r4 = r0.f4662a;
        r4 = r4.m6533k();
        r4 = r4.m6780g();
        r6 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r4, r6);
    L_0x00b5:
        r0 = r24;
        r1 = r26;
        r2 = r25;
        r4 = r0.m6998a(r1, r2);
        if (r4 == 0) goto L_0x01f3;
    L_0x00c1:
        return;
    L_0x00c2:
        r4 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r6, r4);
        r4 = 0;
        r12 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r12 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r12 != 0) goto L_0x0124;
    L_0x00d8:
        r0 = r24;
        r1 = r26;
        r4 = r0.m7001b(r1, r6);
    L_0x00e0:
        r12 = r4 + r16;
        r4 = 0;
        r4 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x01a9;
    L_0x00e8:
        r4 = 0;
    L_0x00ea:
        r10 = r14.mo1366i();
        r10 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r10 >= 0) goto L_0x00b5;
    L_0x00f2:
        r0 = r24;
        r1 = r26;
        r10 = r0.m7001b(r1, r6);
        r18 = 0;
        r15 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1));
        if (r15 >= 0) goto L_0x0113;
    L_0x0100:
        r10 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r6, r10);
        r0 = r24;
        r1 = r26;
        r10 = r0.m7001b(r1, r6);
    L_0x0113:
        r4 = r4 + r10;
        r10 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r10 >= 0) goto L_0x01a4;
    L_0x0118:
        r4 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r6, r4);
        goto L_0x00b5;
    L_0x0124:
        r12 = -9223372036854775808;
        r12 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r12 != 0) goto L_0x012d;
    L_0x012a:
        r4 = -1;
        goto L_0x00e0;
    L_0x012d:
        r12 = 0;
        r12 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r12 != 0) goto L_0x0139;
    L_0x0133:
        r12 = 0;
        r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r12 == 0) goto L_0x00e0;
    L_0x0139:
        r12 = r4;
    L_0x013a:
        r4 = r14.mo1365h();
        r4 = r4.getPageOfChapterEx(r6, r12);
        r5 = f4722i;
        if (r5 != 0) goto L_0x014e;
    L_0x0146:
        if (r4 != 0) goto L_0x014e;
    L_0x0148:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x014e:
        if (r4 != 0) goto L_0x0153;
    L_0x0150:
        r4 = 0;
        goto L_0x00e0;
    L_0x0153:
        r5 = new com.duokan.kernel.DkFlowPosition;
        r5.<init>(r6, r8, r10);
        r15 = new com.duokan.kernel.DkFlowPosition;
        r15.<init>();
        r18 = new com.duokan.kernel.DkFlowPosition;
        r18.<init>();
        r4.getBeginPosition(r15);
        r0 = r18;
        r4.getEndPosition(r0);
        r4 = f4722i;
        if (r4 != 0) goto L_0x0182;
    L_0x016e:
        r0 = r15.mChapterIndex;
        r20 = r0;
        r0 = r18;
        r0 = r0.mChapterIndex;
        r22 = r0;
        r4 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1));
        if (r4 == 0) goto L_0x0182;
    L_0x017c:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x0182:
        r4 = f4722i;
        if (r4 != 0) goto L_0x0194;
    L_0x0186:
        r0 = r15.mChapterIndex;
        r20 = r0;
        r4 = (r20 > r6 ? 1 : (r20 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x0194;
    L_0x018e:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x0194:
        r0 = r18;
        r4 = com.duokan.reader.domain.document.epub.ai.m6513a(r5, r15, r0);
        if (r4 == 0) goto L_0x019f;
    L_0x019c:
        r4 = r12;
        goto L_0x00e0;
    L_0x019f:
        r4 = 1;
        r4 = r4 + r12;
        r12 = r4;
        goto L_0x013a;
    L_0x01a4:
        r10 = 1;
        r6 = r6 + r10;
        goto L_0x00ea;
    L_0x01a9:
        r10 = 0;
        r4 = 1;
        r4 = r6 - r4;
        r6 = r4;
    L_0x01b0:
        r4 = 0;
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x00b5;
    L_0x01b6:
        r0 = r24;
        r1 = r26;
        r4 = r0.m7001b(r1, r6);
        r18 = 0;
        r15 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1));
        if (r15 >= 0) goto L_0x01d7;
    L_0x01c4:
        r4 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r6, r4);
        r0 = r24;
        r1 = r26;
        r4 = r0.m7001b(r1, r6);
    L_0x01d7:
        r10 = r10 + r4;
        r4 = java.lang.Math.abs(r12);
        r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r4 > 0) goto L_0x01ed;
    L_0x01e0:
        r4 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r6, r4);
        goto L_0x00b5;
    L_0x01ed:
        r4 = 1;
        r4 = r6 - r4;
        r6 = r4;
        goto L_0x01b0;
    L_0x01f3:
        r4 = 0;
        r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x0205;
    L_0x01f9:
        r4 = 0;
        r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x024e;
    L_0x01ff:
        r4 = -9223372036854775808;
        r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x024e;
    L_0x0205:
        r4 = r14.mo1366i();
        r6 = 1;
        r4 = r4 - r6;
    L_0x020c:
        r6 = 0;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 < 0) goto L_0x0293;
    L_0x0212:
        r6 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r4, r6);
        r0 = r24;
        r1 = r26;
        r6 = r0.m7001b(r1, r4);
        r8 = 0;
        r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r8 <= 0) goto L_0x024a;
    L_0x022b:
        r0 = r25;
        r8 = r0.f4664c;
        r9 = 1;
        r8.f4650d = r9;
        r0 = r25;
        r8 = r0.f4664c;
        r8.f4647a = r4;
        r0 = r25;
        r4 = r0.f4664c;
        r8 = 1;
        r6 = r6 - r8;
        r4.f4648b = r6;
        r0 = r25;
        r4 = r0.f4664c;
        r4.m6799f();
        goto L_0x00c1;
    L_0x024a:
        r6 = 1;
        r4 = r4 - r6;
        goto L_0x020c;
    L_0x024e:
        r4 = 0;
    L_0x0250:
        r6 = r14.mo1366i();
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 >= 0) goto L_0x0293;
    L_0x0258:
        r6 = r26.m6455j();
        r0 = r24;
        r1 = r26;
        r0.m7003b(r1, r4, r6);
        r0 = r24;
        r1 = r26;
        r6 = r0.m7001b(r1, r4);
        r8 = 0;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x028f;
    L_0x0271:
        r0 = r25;
        r6 = r0.f4664c;
        r7 = 1;
        r6.f4649c = r7;
        r0 = r25;
        r6 = r0.f4664c;
        r6.f4647a = r4;
        r0 = r25;
        r4 = r0.f4664c;
        r6 = 0;
        r4.f4648b = r6;
        r0 = r25;
        r4 = r0.f4664c;
        r4.m6799f();
        goto L_0x00c1;
    L_0x028f:
        r6 = 1;
        r4 = r4 + r6;
        goto L_0x0250;
    L_0x0293:
        r4 = f4722i;
        if (r4 != 0) goto L_0x00c1;
    L_0x0297:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.s.a(com.duokan.reader.domain.document.epub.ch, com.duokan.reader.domain.document.epub.EpubTypesettingContext):void");
    }

    /* renamed from: a */
    private boolean m6998a(EpubTypesettingContext epubTypesettingContext, ch chVar) {
        C0934e e = epubTypesettingContext.mo1369e();
        if (!Float.isNaN(chVar.f4662a.f4504c) && epubTypesettingContext.f4452j[(int) chVar.f4662a.f4503b] != ChapterState.TYPESETTED) {
            return false;
        }
        if (!TextUtils.isEmpty(chVar.f4662a.f4505d)) {
            if (epubTypesettingContext.f4452j[(int) chVar.f4662a.f4503b] == ChapterState.NOT_TYPESETTED) {
                return false;
            }
            if (m6984a(epubTypesettingContext, chVar.f4662a.f4503b) < 1) {
                return false;
            }
        }
        long[] b = m7005b(epubTypesettingContext, chVar);
        long j = b[0];
        long j2 = b[1];
        long j3 = b[2];
        long j4 = b[3];
        long j5;
        if (chVar.f4662a.m5777b()) {
            C0936c k = chVar.f4662a.m6533k();
            if (chVar.f4662a.m5817f()) {
                return false;
            }
            j5 = 0;
            while (true) {
                DkePage pageOfChapterEx = e.mo1365h().getPageOfChapterEx(k.m6780g(), j5);
                if (pageOfChapterEx == null) {
                    return false;
                }
                DkFlowPosition dkFlowPosition = new DkFlowPosition(k.m6774b(e.mo1365h()));
                DkFlowPosition dkFlowPosition2 = new DkFlowPosition();
                DkFlowPosition dkFlowPosition3 = new DkFlowPosition();
                pageOfChapterEx.getBeginPosition(dkFlowPosition2);
                pageOfChapterEx.getEndPosition(dkFlowPosition3);
                if (!f4722i && dkFlowPosition2.mChapterIndex != dkFlowPosition3.mChapterIndex) {
                    throw new AssertionError();
                } else if (!f4722i && dkFlowPosition2.mChapterIndex != k.m6780g()) {
                    throw new AssertionError();
                } else if (ai.m6513a(dkFlowPosition, dkFlowPosition2, dkFlowPosition3)) {
                    chVar.f4664c.f4647a = k.m6780g();
                    chVar.f4664c.f4648b = j5;
                    chVar.f4664c.m6799f();
                    return true;
                } else {
                    j5++;
                }
            }
        } else if (!f4722i && !chVar.f4662a.m6532j().b) {
            throw new AssertionError();
        } else if (j < 0 || j >= e.mo1366i()) {
            return false;
        } else {
            j5 = 0;
            if (j2 == Long.MAX_VALUE) {
                if (m7001b(epubTypesettingContext, j) < 0) {
                    return false;
                }
                j5 = m7001b(epubTypesettingContext, j);
            } else if (j2 == Long.MIN_VALUE) {
                j5 = -1;
            } else if (!(j2 == 0 && j3 == 0)) {
                long j6 = 0;
                while (true) {
                    DkePage pageOfChapterEx2 = e.mo1365h().getPageOfChapterEx(j, j6);
                    if (pageOfChapterEx2 == null) {
                        return false;
                    }
                    DkFlowPosition dkFlowPosition4 = new DkFlowPosition(j, j2, j3);
                    DkFlowPosition dkFlowPosition5 = new DkFlowPosition();
                    DkFlowPosition dkFlowPosition6 = new DkFlowPosition();
                    pageOfChapterEx2.getBeginPosition(dkFlowPosition5);
                    pageOfChapterEx2.getEndPosition(dkFlowPosition6);
                    if (!f4722i && dkFlowPosition5.mChapterIndex != dkFlowPosition6.mChapterIndex) {
                        throw new AssertionError();
                    } else if (!f4722i && dkFlowPosition5.mChapterIndex != j) {
                        throw new AssertionError();
                    } else if (ai.m6513a(dkFlowPosition4, dkFlowPosition5, dkFlowPosition6)) {
                        break;
                    } else {
                        j6 = 1 + j6;
                    }
                }
                j5 = j6;
            }
            j3 = j5 + j4;
            if (j3 >= 0) {
                j5 = 0;
                while (j < e.mo1366i()) {
                    j2 = m7001b(epubTypesettingContext, j);
                    if (j2 >= 0) {
                        if (j3 >= j5 + j2) {
                            j5 += j2;
                            j++;
                        } else if (j3 >= m6984a(epubTypesettingContext, j) + j5) {
                            return false;
                        } else {
                            chVar.f4664c.f4647a = j;
                            chVar.f4664c.f4648b = j3 - j5;
                            chVar.f4664c.m6799f();
                            return true;
                        }
                    } else if (j3 >= m6984a(epubTypesettingContext, j) + j5) {
                        return false;
                    } else {
                        chVar.f4664c.f4647a = j;
                        chVar.f4664c.f4648b = j3 - j5;
                        chVar.f4664c.m6799f();
                        return true;
                    }
                }
                return false;
            }
            j = 0;
            for (j5 = j - 1; j5 >= 0; j5--) {
                j2 = m7001b(epubTypesettingContext, j5);
                if (j2 < 0) {
                    return false;
                }
                if (Math.abs(j3) <= j + j2) {
                    if ((j + j2) + j3 >= m6984a(epubTypesettingContext, j5)) {
                        return false;
                    }
                    chVar.f4664c.f4647a = j5;
                    chVar.f4664c.f4648b = (j + j2) + j3;
                    chVar.f4664c.m6799f();
                    return true;
                }
                j += j2;
            }
            return false;
        }
    }

    /* renamed from: a */
    private void m6992a(EpubTypesettingContext epubTypesettingContext, long j, am amVar) {
        C0934e e = epubTypesettingContext.mo1369e();
        if (j >= 0 && j < e.mo1366i() && epubTypesettingContext.f4452j[(int) j] != ChapterState.TYPESETTED) {
            HashSet hashSet;
            m6980M();
            long[] calcChapterPages = e.mo1365h().calcChapterPages(ai.m6505a(amVar, j));
            if (epubTypesettingContext.f4454l.get((int) j) == null) {
                hashSet = new HashSet();
                hashSet.addAll(m6981N());
                epubTypesettingContext.f4454l.set((int) j, hashSet);
            }
            if (epubTypesettingContext.f4455m.get((int) j) == null) {
                hashSet = new HashSet();
                hashSet.addAll(m6982O());
                epubTypesettingContext.f4455m.set((int) j, hashSet);
            }
            epubTypesettingContext.f4451i[(int) j] = calcChapterPages;
        }
    }

    /* renamed from: b */
    private void m7003b(EpubTypesettingContext epubTypesettingContext, long j, am amVar) {
        C0934e e = epubTypesettingContext.mo1369e();
        if (j >= 0 && j < e.mo1366i() && epubTypesettingContext.f4452j[(int) j] != ChapterState.TYPESETTED) {
            HashSet hashSet;
            epubTypesettingContext.f4452j[(int) j] = ChapterState.TYPESETTING;
            m6980M();
            e.mo1365h().parseContent(ai.m6505a(amVar, j));
            if (epubTypesettingContext.f4454l.get((int) j) == null) {
                hashSet = new HashSet();
                hashSet.addAll(m6981N());
                epubTypesettingContext.f4454l.set((int) j, hashSet);
            }
            if (epubTypesettingContext.f4455m.get((int) j) == null) {
                hashSet = new HashSet();
                hashSet.addAll(m6982O());
                epubTypesettingContext.f4455m.set((int) j, hashSet);
            }
            long[] jArr = new long[((int) e.mo1365h().getPageCountOfChapter(j))];
            for (int i = 0; i < jArr.length; i++) {
                DkFlowPosition dkFlowPosition = new DkFlowPosition();
                long j2 = j;
                ai.m6510a(e.mo1365h(), j2, (long) i, dkFlowPosition, new DkFlowPosition());
                jArr[i] = (((long) ((int) dkFlowPosition.mParaIndex)) << 32) | dkFlowPosition.mAtomIndex;
            }
            epubTypesettingContext.f4451i[(int) j] = jArr;
            epubTypesettingContext.f4452j[(int) j] = ChapterState.TYPESETTED;
            m7012e(epubTypesettingContext);
        }
    }

    /* renamed from: b */
    private long[] m7005b(EpubTypesettingContext epubTypesettingContext, ch chVar) {
        DkFlowPosition dkFlowPosition;
        DkFlowPosition dkFlowPosition2;
        long j;
        long j2;
        C0934e e = epubTypesettingContext.mo1369e();
        long j3 = chVar.f4662a.f4503b;
        long j4 = chVar.f4662a.f4506e;
        long j5 = chVar.f4662a.f4507f;
        long j6 = chVar.f4662a.f4508g;
        if (chVar.f4662a.f4502a == null || !chVar.f4662a.f4502a.m5777b()) {
            if (!Float.isNaN(chVar.f4662a.f4504c)) {
                j4 = 0;
                j5 = 0;
                if (epubTypesettingContext.f4452j[(int) j3] == ChapterState.TYPESETTED) {
                    dkFlowPosition = new DkFlowPosition();
                    dkFlowPosition2 = new DkFlowPosition();
                    j = e.mo1365h().getChapterOffsetRange(j3)[1];
                    for (int i = 0; ((long) i) < m7001b(epubTypesettingContext, j3); i++) {
                        float f;
                        ai.m6510a(e.mo1365h(), j3, (long) i, dkFlowPosition, dkFlowPosition2);
                        j4 = dkFlowPosition.mParaIndex;
                        j5 = dkFlowPosition.mAtomIndex;
                        long j7 = C0952s.m7000a(e.mo1365h(), dkFlowPosition, dkFlowPosition2)[1];
                        if (j == 0) {
                            f = 1.0f;
                        } else {
                            f = ((float) j7) / ((float) j);
                        }
                        if (Float.compare(Math.max(0.0f, Math.min(f, 1.0f)), chVar.f4662a.f4504c) >= 0) {
                            break;
                        }
                    }
                    j = j6;
                    j6 = j4;
                    j4 = j5;
                }
            } else if (!TextUtils.isEmpty(chVar.f4662a.f4505d)) {
                j4 = 0;
                j5 = 0;
                if (epubTypesettingContext.f4452j[(int) j3] == ChapterState.TYPESETTED || m6984a(epubTypesettingContext, j3) > 0) {
                    DkFlowPosition flowPosition = e.mo1365h().getFlowPosition(j3, chVar.f4662a.f4505d);
                    j = j6;
                    j6 = flowPosition.mParaIndex;
                    j4 = flowPosition.mAtomIndex;
                }
            } else if (!(f4722i || chVar.f4662a.f4502a == null || chVar.f4662a.f4502a.m6532j() == chVar.f4662a.m6532j())) {
                throw new AssertionError();
            }
            j = j6;
            j6 = j4;
            j4 = j5;
        } else {
            C0936c k = chVar.f4662a.f4502a.m6533k();
            j3 = k.m6780g();
            j4 = k.m6781h();
            j = j6 - chVar.f4662a.f4502a.f4508g;
            j6 = j4;
            j4 = k.m6782i();
        }
        if (j3 < 0) {
            if (f4722i) {
                j5 = 0;
                j3 = Long.MIN_VALUE;
                j2 = 0;
            } else {
                throw new AssertionError();
            }
        } else if (j3 >= e.mo1366i()) {
            j5 = e.mo1366i() - 1;
            j3 = Long.MAX_VALUE;
            j2 = 0;
        } else {
            if (j6 != Long.MAX_VALUE && epubTypesettingContext.f4452j[(int) j3] == ChapterState.TYPESETTED && e.mo1365h().getPageCountOfChapter(j3) > 0) {
                dkFlowPosition = new DkFlowPosition();
                dkFlowPosition2 = new DkFlowPosition();
                ai.m6510a(e.mo1365h(), j3, e.mo1365h().getPageCountOfChapter(j3) - 1, dkFlowPosition, dkFlowPosition2);
                if (j6 > dkFlowPosition2.mParaIndex || (j6 == dkFlowPosition2.mParaIndex && j4 >= dkFlowPosition2.mAtomIndex)) {
                    j5 = dkFlowPosition.mParaIndex;
                    j2 = dkFlowPosition.mAtomIndex;
                    long j8 = j5;
                    j5 = j3;
                    j3 = j8;
                }
            }
            j2 = j4;
            j5 = j3;
            j3 = j6;
        }
        return new long[]{j5, j3, j2, j};
    }

    /* renamed from: a */
    private long m6984a(EpubTypesettingContext epubTypesettingContext, long j) {
        C0934e e = epubTypesettingContext.mo1369e();
        ChapterState chapterState = epubTypesettingContext.f4452j[(int) j];
        if (chapterState == ChapterState.NOT_TYPESETTED) {
            return 0;
        }
        if (chapterState == ChapterState.TYPESETTING) {
            return e.mo1365h().getPageCountOfChapter(j);
        }
        return (long) epubTypesettingContext.f4451i[(int) j].length;
    }

    /* renamed from: e */
    private boolean m7012e(EpubTypesettingContext epubTypesettingContext) {
        C0934e e = epubTypesettingContext.mo1369e();
        long b = epubTypesettingContext.m5839b();
        int i = 0;
        for (long j = 0; j < e.mo1366i(); j++) {
            long b2 = m7001b(epubTypesettingContext, j);
            if (b2 < 0) {
                return false;
            }
            i = (int) (b2 + ((long) i));
        }
        if (b == ((long) i)) {
            return false;
        }
        epubTypesettingContext.m5835a((long) i);
        m5955z();
        return true;
    }

    /* renamed from: b */
    private long m7001b(EpubTypesettingContext epubTypesettingContext, long j) {
        return epubTypesettingContext.m6449d(j);
    }

    /* renamed from: L */
    private EpubTypesettingContext m6979L() {
        EpubTypesettingContext epubTypesettingContext;
        synchronized (this) {
            epubTypesettingContext = (EpubTypesettingContext) this.f4725l.getLast();
            if (f4722i || epubTypesettingContext != null) {
            } else {
                throw new AssertionError();
            }
        }
        return epubTypesettingContext;
    }

    /* renamed from: M */
    private void m6980M() {
        if (this.f4734u.get() != null) {
            ((HashSet) this.f4734u.get()).clear();
        }
        if (this.f4735v.get() != null) {
            ((HashSet) this.f4735v.get()).clear();
        }
    }

    /* renamed from: N */
    private List<av> m6981N() {
        if (this.f4734u.get() != null) {
            return Arrays.asList(((HashSet) this.f4734u.get()).toArray(new av[0]));
        }
        return Collections.emptyList();
    }

    /* renamed from: O */
    private List<av> m6982O() {
        if (this.f4735v.get() != null) {
            return Arrays.asList(((HashSet) this.f4735v.get()).toArray(new av[0]));
        }
        return Collections.emptyList();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private com.duokan.reader.domain.document.epub.C0934e m6989a(com.duokan.reader.domain.document.epub.ap r9) {
        /*
        r8 = this;
        r3 = 0;
        r2 = 1;
        r1 = 0;
        if (r9 != 0) goto L_0x000b;
    L_0x0005:
        r0 = 4;
        r8.m5927d(r0);
        r0 = r3;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        r4 = r9.a;
        r5 = new com.duokan.reader.domain.document.epub.x;
        r5.<init>(r8);
        r4 = com.duokan.reader.domain.document.epub.ai.m6507a(r4, r9, r5);
        r5 = r4.f4489b;
        r5 = r5.isValid();
        if (r5 == 0) goto L_0x002c;
    L_0x001f:
        r0 = r4.f4489b;
        r0 = r0.isValid();
        if (r0 != 0) goto L_0x0065;
    L_0x0027:
        r8.m5927d(r2);
        r0 = r3;
        goto L_0x000a;
    L_0x002c:
        if (r0 == 0) goto L_0x0033;
    L_0x002e:
        r0 = 3;
        r8.m5927d(r0);
        goto L_0x001f;
    L_0x0033:
        r0 = r9 instanceof com.duokan.reader.domain.document.epub.ag;
        if (r0 == 0) goto L_0x001f;
    L_0x0037:
        r0 = r9;
        r0 = (com.duokan.reader.domain.document.epub.ag) r0;
        r5 = r8.f4723j;
        if (r5 == 0) goto L_0x001f;
    L_0x003e:
        r5 = r0.f4477b;
        r5 = r5.length;
        if (r5 <= 0) goto L_0x001f;
    L_0x0043:
        r5 = r0.f4477b;
        r5 = r5[r1];
        r5 = r5.length;
        if (r5 <= 0) goto L_0x001f;
    L_0x004a:
        r5 = r0.f4477b;
        r5 = r5[r1];
        r5 = r5[r1];
        r6 = 100;
        if (r5 >= r6) goto L_0x001f;
    L_0x0054:
        r5 = r8.f4723j;
        r5 = r5.mo1062a();
        if (r5 != 0) goto L_0x0061;
    L_0x005c:
        r0 = 2;
        r8.m5927d(r0);
        goto L_0x001f;
    L_0x0061:
        r0.f4477b = r5;
        r0 = r2;
        goto L_0x000c;
    L_0x0065:
        r0 = r4.f4489b;
        r0 = r0.getChapterCount();
        r6 = 0;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 > 0) goto L_0x0076;
    L_0x0071:
        r8.m5927d(r2);
        r0 = r3;
        goto L_0x000a;
    L_0x0076:
        r0 = new com.duokan.reader.domain.document.epub.ab;
        r0.<init>(r8, r9, r4);
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.s.a(com.duokan.reader.domain.document.epub.ap):com.duokan.reader.domain.document.epub.e");
    }

    /* renamed from: P */
    private void m6983P() {
        this.f4737x.shutdown();
        do {
            try {
            } catch (Exception e) {
                if (!f4722i) {
                    throw new AssertionError();
                }
            }
        } while (!this.f4737x.awaitTermination(60, TimeUnit.SECONDS));
        this.g.m6357a();
        this.f4724k.mo1261g();
    }

    /* renamed from: a */
    private static long[] m7000a(DkeBook dkeBook, DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
        long j;
        if (dkFlowPosition.mParaIndex == Long.MAX_VALUE) {
            j = dkeBook.getChapterOffsetRange(dkFlowPosition.mChapterIndex)[1];
            return new long[]{j, j};
        } else if (dkFlowPosition2.mParaIndex != Long.MAX_VALUE) {
            return dkeBook.getByteOffsetRange(dkFlowPosition, dkFlowPosition2);
        } else {
            j = dkeBook.getChapterOffsetRange(dkFlowPosition.mChapterIndex)[1];
            return new long[]{dkeBook.getByteOffsetRange(dkFlowPosition, dkFlowPosition2)[0], j};
        }
    }

    /* renamed from: a */
    private long m6985a(ay ayVar) {
        WebLog.init().w(ayVar.m5777b());
        if (ayVar.m6533k().m6787n() == m6979L()) {
            return ayVar.m6533k().f4625a;
        }
        EpubTypesettingContext L = m6979L();
        if (L.mo1272c()) {
            WebLog.init().printStackTraceString(LogLevel.WARNING, "doc-epub", "dead lock detected!");
            return ayVar.m6533k().f4625a;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        cd a = L.m6443a(ayVar, new C0958y(this, countDownLatch));
        try {
            countDownLatch.await();
            return a.f4648b;
        } catch (Exception e) {
            WebLog.init().m762a(true);
            return -1;
        }
    }
}
