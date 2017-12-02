package com.duokan.reader.ui.general;

import com.duokan.core.ui.TabBarView;

class is implements ix {
    final /* synthetic */ TabBarView a;
    final /* synthetic */ ir b;

    is(ir irVar, TabBarView tabBarView) {
        this.b = irVar;
        this.a = tabBarView;
    }

    public void a(float f, int i) {
        this.b.a(i, false);
        if (this.b.d != null) {
            this.b.d.a(f, i);
        }
    }

    public void a(int i, int i2) {
        this.a.a(i2);
        this.b.a(i2, false);
        if (this.b.d != null) {
            this.b.d.a(i, i2);
        }
    }
}
