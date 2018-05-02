package com.duokan.reader.domain.downloadcenter;

import org.json.JSONObject;

public class aa extends C1014m {
    /* renamed from: c */
    static final /* synthetic */ boolean f5047c = (!aa.class.desiredAssertionStatus());
    /* renamed from: a */
    public String f5048a = "";
    /* renamed from: b */
    public String f5049b = "";

    public aa(JSONObject jSONObject) {
        super(jSONObject);
        this.f5048a = jSONObject.optString("plugin_name");
        this.f5049b = jSONObject.optString("plugin_type");
    }

    /* renamed from: a */
    public static aa m7819a(JSONObject jSONObject) {
        if (f5047c || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.PLUGIN) {
                    return null;
                }
                return new aa(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public DownloadType mo1474a() {
        return DownloadType.PLUGIN;
    }

    /* renamed from: b */
    public String mo1475b() {
        return this.f5048a;
    }

    /* renamed from: b */
    protected void mo1476b(JSONObject jSONObject) {
        super.mo1476b(jSONObject);
        try {
            jSONObject.put("plugin_name", this.f5048a);
            jSONObject.put("plugin_type", this.f5049b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
