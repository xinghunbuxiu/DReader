package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.mipay.sdk.Mipay;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

class ct extends WebSession {
    /* renamed from: a */
    final /* synthetic */ String f7696a;
    /* renamed from: b */
    final /* synthetic */ ArrayList f7697b;
    /* renamed from: c */
    final /* synthetic */ String f7698c;
    /* renamed from: d */
    final /* synthetic */ ArrayList f7699d;
    /* renamed from: e */
    final /* synthetic */ String f7700e;
    /* renamed from: f */
    final /* synthetic */ cs f7701f;
    /* renamed from: g */
    private Object f7702g = null;

    ct(cs csVar, String str, ArrayList arrayList, String str2, ArrayList arrayList2, String str3) {
        this.f7701f = csVar;
        this.f7696a = str;
        this.f7697b = arrayList;
        this.f7698c = str2;
        this.f7699d = arrayList2;
        this.f7700e = str3;
    }

    protected void onSessionTry() {
        C0624a a;
        int i = 0;
        if (TextUtils.equals(this.f7696a, HttpPost.METHOD_NAME)) {
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < this.f7697b.size(); i2 += 2) {
                linkedList.add(new BasicNameValuePair((String) this.f7697b.get(i2), (String) this.f7697b.get(i2 + 1)));
            }
            a = new C0626c().m2856b(this.f7698c).m2853a(HttpPost.METHOD_NAME).m2854a(linkedList).m2851a();
        } else {
            a = new C0626c().m2856b(this.f7698c).m2853a(this.f7696a).m2851a();
        }
        while (i < this.f7699d.size()) {
            a.m2835a((String) this.f7699d.get(i), (String) this.f7699d.get(i + 1));
            i += 2;
        }
        String b = new C0237c(this).m550b(execute(a), HTTP.UTF_8);
        try {
            this.f7702g = new JSONObject(b);
        } catch (Exception e) {
            this.f7702g = b;
        }
    }

    protected void onSessionSucceeded() {
        this.f7701f.f7695b.f7581b.web_notifyWeb(this.f7700e, 2, Mipay.KEY_RESULT, Integer.valueOf(0), "data", this.f7702g);
    }

    protected void onSessionFailed() {
        this.f7701f.f7695b.f7581b.web_notifyWeb(this.f7700e, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }
}
