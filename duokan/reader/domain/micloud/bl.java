package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class bl extends bf {
    private String a;
    private boolean b;
    private boolean c;
    private boolean d;

    public bl(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, int i) {
        super(str, str2, str3, 3, i);
        this.a = str4;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public String w() {
        return this.a;
    }

    public boolean x() {
        return this.c;
    }

    public boolean y() {
        return this.d;
    }

    protected void a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.a = jSONObject.optString("sync_dir_struct_task__root_path");
        this.b = jSONObject.optBoolean("sync_dir_struct_task__use_incremental_refresh");
        this.c = jSONObject.optBoolean("sync_dir_struct_task__just_sync_first_level");
        this.d = jSONObject.optBoolean("sync_dir_struct_task__just_sync_first_level_files");
    }

    protected void b(JSONObject jSONObject) {
        super.b(jSONObject);
        try {
            jSONObject.put("sync_dir_struct_task__root_path", this.a);
            jSONObject.put("sync_dir_struct_task__use_incremental_refresh", this.b);
            jSONObject.put("sync_dir_struct_task__just_sync_first_level", this.c);
            jSONObject.put("sync_dir_struct_task__just_sync_first_level_files", this.d);
        } catch (JSONException e) {
        }
    }
}
