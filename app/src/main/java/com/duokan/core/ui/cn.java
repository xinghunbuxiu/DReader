package com.duokan.core.ui;

class cn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f1084a;
    /* renamed from: b */
    final /* synthetic */ TabBarView f1085b;

    cn(TabBarView tabBarView, boolean z) {
        this.f1085b = tabBarView;
        this.f1084a = z;
    }

    public void run() {
        if (this.f1085b.f865j != null) {
            this.f1085b.f865j.mo1698b(this.f1085b.f858c, this.f1085b.f857b, this.f1084a);
        }
    }
}
