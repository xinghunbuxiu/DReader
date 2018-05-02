package com.duokan.reader.common.async.work;

import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final String d;
    public final boolean e;
    public final boolean f;

    private e(boolean z, boolean z2, int i, String str, boolean z3, boolean z4) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = str;
        this.e = z3;
        this.f = z4;
    }

    private e(JSONObject jSONObject) {
        this.a = jSONObject.optBoolean("work_result_ok");
        this.b = jSONObject.optBoolean("work_result_user_canceled");
        this.c = jSONObject.optInt("work_result_code");
        this.d = jSONObject.optString("work_result_description");
        this.e = jSONObject.optBoolean("work_result_recoverable");
        this.f = jSONObject.optBoolean("work_result_auto_retriable");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("work_result_ok", this.a);
            jSONObject.put("work_result_user_canceled", this.b);
            jSONObject.put("work_result_code", this.c);
            jSONObject.put("work_result_description", this.d);
            jSONObject.put("work_result_recoverable", this.e);
            jSONObject.put("work_result_auto_retriable", this.f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public static e a(int i, boolean z, boolean z2) {
        return new e(true, false, i, "", z, z2);
    }

    public static e b(int i, boolean z, boolean z2) {
        return new e(false, true, i, "", z, z2);
    }

    public static e c(int i, boolean z, boolean z2) {
        return new e(false, false, i, "", z, z2);
    }

    public static e a(int i, String str, boolean z, boolean z2) {
        return new e(false, false, i, str, z, z2);
    }
}
