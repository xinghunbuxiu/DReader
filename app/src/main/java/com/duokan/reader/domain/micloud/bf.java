package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.async.work.C0523c;
import org.json.JSONObject;

public class bf extends C0523c {
    /* renamed from: a */
    private String f5232a;
    /* renamed from: b */
    private String f5233b;

    public bf(String str, String str2, String str3, int i, int i2) {
        super(str3, i, i2);
        this.f5232a = str;
        this.f5233b = str2;
    }

    public bf(JSONObject jSONObject) {
        super(jSONObject);
    }

    /* renamed from: N */
    public final String m8140N() {
        return this.f5232a;
    }

    /* renamed from: O */
    public final String m8141O() {
        return this.f5233b;
    }

    /* renamed from: a */
    protected void mo1489a(JSONObject jSONObject) {
        super.mo1489a(jSONObject);
        this.f5232a = jSONObject.optString("storage_task_item_mi_account_id");
        this.f5233b = jSONObject.optString("storage_task_item_namespace");
    }

    /* renamed from: b */
    protected void mo1490b(JSONObject jSONObject) {
        super.mo1490b(jSONObject);
        try {
            jSONObject.put("storage_task_item_mi_account_id", this.f5232a);
            jSONObject.put("storage_task_item_namespace", this.f5233b);
        } catch (Exception e) {
        }
    }
}
