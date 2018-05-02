package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.widget.FrameLayout;

/* renamed from: com.duokan.reader.ui.general.web.r */
class C1372r extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ SearchController f8172a;

    C1372r(SearchController searchController, Context context) {
        this.f8172a = searchController;
        super(context);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8172a.mLocalHintSize = this.f8172a.getLocalHintSize();
        this.f8172a.refreshView();
    }
}
