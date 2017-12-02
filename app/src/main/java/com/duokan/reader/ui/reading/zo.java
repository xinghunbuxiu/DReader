package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.t;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.gi;
import com.duokan.reader.ui.general.web.StorePageController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class zo extends qh {
    private boolean J = false;
    private final LinkedList K = new LinkedList();
    private final HashMap L = new HashMap();
    private final HashSet M = new HashSet();
    private final af N = new af();
    private boolean O = false;
    private final LinkedList P = new LinkedList();
    private final HashMap Q = new HashMap();
    private final HashMap a = new HashMap();
    private boolean b = false;

    public zo(y yVar, c cVar, a aVar) {
        super(yVar, cVar, aVar);
    }

    protected void a() {
        if (this.f.k()) {
            DkUserPurchasedFictionsManager.a().a((aaj) this.c);
        }
        super.a();
    }

    protected void b() {
        if (this.f.k()) {
            DkUserPurchasedFictionsManager.a().b((aaj) this.c);
        }
        super.b();
    }

    protected void a(gi giVar) {
        super.a(giVar);
        if (!i_()) {
            if (this.f.k()) {
                aaq com_duokan_reader_ui_reading_aaq = (aaq) this.c;
                long j = com_duokan_reader_ui_reading_aaq.a(((gn) giVar).g())[0];
                D();
                if (com_duokan_reader_ui_reading_aaq.c(j)) {
                    a(j, null, null);
                } else if (com_duokan_reader_ui_reading_aaq.c(j + 1)) {
                    a(j + 1, null, null);
                }
            }
            try {
                if (this.c.U() != PageAnimationMode.VSCROLL) {
                    if (giVar.d() instanceof gs) {
                        ((gs) giVar.d()).d();
                    }
                    if (!this.y.f() && this.h.i(this.y)) {
                        if (this.c.bn()) {
                            com.duokan.reader.domain.statistics.a.k().b("ending_page_recommendation_v3", "exposure", "ending_page_last_page_shown");
                        } else {
                            com.duokan.reader.domain.statistics.a.k().b("ending_page_recommendation_v3", "exposure", "unavailable_page_last_page_shown");
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public void onConnectivityChanged(f fVar) {
        super.onConnectivityChanged(fVar);
        if (this.f.k() && fVar.d()) {
            this.N.c();
        }
    }

    protected void a(long j, Runnable runnable, Runnable runnable2) {
        aaq com_duokan_reader_ui_reading_aaq = (aaq) this.c;
        if (com_duokan_reader_ui_reading_aaq.j(j).b(Boolean.valueOf(true))) {
            t.b(runnable);
        } else if (com_duokan_reader_ui_reading_aaq.ah() && com_duokan_reader_ui_reading_aaq.i(j) == null) {
            String H = this.f.H();
            String aw = this.f.aw();
            String b = com_duokan_reader_ui_reading_aaq.b(j);
            String a = com_duokan_reader_ui_reading_aaq.a(j);
            short g = com_duokan_reader_ui_reading_aaq.g(j);
            this.a.put(a, new af());
            t.b(new zp(this, com_duokan_reader_ui_reading_aaq, j, runnable, aw, H, b, a, g, runnable2));
        } else {
            t.b(runnable2);
        }
    }

    private void C() {
        Iterator it = this.a.keySet().iterator();
        while (it.hasNext()) {
            af afVar = (af) this.a.get((String) it.next());
            com.duokan.core.diagnostic.a.c().b(afVar != null);
            if (afVar.b() && ((Integer) afVar.a()).intValue() != 0) {
                it.remove();
            }
        }
    }

    private void D() {
        ah.a(new zs(this));
    }

    private void E() {
        this.c.b(new zt(this, (aaq) this.c, (ej) this.f));
    }

    private void F() {
        if (!this.J) {
            this.J = true;
            G();
        }
    }

    private void G() {
        aaq com_duokan_reader_ui_reading_aaq = (aaq) this.c;
        List linkedList = new LinkedList();
        ag com_duokan_reader_ui_reading_aaa = new aaa(this);
        for (View view : this.e.getShowingPagesView().getVisiblePageViews()) {
            List<String> d;
            as pageDrawable = ((gs) view).getPageDrawable();
            if (pageDrawable != null) {
                d = com_duokan_reader_ui_reading_aaq.d(pageDrawable);
                if (d.isEmpty()) {
                    continue;
                } else {
                    for (String str : d) {
                        if (!(this.K.contains(str) || this.L.containsKey(str) || this.M.contains(str))) {
                            linkedList.add(str);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        b(linkedList, com_duokan_reader_ui_reading_aaa);
                        return;
                    }
                }
            }
        }
        for (View view2 : this.e.getShowingPagesView().getPageViews()) {
            pageDrawable = ((gs) view2).getPageDrawable();
            if (pageDrawable != null) {
                d = com_duokan_reader_ui_reading_aaq.d(pageDrawable);
                if (d.isEmpty()) {
                    continue;
                } else {
                    for (String str2 : d) {
                        if (!(this.K.contains(str2) || this.L.containsKey(str2) || this.M.contains(str2))) {
                            linkedList.add(str2);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        b(linkedList, com_duokan_reader_ui_reading_aaa);
                        return;
                    }
                }
            }
        }
        this.J = false;
    }

    private final void b(List list, ag agVar) {
        com.duokan.core.diagnostic.a.c().b(t.a());
        aaq com_duokan_reader_ui_reading_aaq = (aaq) this.c;
        ej ejVar = (ej) this.c.G();
        this.K.addAll(list);
        ejVar.a(list, new aab(this, list, ejVar, com_duokan_reader_ui_reading_aaq, agVar));
    }

    private void H() {
        if (this.f.k() && !this.f.aj()) {
            as aa = this.c.aa();
            if (aa.G()) {
                long[] a = ((bm) this.c).a(aa.l());
                if (a.length >= 1) {
                    e storePageController = new StorePageController(x.a(getContext()));
                    storePageController.loadUrl(p.i().c(this.c.G().H()) + "?currChapterIndex=" + a[0]);
                    ((ReaderFeature) x.a(getContext()).queryFeature(ReaderFeature.class)).pushPageSmoothly(storePageController, null);
                }
            }
        }
    }

    protected boolean i_() {
        if (this.c.X() == null || this.M.isEmpty()) {
            return false;
        }
        boolean z;
        View[] pageViews = this.e.getShowingPagesView().getPageViews();
        if (this.M.isEmpty()) {
            z = false;
        } else {
            Iterator it = this.M.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                for (View view : pageViews) {
                    if (((aaq) this.c).c(((gs) view).getPageDrawable()).contains(str)) {
                        this.e.f();
                        z = true;
                        break;
                    }
                }
                z = z2;
                if (z) {
                    break;
                }
                z2 = z;
            }
            z = z2;
        }
        this.M.clear();
        if (!z) {
            return false;
        }
        this.h.a(null);
        this.e.i();
        return true;
    }

    private void I() {
        if (!this.O) {
            this.O = true;
            J();
        }
    }

    private void J() {
        List linkedList = new LinkedList();
        ag com_duokan_reader_ui_reading_aae = new aae(this);
        for (View view : this.e.getShowingPagesView().getVisiblePageViews()) {
            List<String> D;
            as pageDrawable = ((gs) view).getPageDrawable();
            if (pageDrawable != null) {
                D = pageDrawable.D();
                if (D.isEmpty()) {
                    continue;
                } else {
                    for (String str : D) {
                        if (!(this.P.contains(str) || this.Q.containsKey(str))) {
                            linkedList.add(str);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        a(linkedList, com_duokan_reader_ui_reading_aae);
                        return;
                    }
                }
            }
        }
        for (View view2 : this.e.getShowingPagesView().getPageViews()) {
            pageDrawable = ((gs) view2).getPageDrawable();
            if (pageDrawable != null) {
                D = pageDrawable.D();
                if (D.isEmpty()) {
                    continue;
                } else {
                    for (String str2 : D) {
                        if (!(this.P.contains(str2) || this.Q.containsKey(str2))) {
                            linkedList.add(str2);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        a(linkedList, com_duokan_reader_ui_reading_aae);
                        return;
                    }
                }
            }
        }
        this.O = false;
    }

    protected void a(List list, ag agVar) {
        com.duokan.core.diagnostic.a.c().b(t.a());
        Runnable com_duokan_reader_ui_reading_aaf = new aaf(this, list, (ej) this.f, agVar);
        if (this.N.b() || !f.b().c()) {
            com_duokan_reader_ui_reading_aaf.run();
        } else {
            a(new aah(this, com_duokan_reader_ui_reading_aaf), new aai(this, com_duokan_reader_ui_reading_aaf));
        }
    }

    protected void a(Runnable runnable, Runnable runnable2) {
        runnable.run();
    }

    protected int B() {
        return 5;
    }
}
