package com.duokan.reader.ui.reading;

import com.duokan.core.ui.TabBarView;

class fc implements bw {
    final /* synthetic */ TabBarView a;
    final /* synthetic */ fa b;

    fc(fa faVar, TabBarView tabBarView) {
        this.b = faVar;
        this.a = tabBarView;
    }

    public void a(int i, int i2, float f) {
        if (this.a.getSelectedTabIndex() == 0) {
            this.b.a.ae().h(i2);
            this.b.a.ae().f(f);
            this.b.a.ae().Y();
            this.b.a.c(i);
            return;
        }
        this.b.a.ae().j(i2);
        this.b.a.ae().g(f);
        this.b.a.ae().Y();
        this.b.a.d(i);
    }
}
