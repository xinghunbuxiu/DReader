package com.duokan.reader.domain.payment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.p023b.C0247i;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.duokan.reader.domain.payment.b */
class C1087b extends Handler {
    /* renamed from: a */
    final /* synthetic */ C1089s f5327a;
    /* renamed from: b */
    final /* synthetic */ C1097r f5328b;
    /* renamed from: c */
    final /* synthetic */ Context f5329c;
    /* renamed from: d */
    final /* synthetic */ C1086a f5330d;

    C1087b(C1086a c1086a, Looper looper, C1089s c1089s, C1097r c1097r, Context context) {
        this.f5330d = c1086a;
        this.f5327a = c1089s;
        this.f5328b = c1097r;
        this.f5329c = context;
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
        WebLog.init().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s, result_status: %s, success: %s", new Object[]{this.f5327a.mo1504d(), C1086a.m8357a(this.f5327a.mo1502b()).get("out_trade_no"), str2 + "", str3}));
        if (str2.equals("9000") && str3.equals("true")) {
            this.f5328b.mo1508a(this.f5330d, this.f5327a, str);
        } else {
            this.f5328b.mo1509b(this.f5330d, this.f5327a, this.f5329c.getString(C0247i.bookcity_store__shared__fail_to_pay));
        }
    }
}
