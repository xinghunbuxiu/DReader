package com.duokan.reader.domain.bookshelf;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.domain.account.UserAccount;

class jf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ UserAccount f3384a;
    /* renamed from: b */
    final /* synthetic */ it f3385b;

    jf(it itVar, UserAccount userAccount) {
        this.f3385b = itVar;
        this.f3384a = userAccount;
    }

    public void run() {
        WebLog.init().w(this.f3385b.f3365i == null);
        this.f3385b.f3365i = new jp(this.f3385b, this.f3385b.f3363g, this.f3384a.mo833c());
    }
}
