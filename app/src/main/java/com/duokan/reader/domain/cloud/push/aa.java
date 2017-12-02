package com.duokan.reader.domain.cloud.push;

class aa implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ z d;

    aa(z zVar, long j, String str, String str2) {
        this.d = zVar;
        this.a = j;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        if (this.d.j != null) {
            this.d.j.a(this.a, this.b, this.c);
        }
    }
}
