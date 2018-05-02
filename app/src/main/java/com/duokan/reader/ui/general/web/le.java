package com.duokan.reader.ui.general.web;

import org.json.JSONException;
import org.json.JSONObject;

class le implements Runnable {
    /* renamed from: a */
    final /* synthetic */ float f8139a;
    /* renamed from: b */
    final /* synthetic */ JSONObject f8140b;
    /* renamed from: c */
    final /* synthetic */ TtsWebController f8141c;

    le(TtsWebController ttsWebController, float f, JSONObject jSONObject) {
        this.f8141c = ttsWebController;
        this.f8139a = f;
        this.f8140b = jSONObject;
    }

    public void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", (double) this.f8139a);
            jSONObject.put("speaker", this.f8140b);
            this.f8141c.invokeJS("iflytek.jsHandler.onDownloadProgress", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
