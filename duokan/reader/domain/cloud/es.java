package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBookInfo;

class es extends r {
    final /* synthetic */ ab a;
    final /* synthetic */ er b;
    private b c = null;
    private ReadBook[] d = new ReadBook[0];

    es(er erVar, ab abVar) {
        this.b = erVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        int i = 0;
        this.c = new o(this, this.a).a(this.b.a, this.b.b);
        if (this.c.b == 0) {
            ReadBook[] readBookArr = new ReadBook[((ReadBookInfo[]) this.c.a).length];
            for (int i2 = 0; i2 < readBookArr.length; i2++) {
                readBookArr[i2] = new ReadBook(((ReadBookInfo[]) this.c.a)[i2]);
            }
            this.d = new ReadBook[readBookArr.length];
            while (i < readBookArr.length) {
                this.d[i] = readBookArr[i];
                i++;
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(this.b.e.f)) {
            this.b.c.a("");
        } else if (this.c.b == 1001 || this.c.b == 1002 || this.c.b == 1003) {
            if (this.b.d) {
                i.f().a(this.a.a, new et(this));
            } else {
                this.b.c.a("");
            }
        } else if (this.c.b != 0) {
            this.b.c.a("");
        } else {
            if (this.b.a == 0) {
                this.b.e.a(this.d);
            } else {
                this.b.e.b(this.d);
            }
            this.b.c.a(this.d, Boolean.parseBoolean(this.c.c), false);
        }
    }

    protected void onSessionFailed() {
        if (this.a.a(this.b.e.f)) {
            this.b.c.a("");
        } else {
            this.b.c.a("");
        }
    }
}
