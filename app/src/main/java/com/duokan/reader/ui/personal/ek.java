package com.duokan.reader.ui.personal;

import android.content.Context;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.bj;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.ap;
import java.util.Collections;
import java.util.List;

public class ek extends oa {
    /* renamed from: a */
    private final ao f8501a;
    /* renamed from: l */
    private final ao f8502l;
    /* renamed from: m */
    private final ei f8503m;
    /* renamed from: n */
    private bj f8504n;
    /* renamed from: o */
    private boolean f8505o = true;
    /* renamed from: p */
    private ab f8506p;
    /* renamed from: q */
    private boolean f8507q = false;
    /* renamed from: r */
    private boolean f8508r = false;

    public ek(Context context, hv hvVar) {
        super(context, hvVar);
        this.b.setVisibility(8);
        this.f8503m = (ei) AppContext.getAppContext(context).queryFeature(ei.class);
        this.f8506p = new ab(getContext());
        this.f8506p.setPadding(dv.m1932b(getContext(), 15.0f), 0, 0, 0);
        this.e.addView(this.f8506p);
        this.e.setVisibility(4);
        this.f8501a = new el(this, getContext());
        this.f8502l = new em(this, getContext());
        this.j = new en(this);
        setAdapter(this.f8501a);
        setSearchAdapter(this.f8502l);
    }

    public void setSpaceQuota(bj bjVar) {
        this.f8504n = bjVar;
        m11747h();
        m11749s();
    }

    public void setData(List<CustomCloudItem> list) {
        this.f8501a.m11409a(m11737a((List) list));
        m11534o();
        setSpaceQuota(it.m4692a().m4725b().m8168b());
    }

    public void setfilterMiCloudItemInfos(List<bi> list) {
        this.f8501a.m11409a(CustomCloudItem.m11334a(getCloudItem(), list));
        this.f8502l.m11410a(CustomCloudItem.m11334a(this.f8502l.m11420n(), list), this.f8502l.m11421o());
    }

    public void setfilterCreateFileTaskItems(List<C1068i> list) {
        this.f8501a.m11409a(CustomCloudItem.m11335b(getCloudItem(), list));
        this.f8502l.m11410a(CustomCloudItem.m11335b(this.f8502l.m11420n(), list), this.f8502l.m11421o());
    }

    public List<CustomCloudItem> getCloudItem() {
        return this.f8501a.m11420n();
    }

    /* renamed from: a */
    public void m11751a(C1068i c1068i, boolean z) {
        ((ao) getAdapter()).m11408a(ReaderUi.m10157a(getListView()), c1068i, z);
    }

    public void g_() {
        if (this.f8507q) {
            this.f8508r = true;
        } else {
            m11746g();
        }
    }

    /* renamed from: a */
    public void m11752a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.bookshelf__remove_books_in_cloud_dlg__title);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__remove);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new eo(this, runnable));
    }

    /* renamed from: b */
    public void mo1892b() {
        super.mo1892b();
        if (!m11530k()) {
            this.f.setPullDownRefreshEnabled(true);
        }
    }

    /* renamed from: a */
    public void mo1891a() {
        super.mo1891a();
        if (!m11530k()) {
            this.f.setPullDownRefreshEnabled(false);
        }
    }

    /* renamed from: g */
    private void m11746g() {
        this.f8507q = true;
        it.m4692a().m4716a(new eq(this));
    }

    /* renamed from: h */
    private void m11747h() {
        this.f8506p.m11374a(this.f8504n, 10);
    }

    /* renamed from: r */
    private void m11748r() {
        if (this.f8505o) {
            g_();
            this.f8505o = false;
            it.m4692a().m4724a(true);
            return;
        }
        it.m4692a().m4724a(false);
    }

    /* renamed from: s */
    private void m11749s() {
        this.e.setVisibility(this.f8501a.mo506c() > 0 ? 0 : 8);
    }

    /* renamed from: a */
    private List<CustomCloudItem> m11737a(List<CustomCloudItem> list) {
        Collections.sort(list, new et(this));
        return list;
    }

    /* renamed from: d */
    public void mo1903d() {
        m11523b(false);
        m11749s();
    }
}
