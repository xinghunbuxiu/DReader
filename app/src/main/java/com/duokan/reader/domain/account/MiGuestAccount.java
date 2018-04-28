package com.duokan.reader.domain.account;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.domain.social.p048b.C1135b;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import com.xiaomi.security.SignatureCoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class MiGuestAccount extends UserAccount {
    /* renamed from: e */
    public ExtendedAuthToken f2258e;
    /* renamed from: f */
    public String f2259f;
    /* renamed from: g */
    private String f2260g;
    /* renamed from: h */
    private String f2261h;
    /* renamed from: i */
    private cm<bl> f2262i;
    /* renamed from: j */
    private bl f2263j;
    /* renamed from: k */
    private final RequestEnv f2264k;

    private MiGuestAccount(C0706e c0706e) {
        super(c0706e);
        this.f2260g = "";
        this.f2261h = "";
        this.f2262i = null;
        this.f2263j = new bl();
        this.f2264k = new be(this);
    }

    /* renamed from: a */
    public void mo847a(Context context, String str, ba baVar) {
        new bf(this, str, baVar).open();
    }

    /* renamed from: s */
    public C1135b mo849s() {
        if (this.f2263j == null) {
            return null;
        }
        return this.f2263j.f2429f;
    }

    /* renamed from: b */
    public String mo832b() {
        return this.f2260g;
    }

    /* renamed from: c */
    public String mo833c() {
        return this.f2260g;
    }

    /* renamed from: d */
    public String mo834d() {
        return this.f2261h;
    }

    /* renamed from: e */
    public AccountType mo835e() {
        return AccountType.XIAOMI_GUEST;
    }

    /* renamed from: f */
    public C0705g mo836f() {
        return this.f2263j;
    }

    /* renamed from: g */
    public synchronized Map<String, String> mo837g() {
        return UserAccount.m3175a(null, this.f2261h);
    }

    /* renamed from: h */
    public Map<String, String> mo838h() {
        return UserAccount.m3175a(this.f2260g, this.f2261h);
    }

    /* renamed from: a */
    public void mo829a(Activity activity, C0700d c0700d) {
        new bg(this, c0700d).open();
    }

    /* renamed from: i */
    public boolean mo839i() {
        return TextUtils.isEmpty(this.f2261h) || TextUtils.isEmpty(this.f2260g);
    }

    /* renamed from: j */
    public RequestEnv mo840j() {
        return this.f2264k;
    }

    /* renamed from: n */
    public void mo843n() {
        new bh(this).open();
    }

    /* renamed from: r */
    public void mo848r() {
        new bi(this).open();
    }

    /* renamed from: d */
    private C0624a m3225d(String str) {
        List linkedList = new LinkedList();
        TreeMap treeMap = new TreeMap();
        treeMap.put("sid", str);
        treeMap.put("visitorId", this.f2260g);
        treeMap.put("visitorSdkVersion", WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
        treeMap.put("visitorType", "5");
        treeMap.put("visitorDeviceId", "");
        treeMap.put("visitorPassToken", this.f2263j.f2425b.f2441c);
        String genSignature = SignatureCoder.genSignature(HttpPost.METHOD_NAME, "/visitor/login", treeMap, "BEYBuDbVZqYHzAVT+TAAAA==");
        linkedList.add(new BasicNameValuePair("visitorId", this.f2260g));
        linkedList.add(new BasicNameValuePair("sid", str));
        linkedList.add(new BasicNameValuePair("visitorType", "5"));
        C0624a a = new C0626c().m2853a(HttpPost.METHOD_NAME).m2856b("https://v.id.mi.com/visitor/login").m2854a(linkedList).m2851a();
        a.m2835a(SM.COOKIE, "visitorSdkVersion=-1;visitorPassToken=" + this.f2263j.f2425b.f2441c + ";_sign=" + genSignature);
        return a;
    }

    /* renamed from: a */
    public void mo830a(C0699c c0699c) {
        this.f2261h = "";
        this.f2263j = new bl();
        m3155l();
        c0699c.mo867a(this);
        this.a.mo880b(this);
    }

    /* renamed from: a */
    protected void mo831a(String str, String str2, String str3) {
        this.f2260g = str;
        try {
            this.f2261h = new JSONObject(str3).optString("login_token");
            this.f2263j = bl.m3408a(new JSONObject(str2), TextUtils.isEmpty(str3) ? null : new JSONObject(str3));
        } catch (JSONException e) {
        }
        mo848r();
        mo843n();
    }

    /* renamed from: m */
    protected String mo842m() {
        JSONObject c = this.f2263j.m3412c();
        c.put("login_token", this.f2261h);
        return c.toString();
    }

    /* renamed from: a */
    public boolean m3230a(JSONObject jSONObject) {
        try {
            this.f2262i = new cm(jSONObject.getJSONObject("xiaomi").getString("visitorId"), jSONObject.getJSONObject("duokan").getString("token"), bl.m3408a(jSONObject, null));
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    /* renamed from: t */
    public synchronized void mo850t() {
        if (this.f2262i != null) {
            this.f2260g = this.f2262i.m3447b();
            this.f2261h = this.f2262i.m3448c();
            this.f2263j = (bl) this.f2262i.m3449d();
            m3155l();
            mo829a(null, new bj(this));
            this.f2262i = null;
        }
    }

    /* renamed from: o */
    public boolean mo844o() {
        return true;
    }

    /* renamed from: p */
    public boolean mo845p() {
        return true;
    }

    /* renamed from: q */
    public boolean mo846q() {
        return true;
    }

    /* renamed from: v */
    public synchronized cm<bl> mo852v() {
        return this.f2262i;
    }

    /* renamed from: u */
    public synchronized void mo851u() {
        this.f2262i = null;
    }
}
