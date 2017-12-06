package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.core.ui.UTools;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;

class ec implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    ec(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        if (jSONObject.has("page_height")) {
            this.b.pageController.mPageHeight = jSONObject.getInt("page_height");
            this.b.a(new ed(this));
        }
        if (jSONObject.has("top_banner")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("top_banner");
            this.b.pageController.mBannerInfo.a = UTools.getMinimumHeight(this.b.pageController.getContext(), (float) jSONObject2.optInt("height", this.b.pageController.getHeaderViewOffset()));
        }
        if (jSONObject.has("nav_tabs")) {
            JSONArray jSONArray = jSONObject.getJSONArray("nav_tabs");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int access$600 = this.b.pageController.mSurfingBarOffset;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                String string = jSONObject3.getString("name");
                int b = UTools.getMinimumHeight(this.b.pageController.getContext(), (float) jSONObject3.getInt("pos"));
                if (i == 0) {
                    access$600 = b;
                }
                linkedHashMap.put(string, Integer.valueOf(b));
            }
            this.b.a(new ee(this, linkedHashMap, access$600));
        }
    }
}
