package com.duokan.reader.domain.downloadcenter;

import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.downloadcenter.o */
public class C1027o extends C1014m {
    /* renamed from: b */
    static final /* synthetic */ boolean f5087b = (!C1027o.class.desiredAssertionStatus());
    /* renamed from: a */
    public String f5088a = "";

    public C1027o(JSONObject jSONObject) {
        super(jSONObject);
        this.f5088a = jSONObject.optString("font_name");
    }

    /* renamed from: a */
    public static C1027o m7904a(JSONObject jSONObject) {
        if (f5087b || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.FONT) {
                    return null;
                }
                return new C1027o(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public DownloadType mo1474a() {
        return DownloadType.FONT;
    }

    /* renamed from: b */
    public String mo1475b() {
        return this.f5088a;
    }

    /* renamed from: b */
    protected void mo1476b(JSONObject jSONObject) {
        super.mo1476b(jSONObject);
        try {
            jSONObject.put("font_name", this.f5088a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
