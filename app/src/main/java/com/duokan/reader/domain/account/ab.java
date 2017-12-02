package com.duokan.reader.domain.account;

import android.text.TextUtils;

import java.util.Map;

public class ab {
    public static final ab g = new ab();
    public final String a;
    public final AccountType b;
    public final String c;
    public final String d;
    public final String e;
    public final Map f;

    public ab() {
        this(null);
    }

    public ab(a aVar) {
        if (aVar == null || aVar.i()) {
            this.a = "";
            this.b = AccountType.NONE;
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = null;
            return;
        }
        this.a = aVar.b();
        this.b = aVar.e();
        this.c = aVar.c();
        this.d = aVar.f().a();
        this.e = aVar.d();
        this.f = aVar.g();
    }

    public boolean a() {
        if (this.b == AccountType.XIAO_MI || this.b == AccountType.XIAOMI_GUEST) {
            if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.e)) {
                return true;
            }
            return false;
        } else if (this.b == AccountType.ANONYMOUS) {
            return TextUtils.isEmpty(this.c);
        } else {
            return true;
        }
    }

    public boolean b() {
        return !c();
    }

    public boolean c() {
        return !a() && (AccountType.XIAO_MI.equals(this.b) || AccountType.XIAOMI_GUEST.equals(this.b));
    }

    public boolean a(ab abVar) {
        return TextUtils.equals(this.a, abVar.a);
    }
}
