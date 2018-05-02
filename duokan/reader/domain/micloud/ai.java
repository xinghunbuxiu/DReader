package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

import cn.kuaipan.android.kss.upload.KssUploadInfo;

public class ai {
    private JSONObject a;

    public ai(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public JSONObject a() {
        return this.a;
    }

    public static ai a(KssUploadInfo kssUploadInfo) {
        try {
            return new ai(new JSONObject().put("kss", new JSONObject(kssUploadInfo.getCommitString())));
        } catch (JSONException e) {
            return null;
        }
    }
}
