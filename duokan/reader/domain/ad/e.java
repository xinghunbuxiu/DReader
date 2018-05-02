package com.duokan.reader.domain.ad;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class e {
    public static int a = 1;
    public static int b = 2;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public long i;
    public List j;
    public List k;
    public List l;
    public List m;
    public List n;
    public List o;
    public String p;
    public String q;
    public String r;
    public String s;
    public boolean t = false;
    public boolean u = false;
    public List v;
    public int w;

    private e() {
    }

    public static e a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            e eVar = new e();
            eVar.c = jSONObject.optString("id");
            eVar.e = jSONObject.optString("summary");
            eVar.f = jSONObject.optString("landingPageUrl");
            eVar.d = jSONObject.optString("title");
            eVar.h = jSONObject.optInt("targetType");
            eVar.g = jSONObject.optInt("adStyle");
            eVar.k = a(jSONObject.optJSONArray("clickMonitorUrls"));
            eVar.j = a(jSONObject.optJSONArray("viewMonitorUrls"));
            eVar.l = a(jSONObject.optJSONArray("startDownloadMonitorUrls"));
            eVar.o = a(jSONObject.optJSONArray("finishInstallMonitorUrls"));
            eVar.n = a(jSONObject.optJSONArray("startInstallMonitorUrls"));
            eVar.m = a(jSONObject.optJSONArray("finishDownloadMonitorUrls"));
            eVar.r = jSONObject.optString("packageName");
            eVar.p = jSONObject.optString("actionUrl");
            eVar.q = jSONObject.optString("iconUrl");
            eVar.s = jSONObject.optString("brand");
            eVar.v = f.a(jSONObject.optJSONArray("assets"));
            eVar.i = jSONObject.optJSONObject("adControl").optLong("duration", 0);
            return eVar;
        } catch (Throwable th) {
            return null;
        }
    }

    private static List a(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    arrayList.add(jSONArray.getString(i));
                    i++;
                } catch (Throwable th) {
                }
            }
        }
        return arrayList;
    }

    public static e a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.e);
    }

    public String toString() {
        return this.c + " -> " + this.d + " -> " + this.e + " -> " + this.s + " -> " + this.g;
    }
}
