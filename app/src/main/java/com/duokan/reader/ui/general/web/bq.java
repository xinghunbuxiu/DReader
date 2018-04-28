package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;
import com.mipay.sdk.Mipay;
import org.json.JSONObject;

class bq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bp f7640a;

    bq(bp bpVar) {
        this.f7640a = bpVar;
    }

    public void onClick(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Mipay.KEY_RESULT, 0);
            jSONObject.put("text", this.f7640a.f7638b);
            this.f7640a.f7639c.triggerEventOnCurrentUrl("button", jSONObject);
        } catch (Exception e) {
        }
    }
}
