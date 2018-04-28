package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class bl extends bf {
    /* renamed from: a */
    private String f5255a;
    /* renamed from: b */
    private boolean f5256b;
    /* renamed from: c */
    private boolean f5257c;
    /* renamed from: d */
    private boolean f5258d;

    public bl(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, int i) {
        super(str, str2, str3, 3, i);
        this.f5255a = str4;
        this.f5256b = z;
        this.f5257c = z2;
        this.f5258d = z3;
    }

    /* renamed from: w */
    public String m8175w() {
        return this.f5255a;
    }

    /* renamed from: x */
    public boolean m8176x() {
        return this.f5257c;
    }

    /* renamed from: y */
    public boolean m8177y() {
        return this.f5258d;
    }

    /* renamed from: a */
    protected void mo1489a(JSONObject jSONObject) {
        super.mo1489a(jSONObject);
        this.f5255a = jSONObject.optString("sync_dir_struct_task__root_path");
        this.f5256b = jSONObject.optBoolean("sync_dir_struct_task__use_incremental_refresh");
        this.f5257c = jSONObject.optBoolean("sync_dir_struct_task__just_sync_first_level");
        this.f5258d = jSONObject.optBoolean("sync_dir_struct_task__just_sync_first_level_files");
    }

    /* renamed from: b */
    protected void mo1490b(JSONObject jSONObject) {
        super.mo1490b(jSONObject);
        try {
            jSONObject.put("sync_dir_struct_task__root_path", this.f5255a);
            jSONObject.put("sync_dir_struct_task__use_incremental_refresh", this.f5256b);
            jSONObject.put("sync_dir_struct_task__just_sync_first_level", this.f5257c);
            jSONObject.put("sync_dir_struct_task__just_sync_first_level_files", this.f5258d);
        } catch (JSONException e) {
        }
    }
}
