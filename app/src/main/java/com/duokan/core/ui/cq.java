package com.duokan.core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

class cq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TabBarView f1090a;

    cq(TabBarView tabBarView) {
        this.f1090a = tabBarView;
    }

    public void onClick(View view) {
        this.f1090a.m1308a(this.f1090a.m1304a((FrameLayout) view), true);
    }
}
