package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class iq implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    iq(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String optString = jSONObject.optString("title", "");
        Object string = jSONObject.getString("url");
        boolean optBoolean = jSONObject.optBoolean("half", false);
        Matcher matcher = Pattern.compile("/h[sd]/fiction/book/([0-9\\-]+)/toc&order=([01])").matcher(string);
        if (matcher.find()) {
            this.b.b.showFictionToc(matcher.group(1), TextUtils.equals(matcher.group(2), "1"));
            return;
        }
        matcher = Pattern.compile("/h[sd]/store/giving/([0-9a-zA-Z]+)").matcher(string);
        if (matcher.find()) {
            this.b.b.giving(matcher.group(1));
            return;
        }
        matcher = Pattern.compile("/h[sd]/store/book/([0-9a-zA-Z]+)/changelog").matcher(string);
        if (matcher.find()) {
            this.b.b.showBookChangeLog(matcher.group(1));
            return;
        }
        this.b.a(new ir(this, optString, string, optBoolean));
    }
}
