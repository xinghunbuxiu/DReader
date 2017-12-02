package com.duokan.core.ui;

class ba implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ay b;

    ba(ay ayVar, int i) {
        this.b = ayVar;
        this.a = i;
    }

    public void run() {
        if (this.b.C == this) {
            bc r = this.b.r(this.a);
            if (r != null) {
                this.b.B = this.a;
                if (r.b != null) {
                    r.b.setPressed(true);
                }
            }
            this.b.C = null;
        }
    }
}
