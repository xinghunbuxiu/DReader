package com.duokan.reader.domain.micloud;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class i extends bf {
    private String a;
    private String b;
    private String c;
    private ah d;
    private long e;
    private long f;
    private String g;
    private String h;
    private bh i;
    private long j;
    private ai k;
    private bi l;
    private long m;
    private long n;

    public i(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        super(str, str2, str3, 0, i);
        this.a = str4;
        this.b = str5;
        this.c = str6;
        this.h = "";
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = null;
    }

    public i(JSONObject jSONObject) {
        super(jSONObject);
    }

    protected void a(JSONObject jSONObject) {
        bi biVar = null;
        super.a(jSONObject);
        this.a = jSONObject.optString("create_file_task_local_file_path");
        this.b = jSONObject.optString("create_file_task_cloud_file_parent_path");
        this.c = jSONObject.optString("create_file_task_cloud_file_name");
        if (TextUtils.isEmpty(this.c)) {
            this.c = new File(this.a).getName();
        }
        this.h = jSONObject.optString("create_file_task_cloud_parent_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("create_file_task_file_block_infos");
        this.d = optJSONObject == null ? null : new ah(optJSONObject);
        this.e = jSONObject.optLong("create_file_task_last_modified_time");
        this.f = jSONObject.optLong("create_file_task_file_size");
        this.g = jSONObject.optString("create_file_task_file_sha1");
        optJSONObject = jSONObject.optJSONObject("create_file_task_upload_data");
        this.i = optJSONObject == null ? null : new bh(optJSONObject);
        this.j = jSONObject.optLong("create_file_task_uploaded_length");
        optJSONObject = jSONObject.optJSONObject("create_file_task_commit_data");
        this.k = optJSONObject == null ? null : new ai(optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("create_file_task_cloud_file_info");
        if (optJSONObject2 != null) {
            biVar = new bi(optJSONObject2);
        }
        this.l = biVar;
    }

    protected void b(JSONObject jSONObject) {
        Object obj = null;
        super.b(jSONObject);
        try {
            jSONObject.put("create_file_task_local_file_path", this.a);
            jSONObject.put("create_file_task_cloud_file_parent_path", this.b);
            jSONObject.put("create_file_task_cloud_file_name", this.c);
            jSONObject.put("create_file_task_cloud_parent_id", this.h);
            jSONObject.put("create_file_task_file_block_infos", this.d == null ? null : this.d.a());
            jSONObject.put("create_file_task_last_modified_time", this.e);
            jSONObject.put("create_file_task_file_size", this.f);
            jSONObject.put("create_file_task_file_sha1", this.g);
            jSONObject.put("create_file_task_upload_data", this.i == null ? null : this.i.c());
            jSONObject.put("create_file_task_uploaded_length", this.j);
            jSONObject.put("create_file_task_commit_data", this.k == null ? null : this.k.a());
            String str = "create_file_task_cloud_file_info";
            if (this.l != null) {
                obj = this.l.a();
            }
            jSONObject.put(str, obj);
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
        return this.c;
    }

    public String z() {
        return this.h;
    }

    public void b(String str) {
        this.h = str;
    }

    public ah A() {
        return this.d;
    }

    public long B() {
        return this.e;
    }

    public long C() {
        return this.f;
    }

    public void a(long j) {
        this.f = j;
    }

    public String D() {
        return this.g;
    }

    public bh E() {
        return this.i;
    }

    public long F() {
        return this.j;
    }

    public ai G() {
        return this.k;
    }

    public bi H() {
        return this.l;
    }

    public void a(long j, long j2, ah ahVar, String str) {
        this.e = j;
        this.f = j2;
        this.d = ahVar;
        this.g = str;
    }

    public void a(bh bhVar) {
        this.i = bhVar;
    }

    public void I() {
        this.m = System.currentTimeMillis();
        this.n = 0;
    }

    public void b(long j, long j2) {
        this.j = j;
        this.n += j2;
    }

    public long J() {
        return this.m;
    }

    public long K() {
        return this.n;
    }

    public void L() {
        this.m = System.currentTimeMillis();
        this.n = 0;
    }

    public long M() {
        if (!h() || J() == 0 || K() == 0) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - J();
        if (currentTimeMillis != 0) {
            return (K() * 1000) / currentTimeMillis;
        }
        return 0;
    }

    public void a(ai aiVar) {
        this.k = aiVar;
    }

    public void a(bi biVar) {
        this.l = biVar;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        return this.a.equals(iVar.w());
    }
}
