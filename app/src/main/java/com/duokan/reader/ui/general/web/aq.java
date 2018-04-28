package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class aq implements as {
    /* renamed from: a */
    final /* synthetic */ String f7592a;
    /* renamed from: b */
    final /* synthetic */ al f7593b;

    aq(al alVar, String str) {
        this.f7593b = alVar;
        this.f7592a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        String string = new JSONObject(this.f7592a).getString("msgid");
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f7593b.f7582a.mHistory.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        this.f7593b.f7582a.web_notifyWeb(string, 0, "items", jSONArray);
    }
}
