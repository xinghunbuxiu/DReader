package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.core.ui.dv;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class ek implements as {
    /* renamed from: a */
    final /* synthetic */ String f7779a;
    /* renamed from: b */
    final /* synthetic */ ci f7780b;

    ek(ci ciVar, String str) {
        this.f7780b = ciVar;
        this.f7779a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7779a);
        if (jSONObject.has("page_height")) {
            this.f7780b.m11016a(new el(this, jSONObject.getInt("page_height")));
        }
        if (jSONObject.has("ad_wall_status")) {
            this.f7780b.m11016a(new em(this, jSONObject.getString("ad_wall_status")));
        }
        if (jSONObject.has("search_bar")) {
            this.f7780b.m11016a(new en(this, dv.m1932b(this.f7780b.f7581b.getContext(), (float) jSONObject.getInt("search_bar"))));
        }
        if (jSONObject.has("keyword")) {
            this.f7780b.m11016a(new eo(this, jSONObject.getString("keyword")));
        }
        if (jSONObject.has("top_banner")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("top_banner");
            this.f7780b.f7581b.mBannerInfo.f7670a = dv.m1932b(this.f7780b.f7581b.getContext(), (float) jSONObject2.optInt("height", this.f7780b.f7581b.getHeaderViewOffset()));
        }
        if (jSONObject.has("nav_tabs")) {
            JSONArray jSONArray = jSONObject.getJSONArray("nav_tabs");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int access$600 = this.f7780b.f7581b.mSurfingBarOffset;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                String string = jSONObject3.getString("name");
                int b = dv.m1932b(this.f7780b.f7581b.getContext(), (float) jSONObject3.getInt("pos"));
                if (i == 0) {
                    access$600 = b;
                }
                linkedHashMap.put(string, Integer.valueOf(b));
            }
            this.f7780b.m11016a(new ep(this, linkedHashMap, access$600));
        }
    }
}
