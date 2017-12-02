package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.async.work.c;

import org.json.JSONObject;

public class bf extends c {
    private String a;
    private String b;

    public bf(String str, String str2, String str3, int i, int i2) {
        super(str3, i, i2);
        this.a = str;
        this.b = str2;
    }

    public bf(JSONObject jSONObject) {
        super(jSONObject);
    }

    public final String N() {
        return this.a;
    }

    public final String O() {
        return this.b;
    }

    protected void a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.a = jSONObject.optString("storage_task_item_mi_account_id");
        this.b = jSONObject.optString("storage_task_item_namespace");
    }

    protected void b(JSONObject jSONObject) {
        super.b(jSONObject);
        try {
            jSONObject.put("storage_task_item_mi_account_id", this.a);
            jSONObject.put("storage_task_item_namespace", this.b);
        } catch (Exception e) {
        }
    }
}
