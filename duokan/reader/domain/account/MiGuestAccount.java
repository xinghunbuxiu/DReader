package com.duokan.reader.domain.account;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.duokan.reader.common.webservices.duokan.a.a;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.domain.social.b.b;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import com.xiaomi.security.SignatureCoder;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MiGuestAccount extends UserAccount {
    private static bf k;
    public ExtendedAuthToken e;
    public String f;
    private String g = "";
    private String h = "";
    private cf i = null;
    private bq j = new bq();
    private final RequestEnv l = new bi(this);

    public MiGuestAccount(e eVar) {
        super(eVar);
    }

    public void a(Context context, String str, bb bbVar) {
        new bj(this, str, bbVar).open();
    }

    public b s() {
        if (this.j == null) {
            return null;
        }
        return this.j.f;
    }

    public static void a(bf bfVar) {
        k = bfVar;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public AccountType e() {
        return AccountType.XIAOMI_GUEST;
    }

    public g f() {
        return this.j;
    }

    public synchronized Map g() {
        return UserAccount.a(null, this.h);
    }

    public Map h() {
        return UserAccount.a(this.g, this.h);
    }

    public void a(Activity activity, d dVar) {
        new bk(this, dVar).open();
    }

    public boolean i() {
        return TextUtils.isEmpty(this.h) || TextUtils.isEmpty(this.g);
    }

    protected void a(b bVar, String str) {
        new bl(this, str, bVar).open();
    }

    public RequestEnv j() {
        return this.l;
    }

    public void n() {
        new bn(this).open();
    }

    public void o() {
        new bo(this).open();
    }

    private a d(String str) {
        List linkedList = new LinkedList();
        TreeMap treeMap = new TreeMap();
        treeMap.put("sid", str);
        treeMap.put("visitorId", this.g);
        treeMap.put("visitorSdkVersion", WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
        treeMap.put("visitorType", "5");
        treeMap.put("visitorDeviceId", "");
        treeMap.put("visitorPassToken", this.j.b.f);
        String genSignature = SignatureCoder.genSignature(HttpPost.METHOD_NAME, "/visitor/login", treeMap, "BEYBuDbVZqYHzAVT+TAAAA==");
        linkedList.add(new BasicNameValuePair("visitorId", this.g));
        linkedList.add(new BasicNameValuePair("sid", str));
        linkedList.add(new BasicNameValuePair("visitorType", "5"));
        a a = new c().a(HttpPost.METHOD_NAME).b("https://v.id.mi.com/visitor/login").a(linkedList).a();
        a.a(SM.COOKIE, "visitorSdkVersion=-1;visitorPassToken=" + this.j.b.f + ";_sign=" + genSignature);
        return a;
    }

    public void a(c cVar) {
        this.h = "";
        this.j = new bq();
        l();
        cVar.a(this);
        this.a.b(this);
    }

    protected void a(String str, String str2, String str3) {
        this.g = str;
        try {
            this.h = new JSONObject(str3).optString("login_token");
            this.j = bq.a(new JSONObject(str2), TextUtils.isEmpty(str3) ? null : new JSONObject(str3));
        } catch (JSONException e) {
        }
        o();
        n();
    }

    protected String m() {
        JSONObject c = this.j.c();
        c.put("login_token", this.h);
        return c.toString();
    }

    public boolean a(JSONObject jSONObject) {
        try {
            this.i = new cf(jSONObject.getJSONObject("xiaomi").getString("visitorId"), jSONObject.getJSONObject("duokan").getString("token"), bq.a(jSONObject, null));
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public synchronized void t() {
        if (this.i != null) {
            this.g = this.i.b();
            this.h = this.i.c();
            this.j = (bq) this.i.d();
            l();
            a(null, new bp(this));
            this.i = null;
        }
    }

    public boolean p() {
        return true;
    }

    public boolean q() {
        return true;
    }

    public boolean r() {
        return true;
    }

    public synchronized cf v() {
        return this.i;
    }

    public synchronized void u() {
        this.i = null;
    }
}
