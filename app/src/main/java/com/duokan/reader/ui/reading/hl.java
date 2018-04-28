package com.duokan.reader.ui.reading;

import android.content.Intent;
import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.ag;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.ad.C0750g;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.AudioPlayerService;
import com.duokan.reader.domain.audio.C0774e;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ad;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.bookshelf.in;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.C0930b;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.C0936c;
import com.duokan.reader.domain.document.epub.C0938f;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.EpubResourceType;
import com.duokan.reader.domain.document.epub.af;
import com.duokan.reader.domain.document.epub.am;
import com.duokan.reader.domain.document.epub.as;
import com.duokan.reader.domain.document.epub.au;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.gc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;

public class hl extends aab implements af {
    /* renamed from: b */
    static final /* synthetic */ boolean f10330b = (!hl.class.desiredAssertionStatus());
    /* renamed from: J */
    private bb f10331J;
    /* renamed from: K */
    private Runnable f10332K;
    /* renamed from: L */
    private C0774e f10333L;
    /* renamed from: M */
    private final boolean f10334M;
    /* renamed from: N */
    private int f10335N;
    /* renamed from: O */
    private final HashSet<av> f10336O;
    /* renamed from: P */
    private final HashMap<av, Integer> f10337P;
    /* renamed from: Q */
    private final HashSet<av> f10338Q;
    /* renamed from: R */
    private final LinkedList<Future<?>> f10339R;
    /* renamed from: S */
    private final LinkedList<av> f10340S;
    /* renamed from: a */
    protected ag<Map<av, Integer>> f10341a;

    public hl(IFeature mFeature, C0800c c0800c, C0896a c0896a) {
        super(mFeature, c0800c, c0896a);
        this.f10331J = null;
        this.f10332K = null;
        this.f10333L = null;
        this.f10335N = 0;
        this.f10336O = new HashSet();
        this.f10337P = new HashMap();
        this.f10338Q = new HashSet();
        this.f10339R = new LinkedList();
        this.f10340S = new LinkedList();
        this.f10341a = null;
        this.r = this.f.m4242o();
        this.s = this.f.m4243p();
        this.f10334M = this.f.mo1018u();
    }

    protected boolean onBack() {
        return super.onBack();
    }

    /* renamed from: a */
    protected void mo1979a() {
        if (this.v == null && this.f.aI() && this.f.m4247s() == BookPackageType.EPUB_OPF) {
            this.e.getShowingDocPresenter().mo1984a(this.h.mo1248q());
        }
        ai.m3980a().m3887a((in) (ht) this.c);
        com.duokan.reader.domain.cloud.av.m5316a().m5333a((ht) this.c);
        super.mo1979a();
        this.f10331J = this.f.m4152E().m4820c();
        if (this.f.m4246r() == BookContent.AUDIO_TEXT) {
            runAfterActive(new hm(this));
        }
    }

    /* renamed from: b */
    protected void mo1981b() {
        ai.m3980a().m3910b((in) (ht) this.c);
        com.duokan.reader.domain.cloud.av.m5316a().m5335b((ht) this.c);
        super.mo1981b();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f10335N = 1;
        } else {
            this.f10335N = 0;
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        if (this.p && this.c.mo2155h()) {
            C1446a bl = this.c.bl();
            C1163a.m8627k().m8643a(this.f.m4156I(), this.n, this.f10335N, bl.m12753a(), bl.m12759b(), bl.m12761c(), bl.m12763d(), bl.m12765e(), C0750g.m3561a().m3591d(), C0750g.m3561a().m3589c(), C0750g.m3561a().m3593e(), !this.c.aa().mo1356z().isEmpty(), ReaderEnv.get().onMiui());
        }
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        Iterator it = this.f10339R.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f10339R.clear();
        this.f10340S.clear();
    }

