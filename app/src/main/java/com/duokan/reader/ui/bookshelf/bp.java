package com.duokan.reader.ui.bookshelf;

import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.FeatureListening;
import com.duokan.core.app.ab;
import com.duokan.core.sys.af;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0630c;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ek;
import com.duokan.reader.ui.surfing.al;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.HttpStatus;

public class bp extends ek implements ab, SystemUiConditioner, cz {
    /* renamed from: a */
    private final BookshelfPrefs f6190a = new BookshelfPrefs();
    /* renamed from: b */
    private final C1285c f6191b;
    /* renamed from: c */
    private final cw f6192c = new cw(getContext(), getActivity());
    /* renamed from: d */
    private final HashSet<an> f6193d = new HashSet();
    /* renamed from: e */
    private final CopyOnWriteArrayList<db> f6194e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private final CopyOnWriteArrayList<da> f6195f = new CopyOnWriteArrayList();
    /* renamed from: g */
    private final al f6196g = ((al) getContext().queryFeature(al.class));
    /* renamed from: h */
    private eb f6197h = null;
    /* renamed from: i */
    private eb f6198i = null;
    /* renamed from: j */
    private ao f6199j = null;
    /* renamed from: k */
    private boolean f6200k = false;
    /* renamed from: l */
    private boolean f6201l = false;
    /* renamed from: m */
    private final ce f6202m = new ce();
    /* renamed from: n */
    private Runnable f6203n = null;

    public bp(IFeature mFeature) {
        super(mFeature);
        getContext().addFeatureListener(this.f6192c);
        getContext().addFeatureListener((FeatureListening) this);
        this.f6191b = new C1285c(getContext());
        m9216a(this.f6191b.getContentView());
        addSubController(this.f6191b);
        activate(this.f6191b);
        this.f6196g.mo2547a(this.f6202m);
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        if (isActive()) {
            afVar.mo975a(Boolean.valueOf(true));
        }
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
    }

    /* renamed from: a */
    public void mo1649a(an... anVarArr) {
        List asList = Arrays.asList(anVarArr);
        if (this.f6193d.addAll(asList)) {
            m9276b(asList);
        }
    }

    /* renamed from: b */
    public void mo1655b(an... anVarArr) {
        List asList = Arrays.asList(anVarArr);
        if (this.f6193d.removeAll(asList)) {
            m9279c(asList);
        }
    }

    /* renamed from: a */
    public boolean mo1651a(an anVar) {
        return this.f6193d.contains(anVar);
    }

    /* renamed from: a */
    public int mo1641a() {
        return this.f6193d.size();
    }

    /* renamed from: a */
    public int mo1642a(aa aaVar) {
        Iterator it = this.f6193d.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            if (aaVar.m3762c((an) it.next())) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    /* renamed from: b */
    public boolean mo1657b() {
        return this.f6200k;
    }

    /* renamed from: c */
    public List<an> mo1658c() {
        return Arrays.asList(this.f6193d.toArray(new an[0]));
    }

    /* renamed from: a */
    public void mo1645a(db dbVar) {
        this.f6194e.add(dbVar);
    }

    /* renamed from: b */
    public void mo1653b(db dbVar) {
        this.f6194e.remove(dbVar);
    }

    /* renamed from: a */
    public void mo1644a(da daVar) {
        this.f6195f.add(daVar);
    }

    /* renamed from: b */
    public void mo1652b(da daVar) {
        this.f6194e.remove(daVar);
    }

    /* renamed from: a */
    public void mo1650a(C0800c... c0800cArr) {
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).shareBooks(this, c0800cArr);
    }

    /* renamed from: b */
    private void m9275b(an anVar) {
        if (this.f6199j == null && anVar != null && this.f6192c.m9446g()) {
            ((al) getContext().queryFeature(al.class)).mo2559o();
            this.f6191b.m9347a(false);
            m9272a(true);
            if (anVar.aA()) {
                mo1649a(anVar);
            }
            this.f6199j = new ao(getContext());
            showPopup(this.f6199j, 119, 0);
        }
    }

