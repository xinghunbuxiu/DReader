package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class ao implements as {
    /* renamed from: a */
    final /* synthetic */ String f7587a;
    /* renamed from: b */
    final /* synthetic */ al f7588b;

    ao(al alVar, String str) {
        this.f7588b = alVar;
        this.f7587a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject(this.f7587a);
        this.f7588b.m11022a(arrayList, jSONObject.optJSONArray("addedWords"));
        this.f7588b.m11022a(arrayList2, jSONObject.optJSONArray("removedWords"));
        this.f7588b.m11016a(new ap(this, arrayList2, arrayList));
    }
}
