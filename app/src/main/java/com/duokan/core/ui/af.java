package com.duokan.core.ui;

import android.view.View;
import android.view.View.OnClickListener;

import org.apache.http.HttpStatus;

class af implements OnClickListener {
    final /* synthetic */ HatGridView a;

    af(HatGridView hatGridView) {
        this.a = hatGridView;
    }

    public void onClick(View view) {
        this.a.x();
        this.a.a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
    }
}
