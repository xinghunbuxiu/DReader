package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.account.m;

class dk implements OnClickListener {
    final /* synthetic */ MiAccountProfileSettingsController a;

    dk(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.a = miAccountProfileSettingsController;
    }

    public void onClick(View view) {
        this.a.b.pushHalfPageSmoothly(new m(this.a.getContext()), null);
    }
}
