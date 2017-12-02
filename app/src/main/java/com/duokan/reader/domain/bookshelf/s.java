package com.duokan.reader.domain.bookshelf;

class s implements Runnable {
    final /* synthetic */ ac a;
    final /* synthetic */ c b;

    s(c cVar, ac acVar) {
        this.b = cVar;
        this.a = acVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.aT();	 Catch:{ all -> 0x009a }
        r2 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = r2.aF();	 Catch:{ all -> 0x009a }
        r1.a(r2);	 Catch:{ all -> 0x009a }
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1.aO();	 Catch:{ all -> 0x009a }
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.y;	 Catch:{ all -> 0x009a }
        if (r1 != 0) goto L_0x0031;
    L_0x001b:
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = r2.aT();	 Catch:{ all -> 0x009a }
        r2 = r2.g();	 Catch:{ all -> 0x009a }
        r3 = r4.a;	 Catch:{ all -> 0x009a }
        r3 = r3.a;	 Catch:{ all -> 0x009a }
        r2 = r2.b(r3);	 Catch:{ all -> 0x009a }
        r1.y = r2;	 Catch:{ all -> 0x009a }
    L_0x0031:
        r1 = r4.a;	 Catch:{ all -> 0x009a }
        r1 = r1.a();	 Catch:{ all -> 0x009a }
        if (r1 != 0) goto L_0x0043;
    L_0x0039:
        r1 = r4.a;	 Catch:{ all -> 0x009a }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = r1.b(r2);	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x006f;
    L_0x0043:
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.y;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x005f;
    L_0x0049:
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.aT();	 Catch:{ all -> 0x009a }
        r0 = r0.g();	 Catch:{ all -> 0x009a }
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.y;	 Catch:{ all -> 0x009a }
        r0.a(r1);	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = 0;
        r0.y = r1;	 Catch:{ all -> 0x009a }
    L_0x005f:
        r0 = r4.b;
        r0 = r0.aT();
        r1 = r4.b;
        r2 = r1.aF();
        r0.b(r2);
    L_0x006e:
        return;
    L_0x006f:
        r1 = r4.a;	 Catch:{ all -> 0x009a }
        r2 = 3;
        r1 = r1.a(r2);	 Catch:{ all -> 0x009a }
        if (r1 != 0) goto L_0x005f;
    L_0x0078:
        r1 = r4.a;	 Catch:{ all -> 0x009a }
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r1 = r1.b(r2);	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x00ab;
    L_0x0082:
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.y;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x005f;
    L_0x0088:
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.aT();	 Catch:{ all -> 0x009a }
        r0 = r0.g();	 Catch:{ all -> 0x009a }
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.y;	 Catch:{ all -> 0x009a }
        r0.c(r1);	 Catch:{ all -> 0x009a }
        goto L_0x005f;
    L_0x009a:
        r0 = move-exception;
        r1 = r4.b;
        r1 = r1.aT();
        r2 = r4.b;
        r2 = r2.aF();
        r1.b(r2);
        throw r0;
    L_0x00ab:
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.y;	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x00d1;
    L_0x00b1:
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.y;	 Catch:{ all -> 0x009a }
        r1 = r1.f();	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x00d1;
    L_0x00bb:
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.aT();	 Catch:{ all -> 0x009a }
        r1 = r1.g();	 Catch:{ all -> 0x009a }
        r2 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = r2.y;	 Catch:{ all -> 0x009a }
        r1.a(r2);	 Catch:{ all -> 0x009a }
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = 0;
        r1.y = r2;	 Catch:{ all -> 0x009a }
    L_0x00d1:
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.y;	 Catch:{ all -> 0x009a }
        if (r1 != 0) goto L_0x017c;
    L_0x00d7:
        r1 = r4.a;	 Catch:{ all -> 0x009a }
        r1 = r1.b;	 Catch:{ all -> 0x009a }
        r2 = "kuaipan://";
        r1 = r1.startsWith(r2);	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x0106;
    L_0x00e3:
        r0 = r4.a;	 Catch:{ Throwable -> 0x0199 }
        r0 = r0.b;	 Catch:{ Throwable -> 0x0199 }
        r1 = r4.a;	 Catch:{ Throwable -> 0x0199 }
        r1 = r1.b;	 Catch:{ Throwable -> 0x0199 }
        r2 = "?info=";
        r1 = r1.indexOf(r2);	 Catch:{ Throwable -> 0x0199 }
        r1 = r1 + 6;
        r1 = r0.substring(r1);	 Catch:{ Throwable -> 0x0199 }
        r0 = new com.duokan.reader.domain.bookshelf.iy;	 Catch:{ Throwable -> 0x0199 }
        r2 = new com.duokan.reader.domain.micloud.bi;	 Catch:{ Throwable -> 0x0199 }
        r3 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0199 }
        r3.<init>(r1);	 Catch:{ Throwable -> 0x0199 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0199 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0199 }
    L_0x0106:
        r1 = new com.duokan.reader.domain.downloadcenter.a;	 Catch:{ all -> 0x009a }
        r1.<init>();	 Catch:{ all -> 0x009a }
        r2 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = r2.aF();	 Catch:{ all -> 0x009a }
        r1.a = r2;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x01ae;
    L_0x0115:
        r1.i = r0;	 Catch:{ all -> 0x009a }
        r0 = r0.b();	 Catch:{ all -> 0x009a }
        r1.d = r0;	 Catch:{ all -> 0x009a }
        r0 = "";
        r1.f = r0;	 Catch:{ all -> 0x009a }
        r0 = "";
        r1.h = r0;	 Catch:{ all -> 0x009a }
        r0 = "";
        r1.g = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.H();	 Catch:{ all -> 0x009a }
        r1.b = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.H();	 Catch:{ all -> 0x009a }
        r1.c = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.a;	 Catch:{ all -> 0x009a }
        r0 = r0.c;	 Catch:{ all -> 0x009a }
        r1.e = r0;	 Catch:{ all -> 0x009a }
    L_0x013f:
        r0 = com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice.Transfer;	 Catch:{ all -> 0x009a }
        r1.m = r0;	 Catch:{ all -> 0x009a }
        r0 = new com.duokan.reader.domain.downloadcenter.l;	 Catch:{ all -> 0x009a }
        r0.<init>();	 Catch:{ all -> 0x009a }
        r2 = r4.a;	 Catch:{ all -> 0x009a }
        r2 = r2.b;	 Catch:{ all -> 0x009a }
        r0.b = r2;	 Catch:{ all -> 0x009a }
        r2 = r4.a;	 Catch:{ all -> 0x009a }
        r2 = r2.a;	 Catch:{ all -> 0x009a }
        r0.c = r2;	 Catch:{ all -> 0x009a }
        r2 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = r2.aw();	 Catch:{ all -> 0x009a }
        r0.a = r2;	 Catch:{ all -> 0x009a }
        r2 = r4.a;	 Catch:{ all -> 0x009a }
        r2 = r2.d;	 Catch:{ all -> 0x009a }
        r0.d = r2;	 Catch:{ all -> 0x009a }
        r0.e = r1;	 Catch:{ all -> 0x009a }
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = r4.b;	 Catch:{ all -> 0x009a }
        r2 = r2.aT();	 Catch:{ all -> 0x009a }
        r2 = r2.g();	 Catch:{ all -> 0x009a }
        r0 = r2.a(r0);	 Catch:{ all -> 0x009a }
        r1.y = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = 0;
        r0.b(r1);	 Catch:{ all -> 0x009a }
    L_0x017c:
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.y;	 Catch:{ all -> 0x009a }
        r0 = r0.d();	 Catch:{ all -> 0x009a }
        if (r0 != 0) goto L_0x005f;
    L_0x0186:
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.aT();	 Catch:{ all -> 0x009a }
        r0 = r0.g();	 Catch:{ all -> 0x009a }
        r1 = r4.b;	 Catch:{ all -> 0x009a }
        r1 = r1.y;	 Catch:{ all -> 0x009a }
        r0.b(r1);	 Catch:{ all -> 0x009a }
        goto L_0x005f;
    L_0x0199:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x009a }
        r0 = r4.b;
        r0 = r0.aT();
        r1 = r4.b;
        r2 = r1.aF();
        r0.b(r2);
        goto L_0x006e;
    L_0x01ae:
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.aw();	 Catch:{ all -> 0x009a }
        r1.d = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.B();	 Catch:{ all -> 0x009a }
        r1.f = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.g();	 Catch:{ all -> 0x009a }
        r1.h = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.t();	 Catch:{ all -> 0x009a }
        r0 = r0.d;	 Catch:{ all -> 0x009a }
        r1.g = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.H();	 Catch:{ all -> 0x009a }
        r1.b = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.b;	 Catch:{ all -> 0x009a }
        r0 = r0.H();	 Catch:{ all -> 0x009a }
        r1.c = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.a;	 Catch:{ all -> 0x009a }
        r0 = r0.c;	 Catch:{ all -> 0x009a }
        r1.e = r0;	 Catch:{ all -> 0x009a }
        goto L_0x013f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.s.run():void");
    }
}
