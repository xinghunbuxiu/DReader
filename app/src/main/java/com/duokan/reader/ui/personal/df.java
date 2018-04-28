package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ui.account.C1253e;

class df implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ MiAccountProfileSettingsController f8448a;

    df(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.f8448a = miAccountProfileSettingsController;
    }

    public void onClick(View view) {
        this.f8448a.b.pushHalfPageSmoothly(new C1253e(this.f8448a.getContext()), null);
    }
}
