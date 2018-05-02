package com.duokan.core.ui;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class bl implements OnHierarchyChangeListener {
    final /* synthetic */ bk a;

    bl(bk bkVar) {
        this.a = bkVar;
    }

    public void onChildViewRemoved(View view, View view2) {
        if (view == this.a && this.a.d == view2) {
            this.a.a(null, false);
        }
        if (this.a.b != null) {
            this.a.b.onChildViewRemoved(view, view2);
        }
    }

    public void onChildViewAdded(View view, View view2) {
        if (view == this.a) {
            view2.setOnClickListener(new bm(this));
        }
        if (this.a.b != null) {
            this.a.b.onChildViewAdded(view, view2);
        }
    }
}
