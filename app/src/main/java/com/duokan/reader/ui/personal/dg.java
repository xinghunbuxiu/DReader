package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.ActivatedController;

class dg implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ MiAccountProfileSettingsController f8449a;

    dg(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.f8449a = miAccountProfileSettingsController;
    }

    public void onClick(View view) {
        ActivatedController changePasswordController = new ChangePasswordController(this.f8449a.getContext());
        changePasswordController.loadUrl("https://account.xiaomi.com/");
        this.f8449a.b.pushHalfPageSmoothly(changePasswordController, null);
    }
}
