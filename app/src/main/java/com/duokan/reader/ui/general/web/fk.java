package com.duokan.reader.ui.general.web;

import android.graphics.Rect;
import com.duokan.core.sys.as;
import com.duokan.core.ui.AnimUtils;
import org.json.JSONArray;
import org.json.JSONObject;

class fk implements as {
    /* renamed from: a */
    final /* synthetic */ String f7836a;
    /* renamed from: b */
    final /* synthetic */ ci f7837b;

    fk(ci ciVar, String str) {
        this.f7837b = ciVar;
        this.f7836a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7836a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        JSONArray jSONArray = jSONObject.getJSONArray("items");
        JSONArray jSONArray2 = jSONObject.getJSONArray("mBounds");
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        Rect rect = new Rect();
        int i2 = jSONArray2.getInt(0);
        int i3 = jSONArray2.getInt(1);
        rect.set(AnimUtils.m1932b(this.f7837b.f7581b.getContext(), (float) i2), AnimUtils.m1932b(this.f7837b.f7581b.getContext(), (float) i3), AnimUtils.m1932b(this.f7837b.f7581b.getContext(), (float) (i2 + jSONArray2.getInt(2))), AnimUtils.m1932b(this.f7837b.f7581b.getContext(), (float) (i3 + jSONArray2.getInt(3))));
        this.f7837b.m11016a(new fl(this, rect, strArr, string));
    }
}
