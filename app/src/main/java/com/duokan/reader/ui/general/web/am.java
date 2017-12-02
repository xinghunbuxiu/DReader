package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class am implements as {
    final /* synthetic */ String a;
    final /* synthetic */ aj b;

    am(aj ajVar, String str) {
        this.b = ajVar;
        this.a = str;
    }

    public void a() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject(this.a);
        this.b.a(arrayList, jSONObject.optJSONArray("addedWords"));
        this.b.a(arrayList2, jSONObject.optJSONArray("removedWords"));
        this.b.a(new an(this, arrayList2, arrayList));
    }
}
