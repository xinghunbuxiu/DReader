package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.domain.social.p048b.C1135b;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MiAccount extends UserAccount {
    /* renamed from: e */
    private String f2252e;
    /* renamed from: f */
    private String f2253f;
    /* renamed from: g */
    private bd f2254g;
    /* renamed from: h */
    private final RequestEnv f2255h;
    /* renamed from: i */
    private cm<bd> f2256i;
    /* renamed from: j */
    private final BroadcastReceiver f2257j;

    /* renamed from: f */
    public /* synthetic */ C0705g mo836f() {
        return mo848r();
    }

    private MiAccount(C0706e c0706e) {
        super(c0706e);
        this.f2252e = "";
        this.f2253f = "";
        this.f2254g = new bd("");
        this.f2256i = null;
        this.f2257j = new ar(this);
        this.f2255h = new as(this);
    }

    /* renamed from: w */
    private void m3190w() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.accounts.LOGIN_ACCOUNTS_CHANGED");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        DkApp.get().getApplicationContext().registerReceiver(this.f2257j, intentFilter);
    }

    /* renamed from: x */
    private void m3191x() {
        try {
            DkApp.get().getApplicationContext().unregisterReceiver(this.f2257j);
        } catch (Exception e) {
        }
    }

    /* renamed from: y */
    private void m3192y() {
        if (!mo839i()) {
            C0542e.m2413b(DkApp.get().getApplicationContext());
        }
    }

    /* renamed from: n */
    public boolean mo843n() {
        Account c = m3187c(DkApp.get().getApplicationContext());
        if (c == null || TextUtils.isEmpty(this.f2252e)) {
            return false;
        }
        return this.f2252e.equals(c.name);
    }

    /* renamed from: a */
    public static boolean m3184a(Context context) {
        return C0538a.m2388a(context).m2399a();
    }

    /* renamed from: b */
    public static boolean m3186b(Context context) {
        return m3187c(context) != null;
    }

    /* renamed from: c */
    public static Account m3187c(Context context) {
        return C0538a.m2388a(context).m2410j();
    }

    /* renamed from: b */
    public String mo832b() {
        return this.f2252e;
    }

    /* renamed from: c */
    public String mo833c() {
        return this.f2252e;
    }

    /* renamed from: d */
    public String mo834d() {
        return this.f2253f;
    }

    /* renamed from: e */
    public AccountType mo835e() {
        return AccountType.XIAO_MI;
    }

    /* renamed from: r */
    public bd mo848r() {
        return this.f2254g;
    }

    /* renamed from: g */
    public synchronized Map<String, String> mo837g() {
        return UserAccount.m3175a(null, this.f2253f);
    }

    /* renamed from: h */
    public Map<String, String> mo838h() {
        return UserAccount.m3175a(this.f2252e, this.f2253f);
    }

    /* renamed from: d */
    public void m3202d(String str) {
        this.f2254g.f2405e.f5458a.mIconUrl = str;
        m3155l();
        this.a.mo881c(this);
    }

    /* renamed from: e */
    public void m3204e(String str) {
        if (!str.startsWith("file://")) {
            str = "file://" + str;
        }
        m3202d(str);
    }

    /* renamed from: f */
    public void m3206f(String str) {
        this.f2254g.f2405e.f5458a.mNickName = str;
        m3155l();
        this.a.mo881c(this);
    }

    /* renamed from: a */
    public void mo830a(C0699c c0699c) {
        C0328a.m757c().m752c(LogLevel.EVENT, "miaccount", "log off");
        this.f2253f = "";
        this.f2254g = new bd(this.f2252e);
        m3155l();
        C0538a.m2388a(DkApp.get()).m2396a(this.f2252e, new at(this, c0699c));
    }

    /* renamed from: a */
    public void mo829a(Activity activity, C0700d c0700d) {
        C0538a a = C0542e.m2411a(DkApp.get().getApplicationContext());
        Account i = a.m2409i();
        if (i != null) {
            if (activity != null) {
                a.m2391a(i, "passportapi", null, activity, new au(this, i, activity, c0700d));
                return;
            }
            m3181a(i, activity, null, c0700d);
        }
    }

    /* renamed from: i */
    public boolean mo839i() {
        return TextUtils.isEmpty(mo833c()) || TextUtils.isEmpty(mo834d());
    }

    /* renamed from: a */
    private void m3181a(Account account, Activity activity, String str, C0700d c0700d) {
        new av(this, bc.f2400a, str, C0542e.m2411a(DkApp.get().getApplicationContext()), account, c0700d, activity).open();
    }

    /* renamed from: a */
    protected void mo831a(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONException e;
        C0538a a;
        this.f2252e = str;
        if (TextUtils.isEmpty(str3)) {
            this.f2253f = "";
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(str3);
                try {
                    this.f2253f = jSONObject.optString("login_token");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    a = C0542e.m2412a(DkApp.get(), true);
                    if (mo839i()) {
                        this.f2254g = new bd(this.f2252e);
                        a.m2395a(new aw(this, a));
                        return;
                    }
                    try {
                        this.f2254g = bd.m3400a(this.f2252e, new JSONObject(str2), jSONObject);
                    } catch (Throwable th) {
                        this.f2254g = new bd(this.f2252e);
                    }
                    if (!mo839i()) {
                    }
                    a.m2406f();
                    a.m2400a(new Account(this.f2252e, "com.xiaomi"), ExtendedAuthToken.build(this.f2254g.f2401a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").toPlain(), null);
                    if (mo839i()) {
                        m3190w();
                        m3192y();
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
                e.printStackTrace();
                a = C0542e.m2412a(DkApp.get(), true);
                if (mo839i()) {
                    this.f2254g = bd.m3400a(this.f2252e, new JSONObject(str2), jSONObject);
                    if (mo839i()) {
                    }
                    a.m2406f();
                    a.m2400a(new Account(this.f2252e, "com.xiaomi"), ExtendedAuthToken.build(this.f2254g.f2401a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").toPlain(), null);
                    if (mo839i()) {
                        m3190w();
                        m3192y();
                    }
                }
                this.f2254g = new bd(this.f2252e);
                a.m2395a(new aw(this, a));
                return;
            }
        }
        a = C0542e.m2412a(DkApp.get(), true);
        if (mo839i()) {
            this.f2254g = new bd(this.f2252e);
            a.m2395a(new aw(this, a));
            return;
        }
        this.f2254g = bd.m3400a(this.f2252e, new JSONObject(str2), jSONObject);
        if (mo839i() || !TextUtils.isEmpty(mo848r().f2401a)) {
            a.m2406f();
            if (a.m2401a("com.xiaomi") == null || a.m2401a("com.xiaomi").length == 0) {
                a.m2400a(new Account(this.f2252e, "com.xiaomi"), ExtendedAuthToken.build(this.f2254g.f2401a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").toPlain(), null);
            }
        } else {
            a.m2407g();
        }
        if (mo839i()) {
            m3190w();
            m3192y();
        }
    }

    /* renamed from: m */
    protected String mo842m() {
        JSONObject jSONObject = new JSONObject();
        bd r = mo848r();
        if (r != null) {
            try {
                jSONObject.put("miPassToken", r.f2401a);
                jSONObject.put("dushuServiceToken", r.f2402b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            jSONObject.put("login_token", this.f2253f);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: k */
    protected void mo841k() {
        super.mo841k();
        if (!mo839i() && TextUtils.isEmpty(mo848r().f2401a) && !mo843n()) {
            mo830a(new ax(this));
        }
    }

    /* renamed from: a */
    public void mo847a(Context context, String str, ba baVar) {
        new ay(this, this.f2252e, bc.f2400a, str, baVar).open();
    }

    /* renamed from: a */
    public void m3195a(C0672a c0672a) {
        this.a.mo878a(c0672a);
    }

    /* renamed from: s */
    public C1135b mo849s() {
        if (this.f2254g == null || this.f2254g.f2405e == null) {
            return null;
        }
        return this.f2254g.f2405e;
    }

    /* renamed from: t */
    public synchronized void mo850t() {
        if (this.f2256i != null) {
            this.f2252e = this.f2256i.m3447b();
            this.f2253f = this.f2256i.m3448c();
            this.f2254g = (bd) this.f2256i.m3449d();
            m3155l();
            if (!mo839i()) {
                m3190w();
                m3192y();
            }
            mo829a(null, new az(this));
            this.f2256i = null;
        }
    }

    /* renamed from: u */
    public synchronized void mo851u() {
        this.f2256i = null;
    }

    /* renamed from: v */
    public synchronized cm mo852v() {
        return this.f2256i;
    }

    /* renamed from: a */
    public synchronized void m3197a(cm cmVar) {
        this.f2256i = cmVar;
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

    /* renamed from: j */
    public RequestEnv mo840j() {
        return this.f2255h;
    }
}
