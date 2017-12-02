package com.duokan.reader.domain.downloadcenter;

import org.json.JSONObject;

public class v extends m {
    static final /* synthetic */ boolean c = (!v.class.desiredAssertionStatus());
    public String a = "";
    public String b = "";

    public v(JSONObject jSONObject) {
        super(jSONObject);
        this.a = jSONObject.optString("plugin_name");
        this.b = jSONObject.optString("plugin_type");
    }

    public static v a(JSONObject jSONObject) {
        if (c || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.PLUGIN) {
                    return null;
                }
                return new v(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    public DownloadType a() {
        return DownloadType.PLUGIN;
    }

    public String b() {
        return this.a;
    }

    protected void b(JSONObject jSONObject) {
        super.b(jSONObject);
        try {
            jSONObject.put("plugin_name", this.a);
            jSONObject.put("plugin_type", this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
