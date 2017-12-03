package com.duokan.reader.ui.general.web;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.general.ja;

import org.json.JSONArray;
import org.json.JSONObject;

class id implements as {
    final /* synthetic */ ic a;

    id(ic icVar) {
        this.a = icVar;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a.a);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        int optInt = jSONObject.optInt("position");
        if (optJSONArray.length() != 0) {
            ActivatedController activatedControllerVar;
            if (optJSONArray.length() < 2) {
                jSONObject = optJSONArray.getJSONObject(0);
                String optString = jSONObject.optString("title", "");
                String optString2 = jSONObject.optString("url");
                ActivatedController storePageController = new StorePageController(this.a.b.b.getContext());
                storePageController.loadUrl(optString2);
                storePageController.setPageTitle(optString);
                activatedControllerVar = storePageController;
            } else {
                ActivatedController jaVar = new ja(this.a.b.b.getContext());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString3 = jSONObject2.optString("title", "");
                    String optString4 = jSONObject2.optString("url");
                    ActivatedController storePageController2 = new StorePageController(this.a.b.b.getContext());
                    storePageController2.loadUrl(optString4);
                    storePageController2.setHasTitle(false);
                    jaVar.a(storePageController2, optString3);
                }
                jaVar.a(optInt);
                activatedControllerVar = jaVar;
            }
            ((ReaderFeature) this.a.b.b.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(activatedControllerVar, null);
        }
    }
}
