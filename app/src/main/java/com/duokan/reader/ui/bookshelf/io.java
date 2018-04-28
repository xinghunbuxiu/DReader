package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import java.util.ArrayList;
import java.util.List;

class io extends jd {
    /* renamed from: a */
    final al f6625a = new al(C0709k.m3476a().m3502b(PersonalAccount.class));
    /* renamed from: b */
    int f6626b = 0;
    /* renamed from: c */
    final /* synthetic */ ie f6627c;
    /* renamed from: e */
    private C0621a<Integer> f6628e = null;
    /* renamed from: f */
    private C0621a<Integer> f6629f = null;

    io(ie ieVar) {
        this.f6627c = ieVar;
        super(ieVar);
    }

    protected void onSessionTry() {
        C0640n c0640n = new C0640n(this, this.f6625a);
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(2));
        this.f6628e = c0640n.m2913a(-1, arrayList);
        this.f6629f = c0640n.m2916b();
    }

    protected void onSessionSucceeded() {
        if (PersonalPrefs.m5175a().m5209a(this.f6625a)) {
            if (this.f6628e.b == 0) {
                this.f6626b = ((Integer) this.f6628e.f2058a).intValue() + this.f6626b;
            }
            if (this.f6629f.b == 0) {
                this.f6626b = ((Integer) this.f6629f.f2058a).intValue() + this.f6626b;
            }
        }
        this.f6627c.f6596h.setText(String.valueOf(this.f6626b));
    }

    protected void onSessionFailed() {
        this.f6627c.f6596h.setText(String.valueOf(this.f6626b));
    }
}