    /* renamed from: a */
    protected void mo1980a(gc gcVar) {
        super.mo1980a(gcVar);
        fp fpVar = (fp) this.f;
        C0952s c0952s = (C0952s) this.h;
        if (!fpVar.mo1038k() && fpVar.m4166S() && !fpVar.aZ() && (c0952s.m7029F() instanceof com.duokan.reader.domain.document.epub.ag)) {
            ad z = fpVar.mo1020z();
            fpVar.mo1011a(new ad(z.f2723b, z.f2724c, "", 0));
            fpVar.aN();
        } else if (fpVar.mo1037j()) {
            C0936c c0936c = (C0936c) ((gs) gcVar).mo2331g().mo1198g();
            long D = c0952s.m7027D();
            long g = c0936c.m6780g() + 1;
            for (long j = g; j < Math.min(2 + g, D); j++) {
                av d = c0952s.m7064d(j);
                if (!(d == null || ((d.mo1075k() && !fpVar.aZ()) || this.f10340S.contains(d) || d.mo1073i()))) {
                    this.f10340S.add(d);
                }
            }
            if (this.f10341a == null && !this.f10340S.isEmpty()) {
                this.f10341a = new ho(this);
                this.f10341a.run(Collections.emptyMap());
            }
        }
    }

    /* renamed from: a */
    protected void mo2350a(gs gsVar, gs gsVar2) {
        super.mo2350a(gsVar, gsVar2);
        if (this.f.m4246r() == BookContent.AUDIO_TEXT && this.f10332K == null && this.c.aT() && AudioPlayer.m3613a().m3641b() && isActive()) {
            this.c.aU();
            this.f10332K = new hp(this);
            this.c.mo2103b(this.f10332K);
        }
        this.f10340S.clear();
    }

    /* renamed from: b */
    protected void mo2351b(gc gcVar) {
        if (this.A != null) {
            if (((C0936c) ((gs) gcVar).mo2331g().mo1198g()).m6780g() != ((C0936c) this.A.mo1198g()).m6780g()) {
                this.f10335N++;
            }
        }
        super.mo2351b(gcVar);
    }

    /* renamed from: c */
    protected sv mo2235c() {
        return new hz(getContext(), m12850o(), this.e);
    }

    /* renamed from: d */
    protected wy mo2236d() {
        return new iy(getContext(), this);
    }

    /* renamed from: e */
    protected si mo2237e() {
        return new ht();
    }

    /* renamed from: a */
    protected void mo2349a(C0923m c0923m) {
        super.mo2349a(c0923m);
        au auVar = (au) c0923m;
        if (ReaderUi.m10170m(getContext()) || m12850o().am()) {
            auVar.f4490q = getResources().getString(C0258j.reading__shared__pages_left);
            auVar.f4491r = true;
        }
    }

    /* renamed from: a */
    protected void mo2348a(C0917k c0917k) {
        super.mo2348a(c0917k);
        am amVar = (am) c0917k;
        if (this.c.ai() != null) {
            amVar.f4487l.put(Long.valueOf(0), Integer.valueOf(1));
        }
    }

    /* renamed from: a */
    protected ak mo2234a(C0901g c0901g) {
        return this.h.mo1235e(c0901g.mo1204g());
    }

    /* renamed from: f */
    protected C0917k mo2238f() {
        C0917k amVar = new am();
        mo2348a(amVar);
        return amVar;
    }

    /* renamed from: k */
    protected C0923m mo2239k() {
        C0923m auVar = new au();
        mo2349a(auVar);
        return auVar;
    }

