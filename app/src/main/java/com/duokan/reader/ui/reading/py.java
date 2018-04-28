package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.p024c.C0255g;

public abstract class py extends tp {
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo2252a(long j) {
        super.mo2252a(j);
    }

    public /* bridge */ /* synthetic */ void chooseNavigationBarColor(af afVar) {
        super.chooseNavigationBarColor(afVar);
    }

    public /* bridge */ /* synthetic */ void chooseNavigationBarMode(af afVar) {
        super.chooseNavigationBarMode(afVar);
    }

    public /* bridge */ /* synthetic */ void chooseStatusBarStyle(af afVar) {
        super.chooseStatusBarStyle(afVar);
    }

    public /* bridge */ /* synthetic */ boolean dismissTopPopup() {
        return super.dismissTopPopup();
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo2254f() {
        super.mo2254f();
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ void mo2255g() {
        super.mo2255g();
    }

    public py(IFeature mFeature) {
        super(mFeature);
        findViewById(C0255g.reading__reading_menu_view__search).setOnClickListener(new pz(this));
        findViewById(C0255g.reading__reading_menu_bottom_view__options).setOnClickListener(new qa(this));
    }

    /* renamed from: b */
    protected void mo2253b() {
        mo2248a(new uq(getContext()));
    }
}
