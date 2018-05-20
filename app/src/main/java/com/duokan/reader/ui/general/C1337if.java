package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;

/* renamed from: com.duokan.reader.ui.general.if */
class C1337if implements OnScrollListener {
    /* renamed from: a */
    final /* synthetic */ ie f7376a;

    C1337if(ie ieVar) {
        this.f7376a = ieVar;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (this.f7376a.f7374b != null) {
            this.f7376a.f7374b.mo478a(scrollable, scrollState, scrollState2);
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        int i = 0;
        if (z && this.f7376a.f7373a != null) {
            Integer[] visiableViewIndex = this.f7376a.getVisiableViewIndex();
            if (visiableViewIndex.length > 0) {
                i = visiableViewIndex[0].intValue();
                int left = (this.f7376a.getChildAt(i).getLeft() + this.f7376a.getChildAt(i).getRight()) / 2;
                int intValue = visiableViewIndex[visiableViewIndex.length - 1].intValue();
                if (Math.abs(left - this.f7376a.getViewportBounds().centerX()) >= Math.abs(((this.f7376a.getChildAt(intValue).getLeft() + this.f7376a.getChildAt(intValue).getRight()) / 2) - this.f7376a.getViewportBounds().centerX())) {
                    i = intValue;
                }
            }
            this.f7376a.f7373a.mo1794a((((float) this.f7376a.getViewportBounds().centerX()) * 1.0f) / ((float) this.f7376a.getContentWidth()), i);
        }
        if (this.f7376a.f7374b != null) {
            this.f7376a.f7374b.mo479a(scrollable, z);
        }
    }
}
