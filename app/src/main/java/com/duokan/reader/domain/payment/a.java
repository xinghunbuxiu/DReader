package com.duokan.reader.domain.payment;

import android.content.Context;
import android.os.Looper;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;

import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class a extends q {
    static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());

    public String a() {
        return "ALIPAY_MOBILE";
    }

    public void a(s sVar, r rVar) {
        com.duokan.core.diagnostic.a.c().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s", new Object[]{sVar.d(), a(sVar.b()).get("out_trade_no")}));
        if (a || rVar != null) {
            Context applicationContext = DkApp.get().getApplicationContext();
            new Thread(new c(this, sVar, new b(this, Looper.getMainLooper(), sVar, rVar, applicationContext), rVar, applicationContext)).start();
            return;
        }
        throw new AssertionError();
    }

    public static Map a(String str) {
        Map linkedHashMap = new LinkedHashMap();
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
