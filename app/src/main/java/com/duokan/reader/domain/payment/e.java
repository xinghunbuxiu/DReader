package com.duokan.reader.domain.payment;

import android.app.Activity;
import android.os.Bundle;

import com.alipay.android.client.BaseHelper;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.b.a;

import org.json.JSONObject;

public class e {
    static final /* synthetic */ boolean a = (!e.class.desiredAssertionStatus());

    public static void a(Activity activity, s sVar, i iVar) {
        if (!a && activity == null) {
            throw new AssertionError();
        } else if (a || iVar != null) {
            Bundle bundle = new Bundle();
            JSONObject string2JSON = BaseHelper.string2JSON(sVar.b() + "&senderSign=" + sVar.c(), "&");
            a a = com.duokan.reader.common.b.e.a(activity);
            com.duokan.core.diagnostic.a.c().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s", new Object[]{sVar.d(), sVar.a()}));
            a.a(activity, sVar.a(), string2JSON.toString(), bundle, new f(sVar, iVar, activity));
        } else {
            throw new AssertionError();
        }
    }
}