    /* renamed from: a */
    protected float mo2233a(ak akVar) {
        if (f10330b || akVar.m5777b()) {
            float j;
            C0952s c0952s = (C0952s) this.h;
            if (this.f.m4247s() == BookPackageType.EPUB_OPF) {
                j = c0952s.m7080j(akVar) * 100.0f;
            } else if (c0952s.mo1234e() >= 0) {
                j = (((float) (c0952s.mo1223b(akVar) + 1)) / ((float) c0952s.mo1234e())) * 100.0f;
            } else {
                j = c0952s.m7080j(akVar) * 100.0f;
            }
            return Math.max(0.0f, Math.min(j, 100.0f));
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    protected void mo2240l() {
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else if (this.c.aj() && this.d.m12465a() == ReadingOrientation.LANDSCAPE) {
            ReaderUi.m10153a(getActivity(), 11);
        } else {
            getActivity().setRequestedOrientation(1);
        }
    }

    /* renamed from: c */
    public void mo1052c(C0903n c0903n) {
        super.mo1052c(c0903n);
        if (this.f10333L != null) {
            AudioPlayer.m3613a().m3640b(this.f10333L);
        }
        if (this.f.m4246r() == BookContent.AUDIO_TEXT) {
            AudioPlayer.m3613a().m3645f();
            getContext().stopService(new Intent(getContext(), AudioPlayerService.class));
        }
        if (this.f.aI()) {
            this.f.aj();
        }
    }

    protected boolean j_() {
        if (super.j_()) {
            return true;
        }
        if (this.c.mo2007X() == null || this.f10338Q.isEmpty()) {
            return false;
        }
        boolean z;
        View[] pageViews = this.e.getShowingPagesView().getPageViews();
        if (this.f10338Q.isEmpty()) {
            z = false;
        } else {
            Iterator it = this.f10338Q.iterator();
            z = false;
            while (it.hasNext()) {
                av avVar = (av) it.next();
                EpubResourceType epubResourceType = avVar.mo1071g().f4493b;
                boolean z2 = z;
                for (View view : pageViews) {
                    gx gxVar = (gx) view;
                    if (((as) gxVar.getPageDrawable()).mo1374P().contains(avVar)) {
                        this.e.m13656f();
                        if (epubResourceType == EpubResourceType.TEXT || epubResourceType == EpubResourceType.FONT || epubResourceType == EpubResourceType.STRUCT) {
                            z2 = true;
                        } else {
                            gxVar.setRenderParams(this.h.mo1246l());
                        }
                    }
                }
                z = z2;
            }
        }
        this.f10338Q.clear();
        if (!z) {
            return false;
        }
        this.h.mo1219a(null);
        this.e.m13659i();
        return true;
    }

    /* renamed from: a */
    private void m14332a(as asVar) {
        if (this.c.mo1992G().m4247s() == BookPackageType.EPUB_OPF) {
            boolean d = C0559f.m2476b().m2485d();
            List<av> Q = asVar.mo1375Q();
            List linkedList = new LinkedList();
            for (av avVar : Q) {
                EpubResourceType epubResourceType = avVar.mo1071g().f4493b;
                if (!(this.f10336O.contains(avVar) || this.f10338Q.contains(avVar) || this.f10337P.containsKey(avVar))) {
                    if (epubResourceType != EpubResourceType.IMAGE && epubResourceType != EpubResourceType.MEDIA) {
                        linkedList.add(avVar);
                    } else if (d) {
                        if (!avVar.mo1074j()) {
                            linkedList.add(avVar);
                        }
                    } else if (!avVar.mo1074j() && avVar.mo1076l() == null) {
                        linkedList.add(avVar);
                    } else if (avVar.mo1074j()) {
                        linkedList.add(avVar);
                    }
                }
            }
            m14337b(linkedList, null);
        }
    }

    /* renamed from: b */
    private void m14337b(List<av> list, ag<Map<av, Integer>> agVar) {
        fp fpVar = (fp) ((hy) this.c).mo1992G();
        ListIterator listIterator = this.f10339R.listIterator();
        while (listIterator.hasNext()) {
            if (((Future) listIterator.next()).isDone()) {
                listIterator.remove();
            }
        }
        this.f10339R.add(fpVar.m4489b((List) list, new hq(this, agVar)));
    }

    /* renamed from: C */
    private C0952s m14327C() {
        return (C0952s) this.h;
    }

    /* renamed from: d */
    private C0930b[] m14340d(int i) {
        long D;
        List arrayList = new ArrayList();
        C0901g[] b = this.h.mo1240h().mo1268b();
        long j = -1;
        if (i >= 0 && i < b.length) {
            j = ((C0938f) b[i]).mo1432l();
            if (i == 0) {
                j = 0;
            }
        }
        int i2 = i + 1;
        if (i2 < 0 || i2 >= b.length) {
            D = ((C0952s) this.h).m7027D();
        } else {
            long l;
            C0938f c0938f = (C0938f) b[i2];
            if (c0938f.mo1208k()) {
                l = c0938f.mo1432l();
            } else {
                l = ((C0952s) this.h).m7027D();
            }
            D = l;
        }
        if (j >= 0 && D >= 0) {
            while (j < D) {
                C0930b[] c = ((C0952s) this.c.getDocument()).m7060c(j);
                if (c != null && c.length > 0) {
                    for (Object add : c) {
                        arrayList.add(add);
                    }
                }
                j = 1 + j;
            }
        }
        return (C0930b[]) arrayList.toArray(new C0930b[0]);
    }
}
