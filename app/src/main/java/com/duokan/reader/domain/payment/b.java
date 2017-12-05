package com.duokan.reader.domain.payment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.duokan.b.i;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class b extends Handler {
    final /* synthetic */ s a;
    final /* synthetic */ r b;
    final /* synthetic */ Context c;
    final /* synthetic */ WebLog d;

    b(WebLog aVar, Looper looper, s sVar, r rVar, Context context) {
        this.d = aVar;
        this.a = sVar;
        this.b = rVar;
        this.c = context;
        super(looper);
    }

    public void handleMessage(Message message) {
        String str = (String) message.obj;
        String str2 = "";
        String str3 = "";
        Matcher matcher = Pattern.compile("resultStatus\\=\\{(\\d*)\\}.*success\\=\\\"(\\w*)\\\".*").matcher(str);
        if (matcher.matches()) {
            str2 = matcher.group(1);
            str3 = matcher.group(2);
        }
        a.c().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s, result_status: %s, success: %s", new Object[]{this.a.d(), a.a(this.a.b()).get("out_trade_no"), str2 + "", str3}));
        if (str2.equals("9000") && str3.equals("true")) {
            this.b.a(this.d, this.a, str);
        } else {
            this.b.b(this.d, this.a, this.c.getString(i.bookcity_store__shared__fail_to_pay));
        }
    }
}
