package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.a.a;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.mipay.sdk.Mipay;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class co extends WebSession {
    final /* synthetic */ String a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ String c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ String e;
    final /* synthetic */ cn f;
    private Object g = null;

    co(cn cnVar, String str, ArrayList arrayList, String str2, ArrayList arrayList2, String str3) {
        this.f = cnVar;
        this.a = str;
        this.b = arrayList;
        this.c = str2;
        this.d = arrayList2;
        this.e = str3;
    }

    protected void onSessionTry() {
        a a;
        int i = 0;
        if (TextUtils.equals(this.a, HttpPost.METHOD_NAME)) {
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < this.b.size(); i2 += 2) {
                linkedList.add(new BasicNameValuePair((String) this.b.get(i2), (String) this.b.get(i2 + 1)));
            }
            a = new c().b(this.c).a(HttpPost.METHOD_NAME).a(linkedList).a();
        } else {
            a = new c().b(this.c).a(this.a).a();
        }
        while (i < this.d.size()) {
            a.a((String) this.d.get(i), (String) this.d.get(i + 1));
            i += 2;
        }
        String b = new d(this).b(execute(a), HTTP.UTF_8);
        try {
            this.g = new JSONObject(b);
        } catch (Exception e) {
            this.g = b;
        }
    }

    protected void onSessionSucceeded() {
        this.f.b.b.web_notifyWeb(this.e, 2, Mipay.KEY_RESULT, Integer.valueOf(0), "data", this.g);
    }

    protected void onSessionFailed() {
        this.f.b.b.web_notifyWeb(this.e, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }
}
