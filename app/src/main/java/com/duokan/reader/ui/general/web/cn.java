package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.sys.as;
import com.duokan.reader.common.i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.WebSession.CacheStrategy;
import com.duokan.reader.common.webservices.duokan.p;

import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

class cn implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    cn(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        int i;
        String str;
        int i2 = 0;
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        String toUpperCase = i.a(jSONObject2, "method", HttpGet.METHOD_NAME).toUpperCase();
        String string2 = jSONObject2.getString("url");
        Uri parse = Uri.parse(string2);
        if (TextUtils.isEmpty(parse.getAuthority())) {
            string2 = p.i().y() + string2;
        }
        if (TextUtils.isEmpty(parse.getScheme())) {
            string2 = (p.i().k() ? "https://" : "http://") + string2;
        }
        JSONObject optJSONObject = jSONObject2.optJSONObject("params");
        if (optJSONObject != null) {
            JSONArray names = optJSONObject.names();
            String str2 = string2;
            i = 0;
            while (i < names.length()) {
                String string3 = names.getString(i);
                str2 = (str2 + (i == 0 ? "?" : "&")) + Uri.encode(string3) + "=" + Uri.encode(String.valueOf(optJSONObject.get(string3)));
                i++;
            }
            str = str2;
        } else {
            str = string2;
        }
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
        ArrayList arrayList = new ArrayList();
        if (optJSONObject2 != null) {
            JSONArray names2 = optJSONObject2.names();
            for (i = 0; i < names2.length(); i++) {
                String string4 = names2.getString(i);
                arrayList.add(string4);
                arrayList.add(String.valueOf(optJSONObject2.get(string4)));
            }
        }
        jSONObject = jSONObject2.optJSONObject("header");
        ArrayList arrayList2 = new ArrayList();
        if (jSONObject != null) {
            JSONArray names3 = jSONObject.names();
            while (i2 < names3.length()) {
                string4 = names3.getString(i2);
                arrayList2.add(string4);
                arrayList2.add(String.valueOf(jSONObject.get(string4)));
                i2++;
            }
        }
        i2 = jSONObject2.optInt("timeout", 20000);
        boolean optBoolean = jSONObject2.optBoolean("cache", true);
        WebSession coVar = new co(this, toUpperCase, arrayList, str, arrayList2, string);
        if (i2 > 0) {
            int max = Math.max(5000, i2);
            coVar.setConnectTimeout(max);
            coVar.setReadTimeout(max);
        }
        coVar.open(optBoolean ? CacheStrategy.USE_CACHE_IF_FRESH : CacheStrategy.DO_NOT_USE_CACHE);
    }
}
