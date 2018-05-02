package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.z */
public class C1084z extends bf {
    /* renamed from: a */
    private String f5308a;
    /* renamed from: b */
    private String f5309b;
    /* renamed from: c */
    private bi f5310c;
    /* renamed from: d */
    private az f5311d;
    /* renamed from: e */
    private long f5312e;
    /* renamed from: f */
    private boolean f5313f;
    /* renamed from: g */
    private long f5314g = 0;
    /* renamed from: h */
    private long f5315h = 0;

    public C1084z(String str, String str2, String str3, String str4, String str5, bi biVar, int i) {
        super(str, str2, str3, 1, i);
        this.f5308a = str4;
        this.f5309b = str5;
        this.f5310c = biVar;
        this.f5311d = null;
        this.f5312e = 0;
        this.f5313f = false;
        m2281a(biVar.m8154d());
    }

    public C1084z(JSONObject jSONObject) {
        super(jSONObject);
    }

    /* renamed from: a */
    protected void mo1489a(JSONObject jSONObject) {
        az azVar = null;
        super.mo1489a(jSONObject);
        this.f5308a = jSONObject.optString("download_file_task_local_file_path");
        this.f5309b = jSONObject.optString("download_file_task_local_temp_file_path");
        JSONObject optJSONObject = jSONObject.optJSONObject("download_file_task_cloud_file_info");
        this.f5310c = optJSONObject == null ? null : new bi(optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("download_file_task_download_data");
        if (optJSONObject2 != null) {
            azVar = new az(optJSONObject2);
        }
        this.f5311d = azVar;
        this.f5312e = jSONObject.optLong("download_file_task_downloaded_length");
        this.f5313f = jSONObject.optBoolean("download_file_task_kss_downloaded");
    }

    /* renamed from: b */
    protected void mo1490b(JSONObject jSONObject) {
        super.mo1490b(jSONObject);
        try {
            jSONObject.put("download_file_task_local_file_path", this.f5308a);
            jSONObject.put("download_file_task_local_temp_file_path", this.f5309b);
            jSONObject.put("download_file_task_cloud_file_info", this.f5310c.m8150a());
            jSONObject.put("download_file_task_download_data", this.f5311d == null ? null : this.f5311d.m8104b());
            jSONObject.put("download_file_task_downloaded_length", this.f5312e);
            jSONObject.put("download_file_task_kss_downloaded", this.f5313f);
        } catch (JSONException e) {
        }
    }

    /* renamed from: w */
    public String m8326w() {
        return this.f5308a;
    }

    /* renamed from: x */
    public String m8327x() {
        return this.f5309b;
    }

    /* renamed from: y */
    public String m8328y() {
        return this.f5310c.m8154d();
    }

    /* renamed from: z */
    public bi m8329z() {
        return this.f5310c;
    }

    /* renamed from: A */
    public az m8314A() {
        return this.f5311d;
    }

    /* renamed from: B */
    public long m8315B() {
        return this.f5312e;
    }

    /* renamed from: C */
    public boolean m8316C() {
        return this.f5313f;
    }

    /* renamed from: a */
    public void m8322a(az azVar) {
        this.f5311d = azVar;
    }

    /* renamed from: D */
    public void m8317D() {
        this.f5314g = System.currentTimeMillis();
        this.f5315h = 0;
    }

    /* renamed from: b */
    public void m8324b(long j, long j2) {
        this.f5312e = j;
        this.f5315h += j2;
    }

    /* renamed from: E */
    public long m8318E() {
        return this.f5314g;
    }

    /* renamed from: F */
    public long m8319F() {
        return this.f5315h;
    }

    /* renamed from: G */
    public void m8320G() {
        this.f5314g = 0;
        this.f5315h = 0;
    }

    /* renamed from: H */
    public void m8321H() {
        this.f5313f = true;
    }
}
