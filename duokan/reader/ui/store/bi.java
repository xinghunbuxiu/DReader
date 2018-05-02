package com.duokan.reader.ui.store;

import android.app.Activity;
import android.content.Context;

import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.domain.payment.PaymentManager;
import com.duokan.reader.domain.store.n;
import com.duokan.reader.ui.general.bc;

import java.util.List;

public class bi {
    private DkStoreBookPrice[] a;
    private boolean b;
    private boolean c;
    private String[] d;
    private int e = 0;
    private final bc f = new bc();

    public bi(Context context, List list, DkStoreBookPrice... dkStoreBookPriceArr) {
        int i = 0;
        this.a = dkStoreBookPriceArr;
        this.b = false;
        this.c = false;
        this.d = null;
        int length = dkStoreBookPriceArr.length;
        while (i < length) {
            DkStoreBookPrice dkStoreBookPrice = dkStoreBookPriceArr[i];
            this.e = dkStoreBookPrice.mNewPrice + this.e;
            i++;
        }
        this.e = (int) (((float) this.e) - n.a(context, list, this.e));
    }

    public void a(Activity activity, bj bjVar) {
        bjVar.a(PaymentManager.a().b());
    }
}
