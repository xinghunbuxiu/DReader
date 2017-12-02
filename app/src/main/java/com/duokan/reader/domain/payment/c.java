package com.duokan.reader.domain.payment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.PayTask;
import com.duokan.b.i;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.DkApp;

class c implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ Handler b;
    final /* synthetic */ r c;
    final /* synthetic */ Context d;
    final /* synthetic */ a e;

    c(a aVar, s sVar, Handler handler, r rVar, Context context) {
        this.e = aVar;
        this.a = sVar;
        this.b = handler;
        this.c = rVar;
        this.d = context;
    }

    public void run() {
        Message message;
        try {
            String pay = new PayTask(DkApp.get().getTopActivity()).pay(this.a.b(), true);
            message = new Message();
            message.what = 1;
            message.obj = pay;
            this.b.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            a.c().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s, exception: %s", new Object[]{this.a.d(), a.a(this.a.b()).get("out_trade_no"), e.getClass().getSimpleName()}));
            message = new Message();
            message.what = 0;
            message.obj = e.toString();
            this.b.sendMessage(message);
            this.c.b(this.e, this.a, this.d.getString(i.bookcity_store__shared__alipay_fail_to_connect));
        }
    }
}
