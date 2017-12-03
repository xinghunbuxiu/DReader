package com.duokan.d;

import android.content.Context;
import android.os.Build.VERSION;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private final Context context;
    private i b;
    MyWebSession myWebSession;

    public d(Context context) {
        this.context = context;
    }

    public d(Context context, i iVar) {
        this(context);
        this.b = iVar;
    }

    public void a() {
        myWebSession = new MyWebSession(this);
        myWebSession.open();
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
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
