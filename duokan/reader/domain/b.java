package com.duokan.reader.domain;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.duokan.reader.DkApp;
import com.mipay.sdk.Mipay;

import org.json.JSONObject;

public class b {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        try {
            bVar.a = jSONObject.getString("url");
            bVar.b = jSONObject.getString("data");
            bVar.c = jSONObject.getString("title");
            bVar.d = jSONObject.optString("imageUrl");
            bVar.e = jSONObject.optString(Mipay.KEY_EXTRA);
        } catch (Throwable th) {
        }
        return bVar;
    }

    public void a() {
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.c)) {
            Intent intent = new Intent("com.miui.personalassistant.action.FAVORITE");
            Bundle bundle = new Bundle();
            bundle.putString("matchComponent", DkApp.get().getPackageName() + "/" + DkApp.get().getReaderActivityClass().getName());
            bundle.putString("targetUrl", this.a);
            bundle.putString("targetData", this.b);
            bundle.putString("targetTitle", this.c);
            if (!TextUtils.isEmpty(this.d)) {
                bundle.putString("targetImage", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                bundle.putString("targetExtra", this.e);
            }
            intent.putExtras(bundle);
            intent.setPackage("com.miui.personalassistant");
            DkApp.get().sendBroadcast(intent, "com.miui.personalassistant.permission.FAVORITE");
        }
    }
}
