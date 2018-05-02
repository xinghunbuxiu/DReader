package com.duokan.reader.domain.micloud;

import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.i */
public class C1068i extends bf {
    /* renamed from: a */
    private String f5272a;
    /* renamed from: b */
    private String f5273b;
    /* renamed from: c */
    private String f5274c;
    /* renamed from: d */
    private ah f5275d;
    /* renamed from: e */
    private long f5276e;
    /* renamed from: f */
    private long f5277f;
    /* renamed from: g */
    private String f5278g;
    /* renamed from: h */
    private String f5279h;
    /* renamed from: i */
    private bh f5280i;
    /* renamed from: j */
    private long f5281j;
    /* renamed from: k */
    private ai f5282k;
    /* renamed from: l */
    private bi f5283l;
    /* renamed from: m */
    private long f5284m;
    /* renamed from: n */
    private long f5285n;

    public C1068i(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        super(str, str2, str3, 0, i);
        this.f5272a = str4;
        this.f5273b = str5;
        this.f5274c = str6;
        this.f5279h = "";
        this.f5275d = null;
        this.f5276e = 0;
        this.f5277f = 0;
        this.f5278g = null;
        this.f5280i = null;
        this.f5281j = 0;
        this.f5282k = null;
        this.f5283l = null;
    }

    public C1068i(JSONObject jSONObject) {
        super(jSONObject);
    }

    /* renamed from: a */
    protected void mo1489a(JSONObject jSONObject) {
        bi biVar = null;
        super.mo1489a(jSONObject);
        this.f5272a = jSONObject.optString("create_file_task_local_file_path");
        this.f5273b = jSONObject.optString("create_file_task_cloud_file_parent_path");
        this.f5274c = jSONObject.optString("create_file_task_cloud_file_name");
        if (TextUtils.isEmpty(this.f5274c)) {
            this.f5274c = new File(this.f5272a).getName();
        }
        this.f5279h = jSONObject.optString("create_file_task_cloud_parent_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("create_file_task_file_block_infos");
        this.f5275d = optJSONObject == null ? null : new ah(optJSONObject);
        this.f5276e = jSONObject.optLong("create_file_task_last_modified_time");
        this.f5277f = jSONObject.optLong("create_file_task_file_size");
        this.f5278g = jSONObject.optString("create_file_task_file_sha1");
        optJSONObject = jSONObject.optJSONObject("create_file_task_upload_data");
        this.f5280i = optJSONObject == null ? null : new bh(optJSONObject);
        this.f5281j = jSONObject.optLong("create_file_task_uploaded_length");
        optJSONObject = jSONObject.optJSONObject("create_file_task_commit_data");
        this.f5282k = optJSONObject == null ? null : new ai(optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("create_file_task_cloud_file_info");
        if (optJSONObject2 != null) {
            biVar = new bi(optJSONObject2);
        }
        this.f5283l = biVar;
    }

    /* renamed from: b */
    protected void mo1490b(JSONObject jSONObject) {
        Object obj = null;
        super.mo1490b(jSONObject);
        try {
            jSONObject.put("create_file_task_local_file_path", this.f5272a);
            jSONObject.put("create_file_task_cloud_file_parent_path", this.f5273b);
            jSONObject.put("create_file_task_cloud_file_name", this.f5274c);
            jSONObject.put("create_file_task_cloud_parent_id", this.f5279h);
            jSONObject.put("create_file_task_file_block_infos", this.f5275d == null ? null : this.f5275d.m8059a());
            jSONObject.put("create_file_task_last_modified_time", this.f5276e);
            jSONObject.put("create_file_task_file_size", this.f5277f);
            jSONObject.put("create_file_task_file_sha1", this.f5278g);
            jSONObject.put("create_file_task_upload_data", this.f5280i == null ? null : this.f5280i.m8146c());
            jSONObject.put("create_file_task_uploaded_length", this.f5281j);
            jSONObject.put("create_file_task_commit_data", this.f5282k == null ? null : this.f5282k.m8061a());
            String str = "create_file_task_cloud_file_info";
            if (this.f5283l != null) {
                obj = this.f5283l.m8150a();
            }
            jSONObject.put(str, obj);
        } catch (JSONException e) {
        }
    }

    /* renamed from: w */
    public String m8228w() {
        return this.f5272a;
    }

    /* renamed from: x */
    public String m8229x() {
        return this.f5273b;
    }

    /* renamed from: y */
    public String m8230y() {
        return this.f5274c;
    }

    /* renamed from: z */
    public String m8231z() {
        return this.f5279h;
    }

    /* renamed from: b */
    public void m8226b(String str) {
        this.f5279h = str;
    }

    /* renamed from: A */
    public ah m8205A() {
        return this.f5275d;
    }

    /* renamed from: B */
    public long m8206B() {
        return this.f5276e;
    }

    /* renamed from: C */
    public long m8207C() {
        return this.f5277f;
    }

    /* renamed from: a */
    public void m8218a(long j) {
        this.f5277f = j;
    }

    /* renamed from: D */
    public String m8208D() {
        return this.f5278g;
    }

    /* renamed from: E */
    public bh m8209E() {
        return this.f5280i;
    }

    /* renamed from: F */
    public long m8210F() {
        return this.f5281j;
    }

    /* renamed from: G */
    public ai m8211G() {
        return this.f5282k;
    }

    /* renamed from: H */
    public bi m8212H() {
        return this.f5283l;
    }

    /* renamed from: a */
    public void m8219a(long j, long j2, ah ahVar, String str) {
        this.f5276e = j;
        this.f5277f = j2;
        this.f5275d = ahVar;
        this.f5278g = str;
    }

    /* renamed from: a */
    public void m8221a(bh bhVar) {
        this.f5280i = bhVar;
    }

    /* renamed from: I */
    public void m8213I() {
        this.f5284m = System.currentTimeMillis();
        this.f5285n = 0;
    }

    /* renamed from: b */
    public void m8225b(long j, long j2) {
        this.f5281j = j;
        this.f5285n += j2;
    }

    /* renamed from: J */
    public long m8214J() {
        return this.f5284m;
    }

    /* renamed from: K */
    public long m8215K() {
        return this.f5285n;
    }

    /* renamed from: L */
    public void m8216L() {
        this.f5284m = System.currentTimeMillis();
        this.f5285n = 0;
    }

    /* renamed from: M */
    public long m8217M() {
        if (!m2293h() || m8214J() == 0 || m8215K() == 0) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - m8214J();
        if (currentTimeMillis != 0) {
            return (m8215K() * 1000) / currentTimeMillis;
        }
        return 0;
    }

    /* renamed from: a */
    public void m8220a(ai aiVar) {
        this.f5282k = aiVar;
    }

    /* renamed from: a */
    public void m8222a(bi biVar) {
        this.f5283l = biVar;
    }

    /* renamed from: a */
    public boolean m8224a(C1068i c1068i) {
        if (c1068i == null) {
            return false;
        }
        return this.f5272a.equals(c1068i.m8228w());
    }
}
