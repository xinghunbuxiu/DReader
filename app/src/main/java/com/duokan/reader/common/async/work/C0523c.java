package com.duokan.reader.common.async.work;

import android.util.Pair;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.async.work.c */
public class C0523c {
    /* renamed from: a */
    private final JSONObject f1761a;
    /* renamed from: b */
    private String f1762b;
    /* renamed from: c */
    private int f1763c;
    /* renamed from: d */
    private int f1764d;
    /* renamed from: e */
    private String f1765e;
    /* renamed from: f */
    private JSONObject f1766f;
    /* renamed from: g */
    private int f1767g;
    /* renamed from: h */
    private Pair<Long, Long> f1768h;
    /* renamed from: i */
    private C0525e f1769i;
    /* renamed from: j */
    private long f1770j;
    /* renamed from: k */
    private long f1771k;
    /* renamed from: l */
    private JSONObject f1772l;

    public C0523c(String str, int i, int i2) {
        this.f1769i = null;
        this.f1761a = new JSONObject();
        this.f1762b = str;
        this.f1763c = i;
        this.f1764d = i2;
        this.f1765e = null;
        this.f1766f = new JSONObject();
        this.f1767g = 0;
        this.f1768h = new Pair(Long.valueOf(0), Long.valueOf(0));
        this.f1769i = null;
        this.f1770j = 0;
        this.f1771k = 0;
        this.f1772l = new JSONObject();
    }

    public C0523c(JSONObject jSONObject) {
        long optLong;
        long j = 0;
        this.f1769i = null;
        this.f1761a = jSONObject;
        this.f1762b = jSONObject.optString("work_item_local_id");
        this.f1763c = jSONObject.optInt("work_item_type");
        this.f1764d = jSONObject.optInt("work_item_max_retry_times");
        this.f1765e = jSONObject.optString("work_item_cloud_id");
        this.f1766f = jSONObject.optJSONObject("work_item_type_details");
        mo1489a(this.f1766f);
        this.f1767g = jSONObject.optInt("work_item_status");
        JSONObject optJSONObject = jSONObject.optJSONObject("work_item_progress");
        if (optJSONObject != null) {
            optLong = optJSONObject.optLong("work_item_progress_numerator");
            j = optJSONObject.optLong("work_item_progress_denominator");
        } else {
            optLong = 0;
        }
        this.f1768h = new Pair(Long.valueOf(optLong), Long.valueOf(j));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("work_item_execution_result");
        this.f1769i = optJSONObject2 == null ? null : new C0525e(optJSONObject2);
        this.f1770j = jSONObject.optLong("work_item_start_time");
        this.f1771k = jSONObject.optLong("work_item_end_time");
        this.f1772l = jSONObject.optJSONObject("work_item_extension_data");
    }

    /* renamed from: a */
    protected void mo1489a(JSONObject jSONObject) {
    }

    /* renamed from: a */
    public final JSONObject m2279a() {
        return this.f1761a;
    }

    /* renamed from: b */
    public String m2285b() {
        return this.f1762b;
    }

    /* renamed from: c */
    public int m2288c() {
        return this.f1763c;
    }

    /* renamed from: d */
    public int m2289d() {
        return this.f1764d;
    }

    /* renamed from: e */
    public final String m2290e() {
        return this.f1765e;
    }

    /* renamed from: a */
    public final void m2281a(String str) {
        this.f1765e = str;
    }

    /* renamed from: f */
    public final int m2291f() {
        return this.f1767g;
    }

    /* renamed from: g */
    public final boolean m2292g() {
        return this.f1767g == 1;
    }

    /* renamed from: h */
    public final boolean m2293h() {
        return this.f1767g == 2;
    }

    /* renamed from: i */
    public final Pair<Long, Long> m2294i() {
        return this.f1768h;
    }

    /* renamed from: j */
    public final boolean m2295j() {
        return this.f1767g == 4 || this.f1767g == 3;
    }

    /* renamed from: k */
    public final boolean m2296k() {
        return this.f1767g == 3;
    }

    /* renamed from: l */
    public final boolean m2297l() {
        return this.f1767g == 5;
    }

    /* renamed from: m */
    public final boolean m2298m() {
        return this.f1767g == 6;
    }

