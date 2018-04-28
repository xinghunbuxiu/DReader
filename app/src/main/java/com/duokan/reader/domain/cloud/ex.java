package com.duokan.reader.domain.cloud;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.payment.C1089s;
import com.duokan.reader.domain.store.C1186l;
import com.duokan.reader.domain.store.C1187m;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.ui.general.ja;

public class ex implements ai {
    /* renamed from: a */
    static final /* synthetic */ boolean f3955a = (!ex.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<ex> f3956b = new aj();
    /* renamed from: c */
    private final Context f3957c;
    /* renamed from: d */
    private final C0709k f3958d;
    /* renamed from: e */
    private C1186l f3959e = null;

    private ex(Context context, C0709k c0709k) {
        this.f3957c = context;
        this.f3958d = c0709k;
    }

    /* renamed from: a */
    public static void m5518a(Context context, C0709k c0709k) {
        f3956b.m709a(new ex(context, c0709k));
    }

    /* renamed from: a */
    public static ex m5516a() {
        return (ex) f3956b.m707a();
    }

    /* renamed from: a */
    public void m5523a(C1186l c1186l) {
        this.f3959e = c1186l;
    }

    /* renamed from: a */
    public void m5525a(boolean z, int i, int i2, fi fiVar) {
        C0672a d = this.f3958d.m3508d();
        if (z || d == null || !d.mo839i()) {
            m5517a(i, i2, z, fiVar);
        } else {
            fiVar.mo1930a("");
        }
    }

    /* renamed from: a */
    public void m5522a(DkStoreBookDetail dkStoreBookDetail, fj fjVar) {
        ja jaVar = new ja(DkApp.get().getTopActivity());
        jaVar.m10843a(this.f3957c.getString(C0247i.bookcity_store__shared__creating_order));
        jaVar.m10844a(true);
        jaVar.setCancelOnBack(false);
        jaVar.setCancelOnTouchOutside(false);
        fj eyVar = new ey(this, jaVar, fjVar);
        if (C0709k.m3476a().m3507c()) {
            m5520a(dkStoreBookDetail, eyVar, jaVar);
        } else {
            C0709k.m3476a().m3495a(new ez(this, dkStoreBookDetail, eyVar, jaVar));
        }
    }

    /* renamed from: a */
    public void m5521a(DkCloudRedeemFund dkCloudRedeemFund, String str, fk fkVar) {
        this.f3958d.m3495a(new fa(this, dkCloudRedeemFund, str, fkVar));
    }

    /* renamed from: a */
    private void m5520a(DkStoreBookDetail dkStoreBookDetail, fj fjVar, ja jaVar) {
        this.f3958d.m3495a(new fc(this, jaVar, dkStoreBookDetail, fjVar));
    }

    /* renamed from: a */
    protected void m5524a(C1187m c1187m, String str, DkStoreCallback dkStoreCallback) {
        if (!f3955a && this.f3959e == null) {
            throw new AssertionError();
        } else if (this.f3959e != null) {
            this.f3959e.mo2540a(c1187m, str, dkStoreCallback);
        } else {
            dkStoreCallback.mo1164a((C1089s) c1187m, "");
        }
    }

    /* renamed from: a */
    private void m5517a(int i, int i2, boolean z, fi fiVar) {
        this.f3958d.m3495a(new fg(this, i, i2, fiVar));
    }
}
