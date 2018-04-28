package com.duokan.reader.domain.micloud;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bi {
    /* renamed from: a */
    private JSONObject f5237a;
    /* renamed from: b */
    private String f5238b;
    /* renamed from: c */
    private String f5239c;
    /* renamed from: d */
    private String f5240d;
    /* renamed from: e */
    private String f5241e;
    /* renamed from: f */
    private String f5242f;
    /* renamed from: g */
    private String f5243g;
    /* renamed from: h */
    private String f5244h;
    /* renamed from: i */
    private String f5245i;
    /* renamed from: j */
    private long f5246j;
    /* renamed from: k */
    private long f5247k;
    /* renamed from: l */
    private long f5248l;
    /* renamed from: m */
    private String f5249m;
    /* renamed from: n */
    private boolean f5250n;

    public bi(JSONObject jSONObject) {
        this.f5237a = jSONObject;
        this.f5238b = this.f5237a.getString("__mi_account_id__");
        this.f5239c = this.f5237a.getString("__mi_cloud_storage_namespace__");
        this.f5240d = this.f5237a.getString("__cloud_parent_path__");
        this.f5250n = this.f5237a.optBoolean("__is_files_of_this_directory_refreshed__");
        m8149q();
    }

    public bi(String str, String str2, String str3, JSONObject jSONObject) {
        this.f5237a = jSONObject;
        this.f5238b = str;
        this.f5237a.put("__mi_account_id__", str);
        this.f5239c = str2;
        this.f5237a.put("__mi_cloud_storage_namespace__", str2);
        if (TextUtils.isEmpty(str3)) {
            this.f5240d = "/";
        } else {
            this.f5240d = new File(str3).getAbsolutePath();
        }
        this.f5237a.put("__cloud_parent_path__", this.f5240d);
        this.f5250n = false;
        this.f5237a.put("__is_files_of_this_directory_refreshed__", this.f5250n);
        m8149q();
    }

    /* renamed from: q */
    private void m8149q() {
        this.f5241e = this.f5237a.getString("id");
        this.f5242f = this.f5237a.getString("parent_id");
        this.f5243g = this.f5237a.getString("name");
        this.f5245i = this.f5237a.getString("type");
        this.f5246j = this.f5237a.getLong("create_time");
        this.f5247k = this.f5237a.getLong("modify_time");
        this.f5248l = this.f5237a.optLong("size");
        this.f5249m = this.f5237a.optString("sha1");
        if (!this.f5243g.equals("/")) {
            if (this.f5240d.endsWith("/")) {
                this.f5244h = this.f5240d + this.f5243g;
            } else {
                this.f5244h = this.f5240d + "/" + this.f5243g;
            }
        }
    }

    /* renamed from: a */
    public JSONObject m8150a() {
        return this.f5237a;
    }

    /* renamed from: b */
    public String m8152b() {
        return this.f5238b;
    }

    /* renamed from: c */
    public String m8153c() {
        return this.f5239c;
    }

    /* renamed from: d */
    public String m8154d() {
        return this.f5241e;
    }

    /* renamed from: e */
    public String m8155e() {
        return this.f5243g;
    }

    /* renamed from: f */
    public boolean m8156f() {
        return this.f5245i.equals("file");
    }

    /* renamed from: g */
    public boolean m8157g() {
        return this.f5245i.equals("dir");
    }

    /* renamed from: h */
    public long m8158h() {
        return this.f5246j;
    }

    /* renamed from: i */
    public long m8159i() {
        return this.f5247k;
    }

    /* renamed from: j */
    public long m8160j() {
        return this.f5248l;
    }

    /* renamed from: k */
    public String m8161k() {
        return this.f5249m;
    }

    /* renamed from: l */
    public String m8162l() {
        return this.f5244h;
    }

    /* renamed from: m */
    public String m8163m() {
        return this.f5240d;
    }

    /* renamed from: n */
    public boolean m8164n() {
        return this.f5250n;
    }

    /* renamed from: o */
    public void m8165o() {
        this.f5250n = true;
        try {
            this.f5237a.put("__is_files_of_this_directory_refreshed__", this.f5250n);
        } catch (JSONException e) {
        }
    }

    /* renamed from: p */
    public void m8166p() {
        this.f5250n = false;
        try {
            this.f5237a.put("__is_files_of_this_directory_refreshed__", this.f5250n);
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public static ArrayList<bi> m8147a(String str, String str2, String str3, JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList<bi> arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new bi(str, str2, str3, jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static ArrayList<bi> m8148a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList<bi> arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new bi(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public boolean m8151a(bi biVar) {
        if (biVar == null) {
            return false;
        }
        return this.f5241e.equals(biVar.m8154d());
    }
}
