package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

class ak implements as {
    final /* synthetic */ String a;
    final /* synthetic */ aj b;

    ak(aj ajVar, String str) {
        this.b = ajVar;
        this.a = str;
    }

    public void a() {
        if (!TextUtils.isEmpty(this.a)) {
            List arrayList = new ArrayList();
            this.b.a(arrayList, new JSONArray(this.a));
            if (arrayList.size() > 0) {
                this.b.a(new al(this, arrayList));
            }
        }
    }
}
