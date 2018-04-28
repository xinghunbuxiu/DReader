package com.duokan.core.ui;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class dj implements OnHierarchyChangeListener {
    /* renamed from: a */
    final /* synthetic */ di f1148a;

    dj(di diVar) {
        this.f1148a = diVar;
    }

    public void onChildViewRemoved(View view, View view2) {
        if (this.f1148a.f1145c != null) {
            this.f1148a.f1145c.onChildViewRemoved(view, view2);
        }
        if (view == this.f1148a) {
            this.f1148a.f1144b.remove(view2);
        }
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.f1148a.f1145c != null) {
            this.f1148a.f1145c.onChildViewAdded(view, view2);
        }
        if (view == this.f1148a) {
            this.f1148a.f1144b.put(view2, new ds());
        }
    }
}
