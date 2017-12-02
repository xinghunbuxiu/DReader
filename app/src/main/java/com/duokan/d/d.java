package com.duokan.d;

import android.content.Context;
import android.os.Build.VERSION;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private final Context a;
    private i b;

    public d(Context context) {
        this.a = context;
    }

    public d(Context context, i iVar) {
        this(context);
        this.b = iVar;
    }

    public void a() {
        new f().open();
    }

    private String b() {
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

    public void a(i iVar) {
        this.b = iVar;
    }

    private int c() {
        int i = 0;
        try {
            return this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
