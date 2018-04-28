package com.duokan.reader.ui.personal;

import android.content.Context;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.domain.cloud.C0848h;
import com.duokan.reader.domain.social.p047a.C1132b;
import com.duokan.reader.domain.social.p048b.C1135b;
import com.duokan.reader.domain.social.p048b.C1136c;

public class fo implements nc {
    /* renamed from: a */
    private final C1135b f8550a;
    /* renamed from: b */
    private final C1132b f8551b;

    public fo() {
        PersonalAccount personalAccount = (PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class);
        if (personalAccount.mo835e() == AccountType.XIAO_MI) {
            bd bdVar = (bd) personalAccount.mo836f();
            this.f8550a = bdVar.f2405e;
            this.f8551b = bdVar.f2406f;
            return;
        }
        this.f8550a = new C1135b();
        this.f8550a.f5458a = new User();
        this.f8550a.f5458a.mUserId = personalAccount.mo832b();
        this.f8550a.f5458a.mNickName = personalAccount.mo836f().mo871a();
        this.f8550a.f5458a.mIconUrl = "";
        this.f8550a.f5458a.mIsVip = false;
        this.f8550a.f5459b = new C1136c(this.f8550a.f5458a);
        this.f8551b = new C1132b();
    }

    /* renamed from: a */
    public boolean mo1905a() {
        return true;
    }

    /* renamed from: b */
    public long mo1906b() {
        return C0848h.m5604a().m5624c();
    }

    /* renamed from: c */
    public long mo1907c() {
        return C0848h.m5604a().m5625d();
    }

    /* renamed from: d */
    public long mo1908d() {
        return C0848h.m5604a().m5626e();
    }

    /* renamed from: e */
    public long mo1909e() {
        return C0848h.m5604a().m5627f();
    }

    /* renamed from: f */
    public double mo1910f() {
        return C0848h.m5604a().m5628g();
    }

    /* renamed from: g */
    public long mo1911g() {
        return C0848h.m5604a().m5629h();
    }

    /* renamed from: h */
    public int[] mo1912h() {
        return C0848h.m5604a().m5630i();
    }

    /* renamed from: a */
    public void mo1904a(Context context, nd ndVar) {
        m11804b(context, ndVar);
    }

    /* renamed from: b */
    private void m11804b(Context context, nd ndVar) {
        C0848h.m5604a().m5619a(true, new fp(this, context, ndVar));
    }

    /* renamed from: c */
    private void m11805c(Context context, nd ndVar) {
        ((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo829a(DkApp.get().getTopActivity(), new fq(this, ndVar));
    }
}
