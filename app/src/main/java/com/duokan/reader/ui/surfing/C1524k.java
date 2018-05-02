package com.duokan.reader.ui.surfing;

import android.net.Uri;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.UThread;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;

/* renamed from: com.duokan.reader.ui.surfing.k */
class C1524k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f11560a;
    /* renamed from: b */
    final /* synthetic */ boolean f11561b;
    /* renamed from: c */
    final /* synthetic */ Runnable f11562c;
    /* renamed from: d */
    final /* synthetic */ Uri f11563d;
    /* renamed from: e */
    final /* synthetic */ C1522i f11564e;

    C1524k(C1522i c1522i, String str, boolean z, Runnable runnable, Uri uri) {
        this.f11564e = c1522i;
        this.f11560a = str;
        this.f11561b = z;
        this.f11562c = runnable;
        this.f11563d = uri;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r7 = this;
        r1 = 0;
        r4 = 1;
        r6 = 0;
        r0 = r7.f11560a;
        r2 = 47;
        r0 = r0.indexOf(r2);
        if (r0 < 0) goto L_0x0054;
    L_0x000d:
        r2 = r7.f11560a;
        r2 = r2.length();
        r2 = r2 + -1;
        if (r0 >= r2) goto L_0x0054;
    L_0x0017:
        r2 = r7.f11560a;
        r3 = r0 + 1;
        r2 = r2.substring(r3);
        r3 = "message";
        r2 = r2.startsWith(r3);
        if (r2 == 0) goto L_0x0097;
    L_0x0027:
        r2 = r7.f11560a;
        r3 = r0 + 1;
        r2 = r2.substring(r3);
        r3 = "message";
        r3 = r3.length();
        r2 = r2.substring(r3);
        r3 = "/feed";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0055;
    L_0x0041:
        r2 = new com.duokan.reader.ui.personal.cd;
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2.<init>(r0, r4);
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r0.m15543a(r1, r2, r3, r4, r5);
    L_0x0054:
        return;
    L_0x0055:
        r2 = r7.f11560a;
        r0 = r0 + 1;
        r0 = r2.substring(r0);
        r2 = "message";
        r2 = r2.length();
        r0 = r0.substring(r2);
        r2 = "/notification";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0083;
    L_0x006f:
        r2 = new com.duokan.reader.ui.personal.cd;
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2.<init>(r0, r6);
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x0083:
        r2 = new com.duokan.reader.ui.personal.cd;
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2.<init>(r0, r6);
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x0097:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "favourite";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00bd;
    L_0x00a7:
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2 = com.duokan.reader.ui.store.bv.m15353a(r0);
        r1 = com.duokan.reader.domain.account.MiAccount.class;
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r4 = r6;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x00bd:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "coupons";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x013b;
    L_0x00cd:
        r0 = r7.f11563d;
        r1 = "award_type";
        r1 = r0.getQueryParameter(r1);
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x00f2;
    L_0x00db:
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2 = com.duokan.reader.ui.store.bv.m15359c(r0);
    L_0x00e5:
        r1 = com.duokan.reader.domain.account.PersonalAccount.class;
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r4 = r6;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x00f2:
        r0 = -1;
        r2 = r1.hashCode();
        switch(r2) {
            case 48: goto L_0x0113;
            case 49: goto L_0x011c;
            case 50: goto L_0x0109;
            case 1567: goto L_0x0126;
            default: goto L_0x00fa;
        };
    L_0x00fa:
        r4 = r0;
    L_0x00fb:
        switch(r4) {
            case 0: goto L_0x0130;
            default: goto L_0x00fe;
        };
    L_0x00fe:
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2 = com.duokan.reader.ui.store.bv.m15359c(r0);
        goto L_0x00e5;
    L_0x0109:
        r2 = "2";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00fa;
    L_0x0111:
        r4 = r6;
        goto L_0x00fb;
    L_0x0113:
        r2 = "0";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00fa;
    L_0x011b:
        goto L_0x00fb;
    L_0x011c:
        r2 = "1";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00fa;
    L_0x0124:
        r4 = 2;
        goto L_0x00fb;
    L_0x0126:
        r2 = "10";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00fa;
    L_0x012e:
        r4 = 3;
        goto L_0x00fb;
    L_0x0130:
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2 = com.duokan.reader.ui.store.bv.m15361d(r0);
        goto L_0x00e5;
    L_0x013b:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "cash";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0162;
    L_0x014b:
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2 = com.duokan.reader.ui.store.bv.m15361d(r0);
        r1 = com.duokan.reader.domain.account.PersonalAccount.class;
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r4 = r6;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x0162:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "reward";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0189;
    L_0x0172:
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2 = com.duokan.reader.ui.store.bv.m15362e(r0);
        r1 = com.duokan.reader.domain.account.PersonalAccount.class;
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r4 = r6;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x0189:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "feedback";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x01b1;
    L_0x0199:
        r2 = new com.duokan.reader.ui.personal.az;
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2.<init>(r0, r6);
        r1 = com.duokan.reader.domain.account.MiAccount.class;
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r4 = r6;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x01b1:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "task";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x01ec;
    L_0x01c1:
        r0 = com.duokan.reader.ReaderEnv.get();
        r1 = com.duokan.reader.ReaderEnv.PrivatePref.PERSONAL;
        r2 = "is_in_task_page";
        r0 = r0.getPrefBoolean(r1, r2, r6);
        if (r0 != 0) goto L_0x0054;
    L_0x01cf:
        r0 = r7.f11561b;
        if (r0 == 0) goto L_0x01dc;
    L_0x01d3:
        r0 = r7.f11564e;
        r1 = r7.f11562c;
        r0.m11283a(r1);
        goto L_0x0054;
    L_0x01dc:
        r0 = r7.f11564e;
        r0.m11290j();
        r0 = r7.f11562c;
        if (r0 == 0) goto L_0x0054;
    L_0x01e5:
        r0 = r7.f11562c;
        r0.run();
        goto L_0x0054;
    L_0x01ec:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "purchased";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0238;
    L_0x01fc:
        r0 = com.duokan.reader.domain.account.C0709k.m3476a();
        r0 = r0.m3508d();
        if (r0 == 0) goto L_0x022c;
    L_0x0206:
        r0 = com.duokan.reader.domain.account.C0709k.m3476a();
        r0 = r0.m3508d();
        r0 = r0.mo839i();
        if (r0 != 0) goto L_0x022c;
    L_0x0214:
        r2 = new com.duokan.reader.ui.personal.x;
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2.<init>(r0);
    L_0x021f:
        r1 = com.duokan.reader.domain.account.PersonalAccount.class;
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r4 = r6;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x022c:
        r2 = new com.duokan.reader.ui.personal.ku;
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2.<init>(r0);
        goto L_0x021f;
    L_0x0238:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "notes";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x028f;
    L_0x0248:
        r0 = com.duokan.reader.domain.account.C0709k.m3476a();
        r0 = r0.m3508d();
        if (r0 == 0) goto L_0x0278;
    L_0x0252:
        r0 = com.duokan.reader.domain.account.C0709k.m3476a();
        r0 = r0.m3508d();
        r0 = r0.mo839i();
        if (r0 != 0) goto L_0x0278;
    L_0x0260:
        r2 = new com.duokan.reader.ui.personal.mv;
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2.<init>(r0);
    L_0x026b:
        r1 = com.duokan.reader.domain.account.PersonalAccount.class;
        r3 = r7.f11561b;
        r5 = r7.f11562c;
        r0 = r7;
        r4 = r6;
        r0.m15543a(r1, r2, r3, r4, r5);
        goto L_0x0054;
    L_0x0278:
        r2 = new com.duokan.reader.ui.general.web.StorePageController;
        r0 = r7.f11564e;
        r0 = r0.getContext();
        r2.<init>(r0);
        r0 = com.duokan.reader.common.webservices.duokan.C0641o.m2934i();
        r0 = r0.m2944H();
        r2.loadUrl(r0);
        goto L_0x026b;
    L_0x028f:
        r1 = r7.f11560a;
        r2 = r0 + 1;
        r1 = r1.substring(r2);
        r2 = "settings";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x02b3;
    L_0x029f:
        r0 = new com.duokan.reader.ui.personal.jg;
        r1 = r7.f11564e;
        r1 = r1.getContext();
        r0.<init>(r1);
        r1 = r7.f11561b;
        r2 = r7.f11562c;
        r7.m15541a(r0, r1, r6, r2);
        goto L_0x0054;
    L_0x02b3:
        r1 = r7.f11560a;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r1 = "checkin";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0054;
    L_0x02c3:
        r0 = new com.duokan.reader.ui.bookshelf.ie;
        r1 = r7.f11564e;
        r1 = r1.getContext();
        r0.<init>(r1);
        r1 = r7.f11561b;
        r2 = r7.f11562c;
        r7.m15541a(r0, r1, r6, r2);
        r0 = com.duokan.reader.UmengManager.get();
        r1 = "PERSONAL_CHECK_IN_CLICK_V2";
        r2 = "查看签到";
        r0.onEvent(r1, r2);
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ui.surfing.k.run():void");
    }

    /* renamed from: a */
    private void m15543a(Class<? extends C0672a> cls, ActivatedController c0303e, boolean z, boolean z2, Runnable runnable) {
        if (cls == null) {
            m15541a(c0303e, z, z2, runnable);
        } else {
            C0709k.m3476a().m3497a((Class) cls, new C1525l(this, c0303e, z, z2, runnable));
        }
    }

    /* renamed from: a */
    private void m15541a(ActivatedController c0303e, boolean z, boolean z2, Runnable runnable) {
        if (!z) {
            if (z2) {
                ((ReaderFeature) this.f11564e.getContext().queryFeature(ReaderFeature.class)).pushHalfPage(c0303e);
            } else {
                ((ReaderFeature) this.f11564e.getContext().queryFeature(ReaderFeature.class)).pushPage(c0303e);
            }
            UThread.post(runnable);
        } else if (z2) {
            ((ReaderFeature) this.f11564e.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(c0303e, runnable);
        } else {
            ((ReaderFeature) this.f11564e.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(c0303e, runnable);
        }
    }
}
