package com.duokan.reader.domain.downloadcenter;

import org.json.JSONObject;

public class o extends m {
    static final /* synthetic */ boolean b = (!o.class.desiredAssertionStatus());
    public String a = "";

    public o(JSONObject jSONObject) {
        super(jSONObject);
        this.a = jSONObject.optString("font_name");
    }

    public static o a(JSONObject jSONObject) {
        if (b || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.FONT) {
                    return null;
                }
                return new o(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    public DownloadType a() {
        return DownloadType.FONT;
    }

    public String b() {
        return this.a;
    }

    protected void b(JSONObject jSONObject) {
        super.b(jSONObject);
        try {
            jSONObject.put("font_name", this.a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
