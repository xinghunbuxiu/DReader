package com.duokan.p030d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;


public class C0402d {

    private final Context context;
    
    private C0406h f1354b;

    public C0402d(Context context) {
        this.context = context;
    }

    public C0402d(Context context, C0406h c0406h) {
        this(context);
        this.f1354b = c0406h;
    }


    public void m2184a() {
        new C0403e(this).open();
    }


    private String getMobileInfo() {
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


    public void m2185a(C0406h c0406h) {
        this.f1354b = c0406h;
    }


    private int getVersionCode() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
