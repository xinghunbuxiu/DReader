package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.account.C0672a;

class dj implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0672a f8452a;
    /* renamed from: b */
    final /* synthetic */ MiAccountProfileSettingsController f8453b;

    dj(MiAccountProfileSettingsController miAccountProfileSettingsController, C0672a c0672a) {
        this.f8453b = miAccountProfileSettingsController;
        this.f8452a = c0672a;
    }

    public void onClick(View view) {
        this.f8452a.mo830a(new dk(this));
    }
}
