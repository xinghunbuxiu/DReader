package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class dr implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    dr(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        this.b.a(new ds(this, new JSONObject(this.a).getString("msgid")));
    }
}
