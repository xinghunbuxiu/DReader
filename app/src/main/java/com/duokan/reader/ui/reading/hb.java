package com.duokan.reader.ui.reading;

import android.content.Intent;
import android.view.View;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.ag;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.AudioPlayerService;
import com.duokan.reader.domain.audio.e;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.ad;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.cloud.bd;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.EpubResourceType;
import com.duokan.reader.domain.document.epub.af;
import com.duokan.reader.domain.document.epub.am;
import com.duokan.reader.domain.document.epub.as;
import com.duokan.reader.domain.document.epub.au;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.gi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Future;

public class hb extends zo implements af {
    static final /* synthetic */ boolean b = (!hb.class.desiredAssertionStatus());
    private bb J;
    private Runnable K;
    private e L;
    private final boolean M;
    private int N;
    private final HashSet O;
    private final HashMap P;
    private final HashSet Q;
    private final LinkedList R;
    private final LinkedList S;
    protected ag a;

    public hb(IFeature featrue, c cVar, Document_a aVar) {
        super(featrue, cVar, aVar);
        this.J = null;
        this.K = null;
        this.L = null;
        this.N = 0;
        this.O = new HashSet();
        this.P = new HashMap();
        this.Q = new HashSet();
        this.R = new LinkedList();
        this.S = new LinkedList();
        this.a = null;
        this.r = this.f.o();
        this.s = this.f.p();
        this.M = this.f.u();
    }

    protected boolean onBack() {
        return super.onBack();
    }

    protected void a() {
        if (this.v == null && this.f.aG() && this.f.s() == BookPackageType.EPUB_OPF) {
            this.e.getShowingDocPresenter().a(this.h.q());
        }
        ai.a().a((it) (hj) this.c);
        bd.a().a((hj) this.c);
        super.a();
        this.J = this.f.D().c();
        if (this.f.r() == BookContent.AUDIO_TEXT) {
            runAfterActive(new hc(this));
        }
    }

    protected void b() {
        ai.a().b((it) (hj) this.c);
        bd.a().b((hj) this.c);
        super.b();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.N = 1;
        } else {
            this.N = 0;
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        if (this.p && this.c.h()) {
            Document_a bk = this.c.bk();
            com.duokan.reader.domain.statistics.a.k().a(this.f.H(), this.n, this.N, bk.a(), bk.b(), bk.c(), bk.d(), bk.e(), g.a().d(), g.a().c(), g.a().e(), !this.c.aa().z().isEmpty(), ReaderEnv.get().onMiui());
        }
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        Iterator it = this.R.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.R.clear();
        this.S.clear();
    }

    protected void a(gi giVar) {
        super.a(giVar);
        fv fvVar = (fv) this.f;
        s sVar = (s) this.h;
        if (!fvVar.k() && fvVar.Q() && !fvVar.aX() && (sVar.F() instanceof com.duokan.reader.domain.document.epub.ag)) {
            ad y = fvVar.y();
            fvVar.a(new ad(y.b, y.c, "", 0));
            fvVar.aL();
        } else if (fvVar.j()) {
            com.duokan.reader.domain.document.epub.c cVar = (com.duokan.reader.domain.document.epub.c) ((gn) giVar).g().g();
            long D = sVar.D();
            long g = cVar.g() + 1;
            for (long j = g; j < Math.min(2 + g, D); j++) {
                av d = sVar.d(j);
                if (!(d == null || ((d.k() && !fvVar.aX()) || this.S.contains(d) || d.i()))) {
                    this.S.add(d);
                }
            }
            if (this.a == null && !this.S.isEmpty()) {
                this.a = new he(this);
                this.a.a(Collections.emptyMap());
            }
        }
    }

    protected void a(gn gnVar, gn gnVar2) {
        super.a(gnVar, gnVar2);
        if (this.f.r() == BookContent.AUDIO_TEXT && this.K == null && this.c.aT() && AudioPlayer.a().b() && isActive()) {
            this.c.aU();
            this.K = new hf(this);
            this.c.b(this.K);
        }
        this.S.clear();
    }

    protected void b(gi giVar) {
        if (this.A != null) {
            if (((com.duokan.reader.domain.document.epub.c) ((gn) giVar).g().g()).g() != ((com.duokan.reader.domain.document.epub.c) this.A.g()).g()) {
                this.N++;
            }
        }
        super.b(giVar);
    }

    protected si c() {
        return new hp(getContext(), o(), this.e);
    }

    protected wl d() {
        return new io(getContext(), this);
    }

    protected rx e() {
        return new hj();
    }

    protected void a(m mVar) {
        super.a(mVar);
        au auVar = (au) mVar;
        if (ReaderUi.m(getContext()) || o().am()) {
            auVar.q = getResources().getString(j.reading__shared__pages_left);
            auVar.r = true;
        }
    }

    protected void a(k kVar) {
        super.a(kVar);
        am amVar = (am) kVar;
        if (this.c.ai() != null) {
            amVar.l.put(Long.valueOf(0), Integer.valueOf(1));
        }
    }

