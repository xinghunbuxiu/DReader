package com.duokan.d;

import android.os.Build.VERSION;
import android.text.TextUtils;

import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.i;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyWebSession extends WebSession {
    static final boolean a = (!d.class.desiredAssertionStatus());
    final d b;
    private JSONObject c;

    public MyWebSession(d dVar) {
        this.b = dVar;
    }

    protected void onSessionTry() {
        ad adVar = new ad(this, null);
        List arrayList = new ArrayList();
        if (ReaderEnv.get().getBuildName().equals("Reader")) {
            arrayList.add(new BasicNameValuePair("package_name", "com.duokan.reader1"));
        } else {
            arrayList.add(new BasicNameValuePair("package_name", this.b.a.getPackageName()));
        }
        arrayList.add(new BasicNameValuePair("build", this.b.c() + ""));
        arrayList.add(new BasicNameValuePair("client_id", i.f().i()));
        arrayList.add(new BasicNameValuePair("sdk", Integer.toString(VERSION.SDK_INT)));
        arrayList.add(new BasicNameValuePair("info", this.b.b()));
        arrayList.add(new BasicNameValuePair("beta", DkApp.get().forCommunity() ? "1" : "0"));
        this.c = adVar.a(adVar.a(new c().b(p.i().x()).a(arrayList).a(HttpPost.METHOD_NAME).a()));
    }

    protected void onSessionSucceeded() {
        Object obj = null;
        if (a || this.b.b != null) {
            try {
                String str;
                boolean z;
                Object obj2 = this.c.has("apk") ? (String) this.c.get("apk") : null;
                if (this.c.has(ClientCookie.VERSION_ATTR)) {
                    str = (String) this.c.get(ClientCookie.VERSION_ATTR);
                } else {
                    str = null;
                }
                if (this.c.has("note")) {
                    obj = (String) this.c.get("note");
                }
                if (this.c.has("force") && this.c.getBoolean("force")) {
                    z = true;
                } else {
                    z = false;
                }
                if (TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj) || TextUtils.isEmpty(str)) {
                    ReaderEnv.get().setNewVersion(0);
                    this.b.b.onNoUpdate();
                    a();
                    return;
                }
                ReaderEnv.get().setNewVersion(Integer.parseInt(str));
                if (Integer.parseInt(str) > this.b.c()) {
                    this.b.b.onUpdate(obj2, obj, z);
                    return;
                }
                this.b.b.onNoUpdate();
                a();
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        throw new AssertionError();
    }

    protected void onSessionFailed() {
    }

    private void a() {
        new g(this).open();
    }
}
