package com.duokan.reader.ui.store;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bk implements OnCheckedChangeListener {
    /* renamed from: a */
    final /* synthetic */ PaymentMethodItemView f11374a;

    bk(PaymentMethodItemView paymentMethodItemView) {
        this.f11374a = paymentMethodItemView;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f11374a.f11296e != null) {
            this.f11374a.f11296e.mo1749a(this.f11374a, z);
        }
    }
}
