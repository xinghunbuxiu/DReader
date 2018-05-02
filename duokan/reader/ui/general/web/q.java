package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.widget.FrameLayout;

class q extends FrameLayout {
    final /* synthetic */ SearchController a;

    q(SearchController searchController, Context context) {
        this.a = searchController;
        super(context);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.mLocalHintSize = this.a.getLocalHintSize();
        this.a.refreshView();
    }
}
