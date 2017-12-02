package com.duokan.reader.common.async.work;

import android.util.Pair;

import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private final JSONObject a;
    private String b;
    private int c;
    private int d;
    private String e;
    private JSONObject f;
    private int g;
    private Pair h;
    private e i;
    private long j;
    private long k;
    private JSONObject l;

    public c(String str, int i, int i2) {
        this.i = null;
        this.a = new JSONObject();
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = null;
        this.f = new JSONObject();
        this.g = 0;
        this.h = new Pair(Long.valueOf(0), Long.valueOf(0));
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.l = new JSONObject();
    }

    public c(JSONObject jSONObject) {
        long optLong;
        long j = 0;
        this.i = null;
        this.a = jSONObject;
        this.b = jSONObject.optString("work_item_local_id");
        this.c = jSONObject.optInt("work_item_type");
        this.d = jSONObject.optInt("work_item_max_retry_times");
        this.e = jSONObject.optString("work_item_cloud_id");
        this.f = jSONObject.optJSONObject("work_item_type_details");
        a(this.f);
        this.g = jSONObject.optInt("work_item_status");
        JSONObject optJSONObject = jSONObject.optJSONObject("work_item_progress");
        if (optJSONObject != null) {
            optLong = optJSONObject.optLong("work_item_progress_numerator");
            j = optJSONObject.optLong("work_item_progress_denominator");
        } else {
            optLong = 0;
        }
        this.h = new Pair(Long.valueOf(optLong), Long.valueOf(j));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("work_item_execution_result");
        this.i = optJSONObject2 == null ? null : new e(optJSONObject2);
        this.j = jSONObject.optLong("work_item_start_time");
        this.k = jSONObject.optLong("work_item_end_time");
        this.l = jSONObject.optJSONObject("work_item_extension_data");
    }

    protected void a(JSONObject jSONObject) {
    }

    public final JSONObject a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final int f() {
        return this.g;
    }

    public final boolean g() {
        return this.g == 1;
    }

    public final boolean h() {
        return this.g == 2;
    }

    public final Pair i() {
        return this.h;
    }

    public final boolean j() {
        return this.g == 4 || this.g == 3;
    }

    public final boolean k() {
        return this.g == 3;
    }

    public final boolean l() {
        return this.g == 5;
    }

    public final boolean m() {
        return this.g == 6;
    }

    public final boolean n() {
        return this.g == 7;
    }

    public final boolean o() {
        return this.g == 1 || this.g == 2;
    }

    public final synchronized boolean p() {
        boolean z = true;
        synchronized (this) {
            if (this.g == 1 || this.g == 2) {
                z = false;
            } else if (this.g == 0) {
                this.j = System.currentTimeMillis();
                this.g = 1;
                this.i = null;
            } else if (this.g == 3 || this.g == 4) {
                this.g = 1;
                this.i = null;
            } else if (this.g == 6 && (this.i == null || this.i.e)) {
                this.g = 1;
                this.i = null;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean q() {
        boolean z = true;
        synchronized (this) {
            if (this.g == 1) {
                this.g = 2;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized void a(long j, long j2) {
        this.h = new Pair(Long.valueOf(j), Long.valueOf(j2));
    }

    public final synchronized boolean a(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.g == 0 || this.g == 1 || this.g == 2) {
                int i;
                if (z) {
                    i = 4;
                } else {
                    i = 3;
                }
                this.g = i;
                z2 = true;
            } else if (this.g != 4 && this.g == 3 && z) {
                this.g = 4;
                z2 = true;
            }
        }
        return z2;
    }

    public final synchronized boolean a(e eVar) {
        boolean z = true;
        synchronized (this) {
            if (this.g == 1 || this.g == 2 || this.g == 3 || this.g == 4) {
                this.g = 5;
                this.i = eVar;
                this.k = System.currentTimeMillis();
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean b(e eVar) {
        boolean z = true;
        synchronized (this) {
            if (this.g == 1 || this.g == 2 || this.g == 3 || this.g == 4) {
                this.g = 6;
                this.i = eVar;
                this.k = System.currentTimeMillis();
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean r() {
        boolean z;
        if (this.g == 5) {
            z = false;
        } else {
            this.g = 7;
            this.i = null;
            this.k = System.currentTimeMillis();
            z = true;
        }
        return z;
    }

    public final long s() {
        return this.j;
    }

    public final long t() {
        return this.k;
    }

    public final JSONObject u() {
        return this.l;
    }

    public final synchronized void v() {
        try {
            Object obj;
            this.a.put("work_item_local_id", this.b);
            this.a.put("work_item_type", this.c);
            this.a.put("work_item_max_retry_times", this.d);
            this.a.put("work_item_cloud_id", this.e);
            b(this.f);
            this.a.put("work_item_type_details", this.f);
            this.a.put("work_item_status", this.g);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("work_item_progress_numerator", ((Long) this.h.first).longValue());
            jSONObject.put("work_item_progress_denominator", ((Long) this.h.second).longValue());
            this.a.put("work_item_progress", jSONObject);
            jSONObject = this.a;
            String str = "work_item_execution_result";
            if (this.i == null) {
                obj = null;
            } else {
                obj = this.i.a();
            }
            jSONObject.put(str, obj);
            this.a.put("work_item_start_time", this.j);
            this.a.put("work_item_end_time", this.k);
            this.a.put("work_item_extension_data", this.l);
        } catch (JSONException e) {
        }
    }

    protected void b(JSONObject jSONObject) {
    }
}
