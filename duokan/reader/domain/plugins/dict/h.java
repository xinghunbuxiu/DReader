package com.duokan.reader.domain.plugins.dict;

import com.duokan.reader.domain.downloadcenter.DownloadType;
import com.duokan.reader.domain.downloadcenter.m;

import org.json.JSONObject;

public class h extends m {
    static final /* synthetic */ boolean b = (!DictDownloadController.class.desiredAssertionStatus());
    public String a;

    public h(JSONObject jSONObject) {
        super(jSONObject);
        this.a = jSONObject.optString("dict_name");
    }

    public static h a(JSONObject jSONObject) {
        if (b || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.DICT) {
                    return null;
                }
                return new h(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    public DownloadType a() {
        return DownloadType.DICT;
    }

    public String b() {
        return this.a;
    }

    protected void b(JSONObject jSONObject) {
        super.b(jSONObject);
        try {
            jSONObject.put("dict_name", this.a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
