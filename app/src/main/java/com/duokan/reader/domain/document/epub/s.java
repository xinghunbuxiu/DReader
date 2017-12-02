package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.kernel.epublib.DkePage;
import com.duokan.kernel.epublib.DkeResourceDescriptor;
import com.duokan.reader.domain.document.FootnoteStyle;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.epub.EpubTypesettingContext.ChapterState;
import com.duokan.reader.domain.document.f;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.j;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.y;
import com.duokan.reader.domain.document.z;

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

public class s extends n implements at {
    static final /* synthetic */ boolean i = (!s.class.desiredAssertionStatus());
    private final ae j;
    private e k = null;
    private final LinkedList l = new LinkedList();
    private final Semaphore m = new Semaphore(0);
    private final Semaphore n = new Semaphore(0);
    private final am o;
    private String p = "";
    private boolean q = false;
    private long r = 0;
    private final Thread s;
    private final Thread t;
    private final ThreadLocal u = new ThreadLocal();
    private final ThreadLocal v = new ThreadLocal();
    private au w = null;
    private final ExecutorService x = Executors.newSingleThreadExecutor();

    public /* synthetic */ ak a(long j) {
        return h(j);
    }

    public /* synthetic */ bb a(d dVar, d dVar2) {
        return b(dVar, dVar2);
    }

    public /* synthetic */ ak c(av avVar) {
        return d(avVar);
    }

    public /* synthetic */ ak d(ak akVar) {
        return k(akVar);
    }

    public /* synthetic */ ak e(ak akVar) {
        return l(akVar);
    }

    public /* synthetic */ ak f(ak akVar) {
        return m(akVar);
    }

    public /* synthetic */ ak g(ak akVar) {
        return n(akVar);
    }

    public /* synthetic */ h h() {
        return E();
    }

    public /* synthetic */ m l() {
        return G();
    }

    public /* synthetic */ av q() {
        return H();
    }

    public /* synthetic */ ak r() {
        return I();
    }

    public s(ae aeVar) {
        a.c().b(A());
        DkUtils.initWordSeg(ah.e().b());
        this.j = aeVar;
        this.o = new am();
        this.w = new au();
        this.s = new Thread(new t(this));
        this.t = new Thread(new u(this));
    }

    public String B() {
        a.c().b(A());
        if (p()) {
            return this.k.h().getBookRevision();
        }
        return "";
    }

    public an C() {
        a.c().b(A());
        if (!p()) {
            return null;
        }
        l c = this.k.c();
        return c instanceof al ? ((al) c).b : null;
    }

    public long D() {
        a.c().b(A());
        if (p()) {
            return this.k.i();
        }
        return 0;
    }

    public long b(long j) {
        a.c().b(A());
        if (D() <= 0) {
            return 0;
        }
        long b = b(L(), j);
        if (b < 0) {
            return 0;
        }
        return b;
    }

    public b[] c(long j) {
        a.c().b(A());
        if (p()) {
            return this.k.a(j);
        }
        return new b[0];
    }

    public static c a(long j, long j2, long j3) {
        return new c(j, j2, j3);
    }

    public static c a(long j, long j2, long j3, String str, String str2, long j4, String str3) {
        return new c(j, j2, j3, str, str2, j4, str3);
    }

    public ce a(c cVar, c cVar2) {
        a.c().b(A());
        return new ce(cVar, cVar2);
    }

    public bb s() {
        a.c().b(A());
        return new ce();
    }

    public ar a(long j, long j2) {
        a.c().b(A());
        return new ay(L(), j, 0, 0, j2);
    }

    public ar a(long j, String str) {
        a.c().b(A());
        return new ay(L(), j, str, 0);
    }

    public av d(long j) {
        a.c().b(A());
        if (!p() || this.j == null) {
            return null;
        }
        av a = this.j.a(new aw(this.k.h().getChapterResource(j)), false);
        if (!a.h()) {
            a = null;
        }
        return a;
    }

    public boolean e(long j) {
        a.c().b(A());
        if (p()) {
            return this.k.h().isDrmChapter(j);
        }
        return false;
    }

    public String f(long j) {
        a.c().b(A());
        if (!p()) {
            return "";
        }
        e eVar = this.k;
        if (eVar.c(j)) {
            return eVar.h().getChapterId(j);
        }
        return "";
    }

    public String g(long j) {
        a.c().b(A());
        if (!p()) {
            return "";
        }
        String chapterPackUri = this.k.h().getChapterPackUri(j);
        return TextUtils.equals(chapterPackUri, "/") ? "" : chapterPackUri;
    }

    public static aw[] b(String str) {
        int i = 0;
        ap apVar = new ap();
        apVar.a = str;
        aq a = ai.a(str, apVar, null);
        if (!a.b.isValid()) {
            return new aw[0];
        }
        DkeBook dkeBook = a.b;
        DkeResourceDescriptor[] allResources = dkeBook.getAllResources();
        aw[] awVarArr = new aw[allResources.length];
        while (i < awVarArr.length) {
            awVarArr[i] = new aw(allResources[i]);
            i++;
        }
        dkeBook.close();
        return awVarArr;
    }

