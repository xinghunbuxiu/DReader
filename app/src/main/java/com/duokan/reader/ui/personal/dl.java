package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.account.q;

class dl implements OnClickListener {
    final /* synthetic */ MiAccountProfileSettingsController a;

    dl(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.a = miAccountProfileSettingsController;
    }

    public void onClick(View view) {
        this.a.b.pushHalfPageSmoothly(new q(this.a.getContext()), null);
    }
}
