package com.duokan.reader.domain.cloud;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.payment.s;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.l;
import com.duokan.reader.domain.store.m;
import com.duokan.reader.ui.general.jq;

public class fp implements ah {
    static final /* synthetic */ boolean a = (!fp.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final Context c;
    private final i d;
    private l e = null;

    private fp(Context context, i iVar) {
        this.c = context;
        this.d = iVar;
    }

    public static void a(Context context, i iVar) {
        b.a(new fp(context, iVar));
    }

    public static fp a() {
        return (fp) b.a();
    }

    public void a(l lVar) {
        this.e = lVar;
    }

    public void a(boolean z, int i, int i2, gc gcVar) {
        a c = this.d.c();
        if (z || c == null || !c.i()) {
            a(i, i2, z, gcVar);
        } else {
            gcVar.a("");
        }
    }

    public void a(DkStoreBookDetail dkStoreBookDetail, gd gdVar) {
        jq jqVar = new jq(DkApp.get().getTopActivity());
        jqVar.a(this.c.getString(com.duokan.b.i.bookcity_store__shared__creating_order));
        jqVar.a(true);
        jqVar.setCancelOnBack(false);
        jqVar.setCancelOnTouchOutside(false);
        gd fqVar = new fq(this, jqVar, gdVar);
        if (i.f().b()) {
            a(dkStoreBookDetail, fqVar, jqVar);
        } else {
            i.f().a(new fr(this, dkStoreBookDetail, fqVar, jqVar));
        }
    }

    public void a(DkCloudRedeemFund dkCloudRedeemFund, String str, ge geVar) {
        this.d.a(new fs(this, dkCloudRedeemFund, str, geVar));
    }

    private void a(DkStoreBookDetail dkStoreBookDetail, gd gdVar, jq jqVar) {
        this.d.a(new fv(this, jqVar, dkStoreBookDetail, gdVar));
    }

    protected void a(m mVar, String str, DkStoreCallback dkStoreCallback) {
        if (!a && this.e == null) {
            throw new AssertionError();
        } else if (this.e != null) {
            this.e.a(mVar, str, dkStoreCallback);
        } else {
            dkStoreCallback.a((s) mVar, "");
        }
    }

    private void a(int i, int i2, boolean z, gc gcVar) {
        this.d.a(new ga(this, i, i2, gcVar));
    }
}