    /* renamed from: a */
    public void mo1646a(he heVar) {
        if (getPopupCount() <= 0) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).showMenuFromTop(heVar);
        }
    }

    /* renamed from: a */
    public void mo1643a(aa aaVar, boolean z, Runnable runnable) {
        if (this.f6197h == null) {
            this.f6197h = new eb(getContext(), aaVar);
            addSubController(this.f6197h);
            activate(this.f6197h);
            al alVar = (al) getContext().queryFeature(al.class);
            alVar.mo2546a(this.f6197h.getContentView(), ReaderEnv.get().forHd(), new bq(this, runnable, z));
            alVar.mo2559o();
            if (this.f6199j != null) {
                this.f6199j.m9174a();
            }
        }
    }

    /* renamed from: a */
    public void mo1647a(Runnable runnable) {
        if (this.f6197h != null) {
            this.f6203n = runnable;
            this.f6197h.requestDetach();
        }
    }

    /* renamed from: d */
    public aa mo1660d() {
        if (this.f6197h != null) {
            return this.f6197h.m9517c();
        }
        return null;
    }

    /* renamed from: b */
    public void mo1656b(C0800c... c0800cArr) {
        WebSession bsVar = new bs(this, C0630c.f2119a, c0800cArr);
        if (C0559f.m2476b().m2486e()) {
            bsVar.open();
        } else {
            be.m10287a(getContext(), getString(C0258j.general__shared__network_error), 0).show();
        }
    }

    /* renamed from: a */
    public void mo1648a(List<C0800c> list, Runnable runnable, Runnable runnable2) {
        int addCheckBoxView;
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.bookshelf__remove_books_dlg__title);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__remove);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        int i = 0;
        for (an anVar : list) {
            i = ((C0800c) anVar).af() | i;
        }
        if (i != 0) {
            addCheckBoxView = apVar.addCheckBoxView(C0258j.bookshelf__remove_books_dlg__del_src_files);
        } else {
            addCheckBoxView = -1;
        }
        apVar.open(new bv(this, addCheckBoxView, apVar, list, runnable, runnable2));
    }

    /* renamed from: b */
    public void mo1654b(List<C0800c> list, Runnable runnable, Runnable runnable2) {
        ap apVar = new ap(getContext());
        apVar.setTitle(C0258j.bookshelf__clear_local_files_dlg__title);
        apVar.setPrompt(String.format(getString(C0258j.bookshelf__clear_local_files_dlg__prompt), new Object[]{Integer.valueOf(list.size()), m9270a((List) list)}));
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__clear);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new bw(this, list, runnable, runnable2));
    }

    /* renamed from: c */
    public void mo1659c(List<File> list, Runnable runnable, Runnable runnable2) {
        ap apVar = new ap(getContext());
        int addCheckBoxView = apVar.addCheckBoxView(getString(C0258j.bookshelf__file_import_view__import_default_category));
        apVar.setPrompt(getString(C0258j.bookshelf__file_import_view__ensure_import));
        apVar.setCancelLabel(getString(C0258j.bookshelf__file_import_view__cancel));
        apVar.setOkLabelResid(C0258j.general__shared__confirm);
        apVar.open(new bx(this, apVar, addCheckBoxView, list, runnable, runnable2));
    }

    /* renamed from: e */
    public void m9305e() {
        this.f6191b.mo1663a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
    }

    /* renamed from: a */
    public void m9287a(C0800c c0800c) {
        if (this.f6197h != null) {
            an a = ai.m3980a().m3862a((an) c0800c);
            if (a != null) {
                this.f6191b.m9343a(a);
            }
            this.f6197h.m9511a((an) c0800c);
            return;
        }
        this.f6191b.m9343a((an) c0800c);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).addSystemUiConditioner(this);
            C1163a.m8627k().m8642a("shelf", 3);
            C1163a.m8627k().m8660f();
            DkApp.get().setReadyToSee();
            al alVar = (al) getContext().queryFeature(al.class);
            if (alVar != null) {
                alVar.mo2549a(true, "s");
            }
        }
        this.f6202m.m1607a(true);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
    }

    protected void onDeactive() {
        this.f6202m.m9391f(false);
        this.f6202m.m1607a(false);
        super.onDeactive();
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        this.f6202m.m9391f(false);
        super.onActivityConfigurationChanged(configuration);
    }

    protected boolean onBack() {
        if (this.f6198i != null) {
            return true;
        }
        if (this.f6197h == null) {
            return super.onBack();
        }
        this.f6197h.requestDetach();
        return true;
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (this.f6198i == c0303e) {
            return true;
        }
        if (this.f6199j != null) {
            this.f6199j.m9182f();
        }
        if (this.f6197h == c0303e) {
            this.f6198i = this.f6197h;
            al alVar = (al) getContext().queryFeature(al.class);
            alVar.mo2545a(this.f6198i.getContentView(), new ca(this, alVar));
            return true;
        } else if (this.f6199j == null || !c0303e.contains(this.f6199j)) {
            return super.onRequestDetach(c0303e);
        } else {
            m9272a(false);
            this.f6202m.m9391f(false);
            ((al) getContext().queryFeature(al.class)).mo2561p();
            this.f6191b.m9347a(true);
            this.f6192c.m9447h();
            this.f6199j = null;
            return super.onRequestDetach(c0303e);
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        getContext().removeFeatureListener(this.f6192c);
        getContext().removeFeatureListener(this);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).removeSystemUiConditioner(this);
        super.onDetachFromStub();
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        if (str.startsWith("#bookuuid_")) {
            an b = ai.m3980a().m3906b(str.substring("#bookuuid_".length()));
            if (b != null) {
                aa a = ai.m3980a().m3862a(b);
                if (a == null || a.m3767h()) {
                    this.f6191b.m9343a(b);
                } else {
                    mo1643a(a, false, new cb(this, b));
                }
            }
        }
        if (str.startsWith("open")) {
            ReaderFeature readerFeature = (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
            Object queryParameter = Uri.parse(str).getQueryParameter("id");
            if (!TextUtils.isEmpty(queryParameter)) {
                new cc(this, C0643q.f2173a, queryParameter, readerFeature).open();
            }
        }
        return true;
    }

    public boolean navigateSmoothly(String str) {
        return navigate(str, null, true, null);
    }

    /* renamed from: a */
    private void m9272a(boolean z) {
        if (this.f6200k != z) {
            this.f6200k = z;
            m9277b(this.f6200k);
        }
    }

    /* renamed from: a */
    private String m9270a(List<C0800c> list) {
        long j = 0;
        for (C0800c ai : list) {
            j = ai.ai() + j;
        }
        return Formatter.formatFileSize(getContext(), j);
    }

    /* renamed from: b */
    private void m9277b(boolean z) {
        Iterator it = this.f6194e.iterator();
        while (it.hasNext()) {
            ((db) it.next()).mo1628a((cz) this, z);
        }
    }

    /* renamed from: b */
    private void m9276b(List<an> list) {
        Iterator it = this.f6194e.iterator();
        while (it.hasNext()) {
            ((db) it.next()).mo1627a((cz) this, (List) list);
        }
    }

    /* renamed from: c */
    private void m9279c(List<an> list) {
        Iterator it = this.f6194e.iterator();
        while (it.hasNext()) {
            ((db) it.next()).mo1629b(this, list);
        }
    }
}
