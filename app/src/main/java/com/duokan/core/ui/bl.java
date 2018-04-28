package com.duokan.core.ui;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class bl implements OnHierarchyChangeListener {
    /* renamed from: a */
    final /* synthetic */ bk f1024a;

    bl(bk bkVar) {
        this.f1024a = bkVar;
    }

    public void onChildViewRemoved(View view, View view2) {
        if (view == this.f1024a && this.f1024a.f1018d == view2) {
            this.f1024a.m1686a(null, false);
        }
        if (this.f1024a.f1016b != null) {
            this.f1024a.f1016b.onChildViewRemoved(view, view2);
        }
    }

    public void onChildViewAdded(View view, View view2) {
        if (view == this.f1024a) {
            view2.setOnClickListener(new bm(this));
        }
        if (this.f1024a.f1016b != null) {
            this.f1024a.f1016b.onChildViewAdded(view, view2);
        }
    }
}
