package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.gc;
import com.duokan.reader.ui.general.web.StorePageController;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class aab extends qr {
    /* renamed from: J */
    private boolean f9303J = false;
    /* renamed from: K */
    private final LinkedList<String> f9304K = new LinkedList();
    /* renamed from: L */
    private final HashMap<String, Integer> f9305L = new HashMap();
    /* renamed from: M */
    private final HashSet<String> f9306M = new HashSet();
    /* renamed from: N */
    private final af<Boolean> f9307N = new af();
    /* renamed from: O */
    private boolean f9308O = false;
    /* renamed from: P */
    private final LinkedList<String> f9309P = new LinkedList();
    /* renamed from: Q */
    private final HashMap<String, Integer> f9310Q = new HashMap();
    /* renamed from: a */
    private final HashMap<String, af<Integer>> f9311a = new HashMap();
    /* renamed from: b */
    private boolean f9312b = false;

    public aab(IFeature mFeature, C0800c c0800c, C0896a c0896a) {
        super(mFeature, c0800c, c0896a);
    }

    /* renamed from: a */
    protected void mo1979a() {
        if (this.f.mo1038k()) {
            DkUserPurchasedFictionsManager.m5072a().m5096a((aaw) this.c);
        }
        super.mo1979a();
    }

    /* renamed from: b */
    protected void mo1981b() {
        if (this.f.mo1038k()) {
            DkUserPurchasedFictionsManager.m5072a().m5104b((aaw) this.c);
        }
        super.mo1981b();
    }

    /* renamed from: a */
    protected void mo1980a(gc gcVar) {
        super.mo1980a(gcVar);
        if (!j_()) {
            if (this.f.mo1038k()) {
                abd abd = (abd) this.c;
                long j = abd.mo2358a(((gs) gcVar).mo2331g())[0];
                m12863D();
                if (abd.mo2191c(j)) {
                    m12892a(j, null, null);
                } else if (abd.mo2191c(j + 1)) {
                    m12892a(j + 1, null, null);
                }
            }
            try {
                if (this.c.mo2004U() != PageAnimationMode.VSCROLL) {
                    if (gcVar.mo2328d() instanceof gx) {
                        ((gx) gcVar.mo2328d()).m14298d();
                    }
                    if (!this.y.m5817f() && this.h.mo1243i(this.y)) {
                        if (this.c.bo()) {
                            C1163a.m8627k().m8655c("ending_page_recommendation_v3", "exposure", "ending_page_last_page_shown");
                        } else {
                            C1163a.m8627k().m8655c("ending_page_recommendation_v3", "exposure", "unavailable_page_last_page_shown");
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public void onConnectivityChanged(C0559f c0559f) {
        super.onConnectivityChanged(c0559f);
        if (this.f.mo1038k() && c0559f.m2485d()) {
            this.f9307N.m863c();
        }
    }

    /* renamed from: a */
    protected void m12892a(long j, Runnable runnable, Runnable runnable2) {
        abd abd = (abd) this.c;
        if (abd.mo2197j(j).m862b(Boolean.valueOf(true))) {
            UThread.post(runnable);
        } else if (abd.ah() && abd.mo2196i(j) == null) {
            String I = this.f.m4156I();
            String ay = this.f.ay();
            String b = abd.mo2359b(j);
            String a = abd.mo2356a(j);
            short g = abd.mo2194g(j);
            this.f9311a.put(a, new af());
            UThread.post(new aac(this, abd, j, runnable, ay, I, b, a, g, runnable2));
        } else {
            UThread.post(runnable2);
        }
    }

    /* renamed from: C */
    private void m12862C() {
        Iterator it = this.f9311a.keySet().iterator();
        while (it.hasNext()) {
            af afVar = (af) this.f9311a.get((String) it.next());
            C0328a.m757c().m764b(afVar != null);
            if (afVar.m861b() && ((Integer) afVar.m858a()).intValue() != 0) {
                it.remove();
            }
        }
    }

    /* renamed from: D */
    private void m12863D() {
        ah.m865a(new aaf(this));
    }

    /* renamed from: E */
    private void m12864E() {
        this.c.mo2103b(new aag(this, (abd) this.c, (ee) this.f));
    }

    /* renamed from: F */
    private void m12865F() {
        if (!this.f9303J) {
            this.f9303J = true;
            m12866G();
        }
    }

    /* renamed from: G */
    private void m12866G() {
        abd abd = (abd) this.c;
        List linkedList = new LinkedList();
        ag aan = new aan(this);
        for (View view : this.e.getShowingPagesView().getVisiblePageViews()) {
            List<String> d;
            as pageDrawable = ((gx) view).getPageDrawable();
            if (pageDrawable != null) {
                d = abd.mo2193d(pageDrawable);
                if (d.isEmpty()) {
                    continue;
                } else {
                    for (String str : d) {
                        if (!(this.f9304K.contains(str) || this.f9305L.containsKey(str) || this.f9306M.contains(str))) {
                            linkedList.add(str);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        m12873b(linkedList, aan);
                        return;
                    }
                }
            }
        }
        for (View view2 : this.e.getShowingPagesView().getPageViews()) {
            pageDrawable = ((gx) view2).getPageDrawable();
            if (pageDrawable != null) {
                d = abd.mo2193d(pageDrawable);
                if (d.isEmpty()) {
                    continue;
                } else {
                    for (String str2 : d) {
                        if (!(this.f9304K.contains(str2) || this.f9305L.containsKey(str2) || this.f9306M.contains(str2))) {
                            linkedList.add(str2);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        m12873b(linkedList, aan);
                        return;
                    }
                }
            }
        }
        this.f9303J = false;
    }

    /* renamed from: b */
    private final void m12873b(List<String> list, ag<Map<String, Integer>> agVar) {
        C0328a.m757c().m764b(UThread.isCurrentThread());
        abd abd = (abd) this.c;
        ee eeVar = (ee) this.c.mo1992G();
        this.f9304K.addAll(list);
        eeVar.mo1028a((List) list, new aao(this, list, eeVar, abd, agVar));
    }

    /* renamed from: H */
    private void m12867H() {
        if (this.f.mo1038k() && !this.f.al()) {
            as aa = this.c.aa();
            if (aa.mo1284G()) {
                long[] a = ((bm) this.c).mo2358a(aa.mo1332l());
                if (a.length >= 1) {
                    ActivatedController storePageController = new StorePageController(AppContext.getAppContext(getContext()));
                    storePageController.loadUrl(C0641o.m2934i().m2965c(this.c.mo1992G().m4156I()) + "?currChapterIndex=" + a[0]);
                    ((ReaderFeature) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class)).pushPageSmoothly(storePageController, null);
                }
            }
        }
    }

    protected boolean j_() {
        if (this.c.mo2007X() == null || this.f9306M.isEmpty()) {
            return false;
        }
        boolean z;
        View[] pageViews = this.e.getShowingPagesView().getPageViews();
        if (this.f9306M.isEmpty()) {
            z = false;
        } else {
            Iterator it = this.f9306M.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                for (View view : pageViews) {
                    if (((abd) this.c).mo2189c(((gx) view).getPageDrawable()).contains(str)) {
                        this.e.m13656f();
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
        this.f9306M.clear();
        if (!z) {
            return false;
        }
        this.h.mo1219a(null);
        this.e.m13659i();
        return true;
    }

    /* renamed from: I */
    private void m12868I() {
        if (!this.f9308O) {
            this.f9308O = true;
            m12869J();
        }
    }

    /* renamed from: J */
    private void m12869J() {
        List linkedList = new LinkedList();
        ag aar = new aar(this);
        for (View view : this.e.getShowingPagesView().getVisiblePageViews()) {
            List<String> D;
            as pageDrawable = ((gx) view).getPageDrawable();
            if (pageDrawable != null) {
                D = pageDrawable.mo1456D();
                if (D.isEmpty()) {
                    continue;
                } else {
                    for (String str : D) {
                        if (!(this.f9309P.contains(str) || this.f9310Q.containsKey(str))) {
                            linkedList.add(str);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        m12895a(linkedList, aar);
                        return;
                    }
                }
            }
        }
        for (View view2 : this.e.getShowingPagesView().getPageViews()) {
            pageDrawable = ((gx) view2).getPageDrawable();
            if (pageDrawable != null) {
                D = pageDrawable.mo1456D();
                if (D.isEmpty()) {
                    continue;
                } else {
                    for (String str2 : D) {
                        if (!(this.f9309P.contains(str2) || this.f9310Q.containsKey(str2))) {
                            linkedList.add(str2);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        m12895a(linkedList, aar);
                        return;
                    }
                }
            }
        }
        this.f9308O = false;
    }

    /* renamed from: a */
    protected void m12895a(List<String> list, ag<Map<String, Integer>> agVar) {
        C0328a.m757c().m764b(UThread.isCurrentThread());
        Runnable aas = new aas(this, list, (ee) this.f, agVar);
        if (this.f9307N.m861b() || !C0559f.m2476b().m2484c()) {
            aas.run();
        } else {
            mo2513a(new aau(this, aas), new aav(this, aas));
        }
    }

    /* renamed from: a */
    protected void mo2513a(Runnable runnable, Runnable runnable2) {
        runnable.run();
    }

    /* renamed from: B */
    protected int mo1978B() {
        return 5;
    }
}
