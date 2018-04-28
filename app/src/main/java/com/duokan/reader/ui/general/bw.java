package com.duokan.reader.ui.general;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class bw implements OnHierarchyChangeListener {
    /* renamed from: a */
    final /* synthetic */ DotScrollerView f7011a;

    bw(DotScrollerView dotScrollerView) {
        this.f7011a = dotScrollerView;
    }

    public void onChildViewRemoved(View view, View view2) {
        this.f7011a.f6820d = true;
    }

    public void onChildViewAdded(View view, View view2) {
        this.f7011a.f6820d = true;
    }
}
