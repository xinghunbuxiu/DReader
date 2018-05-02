package com.duokan.reader.ui.account;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.store.DkShareBook;
import com.duokan.reader.ui.general.be;

import java.util.List;

class bx extends r {
    b a = new b();
    final /* synthetic */ List b;
    final /* synthetic */ bv c;

    bx(bv bvVar, List list) {
        this.c = bvVar;
        this.b = list;
    }

    protected void onSessionTry() {
        v vVar = new v(this, i.f().b(PersonalAccount.class));
        int i = 0;
        while (i < this.c.i.length) {
            this.a = vVar.e(this.c.i[i].trim());
            if (this.a.b == 0) {
                DkShareBook dkShareBook = (DkShareBook) this.a.a;
                dkShareBook.mTraceId = this.c.j.length > i ? this.c.j[i] : "";
                this.b.add(dkShareBook);
            }
            i++;
        }
    }

    protected void onSessionSucceeded() {
        if (!this.c.g) {
            if (this.b.size() == this.c.i.length) {
                this.c.a(this.b);
                if (this.c.b.equals("system")) {
                    this.c.e();
                    this.c.c(this.b);
                    return;
                } else if (this.c.b.equals("sina")) {
                    bn biVar = new bi(this.c.getActivity(), this.c.c, this.b, this.c.h);
                    biVar.setOnShowListener(new by(this));
                    biVar.show();
                    return;
                } else {
                    this.c.c();
                    return;
                }
            }
            this.c.e();
            CharSequence string = this.c.getString(j.get_book_detail_fail);
            if (this.c.h != null) {
                this.c.h.b(string);
                this.c.h = null;
                return;
            }
            be.a(this.c.getContext(), string, 0).show();
        }
    }

    protected void onSessionFailed() {
        if (!this.c.g) {
            this.c.e();
            CharSequence string = this.c.getString(j.get_book_detail_fail);
            if (this.c.h != null) {
                this.c.h.b(string);
                this.c.h = null;
                return;
            }
            be.a(this.c.getContext(), string, 0).show();
        }
    }

    protected void onSessionClosed() {
        this.c.g = false;
    }
}
