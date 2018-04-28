package com.duokan.reader.ui.general.web;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.general.ik;
import org.json.JSONArray;
import org.json.JSONObject;

class ip implements as {
    /* renamed from: a */
    final /* synthetic */ io f8008a;

    ip(io ioVar) {
        this.f8008a = ioVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f8008a.f8006a);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        int optInt = jSONObject.optInt("position");
        if (optJSONArray.length() != 0) {
            ActivatedController c0303e;
            if (optJSONArray.length() < 2) {
                jSONObject = optJSONArray.getJSONObject(0);
                String optString = jSONObject.optString("title", "");
                String optString2 = jSONObject.optString("url");
                ActivatedController storePageController = new StorePageController(this.f8008a.f8007b.f7581b.getContext());
                storePageController.loadUrl(optString2);
                storePageController.setPageTitle(optString);
                c0303e = storePageController;
            } else {
                ActivatedController ikVar = new ik(this.f8008a.f8007b.f7581b.getContext());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString3 = jSONObject2.optString("title", "");
                    String optString4 = jSONObject2.optString("url");
                    ActivatedController storePageController2 = new StorePageController(this.f8008a.f8007b.f7581b.getContext());
                    storePageController2.loadUrl(optString4);
                    storePageController2.setHasTitle(false);
                    ikVar.m10793a(storePageController2, optString3);
                }
                ikVar.m10792a(optInt);
                c0303e = ikVar;
            }
            ((ReaderFeature) this.f8008a.f8007b.f7581b.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(c0303e, null);
        }
    }
}
