package com.duokan.reader.domain.plugins.dict;

import com.duokan.reader.domain.downloadcenter.C1014m;
import com.duokan.reader.domain.downloadcenter.DownloadType;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.plugins.dict.h */
public class C1113h extends C1014m {
    /* renamed from: b */
    static final /* synthetic */ boolean f5398b = (!DictDownloadController.class.desiredAssertionStatus());
    /* renamed from: a */
    public String f5399a;

    public C1113h(JSONObject jSONObject) {
        super(jSONObject);
        this.f5399a = jSONObject.optString("dict_name");
    }

    /* renamed from: a */
    public static C1113h m8403a(JSONObject jSONObject) {
        if (f5398b || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.DICT) {
                    return null;
                }
                return new C1113h(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public DownloadType mo1474a() {
        return DownloadType.DICT;
    }

    /* renamed from: b */
    public String mo1475b() {
        return this.f5399a;
    }

    /* renamed from: b */
    protected void mo1476b(JSONObject jSONObject) {
        super.mo1476b(jSONObject);
        try {
            jSONObject.put("dict_name", this.f5399a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
