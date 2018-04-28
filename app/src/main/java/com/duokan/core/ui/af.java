package com.duokan.core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import org.apache.http.HttpStatus;

class af implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ HatGridView f897a;

    af(HatGridView hatGridView) {
        this.f897a = hatGridView;
    }

    public void onClick(View view) {
        this.f897a.m1237x();
        this.f897a.mo434a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
    }
}
