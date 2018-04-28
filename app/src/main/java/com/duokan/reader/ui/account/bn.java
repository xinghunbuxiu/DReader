package com.duokan.reader.ui.account;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.store.DkShareBook;
import com.duokan.reader.ui.general.be;
import java.util.List;

class bn extends WebSession {
    /* renamed from: a */
    C0621a<DkShareBook> f5878a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ List f5879b;
    /* renamed from: c */
    final /* synthetic */ bl f5880c;

    bn(bl blVar, C0657i c0657i, List list) {
        this.f5880c = blVar;
        this.f5879b = list;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0647u c0647u = new C0647u(this, C0709k.m3476a().m3502b(PersonalAccount.class));
        int i = 0;
        while (i < this.f5880c.f5872i.length) {
            this.f5878a = c0647u.m3040e(this.f5880c.f5872i[i].trim());
            if (this.f5878a.b == 0) {
                DkShareBook dkShareBook = (DkShareBook) this.f5878a.f2058a;
                dkShareBook.mTraceId = this.f5880c.f5873j.length > i ? this.f5880c.f5873j[i] : "";
                this.f5879b.add(dkShareBook);
            }
            i++;
        }
    }

    protected void onSessionSucceeded() {
        if (!this.f5880c.g) {
            if (this.f5879b.size() == this.f5880c.f5872i.length) {
                this.f5880c.m8931a(this.f5879b);
                if (this.f5880c.b.equals("system")) {
                    this.f5880c.m8885e();
                    this.f5880c.m8937c(this.f5879b);
                    return;
                } else if (this.f5880c.b.equals("weibo")) {
                    bd ayVar = new ay(this.f5880c.getActivity(), this.f5880c.c, this.f5879b, this.f5880c.h);
                    ayVar.setOnShowListener(new bo(this));
                    ayVar.show();
                    return;
                } else {
                    this.f5880c.m8883c();
                    return;
                }
            }
            this.f5880c.m8885e();
            CharSequence string = this.f5880c.getString(C0258j.get_book_detail_fail);
            if (this.f5880c.h != null) {
                this.f5880c.h.mo1845b(string);
                this.f5880c.h = null;
                return;
            }
            be.m10287a(this.f5880c.getContext(), string, 0).show();
        }
    }

    protected void onSessionFailed() {
        if (!this.f5880c.g) {
            this.f5880c.m8885e();
            CharSequence string = this.f5880c.getString(C0258j.get_book_detail_fail);
            if (this.f5880c.h != null) {
                this.f5880c.h.mo1845b(string);
                this.f5880c.h = null;
                return;
            }
            be.m10287a(this.f5880c.getContext(), string, 0).show();
        }
    }

    protected void onSessionClosed() {
        this.f5880c.g = false;
    }
}
