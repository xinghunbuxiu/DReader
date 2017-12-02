package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.a;

class dp implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ MiAccountProfileSettingsController b;

    dp(MiAccountProfileSettingsController miAccountProfileSettingsController, a aVar) {
        this.b = miAccountProfileSettingsController;
        this.a = aVar;
    }

    public void onClick(View view) {
        this.a.a(new dq(this));
    }
}
