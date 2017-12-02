package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.t;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.b.a;
import com.duokan.reader.common.b.e;
import com.duokan.reader.domain.social.b.b;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import miuipub.date.Calendar;

public class MiAccount extends UserAccount {
    private static bf e = null;
    private String f = "";
    private String g = "";
    private bh h = new bh("");
    private final RequestEnv i = new an(this);
    private cf j = null;
    private final BroadcastReceiver k = new ac(this);

    public /* synthetic */ g f() {
        return o();
    }

    public MiAccount(e eVar) {
        super(eVar);
    }

    private void x() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.accounts.LOGIN_ACCOUNTS_CHANGED");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        DkApp.get().getApplicationContext().registerReceiver(this.k, intentFilter);
    }

    private void y() {
        try {
            DkApp.get().getApplicationContext().unregisterReceiver(this.k);
        } catch (Exception e) {
        }
    }

    private void z() {
        if (!i()) {
            e.b(DkApp.get().getApplicationContext());
        }
    }

    public boolean n() {
        Account b = b(DkApp.get().getApplicationContext());
        if (b == null || TextUtils.isEmpty(this.f)) {
            return false;
        }
        return this.f.equals(b.name);
    }

    public static boolean a(Context context) {
        return b(context) != null;
    }

    public static Account b(Context context) {
        return a.a(context).j();
    }

    public static void a(bf bfVar) {
        e = bfVar;
    }

    public String b() {
        return this.f;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public AccountType e() {
        return AccountType.XIAO_MI;
    }

    public bh o() {
        return this.h;
    }

    public synchronized Map g() {
        return UserAccount.a(null, this.g);
    }

    public Map h() {
        return UserAccount.a(this.f, this.g);
    }

    public void d(String str) {
        this.h.e.a.mIconUrl = str;
        l();
        this.a.c(this);
    }

    public void e(String str) {
        if (!str.startsWith("file://")) {
            str = "file://" + str;
        }
        d(str);
    }

    public void f(String str) {
        this.h.e.a.mNickName = str;
        l();
        this.a.c(this);
    }

    public synchronized void a(b bVar) {
        a a = e.a(DkApp.get(), true);
        if (i()) {
            a.a(new at(this, bVar));
        } else {
            com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "miaccount", "relogin(name: %s, invalid token prefix: %s)", this.f, this.g.substring(0, this.g.length() / 4));
            e.b((a) this, bVar);
        }
    }

    public synchronized void b(b bVar) {
        a a = e.a(DkApp.get(), true);
        if (i()) {
            a.a(new av(this, a, bVar));
        } else {
            com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "miaccount", "relogin(name: %s, invalid token prefix: %s)", this.f, this.g.substring(0, this.g.length() / 4));
            e.b((a) this, bVar);
        }
    }

    protected synchronized void c(b bVar) {
        a a = e.a(DkApp.get(), true);
        if (i()) {
            a.a(new aw(this, bVar));
        } else {
            com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "miaccount", "relogin(name: %s, invalid token prefix: %s)", this.f, this.g.substring(0, this.g.length() / 4));
            e.b((a) this, bVar);
        }
    }

    protected synchronized void d(b bVar) {
        a a = e.a(DkApp.get(), true);
        if (i()) {
            a.a(new ax(this, bVar));
        } else {
            com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "miaccount", "relogin(name: %s, invalid token prefix: %s)", this.f, this.g.substring(0, this.g.length() / 4));
            e.b((a) this, bVar);
        }
    }

    public void a(c cVar) {
        com.duokan.core.diagnostic.a.c().c(LogLevel.EVENT, "miaccount", "log off");
        this.g = "";
        this.h = new bh(this.f);
        l();
        a.a(DkApp.get()).a(this.f, new ay(this, cVar));
    }

    public void a(Activity activity, d dVar) {
        a a = e.a(DkApp.get().getApplicationContext());
        Account i = a.i();
        if (i != null) {
            if (activity != null) {
                a.a(i, "passportapi", null, activity, new az(this, i, activity, dVar));
                return;
            }
            a(i, activity, null, dVar);
        }
    }

    public boolean i() {
        return TextUtils.isEmpty(c()) || TextUtils.isEmpty(d());
    }

    private void a(Account account, Activity activity, String str, d dVar) {
        new ba(this, str, e.a(DkApp.get().getApplicationContext()), account, dVar, activity).open();
    }

    protected void a(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONException e;
        a a;
        this.f = str;
        if (TextUtils.isEmpty(str3)) {
            this.g = "";
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(str3);
                try {
                    this.g = jSONObject.optString("login_token");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    a = e.a(DkApp.get(), true);
                    if (i()) {
                        this.h = new bh(this.f);
                        a.a(new ad(this, a));
                        return;
                    }
                    try {
                        this.h = bh.a(this.f, new JSONObject(str2), jSONObject);
                    } catch (Throwable th) {
                        this.h = new bh(this.f);
                    }
                    if (!i()) {
                    }
                    a.f();
                    a.a(new Account(this.f, "com.xiaomi"), ExtendedAuthToken.build(this.h.a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").toPlain(), null);
                    if (i()) {
                        x();
                        z();
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
                e.printStackTrace();
                a = e.a(DkApp.get(), true);
                if (i()) {
                    this.h = bh.a(this.f, new JSONObject(str2), jSONObject);
                    if (i()) {
                    }
                    a.f();
                    a.a(new Account(this.f, "com.xiaomi"), ExtendedAuthToken.build(this.h.a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").toPlain(), null);
                    if (i()) {
                        x();
                        z();
                    }
                }
                this.h = new bh(this.f);
                a.a(new ad(this, a));
                return;
            }
        }
        a = e.a(DkApp.get(), true);
        if (i()) {
            this.h = new bh(this.f);
            a.a(new ad(this, a));
            return;
        }
        this.h = bh.a(this.f, new JSONObject(str2), jSONObject);
        if (i() || !TextUtils.isEmpty(o().a)) {
            a.f();
            if (a.a("com.xiaomi") == null || a.a("com.xiaomi").length == 0) {
                a.a(new Account(this.f, "com.xiaomi"), ExtendedAuthToken.build(this.h.a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").toPlain(), null);
            }
        } else {
            a.g();
        }
        if (i()) {
            x();
            z();
        }
    }

    protected String m() {
        JSONObject jSONObject = new JSONObject();
        bh o = o();
        if (o != null) {
            try {
                jSONObject.put("miPassToken", o.a);
                jSONObject.put("dushuServiceToken", o.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            jSONObject.put("login_token", this.g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    protected void k() {
        super.k();
        if (!i() && TextUtils.isEmpty(o().a) && !n()) {
            a(new ae(this));
        }
    }

    public void a(b bVar, int i) {
        a a = e.a(DkApp.get().getApplicationContext());
        com.duokan.reader.domain.statistics.dailystats.a.d().c();
        a.c();
        a(false, false, false, new af(this, a, bVar), 0);
    }

    public void e(b bVar) {
        a a = e.a(DkApp.get().getApplicationContext());
        com.duokan.reader.domain.statistics.dailystats.a.d().c();
        a.d();
        a(true, true, false, new ag(this, a, bVar), 0);
    }

    public void f(b bVar) {
        a a = e.a(DkApp.get().getApplicationContext());
        com.duokan.reader.domain.statistics.dailystats.a.d().c();
        a.c();
        a(false, false, false, new ah(this, a, bVar), 0);
    }

    public void g(b bVar) {
        a a = e.a(DkApp.get().getApplicationContext());
        com.duokan.reader.domain.statistics.dailystats.a.d().c();
        a.d();
        a(true, false, false, new ai(this, a, bVar), 0);
    }

    private void a(boolean z, boolean z2, boolean z3, be beVar, int i) {
        a a = e.a(DkApp.get().getApplicationContext(), true);
        Account i2 = a.i();
        AccountManagerCallback ajVar = new aj(this, z, beVar, a, i2);
        if (i2 != null) {
            AccountManagerFuture a2 = a.a(i2, "reader", null, DkApp.get().getTopActivity(), ajVar);
            if (i > 0) {
                t.a(new am(this, a2), (long) (i * Calendar.MILLISECOND_OF_SECOND));
            }
        } else if (z2) {
            Bundle bundle = null;
            if (z3) {
                bundle = new Bundle();
                bundle.putBoolean("add_option_register_account", true);
            }
            a.a("reader", null, bundle, DkApp.get().getTopActivity(), new al(this, a, ajVar, beVar));
        } else {
            beVar.b(i2, "");
        }
    }

    private void a(String str, boolean z, bd bdVar, int i) {
        int i2 = 1;
        String[] split = str.split("ABCDFGXYZ");
        if (split.length == 1) {
            i2 = 0;
        }
        String str2 = split[i2].split(",")[0];
        Account account = new Account(split[0], "com.xiaomi");
        bc aoVar = new ao(this, str2, account, bdVar, z, str);
        aoVar.open();
        if (i > 0) {
            t.a(new ap(this, aoVar, bdVar, account), (long) (i * Calendar.MILLISECOND_OF_SECOND));
        }
    }

    public void a(Context context, String str, bb bbVar) {
        new aq(this, str, bbVar, context).open();
    }

    public b s() {
        if (this.h == null || this.h.e == null) {
            return null;
        }
        return this.h.e;
    }

    public synchronized void t() {
        if (this.j != null) {
            this.f = this.j.b();
            this.g = this.j.c();
            this.h = (bh) this.j.d();
            l();
            if (!i()) {
                x();
                z();
            }
            a(null, new as(this));
            this.j = null;
        }
    }

    public synchronized void u() {
        this.j = null;
    }

    public synchronized cf v() {
        return this.j;
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

    public RequestEnv j() {
        return this.i;
    }
}
