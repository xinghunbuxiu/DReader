package com.duokan.reader.domain;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.duokan.reader.DkApp;
import com.mipay.sdk.Mipay;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.b */
public class C0797b {
    /* renamed from: a */
    public String f2666a;
    /* renamed from: b */
    public String f2667b;
    /* renamed from: c */
    public String f2668c;
    /* renamed from: d */
    public String f2669d;
    /* renamed from: e */
    public String f2670e;

    /* renamed from: a */
    public static C0797b m3706a(JSONObject jSONObject) {
        C0797b c0797b = new C0797b();
        try {
            c0797b.f2666a = jSONObject.getString("url");
            c0797b.f2667b = jSONObject.getString("data");
            c0797b.f2668c = jSONObject.getString("title");
            c0797b.f2669d = jSONObject.optString("imageUrl");
            c0797b.f2670e = jSONObject.optString(Mipay.KEY_EXTRA);
        } catch (Throwable th) {
        }
        return c0797b;
    }

    /* renamed from: a */
    public void m3707a() {
        if (!TextUtils.isEmpty(this.f2666a) && !TextUtils.isEmpty(this.f2668c)) {
            Intent intent = new Intent("com.miui.personalassistant.action.FAVORITE");
            Bundle bundle = new Bundle();
            bundle.putString("matchComponent", DkApp.get().getPackageName() + "/" + DkApp.get().getReaderActivityClass().getName());
            bundle.putString("targetUrl", this.f2666a);
            bundle.putString("targetData", this.f2667b);
            bundle.putString("targetTitle", this.f2668c);
            if (!TextUtils.isEmpty(this.f2669d)) {
                bundle.putString("targetImage", this.f2669d);
            }
            if (!TextUtils.isEmpty(this.f2670e)) {
                bundle.putString("targetExtra", this.f2670e);
            }
            intent.putExtras(bundle);
            intent.setPackage("com.miui.personalassistant");
            DkApp.get().sendBroadcast(intent, "com.miui.personalassistant.permission.FAVORITE");
        }
    }
}
