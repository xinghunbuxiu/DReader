package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.kss.upload.KssUploadInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ai {
    /* renamed from: a */
    private JSONObject f5190a;

    public ai(JSONObject jSONObject) {
        this.f5190a = jSONObject;
    }

    /* renamed from: a */
    public JSONObject m8061a() {
        return this.f5190a;
    }

    /* renamed from: a */
    public static ai m8060a(KssUploadInfo kssUploadInfo) {
        try {
            return new ai(new JSONObject().put("kss", new JSONObject(kssUploadInfo.getCommitString())));
        } catch (JSONException e) {
            return null;
        }
    }
}
