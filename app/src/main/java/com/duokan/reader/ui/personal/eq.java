package com.duokan.reader.ui.personal;

import android.content.Context;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.micloud.bj;
import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.ap;

import java.util.Collections;
import java.util.List;

public class eq extends nm {
    private final av a;
    private final av k;
    private final eo l;
    private bj m;
    private boolean n = true;
    private ai o;
    private boolean p = false;
    private boolean q = false;

    public eq(Context context, ho hoVar) {
        super(context, hoVar);
        this.b.setVisibility(8);
        this.l = (eo) MyContextWrapper.getFeature(context).queryFeature(eo.class);
        this.o = new ai(getContext());
        this.o.setPadding(UTools.closeAnimation(getContext(), 15.0f), 0, 0, 0);
        this.d.addView(this.o);
        this.d.setVisibility(4);
        this.a = new er(this, getContext());
        this.k = new es(this, getContext());
        this.i = new et(this);
        setAdapter(this.a);
        setSearchAdapter(this.k);
    }

    public void setSpaceQuota(bj bjVar) {
        this.m = bjVar;
        h();
        s();
    }

    public void setData(List list) {
        this.a.a(a(list));
        o();
        setSpaceQuota(iz.a().b().b());
    }

    public void setfilterMiCloudItemInfos(List list) {
        this.a.a(CustomCloudItem.a(getCloudItem(), list));
        this.k.a(CustomCloudItem.a(this.k.n(), list), this.k.o());
    }

    public void setfilterCreateFileTaskItems(List list) {
        this.a.a(CustomCloudItem.b(getCloudItem(), list));
        this.k.a(CustomCloudItem.b(this.k.n(), list), this.k.o());
    }

    public List getCloudItem() {
        return this.a.n();
    }

    public void a(i iVar, boolean z) {
        ((av) getAdapter()).a(ReaderUi.a(getListView()), iVar, z);
    }

    public void f_() {
        if (this.p) {
            this.q = true;
        } else {
            g();
        }
    }

    public void a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(j.bookshelf__remove_books_in_cloud_dlg__title);
        apVar.setCancelLabel(j.general__shared__cancel);
        apVar.setOkLabel(j.general__shared__remove);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new eu(this, runnable));
    }

    public void b() {
        super.b();
        if (!k()) {
            this.e.setPullDownRefreshEnabled(true);
        }
    }

    public void a() {
        super.a();
        if (!k()) {
            this.e.setPullDownRefreshEnabled(false);
        }
    }

    private void g() {
        this.p = true;
        iz.a().a(new ew(this));
    }

    private void h() {
        this.o.a(this.m, 10);
    }

    private void r() {
        if (this.n) {
            f_();
            this.n = false;
            iz.a().a(true);
            return;
        }
        iz.a().a(false);
    }

    private void s() {
        this.d.setVisibility(this.a.c() > 0 ? 0 : 8);
    }

    private List a(List list) {
        Collections.sort(list, new ez(this));
        return list;
    }

    public void d() {
        b(false);
        s();
    }
}
