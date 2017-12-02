package com.duokan.reader.domain.payment;

import com.duokan.b.i;
import com.duokan.core.sys.ag;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.store.u;
import com.duokan.reader.ui.general.ap;

class m implements ag {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ s c;
    final /* synthetic */ String d;
    final /* synthetic */ u e;
    final /* synthetic */ ag f;
    final /* synthetic */ PaymentManager g;

    m(PaymentManager paymentManager, a aVar, String str, s sVar, String str2, u uVar, ag agVar) {
        this.g = paymentManager;
        this.a = aVar;
        this.b = str;
        this.c = sVar;
        this.d = str2;
        this.e = uVar;
        this.f = agVar;
    }

    public void a(PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.UNVERIFIED) {
            ap nVar = new n(this, DkApp.get().getTopActivity(), paymentResult);
            nVar.setPrompt(i.bookcity_store__shared__notify_repeat_update);
            nVar.setOkLabel(i.bookcity_store__shared__reverify_order_confirm);
            nVar.setCancelLabel(i.bookcity_store__shared__reverify_order_cancel);
            nVar.setCancelOnBack(false);
            nVar.setCancelOnTouchOutside(false);
            nVar.show();
            return;
        }
        this.g.a(this.e.a);
        this.f.a(paymentResult);
    }
}
