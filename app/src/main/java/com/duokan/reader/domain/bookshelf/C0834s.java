package com.duokan.reader.domain.bookshelf;

/* renamed from: com.duokan.reader.domain.bookshelf.s */
class C0834s implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ac f3578a;
    /* renamed from: b */
    final /* synthetic */ C0800c f3579b;

    C0834s(C0800c c0800c, ac acVar) {
        this.f3579b = c0800c;
        this.f3578a = acVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.aV();	 Catch:{ all -> 0x009a }
        r2 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = r2.aH();	 Catch:{ all -> 0x009a }
        r1.mo1091a(r2);	 Catch:{ all -> 0x009a }
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1.aQ();	 Catch:{ all -> 0x009a }
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.f2928y;	 Catch:{ all -> 0x009a }
        if (r1 != 0) goto L_0x0031;
    L_0x001b:
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = r2.aV();	 Catch:{ all -> 0x009a }
        r2 = r2.mo1104g();	 Catch:{ all -> 0x009a }
        r3 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r3 = r3.f2717a;	 Catch:{ all -> 0x009a }
        r2 = r2.m7877b(r3);	 Catch:{ all -> 0x009a }
        r1.f2928y = r2;	 Catch:{ all -> 0x009a }
    L_0x0031:
        r1 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r1 = r1.m3775a();	 Catch:{ all -> 0x009a }
        if (r1 != 0) goto L_0x0043;
    L_0x0039:
        r1 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = r1.m3777b(r2);	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x006f;
    L_0x0043:
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.f2928y;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x005f;
    L_0x0049:
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.aV();	 Catch:{ all -> 0x009a }
        r0 = r0.mo1104g();	 Catch:{ all -> 0x009a }
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.f2928y;	 Catch:{ all -> 0x009a }
        r0.m7871a(r1);	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = 0;
        r0.f2928y = r1;	 Catch:{ all -> 0x009a }
    L_0x005f:
        r0 = r4.f3579b;
        r0 = r0.aV();
        r1 = r4.f3579b;
        r2 = r1.aH();
        r0.mo1097b(r2);
    L_0x006e:
        return;
    L_0x006f:
        r1 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r2 = 3;
        r1 = r1.m3776a(r2);	 Catch:{ all -> 0x009a }
        if (r1 != 0) goto L_0x005f;
    L_0x0078:
        r1 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r1 = r1.m3777b(r2);	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x00ab;
    L_0x0082:
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.f2928y;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x005f;
    L_0x0088:
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.aV();	 Catch:{ all -> 0x009a }
        r0 = r0.mo1104g();	 Catch:{ all -> 0x009a }
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.f2928y;	 Catch:{ all -> 0x009a }
        r0.m7885c(r1);	 Catch:{ all -> 0x009a }
        goto L_0x005f;
    L_0x009a:
        r0 = move-exception;
        r1 = r4.f3579b;
        r1 = r1.aV();
        r2 = r4.f3579b;
        r2 = r2.aH();
        r1.mo1097b(r2);
        throw r0;
    L_0x00ab:
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.f2928y;	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x00d1;
    L_0x00b1:
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.f2928y;	 Catch:{ all -> 0x009a }
        r1 = r1.m7792f();	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x00d1;
    L_0x00bb:
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.aV();	 Catch:{ all -> 0x009a }
        r1 = r1.mo1104g();	 Catch:{ all -> 0x009a }
        r2 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = r2.f2928y;	 Catch:{ all -> 0x009a }
        r1.m7871a(r2);	 Catch:{ all -> 0x009a }
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = 0;
        r1.f2928y = r2;	 Catch:{ all -> 0x009a }
    L_0x00d1:
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.f2928y;	 Catch:{ all -> 0x009a }
        if (r1 != 0) goto L_0x017c;
    L_0x00d7:
        r1 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r1 = r1.f2718b;	 Catch:{ all -> 0x009a }
        r2 = "kuaipan://";
        r1 = r1.startsWith(r2);	 Catch:{ all -> 0x009a }
        if (r1 == 0) goto L_0x0106;
    L_0x00e3:
        r0 = r4.f3578a;	 Catch:{ Throwable -> 0x0199 }
        r0 = r0.f2718b;	 Catch:{ Throwable -> 0x0199 }
        r1 = r4.f3578a;	 Catch:{ Throwable -> 0x0199 }
        r1 = r1.f2718b;	 Catch:{ Throwable -> 0x0199 }
        r2 = "?info=";
        r1 = r1.indexOf(r2);	 Catch:{ Throwable -> 0x0199 }
        r1 = r1 + 6;
        r1 = r0.substring(r1);	 Catch:{ Throwable -> 0x0199 }
        r0 = new com.duokan.reader.domain.bookshelf.is;	 Catch:{ Throwable -> 0x0199 }
        r2 = new com.duokan.reader.domain.micloud.bi;	 Catch:{ Throwable -> 0x0199 }
        r3 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0199 }
        r3.<init>(r1);	 Catch:{ Throwable -> 0x0199 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0199 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0199 }
    L_0x0106:
        r1 = new com.duokan.reader.domain.downloadcenter.a;	 Catch:{ all -> 0x009a }
        r1.<init>();	 Catch:{ all -> 0x009a }
        r2 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = r2.aH();	 Catch:{ all -> 0x009a }
        r1.f5038a = r2;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x01ae;
    L_0x0115:
        r1.f5046i = r0;	 Catch:{ all -> 0x009a }
        r0 = r0.m4682b();	 Catch:{ all -> 0x009a }
        r1.f5041d = r0;	 Catch:{ all -> 0x009a }
        r0 = "";
        r1.f5043f = r0;	 Catch:{ all -> 0x009a }
        r0 = "";
        r1.f5045h = r0;	 Catch:{ all -> 0x009a }
        r0 = "";
        r1.f5044g = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.m4156I();	 Catch:{ all -> 0x009a }
        r1.f5039b = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.m4156I();	 Catch:{ all -> 0x009a }
        r1.f5040c = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r0 = r0.f2719c;	 Catch:{ all -> 0x009a }
        r1.f5042e = r0;	 Catch:{ all -> 0x009a }
    L_0x013f:
        r0 = com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice.Transfer;	 Catch:{ all -> 0x009a }
        r1.m = r0;	 Catch:{ all -> 0x009a }
        r0 = new com.duokan.reader.domain.downloadcenter.l;	 Catch:{ all -> 0x009a }
        r0.<init>();	 Catch:{ all -> 0x009a }
        r2 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r2 = r2.f2718b;	 Catch:{ all -> 0x009a }
        r0.f5080b = r2;	 Catch:{ all -> 0x009a }
        r2 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r2 = r2.f2717a;	 Catch:{ all -> 0x009a }
        r0.f5081c = r2;	 Catch:{ all -> 0x009a }
        r2 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = r2.ay();	 Catch:{ all -> 0x009a }
        r0.f5079a = r2;	 Catch:{ all -> 0x009a }
        r2 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r2 = r2.f2720d;	 Catch:{ all -> 0x009a }
        r0.f5082d = r2;	 Catch:{ all -> 0x009a }
        r0.f5083e = r1;	 Catch:{ all -> 0x009a }
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r2 = r2.aV();	 Catch:{ all -> 0x009a }
        r2 = r2.mo1104g();	 Catch:{ all -> 0x009a }
        r0 = r2.m7865a(r0);	 Catch:{ all -> 0x009a }
        r1.f2928y = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = 0;
        r0.m4213b(r1);	 Catch:{ all -> 0x009a }
    L_0x017c:
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.f2928y;	 Catch:{ all -> 0x009a }
        r0 = r0.m7790d();	 Catch:{ all -> 0x009a }
        if (r0 != 0) goto L_0x005f;
    L_0x0186:
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.aV();	 Catch:{ all -> 0x009a }
        r0 = r0.mo1104g();	 Catch:{ all -> 0x009a }
        r1 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r1 = r1.f2928y;	 Catch:{ all -> 0x009a }
        r0.m7879b(r1);	 Catch:{ all -> 0x009a }
        goto L_0x005f;
    L_0x0199:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;
        r0 = r0.aV();
        r1 = r4.f3579b;
        r2 = r1.aH();
        r0.mo1097b(r2);
        goto L_0x006e;
    L_0x01ae:
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.ay();	 Catch:{ all -> 0x009a }
        r1.f5041d = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.m4150C();	 Catch:{ all -> 0x009a }
        r1.f5043f = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.m4228g();	 Catch:{ all -> 0x009a }
        r1.f5045h = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.m4248t();	 Catch:{ all -> 0x009a }
        r0 = r0.f2706d;	 Catch:{ all -> 0x009a }
        r1.f5044g = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.m4156I();	 Catch:{ all -> 0x009a }
        r1.f5039b = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3579b;	 Catch:{ all -> 0x009a }
        r0 = r0.m4156I();	 Catch:{ all -> 0x009a }
        r1.f5040c = r0;	 Catch:{ all -> 0x009a }
        r0 = r4.f3578a;	 Catch:{ all -> 0x009a }
        r0 = r0.f2719c;	 Catch:{ all -> 0x009a }
        r1.f5042e = r0;	 Catch:{ all -> 0x009a }
        goto L_0x013f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.s.run():void");
    }
}
