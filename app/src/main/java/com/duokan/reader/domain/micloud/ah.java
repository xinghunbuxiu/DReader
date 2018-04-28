package com.duokan.reader.domain.micloud;

import cn.kuaipan.android.kss.upload.UploadFileInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ah {
    /* renamed from: a */
    private JSONObject f5189a;

    public ah(UploadFileInfo uploadFileInfo) {
        this.f5189a = new JSONObject();
        try {
            this.f5189a.put("kss", new JSONObject(uploadFileInfo.getKssString()));
        } catch (JSONException e) {
        }
    }

    public ah(JSONObject jSONObject) {
        this.f5189a = jSONObject;
    }

    /* renamed from: a */
    public JSONObject m8059a() {
        return this.f5189a;
    }
}
