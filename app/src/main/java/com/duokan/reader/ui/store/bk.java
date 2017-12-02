package com.duokan.reader.ui.store;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bk implements OnCheckedChangeListener {
    final /* synthetic */ PaymentMethodItemView a;

    bk(PaymentMethodItemView paymentMethodItemView) {
        this.a = paymentMethodItemView;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.a.e != null) {
            this.a.e.a(this.a, z);
        }
    }
}
