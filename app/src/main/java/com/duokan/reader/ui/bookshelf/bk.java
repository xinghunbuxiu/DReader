package com.duokan.reader.ui.bookshelf;

import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.Formatter;

import com.duokan.core.app.aa;
import com.duokan.core.app.e;
import com.duokan.core.app.k;
import com.duokan.core.app.y;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.statistics.a;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.em;
import com.duokan.reader.ui.surfing.af;

import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class bk extends em implements aa, SystemUiConditioner, cu {
    private final BookshelfPrefs a = new BookshelfPrefs();
    private final c b;
    private final cr c = new cr(getContext(), getActivity());
    private final HashSet d = new HashSet();
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList f = new CopyOnWriteArrayList();
    private final af g = ((af) getContext().queryFeature(af.class));
    private dt h = null;
    private dt i = null;
    private ai j = null;
    private boolean k = false;
    private boolean l = false;
    private final bz m = new bz();
    private Runnable n = null;

    public bk(y yVar) {
        super(yVar);
        getContext().a(this.c);
        getContext().a((k) this);
        this.b = new c(getContext());
        a(this.b.getContentView());
        addSubController(this.b);
        activate(this.b);
        this.g.a(this.m);
    }

    public void chooseStatusBarStyle(com.duokan.core.sys.af afVar) {
        if (isActive()) {
            afVar.a(Boolean.valueOf(true));
        }
    }

    public void chooseNavigationBarMode(com.duokan.core.sys.af afVar) {
    }

    public void chooseNavigationBarColor(com.duokan.core.sys.af afVar) {
    }

    public void a(an... anVarArr) {
        List asList = Arrays.asList(anVarArr);
        if (this.d.addAll(asList)) {
            b(asList);
        }
    }

    public void b(an... anVarArr) {
        List asList = Arrays.asList(anVarArr);
        if (this.d.removeAll(asList)) {
            c(asList);
        }
    }

    public boolean a(an anVar) {
        return this.d.contains(anVar);
    }

    public int a() {
        return this.d.size();
    }

    public int a(com.duokan.reader.domain.bookshelf.aa aaVar) {
        Iterator it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            if (aaVar.c((an) it.next())) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public boolean b() {
        return this.k;
    }

    public List c() {
        return Arrays.asList(this.d.toArray(new an[0]));
    }

    public void a(cw cwVar) {
        this.e.add(cwVar);
    }

    public void b(cw cwVar) {
        this.e.remove(cwVar);
    }

    public void a(cv cvVar) {
        this.f.add(cvVar);
    }

    public void b(cv cvVar) {
        this.e.remove(cvVar);
    }

    public void a(c... cVarArr) {
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).shareBooks(this, cVarArr);
    }

    private void b(an anVar) {
        if (this.j == null && anVar != null && this.c.g()) {
            ((af) getContext().queryFeature(af.class)).o();
            this.b.a(false);
            a(true);
            if (anVar.ay()) {
                a(anVar);
            }
            this.j = new ai(getContext());
            showPopup(this.j, 119, 0);
        }
    }

    public void a(gx gxVar) {
        if (getPopupCount() <= 0) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).showMenuFromTop(gxVar);
        }
    }

    public void a(com.duokan.reader.domain.bookshelf.aa aaVar, boolean z, Runnable runnable) {
        if (this.h == null) {
            this.h = new dt(getContext(), aaVar);
            addSubController(this.h);
            activate(this.h);
            af afVar = (af) getContext().queryFeature(af.class);
            afVar.a(this.h.getContentView(), ReaderEnv.get().forHd(), new bl(this, runnable, z));
            afVar.o();
            if (this.j != null) {
                this.j.a();
            }
        }
    }

    public void a(Runnable runnable) {
        if (this.h != null) {
            this.n = runnable;
            this.h.requestDetach();
        }
    }

    public com.duokan.reader.domain.bookshelf.aa d() {
        if (this.h != null) {
            return this.h.c();
        }
        return null;
    }

    public void b(c... cVarArr) {
        com.duokan.reader.common.webservices.duokan.c bnVar = new bn(this, cVarArr);
        if (f.b().e()) {
            bnVar.open();
        } else {
            be.a(getContext(), getString(j.general__shared__network_error), 0).show();
        }
    }

    public void a(List list, Runnable runnable, Runnable runnable2) {
        int addCheckBoxView;
        ap apVar = new ap(getContext());
        apVar.setPrompt(j.bookshelf__remove_books_dlg__title);
        apVar.setCancelLabel(j.general__shared__cancel);
        apVar.setOkLabel(j.general__shared__remove);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        int i = 0;
        for (an anVar : list) {
            i = ((c) anVar).ad() | i;
        }
        if (i != 0) {
            addCheckBoxView = apVar.addCheckBoxView(j.bookshelf__remove_books_dlg__del_src_files);
        } else {
            addCheckBoxView = -1;
        }
        apVar.open(new bq(this, addCheckBoxView, apVar, list, runnable, runnable2));
    }

    public void b(List list, Runnable runnable, Runnable runnable2) {
        ap apVar = new ap(getContext());
        apVar.setTitle(j.bookshelf__clear_local_files_dlg__title);
        apVar.setPrompt(String.format(getString(j.bookshelf__clear_local_files_dlg__prompt), new Object[]{Integer.valueOf(list.size()), a(list)}));
        apVar.setCancelLabel(j.general__shared__cancel);
        apVar.setOkLabel(j.general__shared__clear);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new br(this, list, runnable, runnable2));
    }

    public void c(List list, Runnable runnable, Runnable runnable2) {
        ap apVar = new ap(getContext());
        int addCheckBoxView = apVar.addCheckBoxView(getString(j.bookshelf__file_import_view__import_default_category));
        apVar.setPrompt(getString(j.bookshelf__file_import_view__ensure_import));
        apVar.setCancelLabel(getString(j.bookshelf__file_import_view__cancel));
        apVar.setOkLabel(j.general__shared__confirm);
        apVar.open(new bs(this, apVar, addCheckBoxView, list, runnable, runnable2));
    }

    public void e() {
        this.b.a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
    }

    public void a(c cVar) {
        if (this.h != null) {
            an a = ai.a().a((an) cVar);
            if (a != null) {
                this.b.a(a);
            }
            this.h.a((an) cVar);
            return;
        }
        this.b.a((an) cVar);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).addSystemUiConditioner(this);
            a.k().a("shelf", 3);
            a.k().f();
            DkApp.get().setReadyToSee();
            af afVar = (af) getContext().queryFeature(af.class);
            if (afVar != null) {
                afVar.a(true, "s");
            }
        }
        this.m.a(true);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
    }

    protected void onDeactive() {
        this.m.f(false);
        this.m.a(false);
        super.onDeactive();
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        this.m.f(false);
        super.onActivityConfigurationChanged(configuration);
    }

    protected boolean onBack() {
        if (this.i != null) {
            return true;
        }
        if (this.h == null) {
            return super.onBack();
        }
        this.h.requestDetach();
        return true;
    }

    protected boolean onRequestDetach(e eVar) {
        if (this.i == eVar) {
            return true;
        }
        if (this.j != null) {
            this.j.f();
        }
        if (this.h == eVar) {
            this.i = this.h;
            af afVar = (af) getContext().queryFeature(af.class);
            afVar.a(this.i.getContentView(), new bv(this, afVar));
            return true;
        } else if (this.j == null || !eVar.contains(this.j)) {
            return super.onRequestDetach(eVar);
        } else {
            a(false);
            this.m.f(false);
            ((af) getContext().queryFeature(af.class)).p();
            this.b.a(true);
            this.c.h();
            this.j = null;
            return super.onRequestDetach(eVar);
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        getContext().b(this.c);
        getContext().b(this);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).removeSystemUiConditioner(this);
        super.onDetachFromStub();
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        if (str.startsWith("#bookuuid_")) {
            an b = ai.a().b(str.substring("#bookuuid_".length()));
            if (b != null) {
                com.duokan.reader.domain.bookshelf.aa a = ai.a().a(b);
                if (a == null || a.h()) {
                    this.b.a(b);
                } else {
                    a(a, false, new bw(this, b));
                }
            }
        }
        if (str.startsWith("open")) {
            ReaderFeature readerFeature = (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
            Object queryParameter = Uri.parse(str).getQueryParameter("id");
            if (!TextUtils.isEmpty(queryParameter)) {
                new bx(this, queryParameter, readerFeature).open();
            }
        }
        return true;
    }

    public boolean navigateSmoothly(String str) {
        return navigate(str, null, true, null);
    }

    private void a(boolean z) {
        if (this.k != z) {
            this.k = z;
            b(this.k);
        }
    }

    private String a(List list) {
        long j = 0;
        for (c ag : list) {
            j = ag.ag() + j;
        }
        return Formatter.formatFileSize(getContext(), j);
    }

    private void b(boolean z) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((cw) it.next()).a((cu) this, z);
        }
    }

    private void b(List list) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((cw) it.next()).a((cu) this, list);
        }
    }

    private void c(List list) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((cw) it.next()).b(this, list);
        }
    }
}
