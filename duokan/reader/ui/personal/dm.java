package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.ActivatedController;

class dm implements OnClickListener {
    final /* synthetic */ MiAccountProfileSettingsController a;

    dm(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.a = miAccountProfileSettingsController;
    }

    public void onClick(View view) {
        ActivatedController changePasswordController = new ChangePasswordController(this.a.getContext());
        changePasswordController.loadUrl("https://account.xiaomi.com/");
        this.a.b.pushHalfPageSmoothly(changePasswordController, null);
    }
}
