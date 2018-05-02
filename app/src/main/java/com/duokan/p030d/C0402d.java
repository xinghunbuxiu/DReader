package com.duokan.p030d;

import android.content.Context;
import android.os.Build.VERSION;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.d.d */
public class C0402d {
    /* renamed from: a */
    private final Context f1353a;
    /* renamed from: b */
    private C0406h f1354b;

    public C0402d(Context context) {
        this.f1353a = context;
    }

    public C0402d(Context context, C0406h c0406h) {
        this(context);
        this.f1354b = c0406h;
    }

    /* renamed from: a */
    public void m2184a() {
        new C0403e(this).open();
    }

    /* renamed from: b */
    private String m2180b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk", VERSION.SDK_INT);
            jSONObject.put(ClientCookie.VERSION_ATTR, VERSION.INCREMENTAL);
            jSONObject.put("release", VERSION.RELEASE);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    /* renamed from: a */
    public void m2185a(C0406h c0406h) {
        this.f1354b = c0406h;
    }

    /* renamed from: c */
    private int m2181c() {
        int i = 0;
        try {
            return this.f1353a.getPackageManager().getPackageInfo(this.f1353a.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
