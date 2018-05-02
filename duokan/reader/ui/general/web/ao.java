package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

class ao implements as {
    final /* synthetic */ String a;
    final /* synthetic */ aj b;

    ao(aj ajVar, String str) {
        this.b = ajVar;
        this.a = str;
    }

    public void a() {
        String string = new JSONObject(this.a).getString("msgid");
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.b.a.mHistory.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        this.b.a.web_notifyWeb(string, 0, "items", jSONArray);
    }
}
