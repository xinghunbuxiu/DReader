package com.duokan.reader.common.async.work;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.async.work.e */
public class C0525e {
    /* renamed from: a */
    public final boolean f1773a;
    /* renamed from: b */
    public final boolean f1774b;
    /* renamed from: c */
    public final int f1775c;
    /* renamed from: d */
    public final String f1776d;
    /* renamed from: e */
    public final boolean f1777e;
    /* renamed from: f */
    public final boolean f1778f;

    private C0525e(boolean z, boolean z2, int i, String str, boolean z3, boolean z4) {
        this.f1773a = z;
        this.f1774b = z2;
        this.f1775c = i;
        this.f1776d = str;
        this.f1777e = z3;
        this.f1778f = z4;
    }

    private C0525e(JSONObject jSONObject) {
        this.f1773a = jSONObject.optBoolean("work_result_ok");
        this.f1774b = jSONObject.optBoolean("work_result_user_canceled");
        this.f1775c = jSONObject.optInt("work_result_code");
        this.f1776d = jSONObject.optString("work_result_description");
        this.f1777e = jSONObject.optBoolean("work_result_recoverable");
        this.f1778f = jSONObject.optBoolean("work_result_auto_retriable");
    }

    /* renamed from: a */
    public JSONObject m2312a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("work_result_ok", this.f1773a);
            jSONObject.put("work_result_user_canceled", this.f1774b);
            jSONObject.put("work_result_code", this.f1775c);
            jSONObject.put("work_result_description", this.f1776d);
            jSONObject.put("work_result_recoverable", this.f1777e);
            jSONObject.put("work_result_auto_retriable", this.f1778f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    public boolean m2313b() {
        return this.f1773a;
    }

    /* renamed from: c */
    public boolean m2314c() {
        return this.f1774b;
    }

    /* renamed from: a */
    public static C0525e m2309a(int i, boolean z, boolean z2) {
        return new C0525e(true, false, i, "", z, z2);
    }

    /* renamed from: b */
    public static C0525e m2310b(int i, boolean z, boolean z2) {
        return new C0525e(false, true, i, "", z, z2);
    }

    /* renamed from: c */
    public static C0525e m2311c(int i, boolean z, boolean z2) {
        return new C0525e(false, false, i, "", z, z2);
    }

    /* renamed from: a */
    public static C0525e m2308a(int i, String str, boolean z, boolean z2) {
        return new C0525e(false, false, i, str, z, z2);
    }
}
