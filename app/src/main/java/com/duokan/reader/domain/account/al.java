package com.duokan.reader.domain.account;

import android.text.TextUtils;
import java.util.Map;

public class al {
    /* renamed from: g */
    public static final al f2359g = new al();
    /* renamed from: a */
    public final String f2360a;
    /* renamed from: b */
    public final AccountType f2361b;
    /* renamed from: c */
    public final String f2362c;
    /* renamed from: d */
    public final String f2363d;
    /* renamed from: e */
    public final String f2364e;
    /* renamed from: f */
    public final Map<String, String> f2365f;

    public al() {
        this(null);
    }

    public al(C0672a c0672a) {
        if (c0672a == null || c0672a.mo839i()) {
            this.f2360a = "";
            this.f2361b = AccountType.NONE;
            this.f2362c = "";
            this.f2363d = "";
            this.f2364e = "";
            this.f2365f = null;
            return;
        }
        this.f2360a = c0672a.mo832b();
        this.f2361b = c0672a.mo835e();
        this.f2362c = c0672a.mo833c();
        this.f2363d = c0672a.mo836f().mo871a();
        this.f2364e = c0672a.mo834d();
        this.f2365f = c0672a.mo837g();
    }

    /* renamed from: a */
    public boolean m3364a() {
        if (this.f2361b == AccountType.XIAO_MI || this.f2361b == AccountType.XIAOMI_GUEST) {
            if (TextUtils.isEmpty(this.f2362c) || TextUtils.isEmpty(this.f2364e)) {
                return true;
            }
            return false;
        } else if (this.f2361b == AccountType.ANONYMOUS) {
            return TextUtils.isEmpty(this.f2362c);
        } else {
            return true;
        }
    }

    /* renamed from: b */
    public boolean m3366b() {
        return !m3367c();
    }

    /* renamed from: c */
    public boolean m3367c() {
        return !m3364a() && (AccountType.XIAO_MI.equals(this.f2361b) || AccountType.XIAOMI_GUEST.equals(this.f2361b));
    }

    /* renamed from: a */
    public boolean m3365a(al alVar) {
        return TextUtils.equals(this.f2360a, alVar.f2360a);
    }
}
