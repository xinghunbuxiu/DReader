package com.duokan.reader.ui.general.web;

import android.graphics.Rect;

import com.duokan.core.sys.as;
import com.duokan.core.ui.UTools;

import org.json.JSONArray;
import org.json.JSONObject;

class fa implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    fa(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        JSONArray jSONArray = jSONObject.getJSONArray("items");
        JSONArray jSONArray2 = jSONObject.getJSONArray("rect");
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        Rect rect = new Rect();
        int i2 = jSONArray2.getInt(0);
        int i3 = jSONArray2.getInt(1);
        rect.set(UTools.getMinimumHeight(this.b.pageController.getContext(), (float) i2), UTools.getMinimumHeight(this.b.pageController.getContext(), (float) i3), UTools.getMinimumHeight(this.b.pageController.getContext(), (float) (i2 + jSONArray2.getInt(2))), UTools.getMinimumHeight(this.b.pageController.getContext(), (float) (i3 + jSONArray2.getInt(3))));
        this.b.a(new fb(this, rect, strArr, string));
    }
}
