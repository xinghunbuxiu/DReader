package com.duokan.reader.domain.ad;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.ad.e */
public class C0748e {
    /* renamed from: a */
    public static int f2516a = 1;
    /* renamed from: b */
    public static int f2517b = 2;
    /* renamed from: c */
    public String f2518c;
    /* renamed from: d */
    public String f2519d;
    /* renamed from: e */
    public String f2520e;
    /* renamed from: f */
    public String f2521f;
    /* renamed from: g */
    public int f2522g;
    /* renamed from: h */
    public int f2523h;
    /* renamed from: i */
    public long f2524i;
    /* renamed from: j */
    public List<String> f2525j;
    /* renamed from: k */
    public List<String> f2526k;
    /* renamed from: l */
    public List<String> f2527l;
    /* renamed from: m */
    public List<String> f2528m;
    /* renamed from: n */
    public List<String> f2529n;
    /* renamed from: o */
    public List<String> f2530o;
    /* renamed from: p */
    public String f2531p;
    /* renamed from: q */
    public String f2532q;
    /* renamed from: r */
    public String f2533r;
    /* renamed from: s */
    public String f2534s;
    /* renamed from: t */
    public String f2535t = "";
    /* renamed from: u */
    public boolean f2536u = false;
    /* renamed from: v */
    public boolean f2537v = false;
    /* renamed from: w */
    public List<C0749f> f2538w;
    /* renamed from: x */
    public int f2539x;

    private C0748e() {
    }

    /* renamed from: a */
    public static C0748e m3556a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            C0748e c0748e = new C0748e();
            c0748e.f2518c = jSONObject.optString("id");
            c0748e.f2520e = jSONObject.optString("summary");
            c0748e.f2521f = jSONObject.optString("landingPageUrl");
            c0748e.f2519d = jSONObject.optString("title");
            c0748e.f2523h = jSONObject.optInt("targetType");
            c0748e.f2522g = jSONObject.optInt("adStyle");
            c0748e.f2535t = jSONObject.optString("appChannel");
            c0748e.f2526k = C0748e.m3557a(jSONObject.optJSONArray("clickMonitorUrls"));
            c0748e.f2525j = C0748e.m3557a(jSONObject.optJSONArray("viewMonitorUrls"));
            c0748e.f2527l = C0748e.m3557a(jSONObject.optJSONArray("startDownloadMonitorUrls"));
            c0748e.f2530o = C0748e.m3557a(jSONObject.optJSONArray("finishInstallMonitorUrls"));
            c0748e.f2529n = C0748e.m3557a(jSONObject.optJSONArray("startInstallMonitorUrls"));
            c0748e.f2528m = C0748e.m3557a(jSONObject.optJSONArray("finishDownloadMonitorUrls"));
            c0748e.f2533r = jSONObject.optString("packageName");
            c0748e.f2531p = jSONObject.optString("actionUrl");
            c0748e.f2532q = jSONObject.optString("iconUrl");
            c0748e.f2534s = jSONObject.optString("brand");
            c0748e.f2538w = C0749f.m3560a(jSONObject.optJSONArray("assets"));
            c0748e.f2524i = jSONObject.optJSONObject("adControl").optLong("duration", 0);
            return c0748e;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    private static List<String> m3557a(JSONArray jSONArray) {
        List<String> arrayList = new ArrayList();
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

    /* renamed from: a */
    public static C0748e m3555a(String str) {
        try {
            return C0748e.m3556a(new JSONObject(str));
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    public boolean m3558a() {
        return !TextUtils.isEmpty(this.f2520e);
    }

    public String toString() {
        return this.f2518c + " -> " + this.f2519d + " -> " + this.f2520e + " -> " + this.f2534s + " -> " + this.f2522g;
    }
}
