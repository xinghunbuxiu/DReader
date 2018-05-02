package com.duokan.reader.ui.general;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.DkApp;

class di implements OnClickListener {
    final /* synthetic */ HeaderView a;

    di(HeaderView headerView) {
        this.a = headerView;
    }

    public void onClick(View view) {
        if (this.a.j == null || !this.a.j.onBack()) {
            Activity topActivity = DkApp.get().getTopActivity();
            if (topActivity != null && !topActivity.isFinishing()) {
                topActivity.onBackPressed();
            }
        }
    }
}
