package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.WebSessionFailException;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedBookInfo;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class cc extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3805a;
    /* renamed from: b */
    final /* synthetic */ cb f3806b;
    /* renamed from: c */
    private ch f3807c = null;
    /* renamed from: d */
    private C0621a<DkCloudPurchasedBookInfo[]> f3808d = null;
    /* renamed from: e */
    private ch f3809e = null;
    /* renamed from: f */
    private List<DkCloudStoreBook> f3810f = new ArrayList();

    cc(cb cbVar, String str, C0657i c0657i, al alVar) {
        this.f3806b = cbVar;
        this.f3805a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        if (this.f3807c == null) {
            throw new WebSessionFailException();
        }
        long max;
        cj cjVar = new cj(this.f3805a);
        cjVar.m5406a();
        DkUserPurchasedBooksInfo b = cjVar.m5405b();
        C0652z c0652z = new C0652z((WebSession) this, this.f3805a);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f3806b.f3804a.f3800a) {
            max = Math.max(b.mLatestFullRefreshTime / 1000, b.mLatestPurchaseTime);
        } else {
            max = 0;
        }
        List linkedList = new LinkedList();
        long j = max;
        while (true) {
            this.f3808d = c0652z.m3063b(j);
            if (this.f3808d.b == 0) {
                for (int length = ((DkCloudPurchasedBookInfo[]) this.f3808d.f2058a).length - 1; length >= 0; length--) {
                    linkedList.addFirst(new DkCloudPurchasedBook(((DkCloudPurchasedBookInfo[]) this.f3808d.f2058a)[length]));
                }
                boolean booleanValue = Boolean.valueOf(this.f3808d.c).booleanValue();
                if (!linkedList.isEmpty() && booleanValue) {
                    j = ((DkCloudPurchasedBook) linkedList.get(0)).getUpdateTimeInSeconds() + 1;
                }
            } else {
                return;
            }
        }
        if (this.f3807c.m5403d() || max <= 0) {
            this.f3809e = new ch();
            this.f3809e.f3813b = true;
            this.f3809e.f3812a = true;
        } else {
            this.f3809e = new ch(this.f3807c);
        }
        if (!linkedList.isEmpty()) {
            if (this.f3807c.m5403d()) {
                this.f3810f.addAll(linkedList);
            } else {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) it.next();
                    if (!dkCloudPurchasedBook.isHidden() && this.f3807c.m5395a(dkCloudPurchasedBook.getBookUuid()) == null) {
                        this.f3810f.add(dkCloudPurchasedBook);
                    }
                }
            }
        }
        this.f3809e.m5398a(linkedList);
        if (max > 0) {
            cjVar.updateItems((Collection) linkedList);
        } else {
            cjVar.replaceWithItems((Collection) linkedList);
        }
        if (max <= 0) {
            b.mLatestFullRefreshTime = currentTimeMillis;
        }
        if (!this.f3809e.m5403d()) {
            b.mLatestPurchaseTime = ((DkCloudPurchasedBook) this.f3809e.m5401c().get(0)).getUpdateTimeInSeconds() + 1;
        }
        cjVar.updateInfo(b);
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3805a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            this.f3806b.f3804a.f3801b.mo729a(-1, "");
        } else if (this.f3808d.b != 0) {
            this.f3806b.f3804a.f3801b.mo729a(this.f3808d.b, this.f3808d.c);
        } else {
            this.f3806b.f3804a.f3803d.f3608h = this.f3809e;
            this.f3806b.f3804a.f3803d.m5048f();
            if (!this.f3810f.isEmpty()) {
                this.f3806b.f3804a.f3803d.m5037a(this.f3810f);
            }
            this.f3806b.f3804a.f3801b.mo730a(null);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3806b.f3804a.f3801b.mo729a(-1, str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return (this.f3808d.b == 1001 || this.f3808d.b == ICallback.LOGIN_OAUTH_AIDL || this.f3808d.b == ICallback.CLEAR_ACCOUNT_AIDL) && this.f3806b.f3804a.f3802c;
    }

    /* renamed from: a */
    public void mo1024a(Exception exception) {
        C0328a.m757c().m748a(LogLevel.ERROR, "pm", "unexpected error while updating purchased books.", (Throwable) exception);
    }

    protected void onSessionOpen() {
        super.onSessionOpen();
        if (this.f3805a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            this.f3807c = this.f3806b.f3804a.f3803d.f3608h;
        }
    }
}
