package com.duokan.core.ui;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class dj implements OnHierarchyChangeListener {
    final /* synthetic */ di a;

    dj(di diVar) {
        this.a = diVar;
    }

    public void onChildViewRemoved(View view, View view2) {
        if (this.a.c != null) {
            this.a.c.onChildViewRemoved(view, view2);
        }
        if (view == this.a) {
            this.a.b.remove(view2);
        }
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.a.c != null) {
            this.a.c.onChildViewAdded(view, view2);
        }
        if (view == this.a) {
            this.a.b.put(view2, new ds());
        }
    }
}
