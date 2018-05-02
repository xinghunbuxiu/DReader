package com.duokan.reader.domain.payment;

import android.app.Activity;
import android.os.Bundle;
import com.alipay.android.client.BaseHelper;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.payment.e */
public class C1091e {
    /* renamed from: a */
    static final /* synthetic */ boolean f5340a = (!C1091e.class.desiredAssertionStatus());

    /* renamed from: a */
    public static void m8369a(Activity activity, C1089s c1089s, C1094i c1094i) {
        if (!f5340a && activity == null) {
            throw new AssertionError();
        } else if (f5340a || c1094i != null) {
            Bundle bundle = new Bundle();
            JSONObject string2JSON = BaseHelper.string2JSON(c1089s.mo1502b() + "&senderSign=" + c1089s.mo1503c(), "&");
            C0538a a = C0542e.m2411a(activity);
            WebLog.init().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s", new Object[]{c1089s.mo1504d(), c1089s.mo1501a()}));
            a.m2394a(activity, c1089s.mo1501a(), string2JSON.toString(), bundle, new C1092f(c1089s, c1094i, activity));
        } else {
            throw new AssertionError();
        }
    }
}
