package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class jt implements OnClickListener {
    final /* synthetic */ PurchasedBookItemView a;

    jt(PurchasedBookItemView purchasedBookItemView) {
        this.a = purchasedBookItemView;
    }

    public void onClick(View view) {
        PurchasedBookItemView.d(this.a, this.a.e);
    }
}
