package com.duokan.core.ui;

class ba implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f989a;
    /* renamed from: b */
    final /* synthetic */ ay f990b;

    ba(ay ayVar, int i) {
        this.f990b = ayVar;
        this.f989a = i;
    }

    public void run() {
        if (this.f990b.f761C == this) {
            bc r = this.f990b.m1163r(this.f989a);
            if (r != null) {
                this.f990b.f760B = this.f989a;
                if (r.f994b != null) {
                    r.f994b.setPressed(true);
                }
            }
            this.f990b.f761C = null;
        }
    }
}
