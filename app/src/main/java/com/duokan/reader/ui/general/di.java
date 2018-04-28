package com.duokan.reader.ui.general;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.DkApp;

class di implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ HeaderView f7097a;

    di(HeaderView headerView) {
        this.f7097a = headerView;
    }

    public void onClick(View view) {
        if (this.f7097a.f6874j == null || !this.f7097a.f6874j.onBack()) {
            Activity topActivity = DkApp.get().getTopActivity();
            if (topActivity != null && !topActivity.isFinishing()) {
                topActivity.onBackPressed();
            }
        }
    }
}
