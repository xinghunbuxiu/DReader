package com.duokan.reader.domain.payment;

import android.content.Context;
import android.os.Looper;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.reader.domain.payment.a */
public class C1086a extends C1085q {
    /* renamed from: a */
    static final /* synthetic */ boolean f5326a = (!C1086a.class.desiredAssertionStatus());

    /* renamed from: a */
    public String mo1499a() {
        return "ALIPAY_MOBILE";
    }

    /* renamed from: a */
    public void mo1500a(C1089s c1089s, C1097r c1097r) {
        WebLog.init().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s", new Object[]{c1089s.mo1504d(), C1086a.m8357a(c1089s.mo1502b()).get("out_trade_no")}));
        if (f5326a || c1097r != null) {
            Context applicationContext = DkApp.get().getApplicationContext();
            new Thread(new C1088c(this, c1089s, new C1087b(this, Looper.getMainLooper(), c1089s, c1097r, applicationContext), c1097r, applicationContext)).start();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static Map<String, String> m8357a(String str) {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=");
            try {
                linkedHashMap.put(URLDecoder.decode(str2.substring(0, indexOf), HTTP.UTF_8), URLDecoder.decode(str2.substring(indexOf + 1), HTTP.UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return linkedHashMap;
    }
}
