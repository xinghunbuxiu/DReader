package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class dr extends ef {
    final /* synthetic */ ab a;
    final /* synthetic */ dq b;
    private eg d = null;
    private b e = null;
    private b f = null;
    private eg g = null;
    private List h = new ArrayList();
    private boolean i = false;

    dr(dq dqVar, ab abVar) {
        this.b = dqVar;
        this.a = abVar;
        super(dqVar.a.d);
    }

    protected void onSessionOpen() {
        if (this.a.a(DkUserPurchasedFictionsManager.g())) {
            this.d = this.b.a.d.h;
        }
    }

    protected void onSessionTry() {
        long max;
        if (this.d == null) {
            fail();
        }
        ei eiVar = new ei(this.a);
        eiVar.a();
        DkUserPurchasedFictionsInfo b = eiVar.b();
        aa aaVar = new aa((WebSession) this, this.a);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.b.a.a) {
            max = Math.max(b.mLatestFullRefreshTime / 1000, b.mLatestPurchaseTime);
        } else {
            max = 0;
        }
        this.f = aaVar.d(max);
        this.e = aaVar.a(max);
        if (this.f.b == 0 && this.e.b == 0) {
            Iterator it;
            DkCloudPurchasedFiction b2;
            List linkedList = new LinkedList();
            for (DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo : (DkCloudPurchasedFictionInfo[]) this.e.a) {
                if (dkCloudPurchasedFictionInfo.mIsHide) {
                    ((List) this.f.a).add(dkCloudPurchasedFictionInfo);
                } else {
                    DkCloudItem dkCloudPurchasedFiction = new DkCloudPurchasedFiction(dkCloudPurchasedFictionInfo, false);
                    DkCloudPurchasedFiction b3 = max > 0 ? this.d.b(dkCloudPurchasedFiction.getBookUuid()) : null;
                    if (b3 != null) {
                        linkedList.add((DkCloudPurchasedFiction) b3.merge(dkCloudPurchasedFiction));
                    } else {
                        linkedList.add(dkCloudPurchasedFiction);
                    }
                    this.i = true;
                }
            }
            List linkedList2 = new LinkedList();
            for (DkCloudPurchasedFictionInfo dkCloudPurchasedFiction2 : (List) this.f.a) {
                DkCloudItem dkCloudPurchasedFiction3 = new DkCloudPurchasedFiction(dkCloudPurchasedFiction2, true);
                b2 = max > 0 ? this.d.b(dkCloudPurchasedFiction3.getBookUuid()) : null;
                if (b2 != null) {
                    linkedList2.add((DkCloudPurchasedFiction) b2.merge(dkCloudPurchasedFiction3));
                } else {
                    linkedList2.add(dkCloudPurchasedFiction3);
                }
                this.i = true;
            }
            if (!linkedList.isEmpty()) {
                if (this.d.d()) {
                    this.h.addAll(linkedList);
                } else {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        b2 = (DkCloudPurchasedFiction) it.next();
                        if (!b2.isHidden() && this.d.a(b2.getBookUuid()) == null) {
                            this.h.add(b2);
                        }
                    }
                }
            }
            if (max > 0) {
                this.g = new eg(this.d);
            } else {
                this.g = new eg();
                this.g.b = true;
                this.g.a = true;
            }
            this.g.a(linkedList2);
            this.g.a(linkedList);
            if (max > 0) {
                eiVar.updateItems((Collection) linkedList2);
                eiVar.updateItems((Collection) linkedList);
            } else {
                eiVar.replaceWithItems((Collection) linkedList2);
                eiVar.replaceWithItems((Collection) linkedList);
            }
            if (max <= 0) {
                b.mLatestFullRefreshTime = currentTimeMillis;
            }
            if (!this.g.d()) {
                b.mLatestPurchaseTime = ((DkCloudPurchasedFiction) this.g.c().get(0)).getUpdateTimeInSeconds() + 1;
            }
            eiVar.updateInfo(b);
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(DkUserPurchasedFictionsManager.g())) {
            this.b.a.b.a(-1, "");
        } else if (this.e.b == 1001 || this.e.b == 1002 || this.e.b == 1003) {
            if (this.b.a.c) {
                i.f().a(this.a.a, new ds(this));
            } else {
                this.b.a.b.a(this.e.b, this.e.c);
            }
        } else if (this.f.b != 0) {
            this.b.a.b.a(this.f.b, this.f.c);
        } else if (this.e.b != 0) {
            this.b.a.b.a(this.e.b, this.e.c);
        } else if (this.i) {
            this.b.a.d.h = this.g;
            this.b.a.d.f();
            if (!this.h.isEmpty()) {
                this.b.a.d.a(this.h);
            }
            this.b.a.b.a(null);
        } else {
            this.b.a.b.a(null);
        }
    }

    protected void onSessionFailed() {
        if (this.a.a(DkUserPurchasedFictionsManager.g())) {
            this.b.a.b.a(-1, "");
        } else {
            this.b.a.b.a(-1, "");
        }
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().a(LogLevel.ERROR, "pm", "unexpected error while updating purchased fictions.", (Throwable) exception);
        return super.onSessionException(exception, i);
    }
}
