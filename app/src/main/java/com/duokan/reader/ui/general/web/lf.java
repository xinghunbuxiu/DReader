package com.duokan.reader.ui.general.web;

import com.mipay.sdk.Mipay;
import org.json.JSONException;
import org.json.JSONObject;

class lf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f8142a;
    /* renamed from: b */
    final /* synthetic */ JSONObject f8143b;
    /* renamed from: c */
    final /* synthetic */ TtsWebController f8144c;

    lf(TtsWebController ttsWebController, boolean z, JSONObject jSONObject) {
        this.f8144c = ttsWebController;
        this.f8142a = z;
        this.f8143b = jSONObject;
    }

    public void run() {
        try {
            if (this.f8142a) {
                this.f8144c.mTtsManager.addSelectedSpeaker(this.f8143b.toString());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Mipay.KEY_CODE, this.f8142a ? 0 : 1);
            jSONObject.put("speaker", this.f8143b);
            this.f8144c.invokeJS("iflytek.jsHandler.onDownloadCompleted", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
