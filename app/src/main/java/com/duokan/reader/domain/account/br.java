package com.duokan.reader.domain.account;

import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.domain.statistics.C1163a;

public class br implements aq<MiGuestAccount> {
    /* renamed from: a */
    private final MiGuestAccount f2446a;
    /* renamed from: b */
    private final C0420b f2447b;
    /* renamed from: c */
    private boolean f2448c;

    private br(MiGuestAccount miGuestAccount, C0420b c0420b) {
        this.f2448c = false;
        this.f2446a = miGuestAccount;
        this.f2447b = c0420b;
    }

    /* renamed from: a */
    public void mo866a() {
        new ThirdWeiXin().login();
        C1163a.m8627k().m8655c("login", "wechat", "click");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m3422a(com.duokan.reader.domain.account.MiGuestAccount r5, com.tencent.mm.opensdk.modelmsg.SendAuth$Resp r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f2448c;	 Catch:{ all -> 0x0038 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
    L_0x0006:
        return;
    L_0x0007:
        r0 = 1;
        r4.f2448c = r0;	 Catch:{ all -> 0x0038 }
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
        r0 = r4.f2447b;
        if (r0 == 0) goto L_0x0006;
    L_0x000f:
        if (r6 == 0) goto L_0x0019;
    L_0x0011:
        r0 = r6.code;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x003b;
    L_0x0019:
        r0 = com.duokan.reader.domain.statistics.C1163a.m8627k();
        r1 = "login";
        r2 = "wechat";
        r3 = "canceled";
        r0.m8655c(r1, r2, r3);
        r0 = r4.f2447b;
        r1 = com.duokan.reader.domain.account.C0709k.m3476a();
        r2 = com.duokan.reader.domain.account.MiGuestAccount.class;
        r1 = r1.m3502b(r2);
        r2 = "";
        r0.onLoginError(r1, r2);
        goto L_0x0006;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
        throw r0;
    L_0x003b:
        r0 = new com.duokan.reader.domain.account.a.l;
        r1 = r6.code;
        r2 = new com.duokan.reader.domain.account.bs;
        r2.<init>(r4);
        r3 = new com.duokan.reader.domain.account.a.z;
        r3.<init>();
        r0.<init>(r5, r1, r2, r3);
        r0.m3320a();
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.account.br.a(com.duokan.reader.domain.account.MiGuestAccount, com.tencent.mm.opensdk.modelmsg.SendAuth$Resp):void");
    }
}
