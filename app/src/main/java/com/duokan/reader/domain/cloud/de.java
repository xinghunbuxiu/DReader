package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.WebSessionFailException;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class de extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3862a;
    /* renamed from: b */
    final /* synthetic */ dd f3863b;
    /* renamed from: c */
    private dr f3864c = null;
    /* renamed from: d */
    private C0621a<DkCloudPurchasedFictionInfo[]> f3865d = null;
    /* renamed from: e */
    private C0621a<List<DkCloudPurchasedFictionInfo>> f3866e = null;
    /* renamed from: f */
    private dr f3867f = null;
    /* renamed from: g */
    private List<DkCloudStoreBook> f3868g = new ArrayList();
    /* renamed from: h */
    private boolean f3869h = false;

    de(dd ddVar, String str, C0657i c0657i, al alVar) {
        this.f3863b = ddVar;
        this.f3862a = alVar;
        super(str, c0657i);
    }

    protected void onSessionOpen() {
        super.onSessionOpen();
        if (this.f3862a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3864c = this.f3863b.f3861a.f3860d.f3616h;
        }
    }

    /* renamed from: a */
    public void mo825a() {
        if (this.f3864c == null) {
            throw new WebSessionFailException();
        }
        long max;
        dt dtVar = new dt(this.f3862a);
        dtVar.m5468a();
        DkUserPurchasedFictionsInfo b = dtVar.m5450b();
        C0652z c0652z = new C0652z((WebSession) this, this.f3862a);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f3863b.f3861a.f3857a) {
            max = Math.max(b.mLatestFullRefreshTime / 1000, b.mLatestPurchaseTime);
        } else {
            max = 0;
        }
        this.f3866e = c0652z.m3071d(max);
        this.f3865d = c0652z.m3054a(max);
        if (this.f3866e.b == 0 && this.f3865d.b == 0) {
            Iterator it;
            DkCloudPurchasedFiction b2;
            List linkedList = new LinkedList();
            for (DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo : (DkCloudPurchasedFictionInfo[]) this.f3865d.f2058a) {
                if (dkCloudPurchasedFictionInfo.mIsHide) {
                    ((List) this.f3866e.f2058a).add(dkCloudPurchasedFictionInfo);
                } else {
                    DkCloudItem dkCloudPurchasedFiction = new DkCloudPurchasedFiction(dkCloudPurchasedFictionInfo, false);
                    DkCloudPurchasedFiction b3 = max > 0 ? this.f3864c.m5462b(dkCloudPurchasedFiction.getBookUuid()) : null;
                    if (b3 != null) {
                        linkedList.add((DkCloudPurchasedFiction) b3.merge(dkCloudPurchasedFiction));
                    } else {
                        linkedList.add(dkCloudPurchasedFiction);
                    }
                    this.f3869h = true;
                }
            }
            List linkedList2 = new LinkedList();
            for (DkCloudPurchasedFictionInfo dkCloudPurchasedFiction2 : (List) this.f3866e.f2058a) {
                DkCloudItem dkCloudPurchasedFiction3 = new DkCloudPurchasedFiction(dkCloudPurchasedFiction2, true);
                b2 = max > 0 ? this.f3864c.m5462b(dkCloudPurchasedFiction3.getBookUuid()) : null;
                if (b2 != null) {
                    linkedList2.add((DkCloudPurchasedFiction) b2.merge(dkCloudPurchasedFiction3));
                } else {
                    linkedList2.add(dkCloudPurchasedFiction3);
                }
                this.f3869h = true;
            }
            if (!linkedList.isEmpty()) {
                if (this.f3864c.m5466d()) {
                    this.f3868g.addAll(linkedList);
                } else {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        b2 = (DkCloudPurchasedFiction) it.next();
                        if (!b2.isHidden() && this.f3864c.m5458a(b2.getBookUuid()) == null) {
                            this.f3868g.add(b2);
                        }
                    }
                }
            }
            if (max > 0) {
                this.f3867f = new dr(this.f3864c);
            } else {
                this.f3867f = new dr();
                this.f3867f.f3889b = true;
                this.f3867f.f3888a = true;
            }
            this.f3867f.m5461a(linkedList2);
            this.f3867f.m5461a(linkedList);
            if (max > 0) {
                dtVar.updateItems((Collection) linkedList2);
                dtVar.updateItems((Collection) linkedList);
            } else {
                dtVar.replaceWithItems((Collection) linkedList2);
                dtVar.replaceWithItems((Collection) linkedList);
            }
            if (max <= 0) {
                b.mLatestFullRefreshTime = currentTimeMillis;
            }
            if (!this.f3867f.m5466d()) {
                b.mLatestPurchaseTime = ((DkCloudPurchasedFiction) this.f3867f.m5464c().get(0)).getUpdateTimeInSeconds() + 1;
            }
            dtVar.updateInfo(b);
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3862a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3863b.f3861a.f3858b.mo729a(-1, "");
        } else if (this.f3866e.b != 0) {
            this.f3863b.f3861a.f3858b.mo729a(this.f3866e.b, this.f3866e.c);
        } else if (this.f3865d.b != 0) {
            this.f3863b.f3861a.f3858b.mo729a(this.f3865d.b, this.f3865d.c);
        } else if (this.f3869h) {
            this.f3863b.f3861a.f3860d.f3616h = this.f3867f;
            this.f3863b.f3861a.f3860d.m5091f();
            if (!this.f3868g.isEmpty()) {
                this.f3863b.f3861a.f3860d.m5080a(this.f3868g);
            }
            this.f3863b.f3861a.f3858b.mo730a(null);
        } else {
            this.f3863b.f3861a.f3858b.mo730a(null);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3862a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3863b.f3861a.f3858b.mo729a(-1, str);
        } else {
            this.f3863b.f3861a.f3858b.mo729a(-1, "");
        }
    }

    /* renamed from: a */
    public void mo1024a(Exception exception) {
        WebLog.init().printStackTrace(LogLevel.ERROR, "pm", "unexpected error while updating purchased fictions.", (Throwable) exception);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return (this.f3865d.b == 1001 || this.f3865d.b == ICallback.LOGIN_OAUTH_AIDL || this.f3865d.b == ICallback.CLEAR_ACCOUNT_AIDL) && this.f3863b.f3861a.f3859c;
    }
}
