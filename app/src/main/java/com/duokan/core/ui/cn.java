package com.duokan.core.ui;

class cn implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ TabBarView b;

    cn(TabBarView tabBarView, boolean z) {
        this.b = tabBarView;
        this.a = z;
    }

    public void run() {
        if (this.b.j != null) {
            this.b.j.b(this.b.c, this.b.b, this.a);
        }
    }
}
