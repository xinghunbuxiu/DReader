package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class z extends bf {
    private String a;
    private String b;
    private bi c;
    private az d;
    private long e;
    private boolean f;
    private long g = 0;
    private long h = 0;

    public z(String str, String str2, String str3, String str4, String str5, bi biVar, int i) {
        super(str, str2, str3, 1, i);
        this.a = str4;
        this.b = str5;
        this.c = biVar;
        this.d = null;
        this.e = 0;
        this.f = false;
        a(biVar.d());
    }

    public z(JSONObject jSONObject) {
        super(jSONObject);
    }

    protected void a(JSONObject jSONObject) {
        az azVar = null;
        super.a(jSONObject);
        this.a = jSONObject.optString("download_file_task_local_file_path");
        this.b = jSONObject.optString("download_file_task_local_temp_file_path");
        JSONObject optJSONObject = jSONObject.optJSONObject("download_file_task_cloud_file_info");
        this.c = optJSONObject == null ? null : new bi(optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("download_file_task_download_data");
        if (optJSONObject2 != null) {
            azVar = new az(optJSONObject2);
        }
        this.d = azVar;
        this.e = jSONObject.optLong("download_file_task_downloaded_length");
        this.f = jSONObject.optBoolean("download_file_task_kss_downloaded");
    }

    protected void b(JSONObject jSONObject) {
        super.b(jSONObject);
        try {
            jSONObject.put("download_file_task_local_file_path", this.a);
            jSONObject.put("download_file_task_local_temp_file_path", this.b);
            jSONObject.put("download_file_task_cloud_file_info", this.c.a());
            jSONObject.put("download_file_task_download_data", this.d == null ? null : this.d.b());
            jSONObject.put("download_file_task_downloaded_length", this.e);
            jSONObject.put("download_file_task_kss_downloaded", this.f);
        } catch (JSONException e) {
        }
    }

    public String w() {
        return this.a;
    }

    public String x() {
        return this.b;
    }

    public String y() {
        return this.c.d();
    }

    public bi z() {
        return this.c;
    }

    public az A() {
        return this.d;
    }

    public long B() {
        return this.e;
    }

    public boolean C() {
        return this.f;
    }

    public void a(az azVar) {
        this.d = azVar;
    }

    public void D() {
        this.g = System.currentTimeMillis();
        this.h = 0;
    }

    public void b(long j, long j2) {
        this.e = j;
        this.h += j2;
    }

    public long E() {
        return this.g;
    }

    public long F() {
        return this.h;
    }

    public void G() {
        this.g = 0;
        this.h = 0;
    }

    public void H() {
        this.f = true;
    }
}
