package com.duokan.reader.ui.reading;

import com.duokan.core.ui.TabBarView;

class fg implements by {
    /* renamed from: a */
    final /* synthetic */ TabBarView f10139a;
    /* renamed from: b */
    final /* synthetic */ fe f10140b;

    fg(fe feVar, TabBarView tabBarView) {
        this.f10140b = feVar;
        this.f10139a = tabBarView;
    }

    /* renamed from: a */
    public void mo2315a(int i, int i2, float f) {
        if (this.f10139a.getSelectedTabIndex() == 0) {
            this.f10140b.f10136a.ae().m12509h(i2);
            this.f10140b.f10136a.ae().m12500f(f);
            this.f10140b.f10136a.ae().m12463X();
            this.f10140b.f10136a.mo2127c(i);
            return;
        }
        this.f10140b.f10136a.ae().m12515j(i2);
        this.f10140b.f10136a.ae().m12504g(f);
        this.f10140b.f10136a.ae().m12463X();
        this.f10140b.f10136a.mo2130d(i);
    }
}
