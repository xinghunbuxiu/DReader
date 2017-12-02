package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

import cn.kuaipan.android.kss.upload.UploadFileInfo;

public class ah {
    private JSONObject a;

    public ah(UploadFileInfo uploadFileInfo) {
        this.a = new JSONObject();
        try {
            this.a.put("kss", new JSONObject(uploadFileInfo.getKssString()));
        } catch (JSONException e) {
        }
    }

    public ah(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public JSONObject a() {
        return this.a;
    }
}
