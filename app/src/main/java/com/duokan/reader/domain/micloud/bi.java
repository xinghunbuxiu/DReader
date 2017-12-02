package com.duokan.reader.domain.micloud;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class bi {
    private JSONObject a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private long j;
    private long k;
    private long l;
    private String m;
    private boolean n;

    public bi(JSONObject jSONObject) {
        this.a = jSONObject;
        this.b = this.a.getString("__mi_account_id__");
        this.c = this.a.getString("__mi_cloud_storage_namespace__");
        this.d = this.a.getString("__cloud_parent_path__");
        this.n = this.a.optBoolean("__is_files_of_this_directory_refreshed__");
        q();
    }

    public bi(String str, String str2, String str3, JSONObject jSONObject) {
        this.a = jSONObject;
        this.b = str;
        this.a.put("__mi_account_id__", str);
        this.c = str2;
        this.a.put("__mi_cloud_storage_namespace__", str2);
        if (TextUtils.isEmpty(str3)) {
            this.d = "/";
        } else {
            this.d = new File(str3).getAbsolutePath();
        }
        this.a.put("__cloud_parent_path__", this.d);
        this.n = false;
        this.a.put("__is_files_of_this_directory_refreshed__", this.n);
        q();
    }

    private void q() {
        this.e = this.a.getString("id");
        this.f = this.a.getString("parent_id");
        this.g = this.a.getString("name");
        this.i = this.a.getString("type");
        this.j = this.a.getLong("create_time");
        this.k = this.a.getLong("modify_time");
        this.l = this.a.optLong("size");
        this.m = this.a.optString("sha1");
        if (!this.g.equals("/")) {
            if (this.d.endsWith("/")) {
                this.h = this.d + this.g;
            } else {
                this.h = this.d + "/" + this.g;
            }
        }
    }

    public JSONObject a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.g;
    }

    public boolean f() {
        return this.i.equals("file");
    }

    public boolean g() {
        return this.i.equals("dir");
    }

    public long h() {
        return this.j;
    }

    public long i() {
        return this.k;
    }

    public long j() {
        return this.l;
    }

    public String k() {
        return this.m;
    }

    public String l() {
        return this.h;
    }

    public String m() {
        return this.d;
    }

    public boolean n() {
        return this.n;
    }

    public void o() {
        this.n = true;
        try {
            this.a.put("__is_files_of_this_directory_refreshed__", this.n);
        } catch (JSONException e) {
        }
    }

    public void p() {
        this.n = false;
        try {
            this.a.put("__is_files_of_this_directory_refreshed__", this.n);
        } catch (JSONException e) {
        }
    }

    public static ArrayList a(String str, String str2, String str3, JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new bi(str, str2, str3, jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static ArrayList a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new bi(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public boolean a(bi biVar) {
        if (biVar == null) {
            return false;
        }
        return this.e.equals(biVar.d());
    }
}
