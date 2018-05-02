package com.duokan.reader.domain.account;

/* renamed from: com.duokan.reader.domain.account.n */
class C0712n implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0699c f2489a;
    /* renamed from: b */
    final /* synthetic */ C0709k f2490b;

    C0712n(C0709k c0709k, C0699c c0699c) {
        this.f2490b = c0709k;
        this.f2489a = c0699c;
    }

    public void run() {
        C0672a b = this.f2490b.m3502b(PersonalAccount.class);
        if (b.mo839i() || !b.mo835e().equals(AccountType.XIAO_MI)) {
            this.f2489a.mo867a(b);
        } else {
            b.mo830a(this.f2489a);
        }
    }
}
