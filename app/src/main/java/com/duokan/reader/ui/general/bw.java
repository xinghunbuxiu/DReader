package com.duokan.reader.ui.general;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class bw implements OnHierarchyChangeListener {
    final /* synthetic */ DotScrollerView a;

    bw(DotScrollerView dotScrollerView) {
        this.a = dotScrollerView;
    }

    public void onChildViewRemoved(View view, View view2) {
        this.a.d = true;
    }

    public void onChildViewAdded(View view, View view2) {
        this.a.d = true;
    }
}
