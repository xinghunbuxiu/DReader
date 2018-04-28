package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

class jc implements as {
    /* renamed from: a */
    final /* synthetic */ String f8036a;
    /* renamed from: b */
    final /* synthetic */ ci f8037b;

    jc(ci ciVar, String str) {
        this.f8037b = ciVar;
        this.f8036a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f8036a);
        String optString = jSONObject.optString("title", "");
        Object string = jSONObject.getString("url");
        boolean optBoolean = jSONObject.optBoolean("half", false);
        Matcher matcher = Pattern.compile("/h[sd]/fiction/book/([0-9\\-]+)/toc&order=([01])").matcher(string);
        if (matcher.find()) {
            this.f8037b.f7581b.showFictionToc(matcher.group(1), TextUtils.equals(matcher.group(2), "1"));
            return;
        }
        matcher = Pattern.compile("/h[sd]/store/giving/([0-9a-zA-Z]+)").matcher(string);
        if (matcher.find()) {
            this.f8037b.f7581b.giving(matcher.group(1));
            return;
        }
        matcher = Pattern.compile("/h[sd]/store/book/([0-9a-zA-Z]+)/changelog").matcher(string);
        if (matcher.find()) {
            this.f8037b.f7581b.showBookChangeLog(matcher.group(1));
        } else if (Pattern.compile("/hs/user/ad-wall").matcher(string).find()) {
            this.f8037b.m11016a(new jd(this));
        } else {
            this.f8037b.m11016a(new je(this, optString, string, optBoolean));
        }
    }
}
