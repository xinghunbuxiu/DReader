package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;

public abstract class po extends tc {
    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
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

    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    public /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public po(IFeature featrue) {
        super(featrue);
        findViewById(g.reading__reading_menu_view__search).setOnClickListener(new pp(this));
        findViewById(g.reading__reading_menu_bottom_view__options).setOnClickListener(new pq(this));
    }

    protected void b() {
        a(new ud(getContext()));
    }
}
