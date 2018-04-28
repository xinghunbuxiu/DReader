package com.duokan.reader.ui.store;

import android.app.Activity;
import android.content.Context;
import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.domain.payment.C1085q;
import com.duokan.reader.domain.payment.PaymentManager;
import com.duokan.reader.domain.store.C1188n;
import com.duokan.reader.ui.general.bc;
import java.util.List;

public class bi {
    /* renamed from: a */
    private DkStoreBookPrice[] f11368a;
    /* renamed from: b */
    private boolean f11369b;
    /* renamed from: c */
    private boolean f11370c;
    /* renamed from: d */
    private String[] f11371d;
    /* renamed from: e */
    private int f11372e = 0;
    /* renamed from: f */
    private final bc<C1085q> f11373f = new bc();

    public bi(Context context, List<C1188n> list, DkStoreBookPrice... dkStoreBookPriceArr) {
        int i = 0;
        this.f11368a = dkStoreBookPriceArr;
        this.f11369b = false;
        this.f11370c = false;
        this.f11371d = null;
        int length = dkStoreBookPriceArr.length;
        while (i < length) {
            DkStoreBookPrice dkStoreBookPrice = dkStoreBookPriceArr[i];
            this.f11372e = dkStoreBookPrice.mNewPrice + this.f11372e;
            i++;
        }
        this.f11372e = (int) (((float) this.f11372e) - C1188n.m8724a(context, list, this.f11372e));
    }

    /* renamed from: a */
    public void m15323a(Activity activity, bj bjVar) {
        bjVar.mo1162a(PaymentManager.m8331a().m8353b());
    }
}
