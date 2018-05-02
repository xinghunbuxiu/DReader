package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class jx implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    jx(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        b.a(new JSONObject(this.a)).a();
    }
}
