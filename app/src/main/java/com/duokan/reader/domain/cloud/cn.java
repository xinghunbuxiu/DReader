package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedBookInfo;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class cn extends cs {
    final /* synthetic */ ab a;
    final /* synthetic */ cm b;
    private ct d = null;
    private b e = null;
    private ct f = null;
    private List g = new ArrayList();

    cn(cm cmVar, ab abVar) {
        this.b = cmVar;
        this.a = abVar;
        super(cmVar.a.d);
    }

    protected void onSessionOpen() {
        if (this.a.a(DkUserPurchasedBooksManager.h())) {
            this.d = this.b.a.d.h;
        }
    }

    protected void onSessionTry() {
        long max;
        if (this.d == null) {
            fail();
        }
        cv cvVar = new cv(this.a);
        cvVar.a();
        DkUserPurchasedBooksInfo b = cvVar.b();
        aa aaVar = new aa((WebSession) this, this.a);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.b.a.a) {
            max = Math.max(b.mLatestFullRefreshTime / 1000, b.mLatestPurchaseTime);
        } else {
            max = 0;
        }
        List linkedList = new LinkedList();
        long j = max;
        while (true) {
            this.e = aaVar.b(j);
            if (this.e.b == 0) {
                for (int length = ((DkCloudPurchasedBookInfo[]) this.e.a).length - 1; length >= 0; length--) {
                    linkedList.addFirst(new DkCloudPurchasedBook(((DkCloudPurchasedBookInfo[]) this.e.a)[length]));
                }
                boolean booleanValue = Boolean.valueOf(this.e.c).booleanValue();
                if (!linkedList.isEmpty() && booleanValue) {
                    j = ((DkCloudPurchasedBook) linkedList.get(0)).getUpdateTimeInSeconds() + 1;
                }
            } else {
                return;
            }
        }
        if (this.d.d() || max <= 0) {
            this.f = new ct();
            this.f.b = true;
            this.f.a = true;
        } else {
            this.f = new ct(this.d);
        }
        if (!linkedList.isEmpty()) {
            if (this.d.d()) {
                this.g.addAll(linkedList);
            } else {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) it.next();
                    if (!dkCloudPurchasedBook.isHidden() && this.d.a(dkCloudPurchasedBook.getBookUuid()) == null) {
                        this.g.add(dkCloudPurchasedBook);
                    }
                }
            }
        }
        this.f.a(linkedList);
        if (max > 0) {
            cvVar.updateItems((Collection) linkedList);
        } else {
            cvVar.replaceWithItems((Collection) linkedList);
        }
        if (max <= 0) {
            b.mLatestFullRefreshTime = currentTimeMillis;
        }
        if (!this.f.d()) {
            b.mLatestPurchaseTime = ((DkCloudPurchasedBook) this.f.c().get(0)).getUpdateTimeInSeconds() + 1;
        }
        cvVar.updateInfo(b);
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(DkUserPurchasedBooksManager.h())) {
            this.b.a.b.a(-1, "");
        } else if (this.e.b == 1001 || this.e.b == 1002 || this.e.b == 1003) {
            if (this.b.a.c) {
                i.f().a(this.a.a, new co(this));
            } else {
                this.b.a.b.a(this.e.b, this.e.c);
            }
        } else if (this.e.b != 0) {
            this.b.a.b.a(this.e.b, this.e.c);
        } else {
            this.b.a.d.h = this.f;
            this.b.a.d.f();
            if (!this.g.isEmpty()) {
                this.b.a.d.a(this.g);
            }
            this.b.a.b.a(null);
        }
    }

    protected void onSessionFailed() {
        this.b.a.b.a(-1, "");
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().a(LogLevel.ERROR, "pm", "unexpected error while updating purchased books.", (Throwable) exception);
        return super.onSessionException(exception, i);
    }
}