    protected ak a(com.duokan.reader.domain.document.g gVar) {
        return this.h.e(gVar.g());
    }

    protected k f() {
        k amVar = new am();
        a(amVar);
        return amVar;
    }

    protected m k() {
        m auVar = new au();
        a(auVar);
        return auVar;
    }

    protected float a(ak akVar) {
        if (b || akVar.b()) {
            float j;
            s sVar = (s) this.h;
            if (this.f.s() == BookPackageType.EPUB_OPF) {
                j = sVar.j(akVar) * 100.0f;
            } else if (sVar.e() >= 0) {
                j = (((float) (sVar.b(akVar) + 1)) / ((float) sVar.e())) * 100.0f;
            } else {
                j = sVar.j(akVar) * 100.0f;
            }
            return Math.max(0.0f, Math.min(j, 100.0f));
        }
        throw new AssertionError();
    }

    protected void l() {
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else if (this.c.aj() && this.d.a() == ReadingOrientation.LANDSCAPE) {
            ReaderUi.a(getActivity(), 11);
        } else {
            getActivity().setRequestedOrientation(1);
        }
    }

    public void c(n nVar) {
        super.c(nVar);
        if (this.L != null) {
            AudioPlayer.a().b(this.L);
        }
        if (this.f.r() == BookContent.AUDIO_TEXT) {
            AudioPlayer.a().f();
            getContext().stopService(new Intent(getContext(), AudioPlayerService.class));
        }
        if (this.f.aG()) {
            this.f.ah();
        }
    }

    protected boolean i_() {
        if (super.i_()) {
            return true;
        }
        if (this.c.X() == null || this.Q.isEmpty()) {
            return false;
        }
        boolean z;
        View[] pageViews = this.e.getShowingPagesView().getPageViews();
        if (this.Q.isEmpty()) {
            z = false;
        } else {
            Iterator it = this.Q.iterator();
            z = false;
            while (it.hasNext()) {
                av avVar = (av) it.next();
                EpubResourceType epubResourceType = avVar.g().b;
                boolean z2 = z;
                for (View view : pageViews) {
                    gs gsVar = (gs) view;
                    if (((as) gsVar.getPageDrawable()).Q().contains(avVar)) {
                        this.e.f();
                        if (epubResourceType == EpubResourceType.TEXT || epubResourceType == EpubResourceType.FONT || epubResourceType == EpubResourceType.STRUCT) {
                            z2 = true;
                        } else {
                            gsVar.setRenderParams(this.h.l());
                        }
                    }
                }
                z = z2;
            }
        }
        this.Q.clear();
        if (!z) {
            return false;
        }
        this.h.a(null);
        this.e.i();
        return true;
    }

    private void a(as asVar) {
        if (this.c.G().s() == BookPackageType.EPUB_OPF) {
            boolean d = f.b().d();
            List<av> R = asVar.R();
            List linkedList = new LinkedList();
            for (av avVar : R) {
                EpubResourceType epubResourceType = avVar.g().b;
                if (!(this.O.contains(avVar) || this.Q.contains(avVar) || this.P.containsKey(avVar))) {
                    if (epubResourceType != EpubResourceType.IMAGE && epubResourceType != EpubResourceType.MEDIA) {
                        linkedList.add(avVar);
                    } else if (d) {
                        if (!avVar.j()) {
                            linkedList.add(avVar);
                        }
                    } else if (!avVar.j() && avVar.l() == null) {
                        linkedList.add(avVar);
                    } else if (avVar.j()) {
                        linkedList.add(avVar);
                    }
                }
            }
            b(linkedList, null);
        }
    }

    private void b(List list, ag agVar) {
        fv fvVar = (fv) ((ho) this.c).G();
        ListIterator listIterator = this.R.listIterator();
        while (listIterator.hasNext()) {
            if (((Future) listIterator.next()).isDone()) {
                listIterator.remove();
            }
        }
        this.R.add(fvVar.b(list, new hg(this, agVar)));
    }

    private s C() {
        return (s) this.h;
    }

    private b[] d(int i) {
        long D;
        List arrayList = new ArrayList();
        com.duokan.reader.domain.document.g[] b = this.h.h().b();
        long j = -1;
        if (i >= 0 && i < b.length) {
            j = ((com.duokan.reader.domain.document.epub.f) b[i]).l();
            if (i == 0) {
                j = 0;
            }
        }
        int i2 = i + 1;
        if (i2 < 0 || i2 >= b.length) {
            D = ((s) this.h).D();
        } else {
            long l;
            com.duokan.reader.domain.document.epub.f fVar = (com.duokan.reader.domain.document.epub.f) b[i2];
            if (fVar.k()) {
                l = fVar.l();
            } else {
                l = ((s) this.h).D();
            }
            D = l;
        }
        if (j >= 0 && D >= 0) {
            while (j < D) {
                b[] c = ((s) this.c.getDocument()).c(j);
                if (c != null && c.length > 0) {
                    for (Object add : c) {
                        arrayList.add(add);
                    }
                }
                j = 1 + j;
            }
        }
        return (b[]) arrayList.toArray(new b[0]);
    }
}
