package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

import com.mipay.sdk.Mipay;

import org.json.JSONObject;

class br implements OnClickListener {
    final /* synthetic */ bq a;

    br(bq bqVar) {
        this.a = bqVar;
    }

    public void onClick(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Mipay.KEY_RESULT, 0);
            jSONObject.put("text", this.a.b);
            this.a.c.triggerEventOnCurrentUrl("button", jSONObject);
        } catch (Exception e) {
        }
    }
}