    /* renamed from: n */
    public final boolean m2299n() {
        return this.f1767g == 7;
    }

    /* renamed from: o */
    public final boolean m2300o() {
        return this.f1767g == 1 || this.f1767g == 2;
    }

    /* renamed from: p */
    public final synchronized boolean m2301p() {
        boolean z = true;
        synchronized (this) {
            if (this.f1767g == 1 || this.f1767g == 2) {
                z = false;
            } else if (this.f1767g == 0) {
                this.f1770j = System.currentTimeMillis();
                this.f1767g = 1;
                this.f1769i = null;
            } else if (this.f1767g == 3 || this.f1767g == 4) {
                this.f1767g = 1;
                this.f1769i = null;
            } else if (this.f1767g == 6 && (this.f1769i == null || this.f1769i.f1777e)) {
                this.f1767g = 1;
                this.f1769i = null;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: q */
    public final synchronized boolean m2302q() {
        boolean z = true;
        synchronized (this) {
            if (this.f1767g == 1) {
                this.f1767g = 2;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized void m2280a(long j, long j2) {
        this.f1768h = new Pair(Long.valueOf(j), Long.valueOf(j2));
    }

    /* renamed from: a */
    public final synchronized boolean m2284a(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.f1767g == 0 || this.f1767g == 1 || this.f1767g == 2) {
                int i;
                if (z) {
                    i = 4;
                } else {
                    i = 3;
                }
                this.f1767g = i;
                z2 = true;
            } else if (this.f1767g != 4 && this.f1767g == 3 && z) {
                this.f1767g = 4;
                z2 = true;
            }
        }
        return z2;
    }

    /* renamed from: a */
    public final synchronized boolean m2283a(C0525e c0525e) {
        boolean z = true;
        synchronized (this) {
            if (this.f1767g == 1 || this.f1767g == 2 || this.f1767g == 3 || this.f1767g == 4) {
                this.f1767g = 5;
                this.f1769i = c0525e;
                this.f1771k = System.currentTimeMillis();
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized boolean m2287b(C0525e c0525e) {
        boolean z = true;
        synchronized (this) {
            if (this.f1767g == 1 || this.f1767g == 2 || this.f1767g == 3 || this.f1767g == 4) {
                this.f1767g = 6;
                this.f1769i = c0525e;
                this.f1771k = System.currentTimeMillis();
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: r */
    public final synchronized boolean m2303r() {
        boolean z;
        if (this.f1767g == 5) {
            z = false;
        } else {
            this.f1767g = 7;
            this.f1769i = null;
            this.f1771k = System.currentTimeMillis();
            z = true;
        }
        return z;
    }

    /* renamed from: s */
    public final long m2304s() {
        return this.f1770j;
    }

    /* renamed from: t */
    public final long m2305t() {
        return this.f1771k;
    }

    /* renamed from: u */
    public final JSONObject m2306u() {
        return this.f1772l;
    }

    /* renamed from: v */
    public final synchronized void m2307v() {
        try {
            Object obj;
            this.f1761a.put("work_item_local_id", this.f1762b);
            this.f1761a.put("work_item_type", this.f1763c);
            this.f1761a.put("work_item_max_retry_times", this.f1764d);
            this.f1761a.put("work_item_cloud_id", this.f1765e);
            mo1490b(this.f1766f);
            this.f1761a.put("work_item_type_details", this.f1766f);
            this.f1761a.put("work_item_status", this.f1767g);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("work_item_progress_numerator", ((Long) this.f1768h.first).longValue());
            jSONObject.put("work_item_progress_denominator", ((Long) this.f1768h.second).longValue());
            this.f1761a.put("work_item_progress", jSONObject);
            jSONObject = this.f1761a;
            String str = "work_item_execution_result";
            if (this.f1769i == null) {
                obj = null;
            } else {
                obj = this.f1769i.m2312a();
            }
            jSONObject.put(str, obj);
            this.f1761a.put("work_item_start_time", this.f1770j);
            this.f1761a.put("work_item_end_time", this.f1771k);
            this.f1761a.put("work_item_extension_data", this.f1772l);
        } catch (JSONException e) {
        }
    }

    /* renamed from: b */
    protected void mo1490b(JSONObject jSONObject) {
    }
}
