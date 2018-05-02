package com.duokan.reader.domain.payment;

import com.duokan.core.sys.ag;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.store.C1195u;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.domain.payment.m */
class C1100m implements ag<PaymentResult> {
    /* renamed from: a */
    final /* synthetic */ C0672a f5356a;
    /* renamed from: b */
    final /* synthetic */ String f5357b;
    /* renamed from: c */
    final /* synthetic */ C1089s f5358c;
    /* renamed from: d */
    final /* synthetic */ String f5359d;
    /* renamed from: e */
    final /* synthetic */ C1195u f5360e;
    /* renamed from: f */
    final /* synthetic */ ag f5361f;
    /* renamed from: g */
    final /* synthetic */ PaymentManager f5362g;

    C1100m(PaymentManager paymentManager, C0672a c0672a, String str, C1089s c1089s, String str2, C1195u c1195u, ag agVar) {
        this.f5362g = paymentManager;
        this.f5356a = c0672a;
        this.f5357b = str;
        this.f5358c = c1089s;
        this.f5359d = str2;
        this.f5360e = c1195u;
        this.f5361f = agVar;
    }

    public /* synthetic */ void run(Object obj) {
        m8384a((PaymentResult) obj);
    }

    /* renamed from: a */
    public void m8384a(PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.UNVERIFIED) {
            ap c1101n = new C1101n(this, DkApp.get().getTopActivity(), paymentResult);
            c1101n.setPrompt(C0247i.bookcity_store__shared__notify_repeat_update);
            c1101n.setOkLabelResid(C0247i.bookcity_store__shared__reverify_order_confirm);
            c1101n.setCancelLabel(C0247i.bookcity_store__shared__reverify_order_cancel);
            c1101n.setCancelOnBack(false);
            c1101n.setCancelOnTouchOutside(false);
            c1101n.show();
            return;
        }
        this.f5362g.m8335a(this.f5360e.f5686a);
        this.f5361f.run(paymentResult);
    }
}
