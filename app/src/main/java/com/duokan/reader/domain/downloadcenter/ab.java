package com.duokan.reader.domain.downloadcenter;

import org.json.JSONObject;

public class ab extends C1014m {
    /* renamed from: c */
    static final /* synthetic */ boolean f5050c = (!ab.class.desiredAssertionStatus());
    /* renamed from: a */
    public String f5051a = "";
    /* renamed from: b */
    public JSONObject f5052b = new JSONObject();

    public ab(JSONObject jSONObject) {
        super(jSONObject);
        this.f5051a = jSONObject.optString("pack_name");
        this.f5052b = jSONObject.optJSONObject("pack_info");
    }

    /* renamed from: a */
    public static ab m7823a(JSONObject jSONObject) {
        if (f5050c || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.TTS_PACK) {
                    return null;
                }
                return new ab(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public DownloadType mo1474a() {
        return DownloadType.TTS_PACK;
    }

    /* renamed from: b */
    public String mo1475b() {
        return this.f5051a;
    }

    /* renamed from: b */
    protected void mo1476b(JSONObject jSONObject) {
        super.mo1476b(jSONObject);
        try {
            jSONObject.put("pack_name", this.f5051a);
            jSONObject.put("pack_info", this.f5052b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public JSONObject m7827d() {
        return this.f5052b;
    }
}
