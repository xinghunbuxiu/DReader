package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.ad.p;

import org.json.JSONException;
import org.json.JSONObject;

class jp implements p {
    final /* synthetic */ String a;
    final /* synthetic */ jo b;

    jp(jo joVar, String str) {
        this.b = joVar;
        this.a = str;
    }

    public void a(String str) {
        try {
            this.b.b.b.web_notifyWeb(this.a, 0, new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.b.b.b.web_notifyWeb(this.a, 2, new Object[0]);
    }
}
