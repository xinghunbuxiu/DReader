package com.duokan.reader.domain.payment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.app.PayTask;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;

/* renamed from: com.duokan.reader.domain.payment.c */
class C1088c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1089s f5331a;
    /* renamed from: b */
    final /* synthetic */ Handler f5332b;
    /* renamed from: c */
    final /* synthetic */ C1097r f5333c;
    /* renamed from: d */
    final /* synthetic */ Context f5334d;
    /* renamed from: e */
    final /* synthetic */ C1086a f5335e;

    C1088c(C1086a c1086a, C1089s c1089s, Handler handler, C1097r c1097r, Context context) {
        this.f5335e = c1086a;
        this.f5331a = c1089s;
        this.f5332b = handler;
        this.f5333c = c1097r;
        this.f5334d = context;
    }

    public void run() {
        Message message;
        try {
            String pay = new PayTask(DkApp.get().getTopActivity()).pay(this.f5331a.mo1502b(), true);
            message = new Message();
            message.what = 1;
            message.obj = pay;
            this.f5332b.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            WebLog.init().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s, exception: %s", new Object[]{this.f5331a.mo1504d(), C1086a.m8357a(this.f5331a.mo1502b()).get("out_trade_no"), e.getClass().getSimpleName()}));
            message = new Message();
            message.what = 0;
            message.obj = e.toString();
            this.f5332b.sendMessage(message);
            this.f5333c.mo1509b(this.f5335e, this.f5331a, this.f5334d.getString(C0247i.bookcity_store__shared__alipay_fail_to_connect));
        }
    }
}