    public WritingDirection c() {
        if (!p()) {
            return WritingDirection.TOP_TO_BOTTOM;
        }
        switch (this.k.h().getWritingMode()) {
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

    public FootnoteStyle d() {
        if (!p()) {
            return FootnoteStyle.NONE;
        }
        switch (this.k.h().getFootnoteAppearanceType()) {
            case 1:
                return FootnoteStyle.BUBBLE;
            case 2:
                return FootnoteStyle.PAPERTAPE;
            default:
                return FootnoteStyle.NONE;
        }
    }

    public long e() {
        long b;
        a.c().b(A());
        synchronized (this) {
            EpubTypesettingContext epubTypesettingContext = (EpubTypesettingContext) this.l.getLast();
            if (i || epubTypesettingContext != null) {
                b = epubTypesettingContext.b();
            } else {
                throw new AssertionError();
            }
        }
        return b;
    }

    public int f() {
        a.c().b(A());
        return 0;
    }

    public float g() {
        a.c().b(A());
        if (!p()) {
            return 0.0f;
        }
        EpubTypesettingContext L = L();
        e e = L.e();
        if (e != null) {
            return (((float) L.k) / ((float) e.i())) * 100.0f;
        }
        return 0.0f;
    }

    public g E() {
        a.c().b(A());
        if (p()) {
            return (g) this.k.d();
        }
        return null;
    }

    public l F() {
        a.c().b(A());
        EpubTypesettingContext L = L();
        return L == null ? null : L.i();
    }

    public boolean i() {
        boolean z = true;
        a.c().b(A());
        synchronized (this) {
            if (this.l.size() <= 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean j() {
        a.c().b(A());
        return L().c();
    }

    public k k() {
        k j;
        a.c().b(A());
        synchronized (this) {
            EpubTypesettingContext epubTypesettingContext = (EpubTypesettingContext) this.l.getLast();
            if (i || epubTypesettingContext != null) {
                j = epubTypesettingContext.j();
            } else {
                throw new AssertionError();
            }
        }
        return j;
    }

    public void a(k kVar) {
        a.c().b(A());
        if (i || kVar != null) {
            synchronized (this) {
                EpubTypesettingContext L = L();
                if (!L.j().equals(kVar)) {
                    this.l.addLast(new ad(this, L.i(), new am((am) kVar), this.m));
                }
            }
            this.m.release();
            return;
        }
        throw new AssertionError();
    }

    public au G() {
        a.c().b(A());
        return this.w;
    }

    public void a(m mVar) {
        a.c().b(A());
        if (i || mVar != null) {
            this.w = (au) mVar;
            return;
        }
        throw new AssertionError();
    }

    public f m() {
        a.c().b(A());
        if (p()) {
            return this.k.e();
        }
        return null;
    }

    public void a(l lVar) {
        a.c().a(this.a);
        if (!this.a) {
            if (this.s.getState() == State.NEW) {
                this.l.addLast(new ad(this, (ap) lVar, this.o, this.m));
                this.s.start();
                return;
            }
            synchronized (this) {
                this.l.addLast(new ad(this, (ap) lVar, L().j(), this.m));
            }
            this.m.release();
        }
    }

    public float j(ak akVar) {
        a.c().b(A());
        if (!d((com.duokan.reader.domain.document.a) akVar) || !akVar.e()) {
            return 0.0f;
        }
        float f;
        float max;
        long chapterPackSize;
        e eVar = this.k;
        ak akVar2 = (ak) c((com.duokan.reader.domain.document.a) akVar);
        c cVar = (c) akVar2.g();
        c cVar2 = (c) akVar2.h();
        long g = cVar.g();
        long chapterCount = eVar.h().getChapterCount();
        if (eVar.c() instanceof al) {
            f = 1.0f / ((float) chapterCount);
            max = ((float) Math.max(0, g - 1)) / ((float) chapterCount);
        } else {
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (j3 < chapterCount) {
                chapterPackSize = eVar.h().getChapterPackSize(j3);
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
        chapterPackSize = eVar.h().getChapterOffsetRange(g)[1];
        return (Math.max(0.0f, Math.min(chapterPackSize == 0 ? 1.0f : ((float) cVar2.l()) / ((float) chapterPackSize), 1.0f)) * f) + max;
    }

    public long b(ak akVar) {
        a.c().b(A());
        if (!d((com.duokan.reader.domain.document.a) akVar) || !akVar.e()) {
            return -1;
        }
        c cVar = (c) akVar.g();
        EpubTypesettingContext L = L();
        if (i || L != null) {
            return L.a(cVar.g(), cVar.h(), cVar.i());
        }
        throw new AssertionError();
    }

    public long a(av avVar) {
        c cVar = (c) avVar;
        EpubTypesettingContext L = L();
        if (i || L != null) {
            return L.a(cVar.g(), cVar.h(), cVar.i());
        }
        throw new AssertionError();
    }

    public long c(ak akVar) {
        a.c().b(A());
        return -1;
    }

    public long b(av avVar) {
        a.c().b(A());
        return -1;
    }

    public int b(int i) {
        a.c().b(A());
        return -1;
    }

    public int c(int i) {
        a.c().b(A());
        return -1;
    }

    public c H() {
        a.c().b(A());
        if (p()) {
            return a(this.k.h().getLeadingChapterIndex(), 0, 0);
        }
        return a(0, 0, 0);
    }

    public h k(ak akVar) {
        a.c().b(A());
        EpubTypesettingContext L = L();
        if (akVar instanceof h) {
            return (h) a((h) akVar, 0);
        }
        if (!(akVar instanceof ay)) {
            return null;
        }
        ay ayVar = (ay) akVar;
        EpubTypesettingContext j = ayVar.j();
        if (ayVar.b() || j == L || d((com.duokan.reader.domain.document.a) ayVar)) {
            return new h(L, ayVar, 0);
        }
        return null;
    }

    public ar I() {
        a.c().b(A());
        return new ay(L(), D() - 1, Long.MAX_VALUE, 0, -1);
    }

    public com.duokan.reader.domain.document.a c(com.duokan.reader.domain.document.a aVar) {
        a.c().b(A());
        a.c().b(aVar != null);
        if (!p()) {
            return null;
        }
        if (d(aVar) && aVar.e()) {
            e eVar = this.k;
            if (aVar instanceof c) {
                c cVar = (c) aVar;
                return a(cVar.g(), cVar.h(), cVar.i(), eVar.h().getBookRevision(), eVar.h().getChapterId(cVar.g()), a(eVar.h(), cVar.b(eVar.h()), new DkFlowPosition(cVar.g(), Long.MAX_VALUE, 0))[0], ah.e().a());
            } else if (aVar instanceof ce) {
                ce ceVar = (ce) aVar;
                r9 = ceVar.j();
                r13 = ceVar.k();
                r15 = a(eVar.h(), r9.b(eVar.h()), r13.b(eVar.h()));
                r12 = ah.e().a();
                return a(a(r9.g(), r9.h(), r9.i(), eVar.h().getBookRevision(), eVar.h().getChapterId(r9.g()), r15[0], r12), a(r13.g(), r13.h(), r13.i(), eVar.h().getBookRevision(), eVar.h().getChapterId(r13.g()), r15[1], r12));
            } else if (aVar instanceof ar) {
                ar arVar = (ar) aVar;
                r9 = (c) arVar.g();
                r13 = (c) arVar.h();
                r15 = a(eVar.h(), r9.b(eVar.h()), r13.b(eVar.h()));
                r12 = ah.e().a();
                return new ay(L(), a(r9.g(), r9.h(), r9.i(), eVar.h().getBookRevision(), eVar.h().getChapterId(r9.g()), r15[0], r12), a(r13.g(), r13.h(), r13.i(), eVar.h().getBookRevision(), eVar.h().getChapterId(r13.g()), r15[1], r12));
            }
        }
        return null;
    }

    public ce b(d dVar, d dVar2) {
        return a((c) dVar, (c) dVar2);
    }

    public ay h(long j) {
        a.c().b(A());
        return new ay(L(), 0, 0, 0, j);
    }

    public ar d(av avVar) {
        a.c().b(A());
        EpubTypesettingContext L = L();
        c cVar = (c) avVar;
        if (i || cVar != null) {
            return new ay(L, cVar.g(), cVar.h(), cVar.i(), 0);
        }
        throw new AssertionError();
    }

    public ar l(ak akVar) {
        a.c().b(A());
        if (!i && (akVar == null || !akVar.a())) {
            throw new AssertionError();
        } else if (akVar instanceof h) {
            return (ar) a(((h) akVar).j(), 0);
        } else {
            if (akVar instanceof ay) {
                return (ar) a((ay) akVar, 0);
            }
            return null;
        }
    }

    public ar m(ak akVar) {
        a.c().b(A());
        return (ar) a(akVar, 1);
    }

    public ar n(ak akVar) {
        a.c().b(A());
        return (ar) a(akVar, -1);
    }

    public ak a(ak akVar, int i) {
        a.c().b(A());
        if (i || (akVar != null && akVar.a())) {
            EpubTypesettingContext L = L();
            EpubTypesettingContext j;
            if (akVar instanceof h) {
                h hVar = (h) akVar;
                j = hVar.j().j();
                if (hVar.b() || j == L || d((com.duokan.reader.domain.document.a) hVar)) {
                    return new h(L, hVar, (long) i);
                }
                return null;
            } else if (!(akVar instanceof ay)) {
                return null;
            } else {
                ay ayVar = (ay) akVar;
                j = ayVar.j();
                if (ayVar.b() || j == L || d((com.duokan.reader.domain.document.a) ayVar)) {
                    return new ay(L, ayVar, (long) i);
                }
                return null;
            }
        }
        throw new AssertionError();
    }

    public boolean h(ak akVar) {
        boolean z = true;
        a.c().b(A());
        if (akVar instanceof h) {
            h hVar = (h) akVar;
            if (h(hVar.k()) || h(hVar.l())) {
                return true;
            }
            return false;
        } else if (!(akVar instanceof ay)) {
            return false;
        } else {
            akVar = (ay) akVar;
            if (akVar.b()) {
                if (!(akVar.k().g() == 0 && a((ay) akVar) == 0)) {
                    z = false;
                }
                return z;
            }
            if (!(d((com.duokan.reader.domain.document.a) akVar) && akVar.e() && h(akVar))) {
                z = false;
            }
            return z;
        }
    }

    public boolean i(ak akVar) {
        boolean z = true;
        a.c().b(A());
        if (akVar instanceof h) {
            h hVar = (h) akVar;
            if (i(hVar.l()) || i(hVar.k())) {
                return true;
            }
            return false;
        } else if (!(akVar instanceof ay)) {
            return false;
        } else {
            akVar = (ay) akVar;
            if (akVar.b()) {
                long g = akVar.k().g();
                long b = b(g);
                if (b < 1) {
                    return false;
                }
                if (!(g == D() - 1 && a((ay) akVar) == b - 1)) {
                    z = false;
                }
                return z;
            } else if (akVar.b == D() - 1 && akVar.e == Long.MAX_VALUE && akVar.g == -1) {
                return true;
            } else {
                if (!(d((com.duokan.reader.domain.document.a) akVar) && akVar.e() && i(akVar))) {
                    z = false;
                }
                return z;
            }
        }
    }

    public boolean d(com.duokan.reader.domain.document.a aVar) {
        a.c().b(A());
        if (!i && aVar == null) {
            throw new AssertionError();
        } else if (!i && !aVar.a()) {
            throw new AssertionError();
        } else if (!aVar.a()) {
            return false;
        } else {
            if (aVar.b()) {
                return true;
            }
            if (aVar instanceof h) {
                h hVar = (h) aVar;
                EpubTypesettingContext j = hVar.j().j();
                synchronized (this) {
                    if (j.a) {
                        j.a(hVar, null);
                    } else {
                        return false;
                    }
                }
            }
            if (aVar instanceof ay) {
                ay ayVar = (ay) aVar;
                EpubTypesettingContext j2 = ayVar.j();
                synchronized (this) {
                    if (j2.a) {
                        j2.a(ayVar, null);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public as a(ak akVar, m mVar) {
        a.c().b(A());
        if (i || akVar != null) {
            au G = mVar == null ? G() : (au) mVar;
            d((com.duokan.reader.domain.document.a) akVar);
            EpubTypesettingContext L = L();
            if (akVar instanceof h) {
                return new i(L, (h) akVar, G, this.g, this);
            }
            if (akVar instanceof ay) {
                return new az(L, (ay) akVar, G, this.g, this);
            }
            return null;
        }
        throw new AssertionError();
    }

    public Bitmap a(String str, Rect rect, int i, int i2) {
        Bitmap c = com.duokan.reader.common.bitmap.a.c(i, i2, Config.RGB_565);
        c.eraseColor(-1);
        new DkFlowRenderOption().mBitmap = c;
        DkBox dkBox = new DkBox((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        dkBox = new DkBox(0.0f, 0.0f, (float) i, (float) i2);
        M();
        return c;
    }

    public aa a(av avVar, String str, int i) {
        a.c().b(A());
        if (!p()) {
            return new aa(str);
        }
        if (avVar == null) {
            avVar = a(0, 0, 0);
        }
        e eVar = this.k;
        eVar.f();
        return a(eVar, avVar, str, i);
    }

    public aa a(aa aaVar, int i) {
        a.c().b(A());
        if (!i && aaVar == null) {
            throw new AssertionError();
        } else if (!p()) {
            return new aa(aaVar.a);
        } else {
            if (aaVar.b.length < 1) {
                return new aa(aaVar.a);
            }
            e eVar = this.k;
            eVar.f();
            return a(eVar, aaVar.b[aaVar.b.length - 1].a.h(), aaVar.a, i);
        }
    }

    public y a(String str) {
        a.c().b(A());
        if (!p()) {
            return null;
        }
        j jVar = this.k;
        return new y(jVar, jVar.h().getFileStream(str));
    }

    protected void t() {
        synchronized (this) {
            ad adVar = new ad(this, L().i(), new am(), this.m);
            adVar.c = true;
            this.l.add(adVar);
        }
        this.m.release();
    }

    public void a(n nVar, as asVar) {
        a(asVar);
    }

    public void b(n nVar, as asVar) {
        b(asVar);
    }

    private String a(EpubTypesettingContext epubTypesettingContext) {
        e e = epubTypesettingContext.e();
        if (epubTypesettingContext.i() instanceof al) {
            return b(epubTypesettingContext);
        }
        if (e.h().isLinear()) {
            return c(epubTypesettingContext);
        }
        return d(epubTypesettingContext);
    }

    private String b(EpubTypesettingContext epubTypesettingContext) {
        an anVar = ((al) epubTypesettingContext.i()).b;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < anVar.a(); i++) {
            stringBuilder.append(anVar.a(i).c()).append(';');
        }
        return o.b(stringBuilder.toString(), "md5");
    }

    private String c(EpubTypesettingContext epubTypesettingContext) {
        int i;
        e e = epubTypesettingContext.e();
        DkeResourceDescriptor[] allResources = e.h().getAllResources();
        LinkedList linkedList = new LinkedList();
        for (DkeResourceDescriptor dkeResourceDescriptor : allResources) {
            if (dkeResourceDescriptor.resourceType == 0 || dkeResourceDescriptor.resourceType == 3 || dkeResourceDescriptor.resourceType == 1) {
                linkedList.add(dkeResourceDescriptor.packUri);
            }
        }
        if (this.j != null) {
            for (DkeResourceDescriptor dkeResourceDescriptor2 : allResources) {
                if ((dkeResourceDescriptor2.resourceType == 0 || dkeResourceDescriptor2.resourceType == 3 || dkeResourceDescriptor2.resourceType == 1) && !this.j.a(new aw(dkeResourceDescriptor2), false).i()) {
                    linkedList.remove(dkeResourceDescriptor2.packUri);
                }
            }
        } else {
            linkedList.clear();
        }
        if (epubTypesettingContext.k == e.i()) {
            for (i = 0; ((long) i) < e.i(); i++) {
                for (av g : epubTypesettingContext.c((long) i)) {
                    linkedList.remove(g.g().a);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next()).append(';');
        }
        stringBuilder.append("drm=").append(epubTypesettingContext.i() instanceof ag);
        return o.b(stringBuilder.toString(), "md5");
    }

    private String d(EpubTypesettingContext epubTypesettingContext) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("drm=").append(epubTypesettingContext.i() instanceof ag);
        return o.b(stringBuilder.toString(), "md5");
    }

    private ak a(e eVar, av avVar, String str, int i) {
        if (i || avVar != null) {
            Object vVar = new v(this, str, i, avVar, eVar, str);
            if (this.x.isShutdown()) {
                vVar.b = new z[0];
                a((aa) vVar);
            } else {
                this.x.execute(vVar);
            }
            return vVar;
        }
        throw new AssertionError();
    }

    private void J() {
        while (true) {
            try {
                if (this.q) {
                    this.n.tryAcquire(10, TimeUnit.MILLISECONDS);
                } else {
                    this.n.acquireUninterruptibly();
                }
            } catch (InterruptedException e) {
                if (!i) {
                    throw new AssertionError();
                }
            }
            synchronized (this) {
                EpubTypesettingContext epubTypesettingContext = (ad) this.l.getFirst();
                int i = this.l.size() > 1 ? 1 : 0;
            }
            if (epubTypesettingContext.b) {
                ch chVar;
                e e2 = epubTypesettingContext.e();
                synchronized (epubTypesettingContext) {
                    Iterator it = epubTypesettingContext.n.iterator();
                    while (it.hasNext()) {
                        ch chVar2 = (ch) it.next();
                        if (!i && chVar2 == null) {
                            throw new AssertionError();
                        } else if (!i && chVar2.c == null) {
                            throw new AssertionError();
                        } else if (!chVar2.c.b()) {
                            chVar = null;
                            break;
                        } else if (chVar2.c.d()) {
                            it.remove();
                            if (chVar2.b != null) {
                                chVar2.b.b(chVar2.c);
                            }
                        } else if (chVar2.c.c()) {
                            it.remove();
                            chVar = chVar2;
                            break;
                        } else if (a(epubTypesettingContext, chVar2)) {
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
                    if (chVar.a.c()) {
                        c a;
                        c cVar;
                        c a2;
                        if (chVar.c.c) {
                            a2 = a(0, Long.MIN_VALUE, 0);
                            a2.b = epubTypesettingContext;
                            a2.a = chVar.c.b;
                            a = a(0, Long.MIN_VALUE, 0);
                            a.b = epubTypesettingContext;
                            a.a = chVar.c.b;
                            cVar = a2;
                        } else if (chVar.c.d) {
                            a2 = a(chVar.c.a, Long.MAX_VALUE, 0);
                            a2.b = epubTypesettingContext;
                            a2.a = chVar.c.b;
                            a = a(chVar.c.a, Long.MAX_VALUE, 0);
                            a.b = epubTypesettingContext;
                            a.a = chVar.c.b;
                            cVar = a2;
                        } else {
                            DkFlowPosition dkFlowPosition = new DkFlowPosition();
                            DkFlowPosition dkFlowPosition2 = new DkFlowPosition();
                            ai.a(e2.h(), chVar.c.a, chVar.c.b, dkFlowPosition, dkFlowPosition2);
                            a2 = a(dkFlowPosition.mChapterIndex, dkFlowPosition.mParaIndex, dkFlowPosition.mAtomIndex);
                            a2.b = epubTypesettingContext;
                            a2.a = chVar.c.b;
                            a = a(dkFlowPosition2.mChapterIndex, dkFlowPosition2.mParaIndex, dkFlowPosition2.mAtomIndex);
                            a.b = epubTypesettingContext;
                            a.a = chVar.c.b;
                            cVar = a2;
                        }
                        chVar.a.a(cVar, a);
                    }
                    if (chVar.b != null) {
                        chVar.b.a(chVar.c);
                    }
                }
                if (i == 1 && r11 == null && chVar == null && epubTypesettingContext.a()) {
                    synchronized (this) {
                        if (epubTypesettingContext.k() == null) {
                            epubTypesettingContext.a = false;
                            this.l.removeFirst();
                            this.n.drainPermits();
                            this.m.release();
                            if (((EpubTypesettingContext) this.l.getFirst()).c) {
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
    private void K() {
        /*
        r16 = this;
        r6 = 0;
    L_0x0001:
        monitor-enter(r16);
        r0 = r16;
        r2 = r0.l;	 Catch:{ all -> 0x003b }
        r2 = r2.size();	 Catch:{ all -> 0x003b }
        r3 = 1;
        if (r2 <= r3) goto L_0x0027;
    L_0x000d:
        r2 = 1;
        r7 = r2;
    L_0x000f:
        r0 = r16;
        r2 = r0.l;	 Catch:{ all -> 0x003b }
        r2 = r2.getFirst();	 Catch:{ all -> 0x003b }
        r0 = r2;
        r0 = (com.duokan.reader.domain.document.epub.ad) r0;	 Catch:{ all -> 0x003b }
        r4 = r0;
        r2 = r4.c;	 Catch:{ all -> 0x003b }
        if (r2 == 0) goto L_0x002a;
    L_0x001f:
        monitor-exit(r16);	 Catch:{ all -> 0x003b }
        r16.P();
        r16.x();
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
        r2 = i;
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
        r2 = r4.i();
        if (r2 != 0) goto L_0x0059;
    L_0x0049:
        r0 = r16;
        r3 = r0.j;
        if (r6 != 0) goto L_0x00be;
    L_0x004f:
        r2 = 0;
    L_0x0050:
        r0 = r16;
        r2 = r3.a(r0, r2);
        r4.a(r2);
    L_0x0059:
        if (r6 != 0) goto L_0x00c8;
    L_0x005b:
        r2 = r4.i();
        r0 = r16;
        r2 = r0.a(r2);
        r0 = r16;
        r0.k = r2;
        r0 = r16;
        r2 = r0.k;
        if (r2 == 0) goto L_0x00c3;
    L_0x006f:
        r0 = r16;
        r2 = r0.k;
        r4.p = r2;
        r16.u();
        r2 = 0;
        r2 = (long[][]) r2;
        r0 = r16;
        r3 = r0.t;
        r3.start();
        r5 = r2;
    L_0x0084:
        r0 = r16;
        r2 = r0.k;
        r8 = r4.p;
        r0 = r16;
        r0.k = r8;
        r0 = r16;
        r3 = r0.k;
        r3 = r2.equals(r3);
        if (r3 != 0) goto L_0x00a4;
    L_0x009a:
        r3 = new com.duokan.reader.domain.document.epub.w;
        r0 = r16;
        r3.<init>(r0, r2);
        com.duokan.core.sys.t.a(r3);
    L_0x00a4:
        r2 = r4.j();
        r9 = r2.j;
        r2 = com.duokan.reader.domain.document.epub.ah.e();
        r10 = r2.d();
        r2 = i;
        if (r2 != 0) goto L_0x02b5;
    L_0x00b6:
        if (r10 != 0) goto L_0x02b5;
    L_0x00b8:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x00be:
        r2 = r6.i();
        goto L_0x0050;
    L_0x00c3:
        r16.v();
        goto L_0x0026;
    L_0x00c8:
        r2 = r4.i();
        r3 = r6.i();
        if (r2 == r3) goto L_0x02a3;
    L_0x00d2:
        r2 = r6.p;
        r2 = (com.duokan.reader.domain.document.epub.ab) r2;
        r5 = r2.h();
        r3 = r4.i();
        r3 = r3 instanceof com.duokan.reader.domain.document.epub.al;
        if (r3 == 0) goto L_0x0194;
    L_0x00e4:
        r2 = r2.c;
        r2 = (com.duokan.reader.domain.document.epub.al) r2;
        r8 = r2.b;
        r2 = r4.i();
        r2 = (com.duokan.reader.domain.document.epub.al) r2;
        r9 = r2.b;
        r2 = r9.a(r8);
        r3 = 2;
        if (r2 != r3) goto L_0x0128;
    L_0x00fb:
        r2 = r4.i();
        r0 = r16;
        r2 = r0.a(r2);
        if (r2 == 0) goto L_0x0110;
    L_0x0107:
        r4.p = r2;
        r2 = 0;
        r2 = (long[][]) r2;
    L_0x010d:
        r5 = r2;
        goto L_0x0084;
    L_0x0110:
        r2 = com.duokan.core.diagnostic.a.c();
        r3 = 0;
        r2.b(r3);
        r2 = r6.p;
        r4.p = r2;
        r2 = r4.j();
        r2 = r6.a(r2);
        goto L_0x010d;
    L_0x0128:
        r3 = 1;
        if (r2 != r3) goto L_0x0183;
    L_0x012b:
        r3 = new com.duokan.reader.domain.document.epub.ab;
        r10 = r4.i();
        r2 = r4.i();
        r2 = (com.duokan.reader.domain.document.epub.al) r2;
        r2 = r2.b;
        r2 = com.duokan.reader.domain.document.epub.ai.a(r2);
        r0 = r16;
        r3.<init>(r0, r10, r5, r2);
        r4.p = r3;
        r2 = r4.j();
        r3 = r6.a(r2);
        if (r3 == 0) goto L_0x04f8;
    L_0x014f:
        r2 = 0;
    L_0x0150:
        r10 = r9.a();
        if (r2 >= r10) goto L_0x0181;
    L_0x0156:
        r10 = r9.a(r2);
        r11 = r10.c();
        r12 = r8.a(r2);
        r12 = r12.c();
        r11 = android.text.TextUtils.equals(r11, r12);
        if (r11 != 0) goto L_0x017e;
    L_0x016c:
        r11 = r10.a();
        r10 = r10.c();
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
        r2 = r6.p;
        r4.p = r2;
        r2 = r4.j();
        r2 = r6.a(r2);
        goto L_0x010d;
    L_0x0194:
        r2 = r2.c();
        r2 = r2.a;
        r3 = r4.i();
        r3 = r3.a;
        r2 = android.text.TextUtils.equals(r2, r3);
        if (r2 != 0) goto L_0x0218;
    L_0x01a6:
        r2 = r4.i();
        r0 = r16;
        r2 = r0.a(r2);
        if (r2 == 0) goto L_0x0200;
    L_0x01b2:
        r4.p = r2;
        r2 = 0;
        r2 = (long[][]) r2;
    L_0x01b8:
        r3 = r2;
    L_0x01b9:
        if (r3 == 0) goto L_0x04f8;
    L_0x01bb:
        r2 = r4.p;
        r5 = r2.h();
        r2 = 0;
    L_0x01c4:
        r8 = (long) r2;
        r10 = r4.p;
        r10 = r10.i();
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
        r9 = r0.j;
        r10 = new com.duokan.reader.domain.document.epub.aw;
        r10.<init>(r8);
        r8 = 0;
        r8 = r9.a(r10, r8);
        r8 = r8.i();
        if (r8 == 0) goto L_0x01fd;
    L_0x01fa:
        r8 = 0;
        r3[r2] = r8;
    L_0x01fd:
        r2 = r2 + 1;
        goto L_0x01c4;
    L_0x0200:
        r2 = com.duokan.core.diagnostic.a.c();
        r3 = 0;
        r2.b(r3);
        r2 = r6.p;
        r4.p = r2;
        r2 = r4.j();
        r2 = r6.a(r2);
        goto L_0x01b8;
    L_0x0218:
        r2 = r4.i();
        r2 = r2 instanceof com.duokan.reader.domain.document.epub.ag;
        if (r2 == 0) goto L_0x0257;
    L_0x0220:
        r2 = r4.i();
        r2 = (com.duokan.reader.domain.document.epub.ag) r2;
        r3 = r2.a;
        r3 = android.net.Uri.parse(r3);
        r3 = r3.getPath();
        r8 = com.duokan.reader.domain.document.epub.ah.e();
        r8 = r8.c();
        r2 = r2.b;
        r5.openDrm(r3, r8, r2);
        r2 = new com.duokan.reader.domain.document.epub.ab;
        r3 = r4.i();
        r8 = 0;
        r0 = r16;
        r2.<init>(r0, r3, r5, r8);
        r4.p = r2;
        r2 = r4.j();
        r2 = r6.a(r2);
        r3 = r2;
        goto L_0x01b9;
    L_0x0257:
        r2 = r6.i();
        r2 = r2 instanceof com.duokan.reader.domain.document.epub.ag;
        if (r2 == 0) goto L_0x028c;
    L_0x025f:
        r2 = r4.i();
        r0 = r16;
        r2 = r0.a(r2);
        if (r2 == 0) goto L_0x0274;
    L_0x026b:
        r4.p = r2;
        r2 = 0;
        r2 = (long[][]) r2;
    L_0x0271:
        r3 = r2;
        goto L_0x01b9;
    L_0x0274:
        r2 = com.duokan.core.diagnostic.a.c();
        r3 = 0;
        r2.b(r3);
        r2 = r6.p;
        r4.p = r2;
        r2 = r4.j();
        r2 = r6.a(r2);
        goto L_0x0271;
    L_0x028c:
        r2 = r6.p;
        r4.p = r2;
        r2 = r4.j();
        r2 = r6.a(r2);
        r3 = r2;
        goto L_0x01b9;
    L_0x029e:
        r8 = 0;
        r3[r2] = r8;
        goto L_0x01fd;
    L_0x02a3:
        r2 = r6.p;
        r4.p = r2;
        r2 = r4.j();
        r2 = r6.a(r2);
        r5 = r2;
        goto L_0x0084;
    L_0x02b5:
        r2 = i;
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
        r2 = com.duokan.reader.domain.document.n.a(r9, r2);
        r3 = "DEFAULT_FONT_EN";
        r3 = com.duokan.reader.domain.document.n.a(r9, r3);
        r11 = "CUSTOM_FONT_ZH";
        r11 = com.duokan.reader.domain.document.n.b(r9, r11);
        r12 = "DEFAULT_FONT_ZH";
        r12 = com.duokan.reader.domain.document.n.b(r9, r12);
        r13 = "FALLBACK_FONT";
        r9 = com.duokan.reader.domain.document.n.c(r9, r13);
        r13 = android.text.TextUtils.isEmpty(r2);
        if (r13 != 0) goto L_0x0408;
    L_0x0326:
        r10.registerFont(r2, r2);
        r13 = r8.h();
        r14 = 0;
        r13.setBodyFontFamily(r2, r14);
    L_0x0331:
        r13 = android.text.TextUtils.isEmpty(r11);
        if (r13 != 0) goto L_0x0414;
    L_0x0337:
        r10.registerFont(r11, r11);
        r13 = r8.h();
        r14 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r13.setBodyFontFamily(r11, r14);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x035f;
    L_0x0349:
        r2 = r8.h();
        r2 = r2.getBookId();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x035f;
    L_0x0357:
        r2 = r8.h();
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
        r2 = r4.j();
        r2 = r2.f;
        r3 = 2;
        r2 = java.lang.Math.max(r2, r3);
        r3 = r8.h();
        r10 = (double) r2;
        r3.setBodyFontSize(r10);
        r2 = r4.j();
        r2 = r2.g;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 >= 0) goto L_0x0439;
    L_0x03af:
        r2 = com.duokan.reader.domain.document.epub.ah.e();
        r2 = r2.d();
        r3 = 1;
        r2.setUseBookStyle(r3);
    L_0x03bb:
        r2 = r8.h();
        r2.clearAllParsedPages();
        r2 = r8.i();
        r2 = (int) r2;
        r2 = new long[r2][];
        r4.i = r2;
        r2 = r8.i();
        r2 = (int) r2;
        r2 = new com.duokan.reader.domain.document.epub.EpubTypesettingContext.ChapterState[r2];
        r4.j = r2;
        r2 = r4.j;
        r3 = com.duokan.reader.domain.document.epub.EpubTypesettingContext.ChapterState.NOT_TYPESETTED;
        java.util.Arrays.fill(r2, r3);
        r2 = r4.l;
        r10 = r8.i();
        r3 = (int) r10;
        r2.ensureCapacity(r3);
        r2 = r4.m;
        r10 = r8.i();
        r3 = (int) r10;
        r2.ensureCapacity(r3);
        r2 = 0;
    L_0x03f0:
        r10 = (long) r2;
        r12 = r8.i();
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
        r13 = r8.h();
        r14 = "";
        r15 = 0;
        r13.setBodyFontFamily(r14, r15);
        goto L_0x0331;
    L_0x0414:
        r2 = r8.h();
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
        r2 = com.duokan.reader.domain.document.epub.ah.e();
        r2 = r2.d();
        r3 = 0;
        r2.setUseBookStyle(r3);
        r2 = r8.h();
        r3 = r4.j();
        r10 = r3.g;
        r2.setLineGap(r10);
        r2 = r8.h();
        r3 = r4.j();
        r10 = r3.h;
        r2.setParaSpacing(r10);
        r2 = r8.h();
        r3 = r4.j();
        r10 = r3.i;
        r2.setFirstLineIndent(r10);
        goto L_0x03bb;
    L_0x046e:
        if (r5 != 0) goto L_0x04e5;
    L_0x0470:
        r0 = r16;
        r0.a(r4, r6);
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.r = r2;
    L_0x047d:
        r16.z();
        r2 = 1;
        r4.b = r2;
    L_0x0483:
        r2 = r4.k();
        if (r2 == 0) goto L_0x04ae;
    L_0x0489:
        r3 = 1;
        r0 = r16;
        r0.q = r3;
        r0 = r16;
        r3 = r0.n;
        r3.release();
        r0 = r16;
        r0.a(r2, r4);
        r3 = 0;
        r0 = r16;
        r0.q = r3;
        r8 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r0.r = r8;
        r0 = r16;
        r3 = r0.n;
        r3.release();
    L_0x04ae:
        if (r2 != 0) goto L_0x04e2;
    L_0x04b0:
        r0 = r16;
        r2 = r0.n;
        r2.release();
        r2 = r4.j();
        r0 = r16;
        r3 = r0.o;
        if (r2 == r3) goto L_0x04e8;
    L_0x04c1:
        if (r7 != 0) goto L_0x04e8;
    L_0x04c3:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r6 = r0.r;
        r2 = r2 - r6;
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x04e8;
    L_0x04d2:
        r2 = 1;
        r0 = r16;
        r2 = r0.a(r4, r2);
        if (r2 != 0) goto L_0x04e2;
    L_0x04db:
        r0 = r16;
        r2 = r0.m;
        r2.acquireUninterruptibly();
    L_0x04e2:
        r6 = r4;
        goto L_0x0001;
    L_0x04e5:
        r4.i = r5;
        goto L_0x047d;
    L_0x04e8:
        r0 = r16;
        r2 = r0.m;	 Catch:{ Exception -> 0x04f4 }
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

    private void a(EpubTypesettingContext epubTypesettingContext, EpubTypesettingContext epubTypesettingContext2) {
        long[][] a;
        long[][] jArr = (long[][]) null;
        if (this.j != null) {
            a = this.j.a(this, a(epubTypesettingContext), epubTypesettingContext.j());
        } else {
            a = jArr;
        }
        if (a != null) {
            boolean z;
            a c = a.c();
            if (((long) a.length) == epubTypesettingContext.e().i()) {
                z = true;
            } else {
                z = false;
            }
            c.b(z);
            epubTypesettingContext.i = a;
            a(epubTypesettingContext, false);
        }
    }

    private boolean a(EpubTypesettingContext epubTypesettingContext, boolean z) {
        if (i || epubTypesettingContext != null) {
            e e = epubTypesettingContext.e();
            if (!i && e.i() < 0) {
                throw new AssertionError();
            } else if (epubTypesettingContext.k == e.i()) {
                return false;
            } else {
                long i = e.i() - 1;
                while (i >= 0) {
                    if (b(epubTypesettingContext, i) < 0 && (i == 0 || b(epubTypesettingContext, i - 1) >= 0)) {
                        a(epubTypesettingContext, i, epubTypesettingContext.j());
                        break;
                    }
                    i--;
                }
                long j = 0;
                for (i = 0; i < e.i(); i++) {
                    if (b(epubTypesettingContext, i) >= 0) {
                        j++;
                    }
                }
                epubTypesettingContext.k = j;
                if (epubTypesettingContext.k == e.i()) {
                    e(epubTypesettingContext);
                    if (this.j != null && z) {
                        this.j.a(this, a(epubTypesettingContext), epubTypesettingContext.j(), epubTypesettingContext.i);
                    }
                    y();
                    return false;
                }
                y();
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.duokan.reader.domain.document.epub.ch r25, com.duokan.reader.domain.document.epub.EpubTypesettingContext r26) {
        /*
        r24 = this;
        r4 = i;
        if (r4 != 0) goto L_0x000c;
    L_0x0004:
        if (r26 != 0) goto L_0x000c;
    L_0x0006:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x000c:
        r4 = i;
        if (r4 != 0) goto L_0x0018;
    L_0x0010:
        if (r25 != 0) goto L_0x0018;
    L_0x0012:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x0018:
        r14 = r26.e();
        r4 = i;
        if (r4 != 0) goto L_0x0030;
    L_0x0020:
        r4 = r14.i();
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 > 0) goto L_0x0030;
    L_0x002a:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x0030:
        r0 = r25;
        r4 = r0.a;
        r4 = r4.c();
        if (r4 == 0) goto L_0x0057;
    L_0x003a:
        r0 = r25;
        r4 = r0.a;
        r4 = r4.c;
        r4 = java.lang.Float.isNaN(r4);
        if (r4 != 0) goto L_0x0057;
    L_0x0046:
        r0 = r25;
        r4 = r0.a;
        r4 = r4.b;
        r6 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r4, r6);
    L_0x0057:
        r0 = r25;
        r4 = r0.a;
        r4 = r4.c();
        if (r4 == 0) goto L_0x007e;
    L_0x0061:
        r0 = r25;
        r4 = r0.a;
        r4 = r4.d;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x007e;
    L_0x006d:
        r0 = r25;
        r4 = r0.a;
        r4 = r4.b;
        r6 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r4, r6);
    L_0x007e:
        r0 = r24;
        r1 = r26;
        r2 = r25;
        r4 = r0.b(r1, r2);
        r5 = 0;
        r6 = r4[r5];
        r5 = 1;
        r8 = r4[r5];
        r5 = 2;
        r10 = r4[r5];
        r5 = 3;
        r16 = r4[r5];
        r0 = r25;
        r4 = r0.a;
        r4 = r4.b();
        if (r4 == 0) goto L_0x00c2;
    L_0x009e:
        r0 = r25;
        r4 = r0.a;
        r4 = r4.k();
        r4 = r4.g();
        r6 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r4, r6);
    L_0x00b5:
        r0 = r24;
        r1 = r26;
        r2 = r25;
        r4 = r0.a(r1, r2);
        if (r4 == 0) goto L_0x01f3;
    L_0x00c1:
        return;
    L_0x00c2:
        r4 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r6, r4);
        r4 = 0;
        r12 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r12 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r12 != 0) goto L_0x0124;
    L_0x00d8:
        r0 = r24;
        r1 = r26;
        r4 = r0.b(r1, r6);
    L_0x00e0:
        r12 = r4 + r16;
        r4 = 0;
        r4 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x01a9;
    L_0x00e8:
        r4 = 0;
    L_0x00ea:
        r10 = r14.i();
        r10 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r10 >= 0) goto L_0x00b5;
    L_0x00f2:
        r0 = r24;
        r1 = r26;
        r10 = r0.b(r1, r6);
        r18 = 0;
        r15 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1));
        if (r15 >= 0) goto L_0x0113;
    L_0x0100:
        r10 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r6, r10);
        r0 = r24;
        r1 = r26;
        r10 = r0.b(r1, r6);
    L_0x0113:
        r4 = r4 + r10;
        r10 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r10 >= 0) goto L_0x01a4;
    L_0x0118:
        r4 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r6, r4);
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
        r4 = r14.h();
        r4 = r4.getPageOfChapterEx(r6, r12);
        r5 = i;
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
        r4 = i;
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
        r4 = i;
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
        r4 = com.duokan.reader.domain.document.epub.ai.a(r5, r15, r0);
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
        r4 = r0.b(r1, r6);
        r18 = 0;
        r15 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1));
        if (r15 >= 0) goto L_0x01d7;
    L_0x01c4:
        r4 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r6, r4);
        r0 = r24;
        r1 = r26;
        r4 = r0.b(r1, r6);
    L_0x01d7:
        r10 = r10 + r4;
        r4 = java.lang.Math.abs(r12);
        r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r4 > 0) goto L_0x01ed;
    L_0x01e0:
        r4 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r6, r4);
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
        r4 = r14.i();
        r6 = 1;
        r4 = r4 - r6;
    L_0x020c:
        r6 = 0;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 < 0) goto L_0x0293;
    L_0x0212:
        r6 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r4, r6);
        r0 = r24;
        r1 = r26;
        r6 = r0.b(r1, r4);
        r8 = 0;
        r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r8 <= 0) goto L_0x024a;
    L_0x022b:
        r0 = r25;
        r8 = r0.c;
        r9 = 1;
        r8.d = r9;
        r0 = r25;
        r8 = r0.c;
        r8.a = r4;
        r0 = r25;
        r4 = r0.c;
        r8 = 1;
        r6 = r6 - r8;
        r4.b = r6;
        r0 = r25;
        r4 = r0.c;
        r4.f();
        goto L_0x00c1;
    L_0x024a:
        r6 = 1;
        r4 = r4 - r6;
        goto L_0x020c;
    L_0x024e:
        r4 = 0;
    L_0x0250:
        r6 = r14.i();
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 >= 0) goto L_0x0293;
    L_0x0258:
        r6 = r26.j();
        r0 = r24;
        r1 = r26;
        r0.b(r1, r4, r6);
        r0 = r24;
        r1 = r26;
        r6 = r0.b(r1, r4);
        r8 = 0;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x028f;
    L_0x0271:
        r0 = r25;
        r6 = r0.c;
        r7 = 1;
        r6.c = r7;
        r0 = r25;
        r6 = r0.c;
        r6.a = r4;
        r0 = r25;
        r4 = r0.c;
        r6 = 0;
        r4.b = r6;
        r0 = r25;
        r4 = r0.c;
        r4.f();
        goto L_0x00c1;
    L_0x028f:
        r6 = 1;
        r4 = r4 + r6;
        goto L_0x0250;
    L_0x0293:
        r4 = i;
        if (r4 != 0) goto L_0x00c1;
    L_0x0297:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.s.a(com.duokan.reader.domain.document.epub.ch, com.duokan.reader.domain.document.epub.EpubTypesettingContext):void");
    }

    private boolean a(EpubTypesettingContext epubTypesettingContext, ch chVar) {
        e e = epubTypesettingContext.e();
        if (!Float.isNaN(chVar.a.c) && epubTypesettingContext.j[(int) chVar.a.b] != ChapterState.TYPESETTED) {
            return false;
        }
        if (!TextUtils.isEmpty(chVar.a.d)) {
            if (epubTypesettingContext.j[(int) chVar.a.b] == ChapterState.NOT_TYPESETTED) {
                return false;
            }
            if (a(epubTypesettingContext, chVar.a.b) < 1) {
                return false;
            }
        }
        long[] b = b(epubTypesettingContext, chVar);
        long j = b[0];
        long j2 = b[1];
        long j3 = b[2];
        long j4 = b[3];
        long j5;
        if (chVar.a.b()) {
            c k = chVar.a.k();
            if (chVar.a.f()) {
                return false;
            }
            j5 = 0;
            while (true) {
                DkePage pageOfChapterEx = e.h().getPageOfChapterEx(k.g(), j5);
                if (pageOfChapterEx == null) {
                    return false;
                }
                DkFlowPosition dkFlowPosition = new DkFlowPosition(k.b(e.h()));
                DkFlowPosition dkFlowPosition2 = new DkFlowPosition();
                DkFlowPosition dkFlowPosition3 = new DkFlowPosition();
                pageOfChapterEx.getBeginPosition(dkFlowPosition2);
                pageOfChapterEx.getEndPosition(dkFlowPosition3);
                if (!i && dkFlowPosition2.mChapterIndex != dkFlowPosition3.mChapterIndex) {
                    throw new AssertionError();
                } else if (!i && dkFlowPosition2.mChapterIndex != k.g()) {
                    throw new AssertionError();
                } else if (ai.a(dkFlowPosition, dkFlowPosition2, dkFlowPosition3)) {
                    chVar.c.a = k.g();
                    chVar.c.b = j5;
                    chVar.c.f();
                    return true;
                } else {
                    j5++;
                }
            }
        } else if (!i && !chVar.a.j().b) {
            throw new AssertionError();
        } else if (j < 0 || j >= e.i()) {
            return false;
        } else {
            j5 = 0;
            if (j2 == Long.MAX_VALUE) {
                if (b(epubTypesettingContext, j) < 0) {
                    return false;
                }
                j5 = b(epubTypesettingContext, j);
            } else if (j2 == Long.MIN_VALUE) {
                j5 = -1;
            } else if (!(j2 == 0 && j3 == 0)) {
                long j6 = 0;
                while (true) {
                    DkePage pageOfChapterEx2 = e.h().getPageOfChapterEx(j, j6);
                    if (pageOfChapterEx2 == null) {
                        return false;
                    }
                    DkFlowPosition dkFlowPosition4 = new DkFlowPosition(j, j2, j3);
                    DkFlowPosition dkFlowPosition5 = new DkFlowPosition();
                    DkFlowPosition dkFlowPosition6 = new DkFlowPosition();
                    pageOfChapterEx2.getBeginPosition(dkFlowPosition5);
                    pageOfChapterEx2.getEndPosition(dkFlowPosition6);
                    if (!i && dkFlowPosition5.mChapterIndex != dkFlowPosition6.mChapterIndex) {
                        throw new AssertionError();
                    } else if (!i && dkFlowPosition5.mChapterIndex != j) {
                        throw new AssertionError();
                    } else if (ai.a(dkFlowPosition4, dkFlowPosition5, dkFlowPosition6)) {
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
                while (j < e.i()) {
                    j2 = b(epubTypesettingContext, j);
                    if (j2 >= 0) {
                        if (j3 >= j5 + j2) {
                            j5 += j2;
                            j++;
                        } else if (j3 >= a(epubTypesettingContext, j) + j5) {
                            return false;
                        } else {
                            chVar.c.a = j;
                            chVar.c.b = j3 - j5;
                            chVar.c.f();
                            return true;
                        }
                    } else if (j3 >= a(epubTypesettingContext, j) + j5) {
                        return false;
                    } else {
                        chVar.c.a = j;
                        chVar.c.b = j3 - j5;
                        chVar.c.f();
                        return true;
                    }
                }
                return false;
            }
            j = 0;
            for (j5 = j - 1; j5 >= 0; j5--) {
                j2 = b(epubTypesettingContext, j5);
                if (j2 < 0) {
                    return false;
                }
                if (Math.abs(j3) <= j + j2) {
                    if ((j + j2) + j3 >= a(epubTypesettingContext, j5)) {
                        return false;
                    }
                    chVar.c.a = j5;
                    chVar.c.b = (j + j2) + j3;
                    chVar.c.f();
                    return true;
                }
                j += j2;
            }
            return false;
        }
    }

    private void a(EpubTypesettingContext epubTypesettingContext, long j, am amVar) {
        e e = epubTypesettingContext.e();
        if (j >= 0 && j < e.i() && epubTypesettingContext.j[(int) j] != ChapterState.TYPESETTED) {
            HashSet hashSet;
            M();
            long[] calcChapterPages = e.h().calcChapterPages(ai.a(amVar, j));
            if (epubTypesettingContext.l.get((int) j) == null) {
                hashSet = new HashSet();
                hashSet.addAll(N());
                epubTypesettingContext.l.set((int) j, hashSet);
            }
            if (epubTypesettingContext.m.get((int) j) == null) {
                hashSet = new HashSet();
                hashSet.addAll(O());
                epubTypesettingContext.m.set((int) j, hashSet);
            }
            epubTypesettingContext.i[(int) j] = calcChapterPages;
        }
    }

    private void b(EpubTypesettingContext epubTypesettingContext, long j, am amVar) {
        e e = epubTypesettingContext.e();
        if (j >= 0 && j < e.i() && epubTypesettingContext.j[(int) j] != ChapterState.TYPESETTED) {
            HashSet hashSet;
            epubTypesettingContext.j[(int) j] = ChapterState.TYPESETTING;
            M();
            e.h().parseContent(ai.a(amVar, j));
            if (epubTypesettingContext.l.get((int) j) == null) {
                hashSet = new HashSet();
                hashSet.addAll(N());
                epubTypesettingContext.l.set((int) j, hashSet);
            }
            if (epubTypesettingContext.m.get((int) j) == null) {
                hashSet = new HashSet();
                hashSet.addAll(O());
                epubTypesettingContext.m.set((int) j, hashSet);
            }
            long[] jArr = new long[((int) e.h().getPageCountOfChapter(j))];
            for (int i = 0; i < jArr.length; i++) {
                DkFlowPosition dkFlowPosition = new DkFlowPosition();
                long j2 = j;
                ai.a(e.h(), j2, (long) i, dkFlowPosition, new DkFlowPosition());
                jArr[i] = (((long) ((int) dkFlowPosition.mParaIndex)) << 32) | dkFlowPosition.mAtomIndex;
            }
            epubTypesettingContext.i[(int) j] = jArr;
            epubTypesettingContext.j[(int) j] = ChapterState.TYPESETTED;
            e(epubTypesettingContext);
        }
    }

    private long[] b(EpubTypesettingContext epubTypesettingContext, ch chVar) {
        DkFlowPosition dkFlowPosition;
        DkFlowPosition dkFlowPosition2;
        long j;
        long j2;
        e e = epubTypesettingContext.e();
        long j3 = chVar.a.b;
        long j4 = chVar.a.e;
        long j5 = chVar.a.f;
        long j6 = chVar.a.g;
        if (chVar.a.a == null || !chVar.a.a.b()) {
            if (!Float.isNaN(chVar.a.c)) {
                j4 = 0;
                j5 = 0;
                if (epubTypesettingContext.j[(int) j3] == ChapterState.TYPESETTED) {
                    dkFlowPosition = new DkFlowPosition();
                    dkFlowPosition2 = new DkFlowPosition();
                    j = e.h().getChapterOffsetRange(j3)[1];
                    for (int i = 0; ((long) i) < b(epubTypesettingContext, j3); i++) {
                        float f;
                        ai.a(e.h(), j3, (long) i, dkFlowPosition, dkFlowPosition2);
                        j4 = dkFlowPosition.mParaIndex;
                        j5 = dkFlowPosition.mAtomIndex;
                        long j7 = a(e.h(), dkFlowPosition, dkFlowPosition2)[1];
                        if (j == 0) {
                            f = 1.0f;
                        } else {
                            f = ((float) j7) / ((float) j);
                        }
                        if (Float.compare(Math.max(0.0f, Math.min(f, 1.0f)), chVar.a.c) >= 0) {
                            break;
                        }
                    }
                    j = j6;
                    j6 = j4;
                    j4 = j5;
                }
            } else if (!TextUtils.isEmpty(chVar.a.d)) {
                j4 = 0;
                j5 = 0;
                if (epubTypesettingContext.j[(int) j3] == ChapterState.TYPESETTED || a(epubTypesettingContext, j3) > 0) {
                    DkFlowPosition flowPosition = e.h().getFlowPosition(j3, chVar.a.d);
                    j = j6;
                    j6 = flowPosition.mParaIndex;
                    j4 = flowPosition.mAtomIndex;
                }
            } else if (!(i || chVar.a.a == null || chVar.a.a.j() == chVar.a.j())) {
                throw new AssertionError();
            }
            j = j6;
            j6 = j4;
            j4 = j5;
        } else {
            c k = chVar.a.a.k();
            j3 = k.g();
            j4 = k.h();
            j = j6 - chVar.a.a.g;
            j6 = j4;
            j4 = k.i();
        }
        if (j3 < 0) {
            if (i) {
                j5 = 0;
                j3 = Long.MIN_VALUE;
                j2 = 0;
            } else {
                throw new AssertionError();
            }
        } else if (j3 >= e.i()) {
            j5 = e.i() - 1;
            j3 = Long.MAX_VALUE;
            j2 = 0;
        } else {
            if (j6 != Long.MAX_VALUE && epubTypesettingContext.j[(int) j3] == ChapterState.TYPESETTED && e.h().getPageCountOfChapter(j3) > 0) {
                dkFlowPosition = new DkFlowPosition();
                dkFlowPosition2 = new DkFlowPosition();
                ai.a(e.h(), j3, e.h().getPageCountOfChapter(j3) - 1, dkFlowPosition, dkFlowPosition2);
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

    private long a(EpubTypesettingContext epubTypesettingContext, long j) {
        e e = epubTypesettingContext.e();
        ChapterState chapterState = epubTypesettingContext.j[(int) j];
        if (chapterState == ChapterState.NOT_TYPESETTED) {
            return 0;
        }
        if (chapterState == ChapterState.TYPESETTING) {
            return e.h().getPageCountOfChapter(j);
        }
        return (long) epubTypesettingContext.i[(int) j].length;
    }

    private boolean e(EpubTypesettingContext epubTypesettingContext) {
        e e = epubTypesettingContext.e();
        long b = epubTypesettingContext.b();
        int i = 0;
        for (long j = 0; j < e.i(); j++) {
            long b2 = b(epubTypesettingContext, j);
            if (b2 < 0) {
                return false;
            }
            i = (int) (b2 + ((long) i));
        }
        if (b == ((long) i)) {
            return false;
        }
        epubTypesettingContext.a((long) i);
        z();
        return true;
    }

    private long b(EpubTypesettingContext epubTypesettingContext, long j) {
        return epubTypesettingContext.d(j);
    }

    private EpubTypesettingContext L() {
        EpubTypesettingContext epubTypesettingContext;
        synchronized (this) {
            epubTypesettingContext = (EpubTypesettingContext) this.l.getLast();
            if (i || epubTypesettingContext != null) {
            } else {
                throw new AssertionError();
            }
        }
        return epubTypesettingContext;
    }

    private void M() {
        if (this.u.get() != null) {
            ((HashSet) this.u.get()).clear();
        }
        if (this.v.get() != null) {
            ((HashSet) this.v.get()).clear();
        }
    }

    private List N() {
        if (this.u.get() != null) {
            return Arrays.asList(((HashSet) this.u.get()).toArray(new av[0]));
        }
        return Collections.emptyList();
    }

    private List O() {
        if (this.v.get() != null) {
            return Arrays.asList(((HashSet) this.v.get()).toArray(new av[0]));
        }
        return Collections.emptyList();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.duokan.reader.domain.document.epub.e a(com.duokan.reader.domain.document.epub.ap r9) {
        /*
        r8 = this;
        r3 = 0;
        r2 = 1;
        r1 = 0;
        if (r9 != 0) goto L_0x000b;
    L_0x0005:
        r0 = 4;
        r8.d(r0);
        r0 = r3;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        r4 = r9.a;
        r5 = new com.duokan.reader.domain.document.epub.x;
        r5.<init>(r8);
        r4 = com.duokan.reader.domain.document.epub.ai.a(r4, r9, r5);
        r5 = r4.b;
        r5 = r5.isValid();
        if (r5 == 0) goto L_0x002c;
    L_0x001f:
        r0 = r4.b;
        r0 = r0.isValid();
        if (r0 != 0) goto L_0x0065;
    L_0x0027:
        r8.d(r2);
        r0 = r3;
        goto L_0x000a;
    L_0x002c:
        if (r0 == 0) goto L_0x0033;
    L_0x002e:
        r0 = 3;
        r8.d(r0);
        goto L_0x001f;
    L_0x0033:
        r0 = r9 instanceof com.duokan.reader.domain.document.epub.ag;
        if (r0 == 0) goto L_0x001f;
    L_0x0037:
        r0 = r9;
        r0 = (com.duokan.reader.domain.document.epub.ag) r0;
        r5 = r8.j;
        if (r5 == 0) goto L_0x001f;
    L_0x003e:
        r5 = r0.b;
        r5 = r5.length;
        if (r5 <= 0) goto L_0x001f;
    L_0x0043:
        r5 = r0.b;
        r5 = r5[r1];
        r5 = r5.length;
        if (r5 <= 0) goto L_0x001f;
    L_0x004a:
        r5 = r0.b;
        r5 = r5[r1];
        r5 = r5[r1];
        r6 = 100;
        if (r5 >= r6) goto L_0x001f;
    L_0x0054:
        r5 = r8.j;
        r5 = r5.a();
        if (r5 != 0) goto L_0x0061;
    L_0x005c:
        r0 = 2;
        r8.d(r0);
        goto L_0x001f;
    L_0x0061:
        r0.b = r5;
        r0 = r2;
        goto L_0x000c;
    L_0x0065:
        r0 = r4.b;
        r0 = r0.getChapterCount();
        r6 = 0;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 > 0) goto L_0x0076;
    L_0x0071:
        r8.d(r2);
        r0 = r3;
        goto L_0x000a;
    L_0x0076:
        r0 = new com.duokan.reader.domain.document.epub.ab;
        r0.<init>(r8, r9, r4);
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.s.a(com.duokan.reader.domain.document.epub.ap):com.duokan.reader.domain.document.epub.e");
    }

    private void P() {
        this.x.shutdown();
        do {
            try {
            } catch (Exception e) {
                if (!i) {
                    throw new AssertionError();
                }
            }
        } while (!this.x.awaitTermination(60, TimeUnit.SECONDS));
        this.g.a();
        this.k.g();
    }

    private static long[] a(DkeBook dkeBook, DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2) {
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

    private long a(ay ayVar) {
        a.c().b(ayVar.b());
        if (ayVar.k().b == L()) {
            return ayVar.k().a;
        }
        EpubTypesettingContext L = L();
        if (L.c()) {
            a.c().a(LogLevel.WARNING, "doc-epub", "dead lock detected!");
            return ayVar.k().a;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        cd a = L.a(ayVar, new y(this, countDownLatch));
        try {
            countDownLatch.await();
            return a.b;
        } catch (Exception e) {
            a.c().a(true);
            return -1;
        }
    }
}
