package com.duokan.reader.ui.personal;

import android.content.Context;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.bh;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.h;
import com.duokan.reader.domain.social.b.b;
import com.duokan.reader.domain.social.b.c;

public class fa implements mo {
    private final b a;
    private final com.duokan.reader.domain.social.a.b b;

    public fa() {
        PersonalAccount personalAccount = (PersonalAccount) i.f().b(PersonalAccount.class);
        if (personalAccount.e() == AccountType.XIAO_MI) {
            bh bhVar = (bh) personalAccount.f();
            this.a = bhVar.e;
            this.b = bhVar.f;
            return;
        }
        this.a = new b();
        this.a.a = new User();
        this.a.a.mUserId = personalAccount.b();
        this.a.a.mNickName = personalAccount.f().a();
        this.a.a.mIconUrl = "";
        this.a.a.mIsVip = false;
        this.a.b = new c(this.a.a);
        this.b = new com.duokan.reader.domain.social.a.b();
    }

    public boolean a() {
        return true;
    }

    public long b() {
        return h.a().c();
    }

    public long c() {
        return h.a().d();
    }

    public long d() {
        return h.a().e();
    }

    public long e() {
        return h.a().f();
    }

    public double f() {
        return h.a().g();
    }

    public long g() {
        return h.a().h();
    }

    public int[] h() {
        return h.a().i();
    }

    public void a(Context context, mp mpVar) {
        b(context, mpVar);
    }

    private void b(Context context, mp mpVar) {
        h.a().a(true, new fb(this, context, mpVar));
    }

    private void c(Context context, mp mpVar) {
        ((PersonalAccount) i.f().b(PersonalAccount.class)).a(DkApp.get().getTopActivity(), new fc(this, mpVar));
    }
}
