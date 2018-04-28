package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ui.account.C1249a;

class de implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ MiAccountProfileSettingsController f8447a;

    de(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.f8447a = miAccountProfileSettingsController;
    }

    public void onClick(View view) {
        this.f8447a.b.pushHalfPageSmoothly(new C1249a(this.f8447a.getContext()), null);
    }
}
