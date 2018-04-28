package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.ad.C0759p;
import org.json.JSONException;
import org.json.JSONObject;

class ke implements C0759p {
    /* renamed from: a */
    final /* synthetic */ String f8090a;
    /* renamed from: b */
    final /* synthetic */ kd f8091b;

    ke(kd kdVar, String str) {
        this.f8091b = kdVar;
        this.f8090a = str;
    }

    /* renamed from: a */
    public void mo1848a(String str) {
        try {
            this.f8091b.f8089b.f7581b.web_notifyWeb(this.f8090a, 0, new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo1847a() {
        this.f8091b.f8089b.f7581b.web_notifyWeb(this.f8090a, 2, new Object[0]);
    }
}
