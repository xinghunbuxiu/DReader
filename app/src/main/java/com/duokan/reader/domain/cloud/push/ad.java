package com.duokan.reader.domain.cloud.push;

class ad implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ z d;

    ad(z zVar, String str, String str2, boolean z) {
        this.d = zVar;
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public void run() {
        if (this.d.j != null) {
            this.d.j.a(this.a, this.b, this.c);
        }
    }
}
