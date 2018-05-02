package com.duokan.core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

class cq implements OnClickListener {
    final /* synthetic */ TabBarView a;

    cq(TabBarView tabBarView) {
        this.a = tabBarView;
    }

    public void onClick(View view) {
        this.a.a(this.a.a((FrameLayout) view), true);
    }
}
